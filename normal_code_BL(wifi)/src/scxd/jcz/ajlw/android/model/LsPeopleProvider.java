package scxd.jcz.ajlw.android.model;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 路试人员 本地数据库连接
 * @author wdn
 */
public class LsPeopleProvider {
	/**
	 * 路试人员 数据库名
	 */
	public static final String LSRY_DB = "lsrydb" ;
	/**
	 * 路试人员 数据库 表名
	 */
	public static final String TB_LSRY = "lsrytable" ;
	/**
	 * 路试人员 id
	 */
	public static final String LSRY_ID = "_id" ;
	/**
	 * 路试人员 名字
	 */
	public static final String LSRY_NAME = "_name" ;
	
	private static LsPeopleProvider lsPeopleProvider = null ;
	/**
	 * 本地数据库实例
	 */
	private static SQLiteDatabase db = null;
	private static SQLiteHelper sqLiteHelper ;
	
	/**
	 * 初始化 数据库连接
	 * @param context
	 */
	private LsPeopleProvider(Context context){
		sqLiteHelper = new SQLiteHelper(context, LSRY_DB) ;		
	}
	/**
	 * 单列模式 获取数据库连接
	 * @param context
	 * @return 数据库连接实例
	 */
	public static synchronized LsPeopleProvider getInstance(Context context){
		if(lsPeopleProvider == null){
			lsPeopleProvider = new LsPeopleProvider(context) ;
		}
		if(db == null || !db.isOpen()){
			db = sqLiteHelper.getWritableDatabase() ;
		}	
		return lsPeopleProvider ;
	}

	/**
	 * 删除 路试人员
	 * @param name 路试人员 姓名
	 * @return 删除是否成功
	 */
	public boolean delete(String name) {
		//删除 指定人员
		int row = db.delete(TB_LSRY,
				LSRY_NAME + "=?",
				new String[] { name }) ;
		
		return row != 0;
	}
	/**
	 * 新增路试人员
	 * @param name 路试人员姓名
	 * @return 插入是否成功
	 */
	public boolean insert(String name) {
		//新增 人员
		Cursor cursor = db.query(
				TB_LSRY, 
				new String[]{LSRY_ID}, 
				LSRY_NAME + "=?", 
				new String[]{ name },
				null, null, null) ;	
		
		long row = 0;
		if(!cursor.moveToNext()){
			ContentValues values = new ContentValues();
			values.put(LSRY_NAME, name) ;
			row = db.insert(TB_LSRY, null, values) ;
		}
		cursor.close() ;
		return row != 0;
	}
	/**
	 * 查询已有路试人员
	 * @return 路试人员姓名列表
	 */
	public ArrayList<String> query(){
		//获取 已有人员列表
		ArrayList<String> lsryList = new ArrayList<String>() ;
		Cursor cursor = db.query(TB_LSRY, new String[]{LSRY_NAME}, null, null, null, null, null) ;	
		
		while(cursor.moveToNext()){
			lsryList.add(cursor.getString(0)) ;
		}
		
		return lsryList ;
	}
	
}

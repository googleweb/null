package scxd.jcz.ajlw.android.model;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * ·����Ա �������ݿ�����
 * @author wdn
 */
public class LsPeopleProvider {
	/**
	 * ·����Ա ���ݿ���
	 */
	public static final String LSRY_DB = "lsrydb" ;
	/**
	 * ·����Ա ���ݿ� ����
	 */
	public static final String TB_LSRY = "lsrytable" ;
	/**
	 * ·����Ա id
	 */
	public static final String LSRY_ID = "_id" ;
	/**
	 * ·����Ա ����
	 */
	public static final String LSRY_NAME = "_name" ;
	
	private static LsPeopleProvider lsPeopleProvider = null ;
	/**
	 * �������ݿ�ʵ��
	 */
	private static SQLiteDatabase db = null;
	private static SQLiteHelper sqLiteHelper ;
	
	/**
	 * ��ʼ�� ���ݿ�����
	 * @param context
	 */
	private LsPeopleProvider(Context context){
		sqLiteHelper = new SQLiteHelper(context, LSRY_DB) ;		
	}
	/**
	 * ����ģʽ ��ȡ���ݿ�����
	 * @param context
	 * @return ���ݿ�����ʵ��
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
	 * ɾ�� ·����Ա
	 * @param name ·����Ա ����
	 * @return ɾ���Ƿ�ɹ�
	 */
	public boolean delete(String name) {
		//ɾ�� ָ����Ա
		int row = db.delete(TB_LSRY,
				LSRY_NAME + "=?",
				new String[] { name }) ;
		
		return row != 0;
	}
	/**
	 * ����·����Ա
	 * @param name ·����Ա����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean insert(String name) {
		//���� ��Ա
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
	 * ��ѯ����·����Ա
	 * @return ·����Ա�����б�
	 */
	public ArrayList<String> query(){
		//��ȡ ������Ա�б�
		ArrayList<String> lsryList = new ArrayList<String>() ;
		Cursor cursor = db.query(TB_LSRY, new String[]{LSRY_NAME}, null, null, null, null, null) ;	
		
		while(cursor.moveToNext()){
			lsryList.add(cursor.getString(0)) ;
		}
		
		return lsryList ;
	}
	
}

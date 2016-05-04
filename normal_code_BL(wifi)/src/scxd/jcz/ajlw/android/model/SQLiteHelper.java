package scxd.jcz.ajlw.android.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static scxd.jcz.ajlw.android.model.LsPeopleProvider.*;

/**
<<<<<<< .mine
 * SQLiteHelper SQLit数据内
 * @author 陈渝金
 * create time：
 * Description： 处理sqlit数据库，这里创建了表 
=======
 * SQLiteHelper 创建本地数据库
 * @author wdn
 *
>>>>>>> .r539
 */
public class SQLiteHelper extends SQLiteOpenHelper {
	private static final int VERSION = 5;
	
	private static final String CREATE_LSRYDB_SQL = 
			"CREATE TABLE " + TB_LSRY + " (" 
		    + LSRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "//id
		    + LSRY_NAME + " VCHAR(20))" ;
		
	public SQLiteHelper(Context context, String dbname) {
		super(context, dbname ,null ,VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		 db.execSQL(CREATE_LSRYDB_SQL);		 
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
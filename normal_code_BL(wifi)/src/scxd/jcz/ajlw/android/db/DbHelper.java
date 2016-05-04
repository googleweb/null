package scxd.jcz.ajlw.android.db;

import java.sql.SQLException;

import scxd.jcz.ajlw.android.model.Md_cartype;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DbHelper extends OrmLiteSqliteOpenHelper {
	private static final String DB_NAME = "star_database.db";
	private static final int DB_VERSION = 1;
	@SuppressWarnings("unused")
	private static final String TAG = "DbHelper";

	public DbHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database,
			ConnectionSource connectionSource) {
		try {
			//建表
			
			
			TableUtils.createTable(connectionSource, Md_cartype.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}

	@Override
	public void onUpgrade(SQLiteDatabase database,
			ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			//更新表
		
			
			TableUtils.createTable(connectionSource, Md_cartype.class);
			onCreate(database, connectionSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

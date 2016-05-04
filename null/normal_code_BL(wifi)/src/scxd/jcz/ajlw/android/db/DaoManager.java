package scxd.jcz.ajlw.android.db;

import java.sql.SQLException;

import scxd.jcz.ajlw.android.Activity.Application_Activity;
import scxd.jcz.ajlw.android.Application.MyApplication;

import com.j256.ormlite.dao.Dao;

public final class DaoManager {
	private static DbHelper mDbhelper;

	public static <D extends Dao<T, ?>, T> D getDao(Class<T> clazz)
			throws SQLException {
		if (mDbhelper == null) {
			mDbhelper = new DbHelper(MyApplication.getAppContext());
		}

		return mDbhelper.getDao(clazz);
	}
}

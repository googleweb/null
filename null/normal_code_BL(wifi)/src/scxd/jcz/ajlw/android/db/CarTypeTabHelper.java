package scxd.jcz.ajlw.android.db;

import java.sql.SQLException;
import java.util.List;

import scxd.jcz.ajlw.android.model.Md_cartype;

import com.j256.ormlite.dao.Dao;

public class CarTypeTabHelper {
	private static CarTypeTabHelper carTypeTabHelper;
	private Dao<Md_cartype, String> dao;
	/**
	 * 类名 :Out_Check_Result_TabHelper.java
	 * @author Administrator
	 * 功能描述:
	 * 创建时间:上午10:24:24
	 */
	private CarTypeTabHelper() {
		try {
			dao = DaoManager.getDao(Md_cartype.class);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	public static CarTypeTabHelper getInstance() {
		if (carTypeTabHelper == null) {
			carTypeTabHelper = new CarTypeTabHelper();
		}
		return carTypeTabHelper;
	}
	
	public Md_cartype insert(Md_cartype cartype) {
		try {
			return dao.createIfNotExists(cartype);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Md_cartype> likequery(String likestring) {
		List<Md_cartype> list=null;
		try {
			list=dao.queryBuilder().where().like("value",  "%"+likestring+"%").query();
		} catch (SQLException e) {
			e.printStackTrace();
			list=null;
		}
		return list;
	}
	public void clear(){
		List<Md_cartype> list = null;
		try {
			list=dao.queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Md_cartype Config_Tab=list.get(i);
				try {
					dao.delete(Config_Tab);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

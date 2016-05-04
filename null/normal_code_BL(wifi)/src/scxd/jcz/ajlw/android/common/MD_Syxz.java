package scxd.jcz.ajlw.android.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import scxd.jcz.ajlw.android.model.Md_cartype;

/**
 * 使用性质
 * 
 * @author Administrator
 * 
 */
public class MD_Syxz {

	private static Map<String, String> map = new HashMap<String, String>();
	private static List<Md_cartype> list = new ArrayList<Md_cartype>();

	public static List<Md_cartype> getSyxzList() {
		if (list.size() == 0) {
			list.add(new Md_cartype("1", "默认"));
			Set<String> keySet = getSyxzMap().keySet();
			for (String key : keySet) {
				list.add(new Md_cartype(key, map.get(key)));
			}
		}
		return list;
	}

	/**
	 * 获取使用性质 19项
	 * 
	 * @return
	 */
	public static Map<String, String> getSyxzMap() {
		if (map.size() == 0) {
			map.put("A", "非营运");
			map.put("B", "公路客运");
			map.put("C", "公交客运");
			map.put("D", "出租客运");
			map.put("E", "旅游客运");
			map.put("F", "货运");
			map.put("G", "租赁");
			map.put("H", "警用");
			map.put("I", "消防");
			map.put("J", "救护");
			map.put("K", "工程抢险");
			map.put("L", "营转非");
			map.put("M", "出租转非");
			map.put("N", "教练");
			map.put("O", "幼儿校车");
			map.put("P", "小学校车");
			map.put("Q", "其他校车");
			map.put("R", "危险品运输");
			map.put("Z", "其他");
		}
		return map;
	}
}

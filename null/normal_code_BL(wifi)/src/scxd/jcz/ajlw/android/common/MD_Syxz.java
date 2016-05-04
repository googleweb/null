package scxd.jcz.ajlw.android.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import scxd.jcz.ajlw.android.model.Md_cartype;

/**
 * ʹ������
 * 
 * @author Administrator
 * 
 */
public class MD_Syxz {

	private static Map<String, String> map = new HashMap<String, String>();
	private static List<Md_cartype> list = new ArrayList<Md_cartype>();

	public static List<Md_cartype> getSyxzList() {
		if (list.size() == 0) {
			list.add(new Md_cartype("1", "Ĭ��"));
			Set<String> keySet = getSyxzMap().keySet();
			for (String key : keySet) {
				list.add(new Md_cartype(key, map.get(key)));
			}
		}
		return list;
	}

	/**
	 * ��ȡʹ������ 19��
	 * 
	 * @return
	 */
	public static Map<String, String> getSyxzMap() {
		if (map.size() == 0) {
			map.put("A", "��Ӫ��");
			map.put("B", "��·����");
			map.put("C", "��������");
			map.put("D", "�������");
			map.put("E", "���ο���");
			map.put("F", "����");
			map.put("G", "����");
			map.put("H", "����");
			map.put("I", "����");
			map.put("J", "�Ȼ�");
			map.put("K", "��������");
			map.put("L", "Ӫת��");
			map.put("M", "����ת��");
			map.put("N", "����");
			map.put("O", "�׶�У��");
			map.put("P", "СѧУ��");
			map.put("Q", "����У��");
			map.put("R", "Σ��Ʒ����");
			map.put("Z", "����");
		}
		return map;
	}
}

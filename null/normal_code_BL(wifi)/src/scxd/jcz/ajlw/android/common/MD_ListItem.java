package scxd.jcz.ajlw.android.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import scxd.jcz.ajlw.android.model.InfoItemEdt;
import scxd.jcz.ajlw.android.model.Md_cartype;
import scxd.jcz.ajlw.android.model.Md_system;
import scxd.jcz.ajlw.android.util.SortMapByKey;
import android.content.Context;
import android.util.Log;
import android.view.View;
/**
 * ����׼�� 
 * @author Administrator
 *
 *�޸���Ƭ���򣬲��ҽ�������Ƭ�������
 *�޸��ˣ�chenyujin
 *ʱ�䣺2016-1-5 11:38:44
 */
public class MD_ListItem {

	/**
	 * ƥ�� ��ȡ id
	 * 
	 * @return Ĭ�� ����0
	 */
	public static int MatchIndex(String value, List<Md_cartype> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(value)) {
				Log.e("index", i + "");
				return i;
			}
		}
		return 0;
	}

	/**
	 * ����pos��ȡvlaue
	 */
	public static String getNameByPos(int pos, List<Md_cartype> list) {
		String val = list.get(pos).getName();
		if (val.equals("")) {
			return list.get(0).getName();
		} else {
			return val;
		}
	}

	/**
	 * ƥ�� ��ȡ id
	 * 
	 * @return Ĭ�� ����0
	 */
	public static String GetValue(String name, List<Md_cartype> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				return list.get(i).getValue();
			}
		}
		return list.get(0).getValue();
	}

	/**
	 * ƥ�� ��ȡ id
	 * 
	 * @return Ĭ�� ����0
	 */
	public static String GetName(String value, List<Md_cartype> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getValue().equals(value)) {
				return list.get(i).getName();
			}
		}
		return list.get(0).getName();
	}

	/**
	 * ��ȡ ȫ��ʡ ���
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_sf() {
		String hphmfl = "��,��,�³�,WJ��,��,��,��,��,��,��,��,��,��,��,��,��,��,��,��,ԥ,³,��,��,��,��,��,ǭ,��,��,��,��,��,��,��,̨,��,��,��";
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		String[] hphmfls = hphmfl.split(",");
		if (Md_system.hphmlb.equals("")) {
			for (String hphmlb : hphmfls) {
				list.add(new Md_cartype(hphmlb, hphmlb));
			}
		} else {
			list.add(new Md_cartype(Md_system.hphmlb, Md_system.hphmlb));
			for (String hphmlb : hphmfls) {
				if (!Md_system.hphmlb.equals(hphmlb)) {
					list.add(new Md_cartype(hphmlb, hphmlb));
				}
			}
		}
		list.add(new Md_cartype(" ", " "));
		return list;
	}

	public static List<Md_cartype> Get_sf2() {
		String[] hphmlbs = null;
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		try {
			hphmlbs = Md_system.getHphmlb().split(",");
		} catch (Exception e) {
		}
		if (hphmlbs != null && hphmlbs.length > 0) {
			for (String hphmlb : hphmlbs) {
				list.add(new Md_cartype(hphmlb, hphmlb));
			}
		} else {
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("�³�", "�³�"));
			list.add(new Md_cartype("WJ��", "WJ��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("ʹ", "ʹ"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("ԥ", "ԥ"));
			list.add(new Md_cartype("³", "³"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("ǭ", "ǭ"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("̨", "̨"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
			list.add(new Md_cartype("��", "��"));
		}
		list.add(new Md_cartype(" ", " "));
		return list;
	}

	/**
	 * ��ȡ ȫ��ʡ ���
	 * 
	 * @return
	 */

	public static String Get_sfs(String sf) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("��", "��");
		resultMap.put("�³�", "�³�");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("ԥ", "ԥ");
		resultMap.put("³", "³");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("ǭ", "ǭ");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("̨", "̨");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		resultMap.put("��", "��");
		return resultMap.get(sf);
	}

	/**
	 * ��ȡҵ������
	 * 
	 * @param id
	 * @return
	 */
	public static String getYwlx(int id) {
		String sywlx = "";
		switch (id) {
		case 0:
			sywlx = "���������ɫ";
			break;
		case 1:
			sywlx = "���Ǩ��";
			break;
		case 2:
			sywlx = "���ʹ������";
			break;
		case 3:
			sywlx = "����������߳���";
			break;
		case 4:
			sywlx = "����Ǽ�֤��";
			break;
		case 5:
			sywlx = "����������";
			break;
		case 6:
			sywlx = "��������";
			break;
		case 7:
			sywlx = "�˷�����ϸ��־";
			break;
		case 8:
			sywlx = "����";
			break;
		case 9:
			sywlx = "����";
			break;
		case 10:
			sywlx = "����Ǽ�֤��";
			break;
		case 11:
			sywlx = "���´�̷�������";
			break;
		case 12:
			sywlx = "���´�� VIN";
			break;
		case 13:
			sywlx = "ע��Ǽ�";
			break;
		case 14:
			sywlx = "ת��";
			break;
		case 15:
			sywlx = "ת�ƵǼ�";
			break;
		}
		return sywlx;
	}

	/**
	 * ��ȡ�����������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jylb() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("01", "01:���ó����飨���죩"));
		list.add(new Md_cartype("00", "00:ע��ǼǼ���"));
		list.add(new Md_cartype("02", "02:��ʱ����"));
		// list.add(new Md_cartype("03", "03:�������"));
		list.add(new Md_cartype("04", "04:���ó����飨�Ƕ��죩"));
		return list;
	}

	/**
	 * ��ȡ��������������ࣨ�Ƕ��죩
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jylbzlfdj() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0401", "0401:����������"));
		list.add(new Md_cartype("0402", "0402:��������򳵼�"));
		list.add(new Md_cartype("0403", "0403:ת������"));
		list.add(new Md_cartype("0404", "0404:�������"));
		list.add(new Md_cartype("0405", "0405:��ѧ�ó�"));
		list.add(new Md_cartype("0499", "0499:����"));
		return list;
	}

	/**
	 * ��ȡ��������������ࣨ��ʱ���飩
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jylbzllsjy() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0201", "0201:�����ó�"));
		list.add(new Md_cartype("0202", "0202:�¹ʳ�"));
		list.add(new Md_cartype("0203", "0203:�����Գ�����"));
		list.add(new Md_cartype("0204", "0204:��ʱ�뾳"));
		list.add(new Md_cartype("0299", "0299:����"));
		return list;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_Jcxlb() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "��ѡ��"));
		list.add(new Md_cartype("1", "��������"));
		list.add(new Md_cartype("2", "Ħ�г���"));
		return list;
	}

	/**
	 * �����������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_clsslb() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("01", "01:����"));
		list.add(new Md_cartype("02", "02:ȫʱ����"));
		list.add(new Md_cartype("03", "03:����"));
		list.add(new Md_cartype("04", "04:����"));
		list.add(new Md_cartype("05", "05:��������"));
		list.add(new Md_cartype("06", "06:˫��������"));
		list.add(new Md_cartype("07", "07:�ҳ�"));
		list.add(new Md_cartype("08", "08:��λ����"));
		list.add(new Md_cartype("09", "09:���ᳵ"));
		list.add(new Md_cartype("10", "10:�������ֳ�"));
		return list;
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_gcjk() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "����"));
		list.add(new Md_cartype("1", "����"));
		return list;
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_dybj() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "δ��Ѻ"));
		list.add(new Md_cartype("1", "�ѵ�Ѻ"));
		return list;
	}

	/**
	 * ��ȡ ��������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_cllx() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		// list.add(new Md_cartype("01", "΢��С���ؿ�����"));
		// list.add(new Md_cartype("02", "�����ؿ�����"));
		// list.add(new Md_cartype("03", "�����ؿ�����"));
		// list.add(new Md_cartype("04", "�ػ�����������ǣ����ҳ���"));
		// list.add(new Md_cartype("05", "Σ�ջ�ѧƷ���䳵"));

		// K��ͷ
		list.add(new Md_cartype("K33", "K33:�γ�"));
		list.add(new Md_cartype("K11", "K11:������ͨ�ͳ�"));
		list.add(new Md_cartype("K12", "K12:����˫��ͳ�"));
		list.add(new Md_cartype("K13", "K13:�������̿ͳ�"));
		list.add(new Md_cartype("K14", "K14:���ͽ½ӿͳ�"));
		list.add(new Md_cartype("K15", "K15:����ԽҰ�ͳ�"));
		list.add(new Md_cartype("K16", "K16:���ͽγ�"));
		list.add(new Md_cartype("K17", "K17:����ר�ÿͳ�"));
		list.add(new Md_cartype("K18", "K18:����ר��У��"));
		list.add(new Md_cartype("K21", "K21:������ͨ�ͳ�"));
		list.add(new Md_cartype("K22", "K22:����˫��ͳ�"));
		list.add(new Md_cartype("K23", "K23:�������̿ͳ�"));
		list.add(new Md_cartype("K24", "K24:���ͽ½ӿͳ�"));
		list.add(new Md_cartype("K25", "K25:����ԽҰ�ͳ�"));
		list.add(new Md_cartype("K26", "K26:���ͽγ�"));
		list.add(new Md_cartype("K27", "K27:����ר�ÿͳ�"));
		list.add(new Md_cartype("K28", "K28:����ר��У��"));
		list.add(new Md_cartype("K31", "K31:С����ͨ�ͳ�"));
		list.add(new Md_cartype("K32", "K32:С��ԽҰ�ͳ�"));
		list.add(new Md_cartype("K34", "K34:С��ר�ÿͳ�"));
		list.add(new Md_cartype("K38", "K38:С��ר��У��"));
		list.add(new Md_cartype("K39", "K39:С�������"));
		list.add(new Md_cartype("K41", "K41:΢����ͨ�ͳ�"));
		list.add(new Md_cartype("K42", "K42:΢��ԽҰ�ͳ�"));
		list.add(new Md_cartype("K43", "K43:΢�ͽγ�"));
		list.add(new Md_cartype("K49", "K49:΢�������"));
		// B��ͷ
		list.add(new Md_cartype("B11", "B1��������ͨ��ҳ�"));
		list.add(new Md_cartype("B12", "B12��������ʽ��ҳ�"));
		list.add(new Md_cartype("B13", "B13:���͹�ʽ��ҳ�"));
		list.add(new Md_cartype("B14", "B14:����ƽ���ҳ�"));
		list.add(new Md_cartype("B15", "B15�����ͼ�װ���ҳ�"));
		list.add(new Md_cartype("B16", "B16��������ж��ҳ�"));
		list.add(new Md_cartype("B17", "B17����������ṹ��ҳ�"));
		list.add(new Md_cartype("B18", "B18�����Ͳ�դʽ��ҳ�"));
		list.add(new Md_cartype("B19", "B19�������þӰ�ҳ�"));
		list.add(new Md_cartype("B1A", "B1A������ר����ҵ��ҳ�"));
		list.add(new Md_cartype("B1B", "B1B�����͵�ƽ���ҳ�"));
		list.add(new Md_cartype("B1C", "B1C�����ͳ��������ҳ�"));
		list.add(new Md_cartype("B1D", "B1D�����͹�ʽ��ж��ҳ�"));
		list.add(new Md_cartype("B1E", "B1E������ƽ����ж��ҳ�"));
		list.add(new Md_cartype("B1F", "B1F�����ͼ�װ����ж��ҳ�"));
		list.add(new Md_cartype("B1G", "B1G����������ṹ��ж��ҳ�"));
		list.add(new Md_cartype("B1H", "B1H�����Ͳ�դʽ��ж��ҳ�"));
		list.add(new Md_cartype("B1J", "B1J������ר����ҵ��ж��ҳ�"));
		list.add(new Md_cartype("B1K", "B1K�����͵�ƽ����ж��ҳ�"));
		list.add(new Md_cartype("B1U", "B1U�������������þӹҳ�"));
		list.add(new Md_cartype("B1V", "B1V�����������ᳵ�����䳵"));
		list.add(new Md_cartype("B1W", "B1W��������������ͨ�ҳ�"));
		list.add(new Md_cartype("B21", "B21��������ͨ��ҳ�"));
		list.add(new Md_cartype("B22", "B22��������ʽ��ҳ�"));
		list.add(new Md_cartype("B23", "B23�����͹�ʽ��ҳ�"));
		list.add(new Md_cartype("B24", "B24������ƽ���ҳ�"));
		list.add(new Md_cartype("B25", "B25�����ͼ�װ���ҳ�"));
		list.add(new Md_cartype("B26", "B26��������ж��ҳ�"));
		list.add(new Md_cartype("B27", "B27����������ṹ��ҳ�"));
		list.add(new Md_cartype("B28", "B28�����Ͳ�դʽ��ҳ�"));
		list.add(new Md_cartype("B29", "B29�������þӰ�ҳ�"));
		list.add(new Md_cartype("B2A", "B2A������ר����ҵ��ҳ�"));
		list.add(new Md_cartype("B2B", "B2B�����͵�ƽ���ҳ�"));
		list.add(new Md_cartype("B2C", "B2C�����ͳ��������ҳ�"));
		list.add(new Md_cartype("B2D", "B2D�����͹�ʽ��ж��ҳ�"));
		list.add(new Md_cartype("B2E", "B2E������ƽ����ж��ҳ�"));
		list.add(new Md_cartype("B2F", "B2F�����ͼ�װ����ж��ҳ�"));
		list.add(new Md_cartype("B2G", "B2G����������ṹ��ж��ҳ�"));
		list.add(new Md_cartype("B2H", "B2H�����Ͳ�դʽ��ж��ҳ�"));
		list.add(new Md_cartype("B2J", "B2J������ר����ҵ��ж��ҳ�"));
		list.add(new Md_cartype("B2K", "B2K�����͵�ƽ����ж��ҳ�"));
		list.add(new Md_cartype("B2U", "B2U�������������þӹҳ�"));
		list.add(new Md_cartype("B2V", "B2V�����������ᳵ�����䳵"));
		list.add(new Md_cartype("B2W", "B2W��������������ͨ�ҳ�"));
		list.add(new Md_cartype("B31", "B31��������ͨ��ҳ�"));
		list.add(new Md_cartype("B32", "B32��������ʽ��ҳ�"));
		list.add(new Md_cartype("B33", "B33�����͹�ʽ��ҳ�"));
		list.add(new Md_cartype("B34", "B34������ƽ���ҳ�"));
		list.add(new Md_cartype("B35", "B35��������ж��ҳ�"));
		list.add(new Md_cartype("B36", "B36�����Ͳ�դʽ��ҳ�"));
		list.add(new Md_cartype("B37", "B37�������þӰ�ҳ�"));
		list.add(new Md_cartype("B38", "B38������ר����ҵ��ҳ�"));
		list.add(new Md_cartype("B39", "B39�����͵�ƽ���ҳ�"));
		list.add(new Md_cartype("B3C", "B3C�����ͳ��������ҳ�"));
		list.add(new Md_cartype("B3D", "B3D�����͹�ʽ��ж��ҳ�"));
		list.add(new Md_cartype("B3E", "B3E������ƽ����ж��ҳ�"));
		list.add(new Md_cartype("B3F", "B3F�����ͼ�װ����ж��ҳ�"));
		list.add(new Md_cartype("B3G", "B3G����������ṹ��ж��ҳ�"));
		list.add(new Md_cartype("B3H", "B3H�����Ͳ�դʽ��ж��ҳ�"));
		list.add(new Md_cartype("B3J", "B3J������ר����ҵ��ж��ҳ�"));
		list.add(new Md_cartype("B3K", "B3K�����͵�ƽ����ж��ҳ�"));
		list.add(new Md_cartype("B3U", "B3U�������������þӹҳ�"));
		list.add(new Md_cartype("B3V", "B3V�����������ᳵ�����䳵"));
		list.add(new Md_cartype("B3W", "B3W��������������ͨ�ҳ�"));
		// H��ͷ
		list.add(new Md_cartype("H11", "H11��������ͨ����"));
		list.add(new Md_cartype("H12", "H12��������ʽ����"));
		list.add(new Md_cartype("H13", "H13�����ͷ�ջ���"));
		list.add(new Md_cartype("H14", "H14�����͹�ʽ����"));
		list.add(new Md_cartype("H15", "H15������ƽ�����"));
		list.add(new Md_cartype("H16", "H16�����ͼ�װ�ᳵ"));
		list.add(new Md_cartype("H17", "H17��������ж����"));
		list.add(new Md_cartype("H18", "H18����������ṹ����"));
		list.add(new Md_cartype("H19", "H19�����Ͳ�դʽ����"));
		list.add(new Md_cartype("H1A", "H1A�����ͳ������䳵"));
		list.add(new Md_cartype("H1B", "H1B��������ʽ��ж����"));
		list.add(new Md_cartype("H1C", "H1C�����͹�ʽ��ж����"));
		list.add(new Md_cartype("H1D", "H1D������ƽ����ж����"));
		list.add(new Md_cartype("H1E", "H1E�����ͼ�װ����ж����"));
		list.add(new Md_cartype("H1F", "H1F����������ṹ��ж����"));
		list.add(new Md_cartype("H1G", "H1G�����Ͳ�դʽ��ж����"));
		list.add(new Md_cartype("H21", "H21��������ͨ����"));
		list.add(new Md_cartype("H22", "H22��������ʽ����"));
		list.add(new Md_cartype("H23", "H23�����ͷ�ջ���"));
		list.add(new Md_cartype("H24", "H24�����͹�ʽ����"));
		list.add(new Md_cartype("H25", "H25:����ƽ�����"));
		list.add(new Md_cartype("H26", "H26:���ͼ�װ�ᳵ"));
		list.add(new Md_cartype("H27", "H27:������ж����"));
		list.add(new Md_cartype("H28", "H28:��������ṹ����"));
		list.add(new Md_cartype("H29", "H29:���Ͳ�դʽ����"));
		list.add(new Md_cartype("H2A", "H2A:���ͳ������䳵"));
		list.add(new Md_cartype("H2B", "H2B:������ʽ��ж����"));
		list.add(new Md_cartype("H2C", "H2C:���͹�ʽ��ж����"));
		list.add(new Md_cartype("H2D", "H2D������ƽ����ж����"));
		list.add(new Md_cartype("H2E", "H2E:���ͼ�װ����ж����"));
		list.add(new Md_cartype("H2F", "H2F:��������ṹ��ж����"));
		list.add(new Md_cartype("H2G", "H2G:���Ͳ�դʽ��ж����"));
		list.add(new Md_cartype("H31", "H31:������ͨ����"));
		list.add(new Md_cartype("H32", "H32:������ʽ����"));
		list.add(new Md_cartype("H33", "H33:���ͷ�ջ���"));
		list.add(new Md_cartype("H34", "H34:���͹�ʽ����"));
		list.add(new Md_cartype("H35", "H35:����ƽ�����"));
		list.add(new Md_cartype("H37", "H37:������ж����"));
		list.add(new Md_cartype("H38", "H38:��������ṹ����"));
		list.add(new Md_cartype("H39", "H39:���Ͳ�դʽ����"));
		list.add(new Md_cartype("H39", "H39:���ͳ������䳵"));
		list.add(new Md_cartype("H3A", "H3A:���ͳ������䳵"));
		list.add(new Md_cartype("H3B", "H3B:������ʽ��ж����"));
		list.add(new Md_cartype("H3C", "H3C:���͹�ʽ��ж����"));
		list.add(new Md_cartype("H3D", "H3D:����ƽ����ж����"));
		list.add(new Md_cartype("H3E", "H3E:���ͼ�װ����ж����"));
		list.add(new Md_cartype("H3F", "H3F:��������ṹ��ж����"));
		list.add(new Md_cartype("H3G", "H3G:���Ͳ�դʽ��ж����"));
		list.add(new Md_cartype("H41", "H41:΢����ͨ����"));
		list.add(new Md_cartype("H42", "H42:΢����ʽ����"));
		list.add(new Md_cartype("H43", "H43:΢�ͷ�ջ���"));
		list.add(new Md_cartype("H44", "H44:΢�͹�ʽ����"));
		list.add(new Md_cartype("H45", "H45:΢����ж����"));
		list.add(new Md_cartype("H46", "H46:΢������ṹ����"));
		list.add(new Md_cartype("H47", "H47:΢�Ͳ�դʽ����"));
		list.add(new Md_cartype("H4A", "H4A:΢�ͳ������䳵"));
		list.add(new Md_cartype("H4B", "H4B:΢����ʽ��ж����"));
		list.add(new Md_cartype("H4C", "H4C:΢�͹�ʽ��ж����"));
		list.add(new Md_cartype("H4F", "H4F:΢������ṹ��ж����"));
		list.add(new Md_cartype("H4G", "H4G:΢�Ͳ�դʽ��ж����"));
		list.add(new Md_cartype("H51", "H51:������ͨ����"));
		list.add(new Md_cartype("H52", "H52:������ʽ����"));
		list.add(new Md_cartype("H53", "H53:���ٹ�ʽ����"));
		list.add(new Md_cartype("H54", "H54:��ж���ٻ���"));
		list.add(new Md_cartype("H55", "H55:��դʽ���ٻ���"));
		list.add(new Md_cartype("H5B", "H5B:��ʽ��ж���ٻ���"));
		list.add(new Md_cartype("H5C", "H5C:��ʽ��ж���ٻ���"));
		// Z��ͷ
		list.add(new Md_cartype("Z11", "Z11:����ר����ҵ��"));
		list.add(new Md_cartype("Z12", "Z12:�����ػ�ר����ҵ��"));
		list.add(new Md_cartype("Z21", "Z21:����ר����ҵ��"));
		list.add(new Md_cartype("Z22", "Z22:�����ػ�ר����ҵ��"));
		list.add(new Md_cartype("Z31", "Z31:С��ר����ҵ��"));
		list.add(new Md_cartype("Z32", "Z32:С���ػ�ר����ҵ��"));
		list.add(new Md_cartype("Z41", "Z41:΢��ר����ҵ��"));
		list.add(new Md_cartype("Z42", "Z42:΢���ػ�ר����ҵ��"));
		list.add(new Md_cartype("Z51", "Z51:����ר����ҵ��"));
		list.add(new Md_cartype("Z52", "Z52:�����ػ�ר����ҵ��"));
		list.add(new Md_cartype("Z71", "Z71:����ר����ҵ��"));
		list.add(new Md_cartype("Z72", "Z72:�����ػ�ר����ҵ��"));
		// D��ͷ
		list.add(new Md_cartype("D11", "D11:�޹�糵"));
		list.add(new Md_cartype("D12", "D12:�й�糵"));
		// M��ͷ
		list.add(new Md_cartype("M11", "M11:��ͨ������Ħ�г�"));
		list.add(new Md_cartype("M12", "M12:���������Ħ�г�"));
		list.add(new Md_cartype("M13", "M13:�������ؿ�Ħ�г�"));
		list.add(new Md_cartype("M14", "M14:�������ػ�Ħ�г�"));
		list.add(new Md_cartype("M15", "M15:������Ħ�г�"));
		list.add(new Md_cartype("M21", "M21:��ͨ����Ħ�г�"));
		list.add(new Md_cartype("M22", "M22:������Ħ�г�"));
		// N��ͷ
		list.add(new Md_cartype("N11", "N11:��������"));
		// Q��ͷ
		list.add(new Md_cartype("Q11", "Q11:���Ͱ��ǣ����"));
		list.add(new Md_cartype("Q12", "Q12:����ȫ��ǣ����"));
		list.add(new Md_cartype("Q22", "Q22:����ȫ��ǣ����"));
		list.add(new Md_cartype("Q21", "Q21:���Ͱ��ǣ����"));
		list.add(new Md_cartype("Q31", "Q31:���Ͱ��ǣ����"));
		list.add(new Md_cartype("Q32", "Q32:����ȫ��ǣ����"));
		// T��ͷ
		list.add(new Md_cartype("T11", "T11:������ʽ������"));
		list.add(new Md_cartype("T21", "T21:С����ʽ������"));
		list.add(new Md_cartype("T22", "T22:�ַ�������"));
		list.add(new Md_cartype("T23", "T23:�ַ����������"));
		// J��ͷ
		list.add(new Md_cartype("J11", "J11:��ʽװ�ػ�е"));
		list.add(new Md_cartype("J12", "J12:��ʽ�ھ��е"));
		list.add(new Md_cartype("J13", "J13:��ʽƽ�ػ�е"));
		// G��ͷ
		list.add(new Md_cartype("G11", "G11:������ͨȫ�ҳ�"));
		list.add(new Md_cartype("G12", "G12:������ʽȫ�ҳ�"));
		list.add(new Md_cartype("G13", "G13:���͹�ʽȫ�ҳ�"));
		list.add(new Md_cartype("G14", "G14:����ƽ��ȫ�ҳ�"));
		list.add(new Md_cartype("G15", "G15:���ͼ�װ��ȫ�ҳ�"));
		list.add(new Md_cartype("G16", "G16:������жȫ�ҳ�"));
		list.add(new Md_cartype("G17", "G17:���Ͳ�դʽȫ�ҳ�"));
		list.add(new Md_cartype("G18", "G18:�����þ�ȫ�ҳ�"));
		list.add(new Md_cartype("G19", "G19:����ר����ҵȫ�ҳ�"));
		list.add(new Md_cartype("G1A", "G1A:������ʽ��жȫ�ҳ�"));
		list.add(new Md_cartype("G1B", "G1B:���͹�ʽ��жȫ�ҳ�"));
		list.add(new Md_cartype("G1C", "G1C:����ƽ����жȫ�ҳ�"));
		list.add(new Md_cartype("G1D", "G1D:���ͼ�װ����жȫ�ҳ�"));
		list.add(new Md_cartype("G1E", "G1E:���Ͳ�դʽ��жȫ�ҳ�"));
		list.add(new Md_cartype("G1F", "G1F:����ר����ҵ��жȫ�ҳ�"));
		list.add(new Md_cartype("G21", "G21:������ͨȫ�ҳ�"));
		list.add(new Md_cartype("G22", "G22:������ʽȫ�ҳ�"));
		list.add(new Md_cartype("G23", "G23:���͹�ʽȫ�ҳ�"));
		list.add(new Md_cartype("G24", "G24:����ƽ��ȫ�ҳ�"));
		list.add(new Md_cartype("G25", "G25:���ͼ�װ��ȫ�ҳ�"));
		list.add(new Md_cartype("G26", "G26:������жȫ�ҳ�"));
		list.add(new Md_cartype("G27", "G27:���Ͳ�դʽȫ�ҳ�"));
		list.add(new Md_cartype("G28", "G28:�����þ�ȫ�ҳ�"));
		list.add(new Md_cartype("G29", "G29:����ר����ҵȫ�ҳ�"));
		list.add(new Md_cartype("G2A", "G2A:������ʽ��жȫ�ҳ�"));
		list.add(new Md_cartype("G2B", "G2B:���͹�ʽ��жȫ�ҳ�"));
		list.add(new Md_cartype("G2C", "G2C:����ƽ����жȫ�ҳ�"));
		list.add(new Md_cartype("G2D", "G2D:���ͼ�װ����жȫ�ҳ�"));
		list.add(new Md_cartype("G2E", "G2E:���Ͳ�դʽ��жȫ�ҳ�"));
		list.add(new Md_cartype("G2F", "G2F:����ר����ҵ��жȫ�ҳ�"));
		list.add(new Md_cartype("G31", "G31:������ͨȫ�ҳ�"));
		list.add(new Md_cartype("G32", "G32:������ʽȫ�ҳ�"));
		list.add(new Md_cartype("G33", "G33:���͹�ʽȫ�ҳ�"));
		list.add(new Md_cartype("G34", "G34:����ƽ��ȫ�ҳ�"));
		list.add(new Md_cartype("G35", "G35:������жȫ�ҳ�"));
		list.add(new Md_cartype("G36", "G36:���Ͳ�դʽȫ�ҳ�"));
		list.add(new Md_cartype("G37", "G37:�����þ�ȫ�ҳ�"));
		list.add(new Md_cartype("G38", "G38:����ר����ҵȫ�ҳ�"));
		list.add(new Md_cartype("G3A", "G3A:������ʽ��жȫ�ҳ�"));
		list.add(new Md_cartype("G3B", "G3B:���͹�ʽ��жȫ�ҳ�"));
		list.add(new Md_cartype("G3C", "G3C:����ƽ����жȫ�ҳ�"));
		list.add(new Md_cartype("G3D", "G3D:���ͼ�װ����жȫ�ҳ�"));
		list.add(new Md_cartype("G3E", "G3E:���Ͳ�դʽ��жȫ�ҳ�"));
		list.add(new Md_cartype("G3F", "G3F:����ר����ҵ��жȫ�ҳ�"));
		// X��:ͷ
		list.add(new Md_cartype("X99", "X99:����"));
		return list;
	}
	/**
	 * ��ȡ ��������
	 * 
	 * @return
	 */
	public static List<String> Get_cllxArray() {
		List<String> list = new ArrayList<String>();
		// list.add(new Md_cartype("01", "΢��С���ؿ�����"));
		// list.add(new Md_cartype("02", "�����ؿ�����"));
		// list.add(new Md_cartype("03", "�����ؿ�����"));
		// list.add(new Md_cartype("04", "�ػ�����������ǣ����ҳ���"));
		// list.add(new Md_cartype("05", "Σ�ջ�ѧƷ���䳵"));

		// K��ͷ
		list.add( "K33:�γ�");
		list.add( "K11:������ͨ�ͳ�");
		list.add( "K12:����˫��ͳ�");
		list.add( "K13:�������̿ͳ�");
		list.add( "K14:���ͽ½ӿͳ�");
		list.add( "K15:����ԽҰ�ͳ�");
		list.add( "K16:���ͽγ�");
		list.add( "K17:����ר�ÿͳ�");
		list.add( "K18:����ר��У��");
		list.add( "K21:������ͨ�ͳ�");
		list.add( "K22:����˫��ͳ�");
		list.add( "K23:�������̿ͳ�");
		list.add( "K24:���ͽ½ӿͳ�");
		list.add( "K25:����ԽҰ�ͳ�");
		list.add( "K26:���ͽγ�");
		list.add( "K27:����ר�ÿͳ�");
		list.add( "K28:����ר��У��");
		list.add( "K31:С����ͨ�ͳ�");
		list.add( "K32:С��ԽҰ�ͳ�");
		list.add( "K34:С��ר�ÿͳ�");
		list.add( "K38:С��ר��У��");
		list.add( "K39:С�������");
		list.add( "K41:΢����ͨ�ͳ�");
		list.add( "K42:΢��ԽҰ�ͳ�");
		list.add( "K43:΢�ͽγ�");
		list.add( "K49:΢�������");
		// B��ͷ
		list.add( "B1��������ͨ��ҳ�");
		list.add( "B12��������ʽ��ҳ�");
		list.add( "B13:���͹�ʽ��ҳ�");
		list.add( "B14:����ƽ���ҳ�");
		list.add( "B15�����ͼ�װ���ҳ�");
		list.add( "B16��������ж��ҳ�");
		list.add( "B17����������ṹ��ҳ�");
		list.add( "B18�����Ͳ�դʽ��ҳ�");
		list.add( "B19�������þӰ�ҳ�");
		list.add( "B1A������ר����ҵ��ҳ�");
		list.add( "B1B�����͵�ƽ���ҳ�");
		list.add( "B1C�����ͳ��������ҳ�");
		list.add( "B1D�����͹�ʽ��ж��ҳ�");
		list.add( "B1E������ƽ����ж��ҳ�");
		list.add( "B1F�����ͼ�װ����ж��ҳ�");
		list.add( "B1G����������ṹ��ж��ҳ�");
		list.add( "B1H�����Ͳ�դʽ��ж��ҳ�");
		list.add( "B1J������ר����ҵ��ж��ҳ�");
		list.add( "B1K�����͵�ƽ����ж��ҳ�");
		list.add( "B1U�������������þӹҳ�");
		list.add( "B1V�����������ᳵ�����䳵");
		list.add( "B1W��������������ͨ�ҳ�");
		list.add( "B21��������ͨ��ҳ�");
		list.add( "B22��������ʽ��ҳ�");
		list.add( "B23�����͹�ʽ��ҳ�");
		list.add( "B24������ƽ���ҳ�");
		list.add( "B25�����ͼ�װ���ҳ�");
		list.add( "B26��������ж��ҳ�");
		list.add( "B27����������ṹ��ҳ�");
		list.add( "B28�����Ͳ�դʽ��ҳ�");
		list.add( "B29�������þӰ�ҳ�");
		list.add( "B2A������ר����ҵ��ҳ�");
		list.add( "B2B�����͵�ƽ���ҳ�");
		list.add( "B2C�����ͳ��������ҳ�");
		list.add( "B2D�����͹�ʽ��ж��ҳ�");
		list.add( "B2E������ƽ����ж��ҳ�");
		list.add( "B2F�����ͼ�װ����ж��ҳ�");
		list.add( "B2G����������ṹ��ж��ҳ�");
		list.add( "B2H�����Ͳ�դʽ��ж��ҳ�");
		list.add( "B2J������ר����ҵ��ж��ҳ�");
		list.add( "B2K�����͵�ƽ����ж��ҳ�");
		list.add( "B2U�������������þӹҳ�");
		list.add( "B2V�����������ᳵ�����䳵");
		list.add( "B2W��������������ͨ�ҳ�");
		list.add( "B31��������ͨ��ҳ�");
		list.add( "B32��������ʽ��ҳ�");
		list.add( "B33�����͹�ʽ��ҳ�");
		list.add( "B34������ƽ���ҳ�");
		list.add( "B35��������ж��ҳ�");
		list.add( "B36�����Ͳ�դʽ��ҳ�");
		list.add( "B37�������þӰ�ҳ�");
		list.add( "B38������ר����ҵ��ҳ�");
		list.add( "B39�����͵�ƽ���ҳ�");
		list.add( "B3C�����ͳ��������ҳ�");
		list.add( "B3D�����͹�ʽ��ж��ҳ�");
		list.add( "B3E������ƽ����ж��ҳ�");
		list.add( "B3F�����ͼ�װ����ж��ҳ�");
		list.add( "B3G����������ṹ��ж��ҳ�");
		list.add( "B3H�����Ͳ�դʽ��ж��ҳ�");
		list.add( "B3J������ר����ҵ��ж��ҳ�");
		list.add( "B3K�����͵�ƽ����ж��ҳ�");
		list.add( "B3U�������������þӹҳ�");
		list.add( "B3V�����������ᳵ�����䳵");
		list.add( "B3W��������������ͨ�ҳ�");
		// H��ͷ
		list.add( "H11��������ͨ����");
		list.add( "H12��������ʽ����");
		list.add( "H13�����ͷ�ջ���");
		list.add( "H14�����͹�ʽ����");
		list.add( "H15������ƽ�����");
		list.add( "H16�����ͼ�װ�ᳵ");
		list.add( "H17��������ж����");
		list.add( "H18����������ṹ����");
		list.add( "H19�����Ͳ�դʽ����");
		list.add( "H1A�����ͳ������䳵");
		list.add( "H1B��������ʽ��ж����");
		list.add( "H1C�����͹�ʽ��ж����");
		list.add( "H1D������ƽ����ж����");
		list.add( "H1E�����ͼ�װ����ж����");
		list.add( "H1F����������ṹ��ж����");
		list.add( "H1G�����Ͳ�դʽ��ж����");
		list.add( "H21��������ͨ����");
		list.add( "H22��������ʽ����");
		list.add( "H23�����ͷ�ջ���");
		list.add( "H24�����͹�ʽ����");
		list.add( "H25:����ƽ�����");
		list.add( "H26:���ͼ�װ�ᳵ");
		list.add( "H27:������ж����");
		list.add( "H28:��������ṹ����");
		list.add( "H29:���Ͳ�դʽ����");
		list.add( "H2A:���ͳ������䳵");
		list.add( "H2B:������ʽ��ж����");
		list.add( "H2C:���͹�ʽ��ж����");
		list.add( "H2D������ƽ����ж����");
		list.add( "H2E:���ͼ�װ����ж����");
		list.add( "H2F:��������ṹ��ж����");
		list.add( "H2G:���Ͳ�դʽ��ж����");
		list.add( "H31:������ͨ����");
		list.add( "H32:������ʽ����");
		list.add( "H33:���ͷ�ջ���");
		list.add( "H34:���͹�ʽ����");
		list.add( "H35:����ƽ�����");
		list.add( "H37:������ж����");
		list.add( "H38:��������ṹ����");
		list.add( "H39:���Ͳ�դʽ����");
		list.add( "H39:���ͳ������䳵");
		list.add( "H3A:���ͳ������䳵");
		list.add( "H3B:������ʽ��ж����");
		list.add( "H3C:���͹�ʽ��ж����");
		list.add( "H3D:����ƽ����ж����");
		list.add( "H3E:���ͼ�װ����ж����");
		list.add( "H3F:��������ṹ��ж����");
		list.add( "H3G:���Ͳ�դʽ��ж����");
		list.add( "H41:΢����ͨ����");
		list.add( "H42:΢����ʽ����");
		list.add( "H43:΢�ͷ�ջ���");
		list.add( "H44:΢�͹�ʽ����");
		list.add( "H45:΢����ж����");
		list.add( "H46:΢������ṹ����");
		list.add( "H47:΢�Ͳ�դʽ����");
		list.add( "H4A:΢�ͳ������䳵");
		list.add( "H4B:΢����ʽ��ж����");
		list.add( "H4C:΢�͹�ʽ��ж����");
		list.add( "H4F:΢������ṹ��ж����");
		list.add( "H4G:΢�Ͳ�դʽ��ж����");
		list.add( "H51:������ͨ����");
		list.add( "H52:������ʽ����");
		list.add( "H53:���ٹ�ʽ����");
		list.add( "H54:��ж���ٻ���");
		list.add( "H55:��դʽ���ٻ���");
		list.add( "H5B:��ʽ��ж���ٻ���");
		list.add( "H5C:��ʽ��ж���ٻ���");
		// Z��ͷ
		list.add( "Z11:����ר����ҵ��");
		list.add( "Z12:�����ػ�ר����ҵ��");
		list.add( "Z21:����ר����ҵ��");
		list.add( "Z22:�����ػ�ר����ҵ��");
		list.add( "Z31:С��ר����ҵ��");
		list.add( "Z32:С���ػ�ר����ҵ��");
		list.add( "Z41:΢��ר����ҵ��");
		list.add( "Z42:΢���ػ�ר����ҵ��");
		list.add( "Z51:����ר����ҵ��");
		list.add( "Z52:�����ػ�ר����ҵ��");
		list.add( "Z71:����ר����ҵ��");
		list.add( "Z72:�����ػ�ר����ҵ��");
		// D��ͷ
		list.add( "D11:�޹�糵");
		list.add( "D12:�й�糵");
		// M��ͷ
		list.add( "M11:��ͨ������Ħ�г�");
		list.add( "M12:���������Ħ�г�");
		list.add( "M13:�������ؿ�Ħ�г�");
		list.add( "M14:�������ػ�Ħ�г�");
		list.add( "M15:������Ħ�г�");
		list.add( "M21:��ͨ����Ħ�г�");
		list.add( "M22:������Ħ�г�");
		// N��ͷ
		list.add( "N11:��������");
		// Q��ͷ
		list.add( "Q11:���Ͱ��ǣ����");
		list.add( "Q12:����ȫ��ǣ����");
		list.add( "Q22:����ȫ��ǣ����");
		list.add( "Q21:���Ͱ��ǣ����");
		list.add( "Q31:���Ͱ��ǣ����");
		list.add( "Q32:����ȫ��ǣ����");
		// T��ͷ
		list.add( "T11:������ʽ������");
		list.add( "T21:С����ʽ������");
		list.add( "T22:�ַ�������");
		list.add( "T23:�ַ����������");
		// J��ͷ
		list.add( "J11:��ʽװ�ػ�е");
		list.add( "J12:��ʽ�ھ��е");
		list.add( "J13:��ʽƽ�ػ�е");
		// G��ͷ
		list.add( "G11:������ͨȫ�ҳ�");
		list.add( "G12:������ʽȫ�ҳ�");
		list.add( "G13:���͹�ʽȫ�ҳ�");
		list.add( "G14:����ƽ��ȫ�ҳ�");
		list.add( "G15:���ͼ�װ��ȫ�ҳ�");
		list.add( "G16:������жȫ�ҳ�");
		list.add( "G17:���Ͳ�դʽȫ�ҳ�");
		list.add( "G18:�����þ�ȫ�ҳ�");
		list.add( "G19:����ר����ҵȫ�ҳ�");
		list.add( "G1A:������ʽ��жȫ�ҳ�");
		list.add( "G1B:���͹�ʽ��жȫ�ҳ�");
		list.add( "G1C:����ƽ����жȫ�ҳ�");
		list.add( "G1D:���ͼ�װ����жȫ�ҳ�");
		list.add( "G1E:���Ͳ�դʽ��жȫ�ҳ�");
		list.add( "G1F:����ר����ҵ��жȫ�ҳ�");
		list.add( "G21:������ͨȫ�ҳ�");
		list.add( "G22:������ʽȫ�ҳ�");
		list.add( "G23:���͹�ʽȫ�ҳ�");
		list.add( "G24:����ƽ��ȫ�ҳ�");
		list.add( "G25:���ͼ�װ��ȫ�ҳ�");
		list.add( "G26:������жȫ�ҳ�");
		list.add( "G27:���Ͳ�դʽȫ�ҳ�");
		list.add( "G28:�����þ�ȫ�ҳ�");
		list.add( "G29:����ר����ҵȫ�ҳ�");
		list.add( "G2A:������ʽ��жȫ�ҳ�");
		list.add( "G2B:���͹�ʽ��жȫ�ҳ�");
		list.add( "G2C:����ƽ����жȫ�ҳ�");
		list.add( "G2D:���ͼ�װ����жȫ�ҳ�");
		list.add( "G2E:���Ͳ�դʽ��жȫ�ҳ�");
		list.add( "G2F:����ר����ҵ��жȫ�ҳ�");
		list.add( "G31:������ͨȫ�ҳ�");
		list.add( "G32:������ʽȫ�ҳ�");
		list.add( "G33:���͹�ʽȫ�ҳ�");
		list.add( "G34:����ƽ��ȫ�ҳ�");
		list.add( "G35:������жȫ�ҳ�");
		list.add( "G36:���Ͳ�դʽȫ�ҳ�");
		list.add( "G37:�����þ�ȫ�ҳ�");
		list.add( "G38:����ר����ҵȫ�ҳ�");
		list.add( "G3A:������ʽ��жȫ�ҳ�");
		list.add( "G3B:���͹�ʽ��жȫ�ҳ�");
		list.add( "G3C:����ƽ����жȫ�ҳ�");
		list.add( "G3D:���ͼ�װ����жȫ�ҳ�");
		list.add( "G3E:���Ͳ�դʽ��жȫ�ҳ�");
		list.add( "G3F:����ר����ҵ��жȫ�ҳ�");
		// X��:ͷ
		list.add( "X99:����");
		
		
		list.add( "�γ�");
		list.add( "������ͨ�ͳ�");
		list.add( "����˫��ͳ�");
		list.add( "�������̿ͳ�");
		list.add( "���ͽ½ӿͳ�");
		list.add( "����ԽҰ�ͳ�");
		list.add( "���ͽγ�");
		list.add( "����ר�ÿͳ�");
		list.add( "����ר��У��");
		list.add( "������ͨ�ͳ�");
		list.add( "����˫��ͳ�");
		list.add( "�������̿ͳ�");
		list.add( "���ͽ½ӿͳ�");
		list.add( "����ԽҰ�ͳ�");
		list.add( "���ͽγ�");
		list.add( "����ר�ÿͳ�");
		list.add( "����ר��У��");
		list.add( "С����ͨ�ͳ�");
		list.add( "С��ԽҰ�ͳ�");
		list.add( "С��ר�ÿͳ�");
		list.add( "С��ר��У��");
		list.add( "С�������");
		list.add( "΢����ͨ�ͳ�");
		list.add( "΢��ԽҰ�ͳ�");
		list.add( "΢�ͽγ�");
		list.add( "΢�������");
		// B��ͷ
		list.add( "������ͨ��ҳ�");
		list.add( "������ʽ��ҳ�");
		list.add( "���͹�ʽ��ҳ�");
		list.add( "����ƽ���ҳ�");
		list.add( "���ͼ�װ���ҳ�");
		list.add( "������ж��ҳ�");
		list.add( "��������ṹ��ҳ�");
		list.add( "���Ͳ�դʽ��ҳ�");
		list.add( "�����þӰ�ҳ�");
		list.add( "����ר����ҵ��ҳ�");
		list.add( "���͵�ƽ���ҳ�");
		list.add( "���ͳ��������ҳ�");
		list.add( "���͹�ʽ��ж��ҳ�");
		list.add( "����ƽ����ж��ҳ�");
		list.add( "���ͼ�װ����ж��ҳ�");
		list.add( "��������ṹ��ж��ҳ�");
		list.add( "���Ͳ�դʽ��ж��ҳ�");
		list.add( "����ר����ҵ��ж��ҳ�");
		list.add( "���͵�ƽ����ж��ҳ�");
		list.add( "�����������þӹҳ�");
		list.add( "���������ᳵ�����䳵");
		list.add( "������������ͨ�ҳ�");
		list.add( "������ͨ��ҳ�");
		list.add( "������ʽ��ҳ�");
		list.add( "���͹�ʽ��ҳ�");
		list.add( "����ƽ���ҳ�");
		list.add( "���ͼ�װ���ҳ�");
		list.add( "������ж��ҳ�");
		list.add( "��������ṹ��ҳ�");
		list.add( "���Ͳ�դʽ��ҳ�");
		list.add( "�����þӰ�ҳ�");
		list.add( "����ר����ҵ��ҳ�");
		list.add( "���͵�ƽ���ҳ�");
		list.add( "���ͳ��������ҳ�");
		list.add( "���͹�ʽ��ж��ҳ�");
		list.add( "����ƽ����ж��ҳ�");
		list.add( "���ͼ�װ����ж��ҳ�");
		list.add( "��������ṹ��ж��ҳ�");
		list.add( "���Ͳ�դʽ��ж��ҳ�");
		list.add( "����ר����ҵ��ж��ҳ�");
		list.add( "���͵�ƽ����ж��ҳ�");
		list.add( "�����������þӹҳ�");
		list.add( "���������ᳵ�����䳵");
		list.add( "������������ͨ�ҳ�");
		list.add( "������ͨ��ҳ�");
		list.add( "������ʽ��ҳ�");
		list.add( "���͹�ʽ��ҳ�");
		list.add( "����ƽ���ҳ�");
		list.add( "������ж��ҳ�");
		list.add( "���Ͳ�դʽ��ҳ�");
		list.add( "�����þӰ�ҳ�");
		list.add( "����ר����ҵ��ҳ�");
		list.add( "���͵�ƽ���ҳ�");
		list.add( "���ͳ��������ҳ�");
		list.add( "���͹�ʽ��ж��ҳ�");
		list.add( "����ƽ����ж��ҳ�");
		list.add( "���ͼ�װ����ж��ҳ�");
		list.add( "��������ṹ��ж��ҳ�");
		list.add( "���Ͳ�դʽ��ж��ҳ�");
		list.add( "����ר����ҵ��ж��ҳ�");
		list.add( "���͵�ƽ����ж��ҳ�");
		list.add( "�����������þӹҳ�");
		list.add( "���������ᳵ�����䳵");
		list.add( "������������ͨ�ҳ�");
		// H��ͷ
		list.add( "������ͨ����");
		list.add( "������ʽ����");
		list.add( "���ͷ�ջ���");
		list.add( "���͹�ʽ����");
		list.add( "����ƽ�����");
		list.add( "���ͼ�װ�ᳵ");
		list.add( "������ж����");
		list.add( "��������ṹ����");
		list.add( "���Ͳ�դʽ����");
		list.add( "���ͳ������䳵");
		list.add( "������ʽ��ж����");
		list.add( "���͹�ʽ��ж����");
		list.add( "����ƽ����ж����");
		list.add( "���ͼ�װ����ж����");
		list.add( "��������ṹ��ж����");
		list.add( "���Ͳ�դʽ��ж����");
		list.add( "������ͨ����");
		list.add( "������ʽ����");
		list.add( "���ͷ�ջ���");
		list.add( "���͹�ʽ����");
		list.add( "����ƽ�����");
		list.add( "���ͼ�װ�ᳵ");
		list.add( "������ж����");
		list.add( "��������ṹ����");
		list.add( "���Ͳ�դʽ����");
		list.add( "���ͳ������䳵");
		list.add( "������ʽ��ж����");
		list.add( "���͹�ʽ��ж����");
		list.add( "����ƽ����ж����");
		list.add( "���ͼ�װ����ж����");
		list.add( "��������ṹ��ж����");
		list.add( "���Ͳ�դʽ��ж����");
		list.add( "������ͨ����");
		list.add( "������ʽ����");
		list.add( "���ͷ�ջ���");
		list.add( "���͹�ʽ����");
		list.add( "����ƽ�����");
		list.add( "������ж����");
		list.add( "��������ṹ����");
		list.add( "���Ͳ�դʽ����");
		list.add( "���ͳ������䳵");
		list.add( "���ͳ������䳵");
		list.add( "������ʽ��ж����");
		list.add( "���͹�ʽ��ж����");
		list.add( "����ƽ����ж����");
		list.add( "���ͼ�װ����ж����");
		list.add( "��������ṹ��ж����");
		list.add( "���Ͳ�դʽ��ж����");
		list.add( "΢����ͨ����");
		list.add( "΢����ʽ����");
		list.add( "΢�ͷ�ջ���");
		list.add( "΢�͹�ʽ����");
		list.add( "΢����ж����");
		list.add( "΢������ṹ����");
		list.add( "΢�Ͳ�դʽ����");
		list.add( "΢�ͳ������䳵");
		list.add( "΢����ʽ��ж����");
		list.add( "΢�͹�ʽ��ж����");
		list.add( "΢������ṹ��ж����");
		list.add( "΢�Ͳ�դʽ��ж����");
		list.add( "������ͨ����");
		list.add( "������ʽ����");
		list.add( "���ٹ�ʽ����");
		list.add( "��ж���ٻ���");
		list.add( "��դʽ���ٻ���");
		list.add( "��ʽ��ж���ٻ���");
		list.add( "��ʽ��ж���ٻ���");
		// Z��ͷ
		list.add( "����ר����ҵ��");
		list.add( "�����ػ�ר����ҵ��");
		list.add( "����ר����ҵ��");
		list.add( "�����ػ�ר����ҵ��");
		list.add( "С��ר����ҵ��");
		list.add( "С���ػ�ר����ҵ��");
		list.add( "΢��ר����ҵ��");
		list.add( "΢���ػ�ר����ҵ��");
		list.add( "����ר����ҵ��");
		list.add( "�����ػ�ר����ҵ��");
		list.add( "����ר����ҵ��");
		list.add( "�����ػ�ר����ҵ��");
		// D��ͷ
		list.add( "�޹�糵");
		list.add( "�й�糵");
		// M��ͷ
		list.add( "��ͨ������Ħ�г�");
		list.add( "���������Ħ�г�");
		list.add( "�������ؿ�Ħ�г�");
		list.add( "�������ػ�Ħ�г�");
		list.add( "������Ħ�г�");
		list.add( "��ͨ����Ħ�г�");
		list.add( "������Ħ�г�");
		// N��ͷ
		list.add( "��������");
		// Q��ͷ
		list.add( "���Ͱ��ǣ����");
		list.add( "����ȫ��ǣ����");
		list.add( "����ȫ��ǣ����");
		list.add( "���Ͱ��ǣ����");
		list.add( "���Ͱ��ǣ����");
		list.add( "����ȫ��ǣ����");
		// T��ͷ
		list.add( "������ʽ������");
		list.add( "С����ʽ������");
		list.add( "�ַ�������");
		list.add( "�ַ����������");
		// J��ͷ
		list.add( "��ʽװ�ػ�е");
		list.add( "��ʽ�ھ��е");
		list.add( "��ʽƽ�ػ�е");
		// G��ͷ
		list.add( "������ͨȫ�ҳ�");
		list.add( "������ʽȫ�ҳ�");
		list.add( "���͹�ʽȫ�ҳ�");
		list.add( "����ƽ��ȫ�ҳ�");
		list.add( "���ͼ�װ��ȫ�ҳ�");
		list.add( "������жȫ�ҳ�");
		list.add( "���Ͳ�դʽȫ�ҳ�");
		list.add( "�����þ�ȫ�ҳ�");
		list.add( "����ר����ҵȫ�ҳ�");
		list.add( "������ʽ��жȫ�ҳ�");
		list.add( "���͹�ʽ��жȫ�ҳ�");
		list.add( "����ƽ����жȫ�ҳ�");
		list.add( "���ͼ�װ����жȫ�ҳ�");
		list.add( "���Ͳ�դʽ��жȫ�ҳ�");
		list.add( "����ר����ҵ��жȫ�ҳ�");
		list.add( "������ͨȫ�ҳ�");
		list.add( "������ʽȫ�ҳ�");
		list.add( "���͹�ʽȫ�ҳ�");
		list.add( "����ƽ��ȫ�ҳ�");
		list.add( "���ͼ�װ��ȫ�ҳ�");
		list.add( "������жȫ�ҳ�");
		list.add( "���Ͳ�դʽȫ�ҳ�");
		list.add( "�����þ�ȫ�ҳ�");
		list.add( "����ר����ҵȫ�ҳ�");
		list.add( "������ʽ��жȫ�ҳ�");
		list.add( "���͹�ʽ��жȫ�ҳ�");
		list.add( "����ƽ����жȫ�ҳ�");
		list.add( "���ͼ�װ����жȫ�ҳ�");
		list.add( "���Ͳ�դʽ��жȫ�ҳ�");
		list.add( "����ר����ҵ��жȫ�ҳ�");
		list.add( "������ͨȫ�ҳ�");
		list.add( "������ʽȫ�ҳ�");
		list.add( "���͹�ʽȫ�ҳ�");
		list.add( "����ƽ��ȫ�ҳ�");
		list.add( "������жȫ�ҳ�");
		list.add( "���Ͳ�դʽȫ�ҳ�");
		list.add( "�����þ�ȫ�ҳ�");
		list.add( "����ר����ҵȫ�ҳ�");
		list.add( "������ʽ��жȫ�ҳ�");
		list.add( "���͹�ʽ��жȫ�ҳ�");
		list.add( "����ƽ����жȫ�ҳ�");
		list.add( "���ͼ�װ����жȫ�ҳ�");
		list.add( "���Ͳ�դʽ��жȫ�ҳ�");
		list.add( "����ר����ҵ��жȫ�ҳ�");
		// X��:ͷ
		list.add( "����");
		return list;
	}
	public static String GetCllxString(String cllx) {
		Map<String,String> maps =new HashMap<String, String>(); 
		// list.add(new Md_cartype("01", "΢��С���ؿ�����"));
		// list.add(new Md_cartype("02", "�����ؿ�����"));
		// list.add(new Md_cartype("03", "�����ؿ�����"));
		// list.add(new Md_cartype("04", "�ػ�����������ǣ����ҳ���"));
		// list.add(new Md_cartype("05", "Σ�ջ�ѧƷ���䳵"));

		// K��ͷ
		maps.put( "K33:�γ�"     ,"K33:�γ�"     );
		maps.put( "K11:������ͨ�ͳ�","K11:������ͨ�ͳ�");
		maps.put( "K12:����˫��ͳ�","K12:����˫��ͳ�");
		maps.put( "K13:�������̿ͳ�","K13:�������̿ͳ�");
		maps.put( "K14:���ͽ½ӿͳ�","K14:���ͽ½ӿͳ�");
		maps.put( "K15:����ԽҰ�ͳ�","K15:����ԽҰ�ͳ�");
		maps.put( "K16:���ͽγ�"  ,"K16:���ͽγ�"   );
		maps.put( "K17:����ר�ÿͳ�","K17:����ר�ÿͳ�");
		maps.put( "K18:����ר��У��","K18:����ר��У��");
		maps.put( "K21:������ͨ�ͳ�","K21:������ͨ�ͳ�");
		maps.put( "K22:����˫��ͳ�","K22:����˫��ͳ�");
		maps.put( "K23:�������̿ͳ�","K23:�������̿ͳ�");
		maps.put( "K24:���ͽ½ӿͳ�","K24:���ͽ½ӿͳ�");
		maps.put( "K25:����ԽҰ�ͳ�","K25:����ԽҰ�ͳ�");
		maps.put( "K26:���ͽγ�"   ,"K26:���ͽγ�"  );
		maps.put( "K27:����ר�ÿͳ�","K27:����ר�ÿͳ�");
		maps.put( "K28:����ר��У��","K28:����ר��У��");
		maps.put( "K31:С����ͨ�ͳ�","K31:С����ͨ�ͳ�");
		maps.put( "K32:С��ԽҰ�ͳ�","K32:С��ԽҰ�ͳ�");
		maps.put( "K34:С��ר�ÿͳ�","K34:С��ר�ÿͳ�");
		maps.put( "K38:С��ר��У��","K38:С��ר��У��");
		maps.put( "K39:С�������"	,"K39:С�������"  );
		maps.put( "K41:΢����ͨ�ͳ�","K41:΢����ͨ�ͳ�");
		maps.put( "K42:΢��ԽҰ�ͳ�","K42:΢��ԽҰ�ͳ�");
		maps.put( "K43:΢�ͽγ�"	,"K43:΢�ͽγ�"  );
		maps.put( "K49:΢�������"	,"K49:΢�������"	);
		// B��ͷ
		maps.put( "B1��������ͨ��ҳ�"	,"B1��������ͨ��ҳ�" );
		maps.put( "B12��������ʽ��ҳ�"	,"B12��������ʽ��ҳ�");
		maps.put( "B13:���͹�ʽ��ҳ�"	,"B13:���͹�ʽ��ҳ�");
		maps.put( "B14:����ƽ���ҳ�"	,"B14:����ƽ���ҳ�");
		maps.put( "B15�����ͼ�װ���ҳ�"	,"B15�����ͼ�װ���ҳ�");
		maps.put( "B16��������ж��ҳ�"	,"B16��������ж��ҳ�");
		maps.put( "B17����������ṹ��ҳ�"	,"B17����������ṹ��ҳ�"	);
		maps.put( "B18�����Ͳ�դʽ��ҳ�"	,"B18�����Ͳ�դʽ��ҳ�");
		maps.put( "B19�������þӰ�ҳ�"	,"B19�������þӰ�ҳ�");
		maps.put( "B1A������ר����ҵ��ҳ�","B1A������ר����ҵ��ҳ�");
		maps.put( "B1B�����͵�ƽ���ҳ�","B1B�����͵�ƽ���ҳ�");
		maps.put( "B1C�����ͳ��������ҳ�","B1C�����ͳ��������ҳ�");
		maps.put( "B1D�����͹�ʽ��ж��ҳ�", "B1D�����͹�ʽ��ж��ҳ�");
		maps.put( "B1E������ƽ����ж��ҳ�","B1E������ƽ����ж��ҳ�");
		maps.put( "B1F�����ͼ�װ����ж��ҳ�","B1F�����ͼ�װ����ж��ҳ�");
		maps.put( "B1G����������ṹ��ж��ҳ�","B1G����������ṹ��ж��ҳ�");
		maps.put( "B1H�����Ͳ�դʽ��ж��ҳ�","B1H�����Ͳ�դʽ��ж��ҳ�");
		maps.put( "B1J������ר����ҵ��ж��ҳ�","B1J������ר����ҵ��ж��ҳ�");
		maps.put( "B1K�����͵�ƽ����ж��ҳ�","B1K�����͵�ƽ����ж��ҳ�");
		maps.put( "B1U�������������þӹҳ�","B1U�������������þӹҳ�");
		maps.put( "B1V�����������ᳵ�����䳵","B1V�����������ᳵ�����䳵");
		maps.put( "B1W��������������ͨ�ҳ�","B1W��������������ͨ�ҳ�");
		maps.put( "B21��������ͨ��ҳ�","B21��������ͨ��ҳ�");
		maps.put( "B22��������ʽ��ҳ�", "B22��������ʽ��ҳ�");
		maps.put( "B23�����͹�ʽ��ҳ�", "B23�����͹�ʽ��ҳ�");
		maps.put( "B24������ƽ���ҳ�","B24������ƽ���ҳ�");
		maps.put( "B25�����ͼ�װ���ҳ�","B25�����ͼ�װ���ҳ�");
		maps.put( "B26��������ж��ҳ�","B26��������ж��ҳ�");
		maps.put( "B27����������ṹ��ҳ�","B27����������ṹ��ҳ�");
		maps.put( "B28�����Ͳ�դʽ��ҳ�", "B28�����Ͳ�դʽ��ҳ�");
		maps.put( "B29�������þӰ�ҳ�","B29�������þӰ�ҳ�");
		maps.put( "B2A������ר����ҵ��ҳ�","B2A������ר����ҵ��ҳ�");
		maps.put( "B2B�����͵�ƽ���ҳ�","B2B�����͵�ƽ���ҳ�");
		maps.put( "B2C�����ͳ��������ҳ�","B2C�����ͳ��������ҳ�");
		maps.put( "B2D�����͹�ʽ��ж��ҳ�","B2D�����͹�ʽ��ж��ҳ�");
		maps.put( "B2E������ƽ����ж��ҳ�","B2E������ƽ����ж��ҳ�");
		maps.put( "B2F�����ͼ�װ����ж��ҳ�","B2F�����ͼ�װ����ж��ҳ�");
		maps.put( "B2G����������ṹ��ж��ҳ�","B2G����������ṹ��ж��ҳ�");
		maps.put( "B2H�����Ͳ�դʽ��ж��ҳ�","B2H�����Ͳ�դʽ��ж��ҳ�");
		maps.put( "B2J������ר����ҵ��ж��ҳ�","B2J������ר����ҵ��ж��ҳ�");
		maps.put( "B2K�����͵�ƽ����ж��ҳ�", "B2K�����͵�ƽ����ж��ҳ�");
		maps.put( "B2U�������������þӹҳ�","B2U�������������þӹҳ�");
		maps.put( "B2V�����������ᳵ�����䳵","B2V�����������ᳵ�����䳵");
		maps.put( "B2W��������������ͨ�ҳ�","B2W��������������ͨ�ҳ�");
		maps.put( "B31��������ͨ��ҳ�","B31��������ͨ��ҳ�");
		maps.put( "B32��������ʽ��ҳ�","B32��������ʽ��ҳ�");
		maps.put( "B33�����͹�ʽ��ҳ�","B33�����͹�ʽ��ҳ�");
		maps.put( "B34������ƽ���ҳ�","B34������ƽ���ҳ�");
		maps.put( "B35��������ж��ҳ�","B35��������ж��ҳ�");
		maps.put( "B36�����Ͳ�դʽ��ҳ�","B36�����Ͳ�դʽ��ҳ�");
		maps.put( "B37�������þӰ�ҳ�","B37�������þӰ�ҳ�");
		maps.put( "B38������ר����ҵ��ҳ�","B38������ר����ҵ��ҳ�");
		maps.put( "B39�����͵�ƽ���ҳ�","B39�����͵�ƽ���ҳ�");
		maps.put( "B3C�����ͳ��������ҳ�","B3C�����ͳ��������ҳ�");
		maps.put( "B3D�����͹�ʽ��ж��ҳ�", "B3D�����͹�ʽ��ж��ҳ�");
		maps.put( "B3E������ƽ����ж��ҳ�","B3E������ƽ����ж��ҳ�");
		maps.put( "B3F�����ͼ�װ����ж��ҳ�","B3F�����ͼ�װ����ж��ҳ�");
		maps.put( "B3G����������ṹ��ж��ҳ�","B3G����������ṹ��ж��ҳ�");
		maps.put( "B3H�����Ͳ�դʽ��ж��ҳ�","B3H�����Ͳ�դʽ��ж��ҳ�");
		maps.put( "B3J������ר����ҵ��ж��ҳ�","B3J������ר����ҵ��ж��ҳ�");
		maps.put( "B3K�����͵�ƽ����ж��ҳ�","B3K�����͵�ƽ����ж��ҳ�");
		maps.put( "B3U�������������þӹҳ�","B3U�������������þӹҳ�");
		maps.put( "B3V�����������ᳵ�����䳵","B3V�����������ᳵ�����䳵");
		maps.put( "B3W��������������ͨ�ҳ�","B3W��������������ͨ�ҳ�");
		// H��ͷ
		maps.put( "H11��������ͨ����","H11��������ͨ����");
		maps.put( "H12��������ʽ����","H12��������ʽ����");
		maps.put( "H13�����ͷ�ջ���","H13�����ͷ�ջ���");
		maps.put( "H14�����͹�ʽ����","H14�����͹�ʽ����");
		maps.put( "H15������ƽ�����", "H15������ƽ�����");
		maps.put( "H16�����ͼ�װ�ᳵ","H16�����ͼ�װ�ᳵ");
		maps.put( "H17��������ж����","H17��������ж����");
		maps.put( "H18����������ṹ����","H18����������ṹ����");
		maps.put( "H19�����Ͳ�դʽ����","H19�����Ͳ�դʽ����");
		maps.put( "H1A�����ͳ������䳵","H1A�����ͳ������䳵");
		maps.put( "H1B��������ʽ��ж����","H1B��������ʽ��ж����");
		maps.put( "H1C�����͹�ʽ��ж����","H1C�����͹�ʽ��ж����");
		maps.put( "H1D������ƽ����ж����","H1D������ƽ����ж����");
		maps.put( "H1E�����ͼ�װ����ж����","H1E�����ͼ�װ����ж����");
		maps.put( "H1F����������ṹ��ж����","H1F����������ṹ��ж����");
		maps.put( "H1G�����Ͳ�դʽ��ж����","H1G�����Ͳ�դʽ��ж����");
		maps.put( "H21��������ͨ����","H21��������ͨ����");
		maps.put( "H22��������ʽ����", "H22��������ʽ����");
		maps.put( "H23�����ͷ�ջ���","H23�����ͷ�ջ���");
		maps.put( "H24�����͹�ʽ����","H24�����͹�ʽ����");
		maps.put( "H25:����ƽ�����","H25:����ƽ�����");
		maps.put( "H26:���ͼ�װ�ᳵ","H26:���ͼ�װ�ᳵ");
		maps.put( "H27:������ж����","H27:������ж����");
		maps.put( "H28:��������ṹ����","H28:��������ṹ����");
		maps.put( "H29:���Ͳ�դʽ����","H29:���Ͳ�դʽ����");
		maps.put( "H2A:���ͳ������䳵", "H2A:���ͳ������䳵");
		maps.put( "H2B:������ʽ��ж����","H2B:������ʽ��ж����");
		maps.put( "H2C:���͹�ʽ��ж����","H2C:���͹�ʽ��ж����");
		maps.put( "H2D������ƽ����ж����","H2D������ƽ����ж����");
		maps.put( "H2E:���ͼ�װ����ж����","H2E:���ͼ�װ����ж����");
		maps.put( "H2F:��������ṹ��ж����","H2F:��������ṹ��ж����");
		maps.put( "H2G:���Ͳ�դʽ��ж����","H2G:���Ͳ�դʽ��ж����");
		maps.put( "H31:������ͨ����", "H31:������ͨ����");
		maps.put( "H32:������ʽ����","H32:������ʽ����");
		maps.put( "H33:���ͷ�ջ���","H33:���ͷ�ջ���");
		maps.put( "H34:���͹�ʽ����","H34:���͹�ʽ����");
		maps.put( "H35:����ƽ�����","H35:����ƽ�����");
		maps.put( "H37:������ж����","H37:������ж����");
		maps.put( "H38:��������ṹ����", "H38:��������ṹ����");
		maps.put( "H39:���Ͳ�դʽ����","H39:���Ͳ�դʽ����");
		maps.put( "H39:���ͳ������䳵","H39:���ͳ������䳵");
		maps.put( "H3A:���ͳ������䳵","H3A:���ͳ������䳵");
		maps.put( "H3B:������ʽ��ж����","H3B:������ʽ��ж����");
		maps.put( "H3C:���͹�ʽ��ж����","H3C:���͹�ʽ��ж����");
		maps.put( "H3D:����ƽ����ж����","H3D:����ƽ����ж����");
		maps.put( "H3E:���ͼ�װ����ж����","H3E:���ͼ�װ����ж����");
		maps.put( "H3F:��������ṹ��ж����","H3F:��������ṹ��ж����");
		maps.put( "H3G:���Ͳ�դʽ��ж����","H3G:���Ͳ�դʽ��ж����");
		maps.put( "H41:΢����ͨ����","H41:΢����ͨ����");
		maps.put( "H42:΢����ʽ����","H42:΢����ʽ����");
		maps.put( "H43:΢�ͷ�ջ���", "H43:΢�ͷ�ջ���");
		maps.put( "H44:΢�͹�ʽ����","H44:΢�͹�ʽ����");
		maps.put( "H45:΢����ж����", "H45:΢����ж����");
		maps.put( "H46:΢������ṹ����","H46:΢������ṹ����");
		maps.put( "H47:΢�Ͳ�դʽ����","H47:΢�Ͳ�դʽ����");
		maps.put( "H4A:΢�ͳ������䳵","H4A:΢�ͳ������䳵");
		maps.put( "H4B:΢����ʽ��ж����","H4B:΢����ʽ��ж����");
		maps.put( "H4C:΢�͹�ʽ��ж����","H4C:΢�͹�ʽ��ж����");
		maps.put( "H4F:΢������ṹ��ж����","H4F:΢������ṹ��ж����");
		maps.put( "H4G:΢�Ͳ�դʽ��ж����","H4G:΢�Ͳ�դʽ��ж����");
		maps.put( "H51:������ͨ����","H51:������ͨ����");
		maps.put( "H52:������ʽ����","H52:������ʽ����");
		maps.put( "H53:���ٹ�ʽ����","H53:���ٹ�ʽ����");
		maps.put( "H54:��ж���ٻ���","H54:��ж���ٻ���");
		maps.put( "H55:��դʽ���ٻ���","H55:��դʽ���ٻ���");
		maps.put( "H5B:��ʽ��ж���ٻ���","H5B:��ʽ��ж���ٻ���");
		maps.put( "H5C:��ʽ��ж���ٻ���","H5C:��ʽ��ж���ٻ���");
		// Z��ͷ
		maps.put( "Z11:����ר����ҵ��","Z11:����ר����ҵ��");
		maps.put( "Z12:�����ػ�ר����ҵ��","Z12:�����ػ�ר����ҵ��");
		maps.put( "Z21:����ר����ҵ��","Z21:����ר����ҵ��");
		maps.put( "Z22:�����ػ�ר����ҵ��","Z22:�����ػ�ר����ҵ��");
		maps.put( "Z31:С��ר����ҵ��","Z31:С��ר����ҵ��");
		maps.put( "Z32:С���ػ�ר����ҵ��","Z32:С���ػ�ר����ҵ��");
		maps.put( "Z41:΢��ר����ҵ��","Z41:΢��ר����ҵ��");
		maps.put( "Z42:΢���ػ�ר����ҵ��","Z42:΢���ػ�ר����ҵ��");
		maps.put( "Z51:����ר����ҵ��","Z51:����ר����ҵ��");
		maps.put( "Z52:�����ػ�ר����ҵ��","Z52:�����ػ�ר����ҵ��");
		maps.put( "Z71:����ר����ҵ��","Z71:����ר����ҵ��");
		maps.put( "Z72:�����ػ�ר����ҵ��","Z72:�����ػ�ר����ҵ��");
		// D��ͷ
		maps.put( "D11:�޹�糵","D11:�޹�糵");
		maps.put( "D12:�й�糵","D12:�й�糵");
		// M��ͷ,"D12:�й�糵"
		maps.put( "M11:��ͨ������Ħ�г�","M11:��ͨ������Ħ�г�");
		maps.put( "M12:���������Ħ�г�","M12:���������Ħ�г�");
		maps.put( "M13:�������ؿ�Ħ�г�","M13:�������ؿ�Ħ�г�");
		maps.put( "M14:�������ػ�Ħ�г�","M14:�������ػ�Ħ�г�");
		maps.put( "M15:������Ħ�г�","M15:������Ħ�г�");
		maps.put( "M21:��ͨ����Ħ�г�","M21:��ͨ����Ħ�г�");
		maps.put( "M22:������Ħ�г�","M22:������Ħ�г�");
		// N��ͷ
		maps.put( "N11:��������","N11:��������");
		// Q��ͷ
		maps.put( "Q11:���Ͱ��ǣ����","Q11:���Ͱ��ǣ����");
		maps.put( "Q12:����ȫ��ǣ����","Q12:����ȫ��ǣ����");
		maps.put( "Q22:����ȫ��ǣ����","Q22:����ȫ��ǣ����");
		maps.put( "Q21:���Ͱ��ǣ����", "Q21:���Ͱ��ǣ����");
		maps.put( "Q31:���Ͱ��ǣ����","Q31:���Ͱ��ǣ����");
		maps.put( "Q32:����ȫ��ǣ����","Q32:����ȫ��ǣ����");
		// T��ͷ
		maps.put( "T11:������ʽ������","T11:������ʽ������");
		maps.put( "T21:С����ʽ������","T21:С����ʽ������");
		maps.put( "T22:�ַ�������","T22:�ַ�������");
		maps.put( "T23:�ַ����������","T23:�ַ����������");
		// J��ͷ
		maps.put( "J11:��ʽװ�ػ�е","J11:��ʽװ�ػ�е");
		maps.put( "J12:��ʽ�ھ��е","J12:��ʽ�ھ��е");
		maps.put( "J13:��ʽƽ�ػ�е","J13:��ʽƽ�ػ�е");
		// G��ͷ
		maps.put( "G11:������ͨȫ�ҳ�","G11:������ͨȫ�ҳ�");
		maps.put( "G12:������ʽȫ�ҳ�","G12:������ʽȫ�ҳ�");
		maps.put( "G13:���͹�ʽȫ�ҳ�","G13:���͹�ʽȫ�ҳ�");
		maps.put( "G14:����ƽ��ȫ�ҳ�","G14:����ƽ��ȫ�ҳ�");
		maps.put( "G15:���ͼ�װ��ȫ�ҳ�","G15:���ͼ�װ��ȫ�ҳ�");
		maps.put( "G16:������жȫ�ҳ�","G16:������жȫ�ҳ�");
		maps.put( "G17:���Ͳ�դʽȫ�ҳ�","G17:���Ͳ�դʽȫ�ҳ�");
		maps.put( "G18:�����þ�ȫ�ҳ�","G18:�����þ�ȫ�ҳ�");
		maps.put( "G19:����ר����ҵȫ�ҳ�","G19:����ר����ҵȫ�ҳ�");
		maps.put( "G1A:������ʽ��жȫ�ҳ�","G1A:������ʽ��жȫ�ҳ�");
		maps.put( "G1B:���͹�ʽ��жȫ�ҳ�","G1B:���͹�ʽ��жȫ�ҳ�");
		maps.put( "G1C:����ƽ����жȫ�ҳ�","G1C:����ƽ����жȫ�ҳ�");
		maps.put( "G1D:���ͼ�װ����жȫ�ҳ�","G1D:���ͼ�װ����жȫ�ҳ�");
		maps.put( "G1E:���Ͳ�դʽ��жȫ�ҳ�","G1E:���Ͳ�դʽ��жȫ�ҳ�");
		maps.put( "G1F:����ר����ҵ��жȫ�ҳ�","G1F:����ר����ҵ��жȫ�ҳ�");
		maps.put( "G21:������ͨȫ�ҳ�","G21:������ͨȫ�ҳ�");
		maps.put( "G22:������ʽȫ�ҳ�","G22:������ʽȫ�ҳ�");
		maps.put( "G23:���͹�ʽȫ�ҳ�","G23:���͹�ʽȫ�ҳ�");
		maps.put( "G24:����ƽ��ȫ�ҳ�" ,"G24:����ƽ��ȫ�ҳ�");
		maps.put( "G25:���ͼ�װ��ȫ�ҳ�","G25:���ͼ�װ��ȫ�ҳ�");
		maps.put( "G26:������жȫ�ҳ�", "G26:������жȫ�ҳ�");
		maps.put( "G27:���Ͳ�դʽȫ�ҳ�","G27:���Ͳ�դʽȫ�ҳ�");
		maps.put( "G28:�����þ�ȫ�ҳ�","G28:�����þ�ȫ�ҳ�");
		maps.put( "G29:����ר����ҵȫ�ҳ�","G29:����ר����ҵȫ�ҳ�");
		maps.put( "G2A:������ʽ��жȫ�ҳ�","G2A:������ʽ��жȫ�ҳ�");
		maps.put( "G2B:���͹�ʽ��жȫ�ҳ�","G2B:���͹�ʽ��жȫ�ҳ�");
		maps.put( "G2C:����ƽ����жȫ�ҳ�","G2C:����ƽ����жȫ�ҳ�");
		maps.put( "G2D:���ͼ�װ����жȫ�ҳ�","G2D:���ͼ�װ����жȫ�ҳ�");
		maps.put( "G2E:���Ͳ�դʽ��жȫ�ҳ�","G2E:���Ͳ�դʽ��жȫ�ҳ�");
		maps.put( "G2F:����ר����ҵ��жȫ�ҳ�","G2F:����ר����ҵ��жȫ�ҳ�");
		maps.put( "G31:������ͨȫ�ҳ�","G31:������ͨȫ�ҳ�");
		maps.put( "G32:������ʽȫ�ҳ�","G32:������ʽȫ�ҳ�");
		maps.put( "G33:���͹�ʽȫ�ҳ�","G33:���͹�ʽȫ�ҳ�");
		maps.put( "G34:����ƽ��ȫ�ҳ�","G34:����ƽ��ȫ�ҳ�");
		maps.put( "G35:������жȫ�ҳ�","G35:������жȫ�ҳ�");
		maps.put( "G36:���Ͳ�դʽȫ�ҳ�","G36:���Ͳ�դʽȫ�ҳ�");
		maps.put( "G37:�����þ�ȫ�ҳ�", "G37:�����þ�ȫ�ҳ�");
		maps.put( "G38:����ר����ҵȫ�ҳ�","G38:����ר����ҵȫ�ҳ�");
		maps.put( "G3A:������ʽ��жȫ�ҳ�", "G3A:������ʽ��жȫ�ҳ�");
		maps.put( "G3B:���͹�ʽ��жȫ�ҳ�","G3B:���͹�ʽ��жȫ�ҳ�");
		maps.put( "G3C:����ƽ����жȫ�ҳ�","G3C:����ƽ����жȫ�ҳ�");
		maps.put( "G3D:���ͼ�װ����жȫ�ҳ�", "G3D:���ͼ�װ����жȫ�ҳ�");
		maps.put( "G3E:���Ͳ�դʽ��жȫ�ҳ�","G3E:���Ͳ�դʽ��жȫ�ҳ�");
		maps.put( "G3F:����ר����ҵ��жȫ�ҳ�","G3F:����ר����ҵ��жȫ�ҳ�");
		// X��:ͷ
		maps.put( "X99:����","X99:����");
		
		
		// K��ͷ
		maps.put( "�γ�"     ,"K33:�γ�"     );
		maps.put( "������ͨ�ͳ�","K11:������ͨ�ͳ�");
		maps.put( "����˫��ͳ�","K12:����˫��ͳ�");
		maps.put( "�������̿ͳ�","K13:�������̿ͳ�");
		maps.put( "���ͽ½ӿͳ�","K14:���ͽ½ӿͳ�");
		maps.put( "����ԽҰ�ͳ�","K15:����ԽҰ�ͳ�");
		maps.put( "���ͽγ�"  ,"K16:���ͽγ�"   );
		maps.put( "����ר�ÿͳ�","K17:����ר�ÿͳ�");
		maps.put( "����ר��У��","K18:����ר��У��");
		maps.put( "������ͨ�ͳ�","K21:������ͨ�ͳ�");
		maps.put( "����˫��ͳ�","K22:����˫��ͳ�");
		maps.put( "�������̿ͳ�","K23:�������̿ͳ�");
		maps.put( "���ͽ½ӿͳ�","K24:���ͽ½ӿͳ�");
		maps.put( "����ԽҰ�ͳ�","K25:����ԽҰ�ͳ�");
		maps.put( "���ͽγ�"   ,"K26:���ͽγ�"  );
		maps.put( "����ר�ÿͳ�","K27:����ר�ÿͳ�");
		maps.put( "����ר��У��","K28:����ר��У��");
		maps.put( "С����ͨ�ͳ�","K31:С����ͨ�ͳ�");
		maps.put( "С��ԽҰ�ͳ�","K32:С��ԽҰ�ͳ�");
		maps.put( "С��ר�ÿͳ�","K34:С��ר�ÿͳ�");
		maps.put( "С��ר��У��","K38:С��ר��У��");
		maps.put( "С�������"	,"K39:С�������"  );
		maps.put( "΢����ͨ�ͳ�","K41:΢����ͨ�ͳ�");
		maps.put( "΢��ԽҰ�ͳ�","K42:΢��ԽҰ�ͳ�");
		maps.put( "΢�ͽγ�"	,"K43:΢�ͽγ�"  );
		maps.put( "΢�������"	,"K49:΢�������"	);
		// B��ͷ
		maps.put( "������ͨ��ҳ�"	,"B1��������ͨ��ҳ�" );
		maps.put( "������ʽ��ҳ�"	,"B12��������ʽ��ҳ�");
		maps.put( "���͹�ʽ��ҳ�"	,"B13:���͹�ʽ��ҳ�");
		maps.put( "����ƽ���ҳ�"	,"B14:����ƽ���ҳ�");
		maps.put( "���ͼ�װ���ҳ�"	,"B15�����ͼ�װ���ҳ�");
		maps.put( "������ж��ҳ�"	,"B16��������ж��ҳ�");
		maps.put( "��������ṹ��ҳ�"	,"B17����������ṹ��ҳ�"	);
		maps.put( "���Ͳ�դʽ��ҳ�"	,"B18�����Ͳ�դʽ��ҳ�");
		maps.put( "�����þӰ�ҳ�"	,"B19�������þӰ�ҳ�");
		maps.put( "����ר����ҵ��ҳ�","B1A������ר����ҵ��ҳ�");
		maps.put( "���͵�ƽ���ҳ�","B1B�����͵�ƽ���ҳ�");
		maps.put( "���ͳ��������ҳ�","B1C�����ͳ��������ҳ�");
		maps.put( "���͹�ʽ��ж��ҳ�", "B1D�����͹�ʽ��ж��ҳ�");
		maps.put( "����ƽ����ж��ҳ�","B1E������ƽ����ж��ҳ�");
		maps.put( "���ͼ�װ����ж��ҳ�","B1F�����ͼ�װ����ж��ҳ�");
		maps.put( "��������ṹ��ж��ҳ�","B1G����������ṹ��ж��ҳ�");
		maps.put( "���Ͳ�դʽ��ж��ҳ�","B1H�����Ͳ�դʽ��ж��ҳ�");
		maps.put( "����ר����ҵ��ж��ҳ�","B1J������ר����ҵ��ж��ҳ�");
		maps.put( "���͵�ƽ����ж��ҳ�","B1K�����͵�ƽ����ж��ҳ�");
		maps.put( "�����������þӹҳ�","B1U�������������þӹҳ�");
		maps.put( "���������ᳵ�����䳵","B1V�����������ᳵ�����䳵");
		maps.put( "������������ͨ�ҳ�","B1W��������������ͨ�ҳ�");
		maps.put( "������ͨ��ҳ�","B21��������ͨ��ҳ�");
		maps.put( "������ʽ��ҳ�", "B22��������ʽ��ҳ�");
		maps.put( "���͹�ʽ��ҳ�", "B23�����͹�ʽ��ҳ�");
		maps.put( "����ƽ���ҳ�","B24������ƽ���ҳ�");
		maps.put( "���ͼ�װ���ҳ�","B25�����ͼ�װ���ҳ�");
		maps.put( "������ж��ҳ�","B26��������ж��ҳ�");
		maps.put( "��������ṹ��ҳ�","B27����������ṹ��ҳ�");
		maps.put( "���Ͳ�դʽ��ҳ�", "B28�����Ͳ�դʽ��ҳ�");
		maps.put( "�����þӰ�ҳ�","B29�������þӰ�ҳ�");
		maps.put( "����ר����ҵ��ҳ�","B2A������ר����ҵ��ҳ�");
		maps.put( "���͵�ƽ���ҳ�","B2B�����͵�ƽ���ҳ�");
		maps.put( "���ͳ��������ҳ�","B2C�����ͳ��������ҳ�");
		maps.put( "���͹�ʽ��ж��ҳ�","B2D�����͹�ʽ��ж��ҳ�");
		maps.put( "����ƽ����ж��ҳ�","B2E������ƽ����ж��ҳ�");
		maps.put( "���ͼ�װ����ж��ҳ�","B2F�����ͼ�װ����ж��ҳ�");
		maps.put( "��������ṹ��ж��ҳ�","B2G����������ṹ��ж��ҳ�");
		maps.put( "���Ͳ�դʽ��ж��ҳ�","B2H�����Ͳ�դʽ��ж��ҳ�");
		maps.put( "����ר����ҵ��ж��ҳ�","B2J������ר����ҵ��ж��ҳ�");
		maps.put( "���͵�ƽ����ж��ҳ�", "B2K�����͵�ƽ����ж��ҳ�");
		maps.put( "�����������þӹҳ�","B2U�������������þӹҳ�");
		maps.put( "���������ᳵ�����䳵","B2V�����������ᳵ�����䳵");
		maps.put( "������������ͨ�ҳ�","B2W��������������ͨ�ҳ�");
		maps.put( "������ͨ��ҳ�","B31��������ͨ��ҳ�");
		maps.put( "������ʽ��ҳ�","B32��������ʽ��ҳ�");
		maps.put( "���͹�ʽ��ҳ�","B33�����͹�ʽ��ҳ�");
		maps.put( "����ƽ���ҳ�","B34������ƽ���ҳ�");
		maps.put( "������ж��ҳ�","B35��������ж��ҳ�");
		maps.put( "���Ͳ�դʽ��ҳ�","B36�����Ͳ�դʽ��ҳ�");
		maps.put( "�����þӰ�ҳ�","B37�������þӰ�ҳ�");
		maps.put( "����ר����ҵ��ҳ�","B38������ר����ҵ��ҳ�");
		maps.put( "���͵�ƽ���ҳ�","B39�����͵�ƽ���ҳ�");
		maps.put( "���ͳ��������ҳ�","B3C�����ͳ��������ҳ�");
		maps.put( "���͹�ʽ��ж��ҳ�", "B3D�����͹�ʽ��ж��ҳ�");
		maps.put( "����ƽ����ж��ҳ�","B3E������ƽ����ж��ҳ�");
		maps.put( "���ͼ�װ����ж��ҳ�","B3F�����ͼ�װ����ж��ҳ�");
		maps.put( "��������ṹ��ж��ҳ�","B3G����������ṹ��ж��ҳ�");
		maps.put( "���Ͳ�դʽ��ж��ҳ�","B3H�����Ͳ�դʽ��ж��ҳ�");
		maps.put( "����ר����ҵ��ж��ҳ�","B3J������ר����ҵ��ж��ҳ�");
		maps.put( "���͵�ƽ����ж��ҳ�","B3K�����͵�ƽ����ж��ҳ�");
		maps.put( "�����������þӹҳ�","B3U�������������þӹҳ�");
		maps.put( "���������ᳵ�����䳵","B3V�����������ᳵ�����䳵");
		maps.put( "������������ͨ�ҳ�","B3W��������������ͨ�ҳ�");
		// H��ͷ
		maps.put( "������ͨ����","H11��������ͨ����");
		maps.put( "������ʽ����","H12��������ʽ����");
		maps.put( "���ͷ�ջ���","H13�����ͷ�ջ���");
		maps.put( "���͹�ʽ����","H14�����͹�ʽ����");
		maps.put( "����ƽ�����", "H15������ƽ�����");
		maps.put( "���ͼ�װ�ᳵ","H16�����ͼ�װ�ᳵ");
		maps.put( "������ж����","H17��������ж����");
		maps.put( "��������ṹ����","H18����������ṹ����");
		maps.put( "���Ͳ�դʽ����","H19�����Ͳ�դʽ����");
		maps.put( "���ͳ������䳵","H1A�����ͳ������䳵");
		maps.put( "������ʽ��ж����","H1B��������ʽ��ж����");
		maps.put( "���͹�ʽ��ж����","H1C�����͹�ʽ��ж����");
		maps.put( "����ƽ����ж����","H1D������ƽ����ж����");
		maps.put( "���ͼ�װ����ж����","H1E�����ͼ�װ����ж����");
		maps.put( "��������ṹ��ж����","H1F����������ṹ��ж����");
		maps.put( "���Ͳ�դʽ��ж����","H1G�����Ͳ�դʽ��ж����");
		maps.put( "������ͨ����","H21��������ͨ����");
		maps.put( "������ʽ����", "H22��������ʽ����");
		maps.put( "���ͷ�ջ���","H23�����ͷ�ջ���");
		maps.put( "���͹�ʽ����","H24�����͹�ʽ����");
		maps.put( "����ƽ�����","H25:����ƽ�����");
		maps.put( "���ͼ�װ�ᳵ","H26:���ͼ�װ�ᳵ");
		maps.put( "������ж����","H27:������ж����");
		maps.put( "��������ṹ����","H28:��������ṹ����");
		maps.put( "���Ͳ�դʽ����","H29:���Ͳ�դʽ����");
		maps.put( "���ͳ������䳵", "H2A:���ͳ������䳵");
		maps.put( "������ʽ��ж����","H2B:������ʽ��ж����");
		maps.put( "���͹�ʽ��ж����","H2C:���͹�ʽ��ж����");
		maps.put( "����ƽ����ж����","H2D������ƽ����ж����");
		maps.put( "���ͼ�װ����ж����","H2E:���ͼ�װ����ж����");
		maps.put( "��������ṹ��ж����","H2F:��������ṹ��ж����");
		maps.put( "���Ͳ�դʽ��ж����","H2G:���Ͳ�դʽ��ж����");
		maps.put( "������ͨ����", "H31:������ͨ����");
		maps.put( "������ʽ����","H32:������ʽ����");
		maps.put( "���ͷ�ջ���","H33:���ͷ�ջ���");
		maps.put( "���͹�ʽ����","H34:���͹�ʽ����");
		maps.put( "����ƽ�����","H35:����ƽ�����");
		maps.put( "������ж����","H37:������ж����");
		maps.put( "��������ṹ����", "H38:��������ṹ����");
		maps.put( "���Ͳ�դʽ����","H39:���Ͳ�դʽ����");
		maps.put( "���ͳ������䳵","H39:���ͳ������䳵");
		maps.put( "���ͳ������䳵","H3A:���ͳ������䳵");
		maps.put( "������ʽ��ж����","H3B:������ʽ��ж����");
		maps.put( "���͹�ʽ��ж����","H3C:���͹�ʽ��ж����");
		maps.put( "����ƽ����ж����","H3D:����ƽ����ж����");
		maps.put( "���ͼ�װ����ж����","H3E:���ͼ�װ����ж����");
		maps.put( "��������ṹ��ж����","H3F:��������ṹ��ж����");
		maps.put( "���Ͳ�դʽ��ж����","H3G:���Ͳ�դʽ��ж����");
		maps.put( "΢����ͨ����","H41:΢����ͨ����");
		maps.put( "΢����ʽ����","H42:΢����ʽ����");
		maps.put( "΢�ͷ�ջ���", "H43:΢�ͷ�ջ���");
		maps.put( "΢�͹�ʽ����","H44:΢�͹�ʽ����");
		maps.put( "΢����ж����", "H45:΢����ж����");
		maps.put( "΢������ṹ����","H46:΢������ṹ����");
		maps.put( "΢�Ͳ�դʽ����","H47:΢�Ͳ�դʽ����");
		maps.put( "΢�ͳ������䳵","H4A:΢�ͳ������䳵");
		maps.put( "΢����ʽ��ж����","H4B:΢����ʽ��ж����");
		maps.put( "΢�͹�ʽ��ж����","H4C:΢�͹�ʽ��ж����");
		maps.put( "΢������ṹ��ж����","H4F:΢������ṹ��ж����");
		maps.put( "΢�Ͳ�դʽ��ж����","H4G:΢�Ͳ�դʽ��ж����");
		maps.put( "������ͨ����","H51:������ͨ����");
		maps.put( "������ʽ����","H52:������ʽ����");
		maps.put( "���ٹ�ʽ����","H53:���ٹ�ʽ����");
		maps.put( "��ж���ٻ���","H54:��ж���ٻ���");
		maps.put( "��դʽ���ٻ���","H55:��դʽ���ٻ���");
		maps.put( "��ʽ��ж���ٻ���","H5B:��ʽ��ж���ٻ���");
		maps.put( "��ʽ��ж���ٻ���","H5C:��ʽ��ж���ٻ���");
		// Z��ͷ
		maps.put( "����ר����ҵ��","Z11:����ר����ҵ��");
		maps.put( "�����ػ�ר����ҵ��","Z12:�����ػ�ר����ҵ��");
		maps.put( "����ר����ҵ��","Z21:����ר����ҵ��");
		maps.put( "�����ػ�ר����ҵ��","Z22:�����ػ�ר����ҵ��");
		maps.put( "С��ר����ҵ��","Z31:С��ר����ҵ��");
		maps.put( "С���ػ�ר����ҵ��","Z32:С���ػ�ר����ҵ��");
		maps.put( "΢��ר����ҵ��","Z41:΢��ר����ҵ��");
		maps.put( "΢���ػ�ר����ҵ��","Z42:΢���ػ�ר����ҵ��");
		maps.put( "����ר����ҵ��","Z51:����ר����ҵ��");
		maps.put( "�����ػ�ר����ҵ��","Z52:�����ػ�ר����ҵ��");
		maps.put( "����ר����ҵ��","Z71:����ר����ҵ��");
		maps.put( "�����ػ�ר����ҵ��","Z72:�����ػ�ר����ҵ��");
		// D��ͷ
		maps.put( "�޹�糵","D11:�޹�糵");
		maps.put( "�й�糵","D12:�й�糵");
		// M��ͷ,"D�й�糵"
		maps.put( "��ͨ������Ħ�г�","M11:��ͨ������Ħ�г�");
		maps.put( "���������Ħ�г�","M12:���������Ħ�г�");
		maps.put( "�������ؿ�Ħ�г�","M13:�������ؿ�Ħ�г�");
		maps.put( "�������ػ�Ħ�г�","M14:�������ػ�Ħ�г�");
		maps.put( "������Ħ�г�","M15:������Ħ�г�");
		maps.put( "��ͨ����Ħ�г�","M21:��ͨ����Ħ�г�");
		maps.put( "������Ħ�г�","M22:������Ħ�г�");
		// N��ͷ
		maps.put( "��������","N11:��������");
		// Q��ͷ
		maps.put( "���Ͱ��ǣ����","Q11:���Ͱ��ǣ����");
		maps.put( "����ȫ��ǣ����","Q12:����ȫ��ǣ����");
		maps.put( "����ȫ��ǣ����","Q22:����ȫ��ǣ����");
		maps.put( "���Ͱ��ǣ����", "Q21:���Ͱ��ǣ����");
		maps.put( "���Ͱ��ǣ����","Q31:���Ͱ��ǣ����");
		maps.put( "����ȫ��ǣ����","Q32:����ȫ��ǣ����");
		// T��ͷ
		maps.put( "������ʽ������","T11:������ʽ������");
		maps.put( "С����ʽ������","T21:С����ʽ������");
		maps.put( "�ַ�������","T22:�ַ�������");
		maps.put( "�ַ����������","T23:�ַ����������");
		// J��ͷ
		maps.put( "��ʽװ�ػ�е","J11:��ʽװ�ػ�е");
		maps.put( "��ʽ�ھ��е","J12:��ʽ�ھ��е");
		maps.put( "��ʽƽ�ػ�е","J13:��ʽƽ�ػ�е");
		// G��ͷ
		maps.put( "������ͨȫ�ҳ�","G11:������ͨȫ�ҳ�");
		maps.put( "������ʽȫ�ҳ�","G12:������ʽȫ�ҳ�");
		maps.put( "���͹�ʽȫ�ҳ�","G13:���͹�ʽȫ�ҳ�");
		maps.put( "����ƽ��ȫ�ҳ�","G14:����ƽ��ȫ�ҳ�");
		maps.put( "���ͼ�װ��ȫ�ҳ�","G15:���ͼ�װ��ȫ�ҳ�");
		maps.put( "������жȫ�ҳ�","G16:������жȫ�ҳ�");
		maps.put( "���Ͳ�դʽȫ�ҳ�","G17:���Ͳ�դʽȫ�ҳ�");
		maps.put( "�����þ�ȫ�ҳ�","G18:�����þ�ȫ�ҳ�");
		maps.put( "����ר����ҵȫ�ҳ�","G19:����ר����ҵȫ�ҳ�");
		maps.put( "������ʽ��жȫ�ҳ�","G1A:������ʽ��жȫ�ҳ�");
		maps.put( "���͹�ʽ��жȫ�ҳ�","G1B:���͹�ʽ��жȫ�ҳ�");
		maps.put( "����ƽ����жȫ�ҳ�","G1C:����ƽ����жȫ�ҳ�");
		maps.put( "���ͼ�װ����жȫ�ҳ�","G1D:���ͼ�װ����жȫ�ҳ�");
		maps.put( "���Ͳ�դʽ��жȫ�ҳ�","G1E:���Ͳ�դʽ��жȫ�ҳ�");
		maps.put( "����ר����ҵ��жȫ�ҳ�","G1F:����ר����ҵ��жȫ�ҳ�");
		maps.put( "������ͨȫ�ҳ�","G21:������ͨȫ�ҳ�");
		maps.put( "������ʽȫ�ҳ�","G22:������ʽȫ�ҳ�");
		maps.put( "���͹�ʽȫ�ҳ�","G23:���͹�ʽȫ�ҳ�");
		maps.put( "����ƽ��ȫ�ҳ�" ,"G24:����ƽ��ȫ�ҳ�");
		maps.put( "���ͼ�װ��ȫ�ҳ�","G25:���ͼ�װ��ȫ�ҳ�");
		maps.put( "������жȫ�ҳ�", "G26:������жȫ�ҳ�");
		maps.put( "���Ͳ�դʽȫ�ҳ�","G27:���Ͳ�դʽȫ�ҳ�");
		maps.put( "�����þ�ȫ�ҳ�","G28:�����þ�ȫ�ҳ�");
		maps.put( "����ר����ҵȫ�ҳ�","G29:����ר����ҵȫ�ҳ�");
		maps.put( "������ʽ��жȫ�ҳ�","G2A:������ʽ��жȫ�ҳ�");
		maps.put( "���͹�ʽ��жȫ�ҳ�","G2B:���͹�ʽ��жȫ�ҳ�");
		maps.put( "����ƽ����жȫ�ҳ�","G2C:����ƽ����жȫ�ҳ�");
		maps.put( "���ͼ�װ����жȫ�ҳ�","G2D:���ͼ�װ����жȫ�ҳ�");
		maps.put( "���Ͳ�դʽ��жȫ�ҳ�","G2E:���Ͳ�դʽ��жȫ�ҳ�");
		maps.put( "����ר����ҵ��жȫ�ҳ�","G2F:����ר����ҵ��жȫ�ҳ�");
		maps.put( "������ͨȫ�ҳ�","G31:������ͨȫ�ҳ�");
		maps.put( "������ʽȫ�ҳ�","G32:������ʽȫ�ҳ�");
		maps.put( "���͹�ʽȫ�ҳ�","G33:���͹�ʽȫ�ҳ�");
		maps.put( "����ƽ��ȫ�ҳ�","G34:����ƽ��ȫ�ҳ�");
		maps.put( "������жȫ�ҳ�","G35:������жȫ�ҳ�");
		maps.put( "���Ͳ�դʽȫ�ҳ�","G36:���Ͳ�դʽȫ�ҳ�");
		maps.put( "�����þ�ȫ�ҳ�", "G37:�����þ�ȫ�ҳ�");
		maps.put( "����ר����ҵȫ�ҳ�","G38:����ר����ҵȫ�ҳ�");
		maps.put( "������ʽ��жȫ�ҳ�", "G3A:������ʽ��жȫ�ҳ�");
		maps.put( "���͹�ʽ��жȫ�ҳ�","G3B:���͹�ʽ��жȫ�ҳ�");
		maps.put( "����ƽ����жȫ�ҳ�","G3C:����ƽ����жȫ�ҳ�");
		maps.put( "���ͼ�װ����жȫ�ҳ�", "G3D:���ͼ�װ����жȫ�ҳ�");
		maps.put( "���Ͳ�դʽ��жȫ�ҳ�","G3E:���Ͳ�դʽ��жȫ�ҳ�");
		maps.put( "����ר����ҵ��жȫ�ҳ�","G3F:����ר����ҵ��жȫ�ҳ�");
		// X��:ͷ
		maps.put( "����","X99:����");
		return maps.get(cllx);
	}
	/**
	 * ��ȡ ��������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_hpzl() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("02", "02:С����������"));
		list.add(new Md_cartype("01", "01:������������"));
		list.add(new Md_cartype("03", "03:ʹ����������"));
		list.add(new Md_cartype("04", "04:�����������"));
		list.add(new Md_cartype("05", "05:������������"));
		list.add(new Md_cartype("06", "06:�⼮��������"));
		list.add(new Md_cartype("07", "07:��������Ħ�г�����"));
		list.add(new Md_cartype("08", "08:���Ħ�г�����"));
		list.add(new Md_cartype("09", "09:ʹ��Ħ�г�����"));
		list.add(new Md_cartype("10", "10:���Ħ�г�����"));
		list.add(new Md_cartype("11", "11:����Ħ�г�����"));
		list.add(new Md_cartype("12", "12:�⼮Ħ�г�����"));
		list.add(new Md_cartype("13", "13:���ٳ�����"));
		list.add(new Md_cartype("14", "14:����������"));
		list.add(new Md_cartype("15", "15:�ҳ�����"));
		list.add(new Md_cartype("16", "16:������������"));
		list.add(new Md_cartype("17", "17:����Ħ�г�����"));
		list.add(new Md_cartype("18", "18:ʵ����������"));
		list.add(new Md_cartype("19", "19:ʵ��Ħ�г�����"));
		list.add(new Md_cartype("20", "20:��ʱ�뾳��������"));
		list.add(new Md_cartype("21", "21:��ʱ�뾳Ħ�г�����"));
		list.add(new Md_cartype("22", "22:��ʱ��ʻ������"));
		list.add(new Md_cartype("23", "23:������������"));
		list.add(new Md_cartype("24", "24:����Ħ�г�����"));
		list.add(new Md_cartype("25", "25:ԭũ������"));
		list.add(new Md_cartype("26", "26:��������������"));
		list.add(new Md_cartype("27", "27:���������������"));
		list.add(new Md_cartype("31", "31:�侯����"));
		list.add(new Md_cartype("32", "32:���Ӻ���"));
		list.add(new Md_cartype("41", "41:�޺���"));
		list.add(new Md_cartype("42", "42:�ٺ���"));
		list.add(new Md_cartype("43", "43:Ų�ú���"));
		list.add(new Md_cartype("99", "99:��������"));
		return list;
	}

	/**
	 * ��ȡ ʹ������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_syxz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("A", "A:��Ӫ��"));
		list.add(new Md_cartype("B", "B:��·����"));
		list.add(new Md_cartype("C", "C:��������"));
		list.add(new Md_cartype("D", "D:�������"));
		list.add(new Md_cartype("E", "E:���ο���"));
		list.add(new Md_cartype("F", "F:����"));
		list.add(new Md_cartype("G", "G:����"));
		list.add(new Md_cartype("H", "H:����"));
		list.add(new Md_cartype("I", "I:����"));
		list.add(new Md_cartype("J", "J:�Ȼ�"));
		list.add(new Md_cartype("K", "K:��������"));
		list.add(new Md_cartype("L", "L:Ӫת��"));
		list.add(new Md_cartype("M", "M:����ת��"));
		list.add(new Md_cartype("N", "N:����"));
		list.add(new Md_cartype("O", "O:�׶�У��"));
		list.add(new Md_cartype("P", "P:СѧУ��"));
		list.add(new Md_cartype("Q", "Q:����У��"));
		list.add(new Md_cartype("R", "R:Σ��Ʒ����"));
		list.add(new Md_cartype("Z", "Z:����"));
		return list;
	}

	/**
	 * ������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_qdz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "��ѡ��"));
		list.add(new Md_cartype("1", "1��"));
		list.add(new Md_cartype("2", "2��"));
		list.add(new Md_cartype("3", "3��"));
		list.add(new Md_cartype("4", "4��"));
		list.add(new Md_cartype("12", "1��2��"));
		list.add(new Md_cartype("23", "2��3��"));
		list.add(new Md_cartype("123", "1��2��3��"));
		list.add(new Md_cartype("34", "3��4��"));
		list.add(new Md_cartype("345", "3��4��5��"));
		list.add(new Md_cartype("0", "��"));
		return list;
	}

	public static List<Md_cartype> Get_qdxs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "��ѡ��"));
		list.add(new Md_cartype("2��1Ħ�г�", "2��1Ħ�г���1-1-2"));
		list.add(new Md_cartype("4��2ǰ����פ��", "4��2ǰ����פ����1-1-2"));
		list.add(new Md_cartype("4��2������פ��", "4��2������פ����2-1-2"));
		list.add(new Md_cartype("4��2ǰ��ǰפ��", "4��2ǰ��ǰפ����1-1-1"));
		list.add(new Md_cartype("4��4ȫ����פ��", "4��4ȫ����פ����12-1-2"));
		list.add(new Md_cartype("4��4ȫ������פ��", "4��4ȫ������פ����12-1-2"));
		list.add(new Md_cartype("6��2������פ�����", "6��2������פ����ң�2-1-2"));
		list.add(new Md_cartype("6��2������פ��", "6��2������פ����3-1-3"));
		list.add(new Md_cartype("6��2˫�󸡶�����פ��", "6��2˫�󸡶�����פ����23-1-2"));
		list.add(new Md_cartype("6��4˫����˫��פ��", "6��4˫����˫��פ����23-2-23"));
		list.add(new Md_cartype("6��4˫������˫��פ��", "6��4˫������˫��פ����23-2-23"));
		list.add(new Md_cartype("6��6ȫ����˫��פ��", "6��6ȫ����˫��פ����123-2-23"));
		list.add(new Md_cartype("8��4˫����˫��פ��", "8��4˫����˫��פ����34-2-34"));
		list.add(new Md_cartype("8��2������פ�����", "8��2������פ����ң�3-1-3"));
		list.add(new Md_cartype("8��4˫����˫��פ�����", "8��4˫����˫��פ����ң�23-2-23"));
		list.add(new Md_cartype("8��2������פ��ȫ��", "8��2������פ��ȫ�ң�4-1-4"));
		list.add(new Md_cartype("10��6����������פ��", "10��6����������פ����345-3-345"));
		list.add(new Md_cartype("10X4˫����˫��פ�����", "10X4˫����˫��פ����ң�34-2-34"));
		list.add(new Md_cartype("10X2������פ�����", "10X2������פ����ң�3-1-3"));
		list.add(new Md_cartype("12X4˫����˫��פ�����", "12X4˫����˫��פ����ң�34-2-34"));
		return list;
	}

	/**
	 * ��ȡ ȼ������
	 */
	public static List<Md_cartype> Get_rlzl() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("A", "����"));
		list.add(new Md_cartype("B", "����"));
		list.add(new Md_cartype("C", "��"));
		list.add(new Md_cartype("D", "�����"));
		list.add(new Md_cartype("E", "��Ȼ��"));
		list.add(new Md_cartype("F", "Һ��ʯ����"));
		list.add(new Md_cartype("L", "�״�"));
		list.add(new Md_cartype("M", "�Ҵ�"));
		list.add(new Md_cartype("N", "̫����"));
		list.add(new Md_cartype("O", "��϶���"));
		list.add(new Md_cartype("Y", "��"));
		list.add(new Md_cartype("Z", "����"));
		return list;
	}

	/**
	 * �Ƿ�
	 */
	public static List<Md_cartype> Get_is() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "��"));
		list.add(new Md_cartype("1", "��"));
		return list;
	}

	/**
	 * ����/����
	 */
	public static List<Md_cartype> Get_cjfj() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "����"));
		list.add(new Md_cartype("1", "����"));
		return list;
	}

	/**
	 * ����/����
	 */
	public static List<Md_cartype> Get_kzmz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "����"));
		list.add(new Md_cartype("1", "����"));
		return list;
	}

	/**
	 * ��ȡ ��ɫ��Ӧ
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_colors() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("J", "��"));
		list.add(new Md_cartype("A", "��"));
		list.add(new Md_cartype("B", "��"));
		list.add(new Md_cartype("C", "��"));
		list.add(new Md_cartype("D", "��"));
		list.add(new Md_cartype("E", "��"));
		list.add(new Md_cartype("F", "��"));
		list.add(new Md_cartype("G", "��"));
		list.add(new Md_cartype("H", "��"));
		list.add(new Md_cartype("I", "��"));
		list.add(new Md_cartype("Z", "����"));
		return list;
	}

	public static List<Md_cartype> Get_jcxdh() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "1����"));
		list.add(new Md_cartype("2", "2����"));
		list.add(new Md_cartype("3", "3����"));
		list.add(new Md_cartype("4", "4����"));
		list.add(new Md_cartype("5", "5����"));
		list.add(new Md_cartype("6", "6����"));
		list.add(new Md_cartype("7", "7����"));
		list.add(new Md_cartype("8", "8����"));
		list.add(new Md_cartype("9", "9����"));
		list.add(new Md_cartype("10", "10����"));
		list.add(new Md_cartype("11", "11����"));
		list.add(new Md_cartype("12", "12����"));
		list.add(new Md_cartype("13", "13����"));
		list.add(new Md_cartype("14", "14����"));
		list.add(new Md_cartype("15", "15����"));
		return list;
	}
	
	public static List<Md_cartype> Get_jycs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "1��"));
		list.add(new Md_cartype("2", "2��"));
		list.add(new Md_cartype("3", "3��"));
		list.add(new Md_cartype("4", "4��"));
		list.add(new Md_cartype("5", "5��"));
		list.add(new Md_cartype("6", "6��"));
		list.add(new Md_cartype("7", "7��"));
		return list;
	}

	/**
	 * ��ȡ ��ɫ��Ӧ��
	 * 
	 * @return
	 */
	public static String Get_colors2(String type) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("0", "��");
		resultMap.put("J", "��");
		resultMap.put("A", "��");
		resultMap.put("B", "��");
		resultMap.put("C", "��");
		resultMap.put("D", "��");
		resultMap.put("E", "��");
		resultMap.put("F", "��");
		resultMap.put("G", "��");
		resultMap.put("H", "��");
		resultMap.put("I", "��");
		resultMap.put("Z", "����");
		//resultMap.put(",", ",");
		return resultMap.get(type);
	}

	/**
	 * ��ȡ ��ɫ��Ӧ��
	 * 
	 * @return
	 */
	public static String Get_colors3(String type) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("��", "0");
		resultMap.put("��", "J");
		resultMap.put("��", "A");
		resultMap.put("��", "B");
		resultMap.put("��", "C");
		resultMap.put("��", "D");
		resultMap.put("��", "E");
		resultMap.put("��", "F");
		resultMap.put("��", "G");
		resultMap.put("��", "H");
		resultMap.put("��", "I");
		resultMap.put("����", "Z");
		//resultMap.put(",", ",");
		return resultMap.get(type);
	}

	/**
	 * ��ȡ ��ɫ��Ӧ��
	 * 
	 * @return
	 */
	public static String Get_dp(String type) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("�Ĵ�", "sc");
		resultMap.put("�㶫", "gdhs");
		resultMap.put("����", "bj");
		return resultMap.get(type);
	}

	/**
	 * ��ȡ ���ƶ�Ӧ
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_dz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "��ѡ��"));
		list.add(new Md_cartype("03", "����Զ����"));
		list.add(new Md_cartype("04", "���ƽ���"));
		list.add(new Md_cartype("05", "һ��Զ��"));
		list.add(new Md_cartype("01", "�ĵ�Զ����"));
		list.add(new Md_cartype("02", "�ĵ�Զ��"));
		list.add(new Md_cartype("00", "��"));
		return list;
	}

	/**
	 * ��ȡ�ƶ���Դ
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_zzly() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		//�ƶ���Դ���ӡ���ѡ��ѡ���Ĭ���ύnull
		list.add(new Md_cartype("","��ѡ��"));
		list.add(new Md_cartype("0", "��ѹ�ƶ�"));
		list.add(new Md_cartype("1", "Һѹ�ƶ�"));
		list.add(new Md_cartype("2", "�������ƶ�"));
		return list;
	}

	/**
	 * Զ�ⵥ������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_ygddtz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "��ѡ��"));
		list.add(new Md_cartype("", "��"));
		list.add(new Md_cartype("0", "���ܵ�������"));
		list.add(new Md_cartype("1", "��������"));
		return list;
	}

	/**
	 * Զ�ⵥ������
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_zxzxjxs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "��ѡ��"));
		list.add(new Md_cartype("", "��"));
		list.add(new Md_cartype("0", "��������"));
		list.add(new Md_cartype("1", "�Ƕ�������"));
		return list;
	}

	/**
	 * �Ƹ�
	 */
	public static List<Md_cartype> Get_dg() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		for (int i = 60; i <= 130; i += 5) {
			list.add(new Md_cartype(i + "", i + ""));
		}
		return list;
	}

	/**
	 * ·���ж���ʽ
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_pdfs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "MFDD�ж�"));
		list.add(new Md_cartype("1", "�ƶ������ж�"));
		return list;
	}

	/**
	 * �ȶ���
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_wdx() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "δ��ƫ"));
		list.add(new Md_cartype("2", "����ƫ"));
		list.add(new Md_cartype("3", "����ƫ"));
		return list;
	}

	/**
	 * Ӧ����������ʽ 0-�ֲ��ݣ�1-�Ų���
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_yjczfs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "�ֲ���"));
		list.add(new Md_cartype("1", "�Ų���"));
		return list;
	}

	/**
	 * 0-δ�죬1-�ϸ�2-���ϸ�
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jlpd() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "δ��"));
		list.add(new Md_cartype("1", "�ϸ�"));
		list.add(new Md_cartype("2", "���ϸ�"));
		return list;
	}
	public static List<Md_cartype> Get_jlpd3() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("�ϸ�", "�ϸ�"));
		list.add(new Md_cartype("���ϸ�", "���ϸ�"));
		return list;
	}
	/**
	 * 0-�����ã�1-�ϸ�2-���ϸ�
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jlpd2() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "������"));
		list.add(new Md_cartype("1", "�ϸ�"));
		list.add(new Md_cartype("2", "���ϸ�"));
		return list;
	}

	public static List<Md_cartype> Get_jccs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "1��"));
		list.add(new Md_cartype("2", "2��"));
		list.add(new Md_cartype("3", "3��"));
		list.add(new Md_cartype("4", "4��"));
		list.add(new Md_cartype("5", "5��"));
		list.add(new Md_cartype("6", "6��"));
		list.add(new Md_cartype("7", "7��"));
		list.add(new Md_cartype("8", "8��"));
		list.add(new Md_cartype("9", "9��"));
		list.add(new Md_cartype("10", "10��"));
		return list;
	}
	public static List<Md_cartype> Get_dgwz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "���"));
		list.add(new Md_cartype("1", "�ҵ�"));
		return list;
	}
	
	public static List<Md_cartype> Get_zcpd() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "20%"));
		list.add(new Md_cartype("1", "15%"));
		return list;
	}
/**
 * �޸���Ƭ����
 * 2016-1-5 11:37:22 chenyujin
 * @return
 */
	public static List<Md_cartype> Get_zpmc() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		int size = Md_Car_JYXM.Car_wgpzxm.size();
		Map<String, String> pzxm=SortMapByKey.sortMapByKey(Md_Car_JYXM.Car_wgpzxm);
	
		if (size > 0) {
			Set<Entry<String, String>> pzxms = pzxm
					.entrySet();
			for (Entry xm : pzxms) {
				list.add(new Md_cartype((String) xm.getKey(), (String) xm.getKey()+":"+(String) xm
						.getValue()));
			}
		}
		// else {
		// list.add(new Md_cartype("01", "��������ʻ֤"));
		// list.add(new Md_cartype("02", "��������֤�����"));
		// list.add(new Md_cartype("03", "��������ͨ�¹�����ǿ�Ʊ���ƾ֤"));
		// list.add(new Md_cartype("04", "��������ȫ�������鱨�浥"));
		// list.add(new Md_cartype("05", "�����������¼��"));
		// list.add(new Md_cartype("06", "����˰��˰������˰֤��"));
		// list.add(new Md_cartype("07", "ί�к˷�����ϸ��־֪ͨ��"));
		// list.add(new Md_cartype("08", "��������Ȩ��"));
		// list.add(new Md_cartype("11", "��ǰб��45����Ƭ"));
		// list.add(new Md_cartype("12", "����б��45����Ƭ"));
		// list.add(new Md_cartype("13", "����ʶ�������Ƭ"));
		// list.add(new Md_cartype("14", "������������Ƭ"));
		// list.add(new Md_cartype("15", "������ǰ�������Ƭ"));
		// list.add(new Md_cartype("16", "�������Ƭ"));
		// list.add(new Md_cartype("17", "��ȫ�ִ���Ƭ"));
		// list.add(new Md_cartype("18", "��ʻ��¼�ǻ�GPS��Ƭ"));
		// list.add(new Md_cartype("19", "�������Ż����Ա�ǩ"));
		// list.add(new Md_cartype("20", "��ȫ������Ƭ"));
		// list.add(new Md_cartype("21", "�ƹ⹤λ������Ƭ"));
		// list.add(new Md_cartype("22", "�ƶ���λ������Ƭ"));
		// list.add(new Md_cartype("23", "���̹�λ������Ƭ"));
		// list.add(new Md_cartype("24", "���Ǿ�ʾ��"));
		// list.add(new Md_cartype("25", "�˿��š�Ӧ���ţ�����"));
		// list.add(new Md_cartype("26", "У����־��"));
		// list.add(new Md_cartype("27", "������"));
		// list.add(new Md_cartype("28", "У����־�ƺ�ͣ��ָʾ��־"));
		// list.add(new Md_cartype("29", "�չ���Ա����"));
		// list.add(new Md_cartype("30", "����������װ��ͼ�α�־"));
		// list.add(new Md_cartype("31", "�˿���Ӧ������"));
		// list.add(new Md_cartype("32", "�������Զ����װ��"));
		// list.add(new Md_cartype("33", "ǰ����ʽ�ƶ���"));
		// list.add(new Md_cartype("34", "ABS�Լ�״̬��"));
		// list.add(new Md_cartype("35", "�м������ݸ���װ�ú��Զ�������"));
		// list.add(new Md_cartype("36", "��̥����ͺ�"));
		// list.add(new Md_cartype("37", "���ͷ��������ͻ���װ�ü�����ϵͳ"));
		// list.add(new Md_cartype("38", "У�������̿ͳ��ĳ�����¼����ϵͳ"));
		// list.add(new Md_cartype("39", "У���ĸ�������װ��"));
		// list.add(new Md_cartype("40", "�����������ƶ�װ��"));
		// list.add(new Md_cartype("41", "·����Ƭ"));
		// list.add(new Md_cartype("42", "��ȫ�ִ����ര"));
		// list.add(new Md_cartype("90", "���ɸְ�Ƭ��"));
		// list.add(new Md_cartype("99", "��Ƭ"));
		// }
		return list;
	}

	public static List<Md_cartype> Get_xh() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "һ����"));
		list.add(new Md_cartype("2", "������"));
		list.add(new Md_cartype("3", "������"));
		list.add(new Md_cartype("4", "�ĺ���"));
		list.add(new Md_cartype("5", "�����"));
		list.add(new Md_cartype("6", "������"));
		list.add(new Md_cartype("7", "�ߺ���"));
		list.add(new Md_cartype("8", "�˺���"));
		list.add(new Md_cartype("9", "�ź���"));
		list.add(new Md_cartype("10", "ʮ����"));
		list.add(new Md_cartype("11", "ʮһ����"));
		list.add(new Md_cartype("12", "ʮ������"));
		list.add(new Md_cartype("13", "ʮ������"));
		list.add(new Md_cartype("14", "ʮ�ĺ���"));
		return list;
	}

	// ������־
	public static List<Md_cartype> Get_hbbz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("4��", "4��"));
		list.add(new Md_cartype("�Ʊ�", "�Ʊ�"));
		list.add(new Md_cartype("���Ǳ�", "���Ǳ�"));
		list.add(new Md_cartype("1��", "1��"));
		list.add(new Md_cartype("2��", "2��"));
		list.add(new Md_cartype("3��", "3��"));
		list.add(new Md_cartype("5��", "5��"));
		list.add(new Md_cartype("�綯��", "�綯��"));
		return list;
	}

	// ȼ��
	public static List<Md_cartype> Get_rylb() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("LPG", "LPG"));
		list.add(new Md_cartype("��Ȼ��", "��Ȼ��"));
		list.add(new Md_cartype("����", "����"));

		return list;
	}

	public static List<Md_cartype> Get_pfbz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("��4", "��4"));
		list.add(new Md_cartype("��1ǰ", "��1ǰ"));
		list.add(new Md_cartype("��1", "��1"));
		list.add(new Md_cartype("��2", "��2"));
		list.add(new Md_cartype("��3", "��3"));
		list.add(new Md_cartype("��5", "��5"));
		list.add(new Md_cartype("��", "��"));
		return list;
	}

	public static List<Md_cartype> Get_clyt() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("����", "����"));

		return list;
	}

	public static List<Md_cartype> Get_gyfs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("�ջ�", "�ջ�"));
		list.add(new Md_cartype("������", "������"));
		list.add(new Md_cartype("����������", "����������"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("��", "��"));
		return list;
	}

	public static List<Md_cartype> Get_jqfs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("��ѹ", "��ѹ"));
		list.add(new Md_cartype("��", "��"));
		return list;
	}

	public static List<Md_cartype> Get_sfsfqszxz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "��"));
		list.add(new Md_cartype("1", "��"));
		return list;
	}

	public static List<Md_cartype> Get_pdsf() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("��", "��"));
		list.add(new Md_cartype("��", "��"));
		return list;
	}

	public static List<Md_cartype> Get_hbjcbz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("���ɼ���", "���ɼ���"));
		list.add(new Md_cartype("˫����", "˫����"));
		list.add(new Md_cartype("����", "����"));
		list.add(new Md_cartype("��", "��"));
		return list;
	}

	public static List<Md_cartype> Get_sfgz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("�޸���", "�޸���"));
		list.add(new Md_cartype("�Ƹ���", "�Ƹ���"));
		list.add(new Md_cartype("�Ƹ����׼�", "�Ƹ����׼�"));
		return list;
	}

	public static List<Md_cartype> Get_bsx() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("�ֶ�", "�ֶ�"));
		list.add(new Md_cartype("�Զ�", "�Զ�"));
		return list;
	}

	/**
	 * ������Ŀ��������
	 * 
	 * @return
	 */
	public static Map<String, View> Get_clgg(Context context) {
		Map<String, View> map = new HashMap<String, View>();
		map.put("1", new InfoItemEdt(context, "����������", null, "notice_BH", 1,
				null, false));
		map.put("2", new InfoItemEdt(context, "����Ʒ��", null, "notice_CLPP1", 1,
				null, false));
		map.put("3", new InfoItemEdt(context, "Ӣ��Ʒ��", null, "notice_CLPP2", 1,
				null, false));
		map.put("4", new InfoItemEdt(context, "�����ͺ�", null, "notice_CLXH", 1,
				null, false));
		map.put("5", new InfoItemEdt(context, "��ҵID", null, "notice_QYID", 1,
				null, false));
		map.put("6", new InfoItemEdt(context, "������ַ", null, "notice_SCDZ", 1,
				null, false));
		map.put("7", new InfoItemEdt(context, "�������ͺ�", null, "notice_FDJXH", 1,
				null, false));
		map.put("8", new InfoItemEdt(context, "ʶ���������", null, "notice_SBDHXL",
				1, null, false));
		map.put("9", new InfoItemEdt(context, "��������", null, "notice_CLLX", 1,
				null, false));
		map.put("10", new InfoItemEdt(context, "�����", null, "notice_ZZG", 1,
				null, false));
		map.put("11", new InfoItemEdt(context, "ת����ʽ", null, "notice_ZXXS", 1,
				null, false));
		map.put("12", new InfoItemEdt(context, "ȼ������", null, "notice_RLZL", 1,
				null, false));
		map.put("13", new InfoItemEdt(context, "����", " ml", "notice_PL", 2,
				"^[0-9]{1,5}$", false));
		map.put("14", new InfoItemEdt(context, "����", "KW", "notice_GL", 2,
				"^[0-9]{1,5}$", false));
		map.put("15", new InfoItemEdt(context, "������", " mm", "notice_CWKC", 2,
				"^[0-9]{1,5}$", false));
		map.put("16", new InfoItemEdt(context, "������", " mm", "notice_CWKK", 2,
				"^[0-9]{1,5}$", false));
		map.put("17", new InfoItemEdt(context, "������", " mm", "notice_CWKG", 2,
				"^[0-9]{1,5}$", false));
		map.put("18", new InfoItemEdt(context, "�����ڲ���", " mm", "notice_HXNBCD",
				2, "^[0-9]{1,5}$", false));
		map.put("19", new InfoItemEdt(context, "�����ڲ���", " mm", "notice_HXNBKD",
				2, "^[0-9]{1,5}$", false));
		map.put("20", new InfoItemEdt(context, "�����ڲ���", " mm", "notice_HXNBGD",
				2, "^[0-9]{1,5}$", false));
		map.put("21", new InfoItemEdt(context, "�ְ嵯��Ƭ��", " ��", "notice_GBTHPS",
				2, "^[0-9]{1,5}$", false));
		map.put("22", new InfoItemEdt(context, "����", " ��", "notice_ZS", 2,
				"^[0-9]{1,5}$", false));
		map.put("23", new InfoItemEdt(context, "���", " mm", "notice_ZJ", 2,
				"^[0-9]{1,5}$", false));
		map.put("24", new InfoItemEdt(context, "ǰ�־�", " mm", "notice_QLJ", 2,
				"^[0-9]{1,5}$", false));
		map.put("25", new InfoItemEdt(context, "���־�", " mm", "notice_HLJ", 2,
				"^[0-9]{1,5}$", false));
		map.put("26", new InfoItemEdt(context, "��̥��", " ��", "notice_LTS", 2,
				"^[0-9]{1,5}$", false));
		map.put("27", new InfoItemEdt(context, "��̥���", null, "notice_LTGG", 1,
				null, false));
		map.put("28", new InfoItemEdt(context, "������", " kg", "notice_ZZL",
				2 | 8192, "^[0-9\\.]{1,5}$", false));
		map.put("29", new InfoItemEdt(context, "��������", " kg", "notice_ZBZL",
				2 | 8192, "^[0-9\\.]{1,5}$", false));
		map.put("30", new InfoItemEdt(context, "�˶�������", "  kg ",
				"notice_HDZZL", 2 | 8192, "^[0-9\\.]{1,6}$", false));
		map.put("31", new InfoItemEdt(context, "׼ǣ��������", "  kg",
				"notice_ZQYZL", 2 | 8192, "^[0-9\\.]{1,6}$", false));
		map.put("32", new InfoItemEdt(context, "��ؿ�", " ��", "notice_HDZK", 2,
				"^[0-9]{1,5}$", false));
		map.put("33", new InfoItemEdt(context, "ǰ��ʻ��׼������", " ��", "notice_QPZK",
				2, "^[0-9]{1,5}$", false));
		map.put("34", new InfoItemEdt(context, "���ʻ��׼������", " ��", "notice_HPZK",
				2, "^[0-9]{1,5}$", false));
		map.put("35", new InfoItemEdt(context, "��������", null, "notice_PC", 1,
				null, false));
		map.put("36", new InfoItemEdt(context, "����ID", null, "notice_DPID", 2,
				"^[0-9]{1,5}$", false));
		map.put("37", new InfoItemEdt(context, "����������", null, "notice_HBDBQK",
				1, null, false));
		map.put("38", new InfoItemEdt(context, "���淢������", null, "notice_CSLX",
				1, null, false));
		map.put("39", new InfoItemEdt(context, "��������", null, "notice_GXRQ", 1,
				null, false));
		map.put("40", new InfoItemEdt(context, "��ע", null, "notice_BZ", 1,
				null, false));
		map.put("41", new InfoItemEdt(context, "����������ҵ����", null,
				"notice_ZZCMC", 1, null, false));
		map.put("42", new InfoItemEdt(context, "���淢������", null, "notice_GGRQ",
				1, null, false));
		map.put("43", new InfoItemEdt(context, "�Ƿ����", null, "notice_SFMJ", 1,
				null, false));
		map.put("44", new InfoItemEdt(context, "������Ч����", null, "notice_CXSXRQ",
				1, null, false));
		map.put("45", new InfoItemEdt(context, "������ҵ���ͺ�", null, "DPQYXH", 1,
				null, false));
		map.put("46", new InfoItemEdt(context, "��Ʒ���", null, "notice_CPLB", 1,
				null, false));
		map.put("47", new InfoItemEdt(context, "У��λ", null, "notice_JYW", 1,
				null, false));
		map.put("48", new InfoItemEdt(context, "���͹�����", null, "notice_CLGGBH",
				1, null, false));
		map.put("49", new InfoItemEdt(context, "�Ƿ�����ע��", null, "notice_SFYXZC",
				1, null, false));
		map.put("50", new InfoItemEdt(context, "������Ч����", null, "notice_GGSXRQ",
				1, null, false));
		map.put("51", new InfoItemEdt(context, "������Ч�ڱ��", null,
				"notice_GGYXQBJ", 1, null, false));
		map.put("52", new InfoItemEdt(context, "������������", null, "notice_CXGGPC",
				1, null, false));
		map.put("53", new InfoItemEdt(context, "�������淢������", null,
				"notice_CXGGRQ", 1, null, false));
		map.put("54", new InfoItemEdt(context, "ֹͣ��������", null, "notice_TZSCRQ",
				1, null, false));
		map.put("55", new InfoItemEdt(context, "��Ч������", null, "notice_YXQMS",
				1, null, false));
		map.put("56", new InfoItemEdt(context, "��Ƭ��", " ��", "notice_ZPS", 1,
				null, false));
		map.put("57", new InfoItemEdt(context, "�����Ч��ֹ", null, "notice_MJYXQZ",
				1, null, false));
		map.put("58", new InfoItemEdt(context, "�����־��ҵ", null, "notice_FGBSQY",
				1, null, false));
		map.put("59", new InfoItemEdt(context, "�����־�̱�", null, "notice_FGBSSB",
				1, null, false));
		map.put("60", new InfoItemEdt(context, "�����־�ͺ�", null, "notice_FGBSXH",
				1, null, false));
		map.put("61",
				new InfoItemEdt(context, "���", "kg", "ZH", 1, null, false));
		map.put("62", new InfoItemEdt(context, "����������ϵ��", null,
				"notice_ZZLLYXS", 1, null, false));
		map.put("63", new InfoItemEdt(context, "��Ұ����������������", "kg",
				"notice_BGAZZDYXZZL", 1, null, false));
		map.put("64", new InfoItemEdt(context, "�ӽ���ȥ��", null, "notice_JJLQJ",
				1, null, false));
		map.put("65", new InfoItemEdt(context, "ǰ������", null, "notice_QXHX", 1,
				null, false));
		map.put("66", new InfoItemEdt(context, "��ʻ������", null, "notice_JSSLX",
				1, null, false));
		map.put("67", new InfoItemEdt(context, "������ʽ", null, "notice_CDXS", 1,
				null, false));
		map.put("68", new InfoItemEdt(context, "��߳���", " km/h", "notice_ZGCS",
				1, null, false));
		map.put("69",
				new InfoItemEdt(context, "�ͺ�", " L", "YH", 1, null, false));
		map.put("70", new InfoItemEdt(context, "ǰ�ƶ���ʽ", null, "notice_QZDFS",
				1, null, false));
		map.put("71", new InfoItemEdt(context, "���ƶ���ʽ", null, "notice_HZDFS",
				1, null, false));
		map.put("72", new InfoItemEdt(context, "ǰ�ƶ�������ʽ", null,
				"notice_QZDCZFS", 1, null, false));
		map.put("73", new InfoItemEdt(context, "���ƶ�������ʽ", null,
				"notice_HZDCZFS", 1, null, false));
		map.put("74", new InfoItemEdt(context, "��������ҵ", null, "notice_FDJQY",
				1, null, false));
		map.put("75", new InfoItemEdt(context, "�������̱�", null, "notice_FDJSB",
				1, null, false));
		map.put("76", new InfoItemEdt(context, "�Ƿ��������ϵͳ", null,
				"notice_YWABS", 1, null, false));
		map.put("77", new InfoItemEdt(context, "��������", null, "notice_CLMC", 1,
				null, false));
		map.put("78", new InfoItemEdt(context, "��ҵ����", null, "notice_QYDM", 1,
				null, false));
		map.put("79", new InfoItemEdt(context, "������ ", null, "notice_GGBJ", 1,
				null, false));
		return map;
	}

}

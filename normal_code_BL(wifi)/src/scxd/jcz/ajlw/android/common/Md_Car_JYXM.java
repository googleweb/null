package scxd.jcz.ajlw.android.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.widget.Toast;

import scxd.jcz.ajlw.android.Activity.Init_Activity;
import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.model.Md_system;
import scxd.jcz.ajlw.android.model.RgjyItem;
/**
 * ����������Ŀ���ݻ�ȡ��
 * @author Administrator
 *@createtime
 */
public class Md_Car_JYXM {

	public static String message = "";

	public static void init() {

		// initCarWGPZXM3();
		initCarWGJYXM();
		initCarWGJYXM2();
		initCarWGJYXM3();
		initCarDPJYXM();
		initCarDPJYXM2();
		initCarDPJYXM3();
		initCarDTDPJYXM();
		initCarDTDPJYXM2();
		initCarDTDPJYXM3();
		initCarCYXM();
		initCarCYXMXC();

		initWgjyfl();
		initWgjyfl2();
		initWgjyfl3();
		initDtdpjyfl();
		initDtdpjyfl2();
		initDtdpjyfl3();
		initDpjyfl();
		initDpjyfl2();
		initDpjyfl3();
		initCytyfl();
		initCyxcfl();

		initWgjyXml();
		initWgjyXml2();
		initWgjyXml3();
		initDpjyXml();
		initDpjyXml2();
		initDpjyXml3();
		initDtdpjyXml();
		initDtdpjyXml2();
		initDtdpjyXml3();
		initCytyxml();
		initCyxcxml();
		/********** Ħ�г� **********/
		initMtWGJYXM3();
		initmt_wgjyxml();
		init_mt_Wgjyfl3();
		mt_dtdpjyxm();
		mt_initDtdpjyfl3();
		initMtDTDPJYXM3();
		initmt_dpjyxml();
		initMtDPJYXM3();
		initmt_Dpjyfl3();
	}

	public static Map<String, String> Car_wgpzxm = null;

	public static Map<String, String> Car_wgjyxml = null;
	public static Map<String, String> Car_wgjyxm = null;
	public static Map<String, String> Car_wgjyxml2 = null;
	public static Map<String, String> Car_wgjyxm2 = null;
	public static Map<String, String> Car_wgjyxml3 = null;
	public static Map<String, String> Car_wgjyxm3 = null;

	public static Map<String, String> Car_dpjyxml = null;
	public static Map<String, String> Car_dpjyxm = null;
	public static Map<String, String> Car_dpjyxml2 = null;
	public static Map<String, String> Car_dpjyxm2 = null;
	public static Map<String, String> Car_dpjyxml3 = null;
	public static Map<String, String> Car_dpjyxm3 = null;

	public static Map<String, String> Car_dtdpjyxml = null;
	public static Map<String, String> Car_dtdpjyxm = null;
	public static Map<String, String> Car_dtdpjyxml2 = null;
	public static Map<String, String> Car_dtdpjyxm2 = null;
	public static Map<String, String> Car_dtdpjyxml3 = null;
	public static Map<String, String> Car_dtdpjyxm3 = null;

	public static Map<String, String> Car_cyxm = null;
	public static Map<String, String> Car_cyxml = null;

	public static Map<String, String> Car_cyxmxc = null;
	public static Map<String, String> Car_cyxmxcl = null;

	/*********** Ħ�г� ************/
	public static Map<String, String> mt_wgjyxml = null;
	public static Map<String, String> mt_wgjyxml3 = null;
	public static Map<String, String> mt_dpjyxml = null;
	public static Map<String, String> mt_dpjyxml3 = null;
	public static Map<String, String> mt_dtdpjyxm = null;
	public static Map<String, String> mt_dtdpjyxm3 = null;

	public static void initMtDPJYXM3() {
		if (mt_dpjyxml3 == null || mt_dpjyxml3.isEmpty()) {
			mt_dpjyxml3 = null;
			mt_dpjyxml3 = new HashMap<String, String>();
			mt_dpjyxml3.put("046", "����");
			mt_dpjyxml3.put("047", "������·�̶�");
			mt_dpjyxml3.put("048", "�����ܩ~  ");
			mt_dpjyxml3.put("049", "�������~  ");
			mt_dpjyxml3.put("050", "ȼ���䡢ȼ�Ϲ�·�~");

		}
	}

	public static void initMtDTDPJYXM3() {
		if (mt_dtdpjyxm3 == null || mt_dtdpjyxm3.isEmpty()) {
			mt_dtdpjyxm3 = null;
			mt_dtdpjyxm3 = new HashMap<String, String>();
			mt_dtdpjyxm3.put("039", "ת��������ת��*");
			mt_dtdpjyxm3.put("040", "�������������ת������*");
			mt_dtdpjyxm3.put("041", "������Ӻ����");
			mt_dtdpjyxm3.put("042", "����������");
			mt_dtdpjyxm3.put("043", "������/��������������");
			mt_dtdpjyxm3.put("044", "���ſ���");
			mt_dtdpjyxm3.put("045", "�ƶ�����");
		}
	}

	public static void initMtWGJYXM3() {
		if (mt_wgjyxml3 == null || mt_wgjyxml3.isEmpty()) {
			mt_wgjyxml3 = null;
			mt_wgjyxml3 = new HashMap<String, String>();
			mt_wgjyxml3.put("001", "���Ƽ���װ ");
			mt_wgjyxml3.put("002", "�������͡�Ʒ��/�ͺ�");
			mt_wgjyxml3.put("003", "������ɫ");
			mt_wgjyxml3.put("004", "vin (�����������)");
			mt_wgjyxml3.put("005", "��������");
			mt_wgjyxml3.put("006", "��Ҫ��������������   ");
			mt_wgjyxml3.put("007", "���Ӿ�*        ");
			mt_wgjyxml3.put("008", "�細�������~   ");
			mt_wgjyxml3.put("009", "��ˮ�����~ ");
			mt_wgjyxml3.put("010", "���ᡢ��ȫ�ܡ� ");
			mt_wgjyxml3.put("011", "����   ");
			mt_wgjyxml3.put("012", "�Ǳ�");
			mt_wgjyxml3.put("013", "ǰ�յƣ�Զ�����⣩*  ");
			mt_wgjyxml3.put("014", "ת���źŵƣ�ǰ����*");
			mt_wgjyxml3.put("015", "��λ��*�������յ�*       ");
			mt_wgjyxml3.put("016", "�ƶ���*    ");
			mt_wgjyxml3.put("017", "������*");
			mt_wgjyxml3.put("018", "�෴����");
			mt_wgjyxml3.put("019", "����*           ");
			mt_wgjyxml3.put("020", "��̥�ͺŹ�� ");
			mt_wgjyxml3.put("021", "��̥�������");
			mt_wgjyxml3.put("022", "̥������/����/ĥ��/����  ");
			mt_wgjyxml3.put("023", "��̥��˨ ��");
			mt_wgjyxml3.put("024", "ǰ�������     ");
			mt_wgjyxml3.put("025", "ת���ϡ�������~");
			mt_wgjyxml3.put("026", "�����*     ");
			mt_wgjyxml3.put("027", "���桢���֣������������ŵ� ");
			mt_wgjyxml3.put("028", "�����  ");
			mt_wgjyxml3.put("029", "�Ǳ�����������*         ");
			mt_wgjyxml3.put("030", "������Ʒ����*          ");
			mt_wgjyxml3.put("031", "����3c��־");
			mt_wgjyxml3.put("032", "���������Ϲ涨����     ");
			mt_wgjyxml3.put("033", "������*      ");
			mt_wgjyxml3.put("034", "����       ");
			mt_wgjyxml3.put("035", "��Դ���     ");
			mt_wgjyxml3.put("036", "�Ǳ�ָʾ��");
			mt_wgjyxml3.put("037", "�����ְ�/̤�����     ");
			mt_wgjyxml3.put("038", "���ͳ�ͣ��װ�á� ");
		}
	}

	public static void mt_dtdpjyxm() {
		if (mt_dtdpjyxm == null || mt_dtdpjyxm.isEmpty()) {
			mt_dtdpjyxm = null;
			mt_dtdpjyxm = new HashMap<String, String>();
			mt_dtdpjyxm.put("039", "rzxlzj");
			mt_dtdpjyxm.put("040", "rfxpzdl");
			mt_dtdpjyxm.put("041", "rlhqjh");
			mt_dtdpjyxm.put("042", "rbsqhd");
			mt_dtdpjyxm.put("043", "rcdzl");
			mt_dtdpjyxm.put("044", "rymkz");
			mt_dtdpjyxm.put("045", "rzdxn");
		}
	}

	public static void initmt_dpjyxml() {
		if (mt_dpjyxml == null || mt_dpjyxml.isEmpty()) {
			mt_dpjyxml = null;
			mt_dpjyxml = new HashMap<String, String>();
			mt_dpjyxml.put("046", "rcj");
			mt_dpjyxml.put("047", "rdqxlgd");
			mt_dpjyxml.put("048", "rpqg");
			mt_dpjyxml.put("049", "rxsq");
			mt_dpjyxml.put("050", "rrlx");
		}
	}

	public static void initmt_wgjyxml() {
		if (mt_wgjyxml == null || mt_wgjyxml.isEmpty()) {
			mt_wgjyxml = null;
			mt_wgjyxml = new HashMap<String, String>();
			mt_wgjyxml.put("001", "rhpaz");
			mt_wgjyxml.put("002", "rppxh");
			mt_wgjyxml.put("003", "rcsys");
			mt_wgjyxml.put("004", "rvin");
			mt_wgjyxml.put("005", "rfdjh");
			mt_wgjyxml.put("006", "rjscs");
			mt_wgjyxml.put("007", "rhsj");
			mt_wgjyxml.put("008", "rfcbl");
			mt_wgjyxml.put("009", "rgsq");
			mt_wgjyxml.put("010", "rhx");
			mt_wgjyxml.put("011", "rqm");
			mt_wgjyxml.put("012", "ryb");
			mt_wgjyxml.put("013", "rqzd");
			mt_wgjyxml.put("014", "rzxxhd");
			mt_wgjyxml.put("015", "rhwd");
			mt_wgjyxml.put("016", "rzdd");
			mt_wgjyxml.put("017", "rfsq");
			mt_wgjyxml.put("018", "rcfsq");
			mt_wgjyxml.put("019", "rlb");
			mt_wgjyxml.put("020", "rltgg");
			mt_wgjyxml.put("021", "rlthw");
			mt_wgjyxml.put("022", "rtmqk");
			mt_wgjyxml.put("023", "rltlx");
			mt_wgjyxml.put("024", "rjzq");
			mt_wgjyxml.put("025", "rzxlb");
			mt_wgjyxml.put("026", "rfxb");
			mt_wgjyxml.put("027", "rzdfs");
			mt_wgjyxml.put("028", "rdnb");
			mt_wgjyxml.put("029", "rybsl");
			mt_wgjyxml.put("030", "rclcpbp");
			mt_wgjyxml.put("031", "rccc");
			mt_wgjyxml.put("032", "rqt");
			mt_wgjyxml.put("033", "rqdxn");
			mt_wgjyxml.put("034", "rds");
			mt_wgjyxml.put("035", "rdycd");
			mt_wgjyxml.put("036", "rybzs");
			mt_wgjyxml.put("037", "rjssb");
			mt_wgjyxml.put("038", "rcyctjzz");
		}
	}

	public static void initCyxcxml() {
		if (Car_cyxmxcl == null || Car_cyxmxcl.isEmpty()) {
			Car_cyxmxcl = null;
			Car_cyxmxcl = new HashMap<String, String>();
			Car_cyxmxcl.put("01", "cyxm1");
			Car_cyxmxcl.put("02", "cyxm2");
			Car_cyxmxcl.put("03", "cyxm3");
			Car_cyxmxcl.put("04", "cyxm4");
			Car_cyxmxcl.put("05", "cyxm5");
			Car_cyxmxcl.put("06", "cyxm6");
			Car_cyxmxcl.put("07", "cyxm7");
			Car_cyxmxcl.put("08", "cyxm8");
			Car_cyxmxcl.put("09", "cyxm9");
			Car_cyxmxcl.put("10", "cyxm10");
			Car_cyxmxcl.put("11", "cyxm11");
			Car_cyxmxcl.put("12", "cyxm12");
			Car_cyxmxcl.put("13", "cyxm13");
			Car_cyxmxcl.put("14", "cyxm14");
			Car_cyxmxcl.put("15", "cyxm15");
			Car_cyxmxcl.put("16", "cyxm16");
			Car_cyxmxcl.put("17", "cyxm17");
			Car_cyxmxcl.put("18", "cyxm18");
			Car_cyxmxcl.put("19", "cyxm19");
			Car_cyxmxcl.put("20", "cyxm20");
			Car_cyxmxcl.put("21", "cyxm21");
			Car_cyxmxcl.put("22", "cyxm22");
		}
	}

	public static void initCytyxml() {
		if (Car_cyxml == null || Car_cyxml.isEmpty()) {
			Car_cyxml = null;
			Car_cyxml = new HashMap<String, String>();
			Car_cyxml.put("01", "cyxm1");
			Car_cyxml.put("02", "cyxm2");
			Car_cyxml.put("03", "cyxm3");
			Car_cyxml.put("04", "cyxm4");
			Car_cyxml.put("05", "cyxm5");
			Car_cyxml.put("06", "cyxm6");
			Car_cyxml.put("07", "cyxm7");
			Car_cyxml.put("08", "cyxm8");
			Car_cyxml.put("09", "cyxm9");
			Car_cyxml.put("10", "cyxm10");
			Car_cyxml.put("11", "cyxm11");
			Car_cyxml.put("12", "cyxm12");
			Car_cyxml.put("13", "cyxm13");
			Car_cyxml.put("14", "cyxm14");
			Car_cyxml.put("15", "cyxm15");
			Car_cyxml.put("16", "cyxm16");
			Car_cyxml.put("17", "cyxm17");
			Car_cyxml.put("18", "cyxm18");
			Car_cyxml.put("19", "cyxm19");
			Car_cyxml.put("20", "cyxm20");
		}
	}

	public static void initDtdpjyXml() {
		if (Car_dtdpjyxml == null || Car_dtdpjyxml.isEmpty()) {
			Car_dtdpjyxml = null;
			Car_dtdpjyxml = new HashMap<String, String>();
			Car_dtdpjyxml.put("072", "rfxpzdl");
			Car_dtdpjyxml.put("073", "rzxcz");
			Car_dtdpjyxml.put("074", "rzjhz");
			Car_dtdpjyxml.put("075", "rlhq");
			Car_dtdpjyxml.put("076", "rbsq");
			Car_dtdpjyxml.put("077", "rcdzl");
			Car_dtdpjyxml.put("078", "rqdq");
			Car_dtdpjyxml.put("079", "rdzdpp");
			Car_dtdpjyxml.put("080", "rdqybjzz");
			Car_dtdpjyxml.put("081", "rthcn");
			Car_dtdpjyxml.put("082", "rfbzdzz");
			Car_dtdpjyxml.put("083", "rybzsq");
		}

	}

	public static void initDtdpjyXml2() {
		if (Car_dtdpjyxml2 == null || Car_dtdpjyxml2.isEmpty()) {
			Car_dtdpjyxml2 = null;
			Car_dtdpjyxml2 = new HashMap<String, String>();
			Car_dtdpjyxml2.put("41", "rzxx");
			Car_dtdpjyxml2.put("42", "rcdx");
			Car_dtdpjyxml2.put("43", "rzdx");
			Car_dtdpjyxml2.put("44", "rybzsq");
		}
	}

	public static void initDtdpjyXml3() {
		if (Car_dtdpjyxml3 == null || Car_dtdpjyxml3.isEmpty()) {
			Car_dtdpjyxml3 = null;
			Car_dtdpjyxml3 = new HashMap<String, String>();
			Car_dtdpjyxml3.put("41", "rzxx");
			Car_dtdpjyxml3.put("42", "rcdx");
			Car_dtdpjyxml3.put("43", "rzdx");
			Car_dtdpjyxml3.put("44", "rybzsq");
			Car_dtdpjyxml3.put("072", "rfxpzdl");
			Car_dtdpjyxml3.put("073", "rzxcz");
			Car_dtdpjyxml3.put("074", "rzjhz");
			Car_dtdpjyxml3.put("075", "rlhq");
			Car_dtdpjyxml3.put("076", "rbsq");
			Car_dtdpjyxml3.put("077", "rcdzl");
			Car_dtdpjyxml3.put("078", "rqdq");
			Car_dtdpjyxml3.put("079", "rdzdpp");
			Car_dtdpjyxml3.put("080", "rdqybjzz");
			Car_dtdpjyxml3.put("081", "rthcn");
			Car_dtdpjyxml3.put("082", "rfbzdzz");
			Car_dtdpjyxml3.put("083", "rybzsq");
		}
	}

	public static void initDpjyXml() {
		if (Car_dpjyxml == null || Car_dpjyxml.isEmpty()) {
			Car_dpjyxml = null;
			Car_dpjyxml = new HashMap<String, String>();
			Car_dpjyxml.put("084", "rzxqgd");
			Car_dpjyxml.put("085", "rzxbj");
			Car_dpjyxml.put("086", "rbsqzj");
			Car_dpjyxml.put("087", "rfdqzj");
			Car_dpjyxml.put("088", "rcdbj");
			Car_dpjyxml.put("089", "rgbde");
			Car_dpjyxml.put("090", "rdex");
			Car_dpjyxml.put("091", "rzxlx");
			Car_dpjyxml.put("092", "ruxlx");
			Car_dpjyxml.put("093", "rcqyw");
			Car_dpjyxml.put("094", "rcjzl");
			Car_dpjyxml.put("095", "rcjhl");
			Car_dpjyxml.put("096", "rxjgx");
			Car_dpjyxml.put("097", "rzdxbj");
			Car_dpjyxml.put("098", "rzdzg");
			Car_dpjyxml.put("099", "rzdrglh");
			Car_dpjyxml.put("100", "rzdglgd");
			Car_dpjyxml.put("101", "rdqxljc");
			Car_dpjyxml.put("102", "rfdjgd");
			Car_dpjyxml.put("103", "rpqg");
			Car_dpjyxml.put("104", "rrlgl");
		}
	}

	public static void initDpjyXml2() {
		if (Car_dpjyxml2 == null || Car_dpjyxml2.isEmpty()) {
			Car_dpjyxml2 = null;
			Car_dpjyxml2 = new HashMap<String, String>();
			Car_dpjyxml2.put("45", "rzxxbj");
			Car_dpjyxml2.put("46", "rcdxbj");
			Car_dpjyxml2.put("47", "rxsxbj");
			Car_dpjyxml2.put("48", "rzdxbj");
			Car_dpjyxml2.put("49", "rqtbj");
		}
	}

	public static void initDpjyXml3() {
		if (Car_dpjyxml3 == null || Car_dpjyxml.isEmpty()) {
			Car_dpjyxml3 = null;
			Car_dpjyxml3 = new HashMap<String, String>();
			Car_dpjyxml3.put("45", "rzxxbj");
			Car_dpjyxml3.put("46", "rcdxbj");
			Car_dpjyxml3.put("47", "rxsxbj");
			Car_dpjyxml3.put("48", "rzdxbj");
			Car_dpjyxml3.put("49", "rqtbj");
			Car_dpjyxml3.put("084", "rzxqgd");
			Car_dpjyxml3.put("085", "rzxbj");
			Car_dpjyxml3.put("086", "rbsqzj");
			Car_dpjyxml3.put("087", "rfdqzj");
			Car_dpjyxml3.put("088", "rcdbj");
			Car_dpjyxml3.put("089", "rgbde");
			Car_dpjyxml3.put("090", "rdex");
			Car_dpjyxml3.put("091", "rzxlx");
			Car_dpjyxml3.put("092", "ruxlx");
			Car_dpjyxml3.put("093", "rcqyw");
			Car_dpjyxml3.put("094", "rcjzl");
			Car_dpjyxml3.put("095", "rcjhl");
			Car_dpjyxml3.put("096", "rxjgx");
			Car_dpjyxml3.put("097", "rzdxbj");
			Car_dpjyxml3.put("098", "rzdzg");
			Car_dpjyxml3.put("099", "rzdrglh");
			Car_dpjyxml3.put("100", "rzdglgd");
			Car_dpjyxml3.put("101", "rdqxljc");
			Car_dpjyxml3.put("102", "rfdjgd");
			Car_dpjyxml3.put("103", "rpqg");
			Car_dpjyxml3.put("104", "rrlgl");
		}
	}

	public static void initWgjyXml2() {
		if (Car_wgjyxml2 == null || Car_wgjyxml2.isEmpty()) {
			Car_wgjyxml2 = null;
			Car_wgjyxml2 = new HashMap<String, String>();
			Car_wgjyxml2.put("01", "rhplx");
			Car_wgjyxml2.put("02", "rppxh");
			Car_wgjyxml2.put("03", "rvin");
			Car_wgjyxml2.put("04", "rfdjh");
			Car_wgjyxml2.put("05", "rcsys");
			Car_wgjyxml2.put("06", "rwkcc");
			Car_wgjyxml2.put("07", "rzj");
			Car_wgjyxml2.put("08", "rzbzl");
			Car_wgjyxml2.put("09", "rhdzrs");
			Car_wgjyxml2.put("10", "rhdzll");
			Car_wgjyxml2.put("11", "rlbgd");
			Car_wgjyxml2.put("12", "rhzgbthps");
			Car_wgjyxml2.put("13", "rkcyjck");
			Car_wgjyxml2.put("14", "rkccktd");
			Car_wgjyxml2.put("15", "rhx");
			Car_wgjyxml2.put("16", "rcswg");
			Car_wgjyxml2.put("17", "rwgbs");
			Car_wgjyxml2.put("18", "rwbzm");
			Car_wgjyxml2.put("19", "rlt");
			Car_wgjyxml2.put("20", "rhpaz");
			Car_wgjyxml2.put("21", "rjzgj");
			Car_wgjyxml2.put("22", "rqcaqd");
			Car_wgjyxml2.put("23", "rsjp");
			Car_wgjyxml2.put("24", "rmhq");
			Car_wgjyxml2.put("25", "rxsjly");
			Car_wgjyxml2.put("26", "rcsfgbs");
			Car_wgjyxml2.put("27", "rclwbzb");
			Car_wgjyxml2.put("28", "rchfh");
			Car_wgjyxml2.put("29", "ryjc");
			Car_wgjyxml2.put("30", "rjjx");
			Car_wgjyxml2.put("31", "rxsgn");
			Car_wgjyxml2.put("32", "rfbs");
			Car_wgjyxml2.put("33", "rfzzd");
			Car_wgjyxml2.put("34", "rpszdq");
			Car_wgjyxml2.put("35", "rjjqd");
			Car_wgjyxml2.put("36", "rfdjcmh");
			Car_wgjyxml2.put("37", "rsddd");
			Car_wgjyxml2.put("38", "rfzdtb");
			Car_wgjyxml2.put("39", "rxcbz");
			Car_wgjyxml2.put("40", "rwxhwbz");
			Car_wgjyxml2.put("80", "rlwcx");
			Car_wgjyxml2.put("81", "ztcjrfzzz");
		}
	}

	public static void initWgjyXml() {
		if (Car_wgjyxml == null || Car_wgjyxml.isEmpty()) {
			Car_wgjyxml = null;
			Car_wgjyxml = new HashMap<String, String>();
			Car_wgjyxml.put("001", "rclhp");
			Car_wgjyxml.put("002", "rppxh");
			Car_wgjyxml.put("003", "rcsys");
			Car_wgjyxml.put("004", "rvin");
			Car_wgjyxml.put("005", "rfdjh");
			Car_wgjyxml.put("006", "rjscs");
			Car_wgjyxml.put("007", "rbxg");
			Car_wgjyxml.put("008", "rhsj");
			Car_wgjyxml.put("009", "rccbl");
			Car_wgjyxml.put("010", "rctzz");
			Car_wgjyxml.put("011", "rqm");
			Car_wgjyxml.put("012", "rhx");
			Car_wgjyxml.put("013", "rcsgg");
			Car_wgjyxml.put("014", "rjzzz");
			Car_wgjyxml.put("015", "rccc");
			Car_wgjyxml.put("016", "rqt");
			Car_wgjyxml.put("017", "rqwd");
			Car_wgjyxml.put("018", "rhpzd");
			Car_wgjyxml.put("019", "rskd");
			Car_wgjyxml.put("020", "rzxxhd");
			Car_wgjyxml.put("021", "rqzd");
			Car_wgjyxml.put("022", "rzdd");
			Car_wgjyxml.put("023", "rhfsq");
			Car_wgjyxml.put("024", "rhwd");
			Car_wgjyxml.put("025", "rdcd");
			Car_wgjyxml.put("026", "rwxbz");
			Car_wgjyxml.put("027", "rtzbz");
			Car_wgjyxml.put("028", "rfjdj");
			Car_wgjyxml.put("029", "rlb");
			Car_wgjyxml.put("030", "rfgbs");
			Car_wgjyxml.put("031", "rfdjjj");
			Car_wgjyxml.put("032", "rxdc");
			Car_wgjyxml.put("033", "rdqdx");
			Car_wgjyxml.put("034", "ryyzd");
			Car_wgjyxml.put("035", "rfdjbs");
			Car_wgjyxml.put("036", "rmsjl");
			Car_wgjyxml.put("037", "rjsyzy");
			Car_wgjyxml.put("038", "raqd");
			Car_wgjyxml.put("039", "rfcblbw");
			Car_wgjyxml.put("040", "rgsq");
			Car_wgjyxml.put("041", "rxdq");
			Car_wgjyxml.put("042", "rxsjly");
			Car_wgjyxml.put("043", "rjss");
			Car_wgjyxml.put("044", "rybsllx");
			Car_wgjyxml.put("045", "rczj");
			Car_wgjyxml.put("046", "rjgxwz");
			Car_wgjyxml.put("047", "rclcpbp");
			Car_wgjyxml.put("048", "rqd");
			Car_wgjyxml.put("049", "rdsyb");
			Car_wgjyxml.put("050", "rjstbkz");
			Car_wgjyxml.put("051", "rlsy");
			Car_wgjyxml.put("052", "rgdxh");
			Car_wgjyxml.put("053", "rzywp");
			Car_wgjyxml.put("054", "rfswphl");
			Car_wgjyxml.put("055", "rcxd");
			Car_wgjyxml.put("056", "rkcdb");
			Car_wgjyxml.put("057", "rwhq");
			Car_wgjyxml.put("058", "raqd2");
			Car_wgjyxml.put("059", "raqck");
			Car_wgjyxml.put("060", "rcktd");
			Car_wgjyxml.put("061", "rrlx");
			Car_wgjyxml.put("062", "rdnb");
			Car_wgjyxml.put("063", "rpwf");
			Car_wgjyxml.put("064", "rgbth");
			Car_wgjyxml.put("065", "rchfh");
			Car_wgjyxml.put("066", "rqyljzz");
			Car_wgjyxml.put("067", "rltgg");
			Car_wgjyxml.put("068", "rlthw");
			Car_wgjyxml.put("069", "rltls");
			Car_wgjyxml.put("070", "rbtbs");
			Car_wgjyxml.put("071", "rqtbfx");
		}
	}

	public static void initWgjyXml3() {
		if (Car_wgjyxml3 == null || Car_wgjyxml3.isEmpty()) {
			Car_wgjyxml3 = null;
			Car_wgjyxml3 = new HashMap<String, String>();
			Car_wgjyxml3.put("01", "rhplx");
			Car_wgjyxml3.put("02", "rppxh");
			Car_wgjyxml3.put("03", "rvin");
			Car_wgjyxml3.put("04", "rfdjh");
			Car_wgjyxml3.put("05", "rcsys");
			Car_wgjyxml3.put("06", "rwkcc");
			Car_wgjyxml3.put("07", "rzj");
			Car_wgjyxml3.put("08", "rzbzl");
			Car_wgjyxml3.put("09", "rhdzrs");
			Car_wgjyxml3.put("10", "rhdzll");
			Car_wgjyxml3.put("11", "rlbgd");
			Car_wgjyxml3.put("12", "rhzgbthps");
			Car_wgjyxml3.put("13", "rkcyjck");
			Car_wgjyxml3.put("14", "rkccktd");
			Car_wgjyxml3.put("15", "rhx");
			Car_wgjyxml3.put("16", "rcswg");
			Car_wgjyxml3.put("17", "rwgbs");
			Car_wgjyxml3.put("18", "rwbzm");
			Car_wgjyxml3.put("19", "rlt");
			Car_wgjyxml3.put("20", "rhpaz");
			Car_wgjyxml3.put("21", "rjzgj");
			Car_wgjyxml3.put("22", "rqcaqd");
			Car_wgjyxml3.put("23", "rsjp");
			Car_wgjyxml3.put("24", "rmhq");
			Car_wgjyxml3.put("25", "rxsjly");
			Car_wgjyxml3.put("26", "rcsfgbs");
			Car_wgjyxml3.put("27", "rclwbzb");
			Car_wgjyxml3.put("28", "rchfh");
			Car_wgjyxml3.put("29", "ryjc");
			Car_wgjyxml3.put("30", "rjjx");
			Car_wgjyxml3.put("31", "rxsgn");
			Car_wgjyxml3.put("32", "rfbs");
			Car_wgjyxml3.put("33", "rfzzd");
			Car_wgjyxml3.put("34", "rpszdq");
			Car_wgjyxml3.put("35", "rjjqd");
			Car_wgjyxml3.put("36", "rfdjcmh");
			Car_wgjyxml3.put("37", "rsddd");
			Car_wgjyxml3.put("38", "rfzdtb");
			Car_wgjyxml3.put("39", "rxcbz");
			Car_wgjyxml3.put("40", "rwxhwbz");
			Car_wgjyxml3.put("80", "rlwcx");
			Car_wgjyxml3.put("81", "ztcjrfzzz");
			Car_wgjyxml3.put("001", "rclhp");
			Car_wgjyxml3.put("002", "rppxh");
			Car_wgjyxml3.put("003", "rcsys");
			Car_wgjyxml3.put("004", "rvin");
			Car_wgjyxml3.put("005", "rfdjh");
			Car_wgjyxml3.put("006", "rjscs");
			Car_wgjyxml3.put("007", "rbxg");
			Car_wgjyxml3.put("008", "rhsj");
			Car_wgjyxml3.put("009", "rccbl");
			Car_wgjyxml3.put("010", "rctzz");
			Car_wgjyxml3.put("011", "rqm");
			Car_wgjyxml3.put("012", "rhx");
			Car_wgjyxml3.put("013", "rcsgg");
			Car_wgjyxml3.put("014", "rjzzz");
			Car_wgjyxml3.put("015", "rccc");
			Car_wgjyxml3.put("016", "rqt");
			Car_wgjyxml3.put("017", "rqwd");
			Car_wgjyxml3.put("018", "rhpzd");
			Car_wgjyxml3.put("019", "rskd");
			Car_wgjyxml3.put("020", "rzxxhd");
			Car_wgjyxml3.put("021", "rqzd");
			Car_wgjyxml3.put("022", "rzdd");
			Car_wgjyxml3.put("023", "rhfsq");
			Car_wgjyxml3.put("024", "rhwd");
			Car_wgjyxml3.put("025", "rdcd");
			Car_wgjyxml3.put("026", "rwxbz");
			Car_wgjyxml3.put("027", "rtzbz");
			Car_wgjyxml3.put("028", "rfjdj");
			Car_wgjyxml3.put("029", "rlb");
			Car_wgjyxml3.put("030", "rfgbs");
			Car_wgjyxml3.put("031", "rfdjjj");
			Car_wgjyxml3.put("032", "rxdc");
			Car_wgjyxml3.put("033", "rdqdx");
			Car_wgjyxml3.put("034", "ryyzd");
			Car_wgjyxml3.put("035", "rfdjbs");
			Car_wgjyxml3.put("036", "rmsjl");
			Car_wgjyxml3.put("037", "rjsyzy");
			Car_wgjyxml3.put("038", "raqd");
			Car_wgjyxml3.put("039", "rfcblbw");
			Car_wgjyxml3.put("040", "rgsq");
			Car_wgjyxml3.put("041", "rxdq");
			Car_wgjyxml3.put("042", "rxsjly");
			Car_wgjyxml3.put("043", "rjss");
			Car_wgjyxml3.put("044", "rybsllx");
			Car_wgjyxml3.put("045", "rczj");
			Car_wgjyxml3.put("046", "rjgxwz");
			Car_wgjyxml3.put("047", "rclcpbp");
			Car_wgjyxml3.put("048", "rqd");
			Car_wgjyxml3.put("049", "rdsyb");
			Car_wgjyxml3.put("050", "rjstbkz");
			Car_wgjyxml3.put("051", "rlsy");
			Car_wgjyxml3.put("052", "rgdxh");
			Car_wgjyxml3.put("053", "rzywp");
			Car_wgjyxml3.put("054", "rfswphl");
			Car_wgjyxml3.put("055", "rcxd");
			Car_wgjyxml3.put("056", "rkcdb");
			Car_wgjyxml3.put("057", "rwhq");
			Car_wgjyxml3.put("058", "raqd2");
			Car_wgjyxml3.put("059", "raqck");
			Car_wgjyxml3.put("060", "rcktd");
			Car_wgjyxml3.put("061", "rrlx");
			Car_wgjyxml3.put("062", "rdnb");
			Car_wgjyxml3.put("063", "rpwf");
			Car_wgjyxml3.put("064", "rgbth");
			Car_wgjyxml3.put("065", "rchfh");
			Car_wgjyxml3.put("066", "rqyljzz");
			Car_wgjyxml3.put("067", "rltgg");
			Car_wgjyxml3.put("068", "rlthw");
			Car_wgjyxml3.put("069", "rltls");
			Car_wgjyxml3.put("070", "rbtbs");
			Car_wgjyxml3.put("071", "rqtbfx");
		}
	}

	public static void initCarCYXMXC() {
		if (Car_cyxmxc == null || Car_cyxmxc.isEmpty()) {
			Car_cyxmxc = null;
			Car_cyxmxc = new HashMap<String, String>();
			Car_cyxmxc.put("01", "����ʶ�����");
			Car_cyxmxc.put("02", "�������ͺ�/����");
			Car_cyxmxc.put("03", "����Ʒ��/�ͺ�");
			Car_cyxmxc.put("04", "������ɫ");
			Car_cyxmxc.put("05", "�˶�������");
			Car_cyxmxc.put("06", "��������");
			Car_cyxmxc.put("07", "����/���������״");
			Car_cyxmxc.put("08", "��̥������");
			Car_cyxmxc.put("09", "��ȫ�������Ǿ�����");
			Car_cyxmxc.put("10", "У����־��");
			Car_cyxmxc.put("11", "ͣ��ָʾ��־");
			Car_cyxmxc.put("12", "������ʻ��¼���ܵ����Ƕ�λװ��");
			Car_cyxmxc.put("13", "Ӧ������/Ӧ����");
			Car_cyxmxc.put("14", "�ɷ������");
			Car_cyxmxc.put("15", "������");
			Car_cyxmxc.put("16", "������۱�ʶ");
			Car_cyxmxc.put("17", "�չ���Ա��λ");
			Car_cyxmxc.put("18", "������ȫ��");
			Car_cyxmxc.put("19", "������¼����ϵͳ");
			Car_cyxmxc.put("20", "��������װ��");
			Car_cyxmxc.put("21", "У������");
			Car_cyxmxc.put("22", "��ȫ��������ϸ�֤��");
		}
	}

	public static void initCarCYXM() {
		if (Car_cyxm == null || Car_cyxm.isEmpty()) {
			Car_cyxm = null;
			Car_cyxm = new HashMap<String, String>();
			Car_cyxm.put("01", "����ʶ�����");
			Car_cyxm.put("02", "�������ͺ�/����");
			Car_cyxm.put("03", "����Ʒ��/�ͺ�");
			Car_cyxm.put("04", "������ɫ");
			Car_cyxm.put("05", "�˶�������");
			Car_cyxm.put("06", "��������");
			Car_cyxm.put("07", "����/���������״");
			Car_cyxm.put("08", "��̥������");
			Car_cyxm.put("09", "��ȫ�������Ǿ�����");
			Car_cyxm.put("10", "�����ߴ硢���������");
			Car_cyxm.put("11", "��������");
			Car_cyxm.put("12", "��̥���");
			Car_cyxm.put("13", "��󲿷���װ��");
			Car_cyxm.put("14", "�������ʶ�ͳ���β����־�塢��Ϳ");
			Car_cyxm.put("15", "�����");
			Car_cyxm.put("16", "��ʻ��¼װ�á�������¼����װ��");
			Car_cyxm.put("17", "Ӧ������/Ӧ�������˿���");
			Car_cyxm.put("18", "�ⲿ��ʶ/���֡���Ϳ");
			Car_cyxm.put("19", "��־�ƾߡ�������");
			Car_cyxm.put("20", "����ϸ�֤��");
		}
	}

	public static void initCarDTDPJYXM() {
		if (Car_dtdpjyxm == null || Car_dtdpjyxm.isEmpty()) {
			Car_dtdpjyxm = null;
			Car_dtdpjyxm = new HashMap<String, String>();
			Car_dtdpjyxm.put("072", "�������������ת����*");
			Car_dtdpjyxm.put("073", "ת�����*");
			Car_dtdpjyxm.put("074", "�Զ�������ֱ����ʻ����");
			Car_dtdpjyxm.put("075", "�����");
			Car_dtdpjyxm.put("076", "������");
			Car_dtdpjyxm.put("077", "ת����/��");
			Car_dtdpjyxm.put("078", "������");
			Car_dtdpjyxm.put("079", "���ƶ���ƫ��20km/h��");
			Car_dtdpjyxm.put("080", "����ѹ����װ��*");
			Car_dtdpjyxm.put("081", "���ɴ����ƶ���*");
			Car_dtdpjyxm.put("082", "�����ƶ�װ��*");
			Car_dtdpjyxm.put("083", "�Ǳ��ָʾ��*");
		}
	}

	public static void initCarDTDPJYXM2() {
		if (Car_dtdpjyxm2 == null || Car_dtdpjyxm2.isEmpty()) {
			Car_dtdpjyxm2 = null;
			Car_dtdpjyxm2 = new HashMap<String, String>();
			Car_dtdpjyxm2.put("041", "ת��ϵ");
			Car_dtdpjyxm2.put("042", "����ϵ");
			Car_dtdpjyxm2.put("043", "�ƶ�ϵ");
			Car_dtdpjyxm2.put("044", "�Ǳ��ָʾ��");
		}
	}

	public static void initCarDTDPJYXM3() {
		if (Car_dtdpjyxm3 == null || Car_dtdpjyxm3.isEmpty()) {
			Car_dtdpjyxm3 = null;
			Car_dtdpjyxm3 = new HashMap<String, String>();
			Car_dtdpjyxm3.put("41", "41.ת��ϵ");
			Car_dtdpjyxm3.put("42", "42.����ϵ");
			Car_dtdpjyxm3.put("43", "43.�ƶ�ϵ");
			Car_dtdpjyxm3.put("44", "44.�Ǳ��ָʾ��");
			Car_dtdpjyxm3.put("072", "072.�������������ת����*");
			Car_dtdpjyxm3.put("073", "073.ת�����*");
			Car_dtdpjyxm3.put("074", "074.�Զ�������ֱ����ʻ����");
			Car_dtdpjyxm3.put("075", "075.�����");
			Car_dtdpjyxm3.put("076", "076.������");
			Car_dtdpjyxm3.put("077", "077.ת����/��");
			Car_dtdpjyxm3.put("078", "078.������");
			Car_dtdpjyxm3.put("079", "079.���ƶ���ƫ��20km/h��");
			Car_dtdpjyxm3.put("080", "080.����ѹ����װ��*");
			Car_dtdpjyxm3.put("081", "081.���ɴ����ƶ���*");
			Car_dtdpjyxm3.put("082", "082.�����ƶ�װ��*");
			Car_dtdpjyxm3.put("083", "083.�Ǳ��ָʾ��*");
		}
	}

	public static void initCarDPJYXM() {
		if (Car_dpjyxm == null || Car_dpjyxm.isEmpty()) {
			Car_dpjyxm = null;
			Car_dpjyxm = new HashMap<String, String>();
			Car_dpjyxm.put("084", "ת��ϵ�̶�");
			Car_dpjyxm.put("085", "ת�������");
			Car_dpjyxm.put("086", "������֧��");
			Car_dpjyxm.put("087", "��֧��֧��");
			Car_dpjyxm.put("088", "ת��������");
			Car_dpjyxm.put("089", "�ְ����*");
			Car_dpjyxm.put("090", "������*");
			Car_dpjyxm.put("091", "������˨");
			Car_dpjyxm.put("092", "U����˨");
			Car_dpjyxm.put("093", "������λ*");
			Car_dpjyxm.put("094", "��������");
			Car_dpjyxm.put("095", "���ݺ���");
			Car_dpjyxm.put("096", "���ܸ�ϵ");
			Car_dpjyxm.put("097", "�ƶ�ϵ�������ṹ�Ķ�");
			Car_dpjyxm.put("098", "�ƶ����ܡ��ָס��ƶ���·©����©��");
			Car_dpjyxm.put("099", "�ƶ�����ϻ�");
			Car_dpjyxm.put("100", "�ƶ���·�̶�");
			Car_dpjyxm.put("101", "������·���*");
			Car_dpjyxm.put("102", "�������̶�");
			Car_dpjyxm.put("103", "�����ܡ�������*");
			Car_dpjyxm.put("104", "ȼ�Ϲ�·");
		}

	}

	public static void initCarDPJYXM2() {
		if (Car_dpjyxm2 == null || Car_dpjyxm2.isEmpty()) {
			Car_dpjyxm2 = null;
			Car_dpjyxm2 = new HashMap<String, String>();
			Car_dpjyxm2.put("045", "ת��ϵ����");
			Car_dpjyxm2.put("046", "����ϵ����");
			Car_dpjyxm2.put("047", "��ʻϵ����");
			Car_dpjyxm2.put("048", "�ƶ�ϵ����");
			Car_dpjyxm2.put("049", "��������");
		}
	}

	public static void initCarDPJYXM3() {
		if (Car_dpjyxm3 == null || Car_dpjyxm3.isEmpty()) {
			Car_dpjyxm3 = null;
			Car_dpjyxm3 = new HashMap<String, String>();
			Car_dpjyxm3.put("45", "45.ת��ϵ����");
			Car_dpjyxm3.put("46", "46.����ϵ����");
			Car_dpjyxm3.put("47", "47.��ʻϵ����");
			Car_dpjyxm3.put("48", "48.�ƶ�ϵ����");
			Car_dpjyxm3.put("49", "49.��������");
			Car_dpjyxm3.put("084", "084.ת��ϵ�̶�");
			Car_dpjyxm3.put("085", "085.ת�������");
			Car_dpjyxm3.put("086", "086.������֧��");
			Car_dpjyxm3.put("087", "087.��֧��֧��");
			Car_dpjyxm3.put("088", "088.ת��������");
			Car_dpjyxm3.put("089", "089.�ְ����*");
			Car_dpjyxm3.put("090", "090.������*");
			Car_dpjyxm3.put("091", "091.������˨");
			Car_dpjyxm3.put("092", "092.U����˨");
			Car_dpjyxm3.put("093", "093.������λ*");
			Car_dpjyxm3.put("094", "094.��������");
			Car_dpjyxm3.put("095", "095.���ݺ���");
			Car_dpjyxm3.put("096", "096.���ܸ�ϵ");
			Car_dpjyxm3.put("097", "097.�ƶ�ϵ�������ṹ�Ķ�");
			Car_dpjyxm3.put("098", "098.�ƶ����ܡ��ָס��ƶ���·©����©��");
			Car_dpjyxm3.put("099", "099.�ƶ�����ϻ�");
			Car_dpjyxm3.put("100", "100.�ƶ���·�̶�");
			Car_dpjyxm3.put("101", "101.������·���*");
			Car_dpjyxm3.put("102", "102.�������̶�");
			Car_dpjyxm3.put("103", "103.�����ܡ�������*");
			Car_dpjyxm3.put("104", "104.ȼ�Ϲ�·");
		}

	}

	public static void initCarWGJYXM2() {
		if (Car_wgjyxm2 == null || Car_wgjyxm2.isEmpty()) {
			Car_wgjyxm2 = null;
			Car_wgjyxm2 = new HashMap<String, String>();
			Car_wgjyxm2.put("001", "�������ƺ��롢��������");
			Car_wgjyxm2.put("002", "����Ʒ�ơ��ͺ�");
			Car_wgjyxm2.put("003", "����ʶ����ţ�����������ţ�");
			Car_wgjyxm2.put("004", "���������루��綯�����룩");
			Car_wgjyxm2.put("005", "������ɫ����״");
			Car_wgjyxm2.put("006", "�����ߴ�");
			Car_wgjyxm2.put("007", "���");
			Car_wgjyxm2.put("008", "��������");
			Car_wgjyxm2.put("009", "�˶�������");
			Car_wgjyxm2.put("010", "�˶�������");
			Car_wgjyxm2.put("011", "����߶�");
			Car_wgjyxm2.put("012", "����ְ嵯��Ƭ��");
			Car_wgjyxm2.put("013", "�ͳ�Ӧ������");
			Car_wgjyxm2.put("014", "�ͳ��˿�ͨ��������");
			Car_wgjyxm2.put("015", "����");
			Car_wgjyxm2.put("016", "�������");
			Car_wgjyxm2.put("017", "��۱�ʶ����ע�ͱ���");
			Car_wgjyxm2.put("018", "�ⲿ�������źŵƾ�");
			Car_wgjyxm2.put("019", "��̥");
			Car_wgjyxm2.put("020", "���Ƽ����ư�װ");
			Car_wgjyxm2.put("021", "��װ/��װ�ƾ�");
			Car_wgjyxm2.put("022", "������ȫ��");
			Car_wgjyxm2.put("023", "�����������Ǿ�����");
			Car_wgjyxm2.put("024", "�����");
			Car_wgjyxm2.put("025", "��ʻ��¼װ��");
			Car_wgjyxm2.put("026", "�������ʶ");
			Car_wgjyxm2.put("027", "����β����־��");
			Car_wgjyxm2.put("028", "������װ��");
			Car_wgjyxm2.put("029", "Ӧ����");
			Car_wgjyxm2.put("030", "������");
			Car_wgjyxm2.put("031", "���ٹ��ܻ�����װ��");
			Car_wgjyxm2.put("032", "�������ƶ�װ��");
			Car_wgjyxm2.put("033", "�����ƶ�װ��");
			Car_wgjyxm2.put("034", "��ʽ�ƶ���");
			Car_wgjyxm2.put("035", "�����ж�װ��");
			Car_wgjyxm2.put("036", "���������Զ����װ��");
			Car_wgjyxm2.put("037", "�ֶ���е�ϵ翪��");
			Car_wgjyxm2.put("038", "���ƶ�̤��");
			Car_wgjyxm2.put("039", "У����־�ƺ�У��ͣ��ָʾ��־��");
			Car_wgjyxm2.put("040", "Σ�ջ������䳵��־");
			Car_wgjyxm2.put("080", "������ѯ");
			Car_wgjyxm2.put("081", "֫��м��˲��ݸ���װ��");
		}
	}

	public static void initCarWGJYXM() {
		if (Car_wgjyxm == null || Car_wgjyxm.isEmpty()) {
			Car_wgjyxm = null;
			Car_wgjyxm = new HashMap<String, String>();
			Car_wgjyxm.put("001", "��������");
			Car_wgjyxm.put("002", "�������͡�����/�ͺ�");
			Car_wgjyxm.put("003", "������ɫ");
			Car_wgjyxm.put("004", "VIN������������ţ�");
			Car_wgjyxm.put("005", "����������");
			Car_wgjyxm.put("006", "��Ҫ��������������");
			Car_wgjyxm.put("007", "���ո�");
			Car_wgjyxm.put("008", "���Ӿ�*/���Ӿ�*");
			Car_wgjyxm.put("009", "��������*");
			Car_wgjyxm.put("010", "��������������ͻ����*");
			Car_wgjyxm.put("011", "����");
			Car_wgjyxm.put("012", "����/��ȫ��/���ⶥ�����*");
			Car_wgjyxm.put("013", "�����������ֱ�־����ʶ*");
			Car_wgjyxm.put("014", "���м�װװ��*");
			Car_wgjyxm.put("015", "����3C��־");
			Car_wgjyxm.put("016", "����ע��ǼǼ���������Ŀ*");
			Car_wgjyxm.put("017", "ǰλ��/��λ�ơ�����־��");
			Car_wgjyxm.put("018", "�����յ�");
			Car_wgjyxm.put("019", "ʾ�ȵ�/�ҳ���־��");
			Car_wgjyxm.put("020", "ת���źŵƣ�ǰ���󡢲ࣩΣ�վ����źŵ�");
			Car_wgjyxm.put("021", "ǰ�յƣ�Զ�⡢���⣩");
			Car_wgjyxm.put("022", "�ƶ���");
			Car_wgjyxm.put("023", "���������෴����");
			Car_wgjyxm.put("024", "�����");
			Car_wgjyxm.put("025", "������");
			Car_wgjyxm.put("026", "��·����Σ�ջ��ﳵ����ʶ");
			Car_wgjyxm.put("027", "���ֳ�����־�ƾ�");
			Car_wgjyxm.put("028", "���ӵƾߡ�����������װ��");
			Car_wgjyxm.put("029", "����");
			Car_wgjyxm.put("030", "�������ʶ");
			Car_wgjyxm.put("031", "����������ϵͳ����");
			Car_wgjyxm.put("032", "����׮ͷ������");
			Car_wgjyxm.put("033", "�������ߡ����ֹ�·*");
			Car_wgjyxm.put("034", "Һѹ�ƶ���Һ��Һ��*");
			Car_wgjyxm.put("035", "��������ʶ*");
			Car_wgjyxm.put("036", "�������Ž���");
			Car_wgjyxm.put("037", "��ʻԱ����*");
			Car_wgjyxm.put("038", "��ȫ��*");
			Car_wgjyxm.put("039", "�細������ʻԱ������λ*");
			Car_wgjyxm.put("040", "��ˮ��*");
			Car_wgjyxm.put("041", "ϴ����");
			Car_wgjyxm.put("042", "������ʻ��¼��*");
			Car_wgjyxm.put("043", "��ʻ�ҹ̶�����ȫ��*");
			Car_wgjyxm.put("044", "�Ǳ�����������");
			Car_wgjyxm.put("045", "���ݼ���ָʾ�����ź�װ�õ�ͼ�α�־");
			Car_wgjyxm.put("046", "���������ֵ����ı�ע*");
			Car_wgjyxm.put("047", "������Ʒ����");
			Car_wgjyxm.put("048", "��*");
			Car_wgjyxm.put("049", "���١��Ǳ��Դ���");
			Car_wgjyxm.put("050", "����̤�����");
			Car_wgjyxm.put("051", "©ˮ���͡���/ˮ�¡���ѹ");
			Car_wgjyxm.put("052", "�ص�Ϩ��/���ͳ�ͣ��װ��*");
			Car_wgjyxm.put("053", "����/�������������μ��*");
			Car_wgjyxm.put("054", "���ֺ����̻���");
			Car_wgjyxm.put("055", "����ơ��ŵ�");
			Car_wgjyxm.put("056", "�ͳ��ذ塢���������");
			Car_wgjyxm.put("057", "�������Ӧ�����ڱ�ʶ����ȫ�ִ�����ȫ��");
			Car_wgjyxm.put("058", "��ȫ��*");
			Car_wgjyxm.put("059", "Ӧ�����ڵ�������λ�úͳߴ�");
			Car_wgjyxm.put("060", "�˿�ͨ����ͨ����ȫ�ŵ�ͨ��");
			Car_wgjyxm.put("061", "ȼ���䡢ȼ�����*");
			Car_wgjyxm.put("062", "�����/ǣ���������ء����ؼ�");
			Car_wgjyxm.put("063", "����Ͳ���۷�");
			Car_wgjyxm.put("064", "�ְ嵯��*");
			Car_wgjyxm.put("065", "���漰���²�����װ��*");
			Car_wgjyxm.put("066", "ǣ������װ��");
			Car_wgjyxm.put("067", "��̥�ͺ�/���/�ٶȼ���*");
			Car_wgjyxm.put("068", "̥�ڻ�����ȡ�̥��*");
			Car_wgjyxm.put("069", "��̥��˨��������˨*");
			Car_wgjyxm.put("070", "��̥��־*");
			Car_wgjyxm.put("071", "���������Ϲ涨������");
		}
	}

	public static void initCarWGJYXM3() {
		if (Car_wgjyxm3 == null || Car_wgjyxm3.isEmpty()) {
			Car_wgjyxm3 = null;
			Car_wgjyxm3 = new HashMap<String, String>();
			
			Car_wgjyxm3.put("01", "01.�������ƺ��롢��������");
			Car_wgjyxm3.put("02", "02.����Ʒ�ơ��ͺ�");
			Car_wgjyxm3.put("03", "03.����ʶ����ţ�����������ţ�");
			Car_wgjyxm3.put("04", "04.���������루��綯�����룩");
			Car_wgjyxm3.put("05", "05.������ɫ����״");
			Car_wgjyxm3.put("06", "06.�����ߴ�");
			Car_wgjyxm3.put("07", "07.���");
			Car_wgjyxm3.put("08", "08.��������");
			Car_wgjyxm3.put("09", "09.�˶�������");
			Car_wgjyxm3.put("10", "10.�˶�������");
			Car_wgjyxm3.put("11", "11.����߶�");
			Car_wgjyxm3.put("12", "12.����ְ嵯��Ƭ��");
			Car_wgjyxm3.put("13", "13.�ͳ�Ӧ������");
			Car_wgjyxm3.put("14", "14�ͳ��˿�ͨ��������");
			Car_wgjyxm3.put("15", "15.����");
			Car_wgjyxm3.put("16", "16.�������");
			Car_wgjyxm3.put("17", "17.��۱�ʶ����ע�ͱ���");
			Car_wgjyxm3.put("18", "18.�ⲿ�������źŵƾ�");
			Car_wgjyxm3.put("19", "19.��̥");
			Car_wgjyxm3.put("20", "20.���Ƽ����ư�װ");
			Car_wgjyxm3.put("21", "21.��װ/��װ�ƾ�");
			Car_wgjyxm3.put("22", "22.������ȫ��");
			Car_wgjyxm3.put("23", "23.�����������Ǿ�����");
			Car_wgjyxm3.put("24", "24.�����");
			Car_wgjyxm3.put("25", "25.��ʻ��¼װ��");
			Car_wgjyxm3.put("26", "26.�������ʶ");
			Car_wgjyxm3.put("27", "27.����β����־��");
			Car_wgjyxm3.put("28", "28.������װ��");
			Car_wgjyxm3.put("29", "29.Ӧ����");
			Car_wgjyxm3.put("30", "30.������");
			Car_wgjyxm3.put("31", "31.���ٹ��ܻ�����װ��");
			Car_wgjyxm3.put("32", "32.�������ƶ�װ��");
			Car_wgjyxm3.put("33", "33.�����ƶ�װ��");
			Car_wgjyxm3.put("34", "34.��ʽ�ƶ���");
			Car_wgjyxm3.put("35", "35.�����ж�װ��");
			Car_wgjyxm3.put("36", "36.���������Զ����װ��");
			Car_wgjyxm3.put("37", "37.�ֶ���е�ϵ翪��");
			Car_wgjyxm3.put("38", "38.���ƶ�̤��");
			Car_wgjyxm3.put("39", "39.У����־�ƺ�У��ͣ��ָʾ��־��");
			Car_wgjyxm3.put("40", "40.Σ�ջ������䳵��־");
			Car_wgjyxm3.put("80", "80.������ѯ");
			Car_wgjyxm3.put("81", "81.֫��м��˲��ݸ���װ��");
			Car_wgjyxm3.put("001", "001.��������");
			Car_wgjyxm3.put("002", "002.�������͡�����/�ͺ�");
			Car_wgjyxm3.put("003", "003.������ɫ");
			Car_wgjyxm3.put("004", "004.VIN������������ţ�");
			Car_wgjyxm3.put("005", "005.����������");
			Car_wgjyxm3.put("006", "006.��Ҫ��������������");
			Car_wgjyxm3.put("007", "007.���ո�");
			Car_wgjyxm3.put("008", "008.���Ӿ�*/���Ӿ�*");
			Car_wgjyxm3.put("009", "009.��������*");
			Car_wgjyxm3.put("010", "010.��������������ͻ����*");
			Car_wgjyxm3.put("011", "011.����");
			Car_wgjyxm3.put("012", "012.����/��ȫ��/���ⶥ�����*");
			Car_wgjyxm3.put("013", "013.�����������ֱ�־����ʶ*");
			Car_wgjyxm3.put("014", "014.���м�װװ��*");
			Car_wgjyxm3.put("015", "015.����3C��־");
			Car_wgjyxm3.put("016", "016.����ע��ǼǼ���������Ŀ*");
			Car_wgjyxm3.put("017", "017.ǰλ��/��λ�ơ�����־��");
			Car_wgjyxm3.put("018", "018.�����յ�");
			Car_wgjyxm3.put("019", "019.ʾ�ȵ�/�ҳ���־��");
			Car_wgjyxm3.put("020", "020.ת���źŵƣ�ǰ���󡢲ࣩΣ�վ����źŵ�");
			Car_wgjyxm3.put("021", "021.ǰ�յƣ�Զ�⡢���⣩");
			Car_wgjyxm3.put("022", "022.�ƶ���");
			Car_wgjyxm3.put("023", "023.���������෴����");
			Car_wgjyxm3.put("024", "024.�����");
			Car_wgjyxm3.put("025", "025.������");
			Car_wgjyxm3.put("026", "026.��·����Σ�ջ��ﳵ����ʶ");
			Car_wgjyxm3.put("027", "027.���ֳ�����־�ƾ�");
			Car_wgjyxm3.put("028", "028.���ӵƾߡ�����������װ��");
			Car_wgjyxm3.put("029", "029.����");
			Car_wgjyxm3.put("030", "030.�������ʶ");
			Car_wgjyxm3.put("031", "031.����������ϵͳ����");
			Car_wgjyxm3.put("032", "032.����׮ͷ������");
			Car_wgjyxm3.put("033", "033.�������ߡ����ֹ�·*");
			Car_wgjyxm3.put("034", "034.Һѹ�ƶ���Һ��Һ��*");
			Car_wgjyxm3.put("035", "035.��������ʶ*");
			Car_wgjyxm3.put("036", "036.�������Ž���");
			Car_wgjyxm3.put("037", "037.��ʻԱ����*");
			Car_wgjyxm3.put("038", "038.��ȫ��*");
			Car_wgjyxm3.put("039", "039.�細������ʻԱ������λ*");
			Car_wgjyxm3.put("040", "040.��ˮ��*");
			Car_wgjyxm3.put("041", "041.ϴ����");
			Car_wgjyxm3.put("042", "042.������ʻ��¼��*");
			Car_wgjyxm3.put("043", "043.��ʻ�ҹ̶�����ȫ��*");
			Car_wgjyxm3.put("044", "044.�Ǳ�����������");
			Car_wgjyxm3.put("045", "045.���ݼ���ָʾ�����ź�װ�õ�ͼ�α�־");
			Car_wgjyxm3.put("046", "046.���������ֵ����ı�ע*");
			Car_wgjyxm3.put("047", "047.������Ʒ����");
			Car_wgjyxm3.put("048", "048.��*");
			Car_wgjyxm3.put("049", "049.���١��Ǳ��Դ���");
			Car_wgjyxm3.put("050", "050.����̤�����");
			Car_wgjyxm3.put("051", "051.©ˮ���͡���/ˮ�¡���ѹ");
			Car_wgjyxm3.put("052", "052.�ص�Ϩ��/���ͳ�ͣ��װ��*");
			Car_wgjyxm3.put("053", "053.����/�������������μ��*");
			Car_wgjyxm3.put("054", "054.���ֺ����̻���");
			Car_wgjyxm3.put("055", "055.����ơ��ŵ�");
			Car_wgjyxm3.put("056", "056.�ͳ��ذ塢���������");
			Car_wgjyxm3.put("057", "057.�������Ӧ�����ڱ�ʶ����ȫ�ִ�����ȫ��");
			Car_wgjyxm3.put("058", "058.��ȫ��*");
			Car_wgjyxm3.put("059", "059.Ӧ�����ڵ�������λ�úͳߴ�");
			Car_wgjyxm3.put("060", "060.�˿�ͨ����ͨ����ȫ�ŵ�ͨ��");
			Car_wgjyxm3.put("061", "061.ȼ���䡢ȼ�����*");
			Car_wgjyxm3.put("062", "062.�����/ǣ���������ء����ؼ�");
			Car_wgjyxm3.put("063", "063.����Ͳ���۷�");
			Car_wgjyxm3.put("064", "064.�ְ嵯��*");
			Car_wgjyxm3.put("065", "065.���漰���²�����װ��*");
			Car_wgjyxm3.put("066", "066.ǣ������װ��");
			Car_wgjyxm3.put("067", "067.��̥�ͺ�/���/�ٶȼ���*");
			Car_wgjyxm3.put("068", "068.̥�ڻ�����ȡ�̥��*");
			Car_wgjyxm3.put("069", "069.��̥��˨��������˨*");
			Car_wgjyxm3.put("070", "070.��̥��־*");
			Car_wgjyxm3.put("071", "071.���������Ϲ涨������");
		}
	}

	
	public static void initCarWGPZXM3(Context context,Map<String, String> Car_wgpzxm_map) {
		if (Car_wgpzxm_map != null && Car_wgpzxm_map.size() > 0
				&& Car_wgpzxm_map.get("hasdata").equals("1")) {
			Car_wgpzxm_map.remove("hasdata");
			if (Car_wgpzxm == null) {
				Car_wgpzxm = Car_wgpzxm_map;
			} else {
				Car_wgpzxm.clear();
				Car_wgpzxm = null;
				Car_wgpzxm = Car_wgpzxm_map;
			}
		} else {
			Toast.makeText(context, "δ��ȡ����������Ƭ��Ϣ�����ñ�����Ƭ��Ϣ", 1).show();
			initCarWGPZXM4();
		}
	}

/*	public static void initCarWGPZXM2() {
		String[] zpbhs = null;
		String[] zpmcs = null;
		if (!Md_system.zpbh.equals("") && !Md_system.zpmc.equals("")) {
			zpbhs = Md_system.zpbh.split(",");
			zpmcs = Md_system.zpmc.split(",");
		} else {
//			zpbhs = Init_Activity.zpbh.split(",");
			//zpmcs = Init_Activity.zpmc.split(",");
		}
		if (Car_wgpzxm == null || Car_wgpzxm.isEmpty()) {
			Car_wgpzxm = null;
			Car_wgpzxm = new HashMap<String, String>();
			for (int i = 0; i < zpbhs.length; i++) {
				Car_wgpzxm.put(zpbhs[i], zpmcs[i]);
			}
		}
	}*/

	public static void initCarWGPZXM4() {

		if (Car_wgpzxm == null || Car_wgpzxm.isEmpty()) {
			Car_wgpzxm = null;
			Car_wgpzxm = new HashMap<String, String>();
			Car_wgpzxm.put("0138", "У�������̿ͳ��ĳ�����¼����ϵͳ");
			Car_wgpzxm.put("0205", "�����������¼��");
			Car_wgpzxm.put("0354", "�����ƶ���λ��Ƭ");
			Car_wgpzxm.put("0216", "��������ȫ�������鱨�浥5");
			Car_wgpzxm.put("0158", "����������Ƭ");
			Car_wgpzxm.put("0170", "���԰�");
			Car_wgpzxm.put("0321", "��ƹ⹤λ��Ƭ");
			Car_wgpzxm.put("0211", "�������������������ϸ�֤�͵��̺ϸ�֤");
			Car_wgpzxm.put("0343", "·���г��ƶ�������Ƭ");
			Car_wgpzxm.put("0114", "������������Ƭ");
			Car_wgpzxm.put("0178", "�����ʶ��������Ϳ");
			Car_wgpzxm.put("0119", "�������Ż����Ա�ǩ");
			Car_wgpzxm.put("0160", "У�����ƣ�ǰ��������Ƭ");
			Car_wgpzxm.put("0257", "·�Լ����¼��");
			Car_wgpzxm.put("0166", "����������װ��ͼ�α�־");
			Car_wgpzxm.put("0349", "�����ƶ���λ��Ƭ");
			Car_wgpzxm.put("0161", "У�����ƣ���������Ƭ");
			Car_wgpzxm.put("0256", "������ƿʹ�õǼ�֤");
			Car_wgpzxm.put("0132", "���������Զ����װ��");
			Car_wgpzxm.put("0135", "�м������ݸ���װ��");
			Car_wgpzxm.put("0217", "��������ȫ�������鱨�浥6");
			Car_wgpzxm.put("0176", "��̥ĥ��");
			Car_wgpzxm.put("0154", "��ǰ��̥����ͺ�");
			Car_wgpzxm.put("0348", "�����ƶ���λ��Ƭ");
			Car_wgpzxm.put("0118", "��ʻ��¼װ����Ƭ");
			Car_wgpzxm.put("0213", "��������ȫ�������鱨�浥2");
			Car_wgpzxm.put("0221", "��������ȫ�������鱨�浥10");
			Car_wgpzxm.put("0344", "���̶�̬���鿪ʼ��Ƭ");
			Car_wgpzxm.put("0180", "�˿���Ӧ������");
			Car_wgpzxm.put("0206", "����˰��˰������˰֤��");
			Car_wgpzxm.put("0224", "��������ȫ�������鱨�浥13");
			Car_wgpzxm.put("0130", "�����ƶ�װ��");
			Car_wgpzxm.put("0140", "���������ƶ�̤��");
			Car_wgpzxm.put("0298", "β�����鱨�浥");
			Car_wgpzxm.put("0220", "��������ȫ�������鱨�浥9");
			Car_wgpzxm.put("0223", "��������ȫ�������鱨�浥12");
			Car_wgpzxm.put("0137", "���ͷ��������ͻ���װ�ü�����ϵͳ");
			Car_wgpzxm.put("0361", "�����ߴ��Զ�����-��");
			Car_wgpzxm.put("0124", "���Ǿ�ʾ��");
			Car_wgpzxm.put("0350", "�����ƶ���λ��Ƭ");
			Car_wgpzxm.put("0204", "��������ȫ�������鱨�浥");
			Car_wgpzxm.put("0177", "��̥���");
			Car_wgpzxm.put("0115", "�����ڲ���Ƭ");
			Car_wgpzxm.put("0171", "����������ϵͳ����ѹ���죩");
			Car_wgpzxm.put("0185", "��λ������ʽ");
			Car_wgpzxm.put("0226", "��������ȫ�������鱨�浥15");
			Car_wgpzxm.put("0212", "��������ȫ�������鱨�浥1");
			Car_wgpzxm.put("0214", "��������ȫ�������鱨�浥3");
			Car_wgpzxm.put("0188", "�ֶ���е�ϵ翪��");
			Car_wgpzxm.put("0345", "·���¶�פ���ƶ���Ƭ");
			Car_wgpzxm.put("0164", "��Ϩ��װ��");
			Car_wgpzxm.put("0215", "��������֤�����");
			Car_wgpzxm.put("0351", "פ���ƶ���λ��Ƭ");
			Car_wgpzxm.put("0174", "·��פ���ƶ���Ƭ");
			Car_wgpzxm.put("0175", "·���豸��װ���");
			Car_wgpzxm.put("0117", "Ӧ������Ƭ");
			Car_wgpzxm.put("0225", "��������ȫ�������鱨�浥14");
			Car_wgpzxm.put("0202", "��������֤�����");
			Car_wgpzxm.put("0136", "��ǰ��̥����ͺ�");
			Car_wgpzxm.put("0199", "���������Ƭ");
			Car_wgpzxm.put("0201", "��������ʻ֤");
			Car_wgpzxm.put("0323", "���̼�����Ƭ");
			Car_wgpzxm.put("0113", "����ʶ�������Ƭ");
			Car_wgpzxm.put("0120", "��ȫ������Ƭ");
			Car_wgpzxm.put("0157", "��ʻ������������ȫ��");
			Car_wgpzxm.put("0184", "�չ���Ա����");
			Car_wgpzxm.put("0187", "������ǰ�������Ƭ");
			Car_wgpzxm.put("0112", "�����Һ�б��45����Ƭ");
			Car_wgpzxm.put("0355", "�����ƶ���λ��Ƭ");
			Car_wgpzxm.put("0341", "·���г��ƶ���ʼ��Ƭ");
			Car_wgpzxm.put("0186", "����");
			Car_wgpzxm.put("0218", "��������ȫ�������鱨�浥7");
			Car_wgpzxm.put("0167", "���׷�");
			Car_wgpzxm.put("0296", "��������");
			if (Md_system.getDq().equals("�㶫")) {
				Car_wgpzxm.put("0172", "��������");
			} else {
				Car_wgpzxm.put("0172", "����ϵͳ");
			}
			Car_wgpzxm.put("0169", "0BD�ӿ�");
			Car_wgpzxm.put("0352", "�ҵƹ⹤λ��Ƭ");
			Car_wgpzxm.put("0116", "�������Ƭ");
			Car_wgpzxm.put("0322", "һ���ƶ���λ��Ƭ");
			Car_wgpzxm.put("0297", "��������");
			Car_wgpzxm.put("0139", "У���ĸ�������װ��");
			Car_wgpzxm.put("0203", "��������ͨ�¹�����ǿ�Ʊ���ƾ֤");
			Car_wgpzxm.put("0156", "�Һ���̥����ͺ�");
			Car_wgpzxm.put("0159", "У�����ƣ�ǰ��������Ƭ");
			Car_wgpzxm.put("0342", "���̶�̬���������Ƭ");
			Car_wgpzxm.put("0179", "·�Ա���");
			Car_wgpzxm.put("0134", "�������ƶ�װ���Լ�״̬��");
			Car_wgpzxm.put("0347", "���ٱ�λ��Ƭ");
			Car_wgpzxm.put("0127", "������");
			Car_wgpzxm.put("0181", "������������Ƭ");
			Car_wgpzxm.put("0183", "��ʻ��¼�ǻ�GPS��Ƭ");
			Car_wgpzxm.put("0128", "У����־����Ƭ");
			Car_wgpzxm.put("0168", "�����ж�װ�ã����أ�");
			Car_wgpzxm.put("0125", "�˿��š�Ӧ���ţ�����");
			Car_wgpzxm.put("0126", "У��ͣ��ָʾ��־����Ƭ");
			Car_wgpzxm.put("0163", "Σ�ջ������䳵��־");
			Car_wgpzxm.put("0360", "�����ߴ��Զ�����-ǰ");
			Car_wgpzxm.put("0219", "��������ȫ�������鱨�浥8");
			Car_wgpzxm.put("0155", "�����̥����ͺ�");
			Car_wgpzxm.put("0131", "�˿���Ӧ������");
			Car_wgpzxm.put("0165", "�����ʶ��������Ϳ");
			Car_wgpzxm.put("0353", "�໬��λ��Ƭ");
			Car_wgpzxm.put("0133", "ǰ����ʽ�ƶ���");
			Car_wgpzxm.put("0173", "����ְ嵯��Ƭ��");
			Car_wgpzxm.put("0207", "ί�к˷�����ϸ��־֪ͨ��");
			Car_wgpzxm.put("0208", "��������Ȩ��");
			Car_wgpzxm.put("0222", "��������ȫ�������鱨�浥11");
			Car_wgpzxm.put("0111", "������ǰ��б��45����Ƭ");
		}
	}

	public static void initCarWGPZXM() {
		if (Car_wgpzxm == null || Car_wgpzxm.isEmpty()) {
			Car_wgpzxm = null;
			Car_wgpzxm = new HashMap<String, String>();
			Car_wgpzxm.put("01", "��������ʻ֤");
			Car_wgpzxm.put("02", "��������֤�����");
			Car_wgpzxm.put("03", "��������ͨ�¹�����ǿ�Ʊ���ƾ֤");
			Car_wgpzxm.put("04", "��������ȫ�������鱨�浥");
			Car_wgpzxm.put("05", "�����������¼��");
			Car_wgpzxm.put("06", "����˰��˰������˰֤��");
			Car_wgpzxm.put("07", "ί�к˷�����ϸ��־֪ͨ��");
			Car_wgpzxm.put("08", "��������Ȩ��");
			Car_wgpzxm.put("11", "��ǰб��45����Ƭ");
			Car_wgpzxm.put("12", "����б��45����Ƭ");
			Car_wgpzxm.put("13", "����ʶ�������Ƭ");
			Car_wgpzxm.put("14", "������������Ƭ");
			Car_wgpzxm.put("15", "������ǰ�������Ƭ");
			Car_wgpzxm.put("16", "�������Ƭ");
			Car_wgpzxm.put("17", "��ȫ�ִ���Ƭ");
			Car_wgpzxm.put("18", "��ʻ��¼�ǻ�GPS��Ƭ");
			Car_wgpzxm.put("19", "�������Ż����Ա�ǩ");
			Car_wgpzxm.put("20", "��ȫ������Ƭ");
			Car_wgpzxm.put("21", "�ƹ⹤λ������Ƭ");
			Car_wgpzxm.put("22", "�ƶ���λ������Ƭ");
			Car_wgpzxm.put("23", "���̹�λ������Ƭ");
			Car_wgpzxm.put("24", "���Ǿ�ʾ��");
			Car_wgpzxm.put("25", "�˿��š�Ӧ���ţ�����");
			Car_wgpzxm.put("26", "У����־��");
			Car_wgpzxm.put("27", "������");
			Car_wgpzxm.put("28", "У����־�ƺ�ͣ��ָʾ��־");
			Car_wgpzxm.put("29", "�չ���Ա����");
			Car_wgpzxm.put("30", "����������װ��ͼ�α�־");
			Car_wgpzxm.put("31", "�˿���Ӧ������");
			Car_wgpzxm.put("32", "�������Զ����װ��");
			Car_wgpzxm.put("33", "ǰ����ʽ�ƶ���");
			Car_wgpzxm.put("34", "ABS�Լ�״̬��");
			Car_wgpzxm.put("35", "�м������ݸ���װ�ú��Զ�������");
			Car_wgpzxm.put("36", "��̥����ͺ�");
			Car_wgpzxm.put("37", "���ͷ��������ͻ���װ�ü�����ϵͳ");
			Car_wgpzxm.put("38", "У�������̿ͳ��ĳ�����¼����ϵͳ");
			Car_wgpzxm.put("39", "У���ĸ�������װ��");
			Car_wgpzxm.put("40", "�����������ƶ�װ��");
			Car_wgpzxm.put("41", "·����Ƭ");
			Car_wgpzxm.put("42", "��ȫ�ִ����ര");
			Car_wgpzxm.put("43", "��ȫ��");
			Car_wgpzxm.put("50", "·��ԭʼ��¼��");
			Car_wgpzxm.put("51", "·��פ���ƶ���Ƭ");
			Car_wgpzxm.put("52", "·���豸��װ��Ƭ");
			Car_wgpzxm.put("53", "�ְ嵯��");
			Car_wgpzxm.put("54", "��̥ĥ�����");
			Car_wgpzxm.put("55", "��λ������ʽ");
			Car_wgpzxm.put("56", "������ƿʹ�õǼ�֤");
			Car_wgpzxm.put("57", "�������������������ϸ�֤��");
			Car_wgpzxm.put("99", "����");
		}
	}

	public static List<String[]> wgjyfl = null;
	public static String[] wgjyflname = new String[] { "����Ψһ���϶�", "�������",
			"�����͵����ͺ�װ��", "��������", "��ʻ�ң�����", "��������ת״��", "�ͳ��ڲ�", "���̼�", "��̥", "����" };

	public static void initWgjyfl() {
		if (wgjyfl == null) {
			wgjyfl = new ArrayList<String[]>();
		}
		wgjyfl.add(new String[] { "001", "002", "003", "004", "005", "006" });
		wgjyfl.add(new String[] { "007", "008", "009", "010", "011", "012",
				"013", "014", "015", "016" });
		wgjyfl.add(new String[] { "017", "018", "019", "020", "021", "022",
				"023", "024", "025", "026", "027", "028", "029", "030" });
		wgjyfl.add(new String[] { "031", "032", "033", "034", "035" });
		wgjyfl.add(new String[] { "036", "037", "038", "039", "040", "041",
				"042", "043", "044", "045", "046", "047" });
		wgjyfl.add(new String[] { "048", "049", "050", "051", "052" });
		wgjyfl.add(new String[] { "053", "054", "055", "056", "057", "058",
				"059", "060" });
		wgjyfl.add(new String[] { "061", "062", "063", "064", "065", "066" });
		wgjyfl.add(new String[] { "067", "068", "069", "070" });
		wgjyfl.add(new String[] { "071" });
	}

	public static List<String[]> wgjyfl2 = null;
	public static String[] wgjyflname2 = new String[] { "������ۼ���" };

	public static void initWgjyfl2() {
		if (wgjyfl2 == null) {
			wgjyfl2 = new ArrayList<String[]>();
		}
		wgjyfl2.add(new String[] { "001", "002", "003", "004", "005", "006",
				"007", "008", "009", "010", "011", "012", "013", "014", "015",
				"016", "017", "018", "019", "020", "021", "022", "023", "024",
				"025", "026", "027", "028", "029", "030", "031", "032", "033",
				"034", "035", "036", "037", "038", "039", "040", "080", "081" });
	}

	public static List<String[]> wgjyfl3 = null;
	public static String[] wgjyflname3 = new String[] { "������ۼ���(01-40��80��81)",
			"����Ψһ���϶�(001-006)", "�������(007-016)", "�����͵����ͺ�װ��(017-030)",
			"��������(031-035)", "��ʻ��(036-047)", "��������ת״��(048-052)",
			"�ͳ��ڲ�(053-060)", "���̼�(061-066)", "��̥(067-070)", "����(071)" };

	public static void initWgjyfl3() {
		if (wgjyfl3 == null) {
			wgjyfl3 = new ArrayList<String[]>();
		}
		wgjyfl3.add(new String[] { "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31", "32", "33", "34", "35", "36", "37",
				"38", "39", "40", "80", "81" });
		wgjyfl3.add(new String[] { "001", "002", "003", "004", "005", "006" });
		wgjyfl3.add(new String[] { "007", "008", "009", "010", "011", "012",
				"013", "014", "015", "016" });
		wgjyfl3.add(new String[] { "017", "018", "019", "020", "021", "022",
				"023", "024", "025", "026", "027", "028", "029", "030" });
		wgjyfl3.add(new String[] { "031", "032", "033", "034", "035" });
		wgjyfl3.add(new String[] { "036", "037", "038", "039", "040", "041",
				"042", "043", "044", "045", "046", "047" });
		wgjyfl3.add(new String[] { "048", "049", "050", "051", "052" });
		wgjyfl3.add(new String[] { "053", "054", "055", "056", "057", "058",
				"059", "060" });
		wgjyfl3.add(new String[] { "061", "062", "063", "064", "065", "066" });
		wgjyfl3.add(new String[] { "067", "068", "069", "070" });
		wgjyfl3.add(new String[] { "071" });
	}

	public static List<String[]> dtdpjyfl = null;
	public static String[] dtdpjyflname = new String[] { "ת��ϵ", "ת��ϵ", "�ƶ�ϵ",
			"��ʻ��" };

	public static void initDtdpjyfl() {
		if (dtdpjyfl == null) {
			dtdpjyfl = new ArrayList<String[]>();
		}
		dtdpjyfl.add(new String[] { "072", "073", "074" });
		dtdpjyfl.add(new String[] { "075", "076", "077", "078" });
		dtdpjyfl.add(new String[] { "079", "080", "081", "082" });
		dtdpjyfl.add(new String[] { "083" });
	}

	public static List<String[]> dtdpjyfl2 = null;
	public static String[] dtdpjyflname2 = new String[] { "��̬���̼���" };

	public static void initDtdpjyfl2() {
		if (dtdpjyfl2 == null) {
			dtdpjyfl2 = new ArrayList<String[]>();
		}
		dtdpjyfl2.add(new String[] { "041", "042", "043", "044" });
	}

	public static List<String[]> dtdpjyfl3 = null;
	public static String[] dtdpjyflname3 = new String[] { "��̬���̼���(41-44)",
			"ת��ϵ(072-074)", "ת��ϵ(075-078)", "�ƶ�ϵ(079-082)", "��ʻ��(083)" };

	public static void initDtdpjyfl3() {
		if (dtdpjyfl3 == null) {
			dtdpjyfl3 = new ArrayList<String[]>();
		}
		dtdpjyfl3.add(new String[] { "41", "42", "43", "44" });
		dtdpjyfl3.add(new String[] { "072", "073", "074" });
		dtdpjyfl3.add(new String[] { "075", "076", "077", "078" });
		dtdpjyfl3.add(new String[] { "079", "080", "081", "082" });
		dtdpjyfl3.add(new String[] { "083" });
	}

	public static List<String[]> dpjyfl = null;
	public static String[] dpjyflname = new String[] { "ת��ϵ", "ת��ϵ", "��ʻϵ",
			"�ƶ�ϵ", "������·", "������������" };

	public static void initDpjyfl() {
		if (dpjyfl == null) {
			dpjyfl = new ArrayList<String[]>();
		}
		dpjyfl.add(new String[] { "084", "085" });
		dpjyfl.add(new String[] { "086", "087", "088" });
		dpjyfl.add(new String[] { "089", "090", "091", "092", "093", "094",
				"095", "096" });
		dpjyfl.add(new String[] { "097", "098", "099", "100" });
		dpjyfl.add(new String[] { "101" });
		dpjyfl.add(new String[] { "102", "103", "104" });
	}

	public static List<String[]> dpjyfl2 = null;
	public static String[] dpjyflname2 = new String[] { "����" };

	public static void initDpjyfl2() {
		if (dpjyfl2 == null) {
			dpjyfl2 = new ArrayList<String[]>();
		}
		dpjyfl2.add(new String[] { "045", "046", "047", "048", "049" });
	}

	public static List<String[]> dpjyfl3 = null;
	public static String[] dpjyflname3 = new String[] { "����(45-49)",
			"ת��ϵ(084-085)", "ת��ϵ(086-088)", "��ʻϵ(089-096)", "�ƶ�ϵ(097-100)",
			"������·(101)", "������������(102-104)" };

	public static void initDpjyfl3() {
		if (dpjyfl3 == null) {
			dpjyfl3 = new ArrayList<String[]>();
		}
		dpjyfl3.add(new String[] { "45", "46", "47", "48", "49" });
		dpjyfl3.add(new String[] { "084", "085" });
		dpjyfl3.add(new String[] { "086", "087", "088" });
		dpjyfl3.add(new String[] { "089", "090", "091", "092", "093", "094",
				"095", "096" });
		dpjyfl3.add(new String[] { "097", "098", "099", "100" });
		dpjyfl3.add(new String[] { "101" });
		dpjyfl3.add(new String[] { "102", "103", "104" });
	}

	public static List<String[]> cytyfl = null;
	public static String[] cytyflname = new String[] { "ͨ����Ŀ", "�����ҳ�",
			"�����Ϳͳ�/Σ��Ʒ���䳵", "����" };

	public static void initCytyfl() {
		if (cytyfl == null) {
			cytyfl = new ArrayList<String[]>();
		}
		cytyfl.add(new String[] { "01", "02", "03", "04", "05", "06", "07",
				"08", "09" });
		cytyfl.add(new String[] { "10", "11", "12", "13", "14" });
		cytyfl.add(new String[] { "15", "16", "17", "18" });
		cytyfl.add(new String[] { "19", "20" });
	}

	public static List<String[]> cyxcfl = null;
	public static String[] cyxcflname = new String[] { "У��ͨ����Ŀ", "У��ר����Ŀ",
			"У������" };

	public static void initCyxcfl() {
		if (cyxcfl == null) {
			cyxcfl = new ArrayList<String[]>();
		}
		cyxcfl.add(new String[] { "01", "02", "03", "04", "05", "06", "07",
				"08", "09" });
		cyxcfl.add(new String[] { "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21" });
		cyxcfl.add(new String[] { "22" });
	}

	/**** Ħ�г� ******/
	public static List<String[]> mt_wgjyfl3 = null;
	public static String[] mt_wgjyflname3 = new String[] { "Ħ�г���ۼ���", "����",
			"��̥", "����" };

	public static void init_mt_Wgjyfl3() {
		if (mt_wgjyfl3 == null) {
			mt_wgjyfl3 = new ArrayList<String[]>();
		}
		mt_wgjyfl3.add(new String[] { "001", "002", "003", "004", "005", "006",
				"007", "008", "009", "010", "011", "012" });
		mt_wgjyfl3.add(new String[] { "013", "014", "015", "016" });
		mt_wgjyfl3.add(new String[] { "020", "021", "022", "023" });
		mt_wgjyfl3.add(new String[] { "017", "018", "019", "024", "025", "026",
				"027", "028", "029", "030", "031", "032", "033", "034", "035",
				"036", "037", "038" });
	}

	public static List<String[]> mt_dtdpjyfl3 = null;
	public static String[] mt_dtdpjyflname3 = new String[] { "��̬����" };

	public static void mt_initDtdpjyfl3() {
		if (mt_dtdpjyfl3 == null) {
			mt_dtdpjyfl3 = new ArrayList<String[]>();
		}
		mt_dtdpjyfl3.add(new String[] { "039", "040", "041", "042", "043",
				"044", "045" });
	}

	public static List<String[]> mt_dpjyfl3 = null;
	public static String[] mt_dpjyflname3 = new String[] { "�²�����" };

	public static void initmt_Dpjyfl3() {
		if (mt_dpjyfl3 == null) {
			mt_dpjyfl3 = new ArrayList<String[]>();
		}
		mt_dpjyfl3.add(new String[] { "046", "047", "048", "049", "050" });
	}

	/**
	 * ��ȡ������Ŀ
	 * 
	 * @param RgjyItems
	 * @param flname
	 * @param fl
	 * @param jyxm
	 * @return
	 */
	public static List<RgjyItem> getItems(String[] RgjyItems, String[] flname,
			List<String[]> fl, Map<String, String> jyxm) {
		List<RgjyItem> result = new ArrayList<RgjyItem>();
		for (int i = 0; i < flname.length; i++) {
			RgjyItem item = new RgjyItem();
			item.items = new ArrayList<RgjyItem.Item>();
			item.msg = flname[i];
			List<String> list = Arrays.asList(fl.get(i));
			for (String code : Arrays.asList(RgjyItems)) {
				if (list.contains(code)) {
					RgjyItem.Item _item = item.new Item();
					_item.id = code;
					_item.name = jyxm.get(code);
					_item.code = code;
					_item.property = "0";
					item.items.add(_item);
				}
			}
			if (item.items.size() != 0) {
				result.add(item);
			}
		}
		return result;
	}

	/**
	 * ��ȡxml�ͽڵ�
	 * 
	 * @param bhgx
	 * @param hgx
	 * @param requestDate
	 * @param xml
	 */
	public static String HG = "1"; // �ϸ�
	public static String BHG = "2"; // ���ϸ�
	public static String WJ = "0"; // δ��

	public static void getXMLAndValue(String bhgx, String hgx,
			Map<String, Object> requestDate, Map<String, String> xml) {
		List<String> yjyxm = Arrays.asList((bhgx + hgx).split(","));
		List<String> bhgxs = Arrays.asList(bhgx.split(","));
		List<String> hgxs = Arrays.asList(hgx.split(","));
		for (Map.Entry<String, String> entry : xml.entrySet()) {
			if (yjyxm.contains(entry.getKey())) {
				if (bhgxs.contains(entry.getKey())) {
					requestDate.put(entry.getValue(), BHG);
				} else {
					requestDate.put(entry.getValue(), HG);
				}
			} else {
				requestDate.put(entry.getValue(), WJ);
			}
		}
	}
}

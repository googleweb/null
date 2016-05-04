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
 * 车辆检验项目数据获取类
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
		/********** 摩托车 **********/
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

	/*********** 摩托车 ************/
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
			mt_dpjyxml3.put("046", "车架");
			mt_dpjyxml3.put("047", "电器线路固定");
			mt_dpjyxml3.put("048", "排气管﹡  ");
			mt_dpjyxml3.put("049", "消声器﹡  ");
			mt_dpjyxml3.put("050", "燃料箱、燃料管路﹡");

		}
	}

	public static void initMtDTDPJYXM3() {
		if (mt_dtdpjyxm3 == null || mt_dtdpjyxm3.isEmpty()) {
			mt_dtdpjyxm3 = null;
			mt_dtdpjyxm3 = new HashMap<String, String>();
			mt_dtdpjyxm3.put("039", "转向轮左右转角*");
			mt_dtdpjyxm3.put("040", "方向盘最大自由转动量※*");
			mt_dtdpjyxm3.put("041", "离合器接合情况");
			mt_dtdpjyxm3.put("042", "变速器换档");
			mt_dtdpjyxm3.put("043", "传动轴/链及传动各部件");
			mt_dtdpjyxm3.put("044", "油门控制");
			mt_dtdpjyxm3.put("045", "制动性能");
		}
	}

	public static void initMtWGJYXM3() {
		if (mt_wgjyxml3 == null || mt_wgjyxml3.isEmpty()) {
			mt_wgjyxml3 = null;
			mt_wgjyxml3 = new HashMap<String, String>();
			mt_wgjyxml3.put("001", "号牌及安装 ");
			mt_wgjyxml3.put("002", "车辆类型、品牌/型号");
			mt_wgjyxml3.put("003", "车身颜色");
			mt_wgjyxml3.put("004", "vin (整车出厂编号)");
			mt_wgjyxml3.put("005", "发动机号");
			mt_wgjyxml3.put("006", "主要特征及技术参数   ");
			mt_wgjyxml3.put("007", "后视镜*        ");
			mt_wgjyxml3.put("008", "风窗玻璃※﹡   ");
			mt_wgjyxml3.put("009", "刮水器※﹡ ");
			mt_wgjyxml3.put("010", "货厢、安全架※ ");
			mt_wgjyxml3.put("011", "漆面   ");
			mt_wgjyxml3.put("012", "仪表");
			mt_wgjyxml3.put("013", "前照灯（远、近光）*  ");
			mt_wgjyxml3.put("014", "转向信号灯（前、后）*");
			mt_wgjyxml3.put("015", "后位灯*、后牌照灯*       ");
			mt_wgjyxml3.put("016", "制动灯*    ");
			mt_wgjyxml3.put("017", "后反射器*");
			mt_wgjyxml3.put("018", "侧反射器");
			mt_wgjyxml3.put("019", "喇叭*           ");
			mt_wgjyxml3.put("020", "轮胎型号规格 ");
			mt_wgjyxml3.put("021", "轮胎花纹深度");
			mt_wgjyxml3.put("022", "胎面破裂/割伤/磨损/变形  ");
			mt_wgjyxml3.put("023", "轮胎螺栓 ※");
			mt_wgjyxml3.put("024", "前后减振器     ");
			mt_wgjyxml3.put("025", "转向上、下联板﹡");
			mt_wgjyxml3.put("026", "方向把*     ");
			mt_wgjyxml3.put("027", "座垫、扶手（或拉带）、脚蹬 ");
			mt_wgjyxml3.put("028", "挡泥板  ");
			mt_wgjyxml3.put("029", "仪表数量和类型*         ");
			mt_wgjyxml3.put("030", "车辆产品标牌*          ");
			mt_wgjyxml3.put("031", "整车3c标志");
			mt_wgjyxml3.put("032", "其他不符合规定情形     ");
			mt_wgjyxml3.put("033", "起动性能*      ");
			mt_wgjyxml3.put("034", "怠速       ");
			mt_wgjyxml3.put("035", "电源充电     ");
			mt_wgjyxml3.put("036", "仪表及指示器");
			mt_wgjyxml3.put("037", "加速手把/踏板控制     ");
			mt_wgjyxml3.put("038", "柴油车停机装置※ ");
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
			Car_cyxmxc.put("01", "车辆识别代号");
			Car_cyxmxc.put("02", "发动机型号/号码");
			Car_cyxmxc.put("03", "车辆品牌/型号");
			Car_cyxmxc.put("04", "车身颜色");
			Car_cyxmxc.put("05", "核定载人数");
			Car_cyxmxc.put("06", "车辆类型");
			Car_cyxmxc.put("07", "号牌/车辆外观形状");
			Car_cyxmxc.put("08", "轮胎完好情况");
			Car_cyxmxc.put("09", "安全带、三角警告牌");
			Car_cyxmxc.put("10", "校车标志灯");
			Car_cyxmxc.put("11", "停车指示标志");
			Car_cyxmxc.put("12", "具有行驶记录功能的卫星定位装置");
			Car_cyxmxc.put("13", "应急出口/应急锤");
			Car_cyxmxc.put("14", "干粉灭火器");
			Car_cyxmxc.put("15", "急救箱");
			Car_cyxmxc.put("16", "车身外观标识");
			Car_cyxmxc.put("17", "照管人员座位");
			Car_cyxmxc.put("18", "汽车安全带");
			Car_cyxmxc.put("19", "车内外录像监控系统");
			Car_cyxmxc.put("20", "辅助倒车装置");
			Car_cyxmxc.put("21", "校车标牌");
			Car_cyxmxc.put("22", "安全技术检验合格证明");
		}
	}

	public static void initCarCYXM() {
		if (Car_cyxm == null || Car_cyxm.isEmpty()) {
			Car_cyxm = null;
			Car_cyxm = new HashMap<String, String>();
			Car_cyxm.put("01", "车辆识别代号");
			Car_cyxm.put("02", "发动机型号/号码");
			Car_cyxm.put("03", "车辆品牌/型号");
			Car_cyxm.put("04", "车身颜色");
			Car_cyxm.put("05", "核定载人数");
			Car_cyxm.put("06", "车辆类型");
			Car_cyxm.put("07", "号牌/车辆外观形状");
			Car_cyxm.put("08", "轮胎完好情况");
			Car_cyxm.put("09", "安全带、三角警告牌");
			Car_cyxm.put("10", "外廓尺寸、轴数、轴距");
			Car_cyxm.put("11", "整备质量");
			Car_cyxm.put("12", "轮胎规格");
			Car_cyxm.put("13", "侧后部防护装置");
			Car_cyxm.put("14", "车身反光标识和车辆尾部标志板、喷涂");
			Car_cyxm.put("15", "灭火器");
			Car_cyxm.put("16", "行驶记录装置、车内外录像监控装置");
			Car_cyxm.put("17", "应急出口/应急锤、乘客门");
			Car_cyxm.put("18", "外部标识/文字、喷涂");
			Car_cyxm.put("19", "标志灯具、警报器");
			Car_cyxm.put("20", "检验合格证明");
		}
	}

	public static void initCarDTDPJYXM() {
		if (Car_dtdpjyxm == null || Car_dtdpjyxm.isEmpty()) {
			Car_dtdpjyxm = null;
			Car_dtdpjyxm = new HashMap<String, String>();
			Car_dtdpjyxm.put("072", "方向盘最大自由转动量*");
			Car_dtdpjyxm.put("073", "转向沉重*");
			Car_dtdpjyxm.put("074", "自动回正、直线行驶能力");
			Car_dtdpjyxm.put("075", "离合器");
			Car_dtdpjyxm.put("076", "变速器");
			Car_dtdpjyxm.put("077", "转动轴/链");
			Car_dtdpjyxm.put("078", "驱动桥");
			Car_dtdpjyxm.put("079", "点制动跑偏（20km/h）");
			Car_dtdpjyxm.put("080", "低气压报警装置*");
			Car_dtdpjyxm.put("081", "弹簧储能制动器*");
			Car_dtdpjyxm.put("082", "防抱制动装置*");
			Car_dtdpjyxm.put("083", "仪表和指示器*");
		}
	}

	public static void initCarDTDPJYXM2() {
		if (Car_dtdpjyxm2 == null || Car_dtdpjyxm2.isEmpty()) {
			Car_dtdpjyxm2 = null;
			Car_dtdpjyxm2 = new HashMap<String, String>();
			Car_dtdpjyxm2.put("041", "转向系");
			Car_dtdpjyxm2.put("042", "传动系");
			Car_dtdpjyxm2.put("043", "制动系");
			Car_dtdpjyxm2.put("044", "仪表和指示器");
		}
	}

	public static void initCarDTDPJYXM3() {
		if (Car_dtdpjyxm3 == null || Car_dtdpjyxm3.isEmpty()) {
			Car_dtdpjyxm3 = null;
			Car_dtdpjyxm3 = new HashMap<String, String>();
			Car_dtdpjyxm3.put("41", "41.转向系");
			Car_dtdpjyxm3.put("42", "42.传动系");
			Car_dtdpjyxm3.put("43", "43.制动系");
			Car_dtdpjyxm3.put("44", "44.仪表和指示器");
			Car_dtdpjyxm3.put("072", "072.方向盘最大自由转动量*");
			Car_dtdpjyxm3.put("073", "073.转向沉重*");
			Car_dtdpjyxm3.put("074", "074.自动回正、直线行驶能力");
			Car_dtdpjyxm3.put("075", "075.离合器");
			Car_dtdpjyxm3.put("076", "076.变速器");
			Car_dtdpjyxm3.put("077", "077.转动轴/链");
			Car_dtdpjyxm3.put("078", "078.驱动桥");
			Car_dtdpjyxm3.put("079", "079.点制动跑偏（20km/h）");
			Car_dtdpjyxm3.put("080", "080.低气压报警装置*");
			Car_dtdpjyxm3.put("081", "081.弹簧储能制动器*");
			Car_dtdpjyxm3.put("082", "082.防抱制动装置*");
			Car_dtdpjyxm3.put("083", "083.仪表和指示器*");
		}
	}

	public static void initCarDPJYXM() {
		if (Car_dpjyxm == null || Car_dpjyxm.isEmpty()) {
			Car_dpjyxm = null;
			Car_dpjyxm = new HashMap<String, String>();
			Car_dpjyxm.put("084", "转向系固定");
			Car_dpjyxm.put("085", "转向各部件");
			Car_dpjyxm.put("086", "变速器支架");
			Car_dpjyxm.put("087", "分支器支架");
			Car_dpjyxm.put("088", "转动各部件");
			Car_dpjyxm.put("089", "钢板吊耳*");
			Car_dpjyxm.put("090", "吊耳销*");
			Car_dpjyxm.put("091", "中心螺栓");
			Car_dpjyxm.put("092", "U型螺栓");
			Car_dpjyxm.put("093", "车较移位*");
			Car_dpjyxm.put("094", "车驾纵梁");
			Car_dpjyxm.put("095", "车驾横梁");
			Car_dpjyxm.put("096", "悬架杆系");
			Car_dpjyxm.put("097", "制动系部件、结构改动");
			Car_dpjyxm.put("098", "制动主杠、轮缸、制动管路漏气、漏油");
			Car_dpjyxm.put("099", "制动软管老化");
			Car_dpjyxm.put("100", "制动管路固定");
			Car_dpjyxm.put("101", "电器线路检查*");
			Car_dpjyxm.put("102", "发动机固定");
			Car_dpjyxm.put("103", "排气管、消声器*");
			Car_dpjyxm.put("104", "燃料管路");
		}

	}

	public static void initCarDPJYXM2() {
		if (Car_dpjyxm2 == null || Car_dpjyxm2.isEmpty()) {
			Car_dpjyxm2 = null;
			Car_dpjyxm2 = new HashMap<String, String>();
			Car_dpjyxm2.put("045", "转向系部件");
			Car_dpjyxm2.put("046", "传动系部件");
			Car_dpjyxm2.put("047", "行驶系部件");
			Car_dpjyxm2.put("048", "制动系部件");
			Car_dpjyxm2.put("049", "其它部件");
		}
	}

	public static void initCarDPJYXM3() {
		if (Car_dpjyxm3 == null || Car_dpjyxm3.isEmpty()) {
			Car_dpjyxm3 = null;
			Car_dpjyxm3 = new HashMap<String, String>();
			Car_dpjyxm3.put("45", "45.转向系部件");
			Car_dpjyxm3.put("46", "46.传动系部件");
			Car_dpjyxm3.put("47", "47.行驶系部件");
			Car_dpjyxm3.put("48", "48.制动系部件");
			Car_dpjyxm3.put("49", "49.其它部件");
			Car_dpjyxm3.put("084", "084.转向系固定");
			Car_dpjyxm3.put("085", "085.转向各部件");
			Car_dpjyxm3.put("086", "086.变速器支架");
			Car_dpjyxm3.put("087", "087.分支器支架");
			Car_dpjyxm3.put("088", "088.转动各部件");
			Car_dpjyxm3.put("089", "089.钢板吊耳*");
			Car_dpjyxm3.put("090", "090.吊耳销*");
			Car_dpjyxm3.put("091", "091.中心螺栓");
			Car_dpjyxm3.put("092", "092.U型螺栓");
			Car_dpjyxm3.put("093", "093.车较移位*");
			Car_dpjyxm3.put("094", "094.车驾纵梁");
			Car_dpjyxm3.put("095", "095.车驾横梁");
			Car_dpjyxm3.put("096", "096.悬架杆系");
			Car_dpjyxm3.put("097", "097.制动系部件、结构改动");
			Car_dpjyxm3.put("098", "098.制动主杠、轮缸、制动管路漏气、漏油");
			Car_dpjyxm3.put("099", "099.制动软管老化");
			Car_dpjyxm3.put("100", "100.制动管路固定");
			Car_dpjyxm3.put("101", "101.电器线路检查*");
			Car_dpjyxm3.put("102", "102.发动机固定");
			Car_dpjyxm3.put("103", "103.排气管、消声器*");
			Car_dpjyxm3.put("104", "104.燃料管路");
		}

	}

	public static void initCarWGJYXM2() {
		if (Car_wgjyxm2 == null || Car_wgjyxm2.isEmpty()) {
			Car_wgjyxm2 = null;
			Car_wgjyxm2 = new HashMap<String, String>();
			Car_wgjyxm2.put("001", "车辆号牌号码、车辆类型");
			Car_wgjyxm2.put("002", "车辆品牌、型号");
			Car_wgjyxm2.put("003", "车辆识别代号（整车出厂编号）");
			Car_wgjyxm2.put("004", "发动机号码（或电动机号码）");
			Car_wgjyxm2.put("005", "车辆颜色和形状");
			Car_wgjyxm2.put("006", "外廓尺寸");
			Car_wgjyxm2.put("007", "轴距");
			Car_wgjyxm2.put("008", "整备质量");
			Car_wgjyxm2.put("009", "核定载人数");
			Car_wgjyxm2.put("010", "核定载质量");
			Car_wgjyxm2.put("011", "栏板高度");
			Car_wgjyxm2.put("012", "后轴钢板弹簧片数");
			Car_wgjyxm2.put("013", "客车应急出口");
			Car_wgjyxm2.put("014", "客车乘客通道和引道");
			Car_wgjyxm2.put("015", "货厢");
			Car_wgjyxm2.put("016", "车身外观");
			Car_wgjyxm2.put("017", "外观标识、标注和标牌");
			Car_wgjyxm2.put("018", "外部照明和信号灯具");
			Car_wgjyxm2.put("019", "轮胎");
			Car_wgjyxm2.put("020", "号牌及号牌安装");
			Car_wgjyxm2.put("021", "加装/改装灯具");
			Car_wgjyxm2.put("022", "汽车安全带");
			Car_wgjyxm2.put("023", "机动车用三角警告牌");
			Car_wgjyxm2.put("024", "灭火器");
			Car_wgjyxm2.put("025", "行驶记录装置");
			Car_wgjyxm2.put("026", "车身反光标识");
			Car_wgjyxm2.put("027", "车辆尾部标志板");
			Car_wgjyxm2.put("028", "侧后防护装置");
			Car_wgjyxm2.put("029", "应急锤");
			Car_wgjyxm2.put("030", "急救箱");
			Car_wgjyxm2.put("031", "限速功能或限速装置");
			Car_wgjyxm2.put("032", "防抱死制动装置");
			Car_wgjyxm2.put("033", "辅助制动装置");
			Car_wgjyxm2.put("034", "盘式制动器");
			Car_wgjyxm2.put("035", "紧急切断装置");
			Car_wgjyxm2.put("036", "发动机舱自动灭火装置");
			Car_wgjyxm2.put("037", "手动机械断电开关");
			Car_wgjyxm2.put("038", "副制动踏板");
			Car_wgjyxm2.put("039", "校车标志灯和校车停车指示标志牌");
			Car_wgjyxm2.put("040", "危险货物运输车标志");
			Car_wgjyxm2.put("080", "联网查询");
			Car_wgjyxm2.put("081", "肢体残疾人操纵辅助装置");
		}
	}

	public static void initCarWGJYXM() {
		if (Car_wgjyxm == null || Car_wgjyxm.isEmpty()) {
			Car_wgjyxm = null;
			Car_wgjyxm = new HashMap<String, String>();
			Car_wgjyxm.put("001", "车辆号码");
			Car_wgjyxm.put("002", "车辆类型、号牌/型号");
			Car_wgjyxm.put("003", "车身颜色");
			Car_wgjyxm.put("004", "VIN（整车出厂编号）");
			Car_wgjyxm.put("005", "发动机号码");
			Car_wgjyxm.put("006", "主要特征及技术参数");
			Car_wgjyxm.put("007", "保险杠");
			Car_wgjyxm.put("008", "后视镜*/下视镜*");
			Car_wgjyxm.put("009", "车窗玻璃*");
			Car_wgjyxm.put("010", "车体周正、尖锐突出物*");
			Car_wgjyxm.put("011", "漆面");
			Car_wgjyxm.put("012", "货箱/安全架/车外顶行李架*");
			Car_wgjyxm.put("013", "车身广告与文字标志、标识*");
			Car_wgjyxm.put("014", "自行加装装置*");
			Car_wgjyxm.put("015", "整车3C标志");
			Car_wgjyxm.put("016", "其他注册登记检验增加项目*");
			Car_wgjyxm.put("017", "前位灯/后位灯、车标志灯");
			Car_wgjyxm.put("018", "后牌照灯");
			Car_wgjyxm.put("019", "示廊灯/挂车标志灯");
			Car_wgjyxm.put("020", "转向信号灯（前、后、侧）危险警告信号灯");
			Car_wgjyxm.put("021", "前照灯（远光、近光）");
			Car_wgjyxm.put("022", "制动力");
			Car_wgjyxm.put("023", "后反射器、侧反射器");
			Car_wgjyxm.put("024", "后雾灯");
			Car_wgjyxm.put("025", "倒车灯");
			Car_wgjyxm.put("026", "道路运输危险货物车辆标识");
			Car_wgjyxm.put("027", "特种车辆标志灯具");
			Car_wgjyxm.put("028", "附加灯具、反射器或附属装置");
			Car_wgjyxm.put("029", "喇叭");
			Car_wgjyxm.put("030", "车身反光标识");
			Car_wgjyxm.put("031", "发动机各种系统机件");
			Car_wgjyxm.put("032", "蓄电池桩头及联线");
			Car_wgjyxm.put("033", "电器导线、各种管路*");
			Car_wgjyxm.put("034", "液压制动储液器液面*");
			Car_wgjyxm.put("035", "发动机标识*");
			Car_wgjyxm.put("036", "门锁及门铰链");
			Car_wgjyxm.put("037", "驾驶员座椅*");
			Car_wgjyxm.put("038", "安全带*");
			Car_wgjyxm.put("039", "风窗玻璃驾驶员视区部位*");
			Car_wgjyxm.put("040", "刮水器*");
			Car_wgjyxm.put("041", "洗涤器");
			Car_wgjyxm.put("042", "汽车行驶记录仪*");
			Car_wgjyxm.put("043", "驾驶室固定、安全带*");
			Car_wgjyxm.put("044", "仪表数量与类型");
			Car_wgjyxm.put("045", "操纵件、指示器及信号装置的图形标志");
			Car_wgjyxm.put("046", "警告性文字的中文标注*");
			Car_wgjyxm.put("047", "车辆产品标牌");
			Car_wgjyxm.put("048", "起动*");
			Car_wgjyxm.put("049", "怠速、仪表电源充电");
			Car_wgjyxm.put("050", "加速踏板控制");
			Car_wgjyxm.put("051", "漏水、油、气/水温、油压");
			Car_wgjyxm.put("052", "关电熄灯/柴油车停机装置*");
			Car_wgjyxm.put("053", "座椅/卧铺数量，座椅间距*");
			Car_wgjyxm.put("054", "扶手和卧铺护栏");
			Car_wgjyxm.put("055", "车厢灯、门灯");
			Car_wgjyxm.put("056", "客车地板、车内行李架");
			Car_wgjyxm.put("057", "灭火器、应急出口标识、安全手锤、安全门");
			Car_wgjyxm.put("058", "安全带*");
			Car_wgjyxm.put("059", "应急出口的数量、位置和尺寸");
			Car_wgjyxm.put("060", "乘客通道、通往安全门的通道");
			Car_wgjyxm.put("061", "燃料箱、燃料箱盖*");
			Car_wgjyxm.put("062", "挡泥板/牵引钩、蓄电池、蓄电池架");
			Car_wgjyxm.put("063", "贮气筒排污阀");
			Car_wgjyxm.put("064", "钢板弹簧*");
			Car_wgjyxm.put("065", "侧面及后下部防护装置*");
			Car_wgjyxm.put("066", "牵引连接装置");
			Car_wgjyxm.put("067", "轮胎型号/规格/速度级别*");
			Car_wgjyxm.put("068", "胎冠花纹深度、胎面*");
			Car_wgjyxm.put("069", "轮胎螺栓、半轴螺栓*");
			Car_wgjyxm.put("070", "备胎标志*");
			Car_wgjyxm.put("071", "其他不符合规定的情形");
		}
	}

	public static void initCarWGJYXM3() {
		if (Car_wgjyxm3 == null || Car_wgjyxm3.isEmpty()) {
			Car_wgjyxm3 = null;
			Car_wgjyxm3 = new HashMap<String, String>();
			
			Car_wgjyxm3.put("01", "01.车辆号牌号码、车辆类型");
			Car_wgjyxm3.put("02", "02.车辆品牌、型号");
			Car_wgjyxm3.put("03", "03.车辆识别代号（整车出厂编号）");
			Car_wgjyxm3.put("04", "04.发动机号码（或电动机号码）");
			Car_wgjyxm3.put("05", "05.车辆颜色和形状");
			Car_wgjyxm3.put("06", "06.外廓尺寸");
			Car_wgjyxm3.put("07", "07.轴距");
			Car_wgjyxm3.put("08", "08.整备质量");
			Car_wgjyxm3.put("09", "09.核定载人数");
			Car_wgjyxm3.put("10", "10.核定载质量");
			Car_wgjyxm3.put("11", "11.栏板高度");
			Car_wgjyxm3.put("12", "12.后轴钢板弹簧片数");
			Car_wgjyxm3.put("13", "13.客车应急出口");
			Car_wgjyxm3.put("14", "14客车乘客通道和引道");
			Car_wgjyxm3.put("15", "15.货厢");
			Car_wgjyxm3.put("16", "16.车身外观");
			Car_wgjyxm3.put("17", "17.外观标识、标注和标牌");
			Car_wgjyxm3.put("18", "18.外部照明和信号灯具");
			Car_wgjyxm3.put("19", "19.轮胎");
			Car_wgjyxm3.put("20", "20.号牌及号牌安装");
			Car_wgjyxm3.put("21", "21.加装/改装灯具");
			Car_wgjyxm3.put("22", "22.汽车安全带");
			Car_wgjyxm3.put("23", "23.机动车用三角警告牌");
			Car_wgjyxm3.put("24", "24.灭火器");
			Car_wgjyxm3.put("25", "25.行驶记录装置");
			Car_wgjyxm3.put("26", "26.车身反光标识");
			Car_wgjyxm3.put("27", "27.车辆尾部标志板");
			Car_wgjyxm3.put("28", "28.侧后防护装置");
			Car_wgjyxm3.put("29", "29.应急锤");
			Car_wgjyxm3.put("30", "30.急救箱");
			Car_wgjyxm3.put("31", "31.限速功能或限速装置");
			Car_wgjyxm3.put("32", "32.防抱死制动装置");
			Car_wgjyxm3.put("33", "33.辅助制动装置");
			Car_wgjyxm3.put("34", "34.盘式制动器");
			Car_wgjyxm3.put("35", "35.紧急切断装置");
			Car_wgjyxm3.put("36", "36.发动机舱自动灭火装置");
			Car_wgjyxm3.put("37", "37.手动机械断电开关");
			Car_wgjyxm3.put("38", "38.副制动踏板");
			Car_wgjyxm3.put("39", "39.校车标志灯和校车停车指示标志牌");
			Car_wgjyxm3.put("40", "40.危险货物运输车标志");
			Car_wgjyxm3.put("80", "80.联网查询");
			Car_wgjyxm3.put("81", "81.肢体残疾人操纵辅助装置");
			Car_wgjyxm3.put("001", "001.车辆号码");
			Car_wgjyxm3.put("002", "002.车辆类型、号牌/型号");
			Car_wgjyxm3.put("003", "003.车身颜色");
			Car_wgjyxm3.put("004", "004.VIN（整车出厂编号）");
			Car_wgjyxm3.put("005", "005.发动机号码");
			Car_wgjyxm3.put("006", "006.主要特征及技术参数");
			Car_wgjyxm3.put("007", "007.保险杠");
			Car_wgjyxm3.put("008", "008.后视镜*/下视镜*");
			Car_wgjyxm3.put("009", "009.车窗玻璃*");
			Car_wgjyxm3.put("010", "010.车体周正、尖锐突出物*");
			Car_wgjyxm3.put("011", "011.漆面");
			Car_wgjyxm3.put("012", "012.货箱/安全架/车外顶行李架*");
			Car_wgjyxm3.put("013", "013.车身广告与文字标志、标识*");
			Car_wgjyxm3.put("014", "014.自行加装装置*");
			Car_wgjyxm3.put("015", "015.整车3C标志");
			Car_wgjyxm3.put("016", "016.其他注册登记检验增加项目*");
			Car_wgjyxm3.put("017", "017.前位灯/后位灯、车标志灯");
			Car_wgjyxm3.put("018", "018.后牌照灯");
			Car_wgjyxm3.put("019", "019.示廊灯/挂车标志灯");
			Car_wgjyxm3.put("020", "020.转向信号灯（前、后、侧）危险警告信号灯");
			Car_wgjyxm3.put("021", "021.前照灯（远光、近光）");
			Car_wgjyxm3.put("022", "022.制动力");
			Car_wgjyxm3.put("023", "023.后反射器、侧反射器");
			Car_wgjyxm3.put("024", "024.后雾灯");
			Car_wgjyxm3.put("025", "025.倒车灯");
			Car_wgjyxm3.put("026", "026.道路运输危险货物车辆标识");
			Car_wgjyxm3.put("027", "027.特种车辆标志灯具");
			Car_wgjyxm3.put("028", "028.附加灯具、反射器或附属装置");
			Car_wgjyxm3.put("029", "029.喇叭");
			Car_wgjyxm3.put("030", "030.车身反光标识");
			Car_wgjyxm3.put("031", "031.发动机各种系统机件");
			Car_wgjyxm3.put("032", "032.蓄电池桩头及联线");
			Car_wgjyxm3.put("033", "033.电器导线、各种管路*");
			Car_wgjyxm3.put("034", "034.液压制动储液器液面*");
			Car_wgjyxm3.put("035", "035.发动机标识*");
			Car_wgjyxm3.put("036", "036.门锁及门铰链");
			Car_wgjyxm3.put("037", "037.驾驶员座椅*");
			Car_wgjyxm3.put("038", "038.安全带*");
			Car_wgjyxm3.put("039", "039.风窗玻璃驾驶员视区部位*");
			Car_wgjyxm3.put("040", "040.刮水器*");
			Car_wgjyxm3.put("041", "041.洗涤器");
			Car_wgjyxm3.put("042", "042.汽车行驶记录仪*");
			Car_wgjyxm3.put("043", "043.驾驶室固定、安全带*");
			Car_wgjyxm3.put("044", "044.仪表数量与类型");
			Car_wgjyxm3.put("045", "045.操纵件、指示器及信号装置的图形标志");
			Car_wgjyxm3.put("046", "046.警告性文字的中文标注*");
			Car_wgjyxm3.put("047", "047.车辆产品标牌");
			Car_wgjyxm3.put("048", "048.起动*");
			Car_wgjyxm3.put("049", "049.怠速、仪表电源充电");
			Car_wgjyxm3.put("050", "050.加速踏板控制");
			Car_wgjyxm3.put("051", "051.漏水、油、气/水温、油压");
			Car_wgjyxm3.put("052", "052.关电熄灯/柴油车停机装置*");
			Car_wgjyxm3.put("053", "053.座椅/卧铺数量，座椅间距*");
			Car_wgjyxm3.put("054", "054.扶手和卧铺护栏");
			Car_wgjyxm3.put("055", "055.车厢灯、门灯");
			Car_wgjyxm3.put("056", "056.客车地板、车内行李架");
			Car_wgjyxm3.put("057", "057.灭火器、应急出口标识、安全手锤、安全门");
			Car_wgjyxm3.put("058", "058.安全带*");
			Car_wgjyxm3.put("059", "059.应急出口的数量、位置和尺寸");
			Car_wgjyxm3.put("060", "060.乘客通道、通往安全门的通道");
			Car_wgjyxm3.put("061", "061.燃料箱、燃料箱盖*");
			Car_wgjyxm3.put("062", "062.挡泥板/牵引钩、蓄电池、蓄电池架");
			Car_wgjyxm3.put("063", "063.贮气筒排污阀");
			Car_wgjyxm3.put("064", "064.钢板弹簧*");
			Car_wgjyxm3.put("065", "065.侧面及后下部防护装置*");
			Car_wgjyxm3.put("066", "066.牵引连接装置");
			Car_wgjyxm3.put("067", "067.轮胎型号/规格/速度级别*");
			Car_wgjyxm3.put("068", "068.胎冠花纹深度、胎面*");
			Car_wgjyxm3.put("069", "069.轮胎螺栓、半轴螺栓*");
			Car_wgjyxm3.put("070", "070.备胎标志*");
			Car_wgjyxm3.put("071", "071.其他不符合规定的情形");
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
			Toast.makeText(context, "未获取到服务器照片信息，调用本地照片信息", 1).show();
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
			Car_wgpzxm.put("0138", "校车、卧铺客车的车内外录像监控系统");
			Car_wgpzxm.put("0205", "机动车查验记录表");
			Car_wgpzxm.put("0354", "五轴制动工位照片");
			Car_wgpzxm.put("0216", "机动车安全技术检验报告单5");
			Car_wgpzxm.put("0158", "车辆正后方照片");
			Car_wgpzxm.put("0170", "电脑板");
			Car_wgpzxm.put("0321", "左灯光工位照片");
			Car_wgpzxm.put("0211", "国产机动车整车出厂合格证和底盘合格证");
			Car_wgpzxm.put("0343", "路试行车制动结束照片");
			Car_wgpzxm.put("0114", "机动车侧面照片");
			Car_wgpzxm.put("0178", "车身标识、字体喷涂");
			Car_wgpzxm.put("0119", "发动机号或柔性标签");
			Car_wgpzxm.put("0160", "校车标牌（前）反面照片");
			Car_wgpzxm.put("0257", "路试检验记录单");
			Car_wgpzxm.put("0166", "缓速器操作装置图形标志");
			Car_wgpzxm.put("0349", "三轴制动工位照片");
			Car_wgpzxm.put("0161", "校车标牌（后）正面照片");
			Car_wgpzxm.put("0256", "车用气瓶使用登记证");
			Car_wgpzxm.put("0132", "发动机舱自动灭火装置");
			Car_wgpzxm.put("0135", "残疾车操纵辅助装置");
			Car_wgpzxm.put("0217", "机动车安全技术检验报告单6");
			Car_wgpzxm.put("0176", "轮胎磨损");
			Car_wgpzxm.put("0154", "右前轮胎规格型号");
			Car_wgpzxm.put("0348", "二轴制动工位照片");
			Car_wgpzxm.put("0118", "行驶记录装置照片");
			Car_wgpzxm.put("0213", "机动车安全技术检验报告单2");
			Car_wgpzxm.put("0221", "机动车安全技术检验报告单10");
			Car_wgpzxm.put("0344", "底盘动态检验开始照片");
			Car_wgpzxm.put("0180", "乘客门应急开关");
			Car_wgpzxm.put("0206", "车船税纳税或者免税证明");
			Car_wgpzxm.put("0224", "机动车安全技术检验报告单13");
			Car_wgpzxm.put("0130", "辅助制动装置");
			Car_wgpzxm.put("0140", "教练车副制动踏板");
			Car_wgpzxm.put("0298", "尾气检验报告单");
			Car_wgpzxm.put("0220", "机动车安全技术检验报告单9");
			Car_wgpzxm.put("0223", "机动车安全技术检验报告单12");
			Car_wgpzxm.put("0137", "柴油发动机典型环保装置及后处理系统");
			Car_wgpzxm.put("0361", "外廓尺寸自动测量-后");
			Car_wgpzxm.put("0124", "三角警示牌");
			Car_wgpzxm.put("0350", "四轴制动工位照片");
			Car_wgpzxm.put("0204", "机动车安全技术检验报告单");
			Car_wgpzxm.put("0177", "轮胎规格");
			Car_wgpzxm.put("0115", "车厢内部照片");
			Car_wgpzxm.put("0171", "发动机供油系统（高压共轨）");
			Car_wgpzxm.put("0185", "座位布置形式");
			Car_wgpzxm.put("0226", "机动车安全技术检验报告单15");
			Car_wgpzxm.put("0212", "机动车安全技术检验报告单1");
			Car_wgpzxm.put("0214", "机动车安全技术检验报告单3");
			Car_wgpzxm.put("0188", "手动机械断电开关");
			Car_wgpzxm.put("0345", "路试坡度驻车制动照片");
			Car_wgpzxm.put("0164", "火花熄灭装置");
			Car_wgpzxm.put("0215", "机动车牌证申请表");
			Car_wgpzxm.put("0351", "驻车制动工位照片");
			Car_wgpzxm.put("0174", "路试驻车制动照片");
			Car_wgpzxm.put("0175", "路试设备安装情况");
			Car_wgpzxm.put("0117", "应急锤照片");
			Car_wgpzxm.put("0225", "机动车安全技术检验报告单14");
			Car_wgpzxm.put("0202", "机动车牌证申请表");
			Car_wgpzxm.put("0136", "左前轮胎规格型号");
			Car_wgpzxm.put("0199", "外检其他照片");
			Car_wgpzxm.put("0201", "机动车行驶证");
			Car_wgpzxm.put("0323", "底盘检验照片");
			Car_wgpzxm.put("0113", "车辆识别代号照片");
			Car_wgpzxm.put("0120", "安全顶窗照片");
			Car_wgpzxm.put("0157", "驾驶人座椅汽车安全带");
			Car_wgpzxm.put("0184", "照管人员座椅");
			Car_wgpzxm.put("0187", "车内最前方向后照片");
			Car_wgpzxm.put("0112", "车辆右后方斜视45度照片");
			Car_wgpzxm.put("0355", "六轴制动工位照片");
			Car_wgpzxm.put("0341", "路试行车制动开始照片");
			Car_wgpzxm.put("0186", "其他");
			Car_wgpzxm.put("0218", "机动车安全技术检验报告单7");
			Car_wgpzxm.put("0167", "海底阀");
			Car_wgpzxm.put("0296", "保险批单");
			if (Md_system.getDq().equals("广东")) {
				Car_wgpzxm.put("0172", "侧后防护栏");
			} else {
				Car_wgpzxm.put("0172", "后处理系统");
			}
			Car_wgpzxm.put("0169", "0BD接口");
			Car_wgpzxm.put("0352", "右灯光工位照片");
			Car_wgpzxm.put("0116", "灭火器照片");
			Car_wgpzxm.put("0322", "一轴制动工位照片");
			Car_wgpzxm.put("0297", "其他资料");
			Car_wgpzxm.put("0139", "校车的辅助倒车装置");
			Car_wgpzxm.put("0203", "机动车交通事故责任强制保险凭证");
			Car_wgpzxm.put("0156", "右后轮胎规格型号");
			Car_wgpzxm.put("0159", "校车标牌（前）正面照片");
			Car_wgpzxm.put("0342", "底盘动态检验结束照片");
			Car_wgpzxm.put("0179", "路试报告");
			Car_wgpzxm.put("0134", "防抱死制动装置自检状态灯");
			Car_wgpzxm.put("0347", "车速表工位照片");
			Car_wgpzxm.put("0127", "急救箱");
			Car_wgpzxm.put("0181", "机动车侧面照片");
			Car_wgpzxm.put("0183", "行驶记录仪或GPS照片");
			Car_wgpzxm.put("0128", "校车标志灯照片");
			Car_wgpzxm.put("0168", "紧急切断装置（开关）");
			Car_wgpzxm.put("0125", "乘客门、应急门（窗）");
			Car_wgpzxm.put("0126", "校车停车指示标志牌照片");
			Car_wgpzxm.put("0163", "危险货物运输车标志");
			Car_wgpzxm.put("0360", "外廓尺寸自动测量-前");
			Car_wgpzxm.put("0219", "机动车安全技术检验报告单8");
			Car_wgpzxm.put("0155", "左后轮胎规格型号");
			Car_wgpzxm.put("0131", "乘客门应急开关");
			Car_wgpzxm.put("0165", "车身标识、字体喷涂");
			Car_wgpzxm.put("0353", "侧滑工位照片");
			Car_wgpzxm.put("0133", "前轮盘式制动器");
			Car_wgpzxm.put("0173", "后轴钢板弹簧片数");
			Car_wgpzxm.put("0207", "委托核发检验合格标志通知书");
			Car_wgpzxm.put("0208", "代理人授权书");
			Car_wgpzxm.put("0222", "机动车安全技术检验报告单11");
			Car_wgpzxm.put("0111", "车辆左前方斜视45度照片");
		}
	}

	public static void initCarWGPZXM() {
		if (Car_wgpzxm == null || Car_wgpzxm.isEmpty()) {
			Car_wgpzxm = null;
			Car_wgpzxm = new HashMap<String, String>();
			Car_wgpzxm.put("01", "机动车行驶证");
			Car_wgpzxm.put("02", "机动车牌证申请表");
			Car_wgpzxm.put("03", "机动车交通事故责任强制保险凭证");
			Car_wgpzxm.put("04", "机动车安全技术检验报告单");
			Car_wgpzxm.put("05", "机动车查验记录表");
			Car_wgpzxm.put("06", "车船税纳税或者免税证明");
			Car_wgpzxm.put("07", "委托核发检验合格标志通知书");
			Car_wgpzxm.put("08", "代理人授权书");
			Car_wgpzxm.put("11", "车前斜视45度照片");
			Car_wgpzxm.put("12", "车后斜视45度照片");
			Car_wgpzxm.put("13", "车辆识别代号照片");
			Car_wgpzxm.put("14", "机动车侧面照片");
			Car_wgpzxm.put("15", "车内最前方向后照片");
			Car_wgpzxm.put("16", "灭火器照片");
			Car_wgpzxm.put("17", "安全手锤照片");
			Car_wgpzxm.put("18", "行驶记录仪或GPS照片");
			Car_wgpzxm.put("19", "发动机号或柔性标签");
			Car_wgpzxm.put("20", "安全顶窗照片");
			Car_wgpzxm.put("21", "灯光工位拍摄照片");
			Car_wgpzxm.put("22", "制动工位拍摄照片");
			Car_wgpzxm.put("23", "底盘工位拍摄照片");
			Car_wgpzxm.put("24", "三角警示牌");
			Car_wgpzxm.put("25", "乘客门、应急门（窗）");
			Car_wgpzxm.put("26", "校车标志牌");
			Car_wgpzxm.put("27", "急救箱");
			Car_wgpzxm.put("28", "校车标志灯和停车指示标志");
			Car_wgpzxm.put("29", "照管人员座椅");
			Car_wgpzxm.put("30", "缓速器操作装置图形标志");
			Car_wgpzxm.put("31", "乘客门应急开关");
			Car_wgpzxm.put("32", "发动机自动灭火装置");
			Car_wgpzxm.put("33", "前轮盘式制动器");
			Car_wgpzxm.put("34", "ABS自检状态灯");
			Car_wgpzxm.put("35", "残疾车操纵辅助装置和自动变速器");
			Car_wgpzxm.put("36", "轮胎规格型号");
			Car_wgpzxm.put("37", "柴油发动机典型环保装置及后处理系统");
			Car_wgpzxm.put("38", "校车、卧铺客车的车内外录像监控系统");
			Car_wgpzxm.put("39", "校车的辅助倒车装置");
			Car_wgpzxm.put("40", "教练车辅助制动装置");
			Car_wgpzxm.put("41", "路试照片");
			Car_wgpzxm.put("42", "安全手锤及侧窗");
			Car_wgpzxm.put("43", "安全带");
			Car_wgpzxm.put("50", "路试原始记录单");
			Car_wgpzxm.put("51", "路试驻车制动照片");
			Car_wgpzxm.put("52", "路试设备安装照片");
			Car_wgpzxm.put("53", "钢板弹簧");
			Car_wgpzxm.put("54", "轮胎磨损情况");
			Car_wgpzxm.put("55", "座位布置形式");
			Car_wgpzxm.put("56", "车用气瓶使用登记证");
			Car_wgpzxm.put("57", "国产机动车整车出厂合格证明");
			Car_wgpzxm.put("99", "其他");
		}
	}

	public static List<String[]> wgjyfl = null;
	public static String[] wgjyflname = new String[] { "车辆唯一性认定", "车身外观",
			"照明和电气型号装置", "发动机舱", "驾驶室（区）", "发动机运转状况", "客车内部", "底盘件", "轮胎", "其他" };

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
	public static String[] wgjyflname2 = new String[] { "车辆外观检验" };

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
	public static String[] wgjyflname3 = new String[] { "车辆外观检验(01-40、80、81)",
			"车辆唯一性认定(001-006)", "车身外观(007-016)", "照明和电气型号装置(017-030)",
			"发动机舱(031-035)", "驾驶室(036-047)", "发动机运转状况(048-052)",
			"客车内部(053-060)", "底盘件(061-066)", "轮胎(067-070)", "其他(071)" };

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
	public static String[] dtdpjyflname = new String[] { "转向系", "转动系", "制动系",
			"驾驶区" };

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
	public static String[] dtdpjyflname2 = new String[] { "动态底盘检验" };

	public static void initDtdpjyfl2() {
		if (dtdpjyfl2 == null) {
			dtdpjyfl2 = new ArrayList<String[]>();
		}
		dtdpjyfl2.add(new String[] { "041", "042", "043", "044" });
	}

	public static List<String[]> dtdpjyfl3 = null;
	public static String[] dtdpjyflname3 = new String[] { "动态底盘检验(41-44)",
			"转向系(072-074)", "转动系(075-078)", "制动系(079-082)", "驾驶区(083)" };

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
	public static String[] dpjyflname = new String[] { "转向系", "转动系", "行驶系",
			"制动系", "电器线路", "底盘其他部件" };

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
	public static String[] dpjyflname2 = new String[] { "底盘" };

	public static void initDpjyfl2() {
		if (dpjyfl2 == null) {
			dpjyfl2 = new ArrayList<String[]>();
		}
		dpjyfl2.add(new String[] { "045", "046", "047", "048", "049" });
	}

	public static List<String[]> dpjyfl3 = null;
	public static String[] dpjyflname3 = new String[] { "底盘(45-49)",
			"转向系(084-085)", "转动系(086-088)", "行驶系(089-096)", "制动系(097-100)",
			"电器线路(101)", "底盘其他部件(102-104)" };

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
	public static String[] cytyflname = new String[] { "通用项目", "货车挂车",
			"大中型客车/危化品运输车", "其他" };

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
	public static String[] cyxcflname = new String[] { "校车通用项目", "校车专用项目",
			"校车其他" };

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

	/**** 摩托车 ******/
	public static List<String[]> mt_wgjyfl3 = null;
	public static String[] mt_wgjyflname3 = new String[] { "摩托车外观检验", "车灯",
			"轮胎", "其他" };

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
	public static String[] mt_dtdpjyflname3 = new String[] { "动态检验" };

	public static void mt_initDtdpjyfl3() {
		if (mt_dtdpjyfl3 == null) {
			mt_dtdpjyfl3 = new ArrayList<String[]>();
		}
		mt_dtdpjyfl3.add(new String[] { "039", "040", "041", "042", "043",
				"044", "045" });
	}

	public static List<String[]> mt_dpjyfl3 = null;
	public static String[] mt_dpjyflname3 = new String[] { "下部检验" };

	public static void initmt_Dpjyfl3() {
		if (mt_dpjyfl3 == null) {
			mt_dpjyfl3 = new ArrayList<String[]>();
		}
		mt_dpjyfl3.add(new String[] { "046", "047", "048", "049", "050" });
	}

	/**
	 * 获取检验项目
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
	 * 获取xml和节点
	 * 
	 * @param bhgx
	 * @param hgx
	 * @param requestDate
	 * @param xml
	 */
	public static String HG = "1"; // 合格
	public static String BHG = "2"; // 不合格
	public static String WJ = "0"; // 未检

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

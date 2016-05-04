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
 * 数据准备 
 * @author Administrator
 *
 *修改照片排序，并且将其他照片加上序号
 *修改人：chenyujin
 *时间：2016-1-5 11:38:44
 */
public class MD_ListItem {

	/**
	 * 匹配 获取 id
	 * 
	 * @return 默认 返回0
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
	 * 根据pos获取vlaue
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
	 * 匹配 获取 id
	 * 
	 * @return 默认 返回0
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
	 * 匹配 获取 id
	 * 
	 * @return 默认 返回0
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
	 * 获取 全国省 简称
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_sf() {
		String hphmfl = "川,京,新车,WJ川,贵,云,沪,津,渝,黑,吉,辽,蒙,冀,新,甘,青,陕,宁,豫,鲁,晋,皖,鄂,湘,苏,黔,滇,桂,藏,浙,赣,粤,闽,台,琼,港,澳";
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
			list.add(new Md_cartype("川", "川"));
			list.add(new Md_cartype("新车", "新车"));
			list.add(new Md_cartype("WJ川", "WJ川"));
			list.add(new Md_cartype("贵", "贵"));
			list.add(new Md_cartype("云", "云"));
			list.add(new Md_cartype("京", "京"));
			list.add(new Md_cartype("使", "使"));
			list.add(new Md_cartype("沪", "沪"));
			list.add(new Md_cartype("津", "津"));
			list.add(new Md_cartype("渝", "渝"));
			list.add(new Md_cartype("黑", "黑"));
			list.add(new Md_cartype("吉", "吉"));
			list.add(new Md_cartype("辽", "辽"));
			list.add(new Md_cartype("蒙", "蒙"));
			list.add(new Md_cartype("冀", "冀"));
			list.add(new Md_cartype("新", "新"));
			list.add(new Md_cartype("甘", "甘"));
			list.add(new Md_cartype("青", "青"));
			list.add(new Md_cartype("陕", "陕"));
			list.add(new Md_cartype("宁", "宁"));
			list.add(new Md_cartype("豫", "豫"));
			list.add(new Md_cartype("鲁", "鲁"));
			list.add(new Md_cartype("晋", "晋"));
			list.add(new Md_cartype("皖", "皖"));
			list.add(new Md_cartype("鄂", "鄂"));
			list.add(new Md_cartype("湘", "湘"));
			list.add(new Md_cartype("苏", "苏"));
			list.add(new Md_cartype("黔", "黔"));
			list.add(new Md_cartype("滇", "滇"));
			list.add(new Md_cartype("桂", "桂"));
			list.add(new Md_cartype("藏", "藏"));
			list.add(new Md_cartype("浙", "浙"));
			list.add(new Md_cartype("赣", "赣"));
			list.add(new Md_cartype("粤", "粤"));
			list.add(new Md_cartype("闽", "闽"));
			list.add(new Md_cartype("台", "台"));
			list.add(new Md_cartype("琼", "琼"));
			list.add(new Md_cartype("港", "港"));
			list.add(new Md_cartype("澳", "澳"));
		}
		list.add(new Md_cartype(" ", " "));
		return list;
	}

	/**
	 * 获取 全国省 简称
	 * 
	 * @return
	 */

	public static String Get_sfs(String sf) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("川", "川");
		resultMap.put("新车", "新车");
		resultMap.put("云", "云");
		resultMap.put("京", "京");
		resultMap.put("沪", "沪");
		resultMap.put("津", "津");
		resultMap.put("渝", "渝");
		resultMap.put("黑", "黑");
		resultMap.put("吉", "吉");
		resultMap.put("辽", "辽");
		resultMap.put("蒙", "蒙");
		resultMap.put("冀", "冀");
		resultMap.put("新", "新");
		resultMap.put("甘", "甘");
		resultMap.put("青", "青");
		resultMap.put("陕", "陕");
		resultMap.put("宁", "宁");
		resultMap.put("豫", "豫");
		resultMap.put("鲁", "鲁");
		resultMap.put("晋", "晋");
		resultMap.put("皖", "皖");
		resultMap.put("鄂", "鄂");
		resultMap.put("湘", "湘");
		resultMap.put("苏", "苏");
		resultMap.put("黔", "黔");
		resultMap.put("滇", "滇");
		resultMap.put("桂", "桂");
		resultMap.put("藏", "藏");
		resultMap.put("浙", "浙");
		resultMap.put("赣", "赣");
		resultMap.put("粤", "粤");
		resultMap.put("闽", "闽");
		resultMap.put("台", "台");
		resultMap.put("琼", "琼");
		resultMap.put("港", "港");
		resultMap.put("澳", "澳");
		return resultMap.get(sf);
	}

	/**
	 * 获取业务类型
	 * 
	 * @param id
	 * @return
	 */
	public static String getYwlx(int id) {
		String sywlx = "";
		switch (id) {
		case 0:
			sywlx = "变更车身颜色";
			break;
		case 1:
			sywlx = "变更迁出";
			break;
		case 2:
			sywlx = "变更使用性质";
			break;
		case 3:
			sywlx = "更换车身或者车架";
			break;
		case 4:
			sywlx = "补领登记证书";
			break;
		case 5:
			sywlx = "更换发动机";
			break;
		case 6:
			sywlx = "更换整车";
			break;
		case 7:
			sywlx = "核发检验合格标志";
			break;
		case 8:
			sywlx = "监销";
			break;
		case 9:
			sywlx = "其他";
			break;
		case 10:
			sywlx = "申领登记证书";
			break;
		case 11:
			sywlx = "重新打刻发动机号";
			break;
		case 12:
			sywlx = "重新打刻 VIN";
			break;
		case 13:
			sywlx = "注册登记";
			break;
		case 14:
			sywlx = "转入";
			break;
		case 15:
			sywlx = "转移登记";
			break;
		}
		return sywlx;
	}

	/**
	 * 获取车辆检测类型
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jylb() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("01", "01:在用车检验（定检）"));
		list.add(new Md_cartype("00", "00:注册登记检验"));
		list.add(new Md_cartype("02", "02:临时检验"));
		// list.add(new Md_cartype("03", "03:特殊检验"));
		list.add(new Md_cartype("04", "04:在用车检验（非定检）"));
		return list;
	}

	/**
	 * 获取车辆检测类型子类（非定检）
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jylbzlfdj() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0401", "0401:更换发动机"));
		list.add(new Md_cartype("0402", "0402:更换车身或车架"));
		list.add(new Md_cartype("0403", "0403:转入逾期"));
		list.add(new Md_cartype("0404", "0404:变更整车"));
		list.add(new Md_cartype("0405", "0405:自学用车"));
		list.add(new Md_cartype("0499", "0499:其它"));
		return list;
	}

	/**
	 * 获取车辆检测类型子类（临时检验）
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jylbzllsjy() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0201", "0201:保障用车"));
		list.add(new Md_cartype("0202", "0202:事故车"));
		list.add(new Md_cartype("0203", "0203:申请试车号牌"));
		list.add(new Md_cartype("0204", "0204:临时入境"));
		list.add(new Md_cartype("0299", "0299:其它"));
		return list;
	}

	/**
	 * 获取检测线类别
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_Jcxlb() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "请选择"));
		list.add(new Md_cartype("1", "机动车线"));
		list.add(new Md_cartype("2", "摩托车线"));
		return list;
	}

	/**
	 * 车辆所属类别
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_clsslb() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("01", "01:常规"));
		list.add(new Md_cartype("02", "02:全时四驱"));
		list.add(new Md_cartype("03", "03:超重"));
		list.add(new Md_cartype("04", "04:超宽"));
		list.add(new Md_cartype("05", "05:驱动防滑"));
		list.add(new Md_cartype("06", "06:双后轴驱动"));
		list.add(new Md_cartype("07", "07:挂车"));
		list.add(new Md_cartype("08", "08:灯位超高"));
		list.add(new Md_cartype("09", "09:多轴车"));
		list.add(new Md_cartype("10", "10:其它特种车"));
		return list;
	}

	/**
	 * 国产、进口
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_gcjk() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "国产"));
		list.add(new Md_cartype("1", "进口"));
		return list;
	}

	/**
	 * 国产、进口
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_dybj() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "未抵押"));
		list.add(new Md_cartype("1", "已抵押"));
		return list;
	}

	/**
	 * 获取 车辆类型
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_cllx() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		// list.add(new Md_cartype("01", "微、小型载客汽车"));
		// list.add(new Md_cartype("02", "中型载客汽车"));
		// list.add(new Md_cartype("03", "大型载客汽车"));
		// list.add(new Md_cartype("04", "载货汽车（包括牵引半挂车）"));
		// list.add(new Md_cartype("05", "危险化学品运输车"));

		// K开头
		list.add(new Md_cartype("K33", "K33:轿车"));
		list.add(new Md_cartype("K11", "K11:大型普通客车"));
		list.add(new Md_cartype("K12", "K12:大型双层客车"));
		list.add(new Md_cartype("K13", "K13:大型卧铺客车"));
		list.add(new Md_cartype("K14", "K14:大型铰接客车"));
		list.add(new Md_cartype("K15", "K15:大型越野客车"));
		list.add(new Md_cartype("K16", "K16:大型轿车"));
		list.add(new Md_cartype("K17", "K17:大型专用客车"));
		list.add(new Md_cartype("K18", "K18:大型专用校车"));
		list.add(new Md_cartype("K21", "K21:中型普通客车"));
		list.add(new Md_cartype("K22", "K22:中型双层客车"));
		list.add(new Md_cartype("K23", "K23:中型卧铺客车"));
		list.add(new Md_cartype("K24", "K24:中型铰接客车"));
		list.add(new Md_cartype("K25", "K25:中型越野客车"));
		list.add(new Md_cartype("K26", "K26:中型轿车"));
		list.add(new Md_cartype("K27", "K27:中型专用客车"));
		list.add(new Md_cartype("K28", "K28:中型专用校车"));
		list.add(new Md_cartype("K31", "K31:小型普通客车"));
		list.add(new Md_cartype("K32", "K32:小型越野客车"));
		list.add(new Md_cartype("K34", "K34:小型专用客车"));
		list.add(new Md_cartype("K38", "K38:小型专用校车"));
		list.add(new Md_cartype("K39", "K39:小型面包车"));
		list.add(new Md_cartype("K41", "K41:微型普通客车"));
		list.add(new Md_cartype("K42", "K42:微型越野客车"));
		list.add(new Md_cartype("K43", "K43:微型轿车"));
		list.add(new Md_cartype("K49", "K49:微型面包车"));
		// B开头
		list.add(new Md_cartype("B11", "B1：重型普通半挂车"));
		list.add(new Md_cartype("B12", "B12：重型厢式半挂车"));
		list.add(new Md_cartype("B13", "B13:重型罐式半挂车"));
		list.add(new Md_cartype("B14", "B14:重型平板半挂车"));
		list.add(new Md_cartype("B15", "B15：重型集装箱半挂车"));
		list.add(new Md_cartype("B16", "B16：重型自卸半挂车"));
		list.add(new Md_cartype("B17", "B17：重型特殊结构半挂车"));
		list.add(new Md_cartype("B18", "B18：重型仓栅式半挂车"));
		list.add(new Md_cartype("B19", "B19：重型旅居半挂车"));
		list.add(new Md_cartype("B1A", "B1A：重型专项作业半挂车"));
		list.add(new Md_cartype("B1B", "B1B：重型低平板半挂车"));
		list.add(new Md_cartype("B1C", "B1C：重型车辆运输半挂车"));
		list.add(new Md_cartype("B1D", "B1D：重型罐式自卸半挂车"));
		list.add(new Md_cartype("B1E", "B1E：重型平板自卸半挂车"));
		list.add(new Md_cartype("B1F", "B1F：重型集装箱自卸半挂车"));
		list.add(new Md_cartype("B1G", "B1G：重型特殊结构自卸半挂车"));
		list.add(new Md_cartype("B1H", "B1H：重型仓栅式自卸半挂车"));
		list.add(new Md_cartype("B1J", "B1J：重型专项作业自卸半挂车"));
		list.add(new Md_cartype("B1K", "B1K：重型低平板自卸半挂车"));
		list.add(new Md_cartype("B1U", "B1U：重型中置轴旅居挂车"));
		list.add(new Md_cartype("B1V", "B1V：重型中置轴车辆运输车"));
		list.add(new Md_cartype("B1W", "B1W：重型中置轴普通挂车"));
		list.add(new Md_cartype("B21", "B21：中型普通半挂车"));
		list.add(new Md_cartype("B22", "B22：中型厢式半挂车"));
		list.add(new Md_cartype("B23", "B23：中型罐式半挂车"));
		list.add(new Md_cartype("B24", "B24：中型平板半挂车"));
		list.add(new Md_cartype("B25", "B25：中型集装箱半挂车"));
		list.add(new Md_cartype("B26", "B26：中型自卸半挂车"));
		list.add(new Md_cartype("B27", "B27：中型特殊结构半挂车"));
		list.add(new Md_cartype("B28", "B28：中型仓栅式半挂车"));
		list.add(new Md_cartype("B29", "B29：中型旅居半挂车"));
		list.add(new Md_cartype("B2A", "B2A：中型专项作业半挂车"));
		list.add(new Md_cartype("B2B", "B2B：中型低平板半挂车"));
		list.add(new Md_cartype("B2C", "B2C：中型车辆运输半挂车"));
		list.add(new Md_cartype("B2D", "B2D：中型罐式自卸半挂车"));
		list.add(new Md_cartype("B2E", "B2E：中型平板自卸半挂车"));
		list.add(new Md_cartype("B2F", "B2F：中型集装箱自卸半挂车"));
		list.add(new Md_cartype("B2G", "B2G：中型特殊结构自卸半挂车"));
		list.add(new Md_cartype("B2H", "B2H：中型仓栅式自卸半挂车"));
		list.add(new Md_cartype("B2J", "B2J：中型专项作业自卸半挂车"));
		list.add(new Md_cartype("B2K", "B2K：中型低平板自卸半挂车"));
		list.add(new Md_cartype("B2U", "B2U：中型中置轴旅居挂车"));
		list.add(new Md_cartype("B2V", "B2V：中型中置轴车辆运输车"));
		list.add(new Md_cartype("B2W", "B2W：中型中置轴普通挂车"));
		list.add(new Md_cartype("B31", "B31：轻型普通半挂车"));
		list.add(new Md_cartype("B32", "B32：轻型厢式半挂车"));
		list.add(new Md_cartype("B33", "B33：轻型罐式半挂车"));
		list.add(new Md_cartype("B34", "B34：轻型平板半挂车"));
		list.add(new Md_cartype("B35", "B35：轻型自卸半挂车"));
		list.add(new Md_cartype("B36", "B36：轻型仓栅式半挂车"));
		list.add(new Md_cartype("B37", "B37：轻型旅居半挂车"));
		list.add(new Md_cartype("B38", "B38：轻型专项作业半挂车"));
		list.add(new Md_cartype("B39", "B39：轻型低平板半挂车"));
		list.add(new Md_cartype("B3C", "B3C：轻型车辆运输半挂车"));
		list.add(new Md_cartype("B3D", "B3D：轻型罐式自卸半挂车"));
		list.add(new Md_cartype("B3E", "B3E：轻型平板自卸半挂车"));
		list.add(new Md_cartype("B3F", "B3F：轻型集装箱自卸半挂车"));
		list.add(new Md_cartype("B3G", "B3G：轻型特殊结构自卸半挂车"));
		list.add(new Md_cartype("B3H", "B3H：轻型仓栅式自卸半挂车"));
		list.add(new Md_cartype("B3J", "B3J：轻型专项作业自卸半挂车"));
		list.add(new Md_cartype("B3K", "B3K：轻型低平板自卸半挂车"));
		list.add(new Md_cartype("B3U", "B3U：轻型中置轴旅居挂车"));
		list.add(new Md_cartype("B3V", "B3V：轻型中置轴车辆运输车"));
		list.add(new Md_cartype("B3W", "B3W：轻型中置轴普通挂车"));
		// H开头
		list.add(new Md_cartype("H11", "H11：重型普通货车"));
		list.add(new Md_cartype("H12", "H12：重型厢式货车"));
		list.add(new Md_cartype("H13", "H13：重型封闭货车"));
		list.add(new Md_cartype("H14", "H14：重型罐式货车"));
		list.add(new Md_cartype("H15", "H15：重型平板货车"));
		list.add(new Md_cartype("H16", "H16：重型集装厢车"));
		list.add(new Md_cartype("H17", "H17：重型自卸货车"));
		list.add(new Md_cartype("H18", "H18：重型特殊结构货车"));
		list.add(new Md_cartype("H19", "H19：重型仓栅式货车"));
		list.add(new Md_cartype("H1A", "H1A：重型车辆运输车"));
		list.add(new Md_cartype("H1B", "H1B：重型厢式自卸货车"));
		list.add(new Md_cartype("H1C", "H1C：重型罐式自卸货车"));
		list.add(new Md_cartype("H1D", "H1D：重型平板自卸货车"));
		list.add(new Md_cartype("H1E", "H1E：重型集装厢自卸货车"));
		list.add(new Md_cartype("H1F", "H1F：重型特殊结构自卸货车"));
		list.add(new Md_cartype("H1G", "H1G：重型仓栅式自卸货车"));
		list.add(new Md_cartype("H21", "H21：中型普通货车"));
		list.add(new Md_cartype("H22", "H22：中型厢式货车"));
		list.add(new Md_cartype("H23", "H23：中型封闭货车"));
		list.add(new Md_cartype("H24", "H24：中型罐式货车"));
		list.add(new Md_cartype("H25", "H25:中型平板货车"));
		list.add(new Md_cartype("H26", "H26:中型集装厢车"));
		list.add(new Md_cartype("H27", "H27:中型自卸货车"));
		list.add(new Md_cartype("H28", "H28:中型特殊结构货车"));
		list.add(new Md_cartype("H29", "H29:中型仓栅式货车"));
		list.add(new Md_cartype("H2A", "H2A:中型车辆运输车"));
		list.add(new Md_cartype("H2B", "H2B:中型厢式自卸货车"));
		list.add(new Md_cartype("H2C", "H2C:中型罐式自卸货车"));
		list.add(new Md_cartype("H2D", "H2D：中型平板自卸货车"));
		list.add(new Md_cartype("H2E", "H2E:中型集装厢自卸货车"));
		list.add(new Md_cartype("H2F", "H2F:中型特殊结构自卸货车"));
		list.add(new Md_cartype("H2G", "H2G:中型仓栅式自卸货车"));
		list.add(new Md_cartype("H31", "H31:轻型普通货车"));
		list.add(new Md_cartype("H32", "H32:轻型厢式货车"));
		list.add(new Md_cartype("H33", "H33:轻型封闭货车"));
		list.add(new Md_cartype("H34", "H34:轻型罐式货车"));
		list.add(new Md_cartype("H35", "H35:轻型平板货车"));
		list.add(new Md_cartype("H37", "H37:轻型自卸货车"));
		list.add(new Md_cartype("H38", "H38:轻型特殊结构货车"));
		list.add(new Md_cartype("H39", "H39:轻型仓栅式货车"));
		list.add(new Md_cartype("H39", "H39:轻型车辆运输车"));
		list.add(new Md_cartype("H3A", "H3A:轻型车辆运输车"));
		list.add(new Md_cartype("H3B", "H3B:轻型厢式自卸货车"));
		list.add(new Md_cartype("H3C", "H3C:轻型罐式自卸货车"));
		list.add(new Md_cartype("H3D", "H3D:轻型平板自卸货车"));
		list.add(new Md_cartype("H3E", "H3E:轻型集装厢自卸货车"));
		list.add(new Md_cartype("H3F", "H3F:轻型特殊结构自卸货车"));
		list.add(new Md_cartype("H3G", "H3G:轻型仓栅式自卸货车"));
		list.add(new Md_cartype("H41", "H41:微型普通货车"));
		list.add(new Md_cartype("H42", "H42:微型厢式货车"));
		list.add(new Md_cartype("H43", "H43:微型封闭货车"));
		list.add(new Md_cartype("H44", "H44:微型罐式货车"));
		list.add(new Md_cartype("H45", "H45:微型自卸货车"));
		list.add(new Md_cartype("H46", "H46:微型特殊结构货车"));
		list.add(new Md_cartype("H47", "H47:微型仓栅式货车"));
		list.add(new Md_cartype("H4A", "H4A:微型车辆运输车"));
		list.add(new Md_cartype("H4B", "H4B:微型厢式自卸货车"));
		list.add(new Md_cartype("H4C", "H4C:微型罐式自卸货车"));
		list.add(new Md_cartype("H4F", "H4F:微型特殊结构自卸货车"));
		list.add(new Md_cartype("H4G", "H4G:微型仓栅式自卸货车"));
		list.add(new Md_cartype("H51", "H51:低速普通货车"));
		list.add(new Md_cartype("H52", "H52:低速厢式货车"));
		list.add(new Md_cartype("H53", "H53:低速罐式货车"));
		list.add(new Md_cartype("H54", "H54:自卸低速货车"));
		list.add(new Md_cartype("H55", "H55:仓栅式低速货车"));
		list.add(new Md_cartype("H5B", "H5B:厢式自卸低速货车"));
		list.add(new Md_cartype("H5C", "H5C:罐式自卸低速货车"));
		// Z开头
		list.add(new Md_cartype("Z11", "Z11:大型专项作业车"));
		list.add(new Md_cartype("Z12", "Z12:大型载货专项作业车"));
		list.add(new Md_cartype("Z21", "Z21:中型专项作业车"));
		list.add(new Md_cartype("Z22", "Z22:中型载货专项作业车"));
		list.add(new Md_cartype("Z31", "Z31:小型专项作业车"));
		list.add(new Md_cartype("Z32", "Z32:小型载货专项作业车"));
		list.add(new Md_cartype("Z41", "Z41:微型专项作业车"));
		list.add(new Md_cartype("Z42", "Z42:微型载货专项作业车"));
		list.add(new Md_cartype("Z51", "Z51:重型专项作业车"));
		list.add(new Md_cartype("Z52", "Z52:重型载货专项作业车"));
		list.add(new Md_cartype("Z71", "Z71:轻型专项作业车"));
		list.add(new Md_cartype("Z72", "Z72:轻型载货专项作业车"));
		// D开头
		list.add(new Md_cartype("D11", "D11:无轨电车"));
		list.add(new Md_cartype("D12", "D12:有轨电车"));
		// M开头
		list.add(new Md_cartype("M11", "M11:普通正三轮摩托车"));
		list.add(new Md_cartype("M12", "M12:轻便正三轮摩托车"));
		list.add(new Md_cartype("M13", "M13:正三轮载客摩托车"));
		list.add(new Md_cartype("M14", "M14:正三轮载货摩托车"));
		list.add(new Md_cartype("M15", "M15:侧三轮摩托车"));
		list.add(new Md_cartype("M21", "M21:普通二轮摩托车"));
		list.add(new Md_cartype("M22", "M22:轻便二轮摩托车"));
		// N开头
		list.add(new Md_cartype("N11", "N11:三轮汽车"));
		// Q开头
		list.add(new Md_cartype("Q11", "Q11:重型半挂牵引车"));
		list.add(new Md_cartype("Q12", "Q12:重型全挂牵引车"));
		list.add(new Md_cartype("Q22", "Q22:中型全挂牵引车"));
		list.add(new Md_cartype("Q21", "Q21:中型半挂牵引车"));
		list.add(new Md_cartype("Q31", "Q31:轻型半挂牵引车"));
		list.add(new Md_cartype("Q32", "Q32:轻型全挂牵引车"));
		// T开头
		list.add(new Md_cartype("T11", "T11:大型轮式拖拉机"));
		list.add(new Md_cartype("T21", "T21:小型轮式拖拉机"));
		list.add(new Md_cartype("T22", "T22:手扶拖拉机"));
		list.add(new Md_cartype("T23", "T23:手扶变形运输机"));
		// J开头
		list.add(new Md_cartype("J11", "J11:轮式装载机械"));
		list.add(new Md_cartype("J12", "J12:轮式挖掘机械"));
		list.add(new Md_cartype("J13", "J13:轮式平地机械"));
		// G开头
		list.add(new Md_cartype("G11", "G11:重型普通全挂车"));
		list.add(new Md_cartype("G12", "G12:重型厢式全挂车"));
		list.add(new Md_cartype("G13", "G13:重型罐式全挂车"));
		list.add(new Md_cartype("G14", "G14:重型平板全挂车"));
		list.add(new Md_cartype("G15", "G15:重型集装箱全挂车"));
		list.add(new Md_cartype("G16", "G16:重型自卸全挂车"));
		list.add(new Md_cartype("G17", "G17:重型仓栅式全挂车"));
		list.add(new Md_cartype("G18", "G18:重型旅居全挂车"));
		list.add(new Md_cartype("G19", "G19:重型专项作业全挂车"));
		list.add(new Md_cartype("G1A", "G1A:重型厢式自卸全挂车"));
		list.add(new Md_cartype("G1B", "G1B:重型罐式自卸全挂车"));
		list.add(new Md_cartype("G1C", "G1C:重型平板自卸全挂车"));
		list.add(new Md_cartype("G1D", "G1D:重型集装箱自卸全挂车"));
		list.add(new Md_cartype("G1E", "G1E:重型仓栅式自卸全挂车"));
		list.add(new Md_cartype("G1F", "G1F:重型专项作业自卸全挂车"));
		list.add(new Md_cartype("G21", "G21:中型普通全挂车"));
		list.add(new Md_cartype("G22", "G22:中型厢式全挂车"));
		list.add(new Md_cartype("G23", "G23:中型罐式全挂车"));
		list.add(new Md_cartype("G24", "G24:中型平板全挂车"));
		list.add(new Md_cartype("G25", "G25:中型集装箱全挂车"));
		list.add(new Md_cartype("G26", "G26:中型自卸全挂车"));
		list.add(new Md_cartype("G27", "G27:中型仓栅式全挂车"));
		list.add(new Md_cartype("G28", "G28:中型旅居全挂车"));
		list.add(new Md_cartype("G29", "G29:中型专项作业全挂车"));
		list.add(new Md_cartype("G2A", "G2A:中型厢式自卸全挂车"));
		list.add(new Md_cartype("G2B", "G2B:中型罐式自卸全挂车"));
		list.add(new Md_cartype("G2C", "G2C:中型平板自卸全挂车"));
		list.add(new Md_cartype("G2D", "G2D:中型集装箱自卸全挂车"));
		list.add(new Md_cartype("G2E", "G2E:中型仓栅式自卸全挂车"));
		list.add(new Md_cartype("G2F", "G2F:中型专项作业自卸全挂车"));
		list.add(new Md_cartype("G31", "G31:轻型普通全挂车"));
		list.add(new Md_cartype("G32", "G32:轻型厢式全挂车"));
		list.add(new Md_cartype("G33", "G33:轻型罐式全挂车"));
		list.add(new Md_cartype("G34", "G34:轻型平板全挂车"));
		list.add(new Md_cartype("G35", "G35:轻型自卸全挂车"));
		list.add(new Md_cartype("G36", "G36:轻型仓栅式全挂车"));
		list.add(new Md_cartype("G37", "G37:轻型旅居全挂车"));
		list.add(new Md_cartype("G38", "G38:轻型专项作业全挂车"));
		list.add(new Md_cartype("G3A", "G3A:轻型厢式自卸全挂车"));
		list.add(new Md_cartype("G3B", "G3B:轻型罐式自卸全挂车"));
		list.add(new Md_cartype("G3C", "G3C:轻型平板自卸全挂车"));
		list.add(new Md_cartype("G3D", "G3D:轻型集装箱自卸全挂车"));
		list.add(new Md_cartype("G3E", "G3E:轻型仓栅式自卸全挂车"));
		list.add(new Md_cartype("G3F", "G3F:轻型专项作业自卸全挂车"));
		// X开:头
		list.add(new Md_cartype("X99", "X99:其他"));
		return list;
	}
	/**
	 * 获取 车辆类型
	 * 
	 * @return
	 */
	public static List<String> Get_cllxArray() {
		List<String> list = new ArrayList<String>();
		// list.add(new Md_cartype("01", "微、小型载客汽车"));
		// list.add(new Md_cartype("02", "中型载客汽车"));
		// list.add(new Md_cartype("03", "大型载客汽车"));
		// list.add(new Md_cartype("04", "载货汽车（包括牵引半挂车）"));
		// list.add(new Md_cartype("05", "危险化学品运输车"));

		// K开头
		list.add( "K33:轿车");
		list.add( "K11:大型普通客车");
		list.add( "K12:大型双层客车");
		list.add( "K13:大型卧铺客车");
		list.add( "K14:大型铰接客车");
		list.add( "K15:大型越野客车");
		list.add( "K16:大型轿车");
		list.add( "K17:大型专用客车");
		list.add( "K18:大型专用校车");
		list.add( "K21:中型普通客车");
		list.add( "K22:中型双层客车");
		list.add( "K23:中型卧铺客车");
		list.add( "K24:中型铰接客车");
		list.add( "K25:中型越野客车");
		list.add( "K26:中型轿车");
		list.add( "K27:中型专用客车");
		list.add( "K28:中型专用校车");
		list.add( "K31:小型普通客车");
		list.add( "K32:小型越野客车");
		list.add( "K34:小型专用客车");
		list.add( "K38:小型专用校车");
		list.add( "K39:小型面包车");
		list.add( "K41:微型普通客车");
		list.add( "K42:微型越野客车");
		list.add( "K43:微型轿车");
		list.add( "K49:微型面包车");
		// B开头
		list.add( "B1：重型普通半挂车");
		list.add( "B12：重型厢式半挂车");
		list.add( "B13:重型罐式半挂车");
		list.add( "B14:重型平板半挂车");
		list.add( "B15：重型集装箱半挂车");
		list.add( "B16：重型自卸半挂车");
		list.add( "B17：重型特殊结构半挂车");
		list.add( "B18：重型仓栅式半挂车");
		list.add( "B19：重型旅居半挂车");
		list.add( "B1A：重型专项作业半挂车");
		list.add( "B1B：重型低平板半挂车");
		list.add( "B1C：重型车辆运输半挂车");
		list.add( "B1D：重型罐式自卸半挂车");
		list.add( "B1E：重型平板自卸半挂车");
		list.add( "B1F：重型集装箱自卸半挂车");
		list.add( "B1G：重型特殊结构自卸半挂车");
		list.add( "B1H：重型仓栅式自卸半挂车");
		list.add( "B1J：重型专项作业自卸半挂车");
		list.add( "B1K：重型低平板自卸半挂车");
		list.add( "B1U：重型中置轴旅居挂车");
		list.add( "B1V：重型中置轴车辆运输车");
		list.add( "B1W：重型中置轴普通挂车");
		list.add( "B21：中型普通半挂车");
		list.add( "B22：中型厢式半挂车");
		list.add( "B23：中型罐式半挂车");
		list.add( "B24：中型平板半挂车");
		list.add( "B25：中型集装箱半挂车");
		list.add( "B26：中型自卸半挂车");
		list.add( "B27：中型特殊结构半挂车");
		list.add( "B28：中型仓栅式半挂车");
		list.add( "B29：中型旅居半挂车");
		list.add( "B2A：中型专项作业半挂车");
		list.add( "B2B：中型低平板半挂车");
		list.add( "B2C：中型车辆运输半挂车");
		list.add( "B2D：中型罐式自卸半挂车");
		list.add( "B2E：中型平板自卸半挂车");
		list.add( "B2F：中型集装箱自卸半挂车");
		list.add( "B2G：中型特殊结构自卸半挂车");
		list.add( "B2H：中型仓栅式自卸半挂车");
		list.add( "B2J：中型专项作业自卸半挂车");
		list.add( "B2K：中型低平板自卸半挂车");
		list.add( "B2U：中型中置轴旅居挂车");
		list.add( "B2V：中型中置轴车辆运输车");
		list.add( "B2W：中型中置轴普通挂车");
		list.add( "B31：轻型普通半挂车");
		list.add( "B32：轻型厢式半挂车");
		list.add( "B33：轻型罐式半挂车");
		list.add( "B34：轻型平板半挂车");
		list.add( "B35：轻型自卸半挂车");
		list.add( "B36：轻型仓栅式半挂车");
		list.add( "B37：轻型旅居半挂车");
		list.add( "B38：轻型专项作业半挂车");
		list.add( "B39：轻型低平板半挂车");
		list.add( "B3C：轻型车辆运输半挂车");
		list.add( "B3D：轻型罐式自卸半挂车");
		list.add( "B3E：轻型平板自卸半挂车");
		list.add( "B3F：轻型集装箱自卸半挂车");
		list.add( "B3G：轻型特殊结构自卸半挂车");
		list.add( "B3H：轻型仓栅式自卸半挂车");
		list.add( "B3J：轻型专项作业自卸半挂车");
		list.add( "B3K：轻型低平板自卸半挂车");
		list.add( "B3U：轻型中置轴旅居挂车");
		list.add( "B3V：轻型中置轴车辆运输车");
		list.add( "B3W：轻型中置轴普通挂车");
		// H开头
		list.add( "H11：重型普通货车");
		list.add( "H12：重型厢式货车");
		list.add( "H13：重型封闭货车");
		list.add( "H14：重型罐式货车");
		list.add( "H15：重型平板货车");
		list.add( "H16：重型集装厢车");
		list.add( "H17：重型自卸货车");
		list.add( "H18：重型特殊结构货车");
		list.add( "H19：重型仓栅式货车");
		list.add( "H1A：重型车辆运输车");
		list.add( "H1B：重型厢式自卸货车");
		list.add( "H1C：重型罐式自卸货车");
		list.add( "H1D：重型平板自卸货车");
		list.add( "H1E：重型集装厢自卸货车");
		list.add( "H1F：重型特殊结构自卸货车");
		list.add( "H1G：重型仓栅式自卸货车");
		list.add( "H21：中型普通货车");
		list.add( "H22：中型厢式货车");
		list.add( "H23：中型封闭货车");
		list.add( "H24：中型罐式货车");
		list.add( "H25:中型平板货车");
		list.add( "H26:中型集装厢车");
		list.add( "H27:中型自卸货车");
		list.add( "H28:中型特殊结构货车");
		list.add( "H29:中型仓栅式货车");
		list.add( "H2A:中型车辆运输车");
		list.add( "H2B:中型厢式自卸货车");
		list.add( "H2C:中型罐式自卸货车");
		list.add( "H2D：中型平板自卸货车");
		list.add( "H2E:中型集装厢自卸货车");
		list.add( "H2F:中型特殊结构自卸货车");
		list.add( "H2G:中型仓栅式自卸货车");
		list.add( "H31:轻型普通货车");
		list.add( "H32:轻型厢式货车");
		list.add( "H33:轻型封闭货车");
		list.add( "H34:轻型罐式货车");
		list.add( "H35:轻型平板货车");
		list.add( "H37:轻型自卸货车");
		list.add( "H38:轻型特殊结构货车");
		list.add( "H39:轻型仓栅式货车");
		list.add( "H39:轻型车辆运输车");
		list.add( "H3A:轻型车辆运输车");
		list.add( "H3B:轻型厢式自卸货车");
		list.add( "H3C:轻型罐式自卸货车");
		list.add( "H3D:轻型平板自卸货车");
		list.add( "H3E:轻型集装厢自卸货车");
		list.add( "H3F:轻型特殊结构自卸货车");
		list.add( "H3G:轻型仓栅式自卸货车");
		list.add( "H41:微型普通货车");
		list.add( "H42:微型厢式货车");
		list.add( "H43:微型封闭货车");
		list.add( "H44:微型罐式货车");
		list.add( "H45:微型自卸货车");
		list.add( "H46:微型特殊结构货车");
		list.add( "H47:微型仓栅式货车");
		list.add( "H4A:微型车辆运输车");
		list.add( "H4B:微型厢式自卸货车");
		list.add( "H4C:微型罐式自卸货车");
		list.add( "H4F:微型特殊结构自卸货车");
		list.add( "H4G:微型仓栅式自卸货车");
		list.add( "H51:低速普通货车");
		list.add( "H52:低速厢式货车");
		list.add( "H53:低速罐式货车");
		list.add( "H54:自卸低速货车");
		list.add( "H55:仓栅式低速货车");
		list.add( "H5B:厢式自卸低速货车");
		list.add( "H5C:罐式自卸低速货车");
		// Z开头
		list.add( "Z11:大型专项作业车");
		list.add( "Z12:大型载货专项作业车");
		list.add( "Z21:中型专项作业车");
		list.add( "Z22:中型载货专项作业车");
		list.add( "Z31:小型专项作业车");
		list.add( "Z32:小型载货专项作业车");
		list.add( "Z41:微型专项作业车");
		list.add( "Z42:微型载货专项作业车");
		list.add( "Z51:重型专项作业车");
		list.add( "Z52:重型载货专项作业车");
		list.add( "Z71:轻型专项作业车");
		list.add( "Z72:轻型载货专项作业车");
		// D开头
		list.add( "D11:无轨电车");
		list.add( "D12:有轨电车");
		// M开头
		list.add( "M11:普通正三轮摩托车");
		list.add( "M12:轻便正三轮摩托车");
		list.add( "M13:正三轮载客摩托车");
		list.add( "M14:正三轮载货摩托车");
		list.add( "M15:侧三轮摩托车");
		list.add( "M21:普通二轮摩托车");
		list.add( "M22:轻便二轮摩托车");
		// N开头
		list.add( "N11:三轮汽车");
		// Q开头
		list.add( "Q11:重型半挂牵引车");
		list.add( "Q12:重型全挂牵引车");
		list.add( "Q22:中型全挂牵引车");
		list.add( "Q21:中型半挂牵引车");
		list.add( "Q31:轻型半挂牵引车");
		list.add( "Q32:轻型全挂牵引车");
		// T开头
		list.add( "T11:大型轮式拖拉机");
		list.add( "T21:小型轮式拖拉机");
		list.add( "T22:手扶拖拉机");
		list.add( "T23:手扶变形运输机");
		// J开头
		list.add( "J11:轮式装载机械");
		list.add( "J12:轮式挖掘机械");
		list.add( "J13:轮式平地机械");
		// G开头
		list.add( "G11:重型普通全挂车");
		list.add( "G12:重型厢式全挂车");
		list.add( "G13:重型罐式全挂车");
		list.add( "G14:重型平板全挂车");
		list.add( "G15:重型集装箱全挂车");
		list.add( "G16:重型自卸全挂车");
		list.add( "G17:重型仓栅式全挂车");
		list.add( "G18:重型旅居全挂车");
		list.add( "G19:重型专项作业全挂车");
		list.add( "G1A:重型厢式自卸全挂车");
		list.add( "G1B:重型罐式自卸全挂车");
		list.add( "G1C:重型平板自卸全挂车");
		list.add( "G1D:重型集装箱自卸全挂车");
		list.add( "G1E:重型仓栅式自卸全挂车");
		list.add( "G1F:重型专项作业自卸全挂车");
		list.add( "G21:中型普通全挂车");
		list.add( "G22:中型厢式全挂车");
		list.add( "G23:中型罐式全挂车");
		list.add( "G24:中型平板全挂车");
		list.add( "G25:中型集装箱全挂车");
		list.add( "G26:中型自卸全挂车");
		list.add( "G27:中型仓栅式全挂车");
		list.add( "G28:中型旅居全挂车");
		list.add( "G29:中型专项作业全挂车");
		list.add( "G2A:中型厢式自卸全挂车");
		list.add( "G2B:中型罐式自卸全挂车");
		list.add( "G2C:中型平板自卸全挂车");
		list.add( "G2D:中型集装箱自卸全挂车");
		list.add( "G2E:中型仓栅式自卸全挂车");
		list.add( "G2F:中型专项作业自卸全挂车");
		list.add( "G31:轻型普通全挂车");
		list.add( "G32:轻型厢式全挂车");
		list.add( "G33:轻型罐式全挂车");
		list.add( "G34:轻型平板全挂车");
		list.add( "G35:轻型自卸全挂车");
		list.add( "G36:轻型仓栅式全挂车");
		list.add( "G37:轻型旅居全挂车");
		list.add( "G38:轻型专项作业全挂车");
		list.add( "G3A:轻型厢式自卸全挂车");
		list.add( "G3B:轻型罐式自卸全挂车");
		list.add( "G3C:轻型平板自卸全挂车");
		list.add( "G3D:轻型集装箱自卸全挂车");
		list.add( "G3E:轻型仓栅式自卸全挂车");
		list.add( "G3F:轻型专项作业自卸全挂车");
		// X开:头
		list.add( "X99:其他");
		
		
		list.add( "轿车");
		list.add( "大型普通客车");
		list.add( "大型双层客车");
		list.add( "大型卧铺客车");
		list.add( "大型铰接客车");
		list.add( "大型越野客车");
		list.add( "大型轿车");
		list.add( "大型专用客车");
		list.add( "大型专用校车");
		list.add( "中型普通客车");
		list.add( "中型双层客车");
		list.add( "中型卧铺客车");
		list.add( "中型铰接客车");
		list.add( "中型越野客车");
		list.add( "中型轿车");
		list.add( "中型专用客车");
		list.add( "中型专用校车");
		list.add( "小型普通客车");
		list.add( "小型越野客车");
		list.add( "小型专用客车");
		list.add( "小型专用校车");
		list.add( "小型面包车");
		list.add( "微型普通客车");
		list.add( "微型越野客车");
		list.add( "微型轿车");
		list.add( "微型面包车");
		// B开头
		list.add( "重型普通半挂车");
		list.add( "重型厢式半挂车");
		list.add( "重型罐式半挂车");
		list.add( "重型平板半挂车");
		list.add( "重型集装箱半挂车");
		list.add( "重型自卸半挂车");
		list.add( "重型特殊结构半挂车");
		list.add( "重型仓栅式半挂车");
		list.add( "重型旅居半挂车");
		list.add( "重型专项作业半挂车");
		list.add( "重型低平板半挂车");
		list.add( "重型车辆运输半挂车");
		list.add( "重型罐式自卸半挂车");
		list.add( "重型平板自卸半挂车");
		list.add( "重型集装箱自卸半挂车");
		list.add( "重型特殊结构自卸半挂车");
		list.add( "重型仓栅式自卸半挂车");
		list.add( "重型专项作业自卸半挂车");
		list.add( "重型低平板自卸半挂车");
		list.add( "重型中置轴旅居挂车");
		list.add( "重型中置轴车辆运输车");
		list.add( "重型中置轴普通挂车");
		list.add( "中型普通半挂车");
		list.add( "中型厢式半挂车");
		list.add( "中型罐式半挂车");
		list.add( "中型平板半挂车");
		list.add( "中型集装箱半挂车");
		list.add( "中型自卸半挂车");
		list.add( "中型特殊结构半挂车");
		list.add( "中型仓栅式半挂车");
		list.add( "中型旅居半挂车");
		list.add( "中型专项作业半挂车");
		list.add( "中型低平板半挂车");
		list.add( "中型车辆运输半挂车");
		list.add( "中型罐式自卸半挂车");
		list.add( "中型平板自卸半挂车");
		list.add( "中型集装箱自卸半挂车");
		list.add( "中型特殊结构自卸半挂车");
		list.add( "中型仓栅式自卸半挂车");
		list.add( "中型专项作业自卸半挂车");
		list.add( "中型低平板自卸半挂车");
		list.add( "中型中置轴旅居挂车");
		list.add( "中型中置轴车辆运输车");
		list.add( "中型中置轴普通挂车");
		list.add( "轻型普通半挂车");
		list.add( "轻型厢式半挂车");
		list.add( "轻型罐式半挂车");
		list.add( "轻型平板半挂车");
		list.add( "轻型自卸半挂车");
		list.add( "轻型仓栅式半挂车");
		list.add( "轻型旅居半挂车");
		list.add( "轻型专项作业半挂车");
		list.add( "轻型低平板半挂车");
		list.add( "轻型车辆运输半挂车");
		list.add( "轻型罐式自卸半挂车");
		list.add( "轻型平板自卸半挂车");
		list.add( "轻型集装箱自卸半挂车");
		list.add( "轻型特殊结构自卸半挂车");
		list.add( "轻型仓栅式自卸半挂车");
		list.add( "轻型专项作业自卸半挂车");
		list.add( "轻型低平板自卸半挂车");
		list.add( "轻型中置轴旅居挂车");
		list.add( "轻型中置轴车辆运输车");
		list.add( "轻型中置轴普通挂车");
		// H开头
		list.add( "重型普通货车");
		list.add( "重型厢式货车");
		list.add( "重型封闭货车");
		list.add( "重型罐式货车");
		list.add( "重型平板货车");
		list.add( "重型集装厢车");
		list.add( "重型自卸货车");
		list.add( "重型特殊结构货车");
		list.add( "重型仓栅式货车");
		list.add( "重型车辆运输车");
		list.add( "重型厢式自卸货车");
		list.add( "重型罐式自卸货车");
		list.add( "重型平板自卸货车");
		list.add( "重型集装厢自卸货车");
		list.add( "重型特殊结构自卸货车");
		list.add( "重型仓栅式自卸货车");
		list.add( "中型普通货车");
		list.add( "中型厢式货车");
		list.add( "中型封闭货车");
		list.add( "中型罐式货车");
		list.add( "中型平板货车");
		list.add( "中型集装厢车");
		list.add( "中型自卸货车");
		list.add( "中型特殊结构货车");
		list.add( "中型仓栅式货车");
		list.add( "中型车辆运输车");
		list.add( "中型厢式自卸货车");
		list.add( "中型罐式自卸货车");
		list.add( "中型平板自卸货车");
		list.add( "中型集装厢自卸货车");
		list.add( "中型特殊结构自卸货车");
		list.add( "中型仓栅式自卸货车");
		list.add( "轻型普通货车");
		list.add( "轻型厢式货车");
		list.add( "轻型封闭货车");
		list.add( "轻型罐式货车");
		list.add( "轻型平板货车");
		list.add( "轻型自卸货车");
		list.add( "轻型特殊结构货车");
		list.add( "轻型仓栅式货车");
		list.add( "轻型车辆运输车");
		list.add( "轻型车辆运输车");
		list.add( "轻型厢式自卸货车");
		list.add( "轻型罐式自卸货车");
		list.add( "轻型平板自卸货车");
		list.add( "轻型集装厢自卸货车");
		list.add( "轻型特殊结构自卸货车");
		list.add( "轻型仓栅式自卸货车");
		list.add( "微型普通货车");
		list.add( "微型厢式货车");
		list.add( "微型封闭货车");
		list.add( "微型罐式货车");
		list.add( "微型自卸货车");
		list.add( "微型特殊结构货车");
		list.add( "微型仓栅式货车");
		list.add( "微型车辆运输车");
		list.add( "微型厢式自卸货车");
		list.add( "微型罐式自卸货车");
		list.add( "微型特殊结构自卸货车");
		list.add( "微型仓栅式自卸货车");
		list.add( "低速普通货车");
		list.add( "低速厢式货车");
		list.add( "低速罐式货车");
		list.add( "自卸低速货车");
		list.add( "仓栅式低速货车");
		list.add( "厢式自卸低速货车");
		list.add( "罐式自卸低速货车");
		// Z开头
		list.add( "大型专项作业车");
		list.add( "大型载货专项作业车");
		list.add( "中型专项作业车");
		list.add( "中型载货专项作业车");
		list.add( "小型专项作业车");
		list.add( "小型载货专项作业车");
		list.add( "微型专项作业车");
		list.add( "微型载货专项作业车");
		list.add( "重型专项作业车");
		list.add( "重型载货专项作业车");
		list.add( "轻型专项作业车");
		list.add( "轻型载货专项作业车");
		// D开头
		list.add( "无轨电车");
		list.add( "有轨电车");
		// M开头
		list.add( "普通正三轮摩托车");
		list.add( "轻便正三轮摩托车");
		list.add( "正三轮载客摩托车");
		list.add( "正三轮载货摩托车");
		list.add( "侧三轮摩托车");
		list.add( "普通二轮摩托车");
		list.add( "轻便二轮摩托车");
		// N开头
		list.add( "三轮汽车");
		// Q开头
		list.add( "重型半挂牵引车");
		list.add( "重型全挂牵引车");
		list.add( "中型全挂牵引车");
		list.add( "中型半挂牵引车");
		list.add( "轻型半挂牵引车");
		list.add( "轻型全挂牵引车");
		// T开头
		list.add( "大型轮式拖拉机");
		list.add( "小型轮式拖拉机");
		list.add( "手扶拖拉机");
		list.add( "手扶变形运输机");
		// J开头
		list.add( "轮式装载机械");
		list.add( "轮式挖掘机械");
		list.add( "轮式平地机械");
		// G开头
		list.add( "重型普通全挂车");
		list.add( "重型厢式全挂车");
		list.add( "重型罐式全挂车");
		list.add( "重型平板全挂车");
		list.add( "重型集装箱全挂车");
		list.add( "重型自卸全挂车");
		list.add( "重型仓栅式全挂车");
		list.add( "重型旅居全挂车");
		list.add( "重型专项作业全挂车");
		list.add( "重型厢式自卸全挂车");
		list.add( "重型罐式自卸全挂车");
		list.add( "重型平板自卸全挂车");
		list.add( "重型集装箱自卸全挂车");
		list.add( "重型仓栅式自卸全挂车");
		list.add( "重型专项作业自卸全挂车");
		list.add( "中型普通全挂车");
		list.add( "中型厢式全挂车");
		list.add( "中型罐式全挂车");
		list.add( "中型平板全挂车");
		list.add( "中型集装箱全挂车");
		list.add( "中型自卸全挂车");
		list.add( "中型仓栅式全挂车");
		list.add( "中型旅居全挂车");
		list.add( "中型专项作业全挂车");
		list.add( "中型厢式自卸全挂车");
		list.add( "中型罐式自卸全挂车");
		list.add( "中型平板自卸全挂车");
		list.add( "中型集装箱自卸全挂车");
		list.add( "中型仓栅式自卸全挂车");
		list.add( "中型专项作业自卸全挂车");
		list.add( "轻型普通全挂车");
		list.add( "轻型厢式全挂车");
		list.add( "轻型罐式全挂车");
		list.add( "轻型平板全挂车");
		list.add( "轻型自卸全挂车");
		list.add( "轻型仓栅式全挂车");
		list.add( "轻型旅居全挂车");
		list.add( "轻型专项作业全挂车");
		list.add( "轻型厢式自卸全挂车");
		list.add( "轻型罐式自卸全挂车");
		list.add( "轻型平板自卸全挂车");
		list.add( "轻型集装箱自卸全挂车");
		list.add( "轻型仓栅式自卸全挂车");
		list.add( "轻型专项作业自卸全挂车");
		// X开:头
		list.add( "其他");
		return list;
	}
	public static String GetCllxString(String cllx) {
		Map<String,String> maps =new HashMap<String, String>(); 
		// list.add(new Md_cartype("01", "微、小型载客汽车"));
		// list.add(new Md_cartype("02", "中型载客汽车"));
		// list.add(new Md_cartype("03", "大型载客汽车"));
		// list.add(new Md_cartype("04", "载货汽车（包括牵引半挂车）"));
		// list.add(new Md_cartype("05", "危险化学品运输车"));

		// K开头
		maps.put( "K33:轿车"     ,"K33:轿车"     );
		maps.put( "K11:大型普通客车","K11:大型普通客车");
		maps.put( "K12:大型双层客车","K12:大型双层客车");
		maps.put( "K13:大型卧铺客车","K13:大型卧铺客车");
		maps.put( "K14:大型铰接客车","K14:大型铰接客车");
		maps.put( "K15:大型越野客车","K15:大型越野客车");
		maps.put( "K16:大型轿车"  ,"K16:大型轿车"   );
		maps.put( "K17:大型专用客车","K17:大型专用客车");
		maps.put( "K18:大型专用校车","K18:大型专用校车");
		maps.put( "K21:中型普通客车","K21:中型普通客车");
		maps.put( "K22:中型双层客车","K22:中型双层客车");
		maps.put( "K23:中型卧铺客车","K23:中型卧铺客车");
		maps.put( "K24:中型铰接客车","K24:中型铰接客车");
		maps.put( "K25:中型越野客车","K25:中型越野客车");
		maps.put( "K26:中型轿车"   ,"K26:中型轿车"  );
		maps.put( "K27:中型专用客车","K27:中型专用客车");
		maps.put( "K28:中型专用校车","K28:中型专用校车");
		maps.put( "K31:小型普通客车","K31:小型普通客车");
		maps.put( "K32:小型越野客车","K32:小型越野客车");
		maps.put( "K34:小型专用客车","K34:小型专用客车");
		maps.put( "K38:小型专用校车","K38:小型专用校车");
		maps.put( "K39:小型面包车"	,"K39:小型面包车"  );
		maps.put( "K41:微型普通客车","K41:微型普通客车");
		maps.put( "K42:微型越野客车","K42:微型越野客车");
		maps.put( "K43:微型轿车"	,"K43:微型轿车"  );
		maps.put( "K49:微型面包车"	,"K49:微型面包车"	);
		// B开头
		maps.put( "B1：重型普通半挂车"	,"B1：重型普通半挂车" );
		maps.put( "B12：重型厢式半挂车"	,"B12：重型厢式半挂车");
		maps.put( "B13:重型罐式半挂车"	,"B13:重型罐式半挂车");
		maps.put( "B14:重型平板半挂车"	,"B14:重型平板半挂车");
		maps.put( "B15：重型集装箱半挂车"	,"B15：重型集装箱半挂车");
		maps.put( "B16：重型自卸半挂车"	,"B16：重型自卸半挂车");
		maps.put( "B17：重型特殊结构半挂车"	,"B17：重型特殊结构半挂车"	);
		maps.put( "B18：重型仓栅式半挂车"	,"B18：重型仓栅式半挂车");
		maps.put( "B19：重型旅居半挂车"	,"B19：重型旅居半挂车");
		maps.put( "B1A：重型专项作业半挂车","B1A：重型专项作业半挂车");
		maps.put( "B1B：重型低平板半挂车","B1B：重型低平板半挂车");
		maps.put( "B1C：重型车辆运输半挂车","B1C：重型车辆运输半挂车");
		maps.put( "B1D：重型罐式自卸半挂车", "B1D：重型罐式自卸半挂车");
		maps.put( "B1E：重型平板自卸半挂车","B1E：重型平板自卸半挂车");
		maps.put( "B1F：重型集装箱自卸半挂车","B1F：重型集装箱自卸半挂车");
		maps.put( "B1G：重型特殊结构自卸半挂车","B1G：重型特殊结构自卸半挂车");
		maps.put( "B1H：重型仓栅式自卸半挂车","B1H：重型仓栅式自卸半挂车");
		maps.put( "B1J：重型专项作业自卸半挂车","B1J：重型专项作业自卸半挂车");
		maps.put( "B1K：重型低平板自卸半挂车","B1K：重型低平板自卸半挂车");
		maps.put( "B1U：重型中置轴旅居挂车","B1U：重型中置轴旅居挂车");
		maps.put( "B1V：重型中置轴车辆运输车","B1V：重型中置轴车辆运输车");
		maps.put( "B1W：重型中置轴普通挂车","B1W：重型中置轴普通挂车");
		maps.put( "B21：中型普通半挂车","B21：中型普通半挂车");
		maps.put( "B22：中型厢式半挂车", "B22：中型厢式半挂车");
		maps.put( "B23：中型罐式半挂车", "B23：中型罐式半挂车");
		maps.put( "B24：中型平板半挂车","B24：中型平板半挂车");
		maps.put( "B25：中型集装箱半挂车","B25：中型集装箱半挂车");
		maps.put( "B26：中型自卸半挂车","B26：中型自卸半挂车");
		maps.put( "B27：中型特殊结构半挂车","B27：中型特殊结构半挂车");
		maps.put( "B28：中型仓栅式半挂车", "B28：中型仓栅式半挂车");
		maps.put( "B29：中型旅居半挂车","B29：中型旅居半挂车");
		maps.put( "B2A：中型专项作业半挂车","B2A：中型专项作业半挂车");
		maps.put( "B2B：中型低平板半挂车","B2B：中型低平板半挂车");
		maps.put( "B2C：中型车辆运输半挂车","B2C：中型车辆运输半挂车");
		maps.put( "B2D：中型罐式自卸半挂车","B2D：中型罐式自卸半挂车");
		maps.put( "B2E：中型平板自卸半挂车","B2E：中型平板自卸半挂车");
		maps.put( "B2F：中型集装箱自卸半挂车","B2F：中型集装箱自卸半挂车");
		maps.put( "B2G：中型特殊结构自卸半挂车","B2G：中型特殊结构自卸半挂车");
		maps.put( "B2H：中型仓栅式自卸半挂车","B2H：中型仓栅式自卸半挂车");
		maps.put( "B2J：中型专项作业自卸半挂车","B2J：中型专项作业自卸半挂车");
		maps.put( "B2K：中型低平板自卸半挂车", "B2K：中型低平板自卸半挂车");
		maps.put( "B2U：中型中置轴旅居挂车","B2U：中型中置轴旅居挂车");
		maps.put( "B2V：中型中置轴车辆运输车","B2V：中型中置轴车辆运输车");
		maps.put( "B2W：中型中置轴普通挂车","B2W：中型中置轴普通挂车");
		maps.put( "B31：轻型普通半挂车","B31：轻型普通半挂车");
		maps.put( "B32：轻型厢式半挂车","B32：轻型厢式半挂车");
		maps.put( "B33：轻型罐式半挂车","B33：轻型罐式半挂车");
		maps.put( "B34：轻型平板半挂车","B34：轻型平板半挂车");
		maps.put( "B35：轻型自卸半挂车","B35：轻型自卸半挂车");
		maps.put( "B36：轻型仓栅式半挂车","B36：轻型仓栅式半挂车");
		maps.put( "B37：轻型旅居半挂车","B37：轻型旅居半挂车");
		maps.put( "B38：轻型专项作业半挂车","B38：轻型专项作业半挂车");
		maps.put( "B39：轻型低平板半挂车","B39：轻型低平板半挂车");
		maps.put( "B3C：轻型车辆运输半挂车","B3C：轻型车辆运输半挂车");
		maps.put( "B3D：轻型罐式自卸半挂车", "B3D：轻型罐式自卸半挂车");
		maps.put( "B3E：轻型平板自卸半挂车","B3E：轻型平板自卸半挂车");
		maps.put( "B3F：轻型集装箱自卸半挂车","B3F：轻型集装箱自卸半挂车");
		maps.put( "B3G：轻型特殊结构自卸半挂车","B3G：轻型特殊结构自卸半挂车");
		maps.put( "B3H：轻型仓栅式自卸半挂车","B3H：轻型仓栅式自卸半挂车");
		maps.put( "B3J：轻型专项作业自卸半挂车","B3J：轻型专项作业自卸半挂车");
		maps.put( "B3K：轻型低平板自卸半挂车","B3K：轻型低平板自卸半挂车");
		maps.put( "B3U：轻型中置轴旅居挂车","B3U：轻型中置轴旅居挂车");
		maps.put( "B3V：轻型中置轴车辆运输车","B3V：轻型中置轴车辆运输车");
		maps.put( "B3W：轻型中置轴普通挂车","B3W：轻型中置轴普通挂车");
		// H开头
		maps.put( "H11：重型普通货车","H11：重型普通货车");
		maps.put( "H12：重型厢式货车","H12：重型厢式货车");
		maps.put( "H13：重型封闭货车","H13：重型封闭货车");
		maps.put( "H14：重型罐式货车","H14：重型罐式货车");
		maps.put( "H15：重型平板货车", "H15：重型平板货车");
		maps.put( "H16：重型集装厢车","H16：重型集装厢车");
		maps.put( "H17：重型自卸货车","H17：重型自卸货车");
		maps.put( "H18：重型特殊结构货车","H18：重型特殊结构货车");
		maps.put( "H19：重型仓栅式货车","H19：重型仓栅式货车");
		maps.put( "H1A：重型车辆运输车","H1A：重型车辆运输车");
		maps.put( "H1B：重型厢式自卸货车","H1B：重型厢式自卸货车");
		maps.put( "H1C：重型罐式自卸货车","H1C：重型罐式自卸货车");
		maps.put( "H1D：重型平板自卸货车","H1D：重型平板自卸货车");
		maps.put( "H1E：重型集装厢自卸货车","H1E：重型集装厢自卸货车");
		maps.put( "H1F：重型特殊结构自卸货车","H1F：重型特殊结构自卸货车");
		maps.put( "H1G：重型仓栅式自卸货车","H1G：重型仓栅式自卸货车");
		maps.put( "H21：中型普通货车","H21：中型普通货车");
		maps.put( "H22：中型厢式货车", "H22：中型厢式货车");
		maps.put( "H23：中型封闭货车","H23：中型封闭货车");
		maps.put( "H24：中型罐式货车","H24：中型罐式货车");
		maps.put( "H25:中型平板货车","H25:中型平板货车");
		maps.put( "H26:中型集装厢车","H26:中型集装厢车");
		maps.put( "H27:中型自卸货车","H27:中型自卸货车");
		maps.put( "H28:中型特殊结构货车","H28:中型特殊结构货车");
		maps.put( "H29:中型仓栅式货车","H29:中型仓栅式货车");
		maps.put( "H2A:中型车辆运输车", "H2A:中型车辆运输车");
		maps.put( "H2B:中型厢式自卸货车","H2B:中型厢式自卸货车");
		maps.put( "H2C:中型罐式自卸货车","H2C:中型罐式自卸货车");
		maps.put( "H2D：中型平板自卸货车","H2D：中型平板自卸货车");
		maps.put( "H2E:中型集装厢自卸货车","H2E:中型集装厢自卸货车");
		maps.put( "H2F:中型特殊结构自卸货车","H2F:中型特殊结构自卸货车");
		maps.put( "H2G:中型仓栅式自卸货车","H2G:中型仓栅式自卸货车");
		maps.put( "H31:轻型普通货车", "H31:轻型普通货车");
		maps.put( "H32:轻型厢式货车","H32:轻型厢式货车");
		maps.put( "H33:轻型封闭货车","H33:轻型封闭货车");
		maps.put( "H34:轻型罐式货车","H34:轻型罐式货车");
		maps.put( "H35:轻型平板货车","H35:轻型平板货车");
		maps.put( "H37:轻型自卸货车","H37:轻型自卸货车");
		maps.put( "H38:轻型特殊结构货车", "H38:轻型特殊结构货车");
		maps.put( "H39:轻型仓栅式货车","H39:轻型仓栅式货车");
		maps.put( "H39:轻型车辆运输车","H39:轻型车辆运输车");
		maps.put( "H3A:轻型车辆运输车","H3A:轻型车辆运输车");
		maps.put( "H3B:轻型厢式自卸货车","H3B:轻型厢式自卸货车");
		maps.put( "H3C:轻型罐式自卸货车","H3C:轻型罐式自卸货车");
		maps.put( "H3D:轻型平板自卸货车","H3D:轻型平板自卸货车");
		maps.put( "H3E:轻型集装厢自卸货车","H3E:轻型集装厢自卸货车");
		maps.put( "H3F:轻型特殊结构自卸货车","H3F:轻型特殊结构自卸货车");
		maps.put( "H3G:轻型仓栅式自卸货车","H3G:轻型仓栅式自卸货车");
		maps.put( "H41:微型普通货车","H41:微型普通货车");
		maps.put( "H42:微型厢式货车","H42:微型厢式货车");
		maps.put( "H43:微型封闭货车", "H43:微型封闭货车");
		maps.put( "H44:微型罐式货车","H44:微型罐式货车");
		maps.put( "H45:微型自卸货车", "H45:微型自卸货车");
		maps.put( "H46:微型特殊结构货车","H46:微型特殊结构货车");
		maps.put( "H47:微型仓栅式货车","H47:微型仓栅式货车");
		maps.put( "H4A:微型车辆运输车","H4A:微型车辆运输车");
		maps.put( "H4B:微型厢式自卸货车","H4B:微型厢式自卸货车");
		maps.put( "H4C:微型罐式自卸货车","H4C:微型罐式自卸货车");
		maps.put( "H4F:微型特殊结构自卸货车","H4F:微型特殊结构自卸货车");
		maps.put( "H4G:微型仓栅式自卸货车","H4G:微型仓栅式自卸货车");
		maps.put( "H51:低速普通货车","H51:低速普通货车");
		maps.put( "H52:低速厢式货车","H52:低速厢式货车");
		maps.put( "H53:低速罐式货车","H53:低速罐式货车");
		maps.put( "H54:自卸低速货车","H54:自卸低速货车");
		maps.put( "H55:仓栅式低速货车","H55:仓栅式低速货车");
		maps.put( "H5B:厢式自卸低速货车","H5B:厢式自卸低速货车");
		maps.put( "H5C:罐式自卸低速货车","H5C:罐式自卸低速货车");
		// Z开头
		maps.put( "Z11:大型专项作业车","Z11:大型专项作业车");
		maps.put( "Z12:大型载货专项作业车","Z12:大型载货专项作业车");
		maps.put( "Z21:中型专项作业车","Z21:中型专项作业车");
		maps.put( "Z22:中型载货专项作业车","Z22:中型载货专项作业车");
		maps.put( "Z31:小型专项作业车","Z31:小型专项作业车");
		maps.put( "Z32:小型载货专项作业车","Z32:小型载货专项作业车");
		maps.put( "Z41:微型专项作业车","Z41:微型专项作业车");
		maps.put( "Z42:微型载货专项作业车","Z42:微型载货专项作业车");
		maps.put( "Z51:重型专项作业车","Z51:重型专项作业车");
		maps.put( "Z52:重型载货专项作业车","Z52:重型载货专项作业车");
		maps.put( "Z71:轻型专项作业车","Z71:轻型专项作业车");
		maps.put( "Z72:轻型载货专项作业车","Z72:轻型载货专项作业车");
		// D开头
		maps.put( "D11:无轨电车","D11:无轨电车");
		maps.put( "D12:有轨电车","D12:有轨电车");
		// M开头,"D12:有轨电车"
		maps.put( "M11:普通正三轮摩托车","M11:普通正三轮摩托车");
		maps.put( "M12:轻便正三轮摩托车","M12:轻便正三轮摩托车");
		maps.put( "M13:正三轮载客摩托车","M13:正三轮载客摩托车");
		maps.put( "M14:正三轮载货摩托车","M14:正三轮载货摩托车");
		maps.put( "M15:侧三轮摩托车","M15:侧三轮摩托车");
		maps.put( "M21:普通二轮摩托车","M21:普通二轮摩托车");
		maps.put( "M22:轻便二轮摩托车","M22:轻便二轮摩托车");
		// N开头
		maps.put( "N11:三轮汽车","N11:三轮汽车");
		// Q开头
		maps.put( "Q11:重型半挂牵引车","Q11:重型半挂牵引车");
		maps.put( "Q12:重型全挂牵引车","Q12:重型全挂牵引车");
		maps.put( "Q22:中型全挂牵引车","Q22:中型全挂牵引车");
		maps.put( "Q21:中型半挂牵引车", "Q21:中型半挂牵引车");
		maps.put( "Q31:轻型半挂牵引车","Q31:轻型半挂牵引车");
		maps.put( "Q32:轻型全挂牵引车","Q32:轻型全挂牵引车");
		// T开头
		maps.put( "T11:大型轮式拖拉机","T11:大型轮式拖拉机");
		maps.put( "T21:小型轮式拖拉机","T21:小型轮式拖拉机");
		maps.put( "T22:手扶拖拉机","T22:手扶拖拉机");
		maps.put( "T23:手扶变形运输机","T23:手扶变形运输机");
		// J开头
		maps.put( "J11:轮式装载机械","J11:轮式装载机械");
		maps.put( "J12:轮式挖掘机械","J12:轮式挖掘机械");
		maps.put( "J13:轮式平地机械","J13:轮式平地机械");
		// G开头
		maps.put( "G11:重型普通全挂车","G11:重型普通全挂车");
		maps.put( "G12:重型厢式全挂车","G12:重型厢式全挂车");
		maps.put( "G13:重型罐式全挂车","G13:重型罐式全挂车");
		maps.put( "G14:重型平板全挂车","G14:重型平板全挂车");
		maps.put( "G15:重型集装箱全挂车","G15:重型集装箱全挂车");
		maps.put( "G16:重型自卸全挂车","G16:重型自卸全挂车");
		maps.put( "G17:重型仓栅式全挂车","G17:重型仓栅式全挂车");
		maps.put( "G18:重型旅居全挂车","G18:重型旅居全挂车");
		maps.put( "G19:重型专项作业全挂车","G19:重型专项作业全挂车");
		maps.put( "G1A:重型厢式自卸全挂车","G1A:重型厢式自卸全挂车");
		maps.put( "G1B:重型罐式自卸全挂车","G1B:重型罐式自卸全挂车");
		maps.put( "G1C:重型平板自卸全挂车","G1C:重型平板自卸全挂车");
		maps.put( "G1D:重型集装箱自卸全挂车","G1D:重型集装箱自卸全挂车");
		maps.put( "G1E:重型仓栅式自卸全挂车","G1E:重型仓栅式自卸全挂车");
		maps.put( "G1F:重型专项作业自卸全挂车","G1F:重型专项作业自卸全挂车");
		maps.put( "G21:中型普通全挂车","G21:中型普通全挂车");
		maps.put( "G22:中型厢式全挂车","G22:中型厢式全挂车");
		maps.put( "G23:中型罐式全挂车","G23:中型罐式全挂车");
		maps.put( "G24:中型平板全挂车" ,"G24:中型平板全挂车");
		maps.put( "G25:中型集装箱全挂车","G25:中型集装箱全挂车");
		maps.put( "G26:中型自卸全挂车", "G26:中型自卸全挂车");
		maps.put( "G27:中型仓栅式全挂车","G27:中型仓栅式全挂车");
		maps.put( "G28:中型旅居全挂车","G28:中型旅居全挂车");
		maps.put( "G29:中型专项作业全挂车","G29:中型专项作业全挂车");
		maps.put( "G2A:中型厢式自卸全挂车","G2A:中型厢式自卸全挂车");
		maps.put( "G2B:中型罐式自卸全挂车","G2B:中型罐式自卸全挂车");
		maps.put( "G2C:中型平板自卸全挂车","G2C:中型平板自卸全挂车");
		maps.put( "G2D:中型集装箱自卸全挂车","G2D:中型集装箱自卸全挂车");
		maps.put( "G2E:中型仓栅式自卸全挂车","G2E:中型仓栅式自卸全挂车");
		maps.put( "G2F:中型专项作业自卸全挂车","G2F:中型专项作业自卸全挂车");
		maps.put( "G31:轻型普通全挂车","G31:轻型普通全挂车");
		maps.put( "G32:轻型厢式全挂车","G32:轻型厢式全挂车");
		maps.put( "G33:轻型罐式全挂车","G33:轻型罐式全挂车");
		maps.put( "G34:轻型平板全挂车","G34:轻型平板全挂车");
		maps.put( "G35:轻型自卸全挂车","G35:轻型自卸全挂车");
		maps.put( "G36:轻型仓栅式全挂车","G36:轻型仓栅式全挂车");
		maps.put( "G37:轻型旅居全挂车", "G37:轻型旅居全挂车");
		maps.put( "G38:轻型专项作业全挂车","G38:轻型专项作业全挂车");
		maps.put( "G3A:轻型厢式自卸全挂车", "G3A:轻型厢式自卸全挂车");
		maps.put( "G3B:轻型罐式自卸全挂车","G3B:轻型罐式自卸全挂车");
		maps.put( "G3C:轻型平板自卸全挂车","G3C:轻型平板自卸全挂车");
		maps.put( "G3D:轻型集装箱自卸全挂车", "G3D:轻型集装箱自卸全挂车");
		maps.put( "G3E:轻型仓栅式自卸全挂车","G3E:轻型仓栅式自卸全挂车");
		maps.put( "G3F:轻型专项作业自卸全挂车","G3F:轻型专项作业自卸全挂车");
		// X开:头
		maps.put( "X99:其他","X99:其他");
		
		
		// K开头
		maps.put( "轿车"     ,"K33:轿车"     );
		maps.put( "大型普通客车","K11:大型普通客车");
		maps.put( "大型双层客车","K12:大型双层客车");
		maps.put( "大型卧铺客车","K13:大型卧铺客车");
		maps.put( "大型铰接客车","K14:大型铰接客车");
		maps.put( "大型越野客车","K15:大型越野客车");
		maps.put( "大型轿车"  ,"K16:大型轿车"   );
		maps.put( "大型专用客车","K17:大型专用客车");
		maps.put( "大型专用校车","K18:大型专用校车");
		maps.put( "中型普通客车","K21:中型普通客车");
		maps.put( "中型双层客车","K22:中型双层客车");
		maps.put( "中型卧铺客车","K23:中型卧铺客车");
		maps.put( "中型铰接客车","K24:中型铰接客车");
		maps.put( "中型越野客车","K25:中型越野客车");
		maps.put( "中型轿车"   ,"K26:中型轿车"  );
		maps.put( "中型专用客车","K27:中型专用客车");
		maps.put( "中型专用校车","K28:中型专用校车");
		maps.put( "小型普通客车","K31:小型普通客车");
		maps.put( "小型越野客车","K32:小型越野客车");
		maps.put( "小型专用客车","K34:小型专用客车");
		maps.put( "小型专用校车","K38:小型专用校车");
		maps.put( "小型面包车"	,"K39:小型面包车"  );
		maps.put( "微型普通客车","K41:微型普通客车");
		maps.put( "微型越野客车","K42:微型越野客车");
		maps.put( "微型轿车"	,"K43:微型轿车"  );
		maps.put( "微型面包车"	,"K49:微型面包车"	);
		// B开头
		maps.put( "重型普通半挂车"	,"B1：重型普通半挂车" );
		maps.put( "重型厢式半挂车"	,"B12：重型厢式半挂车");
		maps.put( "重型罐式半挂车"	,"B13:重型罐式半挂车");
		maps.put( "重型平板半挂车"	,"B14:重型平板半挂车");
		maps.put( "重型集装箱半挂车"	,"B15：重型集装箱半挂车");
		maps.put( "重型自卸半挂车"	,"B16：重型自卸半挂车");
		maps.put( "重型特殊结构半挂车"	,"B17：重型特殊结构半挂车"	);
		maps.put( "重型仓栅式半挂车"	,"B18：重型仓栅式半挂车");
		maps.put( "重型旅居半挂车"	,"B19：重型旅居半挂车");
		maps.put( "重型专项作业半挂车","B1A：重型专项作业半挂车");
		maps.put( "重型低平板半挂车","B1B：重型低平板半挂车");
		maps.put( "重型车辆运输半挂车","B1C：重型车辆运输半挂车");
		maps.put( "重型罐式自卸半挂车", "B1D：重型罐式自卸半挂车");
		maps.put( "重型平板自卸半挂车","B1E：重型平板自卸半挂车");
		maps.put( "重型集装箱自卸半挂车","B1F：重型集装箱自卸半挂车");
		maps.put( "重型特殊结构自卸半挂车","B1G：重型特殊结构自卸半挂车");
		maps.put( "重型仓栅式自卸半挂车","B1H：重型仓栅式自卸半挂车");
		maps.put( "重型专项作业自卸半挂车","B1J：重型专项作业自卸半挂车");
		maps.put( "重型低平板自卸半挂车","B1K：重型低平板自卸半挂车");
		maps.put( "重型中置轴旅居挂车","B1U：重型中置轴旅居挂车");
		maps.put( "重型中置轴车辆运输车","B1V：重型中置轴车辆运输车");
		maps.put( "重型中置轴普通挂车","B1W：重型中置轴普通挂车");
		maps.put( "中型普通半挂车","B21：中型普通半挂车");
		maps.put( "中型厢式半挂车", "B22：中型厢式半挂车");
		maps.put( "中型罐式半挂车", "B23：中型罐式半挂车");
		maps.put( "中型平板半挂车","B24：中型平板半挂车");
		maps.put( "中型集装箱半挂车","B25：中型集装箱半挂车");
		maps.put( "中型自卸半挂车","B26：中型自卸半挂车");
		maps.put( "中型特殊结构半挂车","B27：中型特殊结构半挂车");
		maps.put( "中型仓栅式半挂车", "B28：中型仓栅式半挂车");
		maps.put( "中型旅居半挂车","B29：中型旅居半挂车");
		maps.put( "中型专项作业半挂车","B2A：中型专项作业半挂车");
		maps.put( "中型低平板半挂车","B2B：中型低平板半挂车");
		maps.put( "中型车辆运输半挂车","B2C：中型车辆运输半挂车");
		maps.put( "中型罐式自卸半挂车","B2D：中型罐式自卸半挂车");
		maps.put( "中型平板自卸半挂车","B2E：中型平板自卸半挂车");
		maps.put( "中型集装箱自卸半挂车","B2F：中型集装箱自卸半挂车");
		maps.put( "中型特殊结构自卸半挂车","B2G：中型特殊结构自卸半挂车");
		maps.put( "中型仓栅式自卸半挂车","B2H：中型仓栅式自卸半挂车");
		maps.put( "中型专项作业自卸半挂车","B2J：中型专项作业自卸半挂车");
		maps.put( "中型低平板自卸半挂车", "B2K：中型低平板自卸半挂车");
		maps.put( "中型中置轴旅居挂车","B2U：中型中置轴旅居挂车");
		maps.put( "中型中置轴车辆运输车","B2V：中型中置轴车辆运输车");
		maps.put( "中型中置轴普通挂车","B2W：中型中置轴普通挂车");
		maps.put( "轻型普通半挂车","B31：轻型普通半挂车");
		maps.put( "轻型厢式半挂车","B32：轻型厢式半挂车");
		maps.put( "轻型罐式半挂车","B33：轻型罐式半挂车");
		maps.put( "轻型平板半挂车","B34：轻型平板半挂车");
		maps.put( "轻型自卸半挂车","B35：轻型自卸半挂车");
		maps.put( "轻型仓栅式半挂车","B36：轻型仓栅式半挂车");
		maps.put( "轻型旅居半挂车","B37：轻型旅居半挂车");
		maps.put( "轻型专项作业半挂车","B38：轻型专项作业半挂车");
		maps.put( "轻型低平板半挂车","B39：轻型低平板半挂车");
		maps.put( "轻型车辆运输半挂车","B3C：轻型车辆运输半挂车");
		maps.put( "轻型罐式自卸半挂车", "B3D：轻型罐式自卸半挂车");
		maps.put( "轻型平板自卸半挂车","B3E：轻型平板自卸半挂车");
		maps.put( "轻型集装箱自卸半挂车","B3F：轻型集装箱自卸半挂车");
		maps.put( "轻型特殊结构自卸半挂车","B3G：轻型特殊结构自卸半挂车");
		maps.put( "轻型仓栅式自卸半挂车","B3H：轻型仓栅式自卸半挂车");
		maps.put( "轻型专项作业自卸半挂车","B3J：轻型专项作业自卸半挂车");
		maps.put( "轻型低平板自卸半挂车","B3K：轻型低平板自卸半挂车");
		maps.put( "轻型中置轴旅居挂车","B3U：轻型中置轴旅居挂车");
		maps.put( "轻型中置轴车辆运输车","B3V：轻型中置轴车辆运输车");
		maps.put( "轻型中置轴普通挂车","B3W：轻型中置轴普通挂车");
		// H开头
		maps.put( "重型普通货车","H11：重型普通货车");
		maps.put( "重型厢式货车","H12：重型厢式货车");
		maps.put( "重型封闭货车","H13：重型封闭货车");
		maps.put( "重型罐式货车","H14：重型罐式货车");
		maps.put( "重型平板货车", "H15：重型平板货车");
		maps.put( "重型集装厢车","H16：重型集装厢车");
		maps.put( "重型自卸货车","H17：重型自卸货车");
		maps.put( "重型特殊结构货车","H18：重型特殊结构货车");
		maps.put( "重型仓栅式货车","H19：重型仓栅式货车");
		maps.put( "重型车辆运输车","H1A：重型车辆运输车");
		maps.put( "重型厢式自卸货车","H1B：重型厢式自卸货车");
		maps.put( "重型罐式自卸货车","H1C：重型罐式自卸货车");
		maps.put( "重型平板自卸货车","H1D：重型平板自卸货车");
		maps.put( "重型集装厢自卸货车","H1E：重型集装厢自卸货车");
		maps.put( "重型特殊结构自卸货车","H1F：重型特殊结构自卸货车");
		maps.put( "重型仓栅式自卸货车","H1G：重型仓栅式自卸货车");
		maps.put( "中型普通货车","H21：中型普通货车");
		maps.put( "中型厢式货车", "H22：中型厢式货车");
		maps.put( "中型封闭货车","H23：中型封闭货车");
		maps.put( "中型罐式货车","H24：中型罐式货车");
		maps.put( "中型平板货车","H25:中型平板货车");
		maps.put( "中型集装厢车","H26:中型集装厢车");
		maps.put( "中型自卸货车","H27:中型自卸货车");
		maps.put( "中型特殊结构货车","H28:中型特殊结构货车");
		maps.put( "中型仓栅式货车","H29:中型仓栅式货车");
		maps.put( "中型车辆运输车", "H2A:中型车辆运输车");
		maps.put( "中型厢式自卸货车","H2B:中型厢式自卸货车");
		maps.put( "中型罐式自卸货车","H2C:中型罐式自卸货车");
		maps.put( "中型平板自卸货车","H2D：中型平板自卸货车");
		maps.put( "中型集装厢自卸货车","H2E:中型集装厢自卸货车");
		maps.put( "中型特殊结构自卸货车","H2F:中型特殊结构自卸货车");
		maps.put( "中型仓栅式自卸货车","H2G:中型仓栅式自卸货车");
		maps.put( "轻型普通货车", "H31:轻型普通货车");
		maps.put( "轻型厢式货车","H32:轻型厢式货车");
		maps.put( "轻型封闭货车","H33:轻型封闭货车");
		maps.put( "轻型罐式货车","H34:轻型罐式货车");
		maps.put( "轻型平板货车","H35:轻型平板货车");
		maps.put( "轻型自卸货车","H37:轻型自卸货车");
		maps.put( "轻型特殊结构货车", "H38:轻型特殊结构货车");
		maps.put( "轻型仓栅式货车","H39:轻型仓栅式货车");
		maps.put( "轻型车辆运输车","H39:轻型车辆运输车");
		maps.put( "轻型车辆运输车","H3A:轻型车辆运输车");
		maps.put( "轻型厢式自卸货车","H3B:轻型厢式自卸货车");
		maps.put( "轻型罐式自卸货车","H3C:轻型罐式自卸货车");
		maps.put( "轻型平板自卸货车","H3D:轻型平板自卸货车");
		maps.put( "轻型集装厢自卸货车","H3E:轻型集装厢自卸货车");
		maps.put( "轻型特殊结构自卸货车","H3F:轻型特殊结构自卸货车");
		maps.put( "轻型仓栅式自卸货车","H3G:轻型仓栅式自卸货车");
		maps.put( "微型普通货车","H41:微型普通货车");
		maps.put( "微型厢式货车","H42:微型厢式货车");
		maps.put( "微型封闭货车", "H43:微型封闭货车");
		maps.put( "微型罐式货车","H44:微型罐式货车");
		maps.put( "微型自卸货车", "H45:微型自卸货车");
		maps.put( "微型特殊结构货车","H46:微型特殊结构货车");
		maps.put( "微型仓栅式货车","H47:微型仓栅式货车");
		maps.put( "微型车辆运输车","H4A:微型车辆运输车");
		maps.put( "微型厢式自卸货车","H4B:微型厢式自卸货车");
		maps.put( "微型罐式自卸货车","H4C:微型罐式自卸货车");
		maps.put( "微型特殊结构自卸货车","H4F:微型特殊结构自卸货车");
		maps.put( "微型仓栅式自卸货车","H4G:微型仓栅式自卸货车");
		maps.put( "低速普通货车","H51:低速普通货车");
		maps.put( "低速厢式货车","H52:低速厢式货车");
		maps.put( "低速罐式货车","H53:低速罐式货车");
		maps.put( "自卸低速货车","H54:自卸低速货车");
		maps.put( "仓栅式低速货车","H55:仓栅式低速货车");
		maps.put( "厢式自卸低速货车","H5B:厢式自卸低速货车");
		maps.put( "罐式自卸低速货车","H5C:罐式自卸低速货车");
		// Z开头
		maps.put( "大型专项作业车","Z11:大型专项作业车");
		maps.put( "大型载货专项作业车","Z12:大型载货专项作业车");
		maps.put( "中型专项作业车","Z21:中型专项作业车");
		maps.put( "中型载货专项作业车","Z22:中型载货专项作业车");
		maps.put( "小型专项作业车","Z31:小型专项作业车");
		maps.put( "小型载货专项作业车","Z32:小型载货专项作业车");
		maps.put( "微型专项作业车","Z41:微型专项作业车");
		maps.put( "微型载货专项作业车","Z42:微型载货专项作业车");
		maps.put( "重型专项作业车","Z51:重型专项作业车");
		maps.put( "重型载货专项作业车","Z52:重型载货专项作业车");
		maps.put( "轻型专项作业车","Z71:轻型专项作业车");
		maps.put( "轻型载货专项作业车","Z72:轻型载货专项作业车");
		// D开头
		maps.put( "无轨电车","D11:无轨电车");
		maps.put( "有轨电车","D12:有轨电车");
		// M开头,"D有轨电车"
		maps.put( "普通正三轮摩托车","M11:普通正三轮摩托车");
		maps.put( "轻便正三轮摩托车","M12:轻便正三轮摩托车");
		maps.put( "正三轮载客摩托车","M13:正三轮载客摩托车");
		maps.put( "正三轮载货摩托车","M14:正三轮载货摩托车");
		maps.put( "侧三轮摩托车","M15:侧三轮摩托车");
		maps.put( "普通二轮摩托车","M21:普通二轮摩托车");
		maps.put( "轻便二轮摩托车","M22:轻便二轮摩托车");
		// N开头
		maps.put( "三轮汽车","N11:三轮汽车");
		// Q开头
		maps.put( "重型半挂牵引车","Q11:重型半挂牵引车");
		maps.put( "重型全挂牵引车","Q12:重型全挂牵引车");
		maps.put( "中型全挂牵引车","Q22:中型全挂牵引车");
		maps.put( "中型半挂牵引车", "Q21:中型半挂牵引车");
		maps.put( "轻型半挂牵引车","Q31:轻型半挂牵引车");
		maps.put( "轻型全挂牵引车","Q32:轻型全挂牵引车");
		// T开头
		maps.put( "大型轮式拖拉机","T11:大型轮式拖拉机");
		maps.put( "小型轮式拖拉机","T21:小型轮式拖拉机");
		maps.put( "手扶拖拉机","T22:手扶拖拉机");
		maps.put( "手扶变形运输机","T23:手扶变形运输机");
		// J开头
		maps.put( "轮式装载机械","J11:轮式装载机械");
		maps.put( "轮式挖掘机械","J12:轮式挖掘机械");
		maps.put( "轮式平地机械","J13:轮式平地机械");
		// G开头
		maps.put( "重型普通全挂车","G11:重型普通全挂车");
		maps.put( "重型厢式全挂车","G12:重型厢式全挂车");
		maps.put( "重型罐式全挂车","G13:重型罐式全挂车");
		maps.put( "重型平板全挂车","G14:重型平板全挂车");
		maps.put( "重型集装箱全挂车","G15:重型集装箱全挂车");
		maps.put( "重型自卸全挂车","G16:重型自卸全挂车");
		maps.put( "重型仓栅式全挂车","G17:重型仓栅式全挂车");
		maps.put( "重型旅居全挂车","G18:重型旅居全挂车");
		maps.put( "重型专项作业全挂车","G19:重型专项作业全挂车");
		maps.put( "重型厢式自卸全挂车","G1A:重型厢式自卸全挂车");
		maps.put( "重型罐式自卸全挂车","G1B:重型罐式自卸全挂车");
		maps.put( "重型平板自卸全挂车","G1C:重型平板自卸全挂车");
		maps.put( "重型集装箱自卸全挂车","G1D:重型集装箱自卸全挂车");
		maps.put( "重型仓栅式自卸全挂车","G1E:重型仓栅式自卸全挂车");
		maps.put( "重型专项作业自卸全挂车","G1F:重型专项作业自卸全挂车");
		maps.put( "中型普通全挂车","G21:中型普通全挂车");
		maps.put( "中型厢式全挂车","G22:中型厢式全挂车");
		maps.put( "中型罐式全挂车","G23:中型罐式全挂车");
		maps.put( "中型平板全挂车" ,"G24:中型平板全挂车");
		maps.put( "中型集装箱全挂车","G25:中型集装箱全挂车");
		maps.put( "中型自卸全挂车", "G26:中型自卸全挂车");
		maps.put( "中型仓栅式全挂车","G27:中型仓栅式全挂车");
		maps.put( "中型旅居全挂车","G28:中型旅居全挂车");
		maps.put( "中型专项作业全挂车","G29:中型专项作业全挂车");
		maps.put( "中型厢式自卸全挂车","G2A:中型厢式自卸全挂车");
		maps.put( "中型罐式自卸全挂车","G2B:中型罐式自卸全挂车");
		maps.put( "中型平板自卸全挂车","G2C:中型平板自卸全挂车");
		maps.put( "中型集装箱自卸全挂车","G2D:中型集装箱自卸全挂车");
		maps.put( "中型仓栅式自卸全挂车","G2E:中型仓栅式自卸全挂车");
		maps.put( "中型专项作业自卸全挂车","G2F:中型专项作业自卸全挂车");
		maps.put( "轻型普通全挂车","G31:轻型普通全挂车");
		maps.put( "轻型厢式全挂车","G32:轻型厢式全挂车");
		maps.put( "轻型罐式全挂车","G33:轻型罐式全挂车");
		maps.put( "轻型平板全挂车","G34:轻型平板全挂车");
		maps.put( "轻型自卸全挂车","G35:轻型自卸全挂车");
		maps.put( "轻型仓栅式全挂车","G36:轻型仓栅式全挂车");
		maps.put( "轻型旅居全挂车", "G37:轻型旅居全挂车");
		maps.put( "轻型专项作业全挂车","G38:轻型专项作业全挂车");
		maps.put( "轻型厢式自卸全挂车", "G3A:轻型厢式自卸全挂车");
		maps.put( "轻型罐式自卸全挂车","G3B:轻型罐式自卸全挂车");
		maps.put( "轻型平板自卸全挂车","G3C:轻型平板自卸全挂车");
		maps.put( "轻型集装箱自卸全挂车", "G3D:轻型集装箱自卸全挂车");
		maps.put( "轻型仓栅式自卸全挂车","G3E:轻型仓栅式自卸全挂车");
		maps.put( "轻型专项作业自卸全挂车","G3F:轻型专项作业自卸全挂车");
		// X开:头
		maps.put( "其他","X99:其他");
		return maps.get(cllx);
	}
	/**
	 * 获取 号牌类型
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_hpzl() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("02", "02:小型汽车号牌"));
		list.add(new Md_cartype("01", "01:大型汽车号牌"));
		list.add(new Md_cartype("03", "03:使馆汽车号牌"));
		list.add(new Md_cartype("04", "04:领馆汽车号牌"));
		list.add(new Md_cartype("05", "05:境外汽车号牌"));
		list.add(new Md_cartype("06", "06:外籍汽车号牌"));
		list.add(new Md_cartype("07", "07:两、三轮摩托车号牌"));
		list.add(new Md_cartype("08", "08:轻便摩托车号牌"));
		list.add(new Md_cartype("09", "09:使馆摩托车号牌"));
		list.add(new Md_cartype("10", "10:领馆摩托车号牌"));
		list.add(new Md_cartype("11", "11:境外摩托车号牌"));
		list.add(new Md_cartype("12", "12:外籍摩托车号牌"));
		list.add(new Md_cartype("13", "13:低速车号牌"));
		list.add(new Md_cartype("14", "14:拖拉机号牌"));
		list.add(new Md_cartype("15", "15:挂车号牌"));
		list.add(new Md_cartype("16", "16:教练汽车号牌"));
		list.add(new Md_cartype("17", "17:教练摩托车号牌"));
		list.add(new Md_cartype("18", "18:实验汽车号牌"));
		list.add(new Md_cartype("19", "19:实验摩托车号牌"));
		list.add(new Md_cartype("20", "20:临时入境汽车号牌"));
		list.add(new Md_cartype("21", "21:临时入境摩托车号牌"));
		list.add(new Md_cartype("22", "22:临时行驶车号牌"));
		list.add(new Md_cartype("23", "23:警用汽车号牌"));
		list.add(new Md_cartype("24", "24:警用摩托车号牌"));
		list.add(new Md_cartype("25", "25:原农机号牌"));
		list.add(new Md_cartype("26", "26:香港入出境车号牌"));
		list.add(new Md_cartype("27", "27:澳门入出境车号牌"));
		list.add(new Md_cartype("31", "31:武警号牌"));
		list.add(new Md_cartype("32", "32:军队号牌"));
		list.add(new Md_cartype("41", "41:无号牌"));
		list.add(new Md_cartype("42", "42:假号牌"));
		list.add(new Md_cartype("43", "43:挪用号牌"));
		list.add(new Md_cartype("99", "99:其他号牌"));
		return list;
	}

	/**
	 * 获取 使用性质
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_syxz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("A", "A:非营运"));
		list.add(new Md_cartype("B", "B:公路客运"));
		list.add(new Md_cartype("C", "C:公交客运"));
		list.add(new Md_cartype("D", "D:出租客运"));
		list.add(new Md_cartype("E", "E:旅游客运"));
		list.add(new Md_cartype("F", "F:货运"));
		list.add(new Md_cartype("G", "G:租赁"));
		list.add(new Md_cartype("H", "H:警用"));
		list.add(new Md_cartype("I", "I:消防"));
		list.add(new Md_cartype("J", "J:救护"));
		list.add(new Md_cartype("K", "K:工程抢险"));
		list.add(new Md_cartype("L", "L:营转非"));
		list.add(new Md_cartype("M", "M:出租转非"));
		list.add(new Md_cartype("N", "N:教练"));
		list.add(new Md_cartype("O", "O:幼儿校车"));
		list.add(new Md_cartype("P", "P:小学校车"));
		list.add(new Md_cartype("Q", "Q:其他校车"));
		list.add(new Md_cartype("R", "R:危险品运输"));
		list.add(new Md_cartype("Z", "Z:其他"));
		return list;
	}

	/**
	 * 驱动轴
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_qdz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "请选择"));
		list.add(new Md_cartype("1", "1轴"));
		list.add(new Md_cartype("2", "2轴"));
		list.add(new Md_cartype("3", "3轴"));
		list.add(new Md_cartype("4", "4轴"));
		list.add(new Md_cartype("12", "1、2轴"));
		list.add(new Md_cartype("23", "2、3轴"));
		list.add(new Md_cartype("123", "1、2、3轴"));
		list.add(new Md_cartype("34", "3、4轴"));
		list.add(new Md_cartype("345", "3、4、5轴"));
		list.add(new Md_cartype("0", "无"));
		return list;
	}

	public static List<Md_cartype> Get_qdxs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "请选择"));
		list.add(new Md_cartype("2×1摩托车", "2×1摩托车：1-1-2"));
		list.add(new Md_cartype("4×2前驱后驻车", "4×2前驱后驻车：1-1-2"));
		list.add(new Md_cartype("4×2后驱后驻车", "4×2后驱后驻车：2-1-2"));
		list.add(new Md_cartype("4×2前驱前驻车", "4×2前驱前驻车：1-1-1"));
		list.add(new Md_cartype("4×4全驱后驻车", "4×4全驱后驻车：12-1-2"));
		list.add(new Md_cartype("4×4全连驱后驻车", "4×4全连驱后驻车：12-1-2"));
		list.add(new Md_cartype("6×2中驱中驻车半挂", "6×2中驱中驻车半挂：2-1-2"));
		list.add(new Md_cartype("6×2后驱后驻车", "6×2后驱后驻车：3-1-3"));
		list.add(new Md_cartype("6×2双后浮动桥中驻车", "6×2双后浮动桥中驻车：23-1-2"));
		list.add(new Md_cartype("6×4双后驱双后驻车", "6×4双后驱双后驻车：23-2-23"));
		list.add(new Md_cartype("6×4双后连驱双后驻车", "6×4双后连驱双后驻车：23-2-23"));
		list.add(new Md_cartype("6×6全连驱双后驻车", "6×6全连驱双后驻车：123-2-23"));
		list.add(new Md_cartype("8×4双后驱双后驻车", "8×4双后驱双后驻车：34-2-34"));
		list.add(new Md_cartype("8×2中驱中驻车半挂", "8×2中驱中驻车半挂：3-1-3"));
		list.add(new Md_cartype("8×4双中驱双中驻车半挂", "8×4双中驱双中驻车半挂：23-2-23"));
		list.add(new Md_cartype("8×2后驱后驻车全挂", "8×2后驱后驻车全挂：4-1-4"));
		list.add(new Md_cartype("10×6三后驱三后驻车", "10×6三后驱三后驻车：345-3-345"));
		list.add(new Md_cartype("10X4双中驱双中驻车半挂", "10X4双中驱双中驻车半挂：34-2-34"));
		list.add(new Md_cartype("10X2中驱中驻车半挂", "10X2中驱中驻车半挂：3-1-3"));
		list.add(new Md_cartype("12X4双中驱双中驻车半挂", "12X4双中驱双中驻车半挂：34-2-34"));
		return list;
	}

	/**
	 * 获取 燃料种类
	 */
	public static List<Md_cartype> Get_rlzl() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("A", "汽油"));
		list.add(new Md_cartype("B", "柴油"));
		list.add(new Md_cartype("C", "电"));
		list.add(new Md_cartype("D", "混合油"));
		list.add(new Md_cartype("E", "天然气"));
		list.add(new Md_cartype("F", "液化石油气"));
		list.add(new Md_cartype("L", "甲醇"));
		list.add(new Md_cartype("M", "乙醇"));
		list.add(new Md_cartype("N", "太阳能"));
		list.add(new Md_cartype("O", "混合动力"));
		list.add(new Md_cartype("Y", "无"));
		list.add(new Md_cartype("Z", "其它"));
		return list;
	}

	/**
	 * 是否
	 */
	public static List<Md_cartype> Get_is() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "否"));
		list.add(new Md_cartype("1", "是"));
		return list;
	}

	/**
	 * 初检/复检
	 */
	public static List<Md_cartype> Get_cjfj() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "初检"));
		list.add(new Md_cartype("1", "复检"));
		return list;
	}

	/**
	 * 空载/满载
	 */
	public static List<Md_cartype> Get_kzmz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "空载"));
		list.add(new Md_cartype("1", "满载"));
		return list;
	}

	/**
	 * 获取 颜色对应
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_colors() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("J", "黑"));
		list.add(new Md_cartype("A", "白"));
		list.add(new Md_cartype("B", "灰"));
		list.add(new Md_cartype("C", "黄"));
		list.add(new Md_cartype("D", "粉"));
		list.add(new Md_cartype("E", "红"));
		list.add(new Md_cartype("F", "紫"));
		list.add(new Md_cartype("G", "绿"));
		list.add(new Md_cartype("H", "蓝"));
		list.add(new Md_cartype("I", "棕"));
		list.add(new Md_cartype("Z", "其它"));
		return list;
	}

	public static List<Md_cartype> Get_jcxdh() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "1号线"));
		list.add(new Md_cartype("2", "2号线"));
		list.add(new Md_cartype("3", "3号线"));
		list.add(new Md_cartype("4", "4号线"));
		list.add(new Md_cartype("5", "5号线"));
		list.add(new Md_cartype("6", "6号线"));
		list.add(new Md_cartype("7", "7号线"));
		list.add(new Md_cartype("8", "8号线"));
		list.add(new Md_cartype("9", "9号线"));
		list.add(new Md_cartype("10", "10号线"));
		list.add(new Md_cartype("11", "11号线"));
		list.add(new Md_cartype("12", "12号线"));
		list.add(new Md_cartype("13", "13号线"));
		list.add(new Md_cartype("14", "14号线"));
		list.add(new Md_cartype("15", "15号线"));
		return list;
	}
	
	public static List<Md_cartype> Get_jycs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "1次"));
		list.add(new Md_cartype("2", "2次"));
		list.add(new Md_cartype("3", "3次"));
		list.add(new Md_cartype("4", "4次"));
		list.add(new Md_cartype("5", "5次"));
		list.add(new Md_cartype("6", "6次"));
		list.add(new Md_cartype("7", "7次"));
		return list;
	}

	/**
	 * 获取 颜色对应二
	 * 
	 * @return
	 */
	public static String Get_colors2(String type) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("0", "无");
		resultMap.put("J", "黑");
		resultMap.put("A", "白");
		resultMap.put("B", "灰");
		resultMap.put("C", "黄");
		resultMap.put("D", "粉");
		resultMap.put("E", "红");
		resultMap.put("F", "紫");
		resultMap.put("G", "绿");
		resultMap.put("H", "蓝");
		resultMap.put("I", "棕");
		resultMap.put("Z", "其它");
		//resultMap.put(",", ",");
		return resultMap.get(type);
	}

	/**
	 * 获取 颜色对应三
	 * 
	 * @return
	 */
	public static String Get_colors3(String type) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("无", "0");
		resultMap.put("黑", "J");
		resultMap.put("白", "A");
		resultMap.put("灰", "B");
		resultMap.put("黄", "C");
		resultMap.put("粉", "D");
		resultMap.put("红", "E");
		resultMap.put("紫", "F");
		resultMap.put("绿", "G");
		resultMap.put("蓝", "H");
		resultMap.put("棕", "I");
		resultMap.put("其它", "Z");
		//resultMap.put(",", ",");
		return resultMap.get(type);
	}

	/**
	 * 获取 颜色对应三
	 * 
	 * @return
	 */
	public static String Get_dp(String type) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("四川", "sc");
		resultMap.put("广东", "gdhs");
		resultMap.put("北京", "bj");
		return resultMap.get(type);
	}

	/**
	 * 获取 灯制对应
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_dz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "请选择"));
		list.add(new Md_cartype("03", "二灯远近光"));
		list.add(new Md_cartype("04", "二灯近光"));
		list.add(new Md_cartype("05", "一灯远光"));
		list.add(new Md_cartype("01", "四灯远近光"));
		list.add(new Md_cartype("02", "四灯远光"));
		list.add(new Md_cartype("00", "无"));
		return list;
	}

	/**
	 * 获取制动力源
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_zzly() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		//制动力源增加”请选择选项“，默认提交null
		list.add(new Md_cartype("","请选择"));
		list.add(new Md_cartype("0", "气压制动"));
		list.add(new Md_cartype("1", "液压制动"));
		list.add(new Md_cartype("2", "气推油制动"));
		return list;
	}

	/**
	 * 远光单独调整
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_ygddtz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "请选择"));
		list.add(new Md_cartype("", "无"));
		list.add(new Md_cartype("0", "不能单独调整"));
		list.add(new Md_cartype("1", "单独调整"));
		return list;
	}

	/**
	 * 远光单独调整
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_zxzxjxs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("-1", "请选择"));
		list.add(new Md_cartype("", "无"));
		list.add(new Md_cartype("0", "独立悬架"));
		list.add(new Md_cartype("1", "非独立悬架"));
		return list;
	}

	/**
	 * 灯高
	 */
	public static List<Md_cartype> Get_dg() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		for (int i = 60; i <= 130; i += 5) {
			list.add(new Md_cartype(i + "", i + ""));
		}
		return list;
	}

	/**
	 * 路试判定方式
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_pdfs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "MFDD判定"));
		list.add(new Md_cartype("1", "制动距离判定"));
		return list;
	}

	/**
	 * 稳定性
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_wdx() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "未跑偏"));
		list.add(new Md_cartype("2", "左跑偏"));
		list.add(new Md_cartype("3", "右跑偏"));
		return list;
	}

	/**
	 * 应急操纵力方式 0-手操纵，1-脚操纵
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_yjczfs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "手操纵"));
		list.add(new Md_cartype("1", "脚操纵"));
		return list;
	}

	/**
	 * 0-未检，1-合格，2-不合格
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jlpd() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "未检"));
		list.add(new Md_cartype("1", "合格"));
		list.add(new Md_cartype("2", "不合格"));
		return list;
	}
	public static List<Md_cartype> Get_jlpd3() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("合格", "合格"));
		list.add(new Md_cartype("不合格", "不合格"));
		return list;
	}
	/**
	 * 0-不适用，1-合格，2-不合格
	 * 
	 * @return
	 */
	public static List<Md_cartype> Get_jlpd2() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "不适用"));
		list.add(new Md_cartype("1", "合格"));
		list.add(new Md_cartype("2", "不合格"));
		return list;
	}

	public static List<Md_cartype> Get_jccs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "1次"));
		list.add(new Md_cartype("2", "2次"));
		list.add(new Md_cartype("3", "3次"));
		list.add(new Md_cartype("4", "4次"));
		list.add(new Md_cartype("5", "5次"));
		list.add(new Md_cartype("6", "6次"));
		list.add(new Md_cartype("7", "7次"));
		list.add(new Md_cartype("8", "8次"));
		list.add(new Md_cartype("9", "9次"));
		list.add(new Md_cartype("10", "10次"));
		return list;
	}
	public static List<Md_cartype> Get_dgwz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "左灯"));
		list.add(new Md_cartype("1", "右灯"));
		return list;
	}
	
	public static List<Md_cartype> Get_zcpd() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "20%"));
		list.add(new Md_cartype("1", "15%"));
		return list;
	}
/**
 * 修改照片排序
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
		// list.add(new Md_cartype("01", "机动车行驶证"));
		// list.add(new Md_cartype("02", "机动车牌证申请表"));
		// list.add(new Md_cartype("03", "机动车交通事故责任强制保险凭证"));
		// list.add(new Md_cartype("04", "机动车安全技术检验报告单"));
		// list.add(new Md_cartype("05", "机动车查验记录表"));
		// list.add(new Md_cartype("06", "车船税纳税或者免税证明"));
		// list.add(new Md_cartype("07", "委托核发检验合格标志通知书"));
		// list.add(new Md_cartype("08", "代理人授权书"));
		// list.add(new Md_cartype("11", "车前斜视45度照片"));
		// list.add(new Md_cartype("12", "车后斜视45度照片"));
		// list.add(new Md_cartype("13", "车辆识别代号照片"));
		// list.add(new Md_cartype("14", "机动车侧面照片"));
		// list.add(new Md_cartype("15", "车内最前方向后照片"));
		// list.add(new Md_cartype("16", "灭火器照片"));
		// list.add(new Md_cartype("17", "安全手锤照片"));
		// list.add(new Md_cartype("18", "行驶记录仪或GPS照片"));
		// list.add(new Md_cartype("19", "发动机号或柔性标签"));
		// list.add(new Md_cartype("20", "安全顶窗照片"));
		// list.add(new Md_cartype("21", "灯光工位拍摄照片"));
		// list.add(new Md_cartype("22", "制动工位拍摄照片"));
		// list.add(new Md_cartype("23", "底盘工位拍摄照片"));
		// list.add(new Md_cartype("24", "三角警示牌"));
		// list.add(new Md_cartype("25", "乘客门、应急门（窗）"));
		// list.add(new Md_cartype("26", "校车标志牌"));
		// list.add(new Md_cartype("27", "急救箱"));
		// list.add(new Md_cartype("28", "校车标志灯和停车指示标志"));
		// list.add(new Md_cartype("29", "照管人员座椅"));
		// list.add(new Md_cartype("30", "缓速器操作装置图形标志"));
		// list.add(new Md_cartype("31", "乘客门应急开关"));
		// list.add(new Md_cartype("32", "发动机自动灭火装置"));
		// list.add(new Md_cartype("33", "前轮盘式制动器"));
		// list.add(new Md_cartype("34", "ABS自检状态灯"));
		// list.add(new Md_cartype("35", "残疾车操纵辅助装置和自动变速器"));
		// list.add(new Md_cartype("36", "轮胎规格型号"));
		// list.add(new Md_cartype("37", "柴油发动机典型环保装置及后处理系统"));
		// list.add(new Md_cartype("38", "校车、卧铺客车的车内外录像监控系统"));
		// list.add(new Md_cartype("39", "校车的辅助倒车装置"));
		// list.add(new Md_cartype("40", "教练车辅助制动装置"));
		// list.add(new Md_cartype("41", "路试照片"));
		// list.add(new Md_cartype("42", "安全手锤及侧窗"));
		// list.add(new Md_cartype("90", "弹簧钢板片数"));
		// list.add(new Md_cartype("99", "照片"));
		// }
		return list;
	}

	public static List<Md_cartype> Get_xh() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("1", "一号线"));
		list.add(new Md_cartype("2", "二号线"));
		list.add(new Md_cartype("3", "三号线"));
		list.add(new Md_cartype("4", "四号线"));
		list.add(new Md_cartype("5", "五号线"));
		list.add(new Md_cartype("6", "六号线"));
		list.add(new Md_cartype("7", "七号线"));
		list.add(new Md_cartype("8", "八号线"));
		list.add(new Md_cartype("9", "九号线"));
		list.add(new Md_cartype("10", "十号线"));
		list.add(new Md_cartype("11", "十一号线"));
		list.add(new Md_cartype("12", "十二号线"));
		list.add(new Md_cartype("13", "十三号线"));
		list.add(new Md_cartype("14", "十四号线"));
		return list;
	}

	// 环保标志
	public static List<Md_cartype> Get_hbbz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("4星", "4星"));
		list.add(new Md_cartype("黄标", "黄标"));
		list.add(new Md_cartype("无星标", "无星标"));
		list.add(new Md_cartype("1星", "1星"));
		list.add(new Md_cartype("2星", "2星"));
		list.add(new Md_cartype("3星", "3星"));
		list.add(new Md_cartype("5星", "5星"));
		list.add(new Md_cartype("电动车", "电动车"));
		return list;
	}

	// 燃油
	public static List<Md_cartype> Get_rylb() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("汽油", "汽油"));
		list.add(new Md_cartype("柴油", "柴油"));
		list.add(new Md_cartype("LPG", "LPG"));
		list.add(new Md_cartype("天然气", "天然气"));
		list.add(new Md_cartype("其他", "其他"));

		return list;
	}

	public static List<Md_cartype> Get_pfbz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("国4", "国4"));
		list.add(new Md_cartype("国1前", "国1前"));
		list.add(new Md_cartype("国1", "国1"));
		list.add(new Md_cartype("国2", "国2"));
		list.add(new Md_cartype("国3", "国3"));
		list.add(new Md_cartype("国5", "国5"));
		list.add(new Md_cartype("无", "无"));
		return list;
	}

	public static List<Md_cartype> Get_clyt() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("其他", "其他"));
		list.add(new Md_cartype("公交", "公交"));
		list.add(new Md_cartype("出租", "出租"));
		list.add(new Md_cartype("环卫", "环卫"));
		list.add(new Md_cartype("旅游", "旅游"));
		list.add(new Md_cartype("运输", "运输"));
		list.add(new Md_cartype("特种", "特种"));
		list.add(new Md_cartype("邮政", "邮政"));
		list.add(new Md_cartype("渣土", "渣土"));

		return list;
	}

	public static List<Md_cartype> Get_gyfs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("闭环", "闭环"));
		list.add(new Md_cartype("化油器", "化油器"));
		list.add(new Md_cartype("化油器改造", "化油器改造"));
		list.add(new Md_cartype("开环", "开环"));
		list.add(new Md_cartype("无", "无"));
		return list;
	}

	public static List<Md_cartype> Get_jqfs() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("自吸", "自吸"));
		list.add(new Md_cartype("增压", "增压"));
		list.add(new Md_cartype("无", "无"));
		return list;
	}

	public static List<Md_cartype> Get_sfsfqszxz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("0", "否"));
		list.add(new Md_cartype("1", "是"));
		return list;
	}

	public static List<Md_cartype> Get_pdsf() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("是", "是"));
		list.add(new Md_cartype("否", "否"));
		return list;
	}

	public static List<Md_cartype> Get_hbjcbz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("工况", "工况"));
		list.add(new Md_cartype("自由加速", "自由加速"));
		list.add(new Md_cartype("双怠速", "双怠速"));
		list.add(new Md_cartype("怠速", "怠速"));
		list.add(new Md_cartype("无", "无"));
		return list;
	}

	public static List<Md_cartype> Get_sfgz() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("无改造", "无改造"));
		list.add(new Md_cartype("黄改绿", "黄改绿"));
		list.add(new Md_cartype("黄改绿首检", "黄改绿首检"));
		return list;
	}

	public static List<Md_cartype> Get_bsx() {
		List<Md_cartype> list = new ArrayList<Md_cartype>();
		list.add(new Md_cartype("手动", "手动"));
		list.add(new Md_cartype("自动", "自动"));
		return list;
	}

	/**
	 * 查验项目数据适配
	 * 
	 * @return
	 */
	public static Map<String, View> Get_clgg(Context context) {
		Map<String, View> map = new HashMap<String, View>();
		map.put("1", new InfoItemEdt(context, "整车公告编号", null, "notice_BH", 1,
				null, false));
		map.put("2", new InfoItemEdt(context, "中文品牌", null, "notice_CLPP1", 1,
				null, false));
		map.put("3", new InfoItemEdt(context, "英文品牌", null, "notice_CLPP2", 1,
				null, false));
		map.put("4", new InfoItemEdt(context, "车辆型号", null, "notice_CLXH", 1,
				null, false));
		map.put("5", new InfoItemEdt(context, "企业ID", null, "notice_QYID", 1,
				null, false));
		map.put("6", new InfoItemEdt(context, "生产地址", null, "notice_SCDZ", 1,
				null, false));
		map.put("7", new InfoItemEdt(context, "发动机型号", null, "notice_FDJXH", 1,
				null, false));
		map.put("8", new InfoItemEdt(context, "识别代号序列", null, "notice_SBDHXL",
				1, null, false));
		map.put("9", new InfoItemEdt(context, "车辆类型", null, "notice_CLLX", 1,
				null, false));
		map.put("10", new InfoItemEdt(context, "制造国", null, "notice_ZZG", 1,
				null, false));
		map.put("11", new InfoItemEdt(context, "转向形式", null, "notice_ZXXS", 1,
				null, false));
		map.put("12", new InfoItemEdt(context, "燃料种类", null, "notice_RLZL", 1,
				null, false));
		map.put("13", new InfoItemEdt(context, "排量", " ml", "notice_PL", 2,
				"^[0-9]{1,5}$", false));
		map.put("14", new InfoItemEdt(context, "功率", "KW", "notice_GL", 2,
				"^[0-9]{1,5}$", false));
		map.put("15", new InfoItemEdt(context, "外廓长", " mm", "notice_CWKC", 2,
				"^[0-9]{1,5}$", false));
		map.put("16", new InfoItemEdt(context, "外廓宽", " mm", "notice_CWKK", 2,
				"^[0-9]{1,5}$", false));
		map.put("17", new InfoItemEdt(context, "外廓高", " mm", "notice_CWKG", 2,
				"^[0-9]{1,5}$", false));
		map.put("18", new InfoItemEdt(context, "货箱内部长", " mm", "notice_HXNBCD",
				2, "^[0-9]{1,5}$", false));
		map.put("19", new InfoItemEdt(context, "货箱内部宽", " mm", "notice_HXNBKD",
				2, "^[0-9]{1,5}$", false));
		map.put("20", new InfoItemEdt(context, "货箱内部高", " mm", "notice_HXNBGD",
				2, "^[0-9]{1,5}$", false));
		map.put("21", new InfoItemEdt(context, "钢板弹簧片数", " 个", "notice_GBTHPS",
				2, "^[0-9]{1,5}$", false));
		map.put("22", new InfoItemEdt(context, "轴数", " 个", "notice_ZS", 2,
				"^[0-9]{1,5}$", false));
		map.put("23", new InfoItemEdt(context, "轴距", " mm", "notice_ZJ", 2,
				"^[0-9]{1,5}$", false));
		map.put("24", new InfoItemEdt(context, "前轮距", " mm", "notice_QLJ", 2,
				"^[0-9]{1,5}$", false));
		map.put("25", new InfoItemEdt(context, "后轮距", " mm", "notice_HLJ", 2,
				"^[0-9]{1,5}$", false));
		map.put("26", new InfoItemEdt(context, "轮胎数", " 个", "notice_LTS", 2,
				"^[0-9]{1,5}$", false));
		map.put("27", new InfoItemEdt(context, "轮胎规格", null, "notice_LTGG", 1,
				null, false));
		map.put("28", new InfoItemEdt(context, "总质量", " kg", "notice_ZZL",
				2 | 8192, "^[0-9\\.]{1,5}$", false));
		map.put("29", new InfoItemEdt(context, "整备质量", " kg", "notice_ZBZL",
				2 | 8192, "^[0-9\\.]{1,5}$", false));
		map.put("30", new InfoItemEdt(context, "核定载质量", "  kg ",
				"notice_HDZZL", 2 | 8192, "^[0-9\\.]{1,6}$", false));
		map.put("31", new InfoItemEdt(context, "准牵引总质量", "  kg",
				"notice_ZQYZL", 2 | 8192, "^[0-9\\.]{1,6}$", false));
		map.put("32", new InfoItemEdt(context, "额定载客", " 个", "notice_HDZK", 2,
				"^[0-9]{1,5}$", false));
		map.put("33", new InfoItemEdt(context, "前驾驶室准乘人数", " 个", "notice_QPZK",
				2, "^[0-9]{1,5}$", false));
		map.put("34", new InfoItemEdt(context, "后驾驶室准乘人数", " 个", "notice_HPZK",
				2, "^[0-9]{1,5}$", false));
		map.put("35", new InfoItemEdt(context, "公告批次", null, "notice_PC", 1,
				null, false));
		map.put("36", new InfoItemEdt(context, "底盘ID", null, "notice_DPID", 2,
				"^[0-9]{1,5}$", false));
		map.put("37", new InfoItemEdt(context, "环保达标情况", null, "notice_HBDBQK",
				1, null, false));
		map.put("38", new InfoItemEdt(context, "公告发布类型", null, "notice_CSLX",
				1, null, false));
		map.put("39", new InfoItemEdt(context, "更新日期", null, "notice_GXRQ", 1,
				null, false));
		map.put("40", new InfoItemEdt(context, "备注", null, "notice_BZ", 1,
				null, false));
		map.put("41", new InfoItemEdt(context, "车辆制造企业名称", null,
				"notice_ZZCMC", 1, null, false));
		map.put("42", new InfoItemEdt(context, "公告发布日期", null, "notice_GGRQ",
				1, null, false));
		map.put("43", new InfoItemEdt(context, "是否免检", null, "notice_SFMJ", 1,
				null, false));
		map.put("44", new InfoItemEdt(context, "撤销生效日期", null, "notice_CXSXRQ",
				1, null, false));
		map.put("45", new InfoItemEdt(context, "底盘企业及型号", null, "DPQYXH", 1,
				null, false));
		map.put("46", new InfoItemEdt(context, "产品类别", null, "notice_CPLB", 1,
				null, false));
		map.put("47", new InfoItemEdt(context, "校验位", null, "notice_JYW", 1,
				null, false));
		map.put("48", new InfoItemEdt(context, "车型公告编号", null, "notice_CLGGBH",
				1, null, false));
		map.put("49", new InfoItemEdt(context, "是否允许注册", null, "notice_SFYXZC",
				1, null, false));
		map.put("50", new InfoItemEdt(context, "公告生效日期", null, "notice_GGSXRQ",
				1, null, false));
		map.put("51", new InfoItemEdt(context, "公告有效期标记", null,
				"notice_GGYXQBJ", 1, null, false));
		map.put("52", new InfoItemEdt(context, "撤销公告批次", null, "notice_CXGGPC",
				1, null, false));
		map.put("53", new InfoItemEdt(context, "撤销公告发布日期", null,
				"notice_CXGGRQ", 1, null, false));
		map.put("54", new InfoItemEdt(context, "停止生产日期", null, "notice_TZSCRQ",
				1, null, false));
		map.put("55", new InfoItemEdt(context, "有效期描述", null, "notice_YXQMS",
				1, null, false));
		map.put("56", new InfoItemEdt(context, "照片数", " 张", "notice_ZPS", 1,
				null, false));
		map.put("57", new InfoItemEdt(context, "免检有效期止", null, "notice_MJYXQZ",
				1, null, false));
		map.put("58", new InfoItemEdt(context, "反光标志企业", null, "notice_FGBSQY",
				1, null, false));
		map.put("59", new InfoItemEdt(context, "反光标志商标", null, "notice_FGBSSB",
				1, null, false));
		map.put("60", new InfoItemEdt(context, "反光标志型号", null, "notice_FGBSXH",
				1, null, false));
		map.put("61",
				new InfoItemEdt(context, "轴荷", "kg", "ZH", 1, null, false));
		map.put("62", new InfoItemEdt(context, "载质量利用系数", null,
				"notice_ZZLLYXS", 1, null, false));
		map.put("63", new InfoItemEdt(context, "半挂鞍座最大允许总质量", "kg",
				"notice_BGAZZDYXZZL", 1, null, false));
		map.put("64", new InfoItemEdt(context, "接近离去角", null, "notice_JJLQJ",
				1, null, false));
		map.put("65", new InfoItemEdt(context, "前悬后悬", null, "notice_QXHX", 1,
				null, false));
		map.put("66", new InfoItemEdt(context, "驾驶室类型", null, "notice_JSSLX",
				1, null, false));
		map.put("67", new InfoItemEdt(context, "传动型式", null, "notice_CDXS", 1,
				null, false));
		map.put("68", new InfoItemEdt(context, "最高车速", " km/h", "notice_ZGCS",
				1, null, false));
		map.put("69",
				new InfoItemEdt(context, "油耗", " L", "YH", 1, null, false));
		map.put("70", new InfoItemEdt(context, "前制动方式", null, "notice_QZDFS",
				1, null, false));
		map.put("71", new InfoItemEdt(context, "后制动方式", null, "notice_HZDFS",
				1, null, false));
		map.put("72", new InfoItemEdt(context, "前制动操作方式", null,
				"notice_QZDCZFS", 1, null, false));
		map.put("73", new InfoItemEdt(context, "后制动操作方式", null,
				"notice_HZDCZFS", 1, null, false));
		map.put("74", new InfoItemEdt(context, "发动机企业", null, "notice_FDJQY",
				1, null, false));
		map.put("75", new InfoItemEdt(context, "发动机商标", null, "notice_FDJSB",
				1, null, false));
		map.put("76", new InfoItemEdt(context, "是否带防抱死系统", null,
				"notice_YWABS", 1, null, false));
		map.put("77", new InfoItemEdt(context, "车辆名称", null, "notice_CLMC", 1,
				null, false));
		map.put("78", new InfoItemEdt(context, "企业代码", null, "notice_QYDM", 1,
				null, false));
		map.put("79", new InfoItemEdt(context, "公告标记 ", null, "notice_GGBJ", 1,
				null, false));
		return map;
	}

}

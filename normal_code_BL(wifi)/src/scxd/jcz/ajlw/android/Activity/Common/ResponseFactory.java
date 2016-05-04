package scxd.jcz.ajlw.android.Activity.Common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.Asset;
import scxd.jcz.ajlw.android.model.MD_Xml_Node;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

/**
 * 请求网络数据工具类
 * 
 * @author Administrator
 * 
 */
public class ResponseFactory {

	private static ResponseFactory defaultInstance;
	public static List<Bitmap> list = null;
	Map<String, String> systenUpgrade = null;
	Map<String, String> ggzp = null;
	static HashMap<String, String> resultMap = null;
	static HashMap<String, Object> resultMapobj = null;

	private ResponseFactory() {
	}

	public static ResponseFactory getInstance() {
		if (defaultInstance == null) {
			defaultInstance = new ResponseFactory();
		}
		return defaultInstance;
	}

	public Object decode(String jkid, String values) {
		if ("18Q89".equals(jkid)) {
			return decode_18Q89(values);
		} else if ("18J89".equals(jkid)) {
			return decode_18J89(values);
		} else if ("18C08".equals(jkid)) {
			return decode_18C08(values);
		} else if ("18C09".equals(jkid)) {
			return decode_18C09(values);
		} else if ("18Q09".equals(jkid)) {
			return decode_18Q09(values);
		} else if ("18Q46".equals(jkid)) {
			return decode_18Q46(values);
		} else if ("18C50".equals(jkid)) {
			return decode_18C50(values);
		} else if ("18C49".equals(jkid)) {
			return decode_18C49(values);
		} else if ("18C51".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18H01".equals(jkid)) {
			return decode_18H01(values);
		} else if ("18J05".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C47".equals(jkid)) {
			return decode_18C47(values);
		} else if ("18C63".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C55".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18Q11".equals(jkid)) {
			return decode_18Q11(values);
		} else if ("18Q51".equals(jkid)) {
			return decode_18Q51(values);
		} else if ("18Q12".equals(jkid)) {
			return decode_18Q12(values);
		} else if ("18C53".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C68".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C80".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C54".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C66".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C58".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C72".equals(jkid)) {
			return decode_DeleteCar(values);
		} else if ("01J12".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18Q22".equals(jkid)) {
			return decode_18Q22(values);
		} else if ("18J03".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C57".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18C57".equals(jkid)) {
			return decode_TongYong(values);
		} else if ("18Q49".equals(jkid)) {
			return decode_18Q49(values);
		} else if ("01C02".equals(jkid)) {
			return decode_01C02(values);
		} else if ("18J11".equals(jkid)) {
			return decode_18J11(values);
		} else if ("18J12".equals(jkid)) {
			return decode_18J12(values);
		} else if ("18J31".equals(jkid)) {
			return decode_18J31(values);
		} else if ("18C82".equals(jkid)) {
			return decode_ty(values);
		} else if ("18C59".equals(jkid)) {
			return decode_ty(values);
		} else if ("18C62".equals(jkid)) {
			return decode_ty(values);
		} else if ("18Q08".equals(jkid)) {
			return decode_ty(values);
		} else if("18Q72".equals(jkid)){
			return decode_18Q12(values);
		} else if("18J72".equals(jkid)){
			return decode_DeleteCar(values);
		}
		else {
			return new Object();
		}
	}

	private Object decode_ty(String xml) {
		Document doc = null;
		String code = "";
		String message = "";
		try {
			if (systenUpgrade != null) {
				systenUpgrade = null;
			}
			doc = DocumentHelper.parseText(xml);
			systenUpgrade = new HashMap<String, String>();
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				systenUpgrade.put("code", code);
				systenUpgrade.put("message", message);
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return systenUpgrade;
	}

	private Object decode_18J31(String xml) {
		Document doc = null;
		String code = "";
		String message = "";
		try {
			if (systenUpgrade != null) {
				systenUpgrade = null;
			}
			doc = DocumentHelper.parseText(xml);
			systenUpgrade = new HashMap<String, String>();
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				systenUpgrade.put("code", code);
				systenUpgrade.put("message", message);
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return systenUpgrade;
	}

	private Object decode_18J12(String xml) {
		Document doc = null;
		String code = "";
		String message = "";
		try {
			if (systenUpgrade != null) {
				systenUpgrade = null;
			}
			doc = DocumentHelper.parseText(xml);
			systenUpgrade = new HashMap<String, String>();
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				systenUpgrade.put("code", code);
				systenUpgrade.put("message", message);
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return systenUpgrade;
	}

	private Object decode_18J11(String xml) {
		Document doc = null;
		String code = "";
		String message = "";
		try {
			if (systenUpgrade != null) {
				systenUpgrade = null;
			}
			doc = DocumentHelper.parseText(xml);
			systenUpgrade = new HashMap<String, String>();
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				systenUpgrade.put("code", code);
				systenUpgrade.put("message", message);
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return systenUpgrade;
	}

	// <?xml version="1.0"
	// encoding="utf-8"?><root><head><code>1</code><message>查询成功</message><rownum>1</rownum></head><body><vehispara
	// id="0"><jyxm>B1,B2,B0,H1,H4,S1,A1,F1,C1,DC</jyxm></vehispara></body></root>
	private Object decode_18Q46(String xml) {
		if (resultMap != null) {
			resultMap = null;
		}
		String code = "";
		String message = "";
		String xjyxmdh = "";
		resultMap = new HashMap<String, String>();
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				resultMap.put("code", code);
				resultMap.put("message", message);
				Iterator iters = rootElt.elementIterator("body");
				while (iters.hasNext()) {
					Element recEle = (Element) iters.next();
					List<Element> items = recEle.elements();
					for (Element item : items) {
						List<Element> vals = item.elements();
						for (Element element : vals) {
							if (element.getName().equals("jyxm")) {
								String[] jyxms = URLDecoder_Str(
										element.getStringValue().trim()).split(
										",");
								if (jyxms.length > 0) {
									for (int i = 0; i < jyxms.length; i++) {
										resultMap.put(jyxms[i], "1");
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			return resultMap;
		}
		return resultMap;
	}

//	private Object decode_18C08(String xml) {
//		Document doc = null;
//		String code = "";
//		ArrayList<Map<String, String>> resultlist = null;
//		Map<String, String> ggxx = null;
//		try {
//			doc = DocumentHelper.parseText(xml);
//			ggxx = new HashMap<String, String>();
//			Element rootElt = doc.getRootElement();
//			Iterator iter = rootElt.elementIterator("head");
//			while (iter.hasNext()) {
//				Element recordEle = (Element) iter.next();
//				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
//				if (code.equals("0") || code.equals("$EE")) {
//					return R.string.GETXML_ERROR;
//				}
//			}
//			Iterator iterss = rootElt.elementIterator("body");
//			if (!iterss.hasNext()) {
//				return R.string.GETXML_ERROR;
//			}
//			while (iterss.hasNext()) {
//				Element recordEle = (Element) iterss.next();
//				List<Element> items = recordEle.elements();
//				if (Md_Car_Temp.getTempCar().ggcxlx.equals("zcggxxcx")) {
//					resultlist = null;
//					resultlist = new ArrayList<Map<String, String>>();
//					for (Element item : items) {
//						ggxx = null;
//						ggxx = new HashMap<String, String>();
//						List<Element> vals = item.elements();
//						for (Element element : vals) {
//							ggxx.put(element.getName(), URLDecoder_Str(element
//									.getStringValue().trim()));
//						}
//						resultlist.add(ggxx);
//					}
//				} else if (Md_Car_Temp.getTempCar().ggcxlx.equals("dpggxxcx")) {
//					resultlist = null;
//					resultlist = new ArrayList<Map<String, String>>();
//					for (Element item : items) {
//						ggxx = null;
//						ggxx = new HashMap<String, String>();
//						List<Element> vals = item.elements();
//						for (Element element : vals) {
//							ggxx.put("dp" + element.getName(),
//									URLDecoder_Str(element.getStringValue()
//											.trim()));
//						}
//						resultlist.add(ggxx);
//					}
//				}
//			}
//		} catch (Exception e) {
//			return R.string.GETXML_ERROR;
//		}
//		return resultlist;
//	}


/**
 * 18C08
 * 
 * @param xml
 * @return string
 */
@SuppressWarnings("unchecked")
public Object decode_18C08(String xml) {
//	System.out.println(xml);
	HashMap<String, String> resultMap = new HashMap<String, String>();
	ArrayList<HashMap<String, String>> ArrayresultMap = new ArrayList<HashMap<String, String>>();

	Document doc = null;
	try {
		doc = DocumentHelper.parseText(xml); // 将字符串转为XML
		Element rootElt = doc.getRootElement(); // 获取根节点

		Iterator iter = rootElt.elementIterator("head"); // 获取根节点下的子节点head
		// 遍历head节点
		if (iter.hasNext()) {
			Element recordEle = (Element) iter.next();
			// List<Element> items = recordEle.elements();
			resultMap.put("code",
					URLDecoder_Str(recordEle.elementTextTrim("code")));
			
			resultMap.put("message",
					URLDecoder_Str(recordEle.elementTextTrim("message")));
			
			if ("0".equals(URLDecoder_Str(recordEle.elementTextTrim("code")))) {
				return ArrayresultMap.add(resultMap);
			}

		}
		Iterator iterbody = (Iterator) rootElt.element("body")
				.elementIterator("vehispara");
		// 获取根节点下的子节点notice

		while (iterbody.hasNext()) {

			Element recordEle = (Element) iterbody.next();
			List<Element> items = recordEle.elements();
			for (Element element : items) {
				resultMap.put(element.getName(),
						URLDecoder_Str(element.getStringValue()).trim());
				// if (element.getName().equals("BH")) {
				// MD_CarInfo.ggbh = URLDecoder_Str(
				// element.getStringValue()).trim();
				// }
			}
			ArrayresultMap.add(resultMap);
		}
	} catch (Exception e) {
		return null;
	}
	return ArrayresultMap;
}



	private Object decode_18C09(String xml) {
		
		int j=0;
		Document doc = null;
		String code = "";
		String message = "";
		String rownum = "";
		try {
			doc = DocumentHelper.parseText(xml);
			ggzp = new HashMap<String, String>();
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				if (code.equals("$EE")) {
					ggzp.put("code", "0");
					ggzp.put("message", "查询公告照片失败!");
					return ggzp;
				}
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				ggzp.put("code", code);
				ggzp.put("message", message);

			}
			Iterator iterss = rootElt.elementIterator("body");
			if (!iterss.hasNext()) {
				return ggzp;
			}
			String zpbha="";
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless.elementIterator("vehispara");
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					String zpbh = URLDecoder_Str(itemEle
							.elementTextTrim("zpbh"));
					if(TextUtils.isEmpty(zpbha)){
						zpbha=zpbh;
					}else{
						zpbha+=","+zpbh;
					}
					byte[] bs = null;
					try {
						j++;
						String s = "zp" + j + "";
						

					//	Element _vio = (Element) itersElIterator.next();
						FileUtil.writeToFile(URLedecoder_Str(itemEle
								.elementTextTrim(s.trim())),"/mnt/sdcard/jclwjcz/ggimage/"
										+ Md_Car_Temp.getTempCar().ggbh
										+ "/"+s+".txt");
						 bs = Base64.decode(URLedecoder_Str(itemEle
								.elementTextTrim(s.trim())), Base64.DEFAULT);
						/*list.add(resizeBitmap(BitmapFactory.decodeByteArray(bs,
								0, bs.length)));*/
						 if (!zpbh.equals("")) {
								BitmapUtil.saveBitmap(BitmapFactory
										.decodeByteArray(bs, 0, bs.length),
										"/mnt/sdcard/jclwjcz/ggimage/"
												+ Md_Car_Temp.getTempCar().ggbh
												+ "/" + zpbh + ".jpg",
										BitmapUtil.JPG);
								ggzp.put("zpbh", zpbha);
							}
						bs = null;
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (bs != null) {
							bs = null;
						}
					}
				}
			}
		} catch (Exception e) {
			return ggzp;
		}
		return ggzp;
	}

	private Object decode_18J89(String xml) {
		Document doc = null;
		String code = "";
		String message = "";
		try {
			if (systenUpgrade != null) {
				systenUpgrade = null;
			}
			doc = DocumentHelper.parseText(xml);
			systenUpgrade = new HashMap<String, String>();
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				systenUpgrade.put("code", code);
				systenUpgrade.put("message", message);
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return systenUpgrade;
	}

	private Object decode_18Q89(String xml) {
		Document doc = null;
		String code = "";
		String message = "";
		String pdaver = "";
		String pdaupdate = "";
		String pdapath = "";
		try {
			if (systenUpgrade != null) {
				systenUpgrade = null;
			}
			systenUpgrade = new HashMap<String, String>();
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				systenUpgrade.put("code", code);
				systenUpgrade.put("message", message);
			}
			Iterator iterss = rootElt.elementIterator("body");
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless
						.elementIterator("vehispara");
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					pdaver = URLDecoder_Str(itemEle.elementTextTrim("pdaver"));
					pdaupdate = URLDecoder_Str(itemEle
							.elementTextTrim("pdaupdate"));
					pdapath = URLDecoder_Str(itemEle.elementTextTrim("pdapath"));
					systenUpgrade.put("pdaver", pdaver);
					systenUpgrade.put("pdaupdate", pdaupdate);
					systenUpgrade.put("pdapath", pdapath);
				}
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return systenUpgrade;
	}

	private Object decode_18H01(String xml) {
		String code = "";
		List<Md_Car_TongYong> callKS = new ArrayList<Md_Car_TongYong>();
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				String message = URLDecoder_Str(recordEle
						.elementTextTrim("message"));
				callKS.add(new Md_Car_TongYong(code, message));
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return callKS;
	}

	private Object decode_DeleteCar(String xml) {
		String code = "";
		List<Md_Car_TongYong> callKS = new ArrayList<Md_Car_TongYong>();
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				String message = URLDecoder_Str(recordEle
						.elementTextTrim("message"));
				callKS.add(new Md_Car_TongYong(code, message));
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return callKS;
	}

	private Object decode_18Q51(String xml) {
		String code = "";
		String message = "";
		Document doc = null;
		List<MD_Xml_Node> listMXN = new ArrayList<MD_Xml_Node>();
		try {
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				if (code.equals("0")) {
					return R.string.GETDATA_ERROR;
				}
			}
			Iterator iterss = rootElt.elementIterator("body"); // /获取根节点下的子节点body
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless
						.elementIterator("vehispara"); // 获取子节点body下的子节点form
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					String hphm = URLDecoder_Str(itemEle
							.elementTextTrim("hphm"));
					String hpzl = URLDecoder_Str(itemEle
							.elementTextTrim("hpzl"));
					listMXN.add(new MD_Xml_Node("", "", code, message, "", "",
							hpzl, hphm, "", "", "", "", "", "", ""));
				}
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return listMXN;
	}

	public static Object decode_18Q49(String xml) {
		if (resultMap != null) {
			resultMap = null;
		}
		resultMap = new HashMap<String, String>();
		if (xml.equals("")) {
			resultMap.put("hasdata", "0"); // 0表示没有数据
			return resultMap;
		}
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			if (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				if ((URLDecoder_Str(recordEle.elementTextTrim("code")))
						.equals("0")) {
					resultMap.put("hasdata", "0"); // 0表示没有数据
					return resultMap;
				} else {
					resultMap.put("hasdata", "1"); // 0表示有数据
				}
			}
			Iterator iterbody = rootElt.elementIterator("body");
			if (iterbody.hasNext()) {
				Element recordEle = (Element) iterbody.next();
				List<Element> items = recordEle.elements();
				for (Element item : items) {
					String zpzl = "";
					String zpmc = "";
					List<Element> vals = item.elements();
					for (Element element : vals) {
						if (element.getName().equals("zpmc")) {
							zpmc = URLDecoder_Str(element.getStringValue())
									.trim();
						} else {
							zpzl = URLDecoder_Str(element.getStringValue())
									.trim();
						}
					}
					resultMap.put(zpzl, zpmc);
				}
			}
		} catch (Exception e) {
			return resultMap;
		}
		return resultMap;
	}

	/**
	 * 获取服务器时间
	 * 
	 * @param xml
	 * @return
	 */
	public static Object decode_18C50(String xml) {
		Document doc = null;
		String code = "";
		String message = "";
		String sj = "";
		try {
			if (resultMap != null) {
				resultMap = null;
			}
			resultMap = new HashMap<String, String>();
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				resultMap.put("code", code);
				resultMap.put("message", message);
				if (code.equals("$E") || code.equals("0")) {
					return resultMap;
				}
			}
			Iterator iterss = rootElt.elementIterator("body");
			if (!iterss.hasNext()) {
				return R.string.GETXML_ERROR;
			}
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless
						.elementIterator("vehispara");
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					sj = URLDecoder_Str(itemEle.elementTextTrim("sj"));
					resultMap.put("sj", sj);
				}
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return resultMap;
	}

	/**
	 * 获取补拍车辆列表
	 * 
	 * @param xml
	 * @return
	 */
	private static Object decode_18Q12(String xml) {
		String code = "";
		String message = "";
		String rownum = "";
		Document doc = null;
		List<MD_Xml_Node> listMXN = new ArrayList<MD_Xml_Node>();
		try {
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				if (code.equals("0")) {
					return R.string.GETDATA_ERROR;
				}
			}
			Iterator iterss = rootElt.elementIterator("body");
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless
						.elementIterator("vehispara");
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					String dlsj = URLDecoder_Str(
							itemEle.elementTextTrim("dlsj")).replace("T", " ");
					String jclsh = URLDecoder_Str(itemEle
							.elementTextTrim("jylsh"));

					String jyjl = URLDecoder_Str(itemEle
							.elementTextTrim("jyjl"));
					if ("".equals(jyjl) || "0".equals(jyjl)) {
						jyjl = "检测中";
					} else if ("1".equals(jyjl)) {
						jyjl = "合格";
					} else if ("2".equals(jyjl)) {
						jyjl = "不合格";
					} else if ("3".equals(jyjl)) {
						jyjl = "合格建议维护";
					}

					String clsbdh = URLDecoder_Str(itemEle
							.elementTextTrim("clsbdh"));
					String hphm = URLDecoder_Str(itemEle
							.elementTextTrim("hphm"));
					String hpzl = URLDecoder_Str(itemEle
							.elementTextTrim("hpzl"));
					String car_jycs = URLDecoder_Str(itemEle
							.elementTextTrim("jycs"));
					String cllx = URLDecoder_Str(itemEle
							.elementTextTrim("cllx"));
					String jylb = URLDecoder_Str(itemEle
							.elementTextTrim("jylb"));
					String Syxz = URLDecoder_Str(itemEle
							.elementTextTrim("syxz"));
					String clpp1 = URLDecoder_Str(itemEle
							.elementTextTrim("clpp1"));
					String clxh = URLDecoder_Str(itemEle
							.elementTextTrim("clxh"));
					listMXN.add(new MD_Xml_Node(dlsj, cllx, code, message,
							rownum, jclsh, hpzl, hphm, clsbdh, car_jycs, "0",
							Syxz, jylb, jyjl, "",clpp1,clxh));
				}
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return listMXN;
	}

	public static Object decode_18Q22(String xml) {
		Document doc = null;
		String code = "";
		String message = "";
		String wpzp = "";
		try {
			if (resultMap != null) {
				resultMap = null;
			}
			resultMap = new HashMap<String, String>();
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				resultMap.put("code", code);
				resultMap.put("message", message);
				if (code.equals("$E") || code.equals("0")) {
					return R.string.GETXML_ERROR;
				}
			}
			Iterator iterss = rootElt.elementIterator("body");
			if (!iterss.hasNext()) {
				return R.string.GETXML_ERROR;
			}
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless
						.elementIterator("vehispara");
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					wpzp = URLDecoder_Str(itemEle.elementTextTrim("wpzp"));
					resultMap.put("wpzp", wpzp);
				}
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return resultMap;
	}

	public static Object decode_18C47(String xml) {
		Document doc = null;
		String code = "";
		String message = "";
		String cyxm = "";
		String cyzp = "";
		String wgjyzp = "";
		String zlzp = "";
		String wgjcxm = "";
		String dpjyxm = "";
		String dtdpjyxm = "";
		String pdyj = "";
		String wjfjx = "";
		String dpfjx = "";
		String dpdtfjx = "";
		try {
			if (resultMap != null) {
				resultMap = null;
			}
			resultMap = new HashMap<String, String>();
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				resultMap.put("code", code);
				resultMap.put("message", message);
				if (code.equals("$E") || code.equals("0")) {
					return R.string.GETXML_ERROR;
				}
			}
			Iterator iterss = rootElt.elementIterator("body");
			if (!iterss.hasNext()) {
				resultMap.put("hasbody", "no");
				return resultMap;
			} else {
				resultMap.put("hasbody", "yes");
			}
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless
						.elementIterator("vehispara");
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					cyxm = URLDecoder_Str(itemEle.elementTextTrim("cyxm"));
					cyzp = URLDecoder_Str(itemEle.elementTextTrim("cyzp"));
					wgjyzp = URLDecoder_Str(itemEle.elementTextTrim("wgjyzp"));
					zlzp = URLDecoder_Str(itemEle.elementTextTrim("zlzp"));
					wgjcxm = URLDecoder_Str(itemEle.elementTextTrim("wgjcxm"));
					dpjyxm = URLDecoder_Str(itemEle.elementTextTrim("dpjyxm"));
					pdyj = URLDecoder_Str(itemEle.elementTextTrim("pdyj"));
					if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
							|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
							|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
							|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
							|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
							|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
							|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
						wgjcxm = wgjcxm + ",00001";
						dtdpjyxm = URLDecoder_Str(itemEle
								.elementTextTrim("dtdpjyxm"));
					} else {
						if (Arrays.asList(dpjyxm.split(",")).contains("084")
								|| Arrays.asList(dpjyxm.split(",")).contains(
										"45")) {
							dtdpjyxm = URLDecoder_Str(itemEle
									.elementTextTrim("dtdpjyxm"));
						} else {
							dpjyxm = URLDecoder_Str(itemEle
									.elementTextTrim("dtdpjyxm"));
							dtdpjyxm = URLDecoder_Str(itemEle
									.elementTextTrim("dpjyxm"));
						}
					}
					try {
						wjfjx = URLDecoder_Str(itemEle
								.elementTextTrim("wjbhgx"));
						dpfjx = URLDecoder_Str(itemEle
								.elementTextTrim("dpbhgx"));
						dpdtfjx = URLDecoder_Str(itemEle
								.elementTextTrim("dpdtbhgx"));
					} catch (Exception e) {
						wjfjx = "";
						dpfjx = "";
						dpdtfjx = "";
					}
					// 可选检验项目
					String kxwgjcxm = "";
					String kxdpjyxm = "";
					String kxdtdpjyxm = "";
					try {
						// kxwgjcxm = "80,81";
						kxwgjcxm = URLDecoder_Str(itemEle
								.elementTextTrim("wgkxjyxm"));
						// kxdpjyxm = URLDecoder_Str(itemEle
						// .elementTextTrim("kxdpjyxm"));
						// kxdtdpjyxm = URLDecoder_Str(itemEle
						// .elementTextTrim("kxdtdpjyxm"));
					} catch (Exception e) {
						kxwgjcxm = "";
						kxdpjyxm = "";
						kxdtdpjyxm = "";
					}
					resultMap.put("cyxm", cyxm);
					resultMap.put("cyzp", cyzp);
					resultMap.put("wgjyzp", wgjyzp);
					resultMap.put("zlzp", zlzp);
					resultMap.put("wgjcxm", wgjcxm);
					resultMap.put("dpjyxm", dpjyxm);
					resultMap.put("pdyj", pdyj);
					resultMap.put("dtdpjyxm", dtdpjyxm);
					resultMap.put("wjfjx", wjfjx);
					resultMap.put("dpfjx", dpfjx);
					resultMap.put("dpdtfjx", dpdtfjx);
					resultMap.put("kxwgjcxm", kxwgjcxm);
					resultMap.put("kxdpjyxm", kxdpjyxm);
					resultMap.put("kxdtdpjyxm", kxdtdpjyxm);
				}
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return resultMap;
	}

	/**
	 * 查询注册登记照片
	 * 
	 * @param call
	 * @return
	 */
	public static Object decode_01C02(String xml) {
		if (resultMapobj != null) {
			resultMapobj = null;
		}
		resultMapobj = new HashMap<String, Object>();
		Document doc = null;
		byte[] bs = null;
		try {
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("body");
			if (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				List<Element> items = recordEle.elements();
				for (Element item : items) {
					List<Element> vals = item.elements();
					for (Element element : vals) {

						if (element.getName().trim().equals("zp")) {
							if (element.getStringValue() != null
									&& !element.getStringValue().equals("")) {
								bs = Base64.decode(
										URLDecoder.decode(
												element.getStringValue(),
												"UTF-8").replace("%2B", "+"),
										Base64.DEFAULT);
								resultMapobj.put("zp",
										resizeBitmap(BitmapFactory
												.decodeByteArray(bs, 0,
														bs.length)));
							} else {
								resultMapobj.put("zp", null);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			resultMapobj.put("zp", null);
			return resultMapobj;
		} finally {
			if (bs != null) {
				bs = null;
			}
		}
		return resultMapobj;
	}

	/**
	 * 照片压缩并
	 */
	public static Bitmap resizeBitmap(Bitmap bitmap) {
		Bitmap bitmapes = null;
		try {
			if (bitmap == null) {
				return null;
			} else {
				// 压缩
				int newWidth = 400;
				int newHeight = 300;
				float scaleWidth = (float) newWidth / bitmap.getWidth();
				float scaleHeight = (float) newHeight / bitmap.getHeight();
				Matrix matrix = new Matrix();
				matrix.postScale(scaleWidth, scaleHeight);
				bitmapes = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
						bitmap.getHeight(), matrix, false);
			}
		} catch (Exception e) {
			return null;
		}
		return bitmapes;
	}

	/**
	 * 获取车辆列表
	 * 
	 * @param xml
	 * @return
	 */
	private static Object decode_18Q11(String xml) {
		String code = "";
		String message = "";
		String rownum = "";
		Document doc = null;
		List<MD_Xml_Node> listMXN = new ArrayList<MD_Xml_Node>();
		try {
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				message = URLDecoder_Str(recordEle.elementTextTrim("message"));
				if (code.equals("0")) {
					listMXN.add(new MD_Xml_Node("", "", code, message, "", "",
							"", "", "", "", "", "", "", "", ""));
					return listMXN;
				}
			}
			Iterator iterss = rootElt.elementIterator("body"); // /获取根节点下的子节点body
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless
						.elementIterator("vehispara"); // 获取子节点body下的子节点form
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					String jclsh = URLDecoder_Str(itemEle
							.elementTextTrim("jylsh"));
					String clsbdh = URLDecoder_Str(itemEle
							.elementTextTrim("clsbdh"));
					String hphm = URLDecoder_Str(itemEle
							.elementTextTrim("hphm"));
					String hpzl = URLDecoder_Str(itemEle
							.elementTextTrim("hpzl"));
					String car_jycs = URLDecoder_Str(itemEle
							.elementTextTrim("jycs"));
					String cllx = URLDecoder_Str(itemEle
							.elementTextTrim("cllx"));
					String jylb = URLDecoder_Str(itemEle
							.elementTextTrim("jylb"));
					String Syxz = URLDecoder_Str(itemEle
							.elementTextTrim("syxz"));
					listMXN.add(new MD_Xml_Node("", cllx, code, message,
							rownum, jclsh, hpzl, hphm, clsbdh, car_jycs, "0",
							Syxz, jylb, "", ""));
				}
			}
		} catch (Exception e) {
			listMXN.add(new MD_Xml_Node("", "", code, message, "", "", "", "",
					"", "", "", "", "", "", ""));
			return listMXN;
		}
		return listMXN;
	}

	/**
	 * 解析通用XML并返回Code 和 Message
	 * 
	 * @param xml
	 * @return
	 */
	private static Object decode_TongYong(String xml) {
		if (resultMap != null) {
			resultMap = null;
		}

		String code = "";
		resultMap = new HashMap<String, String>();
		List<Md_Car_TongYong> callKS = new ArrayList<Md_Car_TongYong>();
		if ("".equals(xml)) {
			// resultMap.put("code", "0");
			// resultMap.put("message", "数据请求失败，请重试");
			callKS.add(new Md_Car_TongYong("0", "数据请求失败，请重试"));
			return callKS;
		}
		try {
			// 将结果转换为Domcument
			Document doc = DocumentHelper.parseText(xml);

			// 获取根节点
			Element rootElt = doc.getRootElement();

			// 获取根节点下的子节点head迭代器
			Iterator iter = rootElt.elementIterator("head");
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();

				// 拿到head节点下的子节点code值
				code = URLDecoder_Str(recordEle.elementTextTrim("code"));
				resultMap.put("code", code);

				// 拿到head节点下的子节点message值
				String message = URLDecoder_Str(recordEle
						.elementTextTrim("message"));
				resultMap.put("message", message);
				callKS.add(new Md_Car_TongYong(code, message));
				Iterator iters = rootElt.elementIterator("body");
				while (iters.hasNext()) {
					Element recordEles = (Element) iters.next();
					String jylsh = recordEles.elementTextTrim("jylsh");
					String jycs = recordEles.elementTextTrim("jycs");
					try {
						String jyxm = recordEles.elementTextTrim("jyxm");
						String ywcjyxm = recordEles.elementTextTrim("ywcjyxm");
						Md_Car_Temp.getTempCar().car_jyxm = null;
						if (!TextUtils.isEmpty(jyxm)) {
							Md_Car_Temp.getTempCar().car_jyxm = Arrays
									.asList(jyxm.split(","));
						}
						Md_Car_Temp.getTempCar().car_ywcjyxm = null;
						if (!TextUtils.isEmpty(ywcjyxm)) {
							Md_Car_Temp.getTempCar().car_ywcjyxm = Arrays
									.asList(ywcjyxm.split(","));
						}
					} catch (Exception e) {
						Md_Car_Temp.getTempCar().car_jyxm = null;
						Md_Car_Temp.getTempCar().car_ywcjyxm = null;
					}
					if (!TextUtils.isEmpty(jylsh)) {
						Md_Car_Temp.getTempCar().car_lsh = URLDecoder_Str(jylsh);
					}
					if (!TextUtils.isEmpty(jycs)) {
						Md_Car_Temp.getTempCar().car_jycs = URLDecoder_Str(jycs);
					}
					List<Md_Car_TongYong> tongYongResult = new ArrayList<Md_Car_TongYong>();
					tongYongResult.add(new Md_Car_TongYong(code, message));

					return tongYongResult;

				}

			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return callKS;
	}

	public static String isHZ(String str) {
		if (str.equals("")) {
			return "";
		}
		char[] chars = str.toCharArray();
		char[] cs = { chars[0] };
		if (MD_ListItem.Get_sfs(new String(cs)) != null
				&& !MD_ListItem.Get_sfs(new String(cs)).equals("")) {
			return str.substring(1, str.length());
		}
		return str;
	}

	/**
	 * 解析车辆基本信息
	 * 
	 * @param xml
	 * @return
	 */
	private static Object decode_18C49(String xml) {
		if (resultMap != null) {
			resultMap = null;
		}
		resultMap = new HashMap<String, String>();
		if ("".equals(xml)) {
			resultMap.put("code", "0");
			resultMap.put("message", "调取车辆信息失败，请等待5-10秒重试");
			return resultMap;
		}
		Document doc = null;
		try {

			doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			Iterator iter = rootElt.elementIterator("head"); // 获取根节点下的子节点head
			if (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				resultMap.put("code",
						URLDecoder_Str(recordEle.elementTextTrim("code")));
				resultMap.put("message",
						URLDecoder_Str(recordEle.elementTextTrim("message")));
				if (recordEle.elementTextTrim("code").equals("$E")) {
					return resultMap;
				}
			}
			Iterator iterbody = rootElt.elementIterator("body"); // 获取根节点下的子节点body
			if (!iterbody.hasNext()) {
				resultMap.clear();
				resultMap.put("code", "0");
				resultMap.put("message", "车辆信息提取失败，请查看查询条件是否正确！");
				return resultMap;
			}
			if (iterbody.hasNext()) {
				Element recordEle = (Element) iterbody.next();
				List<Element> items = recordEle.elements();
				for (Element item : items) {
					List<Element> vals = item.elements();
					for (Element element : vals) {
						String value = "";
						if (element.getName().equals("hphm")) {
							resultMap.put(element.getName(),
									isHZ(URLDecoder_Str(element
											.getStringValue().trim())));
						} else if (element.getName().equals("csys")) {
							char[] chars = element.getStringValue()
									.toCharArray();
							if (chars.length > 0) {
								Md_Car_Temp.getTempCar().csys = URLDecoder_Str(
										element.getStringValue()).trim();
								String values = "";
								for (int i = 0; i < chars.length; i++) {
									char[] cs = { chars[i] };
									String csys = new String(cs);
									if (!values.equals("")) {
										values = values
												+ MD_ListItem.Get_colors2(csys
														.trim());
									} else {
										values = MD_ListItem.Get_colors2(csys
												.trim());
									}
								}
								if (values != null && !values.trim().equals("")) {
									resultMap.put(element.getName(),
											values.trim());
								} else {
									resultMap.put(element.getName(),
											URLDecoder_Str(element
													.getStringValue().trim()));
								}
							}
						} else if (element.getName().equals("jyxm")) {
							String[] jyxms = URLDecoder_Str(
									element.getStringValue().trim()).split(",");
							if (jyxms.length > 0) {
								for (int i = 0; i < jyxms.length; i++) {
									resultMap.put(jyxms[i], "1");
								}
							}
						} else {
							if (element.getName().equals("ltgg")) {
								String ltgg = CommonUtils
										.escapeExprSpecialWord(URLDecoder_Str(element
												.getStringValue().trim()));
								resultMap.put(element.getName(), ltgg);
							} else {
								resultMap.put(element.getName(),
										URLDecoder_Str(element.getStringValue()
												.trim()));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
		return resultMap;
	}

	/**
	 * 解析登录用户
	 * 
	 * @param values
	 * @return
	 */
	private Object decode_18Q09(String values) {
		Document doc = null;
		String msgTempString = "";
		boolean isData = false;
		try {
			doc = DocumentHelper.parseText(values); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			Iterator iter = rootElt.elementIterator("head"); // 获取根节点下的子节点head
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				String code = URLDecoder_Str(recordEle.elementTextTrim("code")); // 拿到head节点下的子节点title值
				String message = URLDecoder_Str(recordEle
						.elementTextTrim("message")); // 拿到head节点下的子节点title值
				msgTempString += code + "@" + message + "@";
			}
			Iterator iterss = rootElt.elementIterator("body"); // /获取根节点下的子节点body
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless
						.elementIterator("queryCondition"); // 获取子节点body下的子节点form
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					String value = null;
					String UserID = URLDecoder_Str(itemEle
							.elementTextTrim("yhdh"));
					String UserName = URLDecoder_Str(itemEle
							.elementTextTrim("xm"));
					String dddl = URLDecoder_Str(itemEle
							.elementTextTrim("dddl"));
					try {
						Md_Car_Temp.getTempCar().acl = URLDecoder_Str(itemEle
								.elementTextTrim("pdaqx"));// TODO 权限
						Md_Car_Temp.getTempCar().jyysfzh = URLDecoder_Str(itemEle
								.elementTextTrim("sfzmhm"));// TODO 权限

					} catch (Exception e) {
						Log.e("权限!!", "acl节点");
					}
					msgTempString += UserID + "@" + UserName+"@"+dddl+"@";
					isData = true;
				}
			}
			if (!isData) {
				msgTempString += "@";
			}
			return msgTempString;
		} catch (Exception e) {
			return R.string.GETXML_ERROR;
		}
	}

	/**
	 * UTF-8解码
	 * 
	 * @param str
	 * @return
	 */
	private static String URLDecoder_Str(String str) {
		if (TextUtils.isEmpty(str)) {
			return str;
		}
		try {
			return URLDecoder.decode(str, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}
	
	/**
	 * UTF-8解码
	 * 
	 * @param str
	 * @return
	 */
	private static String URLedecoder_Str(String str) {
		if (TextUtils.isEmpty(str)) {
			return str;
		}
		try {
			str=URLDecoder.decode(str, "UTF-8");
			str=str.replace(" ", "+");
//			return URLDecoder.decode(str, "UTF-8");
			return str;
			
		} catch (Exception e) {
			return str;
		}
	}
	
}

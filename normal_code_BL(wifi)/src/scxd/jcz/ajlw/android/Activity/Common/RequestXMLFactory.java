package scxd.jcz.ajlw.android.Activity.Common;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.model.Md_system;
/**
 * xml生成工具类
 * @author Administrator
 *@createtime
 */
public class RequestXMLFactory {

	private static RequestXMLFactory defaultInstance;

	private RequestXMLFactory() {
	}

	public static RequestXMLFactory getInstance() {
		if (defaultInstance == null) {
			defaultInstance = new RequestXMLFactory();
		}
		return defaultInstance;
	}

	/**
	 * 初始化节点值，以键值对的方式存储在Map<String, String[]> XMLKeys中，键表示jkid,值表示节点名称
	 */
	public Object create(String jkid, Map<String, Object> values,
			String... params) {

		try {

			StringBuilder urlStrBuilder = new StringBuilder();

			encodeToURL(urlStrBuilder, "xtlb", Md_system.getXtlb());
			encodeToURL(urlStrBuilder, "jkxlh", Md_system.getPtkey());
			encodeToURL(urlStrBuilder, "jkid", jkid);
			// encodeToURL(urlStrBuilder, "type", params[0]);
			encodeToURL(urlStrBuilder, "xmldoc", values, jkid);
			return urlStrBuilder.toString();
		} catch (Exception e) {
			return R.string.REQUEST_DATA_ERROR;
		}
	}
/**
 * 将数据组装成xml格式
 * @param urlStrBuilder
 * @param key
 * @param values
 * @param jkid
 * @throws Exception
 */
	private void encodeToURL(StringBuilder urlStrBuilder, String key,
			Map<String, Object> values, String jkid) throws Exception {

		// long milliTime = System.currentTimeMillis();

		StringBuilder mapXmlStrBuilder = new StringBuilder();
		mapXmlStrBuilder
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>");
		encodeMapToXML(mapXmlStrBuilder, values);
		mapXmlStrBuilder.append("</root>");

		if (jkid.equals("18C63")) {
			LogWriter.open().appendMethodB("requestData" + jkid,
					RequestXMLFactory.class, "$" + "上传照片" + "$");
		} else {
			LogWriter.open().appendMethodB("requestData" + jkid,
					RequestXMLFactory.class,
					"$" + mapXmlStrBuilder.toString() + "$");
		}
			encodeToURL(urlStrBuilder, key,
					URLEncoder.encode(mapXmlStrBuilder.toString(), "UTF-8"));
		
	}

	private void encodeToURL(StringBuilder urlStrBuilder, String key,
			Object value) throws Exception {
		if (urlStrBuilder.length() != 0) {
			urlStrBuilder.append('&');
		}
		urlStrBuilder.append(key);
		urlStrBuilder.append('=');
		urlStrBuilder.append(URLEncoder.encode(value.toString(), "UTF-8"));
		// urlStrBuilder.append(value.toString());
	}

	/**
	 * 组装xml
	 * @param strBuilder
	 * @param values
	 */
	private void encodeMapToXML(StringBuilder xmlStrBulder,
			Map<String, Object> values) throws Exception {
		Iterator<Map.Entry<String, Object>> it = values.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();

			String node = entry.getKey();
			Object value = entry.getValue();
			xmlStrBulder.append("<").append(node).append(">");

			if (value instanceof Map) {
				encodeMapToXML(xmlStrBulder, (Map<String, Object>) value);
			} else {
				xmlStrBulder.append(value);
			}

			xmlStrBulder.append("</").append(node).append(">");
		}
	}

}

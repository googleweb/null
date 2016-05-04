package scxd.jcz.ajlw.android.buss;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import scxd.jcz.ajlw.android.model.RgjyItem;
/**
 * 解析xml数据工具类
 * @author Administrator
 *
 */
public class GetXmlData {
	public static List<RgjyItem> readStringMXL_RgjyItem(String xml) {
		String code="";
		String message="";
		Document doc = null;
		List<RgjyItem> result = null;
		try {
			result = new ArrayList<RgjyItem>();
			doc = DocumentHelper.parseText(xml); 
			Element rootElt = doc.getRootElement();
			Iterator iter = rootElt.elementIterator("head"); 
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				code = URLDecoder_Str(recordEle.elementTextTrim("code")); 
				message = URLDecoder_Str(recordEle.elementTextTrim("message")); 
			}
			if (!code.equals("1")) {
				return null;
			}
			Iterator iterss = rootElt.elementIterator("body");
			if (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless.elementIterator("jyxm"); // 获取子节点body下的子节点form
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					RgjyItem item = new RgjyItem();
					Iterator xmname = itemEle.elementIterator("xmname");
					if (xmname.hasNext()) {
						Element _xmname = (Element) xmname.next();
						item.pid = URLDecoder_Str(_xmname.elementText("pid"));
						item.msg = URLDecoder_Str(_xmname.elementText("msg"));
					}
					// 解析项目
					item.items = new ArrayList<RgjyItem.Item>();
					Iterator cylist = itemEle.elementIterator("wjlist");
					if (!cylist.hasNext()) {
						item.pid = null;
						item.msg = null;
					}
					while (cylist.hasNext()) {
						Element _cylist = (Element) cylist.next();
						RgjyItem.Item _item = item.new Item();
						_item.pid = URLDecoder_Str(_cylist.elementText("pid"));
						_item.id = URLDecoder_Str(_cylist.elementText("code"));
						_item.name = URLDecoder_Str(_cylist.elementText("name"));
						_item.code = URLDecoder_Str(_cylist.elementText("id"));
						_item.property = URLDecoder_Str(_cylist
								.elementText("property"));
						item.items.add(_item);
					}
					result.add(item);
				}
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	private static String URLDecoder_Str(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}
}

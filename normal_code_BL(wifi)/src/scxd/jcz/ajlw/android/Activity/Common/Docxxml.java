package scxd.jcz.ajlw.android.Activity.Common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import android.content.Context;
/**
 * xml解析工具类
 * @author Administrator
 *
 */
public class Docxxml {
	static Map<String, String> map=null;
	public static Map<String, String> xmlread(Context con)
	{
		 map=new HashMap<String, String>();
		try {
		InputStream is = con.getResources().getAssets().open("wz.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse(is);
		//通过标签名字获取元素列表
		NodeList nodeList = document.getElementsByTagName("zt");
		for(int i = 0 ; i < nodeList.getLength() ;i++){
			//获取指定下标的节点
			Node node = nodeList.item(i);
//			Element ele = (Element)node;
			NodeList childList = node.getChildNodes();
			for(int j = 0 ; j < childList.getLength() ; j++){
				Node childNode = childList.item(j);
				String name = childNode.getNodeName();
				//获取的文本节点或者注释节点的值
				String value =  childNode.getTextContent();
				map.put(name, value);
				//获取元素的值
//				String textContent = childNode.getTextContent();
			}
		}
		} catch (Exception e) {
			return null;
		}
		return map;
	}
}

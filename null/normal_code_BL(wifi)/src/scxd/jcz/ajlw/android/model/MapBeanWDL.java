package scxd.jcz.ajlw.android.model;

import java.io.Serializable;
import java.util.Map;


/**
 * δ��¼�����ݽ�Map��װ��Beanͨ��inten����
 * @author CXY
 *
 */
public class MapBeanWDL implements Serializable {

	
  private Map<String, String> wdlMap;

public Map<String, String> getWdlMap() {
	return wdlMap;
}

public void setWdlMap(Map<String, String> wdlMap) {
	this.wdlMap = wdlMap;
}

public MapBeanWDL(Map<String, String> wdlMap) {
	super();
	this.wdlMap = wdlMap;
}
  
public MapBeanWDL()
{
	super();
}
	
	
}

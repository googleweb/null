package scxd.jcz.ajlw.android.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 存储下拉列表数据
 * @author xxy
 *
 */
@DatabaseTable
public class Md_cartype {

	/** 主鍵ID **/
	@DatabaseField(generatedId = true)
	private int ID;
	
	//名称
	@DatabaseField
	public String name="";
	//值
	@DatabaseField
	public String value="";
	
	/**
	 * 构造方法初始化数据
	 * @param name
	 * @param value
	 */
	public Md_cartype(String name,String value){
		this.setName(name);
		this.setValue(value);
	}
	
	
	public Md_cartype() {
		super();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}
	/**
	 *返回name
	 * @return 
	 */
	public String getName() {
		return name;
	}
	/**
	 *设置name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 *返回value
	 * @return 
	 */
	public String getValue() {
		return value;
	}
	/**
	 *设置value
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}

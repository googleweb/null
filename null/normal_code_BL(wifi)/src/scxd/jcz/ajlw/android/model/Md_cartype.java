package scxd.jcz.ajlw.android.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * �洢�����б�����
 * @author xxy
 *
 */
@DatabaseTable
public class Md_cartype {

	/** ���IID **/
	@DatabaseField(generatedId = true)
	private int ID;
	
	//����
	@DatabaseField
	public String name="";
	//ֵ
	@DatabaseField
	public String value="";
	
	/**
	 * ���췽����ʼ������
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
	 *����name
	 * @return 
	 */
	public String getName() {
		return name;
	}
	/**
	 *����name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 *����value
	 * @return 
	 */
	public String getValue() {
		return value;
	}
	/**
	 *����value
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}

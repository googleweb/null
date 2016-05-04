package scxd.jcz.ajlw.android.model;

/**
 * 外检拍照项目实体
 * @author xxy
 *
 */
public class MD_Xml_Wjxm {

	//返回信息描述
	public String message;
	//返回code代码 0:成功 1:失败 $E:异常信息
	public String code;
	//流水号
	public String jclsh;
	//项目名称
	public String name;
	//项目编号
	public String wjcode;
	//项目id
	public String id;
	//否决项
	public String property="0";
	
	/**
	 * 构造方法-赋初值
	 * @param message 返回信息描述
	 * @param code 代码 0:成功 1:失败 $E:异常信息
	 * @param jclsh 流水号
	 * @param name 项目名称
	 * @param wjcode 项目编号
	 */
	public   MD_Xml_Wjxm(String message,String code,String jclsh,String name,String wjcode,String id,String property) {
		this.code=code;
		this.jclsh=jclsh;
		this.message = message;
		this.name= name;
		this.wjcode = wjcode;
		this.id = id;
		this.property=property;
	}
}

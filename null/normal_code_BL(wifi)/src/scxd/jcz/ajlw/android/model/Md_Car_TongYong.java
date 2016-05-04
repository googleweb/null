package scxd.jcz.ajlw.android.model;

/**
 * 01Q12接口实体类
 * @author xxy
 *
 */
public class Md_Car_TongYong {
	/**
	 *返回code
	 * @return 
	 */
	public String getCode() {
		return code;
	}
	/**
	 *设置code
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 *返回message
	 * @return 
	 */
	public String getMessage() {
		return message;
	}
	/**
	 *设置message
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	//返回的code
	public String code;
	//返回的已拍照的项目编号
	public String message;
	
	/**
	 * 构造方法
	 * @param code 接收返回的code
	 * @param message 接收返回的已拍照Id
	 */
	public Md_Car_TongYong(String code,String message){
		
		this.code = code;
		this.message = message;
		
	}

}

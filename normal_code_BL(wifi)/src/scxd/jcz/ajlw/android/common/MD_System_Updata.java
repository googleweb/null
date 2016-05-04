package scxd.jcz.ajlw.android.common;
/**
 * 系统升级帮助类
 * @author Administrator
 *
 */
public class MD_System_Updata {
	
	/**
	 *返回version
	 * @return 
	 */
	public String getVersion() {
		return version;
	}
	/**
	 *设置version
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
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
	/**
	 *返回apkmsg
	 * @return 
	 */
	public String getApkmsg() {
		return apkmsg;
	}
	/**
	 *设置apkmsg
	 * @param apkmsg the apkmsg to set
	 */
	public void setApkmsg(String apkmsg) {
		this.apkmsg = apkmsg;
	}
	/**
	 * 版本号
	 */
	public String version="";
	/**
	 * 返回的信息码
	 */
	public String code="";
	/**
	 * 返回的详细信息
	 */
	public String message="";
	/**
	 * apk包内容
	 */
	public String apkmsg="";
	
	
	

}

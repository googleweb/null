package scxd.jcz.ajlw.android.model;

/**
 * 01Q12�ӿ�ʵ����
 * @author xxy
 *
 */
public class Md_Car_TongYong {
	/**
	 *����code
	 * @return 
	 */
	public String getCode() {
		return code;
	}
	/**
	 *����code
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 *����message
	 * @return 
	 */
	public String getMessage() {
		return message;
	}
	/**
	 *����message
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	//���ص�code
	public String code;
	//���ص������յ���Ŀ���
	public String message;
	
	/**
	 * ���췽��
	 * @param code ���շ��ص�code
	 * @param message ���շ��ص�������Id
	 */
	public Md_Car_TongYong(String code,String message){
		
		this.code = code;
		this.message = message;
		
	}

}

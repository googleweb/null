package scxd.jcz.ajlw.android.Activity.Common;
/**
 * ϵͳ������ʾ��
 * @author Administrator
 *
 */
public class ErrorHelper {
	public static final int NET_ERROR=4;//�����쳣����������
	public static final int REQUEST_DATA_ERROR=3;//�������ݴ����������ݣ�
	public static final int SYSTEM_WORKING_ERROR=2;//ϵͳ��æ�������ԣ�
	public static final int REQUEST_OUTTIME_ERROR=5;//����ʱ��ʱ
	public static final int RUNTIMEEXCEPTION_ERROR=6;//�����쳣�������ԣ�
	public static final int GETXML_ERROR=7;//���������쳣��
   public static String localErrorInfo(int error){
		switch (error) {
		case NET_ERROR:
			return "�����쳣���������磡";
		case REQUEST_DATA_ERROR:
			return "�������ݴ����������ݣ�";
		case SYSTEM_WORKING_ERROR: 
			return "ϵͳ��æ��������!";
		case REQUEST_OUTTIME_ERROR: 
			return "����ʱ��ʱ!";
		case RUNTIMEEXCEPTION_ERROR: 
			return "�����쳣��������!";
		default:
			return "�������ݴ����������ݣ�";
		}
	}
}

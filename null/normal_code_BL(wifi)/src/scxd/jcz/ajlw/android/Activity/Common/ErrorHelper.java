package scxd.jcz.ajlw.android.Activity.Common;
/**
 * 系统错误提示类
 * @author Administrator
 *
 */
public class ErrorHelper {
	public static final int NET_ERROR=4;//网络异常，请检查网络
	public static final int REQUEST_DATA_ERROR=3;//请求数据错误，请检查数据！
	public static final int SYSTEM_WORKING_ERROR=2;//系统繁忙，请重试！
	public static final int REQUEST_OUTTIME_ERROR=5;//请求超时超时
	public static final int RUNTIMEEXCEPTION_ERROR=6;//运行异常，请重试！
	public static final int GETXML_ERROR=7;//解析数据异常！
   public static String localErrorInfo(int error){
		switch (error) {
		case NET_ERROR:
			return "网络异常，请检查网络！";
		case REQUEST_DATA_ERROR:
			return "请求数据错误，请检查数据！";
		case SYSTEM_WORKING_ERROR: 
			return "系统繁忙，请重试!";
		case REQUEST_OUTTIME_ERROR: 
			return "请求超时超时!";
		case RUNTIMEEXCEPTION_ERROR: 
			return "运行异常，请重试!";
		default:
			return "请求数据错误，请检查数据！";
		}
	}
}

package scxd.jcz.ajlw.android.Application;

import android.app.Application;
import android.view.WindowManager;
/**
 * @author CXY
 * ����ȫ�ֱ��� ȫ�ֱ���һ�㶼�Ƚ������ڴ���һ���������������ļ�����ʹ��static��̬����
 * ����ʹ������Application��������ݵķ���ʵ��ȫ�ֱ���
 * ע����AndroidManifest.xml�е�Application�ڵ����android:name=".MyApplication"����
 */
public class MyApplication extends Application {

	public static boolean ISMVIEWNULL=false;
	private static MyApplication sAppContext = null;
	/**
	 * �ڹ�����Ϣ���������жϽ���
	 */
	public static boolean ISLOGIN=true;

	public static int  tableindex=0;
	private WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();

	public WindowManager.LayoutParams getMywmParams() {
		return wmParams;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		sAppContext = this;
	}
	
	public static MyApplication getAppContext() {
		return sAppContext;
	}
}

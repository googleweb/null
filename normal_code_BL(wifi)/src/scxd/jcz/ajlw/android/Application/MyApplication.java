package scxd.jcz.ajlw.android.Application;

import android.app.Application;
import android.view.WindowManager;
/**
 * @author CXY
 * 创建全局变量 全局变量一般都比较倾向于创建一个单独的数据类文件，并使用static静态变量
 * 这里使用了在Application中添加数据的方法实现全局变量
 * 注意在AndroidManifest.xml中的Application节点添加android:name=".MyApplication"属性
 */
public class MyApplication extends Application {

	public static boolean ISMVIEWNULL=false;
	private static MyApplication sAppContext = null;
	/**
	 * 在公告信息界面用作判断界面
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

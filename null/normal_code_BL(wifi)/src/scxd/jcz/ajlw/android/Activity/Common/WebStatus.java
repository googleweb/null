package scxd.jcz.ajlw.android.Activity.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/**
 * 判断网络连接状态类
 * @author Administrator
 *@createtime
 *
 */
public class WebStatus {
	/**
	 * 是否连接网络
	 * @param context
	 * @return 0手机流量：1wifi;2其他；-1无网络连接
	 */
	public static int isConnect(Context context) {
        // 获取连接管理器
        ConnectivityManager mConnect = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // 创建一个网络信息对象
        NetworkInfo mNetInfo = mConnect.getActiveNetworkInfo();
        if (mNetInfo != null && mNetInfo.isAvailable()) {
            int netType = mNetInfo.getType();
            if (netType == ConnectivityManager.TYPE_MOBILE) {
                return 0;
            } else if (netType == ConnectivityManager.TYPE_WIFI) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return -1;
        }
        
	}
}

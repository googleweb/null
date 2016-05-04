package scxd.jcz.ajlw.android.Activity.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/**
 * �ж���������״̬��
 * @author Administrator
 *@createtime
 *
 */
public class WebStatus {
	/**
	 * �Ƿ���������
	 * @param context
	 * @return 0�ֻ�������1wifi;2������-1����������
	 */
	public static int isConnect(Context context) {
        // ��ȡ���ӹ�����
        ConnectivityManager mConnect = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // ����һ��������Ϣ����
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

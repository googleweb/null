package scxd.jcz.ajlw.android.Activity.Common;
/**
 * @function �ж���ť�Ƿ��ε��
 * @author chenpan
 * @creattime 2015-6-20 
 */
public class ButtonTools {
    private static long lastClickTime;
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();   
        if ( time - lastClickTime < 500) {   
            return true;   
        }   
        lastClickTime = time;   
        return false;   
    }
}
package scxd.jcz.ajlw.android.Activity.Common;
/**
 * @function 判读按钮是否多次点击
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
package scxd.jcz.ajlw.android.Activity.Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import android.content.Context;
import android.content.Intent;
/**
 * 时间处理工具类
 * @author Administrator
 *@createtime 
 */
public class CommonUtils {
	public static long timeInterval = 0;
	public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

	// dateTime yyyyMMddHHmmss
	public static long parseDateTime(String dateTimeString) {
		long dateTime = -1L;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			dateTime = sdf.parse(dateTimeString).getTime();
		} catch (ParseException e) {
			e.printStackTrace();

		}
		return dateTime;
	}

	public static long parseDateTime(String dateTimeString, String pattern) {
		long dateTime = -1L;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			dateTime = sdf.parse(dateTimeString).getTime();
		} catch (ParseException e) {
			e.printStackTrace();

		}
		return dateTime;
	}

	public static void setSystemDateTime(Context context, String formateDatetime) {
		if (formateDatetime != null
				&& formateDatetime.length() == CommonUtils.FORMAT_TIME.length()) {
			try {
				long datetime = CommonUtils.parseDateTime(formateDatetime,
						CommonUtils.FORMAT_TIME);
				Intent intent = new Intent("android.intent.action.SET_DATETIME");
				intent.putExtra("datetime", datetime);
				context.sendBroadcast(intent);
				timeInterval = datetime - System.currentTimeMillis();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

/** 
 * 转义正则特殊字符 （$()*+.[]?\^{},|） 
 *  
 * @param keyword 
 * @return 
 */  
public static String escapeExprSpecialWord(String keyword) {  
    if (keyword!=null&&!"".equals(keyword)) {  
       /* String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" ,"","└"};  */
    	 String[] fbsArr = { ""+(char)3,"└"};
        for (String key : fbsArr) {  
            if (keyword.contains(key)) {  
                keyword = keyword.replace(key, "");  
            }  
        }  
    }  
    System.out.println(""+(char)3);
    return keyword;  
}  

}

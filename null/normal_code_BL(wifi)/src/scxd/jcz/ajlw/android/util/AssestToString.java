/**
 * @�ļ�����AssestToString.java
 * @author Administrator user=chenpan
 * @��������  2015-10-22
 * @����������
 */
package scxd.jcz.ajlw.android.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.util.EncodingUtils;

import android.content.Context;

/**
 * @���� :AssestToString.java
 * @author Administrator
 * @��������:
 * @����ʱ��:2015-10-22
 */
public class AssestToString {

	public static String xmltoString(Context context, String stringName) {
		InputStream xml=null;
		String result =null;
		try {
			xml = context.getResources().getAssets().open(stringName);

			int length = xml.available();// ��ȡ��������
			byte[] buffer = new byte[length];
			xml.read(buffer);// ����������
			// ���ñ���
			 result = EncodingUtils.getString(buffer, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}

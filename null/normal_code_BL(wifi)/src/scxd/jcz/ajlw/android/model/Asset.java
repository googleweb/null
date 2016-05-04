package scxd.jcz.ajlw.android.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import android.content.Context;
import android.widget.LinearLayout;
/**
 * 
 * @author gbh
 * Create Time��
 * Description����ȡ����XMl����
 */
public class Asset {
	private static String ss=""; //��ʱ��Ų�������
	/**
	 * ��ȡ����XMl����
	 * @param c
	 * @param s
	 * @return
	 */
	public static String getAsset(Context c,String s) {
		ss=s;
		String str = "";
		byte[] bf = new byte[1024];
		int length = 0;
		InputStream fin = null;
		try {
			fin = c.getAssets().open(s) ;
			while((length = fin.read(bf)) != -1){
				str += new String(bf, 0, length) ;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fin != null){
					fin.close() ;
				}
			} catch (IOException ee) { }
		}
		return str;
	}
}

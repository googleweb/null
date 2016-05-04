package scxd.jcz.ajlw.android.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/**
 * �Ի��򹤾���
 * @author Administrator
 *@createtime
 */
public class PromptUtils {

	private static AlertDialog sAlertDialog;
/**
 * 
 * @param context ������
 * @param title ����
 * @param popView �����ļ�
 * @param msg ��Ϣ����
 * @param leftName ��ť����
 * @param negativeListener �¼�
 * @throws 
 * @throw
 */
	public static void showAlertDialog(Context context, String title,
			View popView, String msg, String leftName,
			final DialogInterface.OnClickListener negativeListener) {

		try {
			closeAlertDialog();
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			// builder.setIcon(drawable);
			builder.setTitle(title);
			builder.setCancelable(false);
			builder.setView(popView);
			builder.setMessage(msg);
			builder.setNegativeButton(leftName, negativeListener);
			builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
				@Override
				public void onCancel(DialogInterface dialog) {
					closeAlertDialog();
				}
			});
			sAlertDialog = builder.create();
			sAlertDialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/**
 * 
 * @param context ������this
 * @param drawable ��Դ�ļ�id
 * @param title �ļ�����
 * @param popView �����ļ�
 * @param msg ��ʾ����
 * @throws 
 * @throw
 */
	public static void showAlertDialog(Context context, int drawable,
			String title, View popView, String msg) {

		try {
			closeAlertDialog();
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setIcon(drawable);
			builder.setTitle(title);
			builder.setCancelable(false);
			builder.setView(popView);
			builder.setMessage(msg);
			sAlertDialog = builder.create();
			sAlertDialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/**
 * �ر���ʾ��
 * 
 * @throws 
 * @throw
 */
	public static void closeAlertDialog() {
		if (sAlertDialog != null) {
			sAlertDialog.dismiss();
			sAlertDialog = null;
		}
	}
}

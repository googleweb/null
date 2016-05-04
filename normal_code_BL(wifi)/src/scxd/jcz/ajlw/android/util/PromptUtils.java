package scxd.jcz.ajlw.android.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/**
 * 对话框工具类
 * @author Administrator
 *@createtime
 */
public class PromptUtils {

	private static AlertDialog sAlertDialog;
/**
 * 
 * @param context 上下文
 * @param title 标题
 * @param popView 布局文件
 * @param msg 消息类容
 * @param leftName 左按钮名称
 * @param negativeListener 事件
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
 * @param context 上下文this
 * @param drawable 资源文件id
 * @param title 文件标题
 * @param popView 布局文件
 * @param msg 提示内容
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
 * 关闭提示框
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

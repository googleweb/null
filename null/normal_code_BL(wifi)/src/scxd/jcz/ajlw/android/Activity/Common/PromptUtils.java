/**
 * File Name:PromptUtils.java
 */

package scxd.jcz.ajlw.android.Activity.Common;

import java.util.Timer;
import java.util.TimerTask;

import scxd.jcz.ajlw.android.Activity.R;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * 对话框工具类
 * @author Administrator
 * @createtime 
 */
public class PromptUtils {
	private static PromptUtils sIntance;
	private static AlertDialog sAlertDialog;
	private static ProgressDialog sProgressDialog;
	private static ProgressDialog sProgressBarDialog;
	private static Timer sTimer;
	private Context mContext;

	private PromptUtils() {

	}

	public static PromptUtils getInstance() {
		if (sIntance == null) {
			sIntance = new PromptUtils();
		}
		return sIntance;
	}

	public void setContext(Context context) {
		this.mContext = context;
	}

	public void showPrompts(int textResId) {
		showPrompts(mContext.getString(textResId));
	}

	public void showPrompts(String msg) {
		showAlertDialog(mContext, msg, null);
	}

	public void showPrompts(int textResId,
			DialogInterface.OnClickListener listener) {
		showPrompts(mContext.getString(textResId), listener);
	}

	public void showPrompts(String msg, DialogInterface.OnClickListener listener) {
		showAlertDialog(mContext, msg, listener);
	}

	public void closePrompt() {
		closeAlertDialog();
	}

	public static void closeAlertDialog() {
		if (sAlertDialog != null) {
			sAlertDialog.dismiss();
			sAlertDialog = null;
		}
	}

	public static void showAlertDialog(Context context, int textResId,
			final DialogInterface.OnClickListener positiveListener) {
		showAlertDialog(context, context.getString(textResId), positiveListener);
	}

	public static void showAlertDialog(Context context, String msg,
			final DialogInterface.OnClickListener positiveListener) {
		try {
			closeAlertDialog();
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setIcon(R.drawable.query_dialog_icon);
			builder.setTitle(R.string.prompt);
			builder.setMessage(msg);
			builder.setPositiveButton(R.string.prompt_ok, positiveListener);
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

	public static void showAlertDialog(Context context, int textResId,
			final DialogInterface.OnClickListener positiveListener,
			final DialogInterface.OnClickListener negativeListener) {
		showAlertDialog(context, context.getString(textResId),
				positiveListener, negativeListener);
	}

	public static void showAlertDialog(Context context, String msg,
			final DialogInterface.OnClickListener positiveListener,
			final DialogInterface.OnClickListener negativeListener) {
		try {
			closeAlertDialog();
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setIcon(R.drawable.query_dialog_icon);
			builder.setTitle(R.string.prompt);
			builder.setMessage(msg);
			builder.setPositiveButton(R.string.prompt_ok, positiveListener);
			builder.setNegativeButton(R.string.prompt_cancel, negativeListener);
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
	 * 鑷畾涔夊璇濇
	 * 
	 * @param context
	 * @param drawable
	 * @param title
	 * @param popView
	 * @param msg
	 * @param leftName
	 * @param rightName
	 * @param positiveListener
	 * @param negativeListener
	 */
	public static void showAlertDialog(Context context, int drawable,
			String title, View popView, String msg, String leftName,
			String rightName,
			final DialogInterface.OnClickListener positiveListener,
			final DialogInterface.OnClickListener negativeListener) {

		try {
			closeAlertDialog();
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setIcon(drawable);
			builder.setTitle(title);
			builder.setCancelable(false);
			builder.setView(popView);
			builder.setMessage(msg);
			builder.setPositiveButton(leftName, positiveListener);
			builder.setNegativeButton(rightName, negativeListener);
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

	public static void showAlertDialog(Context context, int drawable,
			String title, View popView, String msg, String leftName,
			final DialogInterface.OnClickListener negativeListener) {

		try {
			closeAlertDialog();
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setIcon(drawable);
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
	 * 璇锋眰ProgressDialog
	 * 
	 * @param context
	 * @param msgId
	 */
	public static void showProgressDialog(Context context, int msgId) {
		showProgressDialog(context, context.getString(msgId));
	}

	public static void showProgressDialog(Context context, String msg) {
		showProgressDialog(context, msg, -1);
	}

	public static void showProgressDialog(Context context, int msgId,
			long maxWaitTime) {
		showProgressDialog(context, context.getString(msgId), maxWaitTime);
	}

	public static void showProgressDialog(Context context, String msg,
			long maxWaitTime) {
		try {
			closeProgressDialog();
			sProgressDialog = ProgressDialog.show(context,
					context.getString(R.string.prompt), msg, false, false);

			if (maxWaitTime > 1000) {
				sTimer = new Timer();
				sTimer.schedule(new TimerTask() {
					@Override
					public void run() {
						closeProgressDialog();
					}
				}, maxWaitTime);
			}
		} catch (Exception e) {
		}
	}

	public static void setProgressMsg(String msg) {
		if (sProgressDialog != null) {
			sProgressDialog.setMessage(msg);
		}
	}

	public static void setProgressMsg(Context context, int textResId) {
		if (sProgressDialog != null) {
			sProgressDialog.setMessage(context.getString(textResId));
		}
	}

	public static void closeProgressDialog() {
		try {
			if (sProgressDialog != null) {
				sProgressDialog.dismiss();
				sProgressDialog = null;
			}
		} catch (Exception e) {
		}

		try {
			if (sTimer != null) {
				sTimer.cancel();
				sTimer = null;
			}
		} catch (Exception e) {
		}
	}

	public static boolean isProgressDialogShowing() {
		return sProgressDialog != null;
	}

	/**
	 * 杩涘害鏉?
	 * 
	 * @param context
	 * @param drawable
	 * @param title
	 * @param popView
	 * @param msg
	 * @param leftName
	 * @param rightName
	 * @param positiveListener
	 * @param negativeListener
	 */
	public static void showProgressBarDialog(Context context, int drawable,
			String title, String msg, String leftName, String rightName,
			final DialogInterface.OnClickListener positiveListener,
			final DialogInterface.OnClickListener negativeListener) {
		try {
			closeProgressDialog();
			sProgressBarDialog = new ProgressDialog(context);
			sProgressBarDialog
					.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			sProgressBarDialog.setTitle(title);
			sProgressBarDialog.setMessage(msg);
			sProgressBarDialog.setIcon(drawable);
			sProgressBarDialog.setProgress(0);
			sProgressBarDialog.setMax(100);
			sProgressBarDialog.setIndeterminate(false);
			sProgressBarDialog.setCancelable(false);
			sProgressBarDialog.setButton(leftName, negativeListener);
			sProgressBarDialog.setButton2(rightName, positiveListener);
			sProgressBarDialog
					.setOnCancelListener(new DialogInterface.OnCancelListener() {
						@Override
						public void onCancel(DialogInterface dialog) {
							closeProgressBarDialog();
						}
					});
			sProgressBarDialog.show();
		} catch (Exception e) {
		}
	}

	public static void setProgressBarDialogValue(int value) {
		try {
			if (sProgressBarDialog != null) {
				sProgressBarDialog.setProgress(value);
			}
		} catch (Exception e) {
		}
	}

	public static int getProgressBarDialogValue() {
		if (sProgressBarDialog != null) {
			return sProgressBarDialog.getProgress();
		}
		return 0;
	}

	public static void closeProgressBarDialog() {
		try {
			if (sProgressBarDialog != null) {
				sProgressBarDialog.dismiss();
				sProgressBarDialog = null;
			}
		} catch (Exception e) {
		}
	}
}

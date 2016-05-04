package scxd.jcz.ajlw.android.Activity.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Login_Activity;
import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * 基础类，实现访问网络，获取数据
 * 
 * @author Administrator
 * @time
 */
public abstract class BaseActivity extends Activity {
	/**
	 * 访问网络类
	 * 
	 * @author Administrator
	 * 
	 */
	public class WebTask extends AsyncTask<Void, Void, Object> {

		public String jkid;
		public Object jkdata;
		public String method;

		@Override
		protected Object doInBackground(Void... params) {
			try {
				String webResult = "";
				webResult = webservice_call
						.postRequest((String) jkdata, method);

				LogWriter.open().appendMethodB("reponseData" + jkid,
						BaseActivity.class, webResult);
				if (webResult == null || "".equals(webResult)
						|| "$EE".equals(webResult)) {
					if (!jkid.equals("18Q49") && !jkid.equals("18C49")) {
						return R.string.RUNTIMEEXCEPTION_ERROR;
					} else {
						return ResponseFactory.getInstance().decode(jkid, "");
					}
				} else {
					return ResponseFactory.getInstance()
							.decode(jkid, webResult);
				}
			} catch (Exception e) {
				return R.string.RUNTIMEEXCEPTION_ERROR;
			}
		}

		protected void onPostExecute(Object result) {
			webTask = null;
			if (result instanceof Integer) {
				getDefaultDialog().dimiss();
				if (jkid.equals("18C63")) {
					List<Md_Car_TongYong> callKS = new ArrayList<Md_Car_TongYong>();
					callKS.add(new Md_Car_TongYong("5", "网络异常，请检查网络!"));
					BaseActivity.this.onRequestSuccess(jkid, callKS);
				} else {
					Toast.makeText(BaseActivity.this, "数据请求失败，请重试！", 1000)
							.show();
				}
			} else {
				getDefaultDialog().dimiss();
				BaseActivity.this.onRequestSuccess(jkid, result);
			}
		}
	}

	private WebTask webTask;
	private static long lastClickTime;
	private RequestStatusDialog dialog;

	// 记录时间
	public synchronized static boolean isFastClick() {
		long time = System.currentTimeMillis();
		if (time - lastClickTime < 30000) {
			return true;
		}
		lastClickTime = time;
		return false;
	}

	private RequestStatusDialog getDefaultDialog() {
		if (dialog == null) {
			dialog = new RequestStatusDialog(BaseActivity.this,
					new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							try {
								if (!isFastClick()) {
									getDefaultDialog().dimiss();
									webTask.cancel(true);
									if (webTask.jkid.equals("18C63")
											|| webTask.jkid.equals("18C51")) {
										List<Md_Car_TongYong> callKS = new ArrayList<Md_Car_TongYong>();
										callKS.add(new Md_Car_TongYong("5",
												"网络异常，请检查网络!"));
										BaseActivity.this.onRequestSuccess(
												webTask.jkid, callKS);
									} else {
										Toast.makeText(BaseActivity.this,
												"数据请求失败，请重试！", 1000).show();
									}
								} else {
									Toast.makeText(BaseActivity.this,
											"数据请求中，等待30秒再取消重传",
											Toast.LENGTH_SHORT).show();

								}

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
		}
		return dialog;
	}

	protected void onDestroy() {

		if (dialog != null) {
			dialog.dismiss();
			dialog = null;
		}
		if (webTask != null) {
			webTask.cancel(true);
			webTask = null;
		}
		super.onDestroy();
	}

	public void request(String jkid, Map<String, Object> values,
			int REQUEST_DIALOG_MESSAGE_ID, String... params) {
		int error = doRequest(jkid, values, params);
		if (error == R.string.REQUEST_DATA_RIGHT) {
			if (REQUEST_DIALOG_MESSAGE_ID != 0) {
				getDefaultDialog().showprogressdialog(R.string.SYS_TITLE,
						REQUEST_DIALOG_MESSAGE_ID);
				isFastClick();
			}
		} else {
			if (jkid.equals("18C63")) {
				List<Md_Car_TongYong> callKS = new ArrayList<Md_Car_TongYong>();
				callKS.add(new Md_Car_TongYong("5", "网络异常，请检查网络!"));
				BaseActivity.this.onRequestSuccess(jkid, callKS);
			} else {
				Toast.makeText(BaseActivity.this, "数据请求失败，请重试！", 1000).show();
			}
		}

	}

	public void request(String jkid, Map<String, Object> values,
			String message, String... params) {
		int error = doRequest(jkid, values, params);
		if (error == R.string.REQUEST_DATA_RIGHT) {
			if (!message.equals("")) {
				getDefaultDialog().showprogressdialog(R.string.SYS_TITLE,
						message);
				isFastClick();
			}
		} else {
			if (jkid.equals("18C63")) {
				List<Md_Car_TongYong> callKS = new ArrayList<Md_Car_TongYong>();
				callKS.add(new Md_Car_TongYong("5", "网络异常，请检查网络!"));
				BaseActivity.this.onRequestSuccess(jkid, callKS);
			} else {
				Toast.makeText(BaseActivity.this, "数据请求失败，请重试！", 1000).show();
			}
		}

	}

	private int doRequest(String jkid, Map<String, Object> values,
			String... params) {
		if (webTask != null) {
			webTask.cancel(true);
			webTask = null;
		}
		if (WebStatus.isConnect(BaseActivity.this) == 1
				|| WebStatus.isConnect(BaseActivity.this) == 0) {
			Object data = RequestXMLFactory.getInstance().create(jkid, values,
					params);
			if (data instanceof Integer) {
				return R.string.REQUEST_DATA_ERROR;// 请求数据错误，请检查数据
			}
			webTask = new WebTask();
			webTask.jkid = jkid;
			webTask.jkdata = data;

			if (params[0].equals("2")) {
				webTask.method = "queryObjectOut";
			} else if (params[0].equals("1")) {
				webTask.method = "writeObjectOut";
			}

			webTask.execute();
		} else {
			return R.string.NET_ERROR; // 网络连接失败，请检查网络
		}
		return R.string.REQUEST_DATA_RIGHT; // 请求数据格式正确
	}

	/**
	 * 请求网络活的返回数据，根据数据作出响应
	 * 
	 * @param jkid
	 *            条件码或者请求码
	 * @param result
	 *            返回的数据
	 * @author gbh
	 */
	public abstract void onRequestSuccess(String jkid, Object result);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		service2 = new Intent();
		service2.setAction("scxd.jcz.ajlw.android.service.SingleService");
		registerBoradcastReceiverforsingle();
	}

	public void registerBoradcastReceiverforsingle() {
		IntentFilter myIntentFilter = new IntentFilter();
		myIntentFilter.addAction("SINGLE_NAME");
		// 注册广播
		registerReceiver(mBroadcastReceiverforsingle, myIntentFilter);
	}

	public void starService() {

		service2.putExtra("exit", false);
		this.startService(service2);
	}

	public void stopService() {
		service2.putExtra("exit", true);
		try {
			stopService(service2);
		} catch (Exception e) {

		}
	}

	private BroadcastReceiver mBroadcastReceiverforsingle = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals("SINGLE_NAME")) {
				if (intent.getStringExtra("signle").equals("0")) {// 处理广播
					Toast.makeText(BaseActivity.this,
							"当前账号已在其它设备上登陆，如果不是本人操作，请登录后及时修改密码！", 1).show();
					Intent intent2 = new Intent(BaseActivity.this,
							Login_Activity.class);
					stopService();
					startActivity(intent2);
					// unregisterReceiver(mBroadcastReceiverforsingle);
					finish();
				} else {

				}
			}
		}
	};
	private Intent service2;
	/**
	 * 通过类名启动Activity
	 * 
	 * @param pClass
	 */
	public void openActivity(Class<?> pClass) {
		openActivity(pClass, null);
	}

	/**
	 * 通过类名启动Activity，并且含有Bundle数据
	 * 
	 * @param pClass
	 * @param pBundle
	 */
	public void openActivity(Class<?> pClass, Bundle pBundle) {
		Intent intent = new Intent(this, pClass);
		if (pBundle != null) {
			intent.putExtras(pBundle);
		}
		startActivity(intent);
	}
}

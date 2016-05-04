package scxd.jcz.ajlw.android.Activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.model.Md_system;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 系统升级
 * @author Administrator
 * @time
 */
public class System_Updata_Activity extends BaseActivity {

	public static final String PHONE_PATH = Environment
			.getExternalStorageDirectory().getAbsolutePath() + File.separator;
	private String updateUrl = "";
	private String version = "";
	private TextView txtView_sj;
	private TextView textView_version;
	private TextView textview_msg;
	private Button btu_qr;
	private ProgressBar progressBar_jd;
	private boolean isAsycn = true;
	private int length = 0;
	private NotificationManager nManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.system_updata);
		getIntentData();
		if (nManager == null) {
			nManager = (NotificationManager) this
					.getSystemService(NOTIFICATION_SERVICE);
		}
		init();
	}
/**
 * 通知栏显示
 */
	public void showNotification() {
		Notification notification = new Notification(R.drawable.xxqc,
				"恭喜你，机动车移动检验系统升级成功！", System.currentTimeMillis());
		notification.defaults = Notification.DEFAULT_SOUND
				| Notification.DEFAULT_VIBRATE;
		Intent notificationIntent = new Intent(System_Updata_Activity.this,
				Login_Activity.class);
		// 点击该通知后要跳转的Activity
		PendingIntent contentItent = PendingIntent.getActivity(this, 0,
				notificationIntent, 0);
		notification.setLatestEventInfo(this, "提示：", "恭喜你，机动车移动检验系统升级成功！",
				contentItent);
		nManager.notify(0, notification);
	}

	private void getIntentData() {
		Intent i = this.getIntent();
		updateUrl = i.getStringExtra("URL");
		version = i.getStringExtra("VERSION");
	}

	public void init() {
		txtView_sj = (TextView) findViewById(R.id.textView_sj);
		textView_version = (TextView) findViewById(R.id.textView_version);
		progressBar_jd = (ProgressBar) findViewById(R.id.progressBar_jd);
		btu_qr = (Button) findViewById(R.id.btu_sj);
		textview_msg = (TextView) findViewById(R.id.textview_msg);
		textView_version.setText("发现服务器上有新版本，请点击按钮下载新的安装包!");
		btu_qr.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				new OnLoadData_Updata().execute("");
			}
		});
	}
/**
 * 异步下载安装包
 * @author Administrator
 *
 */
	class OnLoadData_Updata extends AsyncTask<String, Integer, Integer> {

		@Override
		protected void onPostExecute(Integer msu) {
			super.onPostExecute(msu);
			isAsycn = true;
			switch (msu) {
			case 1:
				txtView_sj.setText("安装包下载成功!");
				dialog("提示：", "安装包下载成功，版本号为：" + version + ",点击确定进行安装!", 1);
				break;
			case 0:
				dialog("提示：", "安装包下载失败，请重试!", 0);
				break;
			case 2:
				Toast.makeText(System_Updata_Activity.this,
						"安装包下载异常，请重新启动软件再进行操作!", 2000).show();
				break;

			}

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			textview_msg.setVisibility(0);
			float fileLength = ((float) length / 1024 / 1024);
			textview_msg.setText("文件大小:"
					+ (float) (Math.round(fileLength * 100)) / 100 + "M  完成:"
					+ values[0] + "%");
			btu_qr.setEnabled(false);
			txtView_sj.setVisibility(0);
			progressBar_jd.setVisibility(0);
			progressBar_jd.setProgress(values[0]);
			super.onProgressUpdate(values);
		}

		@Override
		protected Integer doInBackground(String... arg0) {
			isAsycn = false;
			try {
				deleteApk(Md_system.getVersion());
				URL url = new URL(updateUrl);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				conn.setDoInput(true);
				conn.connect();
				int c=conn.getResponseCode();
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)

				{
					InputStream is = conn.getInputStream();
					File file = new File(PHONE_PATH
							+ "jclwjcz/apk/jcz_pda_ajlw_" + version + ".apk");
					if (!file.exists()) {
						File file2 = new File(file.getParent());
						file2.mkdir();
					}
					if (!file.exists()) {
						file.createNewFile();
					}
					FileOutputStream fos = new FileOutputStream(file);
					length = conn.getContentLength();
					byte[] bt = new byte[1024];
					int count = 0;
					int updataJD = 0;
					int i = 0;
					while ((i = is.read(bt)) > 0) {
						count += i;
						updataJD = (int) (((float) count / length) * 100);
						publishProgress(updataJD);
						fos.write(bt, 0, i);
					}
					fos.flush();
					fos.close();
					is.close();
					publishProgress(100);
					return 1;
				} else {
					return 0;
				}
			} catch (Exception e) {
				return 2;
			}
		}

	}

	/**
	 * 监听平板返回按键按下事件
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == 4) {
			if (isAsycn) {
				Application_Activity.getApplication_Exit().Exit(1);
			}
		}
		return false;
	}

	protected void dialog(String title, String msg, int type) {
		switch (type) {
		case 0:
			deleteApk(version);
			new AlertDialog.Builder(this)
					.setTitle(title)
					.setMessage(msg)
					.setCancelable(false)
					.setPositiveButton("是",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									if (isAsycn) {
										new OnLoadData_Updata().execute("");
									}
								}
							})
					.setNegativeButton("否",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							}).show();
			break;

		case 1:
			new AlertDialog.Builder(this)
					.setTitle(title)
					.setMessage(msg)
					.setCancelable(false)
					.setPositiveButton("是",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									Md_system.setVersion(version);
									Intent i = new Intent(Intent.ACTION_VIEW);
									i.setDataAndType(
											Uri.fromFile(new File(
													PHONE_PATH
															+ "jclwjcz/apk/jcz_pda_ajlw_"
															+ version + ".apk")),
											"application/vnd.android.package-archive");
									i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
									startActivity(i);
									showNotification();
									finish();
									// System_Updata_Activity.this.request(
									// "18J89", getFinishUpgrade(), 0,
									// new String[] { "1" });
								}
							}).show();
			break;
		}
	}

	protected Map<String, Object> getFinishUpgrade() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		Map<String, Object> requestSystemUpgradeVsersionMap = new HashMap<String, Object>();
		requestSystemUpgradeVsersionMap.put("jyjgbh", Md_system.getDzkey());
		requestSystemUpgradeVsersionMap.put("pdaver", version);
		requestSystemUpgradeVsersionMap.put("type", "4");
		requestMap.put("vehispara", requestSystemUpgradeVsersionMap);
		return requestMap;
	}

	/**
	 * 回调类
	 */
	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try{
		if ("18J89".equals(jkid)) {
			HashMap<String, String> finish_update_map = (HashMap<String, String>) result;
			if (finish_update_map.get("code").equals("1")) {
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setDataAndType(
						Uri.fromFile(new File(PHONE_PATH
								+ "jclwjcz/apk/jcz_pda_ajlw_" + version
								+ ".apk")),
						"application/vnd.android.package-archive");
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				showNotification();
				finish();
			} else {
				System_Updata_Activity.this.request("18J89",
						getFinishUpgrade(), 0, new String[] { "1" });
			}
		}
		}catch (Exception e) {
			DefautDialog.showDialog(System_Updata_Activity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	/**
	 * 删除下载异常的数据包
	 */
	private void deleteApk(String vers) {
		try {
			File file = new File(PHONE_PATH + "jclwjcz/apk/jcz_pda_ajlw_"
					+ vers + ".apk");
			if (file.exists()) {
				file.delete();
				file = null;
			}
		} catch (Exception e) {
		}
	}
}

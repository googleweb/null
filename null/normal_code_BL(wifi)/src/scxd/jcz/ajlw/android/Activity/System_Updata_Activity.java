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
 * ϵͳ����
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
 * ֪ͨ����ʾ
 */
	public void showNotification() {
		Notification notification = new Notification(R.drawable.xxqc,
				"��ϲ�㣬�������ƶ�����ϵͳ�����ɹ���", System.currentTimeMillis());
		notification.defaults = Notification.DEFAULT_SOUND
				| Notification.DEFAULT_VIBRATE;
		Intent notificationIntent = new Intent(System_Updata_Activity.this,
				Login_Activity.class);
		// �����֪ͨ��Ҫ��ת��Activity
		PendingIntent contentItent = PendingIntent.getActivity(this, 0,
				notificationIntent, 0);
		notification.setLatestEventInfo(this, "��ʾ��", "��ϲ�㣬�������ƶ�����ϵͳ�����ɹ���",
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
		textView_version.setText("���ַ����������°汾��������ť�����µİ�װ��!");
		btu_qr.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				new OnLoadData_Updata().execute("");
			}
		});
	}
/**
 * �첽���ذ�װ��
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
				txtView_sj.setText("��װ�����سɹ�!");
				dialog("��ʾ��", "��װ�����سɹ����汾��Ϊ��" + version + ",���ȷ�����а�װ!", 1);
				break;
			case 0:
				dialog("��ʾ��", "��װ������ʧ�ܣ�������!", 0);
				break;
			case 2:
				Toast.makeText(System_Updata_Activity.this,
						"��װ�������쳣����������������ٽ��в���!", 2000).show();
				break;

			}

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			textview_msg.setVisibility(0);
			float fileLength = ((float) length / 1024 / 1024);
			textview_msg.setText("�ļ���С:"
					+ (float) (Math.round(fileLength * 100)) / 100 + "M  ���:"
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
	 * ����ƽ�巵�ذ��������¼�
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
					.setPositiveButton("��",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									if (isAsycn) {
										new OnLoadData_Updata().execute("");
									}
								}
							})
					.setNegativeButton("��",
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
					.setPositiveButton("��",
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
	 * �ص���
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
	 * ɾ�������쳣�����ݰ�
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

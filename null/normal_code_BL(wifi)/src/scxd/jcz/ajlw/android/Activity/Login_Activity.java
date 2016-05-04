package scxd.jcz.ajlw.android.Activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.CommonUtils;
import scxd.jcz.ajlw.android.Activity.Common.CrashHandler;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Activity.Common.Docxxml;
import scxd.jcz.ajlw.android.buss.SystemConfig;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_JYXM;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.db.CarTypeTabHelper;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import scxd.jcz.ajlw.android.model.Md_cartype;
import scxd.jcz.ajlw.android.model.Md_system;
import scxd.jcz.ajlw.android.sign.DisplayMetricsEN;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
/**
 * ��Ա��¼
 * @author Administrator
 *@time
 */
@SuppressLint("NewApi")
public class Login_Activity extends BaseActivity {
	private ImageView logo;
	// ��¼��ť
	Button btu_login;
	// ȡ����ť
	Button btu_cancel;
	// ���ò���
	Button setPram;
	TelephonyManager tm;
	// �û��˻�
	EditText text_name;
	// �û�����
	EditText text_pass;
	// �������ı�
	TextView dengdai_msg;
	// �߳�ִ��״̬
	boolean isAsycn = true;
	RelativeLayout denglu_abs;
	// �ȴ��Ի���
	ProgressDialog p_dialog;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestSystemUpgradeVsersionMap = null;
	SharedPreferences sp;
	private Intent service;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CrashHandler.getInstance().init(this, "jcz_pda");
		Md_Car_Temp.getTempCar().fromLoginToInit = "";
		setContentView(R.layout.login);
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		DisplayMetrics dm = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(dm);
		DisplayMetricsEN.setWidth(dm.widthPixels);
		DisplayMetricsEN.setHeigth(dm.heightPixels);
		Md_Car_Temp.getTempCar().mapwz=Docxxml.xmlread(this);
		GetSystemonConif();
		Md_Car_JYXM.init(); // ��ʼ������
		ButtonClick();
		Login_Activity.this.setTitle(this.getTitle() + "           "+getResources().getString(R.string.bbh)
				+ Md_system.getVersion());
		sp = this.getSharedPreferences("AJLW", MODE_PRIVATE);
		String sp_name = sp.getString("NAME", "none");
		boolean isfirst=sp.getBoolean("isfirst", false);
		if (!sp_name.equals("none")) {
			text_name.setText(sp_name);
		}
		if(!isfirst){
			insertDB();
		}

	}
/**
 * �������ݿ�
 */
	private void insertDB() {
		List<Md_cartype> list=MD_ListItem.Get_cllx();
		CarTypeTabHelper carTypeTabHelper=CarTypeTabHelper.getInstance();
		carTypeTabHelper.clear();
		for (Md_cartype md_cartype : list) {
			carTypeTabHelper.insert(md_cartype);
		}
		sp.edit().putBoolean("isfirst", true).commit();
	}

	@Override
	protected void onResume() {
		Login_Activity.this.request("18Q89", getSystemUpgradeVsersion(), 0,
				new String[] { "2" });
		super.onResume();
	}

	private Map<String, Object> getSystemUpgradeVsersion() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestSystemUpgradeVsersionMap != null) {
			requestSystemUpgradeVsersionMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requestSystemUpgradeVsersionMap = new HashMap<String, Object>();
		requestSystemUpgradeVsersionMap.put("jyjgbh", Md_system.getDzkey());
		requestMap.put("QueryCondition", requestSystemUpgradeVsersionMap);
		return requestMap;
	}
/**
 * ���������ļ���ʾ��Ӧ��ͼ�꣬��������Ӧ�ļ���
 */
	// ��ť����¼�����
	public void ButtonClick() {
		try {
			logo = (ImageView) findViewById(R.id.logo);
			if (Md_system.dq.trim().equals("") || Md_system.getDq().equals("")) {
				logo.setBackgroundDrawable(getResources().getDrawable(
						(R.drawable.bj_logo)));
			} else if (Md_system.getDq().equals("�㶫")) {
				logo.setBackgroundDrawable(getResources().getDrawable(
						(R.drawable.gdhs_logo)));
			} else if (Md_system.getDq().equals("����")) {
				logo.setBackgroundDrawable(getResources().getDrawable(
						(R.drawable.bj_logo)));
			} else if (Md_system.getDq().equals("�Ĵ�")) {
				logo.setBackgroundDrawable(getResources().getDrawable(
						(R.drawable.sc_logo)));
			} else if (Md_system.getDq().equals("����")) {
				logo.setBackgroundDrawable(getResources().getDrawable(
						(R.drawable.bj_logo)));
			} else {
				logo.setBackgroundDrawable(getResources().getDrawable(
						(R.drawable.bj_logo)));
			}
			this.btu_login = (Button) findViewById(R.id.btu_login);
			this.btu_cancel = (Button) findViewById(R.id.btu_cancel);
			this.setPram = (Button) findViewById(R.id.setPram);
			this.text_name = (EditText) findViewById(R.id.text_name);
			this.text_pass = (EditText) findViewById(R.id.text_pass);
			dengdai_msg = (TextView) findViewById(R.id.dengdai_msg);
			// if (Md_Car_Temp.getTempCar().ispbzc) {
			// Map<String, Object> requestMap = new HashMap<String, Object>();
			// Map<String, Object> requestLoginOutMap = new HashMap<String,
			// Object>();
			// requestLoginOutMap.put("username",
			// Md_Car_Temp.getTempCar().userid);
			// requestMap.put("vehispara", requestLoginOutMap);
			// Login_Activity.this.request("18J05", requestMap,
			// R.string.USER_LOGOUT, new String[] { "1" });
			// }
			// ��¼�¼�
			btu_login.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					Editor editor = sp.edit();
					editor.putString("NAME", text_name.getText().toString());
					editor.commit();
					if (requestMap != null) {
						requestMap = null;
					}
					if (requestSystemUpgradeVsersionMap != null) {
						requestSystemUpgradeVsersionMap = null;
					}
					requestMap = new HashMap<String, Object>();
					requestSystemUpgradeVsersionMap = new HashMap<String, Object>();
					requestSystemUpgradeVsersionMap.put("babh",
							Md_system.getDzkey());
					requestMap.put("QueryCondition",
							requestSystemUpgradeVsersionMap);
					Login_Activity.this.request("18C50", requestMap,
							R.string.TIME_MATHCH_SERVICE_TO_NOW,
							new String[] { "2" });

					// String username = text_name.getText().toString().trim()
					// .replace(" ", "").toUpperCase();
					// String password = text_pass.getText().toString().trim()
					// .replace(" ", "");
					// if (username.matches("^[A-Za-z0-9]{3,20}$")
					// && password.matches("^[A-Za-z0-9]{3,20}$")) {
					// Map<String, Object> requestMap = new HashMap<String,
					// Object>();
					// Map<String, Object> requestLoginMap = new HashMap<String,
					// Object>();
					// requestLoginMap.put("pdaid",
					// Md_Car_Temp.getTempCar().deviceId);
					// requestLoginMap.put("password", password);
					// requestLoginMap.put("username", username);
					// requestLoginMap.put("jyjgbh", Md_system.getDzkey());
					// requestMap.put("QueryCondition", requestLoginMap);
					// Md_Car_Temp.getTempCar().username = username;
					// Md_Car_Temp.getTempCar().password = password;
					// Login_Activity.this.request("18Q09", requestMap,
					// R.string.USER_LOGIN, new String[] { "2" });
					// } else {
					// DefautDialog.showDialog(Login_Activity.this,
					// R.string.FORMAT_TITLE,
					// R.string.NAMEORPASSWORD_ERROR, false, null,
					// null);
					// }
				}
			});
			// ȡ���¼�--�˳���ǰϵͳ
			btu_cancel.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
//					service = new Intent();
//					service.setAction("scxd.jcz.ajlw.android.service.PingService");
//					service.putExtra("exit", true);
//					Login_Activity.this.startService(service);
					Application_Activity.getApplication_Exit().Exit(1);
					finish();
				}
			});

			// ȡ���¼�--�˳���ǰϵͳ
			setPram.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					Intent itt = new Intent();
					Md_Car_Temp.getTempCar().fromLoginToInit = "yes";
					itt.setClass(Login_Activity.this, Init_Activity.class);
					startActivity(itt);
					finish();
				}
			});
		} catch (Exception e) {
			DefautDialog.showDialog(Login_Activity.this, R.string.SYS_TITLE,
					R.string.INIT_ERROR, false, null, null);
		}
	}

	/**
	 * ��ȡϵͳ�����ļ�
	 */
	public void GetSystemonConif() {
		// TODO ƽ�� �豸id
		Md_Car_Temp.getTempCar().deviceId = android.provider.Settings.System
				.getString(this.getContentResolver(),
						android.provider.Settings.System.ANDROID_ID)
				.toUpperCase();
		SystemConfig.writeConfigFile(Md_Car_Temp.getTempCar().deviceId,
				"/mnt/sdcard/jclwjcz/pbwym.txt");
		switch (SystemConfig.GetSystemConfigData(this)) {
		case 0:
			service = new Intent();
			service.setAction("scxd.jcz.ajlw.android.service.PingService");
			Login_Activity.this.startService(service);
			Md_Car_Temp.getTempCar().car_hphm = "";
			break;
		case 1:
			Intent itt = new Intent();
			itt.setClass(Login_Activity.this, Init_Activity.class);
			startActivity(itt);
			finish();
			break;
		case 2:
			Toast.makeText(Login_Activity.this, R.string.sys_msg2, 1000).show();
			Intent ittes = new Intent();
			ittes.setClass(Login_Activity.this, Init_Activity.class);
			startActivity(ittes);
			finish();
			break;
		}
	}

	/**
	 * ����ƽ�巵�ذ��������¼�
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == 4) {
			Application_Activity.getApplication_Exit().Exit(1);
		}
		return true;
	}

	private Map<String, Object> getBasicPhotos() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestSystemUpgradeVsersionMap != null) {
			requestSystemUpgradeVsersionMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requestSystemUpgradeVsersionMap = new HashMap<String, Object>();
		requestSystemUpgradeVsersionMap.put("jyjgbh", Md_system.getDzkey());
		requestMap.put("QueryCondition", requestSystemUpgradeVsersionMap);
		return requestMap;
	}

	/**
	 * �ص���
	 */
	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try {
			if ("18Q89".equals(jkid)) {
				final HashMap<String, String> systemVersionMap = (HashMap<String, String>) result;
				try {
					String s = Md_system.getVersion();
					if (systemVersionMap.get("code").equals("1")) {
						if (!"".equals(systemVersionMap.get("pdaupdate"))
								&& !systemVersionMap.get("pdaupdate").equals(
										Md_system.getVersion())) {
							new AlertDialog.Builder(Login_Activity.this)
									.setTitle("ϵͳ��ʾ��")
									.setCancelable(false)
									.setMessage("��ǰ�������°汾�������������")
									.setPositiveButton(
											"ȷ  ��",
											new DialogInterface.OnClickListener() {
												@Override
												public void onClick(
														DialogInterface dialog,
														int which) {
													Intent itt = new Intent();
													itt.putExtra(
															"URL",
															systemVersionMap
																	.get("pdapath"));
													itt.putExtra(
															"VERSION",
															systemVersionMap
																	.get("pdaupdate"));
													itt.setClass(
															Login_Activity.this,
															System_Updata_Activity.class);
													startActivity(itt);
													finish();
												}
											}).show();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if ("18Q49".equals(jkid)) {
				HashMap<String, String> Car_wgpzxm_map = (HashMap<String, String>) result;
				Md_Car_JYXM.initCarWGPZXM3(Login_Activity.this, Car_wgpzxm_map);
				String username = text_name.getText().toString().trim()
						.replace(" ", "");
				String password = text_pass.getText().toString().trim()
						.replace(" ", "");
				if (username.matches("^[A-Za-z0-9]{3,20}$")
						&& password.matches("^[A-Za-z0-9]{3,20}$")) {
					if (requestMap != null) {
						requestMap = null;
					}
					if (requestSystemUpgradeVsersionMap != null) {
						requestSystemUpgradeVsersionMap = null;
					}
					requestMap = new HashMap<String, Object>();
					requestSystemUpgradeVsersionMap = new HashMap<String, Object>();
					requestSystemUpgradeVsersionMap.put("pdaid",
							Md_Car_Temp.getTempCar().deviceId);
					requestSystemUpgradeVsersionMap.put("password", password);
					requestSystemUpgradeVsersionMap.put("username", username);
					requestSystemUpgradeVsersionMap.put("jyjgbh",
							Md_system.getDzkey());
					requestMap.put("QueryCondition",
							requestSystemUpgradeVsersionMap);
					Md_Car_Temp.getTempCar().username = username;
					Md_Car_Temp.getTempCar().password = password;
					Login_Activity.this.request("18Q09", requestMap,
							R.string.USER_LOGIN, new String[] { "2" });
				} else {
					DefautDialog.showDialog(Login_Activity.this,
							R.string.FORMAT_TITLE,
							R.string.NAMEORPASSWORD_ERROR, false, null, null);
				}
			} else if ("18Q09".equals(jkid)) {
				String str = (String) result;
				String temp[] = str.split("@");
				String dddl="";
				if (temp[0].equals("1")) {
					Md_Car_Temp.getTempCar().userid = temp[2];
					try {
						Md_Car_Temp.getTempCar().userxingming = temp[3];
						dddl=temp[4];
					} catch (Exception e) {
					}
					Intent itt = new Intent();
					itt.setClass(Login_Activity.this, MainActivity.class);
					if(dddl.equals("1")){
						starService();
					}else{
						
					}
					
					startActivity(itt);
					finish();
				} else {
					DefautDialog.showDialog(Login_Activity.this, this
							.getResources().getString(R.string.SYS_TITLE),
							temp[1], false, null, null);
				}
			} else if ("18C50".equals(jkid)) {
				HashMap<String, String> sj = (HashMap<String, String>) result;
				if (sj.get("code").equals("1")) {
//					dealSJ(sj);//Ҫ�ж�ʱ��
					SimpleDateFormat Simpleformat = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String sersj = sj.get("sj").substring(0, sj.get("sj").indexOf("."));
					Date service_time = Simpleformat.parse(sersj.trim());
					Md_Car_Temp.getTempCar().sjc = new Date().getTime()
							- service_time.getTime();
					Login_Activity.this.request("18Q49", getBasicPhotos(), 0,
							new String[] { "2" });
				} else {
					Toast.makeText(Login_Activity.this, sj.get("message"), 1000)
							.show();
				}
			} else if ("18J05".equals(jkid)) {
				List<Md_Car_TongYong> callZX = (List<Md_Car_TongYong>) result;
				callZX(callZX);
			}
		} catch (Exception e) {
			DefautDialog.showDialog(Login_Activity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}
/**
 * ���õ�ǰʱ��
 * @param sj
 */
	// ���õ�ǰʱ��
	private void setSystemTime(HashMap<String, String> sj) {
		if (sj != null && !sj.get("sj").equals("")) {
			String sersj = sj.get("sj").substring(0, sj.get("sj").indexOf("."));
			if (setSystemDateTime(sersj.trim())) {
				Login();
			}
		} else {
			Login();
		}
	}

	private Boolean setSystemDateTime(String sersj) {
		try {
			long when = CommonUtils.parseDateTime(sersj,
					CommonUtils.FORMAT_TIME);
			SystemClock.setCurrentTimeMillis(when);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
/**
 * �û���¼
 */
	// �û���¼
	private void Login() {
		String username = text_name.getText().toString().trim()
				.replace(" ", "").toUpperCase();
		String password = text_pass.getText().toString().trim()
				.replace(" ", "");
		if (username.matches("^[A-Za-z0-9]{3,20}$")
				&& password.matches("^[A-Za-z0-9]{3,20}$")) {
			if (requestMap != null) {
				requestMap = null;
			}
			if (requestSystemUpgradeVsersionMap != null) {
				requestSystemUpgradeVsersionMap = null;
			}
			requestMap = new HashMap<String, Object>();
			requestSystemUpgradeVsersionMap = new HashMap<String, Object>();
			requestSystemUpgradeVsersionMap.put("pdaid",
					Md_Car_Temp.getTempCar().deviceId);
			requestSystemUpgradeVsersionMap.put("password", password);
			requestSystemUpgradeVsersionMap.put("username", username);
			requestSystemUpgradeVsersionMap.put("jyjgbh", Md_system.getDzkey());
			requestMap.put("QueryCondition", requestSystemUpgradeVsersionMap);
			Md_Car_Temp.getTempCar().username = username;
			Md_Car_Temp.getTempCar().password = password;
			Login_Activity.this.request("18Q09", requestMap,
					R.string.USER_LOGIN, new String[] { "2" });
		} else {
			DefautDialog.showDialog(Login_Activity.this, R.string.FORMAT_TITLE,
					R.string.NAMEORPASSWORD_ERROR, false, null, null);
		}
	}

	/**
	 * �жϵ�ǰʱ��
	 * 
	 * @param sj
	 */
	private void dealSJ(HashMap<String, String> sj) {
		SimpleDateFormat Simpleformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			String sersj = sj.get("sj").substring(0, sj.get("sj").indexOf("."));
			Date service_time = Simpleformat.parse(sersj.trim());
			if ((new Date().getTime() - service_time.getTime()) > 2 * 60 * 1000
					|| (new Date().getTime() - service_time.getTime()) < -2 * 60 * 1000) {
				DefautDialog.showDialog(Login_Activity.this, this
						.getResources().getString(R.string.SYS_TITLE),
						"����ϵͳʱ�䣬��ǰʱ�䣺" + sj.get("sj") + "!", false,
						new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View arg0) {
								dialog.dimiss();
								Intent intent = new Intent(
										Settings.ACTION_DATE_SETTINGS);
								startActivity(intent);
							}
						}, null);
			} else {
				Md_Car_Temp.getTempCar().sjc = new Date().getTime()
						- service_time.getTime();
				Login_Activity.this.request("18Q49", getBasicPhotos(), 0,
						new String[] { "2" });
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void callZX(List<Md_Car_TongYong> callZX) {
		try {
			if (callZX.get(0).code.equals("1")) {
				Md_Car_Temp.getTempCar().clearData();
				DefautDialog.showDialog(Login_Activity.this, this
						.getResources().getString(R.string.SYS_TITLE), callZX
						.get(0).message, false, null, null);
			} else {
				DefautDialog.showDialog(Login_Activity.this, this
						.getResources().getString(R.string.SYS_TITLE), callZX
						.get(0).message, false, null, null);
			}
		} catch (Exception e) {
			DefautDialog.showDialog(Login_Activity.this, this.getResources()
					.getString(R.string.SYS_TITLE), "�����޸��쳣�������²���!", false,
					null, null);
		} finally {
			Md_Car_Temp.getTempCar().ispbzc = false;
		}
	}
}
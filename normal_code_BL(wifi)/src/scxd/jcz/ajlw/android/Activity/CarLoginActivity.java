package scxd.jcz.ajlw.android.Activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Activity.Common.Docxxml;
import scxd.jcz.ajlw.android.Activity.Common.WebStatus;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.InfoItem;
import scxd.jcz.ajlw.android.model.InfoItemChk;
import scxd.jcz.ajlw.android.model.InfoItemDate;
import scxd.jcz.ajlw.android.model.InfoItemEdt;
import scxd.jcz.ajlw.android.model.InfoItemSp;
import scxd.jcz.ajlw.android.model.InfoItemSpEdt;
import scxd.jcz.ajlw.android.model.ItemLayout;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import scxd.jcz.ajlw.android.model.Md_cartype;
import scxd.jcz.ajlw.android.model.Md_system;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * ������¼���ƽ���
 * 
 * @author Administrator
 * @time
 * 
 */
public class CarLoginActivity extends BaseActivity {
	public static int hp = 0;
	public static int s;
	private static final int ONLINE = 0;// ����
	String alertMsg = "";
	String alertTitle = "";
	ProgressDialog p_dialog;
	private Button submitBtn;
	private Button queryBtn;
	private ItemLayout loginModel;
	private InfoItem hphmItem;
	private InfoItem vinItem;
	private InfoItem clxhItem;
	private InfoItem cllxItem;
	private InfoItem hpzlItem;
	private InfoItem clsslbItem;
	private InfoItem syxzItem;
	private InfoItem jclbItem;
	private InfoItem csys;
	private InfoItem jylbzlfdjItem; // �Ƕ���
	private InfoItem jylbzllsjyItem;// ��ʱ����
	private InfoItem sfqszxzItem;
	private InfoItem WZItem;
	private InfoItem obddsfzc = null;
	private InfoItem gl;
	private InfoItem zxzxjxs;
	private InfoItem syr;
	InfoItem qdxs = null;
	InfoItem qzdz = null;
	InfoItem ygddtz;
	Map<String, Object> requestMap = null;
	Map<String, Object> requesJYXMMap = null;
	Map<String, Object> requesCarLogintMap = null;
	Map<String, String> hm = null;
	Map<String, Object> requestMapNode = null;
	private int queryTime = 0;
	/**
	 * �ж��Ƿ����˹����Ȩ��
	 */
	private boolean isRGWJ = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_login);
		registerBoradcastReceiver();
		init();
	}

	@Override
	protected void onPause() {
		Md_Car_Temp.getTempCar().isFromGGBD = false;
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		Md_Car_Temp.getTempCar().isFromGGBD = false;
		if (mBroadcastReceiver != null) {
			unregisterReceiver(mBroadcastReceiver);
		}
		super.onDestroy();
	}

	/**
	 * ��ʼ������
	 * 
	 * @return
	 */
	void init() {
		Md_Car_Temp.getTempCar().str = null;
		Md_Car_Temp.getTempCar().zdy = false;
		this.queryBtn = (Button) findViewById(R.id.carLoging_online_btn_query);
		this.loginModel = (ItemLayout) findViewById(R.id.carLogin_onlineLayout);
		this.submitBtn = (Button) findViewById(R.id.carLoging_online_btn_submit);
		this.initItems(ONLINE);
		if (Md_Car_Temp.getTempCar().isFromGGBD) {
			try {
				Map<String, String> hm = new HashMap<String, String>();
				Bundle bundle = this.getIntent().getBundleExtra("map");
				Set<String> keySet = bundle.keySet(); // �õ�bundle�����е�key
				Iterator<String> iter = keySet.iterator();
				while (iter.hasNext()) {
					String key = iter.next();
					hm.put(key, bundle.getString(key));
				}
				loginModel.setItemsData(hm);
			} catch (Exception e) {
			}
		}
		if (Md_system.getSfhj().equals("��")) {
			if (Md_system.getSfgxjyxm().equals("��")) {
				if (Md_system.getSfzj().equals("��")) {
					this.loginModel.setShow(5, true);
				} else {
					this.loginModel.setShow(4, true);
				}

			} else {
				if (Md_system.getSfzj().equals("��")) {
					this.loginModel.setShow(4, true);
				} else {
					this.loginModel.setShow(3, true);
				}
			}
		} else {
			if (Md_system.getSfgxjyxm().equals("��")) {
				if (Md_system.getSfzj().equals("��")) {
					this.loginModel.setShow(4, true);
				} else {
					this.loginModel.setShow(3, true);
				}

			} else {
				if (Md_system.getSfzj().equals("��")) {
					this.loginModel.setShow(3, true);
				} else {
					this.loginModel.setShow(2, true);
				}
			}
		}

		/**
		 * �ö�
		 */
		findViewById(R.id.btn_up).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView1);
				scrollView.scrollTo(0, 0);
			}
		});
		/**
		 * �õ�
		 */
		findViewById(R.id.btn_down).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView1);
				scrollView.scrollTo(0, loginModel.getHeight());
			}
		});
		/**
		 * ��ѯ
		 */
		this.queryBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CarLoginActivity.this.submitBtn.setEnabled(true);
				if (Md_Car_Temp.getTempCar().mapwz == null) {
					Md_Car_Temp.getTempCar().mapwz = Docxxml
							.xmlread(CarLoginActivity.this);
				}
				if (queryTime == 0) {
					if (jclbItem.getData().equals("01")) {
						if (!hphmItem.getData().equals("")
								&& !vinItem.getData().equals("")) {
							CarLoginActivity.this.queryBtn.setEnabled(false);
							if (requestMap != null) {
								requestMap = null;
							}
							if (requesCarLogintMap != null) {
								requesCarLogintMap = null;
							}
							requestMap = new HashMap<String, Object>();
							requesCarLogintMap = new HashMap<String, Object>();
							requesCarLogintMap.put("hphm", hphmItem.getData()
									.toUpperCase());
							requesCarLogintMap.put("hpzl", hpzlItem.getData());
							requesCarLogintMap.put("clsbdh", vinItem.getData());
							requesCarLogintMap.put("jyjgbh",
									Md_system.getDzkey());
							requestMap
									.put("QueryCondition", requesCarLogintMap);
							if (WebStatus.isConnect(CarLoginActivity.this) != 0
									&& WebStatus
											.isConnect(CarLoginActivity.this) != 1) {
								Toast.makeText(CarLoginActivity.this,
										"�����쳣����������", 0).show();
								CarLoginActivity.this.queryBtn.setEnabled(true);
							} else {
								CarLoginActivity.this.request("18C49",
										requestMap,
										R.string.QUERY_CAR_BASICINFO,
										new String[] { "2" });
							}

						} else {
							DefautDialog.showDialog(CarLoginActivity.this,
									R.string.FORMAT_TITLE,
									R.string.INPUT_VIN_AND_HAPM, false, null,
									null);
						}
					} else if (jclbItem.getData().equals("00")) {
						if (!vinItem.getData().equals("")) {
							CarLoginActivity.this.queryBtn.setEnabled(false);
							if (requestMap != null) {
								requestMap = null;
							}
							if (requesCarLogintMap != null) {
								requesCarLogintMap = null;
							}
							requestMap = new HashMap<String, Object>();
							requesCarLogintMap = new HashMap<String, Object>();
							requesCarLogintMap.put("hphm", "");
							requesCarLogintMap.put("hpzl", hpzlItem.getData());
							requesCarLogintMap.put("jylb", jclbItem.getData());
							requesCarLogintMap.put("clsbdh", vinItem.getData());
							requesCarLogintMap.put("jyjgbh",
									Md_system.getDzkey());
							requestMap
									.put("QueryCondition", requesCarLogintMap);
							if (WebStatus.isConnect(CarLoginActivity.this) != 0
									&& WebStatus
											.isConnect(CarLoginActivity.this) != 1) {
								Toast.makeText(CarLoginActivity.this,
										"�����쳣����������", 0).show();
								CarLoginActivity.this.queryBtn.setEnabled(true);
							} else {
								CarLoginActivity.this.request("18C49",
										requestMap,
										R.string.QUERY_CAR_BASICINFO,
										new String[] { "2" });
							}
						} else {
							DefautDialog.showDialog(CarLoginActivity.this,
									R.string.FORMAT_TITLE, R.string.INPUT_VIN,
									false, null, null);
						}
					} else {
						if (!hphmItem.getData().equals("")
								&& !vinItem.getData().equals("")) {
							CarLoginActivity.this.queryBtn.setEnabled(false);
							if (requestMap != null) {
								requestMap = null;
							}
							if (requesCarLogintMap != null) {
								requesCarLogintMap = null;
							}
							requestMap = new HashMap<String, Object>();
							requesCarLogintMap = new HashMap<String, Object>();
							requesCarLogintMap.put("hphm", hphmItem.getData()
									.toUpperCase());
							requesCarLogintMap.put("hpzl", hpzlItem.getData());
							requesCarLogintMap.put("clsbdh", vinItem.getData());
							requesCarLogintMap.put("jyjgbh",
									Md_system.getDzkey());
							requestMap
									.put("QueryCondition", requesCarLogintMap);
							if (WebStatus.isConnect(CarLoginActivity.this) != 0
									&& WebStatus
											.isConnect(CarLoginActivity.this) != 1) {
								Toast.makeText(CarLoginActivity.this,
										"�����쳣����������", 0).show();
								CarLoginActivity.this.queryBtn.setEnabled(true);
							} else {
								CarLoginActivity.this.request("18C49",
										requestMap,
										R.string.QUERY_CAR_BASICINFO,
										new String[] { "2" });
							}
						} else {
							DefautDialog.showDialog(CarLoginActivity.this,
									R.string.FORMAT_TITLE,
									R.string.INPUT_VIN_AND_HAPM, false, null,
									null);
						}
					}
				} else {
					DefautDialog.showDialog(CarLoginActivity.this, "��ʾ��",
							"��3������µ����ѯ��", false, null, null);
				}

			}
		});
		/**
		 * ȷ��
		 */
		submitBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				submitBtn.setEnabled(false);
				setMD_Car_Temp();
				if (loginModel.isCompleted()) {
					if (loginModel.isMatch()) {

						requestMap = new HashMap<String, Object>();
						requesCarLogintMap = loginModel.getDataNodeAndValue();
						if (!Md_system.getSfgxjyxm().equals("��")) {
							requesCarLogintMap.put("jyxm", "F1");
						}
						requesCarLogintMap.put("jylsh", "");
						requesCarLogintMap.put("jyjgbh", Md_system.getDzkey());
						if (jclbItem.getData().equals("01")
								|| jclbItem.getData().equals("00")) {
							requesCarLogintMap.put("jylbzl", "");
						}
						requesCarLogintMap.put("dly",
								Md_Car_Temp.getTempCar().userxingming);
						requesCarLogintMap.put("ycy", "");
						requesCarLogintMap.put("wjy", "");
						requesCarLogintMap.put("bhgx", "");
						requesCarLogintMap.put("jycs", "1");
						requesCarLogintMap.put("dtjyy", "");
						requesCarLogintMap.put("dpjyy", "");
						requesCarLogintMap.put("ycysfzh", "");
						requesCarLogintMap.put("wjysfzh", "");
						requesCarLogintMap.put("dtjyysfzh", "");
						requesCarLogintMap.put("ccdlsj", "");
						// requesCarLogintMap.put("clyt",clyt[model].getData());
						requesCarLogintMap.put("dlsj", new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(new Date()));
						requesCarLogintMap.put("dpjyysfzh", "");
						requesCarLogintMap.put("jyrq", "");
						requestMap.put("vehispara", requesCarLogintMap);
						System.out.println("18C51+++" + requestMap);
						if (WebStatus.isConnect(CarLoginActivity.this) != 0
								&& WebStatus.isConnect(CarLoginActivity.this) != 1) {
							Toast.makeText(CarLoginActivity.this, "�����쳣����������",
									0).show();
							CarLoginActivity.this.submitBtn.setEnabled(true);
						} else {
							CarLoginActivity.this.request("18C51", requestMap,
									R.string.CAR_LOGIN, new String[] { "1" });
						}
					} else {
						submitBtn.setEnabled(true);
						DefautDialog.showDialog(CarLoginActivity.this,
								getResources().getString(R.string.SYS_TITLE),
								loginModel.Log(), false, null, null);
					}
				} else {
					submitBtn.setEnabled(true);
					DefautDialog.showDialog(CarLoginActivity.this,
							getResources().getString(R.string.SYS_TITLE),
							loginModel.Log(), false, null, null);
				}
			}
		});
		initValue();
		getwjqx();
	}

	/**
	 * ���� Ȩ��
	 * 
	 * @param acl
	 */
	private void getwjqx() {
		try {
			String[] permissions = null;
			// Md_Car_Temp.getTempCar().acl="0,1,2,4";
			if (Md_Car_Temp.getTempCar().acl.equals("")) {
				permissions = new String[] { "0", "1", "2", "3", "4", "5", "6",
						"7", "8", "9", "10", "11", "12","14" };
			} else {
				permissions = Md_Car_Temp.getTempCar().acl.split(",");
			}
			// permissions = new String[] { "0", "2", "1", "3", "4", "5", "6",
			// "7", "8", "9", "10", "11", "12" };
			for (String permission : permissions) {
				if ("3".equals(permission)) {
					isRGWJ = true;
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * �жϻ���
	 */
	private void initValue() {
		try {
			if (hm != null) {
				hm = null;
			}
			hm = new HashMap<String, String>();
			if (!"".equals(Md_Car_Temp.getTempCar().car_hphm)
					&& !"".equals(Md_Car_Temp.getTempCar().car_hpzl)) {
				hm.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
				hm.put("hpzl", MD_ListItem.GetName(
						Md_Car_Temp.getTempCar().car_hpzl,
						MD_ListItem.Get_hpzl()));
				loginModel.setItemsData(hm);
				if (Md_system.getSfhj().equals("��")) {
					if (Md_system.getSfgxjyxm().equals("��")) {
						loginModel.setShow(4, true);
					} else {
						loginModel.setShow(3, true);
					}
				} else {
					if (Md_system.getSfgxjyxm().equals("��")) {
						loginModel.setShow(3, true);
					} else {
						loginModel.setShow(2, true);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ʼ�� ��Ŀ
	 * 
	 * @param model
	 */
	private void initItems(final int model) {
		/**
		 * ��Ŀ �������� [1]:�ı� [2]:������ [2|8192]:���� ^[A-Za-z0-9]{6}$ [\u4e00-\u9fa5]+
		 */
		InfoItem jcxdh;

		InfoItem zczw, zs, jcxlb;

		InfoItem ccrq, clpp1, cwkk, cwkc, cwkg, hxnbcd, hxnbkd, hxnbgd, zzl, zbzl, ltgg, lcbds, fzjg, dlysfzh;
		/* ������Ŀ */
		InfoItem F1 = null, C1 = null, DC = null, B1 = null, B2 = null, B3 = null, B4 = null, B5 = null, B6 = null, B0 = null, H1 = null, H2 = null, H3 = null, H4 = null, S1 = null, A1 = null, R1 = null, R2 = null, R3 = null;
		/** �������� **/
		InfoItem clyt = null;
		clyt1 = null;
		InfoItem hbbz = null, rllb = null, gyfs = null, pfbz = null, jqfs = null, hbjcbz = null, sfgz = null, sfyobd = null, bsx = null, obdgzm = null, hbbh = null, gs = null, zsitem = null, pl = null;
		/** ����������Ϣ **/
		InfoItem rlzl, hdzk, zzs, zzly, xh, sjr, sjrsfzh, ytsx, fdjh, jyhgbzbh, hdzzl, zj, qlj, hlj, ccdjrq, yxqz, bxzzrq;
		// ����������Ϣ��
		InfoItem gbthps, lts, glbm, zzg, fdjxh, gcjk, sfzmhm, hbdbqk, xszbh, qpzk, hpzk, sfzmmc, clpp2, zqyzl, zzcmc, zxxs, djrq, qzbfqz, dybj;
		/**
		 * �ۼ�������
		 */
		InfoItem Grade = null, Ejwh = null, Repair = null;
		/** ��¼��Ϣ **/
		this.hphmItem = new InfoItemSpEdt(this, "���ƺ���", "hphm",
				MD_ListItem.Get_sf(), 1, null);
		this.clxhItem = new InfoItemEdt(this, "�����ͺ�*", null, "clxh", 1, null,
				false);
		this.vinItem = new InfoItemEdt(this, "����VIN��*", null, "clsbdh", 1,
				null, false);
		/*this.cllxItem = new InfoItemSp(this, "��������", "cllx",
				MD_ListItem.Get_cllx(), null);*/
		this.cllxItem = new InfoItemEdt(this, "��������",null, "cllx",1,
				 null,false);
		this.syxzItem = new InfoItemSp(this, "ʹ������", "syxz",
				MD_ListItem.Get_syxz(), null);
		/*this.jylbzlfdjItem = new InfoItemSp(this, "����������#", "jylbzl",
				MD_ListItem.Get_jylbzlfdj(), null);*/
		this.jylbzlfdjItem = new InfoItemSp(this, "����������#", "jylbzl",
				MD_ListItem.Get_jylbzlfdj(), new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent, View arg1,
							int position, long arg3) {
						String jylbzl = ((Md_cartype) parent
								.getItemAtPosition(position)).getName();
						if("0405".equals(jylbzl)){
							clyt1.setData("J2");
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
				});
		this.jylbzllsjyItem = new InfoItemSp(this, "����������#", "jylbzl",
				MD_ListItem.Get_jylbzllsjy(), null);
		/**
		 * ͨ���޸ļ��������޸ĺ��ƺ���
		 * */
		// final InfoItemSpEdt hphmItemsp=(InfoItemSpEdt)
		// CarLoginActivity.this.hphmItem;
		this.jclbItem = new InfoItemSp(this, "������*", "jylb",
				MD_ListItem.Get_jylb(), new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						String jylb = ((Md_cartype) parent
								.getItemAtPosition(position)).getName();
						if (jylb.equals("04")) {
							// hphmItemsp.setSpinnerdata(0);
							jylbzlfdjItem.setVisibility(View.VISIBLE);
							jylbzllsjyItem.setVisibility(View.GONE);
						} else if (jylb.equals("02")) {
							// hphmItemsp.setSpinnerdata(0);
							jylbzlfdjItem.setVisibility(View.GONE);
							jylbzllsjyItem.setVisibility(View.VISIBLE);
							// } else if(jylb.equals("00")) {
							// hphmItemsp.setSpinnerdata(MD_ListItem.Get_sf().size()-1);
						} else {
							// hphmItemsp.setSpinnerdata(0);
							jylbzlfdjItem.setVisibility(View.GONE);
							jylbzllsjyItem.setVisibility(View.GONE);
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});
		this.sfqszxzItem = new InfoItemSp(this, "�Ƿ�˫ת����#", "sfqszxz",
				MD_ListItem.Get_sfsfqszxz(), null);
		this.WZItem = new InfoItemEdt(this, "Υ����Ϣ", null, "zt", 1, null, true);
		this.hpzlItem = new InfoItemSp(this, "��������", "hpzl",
				MD_ListItem.Get_hpzl(), new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						loginModel.initEdtNull();
						String hpzl = ((Md_cartype) parent
								.getItemAtPosition(position)).getName();
						if ("15".equals(hpzl)) {// ����ǹҳ� �����ᣬǰ�գ�Զ�ⶼѡ��
							qdxs.setData("0");
							qzdz.setData("00");
							ygddtz.setData("");
						}else{
							qdxs.setData("-1");
							qzdz.setData("-1");
							ygddtz.setData("-1");
						}
						if (Md_Car_Temp.getTempCar().isFromGGBD) {
							try {
								Map<String, String> hm = new HashMap<String, String>();
								Bundle bundle = CarLoginActivity.this
										.getIntent().getBundleExtra("map");
								Set<String> keySet = bundle.keySet(); // �õ�bundle�����е�key
								Iterator<String> iter = keySet.iterator();
								while (iter.hasNext()) {
									String key = iter.next();
									hm.put(key, bundle.getString(key));
								}
								loginModel.setItemsData(hm);
							} catch (Exception e) {
							}
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

		syr = new InfoItemEdt(this, "������������", null, "syr", 1, null, true);
		jcxdh = new InfoItemSp(this, "����ߺ�", "jcxdh", MD_ListItem.Get_xh(),
				null);
		csys = new InfoItemEdt(CarLoginActivity.this, "������ɫ", null, "csys", 1,
				null, true);
		zxzxjxs = new InfoItemSp(this, "������ʽ#", "zxzxjxs",
				MD_ListItem.Get_zxzxjxs(), null);
		// qdxs = new InfoItemSp(this, "������ʽ#", "qdxs", MD_ListItem.Get_qdxs(),
		// null);
		// ��������ʽ�����Ϊ�����ᣬ��ɲ�ᡣ�����������ֳ�Ħ�г�
		qdxs = new InfoItemSp(this, "������#", "qdxs", MD_ListItem.Get_qdz(), null);
		zczw = new InfoItemSp(this, "��ɲ��#", "zczw", MD_ListItem.Get_qdz(), null);
		zs = new InfoItemSp(this, "����*", "zs", getResources().getStringArray(
				R.array.zs), null);
		jcxlb = new InfoItemSp(this, "��������#", "jcxlb",
				MD_ListItem.Get_Jcxlb(), null);
		qzdz = new InfoItemSp(this, "ǰ�յ���#", "qzdz", MD_ListItem.Get_dz(), null);
		ygddtz = new InfoItemSp(this, "Զ�ⵥ������#", "ygddtz",
				MD_ListItem.Get_ygddtz(), null);
		ccrq = new InfoItemDate(this, "ccrq", "��������*");
		clpp1 = new InfoItemEdt(this, "����Ʒ��*", null, "clpp1", 1, null, false);
		cwkk = new InfoItemEdt(this, "��������*", " mm", "cwkk", 2 | 8192, null,
				false);
		cwkc = new InfoItemEdt(this, "��������*", " mm", "cwkc", 2 | 8192, null,
				false);
		cwkg = new InfoItemEdt(this, "��������*", " mm", "cwkg", 2 | 8192, null,
				false);
		hxnbcd = new InfoItemEdt(this, "�����ڲ�����", " mm", "hxnbcd", 2 | 8192,
				null, true);
		hxnbkd = new InfoItemEdt(this, "�����ڲ����", " mm", "hxnbkd", 2 | 8192,
				null, true);
		hxnbgd = new InfoItemEdt(this, "�����ڲ��߶�", " mm", "hxnbgd", 2 | 8192,
				null, true);
		zzl = new InfoItemEdt(this, "������*", " kg", "zzl", 2 | 8192,
				"^[0-9\\.]{1,5}$", false);
		zbzl = new InfoItemEdt(this, "��������*", " kg", "0", "zbzl", 2 | 8192,
				"^[0-9\\.]{1,5}$", false);
		ltgg = new InfoItemEdt(this, "��̥���", null, "ltgg", 1, null, true);
		lcbds = new InfoItemEdt(this, "��̱���#", "km", "lcbds", 2,
				"^[0-9]{1,9}$", false);
		fzjg = new InfoItemEdt(this, "��֤����*", null, "fzjg", 1, null, false);
		dlysfzh = new InfoItemEdt(this, "��¼Ա(���֤��)#", null, "dlysfzh", 1, null,
				false);
		/** ��ѡ������Ŀ **/
		if (Md_system.getSfgxjyxm().equals("��")) {
			F1 = new InfoItemChk(this, "������ۼ���", "F1", false);
			C1 = new InfoItemChk(this, "���̼���", "C1", false);
			DC = new InfoItemChk(this, "��̬���̼���", "DC", false);
			B1 = new InfoItemChk(this, "һ���ƶ�", "B1", false);
			B2 = new InfoItemChk(this, "�����ƶ�", "B2", false);
			B3 = new InfoItemChk(this, "�����ƶ�", "B3", false);
			B4 = new InfoItemChk(this, "�����ƶ�", "B4", false);
			B5 = new InfoItemChk(this, "�����ƶ�", "B5", false);
			B6 = new InfoItemChk(this, "�����ƶ�", "B6", false);
			B0 = new InfoItemChk(this, "פ���ƶ�", "B0", false);
			H1 = new InfoItemChk(this, "����ƻ�����ֻ����������", "H1", false);
			H2 = new InfoItemChk(this, "���ڵ�", "H2", false);
			H3 = new InfoItemChk(this, "���ڵ�", "H3", false);
			H4 = new InfoItemChk(this, "����ƻ�����ֻ��������ҵ�", "H4", false);
			S1 = new InfoItemChk(this, "���ٱ�", "S1", false);
			A1 = new InfoItemChk(this, "�໬���������������ƫ", "A1", false);
			R1 = new InfoItemChk(this, "·���ƶ�", "R1", false);
			R2 = new InfoItemChk(this, "·���µ�פ��", "R2", false);
			R3 = new InfoItemChk(this, "·�Գ��ٱ�", "R3", false);
		}
		/**
		 * ��ѡ�ۼ������Ŀ
		 */
		if (Md_system.getSfzj().equals("��")) {
			Grade = new InfoItemChk(this, "�ȼ�����", "grade", false);
			Ejwh = new InfoItemChk(this, "����ά��", "ejwh", false);
			Repair = new InfoItemChk(this, "���޿���", "repair", false);
		}
		/** ������Ϣ **/
		if (Md_system.getSfhj().equals("��")) {
			clyt = new InfoItemSp(this, "������;", "clyt", MD_ListItem.Get_clyt(),
					null);
			obddsfzc = new InfoItemSp(this, "ODB���Ƿ�����", "obddsfzc",
					MD_ListItem.Get_pdsf(), null);
			hbbz = new InfoItemSp(this, "������־", "hbbz", MD_ListItem.Get_hbbz(),
					null);
			rllb = new InfoItemSp(this, "ȼ�����", "rllb", MD_ListItem.Get_rylb(),
					null);
			gyfs = new InfoItemSp(this, "���ͷ�ʽ", "gyfs", MD_ListItem.Get_gyfs(),
					null);
			pfbz = new InfoItemSp(this, "�ŷű�׼", "pfbz", MD_ListItem.Get_pfbz(),
					null);
			jqfs = new InfoItemSp(this, "������ʽ", "jqfs", MD_ListItem.Get_jqfs(),
					null);
			hbjcbz = new InfoItemSp(this, "��������׼", "hbjcbz",
					MD_ListItem.Get_hbjcbz(), null);
			sfgz = new InfoItemSp(this, "�Ƿ����", "sfgz", MD_ListItem.Get_sfgz(),
					null);
			sfyobd = new InfoItemSp(this, "�Ƿ���ODB", "sfyobd",
					MD_ListItem.Get_pdsf(), new OnItemSelectedListener() {
						@Override
						public void onItemSelected(AdapterView<?> parent,
								View view, int position, long id) {
							if (position == 1) {
								obddsfzc.setData("��");
							} else {
								obddsfzc.setData("��");
							}
						}

						@Override
						public void onNothingSelected(AdapterView<?> arg0) {

						}
					});
			bsx = new InfoItemSp(this, "������", "bsx", MD_ListItem.Get_bsx(),
					null);
			obdgzm = new InfoItemEdt(this, "ODB������", null, "obdgzm", 1, null,
					true);
			hbbh = new InfoItemEdt(this, "�������", null, "hbbh", 2 | 8192, null,
					true);
			gs = new InfoItemEdt(this, "����", null, "gs", 2 | 8192, null, true);
			zsitem = new InfoItemEdt(this, "ת��", null, "zs", 2 | 8192, null,
					true);
			pl = new InfoItemEdt(this, "����", " ML", "pl", 2 | 8192, null, true);
		}
		gl = new InfoItemEdt(this, "����", " KW", "gl", 2 | 8192, null, true);
		rlzl = new InfoItemSp(this, "ȼ������", "rlzl", MD_ListItem.Get_rlzl(),
				null);
		hdzk = new InfoItemEdt(this, "�˶��ؿ�����", " ��", "hdzk", 1, "^[0-9]{1,5}$",
				true);
		zzs = new InfoItemSp(this, "������", "zzs", getResources().getStringArray(
				R.array.zs), null);
		zzly = new InfoItemSp(this, "�ƶ���Դ", "zzly", MD_ListItem.Get_zzly(),
				null);
		xh = new InfoItemEdt(this, "���������", null, "xh", 1, null, true);
		clyt1 = new InfoItemEdt(this, "������;", null, "clyt", 1, null, true);
		sjr = new InfoItemEdt(this, "�ͼ��ˣ�������", null, "sjr", 1, null, true);
		sjrsfzh = new InfoItemEdt(this, "�ͼ������֤��", null, "sjrsfzh", 1, null,
				true);
		ytsx = new InfoItemEdt(this, "��;����", null, "ytsx", 1, null, true);
		fdjh = new InfoItemEdt(this, "��������", null, "fdjh", 1, null, true);
		jyhgbzbh = new InfoItemEdt(this, "����ϸ��־", null, "jyhgbzbh", 1, null,
				true);
		hdzzl = new InfoItemEdt(this, "�˶�������", "  kg ", "hdzzl", 2 | 8192,
				"^[0-9\\.]{1,6}$", true);
		zj = new InfoItemEdt(this, "��൥λ", " mm", "zj", 2 | 8192, null, true);
		qlj = new InfoItemEdt(this, "ǰ�־൥λ", " mm", "qlj", 2 | 8192, null, true);
		hlj = new InfoItemEdt(this, "���־൥λ", " mm", "hlj", 2 | 8192, null, true);
		ccdjrq = new InfoItemDate(this, "ccdjrq", "���εǼ�����");
		yxqz = new InfoItemDate(this, "yxqz", "������Ч��ֹ");
		bxzzrq = new InfoItemDate(this, "bxzzrq", "������ֹ����");

		gbthps = new InfoItemEdt(this, "�ְ嵯��Ƭ��", " Ƭ", "gbthps", 2 | 8192,
				null, true);
		lts = new InfoItemEdt(this, "��̥��", " ��", "lts", 2 | 8192, null, true);
		glbm = new InfoItemEdt(this, "������", null, "glbm", 1, null, true);
		zzg = new InfoItemEdt(this, "�����", null, "zzg", 1, null, true);
		fdjxh = new InfoItemEdt(this, "�������ͺ�", null, "fdjxh", 1, null, true);
		gcjk = new InfoItemEdt(this, "����/����", null, "gcjk", 1, null, true);
		sfzmhm = new InfoItemEdt(this, "���֤������", null, "sfzmhm", 1, null, true);
		hbdbqk = new InfoItemEdt(this, "����������", null, "hbdbqk", 1, null, true);
		xszbh = new InfoItemEdt(this, "��ʻ֤֤о���", null, "xszbh", 1, null, true);
		qpzk = new InfoItemEdt(this, "ǰ���ؿ�����", " ��", "qpzk", 2 | 8192,
				"^[0-9]{1,5}$", true);
		hpzk = new InfoItemEdt(this, "�����ؿ�����", " ��", "hpzk", 2 | 8192,
				"^[0-9]{1,5}$", true);
		sfzmmc = new InfoItemEdt(this, "���֤������", null, "sfzmmc", 1, null, true);
		clpp2 = new InfoItemEdt(this, "Ӣ��Ʒ��", null, "clpp2", 1, null, true);
		zqyzl = new InfoItemEdt(this, "׼ǣ��������", " kg", "zqyzl", 2 | 8192, null,
				true);
		zzcmc = new InfoItemEdt(this, "���쳧����", null, "zzcmc", 1, null, true);
		zxxs = new InfoItemEdt(this, "ת����ʽ", null, "zxxs", 1, null, true);
		djrq = new InfoItemDate(this, "djrq", "�����������");
		qzbfqz = new InfoItemDate(this, "qzbfqz", "ǿ�Ʊ�����ֹ");
		dybj = new InfoItemSp(this, "��Ѻ���", "dybj", MD_ListItem.Get_dybj(),
				null);
		// ��ʼ����
		if (Md_system.getSfhj().equals("��")) {
			if (Md_system.getSfgxjyxm().equals("��")) {
				if (Md_system.getSfzj().equals("��")) {
					this.loginModel
							.initItemBars(new String[] { "�ۼ������Ŀ", "����������Ϣ��",
									"����������Ϣһ", "���������Ϣ", "���������Ŀ", "������¼��Ϣ" });

					/** ������¼��Ϣ **/
					this.loginModel.addItem(5, jclbItem); // ���� ������
					this.loginModel.addItem(5, jylbzlfdjItem); // ����������Ƕ���
					this.loginModel.addItem(5, jylbzllsjyItem); // ������������ʱ����
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(5, hphmItem); // ���� ���ƺ���
					this.loginModel.addItem(5, hpzlItem); // ��������
					this.loginModel.addItem(5, vinItem); // ���� vin
					this.loginModel.addItem(5, clxhItem); // �ͺ�
					this.loginModel.addItem(5, clsslbmoth(true));// c���߳�����
																	// �����������
					this.loginModel.addItem(5, cllxItem); // ��������
					this.loginModel.addItem(5, syxzItem); // ʹ������
					this.loginModel.addItem(5, syr);
					this.loginModel.addItem(5, jcxdh);
					this.loginModel.addItem(5, csys);
					this.loginModel.addItem(5, zxzxjxs);
					this.loginModel.addItem(5, qdxs);
					this.loginModel.addItem(5, zczw);
					this.loginModel.addItem(5, zs);
					this.loginModel.addItem(5, sfqszxzItem); // �Ƿ�˫��ת��
					this.loginModel.addItem(5, jcxlb);
					this.loginModel.addItem(5, qzdz);
					this.loginModel.addItem(5, ygddtz);
					this.loginModel.addItem(5, ccrq);
					this.loginModel.addItem(5, clpp1); // ����
					this.loginModel.addItem(5, cwkk);
					this.loginModel.addItem(5, cwkc);
					this.loginModel.addItem(5, cwkg);
					this.loginModel.addItem(5, hxnbcd);
					this.loginModel.addItem(5, hxnbkd);
					this.loginModel.addItem(5, hxnbgd);
					this.loginModel.addItem(5, zzl);
					this.loginModel.addItem(5, zbzl);
					this.loginModel.addItem(5, ltgg);
					this.loginModel.addItem(5, lcbds);
					this.loginModel.addItem(5, fzjg);
					this.loginModel.addItem(5, dlysfzh);
					/* ������Ŀ */
					this.loginModel.addItem(4, F1);
					this.loginModel.addItem(4, C1);
					this.loginModel.addItem(4, DC);
					this.loginModel.addItem(4, B1);
					this.loginModel.addItem(4, B2);
					this.loginModel.addItem(4, B3);
					this.loginModel.addItem(4, B4);
					this.loginModel.addItem(4, B5);
					this.loginModel.addItem(4, B6);
					this.loginModel.addItem(4, B0);
					this.loginModel.addItem(4, H1);
					this.loginModel.addItem(4, H2);
					this.loginModel.addItem(4, H3);
					this.loginModel.addItem(4, H4);
					this.loginModel.addItem(4, S1);
					this.loginModel.addItem(4, A1);
					this.loginModel.addItem(4, R1);
					this.loginModel.addItem(4, R2);
					this.loginModel.addItem(4, R3);
					/** �������� **/

					this.loginModel.addItem(3, clyt);
					this.loginModel.addItem(3, hbbz);
					this.loginModel.addItem(3, rllb);
					this.loginModel.addItem(3, gyfs);
					this.loginModel.addItem(3, pfbz);
					this.loginModel.addItem(3, jqfs);
					this.loginModel.addItem(3, hbjcbz);
					this.loginModel.addItem(3, sfgz);
					this.loginModel.addItem(3, sfyobd);
					this.loginModel.addItem(3, obddsfzc);
					this.loginModel.addItem(3, bsx);
					this.loginModel.addItem(3, obdgzm);
					this.loginModel.addItem(3, hbbh);
					this.loginModel.addItem(3, gs);
					this.loginModel.addItem(3, zsitem);
					this.loginModel.addItem(3, pl);
					/** ����������Ϣ **/
					this.loginModel.addItem(2, gl);
					this.loginModel.addItem(2, hdzk);
					this.loginModel.addItem(2, zzs);
					this.loginModel.addItem(2, rlzl);
					this.loginModel.addItem(2, zzly);
					this.loginModel.addItem(2, xh);
					this.loginModel.addItem(2, clyt1);
					this.loginModel.addItem(2, sjr);
					this.loginModel.addItem(2, sjrsfzh);
					this.loginModel.addItem(2, ytsx);
					this.loginModel.addItem(2, fdjh);
					this.loginModel.addItem(2, jyhgbzbh);
					this.loginModel.addItem(2, hdzzl);
					this.loginModel.addItem(2, zj);
					this.loginModel.addItem(2, qlj);
					this.loginModel.addItem(2, hlj);
					this.loginModel.addItem(2, ccdjrq);
					this.loginModel.addItem(2, yxqz);
					this.loginModel.addItem(2, bxzzrq);
					// ����������Ϣ��
					this.loginModel.addItem(1, WZItem);
					this.loginModel.addItem(1, gbthps);
					this.loginModel.addItem(1, lts);
					this.loginModel.addItem(1, glbm);
					this.loginModel.addItem(1, zzg);
					this.loginModel.addItem(1, fdjxh);
					this.loginModel.addItem(1, gcjk);
					this.loginModel.addItem(1, sfzmhm);
					this.loginModel.addItem(1, hbdbqk);
					this.loginModel.addItem(1, xszbh);
					this.loginModel.addItem(1, qpzk);
					this.loginModel.addItem(1, hpzk);
					this.loginModel.addItem(1, sfzmmc);
					this.loginModel.addItem(1, clpp2);
					this.loginModel.addItem(1, zqyzl);
					this.loginModel.addItem(1, zzcmc);
					this.loginModel.addItem(1, zxxs);
					this.loginModel.addItem(1, djrq);
					this.loginModel.addItem(1, qzbfqz);
					this.loginModel.addItem(1, dybj);
					// �ۼ������Ŀ
					this.loginModel.addItem(0, Grade);
					this.loginModel.addItem(0, Ejwh);
					this.loginModel.addItem(0, Repair);
				} else {
					this.loginModel.initItemBars(new String[] { "����������Ϣ��",
							"����������Ϣһ", "���������Ϣ", "���������Ŀ", "������¼��Ϣ" });
					/** ������¼��Ϣ **/
					this.loginModel.addItem(4, jclbItem); // ���� ������
					this.loginModel.addItem(4, jylbzlfdjItem); // ����������Ƕ���
					this.loginModel.addItem(4, jylbzllsjyItem); // ������������ʱ����
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(4, hphmItem); // ���� ���ƺ���
					this.loginModel.addItem(4, hpzlItem); // ��������
					this.loginModel.addItem(4, vinItem); // ���� vin
					this.loginModel.addItem(4, clxhItem); // �ͺ�
					this.loginModel.addItem(4, clsslbmoth(true));// c���߳�����
																	// �����������
					this.loginModel.addItem(4, cllxItem); // ��������
					this.loginModel.addItem(4, syxzItem); // ʹ������
					this.loginModel.addItem(4, syr);
					this.loginModel.addItem(4, jcxdh);
					this.loginModel.addItem(4, csys);
					this.loginModel.addItem(4, zxzxjxs);
					this.loginModel.addItem(4, qdxs);
					this.loginModel.addItem(4, zczw);
					this.loginModel.addItem(4, zs);
					this.loginModel.addItem(4, sfqszxzItem); // �Ƿ�˫��ת��
					this.loginModel.addItem(4, jcxlb);
					this.loginModel.addItem(4, qzdz);
					this.loginModel.addItem(4, ygddtz);
					this.loginModel.addItem(4, ccrq);
					this.loginModel.addItem(4, clpp1); // ����
					this.loginModel.addItem(4, cwkk);
					this.loginModel.addItem(4, cwkc);
					this.loginModel.addItem(4, cwkg);
					this.loginModel.addItem(4, hxnbcd);
					this.loginModel.addItem(4, hxnbkd);
					this.loginModel.addItem(4, hxnbgd);
					this.loginModel.addItem(4, zzl);
					this.loginModel.addItem(4, zbzl);
					this.loginModel.addItem(4, ltgg);
					this.loginModel.addItem(4, lcbds);
					this.loginModel.addItem(4, fzjg);
					this.loginModel.addItem(4, dlysfzh);
					/* ������Ŀ */
					this.loginModel.addItem(3, F1);
					this.loginModel.addItem(3, C1);
					this.loginModel.addItem(3, DC);
					this.loginModel.addItem(3, B1);
					this.loginModel.addItem(3, B2);
					this.loginModel.addItem(3, B3);
					this.loginModel.addItem(3, B4);
					this.loginModel.addItem(3, B5);
					this.loginModel.addItem(3, B6);
					this.loginModel.addItem(3, B0);
					this.loginModel.addItem(3, H1);
					this.loginModel.addItem(3, H2);
					this.loginModel.addItem(3, H3);
					this.loginModel.addItem(3, H4);
					this.loginModel.addItem(3, S1);
					this.loginModel.addItem(3, A1);
					this.loginModel.addItem(3, R1);
					this.loginModel.addItem(3, R2);
					this.loginModel.addItem(3, R3);
					/** �������� **/

					this.loginModel.addItem(2, clyt);
					this.loginModel.addItem(2, hbbz);
					this.loginModel.addItem(2, rllb);
					this.loginModel.addItem(2, gyfs);
					this.loginModel.addItem(2, pfbz);
					this.loginModel.addItem(2, jqfs);
					this.loginModel.addItem(2, hbjcbz);
					this.loginModel.addItem(2, sfgz);
					this.loginModel.addItem(2, sfyobd);
					this.loginModel.addItem(2, obddsfzc);
					this.loginModel.addItem(2, bsx);
					this.loginModel.addItem(2, obdgzm);
					this.loginModel.addItem(2, hbbh);
					this.loginModel.addItem(2, gs);
					this.loginModel.addItem(2, zsitem);
					this.loginModel.addItem(2, pl);
					/** ����������Ϣ **/
					this.loginModel.addItem(1, gl);
					this.loginModel.addItem(1, hdzk);
					this.loginModel.addItem(1, zzs);
					this.loginModel.addItem(1, rlzl);
					this.loginModel.addItem(1, zzly);
					this.loginModel.addItem(1, xh);
					this.loginModel.addItem(1, clyt1);
					this.loginModel.addItem(1, sjr);
					this.loginModel.addItem(1, sjrsfzh);
					this.loginModel.addItem(1, ytsx);
					this.loginModel.addItem(1, fdjh);
					this.loginModel.addItem(1, jyhgbzbh);
					this.loginModel.addItem(1, hdzzl);
					this.loginModel.addItem(1, zj);
					this.loginModel.addItem(1, qlj);
					this.loginModel.addItem(1, hlj);
					this.loginModel.addItem(1, ccdjrq);
					this.loginModel.addItem(1, yxqz);
					this.loginModel.addItem(1, bxzzrq);
					// ����������Ϣ��
					this.loginModel.addItem(0, WZItem);
					this.loginModel.addItem(0, gbthps);
					this.loginModel.addItem(0, lts);
					this.loginModel.addItem(0, glbm);
					this.loginModel.addItem(0, zzg);
					this.loginModel.addItem(0, fdjxh);
					this.loginModel.addItem(0, gcjk);
					this.loginModel.addItem(0, sfzmhm);
					this.loginModel.addItem(0, hbdbqk);
					this.loginModel.addItem(0, xszbh);
					this.loginModel.addItem(0, qpzk);
					this.loginModel.addItem(0, hpzk);
					this.loginModel.addItem(0, sfzmmc);
					this.loginModel.addItem(0, clpp2);
					this.loginModel.addItem(0, zqyzl);
					this.loginModel.addItem(0, zzcmc);
					this.loginModel.addItem(0, zxxs);
					this.loginModel.addItem(0, djrq);
					this.loginModel.addItem(0, qzbfqz);
					this.loginModel.addItem(0, dybj);
				}
			} else {
				if (Md_system.getSfzj().equals("��")) {
					this.loginModel.initItemBars(new String[] { "�ۼ������Ŀ",
							"����������Ϣ��", "����������Ϣһ", "���������Ϣ", "������¼��Ϣ" });
					/** ������¼��Ϣ **/
					this.loginModel.addItem(4, jclbItem); // ���� ������
					this.loginModel.addItem(4, jylbzlfdjItem); // ����������Ƕ���
					this.loginModel.addItem(4, jylbzllsjyItem); // ������������ʱ����
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(4, hphmItem); // ���� ���ƺ���
					this.loginModel.addItem(4, hpzlItem); // ��������
					this.loginModel.addItem(4, vinItem); // ���� vin
					this.loginModel.addItem(4, clxhItem); // �ͺ�
					this.loginModel.addItem(4, clsslbmoth(false));// �ǳ��߳��ص�
																	// �����������
					this.loginModel.addItem(4, cllxItem); // ��������
					this.loginModel.addItem(4, syxzItem); // ʹ������
					this.loginModel.addItem(4, syr);
					this.loginModel.addItem(4, jcxdh);
					this.loginModel.addItem(4, csys);
					this.loginModel.addItem(4, zxzxjxs);
					this.loginModel.addItem(4, qdxs);
					this.loginModel.addItem(4, zczw);
					this.loginModel.addItem(4, zs);
					this.loginModel.addItem(4, sfqszxzItem);
					this.loginModel.addItem(4, jcxlb);
					this.loginModel.addItem(4, qzdz);
					this.loginModel.addItem(4, ygddtz);
					this.loginModel.addItem(4, ccrq);
					this.loginModel.addItem(4, clpp1); // ����
					this.loginModel.addItem(4, cwkk);
					this.loginModel.addItem(4, cwkc);
					this.loginModel.addItem(4, cwkg);
					this.loginModel.addItem(4, hxnbcd);
					this.loginModel.addItem(4, hxnbkd);
					this.loginModel.addItem(4, hxnbgd);
					this.loginModel.addItem(4, zzl);
					this.loginModel.addItem(4, zbzl);
					this.loginModel.addItem(4, ltgg);
					this.loginModel.addItem(4, lcbds);
					this.loginModel.addItem(4, fzjg);
					this.loginModel.addItem(4, dlysfzh);
					/** �������� **/
					this.loginModel.addItem(3, clyt);
					this.loginModel.addItem(3, hbbz);
					this.loginModel.addItem(3, rllb);
					this.loginModel.addItem(3, gyfs);
					this.loginModel.addItem(3, pfbz);
					this.loginModel.addItem(3, jqfs);
					this.loginModel.addItem(3, hbjcbz);
					this.loginModel.addItem(3, sfgz);
					this.loginModel.addItem(3, sfyobd);
					this.loginModel.addItem(3, obddsfzc);
					this.loginModel.addItem(3, bsx);
					this.loginModel.addItem(3, obdgzm);
					this.loginModel.addItem(3, hbbh);
					this.loginModel.addItem(3, gs);
					this.loginModel.addItem(3, zsitem);// ת��
					this.loginModel.addItem(3, pl);
					/** ����������Ϣ **/
					this.loginModel.addItem(2, gl);
					this.loginModel.addItem(2, rlzl);
					this.loginModel.addItem(2, hdzk);
					this.loginModel.addItem(2, zzs);
					// this.loginModel.addItem(1, rlzl);
					this.loginModel.addItem(2, zzly);
					this.loginModel.addItem(2, xh);
					this.loginModel.addItem(2, clyt1);
					this.loginModel.addItem(2, sjr);
					this.loginModel.addItem(2, sjrsfzh);
					this.loginModel.addItem(2, ytsx);
					this.loginModel.addItem(2, fdjh);
					this.loginModel.addItem(2, jyhgbzbh);
					this.loginModel.addItem(2, hdzzl);
					this.loginModel.addItem(2, zj);
					this.loginModel.addItem(2, qlj);
					this.loginModel.addItem(2, hlj);
					this.loginModel.addItem(2, ccdjrq);
					this.loginModel.addItem(2, yxqz);
					this.loginModel.addItem(2, bxzzrq);
					// ����������Ϣ
					this.loginModel.addItem(1, WZItem);
					this.loginModel.addItem(1, gbthps);
					this.loginModel.addItem(1, lts);
					this.loginModel.addItem(1, glbm);
					this.loginModel.addItem(1, zzg);
					this.loginModel.addItem(1, fdjxh);
					this.loginModel.addItem(1, gcjk);
					this.loginModel.addItem(1, sfzmhm);
					this.loginModel.addItem(1, hbdbqk);
					this.loginModel.addItem(1, xszbh);
					this.loginModel.addItem(1, qpzk);
					this.loginModel.addItem(1, hpzk);
					this.loginModel.addItem(1, sfzmmc);
					this.loginModel.addItem(1, clpp2);
					this.loginModel.addItem(1, zqyzl);
					this.loginModel.addItem(1, zzcmc);
					this.loginModel.addItem(1, zxxs);
					this.loginModel.addItem(1, djrq);
					this.loginModel.addItem(1, qzbfqz);
					this.loginModel.addItem(1, dybj);

					this.loginModel.addItem(0, Grade);
					this.loginModel.addItem(0, Ejwh);
					this.loginModel.addItem(0, Repair);
				} else {
					this.loginModel.initItemBars(new String[] { "����������Ϣ��",
							"����������Ϣһ", "���������Ϣ", "������¼��Ϣ" });
					/** ������¼��Ϣ **/
					this.loginModel.addItem(3, jclbItem); // ���� ������
					this.loginModel.addItem(3, jylbzlfdjItem); // ����������Ƕ���
					this.loginModel.addItem(3, jylbzllsjyItem); // ������������ʱ����
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(3, hphmItem); // ���� ���ƺ���
					this.loginModel.addItem(3, hpzlItem); // ��������
					this.loginModel.addItem(3, vinItem); // ���� vin
					this.loginModel.addItem(3, clxhItem); // �ͺ�
					this.loginModel.addItem(3, clsslbmoth(false));// �ǳ��߳��ص�
																	// �����������
					this.loginModel.addItem(3, cllxItem); // ��������
					this.loginModel.addItem(3, syxzItem); // ʹ������
					this.loginModel.addItem(3, syr);
					this.loginModel.addItem(3, jcxdh);
					this.loginModel.addItem(3, csys);
					this.loginModel.addItem(3, zxzxjxs);
					this.loginModel.addItem(3, qdxs);
					this.loginModel.addItem(3, zczw);
					this.loginModel.addItem(3, zs);
					this.loginModel.addItem(3, sfqszxzItem);
					this.loginModel.addItem(3, jcxlb);
					this.loginModel.addItem(3, qzdz);
					this.loginModel.addItem(3, ygddtz);
					this.loginModel.addItem(3, ccrq);
					this.loginModel.addItem(3, clpp1); // ����
					this.loginModel.addItem(3, cwkk);
					this.loginModel.addItem(3, cwkc);
					this.loginModel.addItem(3, cwkg);
					this.loginModel.addItem(3, hxnbcd);
					this.loginModel.addItem(3, hxnbkd);
					this.loginModel.addItem(3, hxnbgd);
					this.loginModel.addItem(3, zzl);
					this.loginModel.addItem(3, zbzl);
					this.loginModel.addItem(3, ltgg);
					this.loginModel.addItem(3, lcbds);
					this.loginModel.addItem(3, fzjg);
					this.loginModel.addItem(3, dlysfzh);
					/** �������� **/
					this.loginModel.addItem(2, clyt);
					this.loginModel.addItem(2, hbbz);
					this.loginModel.addItem(2, rllb);
					this.loginModel.addItem(2, gyfs);
					this.loginModel.addItem(2, pfbz);
					this.loginModel.addItem(2, jqfs);
					this.loginModel.addItem(2, hbjcbz);
					this.loginModel.addItem(2, sfgz);
					this.loginModel.addItem(2, sfyobd);
					this.loginModel.addItem(2, obddsfzc);
					this.loginModel.addItem(2, bsx);
					this.loginModel.addItem(2, obdgzm);
					this.loginModel.addItem(2, hbbh);
					this.loginModel.addItem(2, gs);
					this.loginModel.addItem(2, zsitem);// ת��
					this.loginModel.addItem(2, pl);
					/** ����������Ϣ **/
					this.loginModel.addItem(1, gl);
					this.loginModel.addItem(1, rlzl);
					this.loginModel.addItem(1, hdzk);
					this.loginModel.addItem(1, zzs);
					// this.loginModel.addItem(1, rlzl);
					this.loginModel.addItem(1, zzly);
					this.loginModel.addItem(1, xh);
					this.loginModel.addItem(1, clyt1);
					this.loginModel.addItem(1, sjr);
					this.loginModel.addItem(1, sjrsfzh);
					this.loginModel.addItem(1, ytsx);
					this.loginModel.addItem(1, fdjh);
					this.loginModel.addItem(1, jyhgbzbh);
					this.loginModel.addItem(1, hdzzl);
					this.loginModel.addItem(1, zj);
					this.loginModel.addItem(1, qlj);
					this.loginModel.addItem(1, hlj);
					this.loginModel.addItem(1, ccdjrq);
					this.loginModel.addItem(1, yxqz);
					this.loginModel.addItem(1, bxzzrq);
					// ����������Ϣ��
					this.loginModel.addItem(0, WZItem);
					this.loginModel.addItem(0, gbthps);
					this.loginModel.addItem(0, lts);
					this.loginModel.addItem(0, glbm);
					this.loginModel.addItem(0, zzg);
					this.loginModel.addItem(0, fdjxh);
					this.loginModel.addItem(0, gcjk);
					this.loginModel.addItem(0, sfzmhm);
					this.loginModel.addItem(0, hbdbqk);
					this.loginModel.addItem(0, xszbh);
					this.loginModel.addItem(0, qpzk);
					this.loginModel.addItem(0, hpzk);
					this.loginModel.addItem(0, sfzmmc);
					this.loginModel.addItem(0, clpp2);
					this.loginModel.addItem(0, zqyzl);
					this.loginModel.addItem(0, zzcmc);
					this.loginModel.addItem(0, zxxs);
					this.loginModel.addItem(0, djrq);
					this.loginModel.addItem(0, qzbfqz);
					this.loginModel.addItem(0, dybj);
				}
			}
		} else {
			if (Md_system.getSfgxjyxm().equals("��")) {
				if (Md_system.getSfzj().equals("��")) {
					this.loginModel.initItemBars(new String[] { "�ۼ������Ŀ",
							"����������Ϣ��", "����������Ϣһ", "���������Ŀ", "������¼��Ϣ" });
					/** ������¼��Ϣ **/
					this.loginModel.addItem(4, jclbItem); // ���� ������
					this.loginModel.addItem(4, jylbzlfdjItem); // ����������Ƕ���
					this.loginModel.addItem(4, jylbzllsjyItem); // ������������ʱ����
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(4, hphmItem); // ���� ���ƺ���
					this.loginModel.addItem(4, hpzlItem); // ��������
					this.loginModel.addItem(4, vinItem); // ���� vin
					this.loginModel.addItem(4, clxhItem); // �ͺ�
					this.loginModel.addItem(4, clsslbmoth(true));// ���߳��س����������
					this.loginModel.addItem(4, cllxItem); // ��������
					this.loginModel.addItem(4, syxzItem); // ʹ������
					this.loginModel.addItem(4, syr);
					this.loginModel.addItem(4, jcxdh);
					this.loginModel.addItem(4, csys);
					this.loginModel.addItem(4, zxzxjxs);
					this.loginModel.addItem(4, qdxs);
					this.loginModel.addItem(4, zczw);
					this.loginModel.addItem(4, zs);
					this.loginModel.addItem(4, sfqszxzItem);
					this.loginModel.addItem(4, jcxlb);
					this.loginModel.addItem(4, qzdz);
					this.loginModel.addItem(4, ygddtz);
					this.loginModel.addItem(4, ccrq);
					this.loginModel.addItem(4, clpp1); // ����
					this.loginModel.addItem(4, cwkk);
					this.loginModel.addItem(4, cwkc);
					this.loginModel.addItem(4, cwkg);
					this.loginModel.addItem(4, hxnbcd);
					this.loginModel.addItem(4, hxnbkd);
					this.loginModel.addItem(4, hxnbgd);
					this.loginModel.addItem(4, zzl);
					this.loginModel.addItem(4, zbzl);
					this.loginModel.addItem(4, ltgg);
					this.loginModel.addItem(4, lcbds);
					this.loginModel.addItem(4, fzjg);
					this.loginModel.addItem(4, dlysfzh);
					/* ������Ŀ */
					this.loginModel.addItem(3, F1);
					this.loginModel.addItem(3, C1);
					this.loginModel.addItem(3, DC);
					this.loginModel.addItem(3, B1);
					this.loginModel.addItem(3, B2);
					this.loginModel.addItem(3, B3);
					this.loginModel.addItem(3, B4);
					this.loginModel.addItem(3, B5);
					this.loginModel.addItem(3, B6);
					this.loginModel.addItem(3, B0);
					this.loginModel.addItem(3, H1);
					this.loginModel.addItem(3, H2);
					this.loginModel.addItem(3, H3);
					this.loginModel.addItem(3, H4);
					this.loginModel.addItem(3, S1);
					this.loginModel.addItem(3, A1);
					this.loginModel.addItem(3, R1);
					this.loginModel.addItem(3, R2);
					this.loginModel.addItem(3, R3);
					/** ����������Ϣ **/
					//
					this.loginModel.addItem(2, gl);
					this.loginModel.addItem(2, hdzk);
					this.loginModel.addItem(2, zzs);
					this.loginModel.addItem(2, rlzl);
					this.loginModel.addItem(2, zzly);
					this.loginModel.addItem(2, xh);
					this.loginModel.addItem(2, clyt1);
					this.loginModel.addItem(2, sjr);
					this.loginModel.addItem(2, sjrsfzh);
					this.loginModel.addItem(2, ytsx);
					this.loginModel.addItem(2, fdjh);
					this.loginModel.addItem(2, jyhgbzbh);
					this.loginModel.addItem(2, hdzzl);
					this.loginModel.addItem(2, zj);
					this.loginModel.addItem(2, qlj);
					this.loginModel.addItem(2, hlj);
					this.loginModel.addItem(2, ccdjrq);
					this.loginModel.addItem(2, yxqz);
					this.loginModel.addItem(2, bxzzrq);
					// ����������Ϣ��
					this.loginModel.addItem(1, WZItem);
					this.loginModel.addItem(1, gbthps);
					this.loginModel.addItem(1, lts);
					this.loginModel.addItem(1, glbm);
					this.loginModel.addItem(1, zzg);
					this.loginModel.addItem(1, fdjxh);
					this.loginModel.addItem(1, gcjk);
					this.loginModel.addItem(1, sfzmhm);
					this.loginModel.addItem(1, hbdbqk);
					this.loginModel.addItem(1, xszbh);
					this.loginModel.addItem(1, qpzk);
					this.loginModel.addItem(1, hpzk);
					this.loginModel.addItem(1, sfzmmc);
					this.loginModel.addItem(1, clpp2);
					this.loginModel.addItem(1, zqyzl);
					this.loginModel.addItem(1, zzcmc);
					this.loginModel.addItem(1, zxxs);
					this.loginModel.addItem(1, djrq);
					this.loginModel.addItem(1, qzbfqz);
					this.loginModel.addItem(1, dybj);
					this.loginModel.addItem(0, Grade);
					this.loginModel.addItem(0, Ejwh);
					this.loginModel.addItem(0, Repair);
				} else {
					this.loginModel.initItemBars(new String[] { "����������Ϣ��",
							"����������Ϣһ", "���������Ŀ", "������¼��Ϣ" });
					/** ������¼��Ϣ **/
					this.loginModel.addItem(3, jclbItem); // ���� ������
					this.loginModel.addItem(3, jylbzlfdjItem); // ����������Ƕ���
					this.loginModel.addItem(3, jylbzllsjyItem); // ������������ʱ����
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(3, hphmItem); // ���� ���ƺ���
					this.loginModel.addItem(3, hpzlItem); // ��������
					this.loginModel.addItem(3, vinItem); // ���� vin
					this.loginModel.addItem(3, clxhItem); // �ͺ�
					this.loginModel.addItem(3, clsslbmoth(true));// ���߳��س����������
					this.loginModel.addItem(3, cllxItem); // ��������
					this.loginModel.addItem(3, syxzItem); // ʹ������
					this.loginModel.addItem(3, syr);
					this.loginModel.addItem(3, jcxdh);
					this.loginModel.addItem(3, csys);
					this.loginModel.addItem(3, zxzxjxs);
					this.loginModel.addItem(3, qdxs);
					this.loginModel.addItem(3, zczw);
					this.loginModel.addItem(3, zs);
					this.loginModel.addItem(3, sfqszxzItem);
					this.loginModel.addItem(3, jcxlb);
					this.loginModel.addItem(3, qzdz);
					this.loginModel.addItem(3, ygddtz);
					this.loginModel.addItem(3, ccrq);
					this.loginModel.addItem(3, clpp1); // ����
					this.loginModel.addItem(3, cwkk);
					this.loginModel.addItem(3, cwkc);
					this.loginModel.addItem(3, cwkg);
					this.loginModel.addItem(3, hxnbcd);
					this.loginModel.addItem(3, hxnbkd);
					this.loginModel.addItem(3, hxnbgd);
					this.loginModel.addItem(3, zzl);
					this.loginModel.addItem(3, zbzl);
					this.loginModel.addItem(3, ltgg);
					this.loginModel.addItem(3, lcbds);
					this.loginModel.addItem(3, fzjg);
					this.loginModel.addItem(3, dlysfzh);
					/* ������Ŀ */
					this.loginModel.addItem(2, F1);
					this.loginModel.addItem(2, C1);
					this.loginModel.addItem(2, DC);
					this.loginModel.addItem(2, B1);
					this.loginModel.addItem(2, B2);
					this.loginModel.addItem(2, B3);
					this.loginModel.addItem(2, B4);
					this.loginModel.addItem(2, B5);
					this.loginModel.addItem(2, B6);
					this.loginModel.addItem(2, B0);
					this.loginModel.addItem(2, H1);
					this.loginModel.addItem(2, H2);
					this.loginModel.addItem(2, H3);
					this.loginModel.addItem(2, H4);
					this.loginModel.addItem(2, S1);
					this.loginModel.addItem(2, A1);
					this.loginModel.addItem(2, R1);
					this.loginModel.addItem(2, R2);
					this.loginModel.addItem(2, R3);
					/** ����������Ϣ **/
					//
					this.loginModel.addItem(1, gl);
					this.loginModel.addItem(1, hdzk);
					this.loginModel.addItem(1, zzs);
					this.loginModel.addItem(1, rlzl);
					this.loginModel.addItem(1, zzly);
					this.loginModel.addItem(1, xh);
					this.loginModel.addItem(1, clyt1);
					this.loginModel.addItem(1, sjr);
					this.loginModel.addItem(1, sjrsfzh);
					this.loginModel.addItem(1, ytsx);
					this.loginModel.addItem(1, fdjh);
					this.loginModel.addItem(1, jyhgbzbh);
					this.loginModel.addItem(1, hdzzl);
					this.loginModel.addItem(1, zj);
					this.loginModel.addItem(1, qlj);
					this.loginModel.addItem(1, hlj);
					this.loginModel.addItem(1, ccdjrq);
					this.loginModel.addItem(1, yxqz);
					this.loginModel.addItem(1, bxzzrq);
					// ����������Ϣ��
					this.loginModel.addItem(0, WZItem);
					this.loginModel.addItem(0, gbthps);
					this.loginModel.addItem(0, lts);
					this.loginModel.addItem(0, glbm);
					this.loginModel.addItem(0, zzg);
					this.loginModel.addItem(0, fdjxh);
					this.loginModel.addItem(0, gcjk);
					this.loginModel.addItem(0, sfzmhm);
					this.loginModel.addItem(0, hbdbqk);
					this.loginModel.addItem(0, xszbh);
					this.loginModel.addItem(0, qpzk);
					this.loginModel.addItem(0, hpzk);
					this.loginModel.addItem(0, sfzmmc);
					this.loginModel.addItem(0, clpp2);
					this.loginModel.addItem(0, zqyzl);
					this.loginModel.addItem(0, zzcmc);
					this.loginModel.addItem(0, zxxs);
					this.loginModel.addItem(0, djrq);
					this.loginModel.addItem(0, qzbfqz);
					this.loginModel.addItem(0, dybj);
				}
			} else {
				if (Md_system.getSfzj().equals("��")) {
					this.loginModel.initItemBars(new String[] { "�ۼ������Ŀ",
							"����������Ϣ��", "����������Ϣһ", "������¼��Ϣ" });

					/** ������¼��Ϣ **/
					this.loginModel.addItem(3, jclbItem); // ���� ������
					this.loginModel.addItem(3, jylbzlfdjItem); // ����������Ƕ���
					this.loginModel.addItem(3, jylbzllsjyItem); // ������������ʱ����
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(3, hphmItem); // ���� ���ƺ���
					this.loginModel.addItem(3, hpzlItem); // ��������
					this.loginModel.addItem(3, vinItem); // ���� vin
					this.loginModel.addItem(3, clxhItem); // �ͺ�
					this.loginModel.addItem(3, clsslbmoth(false));// �ǳ��� �����������
					this.loginModel.addItem(3, cllxItem); // ��������
					this.loginModel.addItem(3, syxzItem); // ʹ������
					this.loginModel.addItem(3, syr);
					this.loginModel.addItem(3, jcxdh);
					this.loginModel.addItem(3, csys);
					this.loginModel.addItem(3, zxzxjxs);
					this.loginModel.addItem(3, qdxs);
					this.loginModel.addItem(3, zczw);
					this.loginModel.addItem(3, zs);
					this.loginModel.addItem(3, sfqszxzItem);
					this.loginModel.addItem(3, jcxlb);
					this.loginModel.addItem(3, qzdz);
					this.loginModel.addItem(3, ygddtz);
					this.loginModel.addItem(3, ccrq);
					this.loginModel.addItem(3, clpp1); // ����
					this.loginModel.addItem(3, cwkk);
					this.loginModel.addItem(3, cwkc);
					this.loginModel.addItem(3, cwkg);
					this.loginModel.addItem(3, hxnbcd);
					this.loginModel.addItem(3, hxnbkd);
					this.loginModel.addItem(3, hxnbgd);
					this.loginModel.addItem(3, zzl);
					this.loginModel.addItem(3, zbzl);
					this.loginModel.addItem(3, ltgg);
					this.loginModel.addItem(3, lcbds);
					this.loginModel.addItem(3, fzjg);
					this.loginModel.addItem(3, dlysfzh);
					/** ����������Ϣ **/
					this.loginModel.addItem(2, gl);
					this.loginModel.addItem(2, rlzl);
					this.loginModel.addItem(2, hdzk);
					this.loginModel.addItem(2, zzs);
					this.loginModel.addItem(2, zzly);
					this.loginModel.addItem(2, xh);
					this.loginModel.addItem(2, clyt1);
					this.loginModel.addItem(2, sjr);
					this.loginModel.addItem(2, sjrsfzh);
					this.loginModel.addItem(2, ytsx);
					this.loginModel.addItem(2, fdjh);
					this.loginModel.addItem(2, jyhgbzbh);
					this.loginModel.addItem(2, hdzzl);
					this.loginModel.addItem(2, zj);
					this.loginModel.addItem(2, qlj);
					this.loginModel.addItem(2, hlj);
					this.loginModel.addItem(2, ccdjrq);
					this.loginModel.addItem(2, yxqz);
					this.loginModel.addItem(2, bxzzrq);
					// ����������Ϣ��
					this.loginModel.addItem(1, WZItem);
					this.loginModel.addItem(1, gbthps);
					this.loginModel.addItem(1, lts);
					this.loginModel.addItem(1, glbm);
					this.loginModel.addItem(1, zzg);
					this.loginModel.addItem(1, fdjxh);
					this.loginModel.addItem(1, gcjk);
					this.loginModel.addItem(1, sfzmhm);
					this.loginModel.addItem(1, hbdbqk);
					this.loginModel.addItem(1, xszbh);
					this.loginModel.addItem(1, qpzk);
					this.loginModel.addItem(1, hpzk);
					this.loginModel.addItem(1, sfzmmc);
					this.loginModel.addItem(1, clpp2);
					this.loginModel.addItem(1, zqyzl);
					this.loginModel.addItem(1, zzcmc);
					this.loginModel.addItem(1, zxxs);
					this.loginModel.addItem(1, djrq);
					this.loginModel.addItem(1, qzbfqz);
					this.loginModel.addItem(1, dybj);

					this.loginModel.addItem(0, Grade);
					this.loginModel.addItem(0, Ejwh);
					this.loginModel.addItem(0, Repair);
				} else {
					this.loginModel.initItemBars(new String[] { "����������Ϣ��",
							"����������Ϣһ", "������¼��Ϣ" });

					/** ������¼��Ϣ **/
					this.loginModel.addItem(2, jclbItem); // ���� ������
					this.loginModel.addItem(2, jylbzlfdjItem); // ����������Ƕ���
					this.loginModel.addItem(2, jylbzllsjyItem); // ������������ʱ����
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(2, hphmItem); // ���� ���ƺ���
					this.loginModel.addItem(2, hpzlItem); // ��������
					this.loginModel.addItem(2, vinItem); // ���� vin
					this.loginModel.addItem(2, clxhItem); // �ͺ�
					this.loginModel.addItem(2, clsslbmoth(false));// �ǳ��� �����������
					this.loginModel.addItem(2, cllxItem); // ��������
					this.loginModel.addItem(2, syxzItem); // ʹ������
					this.loginModel.addItem(2, syr);
					this.loginModel.addItem(2, jcxdh);
					this.loginModel.addItem(2, csys);
					this.loginModel.addItem(2, zxzxjxs);
					this.loginModel.addItem(2, qdxs);
					this.loginModel.addItem(2, zczw);
					this.loginModel.addItem(2, zs);
					this.loginModel.addItem(2, sfqszxzItem);
					this.loginModel.addItem(2, jcxlb);
					this.loginModel.addItem(2, qzdz);
					this.loginModel.addItem(2, ygddtz);
					this.loginModel.addItem(2, ccrq);
					this.loginModel.addItem(2, clpp1); // ����
					this.loginModel.addItem(2, cwkk);
					this.loginModel.addItem(2, cwkc);
					this.loginModel.addItem(2, cwkg);
					this.loginModel.addItem(2, hxnbcd);
					this.loginModel.addItem(2, hxnbkd);
					this.loginModel.addItem(2, hxnbgd);
					this.loginModel.addItem(2, zzl);
					this.loginModel.addItem(2, zbzl);
					this.loginModel.addItem(2, ltgg);
					this.loginModel.addItem(2, lcbds);
					this.loginModel.addItem(2, fzjg);
					this.loginModel.addItem(2, dlysfzh);
					/** ����������Ϣ **/
					this.loginModel.addItem(1, gl);
					this.loginModel.addItem(1, rlzl);
					this.loginModel.addItem(1, hdzk);
					this.loginModel.addItem(1, zzs);
					this.loginModel.addItem(1, zzly);
					this.loginModel.addItem(1, xh);
					this.loginModel.addItem(1, clyt1);
					this.loginModel.addItem(1, sjr);
					this.loginModel.addItem(1, sjrsfzh);
					this.loginModel.addItem(1, ytsx);
					this.loginModel.addItem(1, fdjh);
					this.loginModel.addItem(1, jyhgbzbh);
					this.loginModel.addItem(1, hdzzl);
					this.loginModel.addItem(1, zj);
					this.loginModel.addItem(1, qlj);
					this.loginModel.addItem(1, hlj);
					this.loginModel.addItem(1, ccdjrq);
					this.loginModel.addItem(1, yxqz);
					this.loginModel.addItem(1, bxzzrq);
					// ����������Ϣ��
					this.loginModel.addItem(0, WZItem);
					this.loginModel.addItem(0, gbthps);
					this.loginModel.addItem(0, lts);
					this.loginModel.addItem(0, glbm);
					this.loginModel.addItem(0, zzg);
					this.loginModel.addItem(0, fdjxh);
					this.loginModel.addItem(0, gcjk);
					this.loginModel.addItem(0, sfzmhm);
					this.loginModel.addItem(0, hbdbqk);
					this.loginModel.addItem(0, xszbh);
					this.loginModel.addItem(0, qpzk);
					this.loginModel.addItem(0, hpzk);
					this.loginModel.addItem(0, sfzmmc);
					this.loginModel.addItem(0, clpp2);
					this.loginModel.addItem(0, zqyzl);
					this.loginModel.addItem(0, zzcmc);
					this.loginModel.addItem(0, zxxs);
					this.loginModel.addItem(0, djrq);
					this.loginModel.addItem(0, qzbfqz);
					this.loginModel.addItem(0, dybj);
				}
			}
		}
	}

	/**
	 * 
	 * @param iscgcz
	 *            �Ƿ񳬸߳���
	 * @return InfoItem
	 */
	private InfoItem clsslbmoth(boolean iscgcz) {
		if (iscgcz) {
			clsslbItem = new InfoItemSp(this, "�����������#", "clsslb",
					MD_ListItem.Get_clsslb(), new OnItemSelectedListener() {
						@Override
						public void onItemSelected(AdapterView<?> parent,
								View view, int position, long id) {
							if (requestMap != null) {
								requestMap = null;
							}
							if (requesJYXMMap != null) {
								requesJYXMMap = null;
							}
							if (!vinItem.getData().equals("")) {
								if (Md_system.getSfhj().equals("��")) {
									if (Md_system.getSfgxjyxm().equals("��")) {
										loginModel.setItemsDataNull(3);
									}
								} else {
									if (Md_system.getSfgxjyxm().equals("��")) {
										loginModel.setItemsDataNull(2);
									}
								}
								requestMap = new HashMap<String, Object>();
								requesJYXMMap = loginModel
										.getDataNodeAndValue();
								// jylsh
								requesJYXMMap.put("jylsh", "");
								if (jclbItem.getData().equals("01")
										|| jclbItem.getData().equals("00")) {
									requesJYXMMap.put("jylbzl", "");
								}
								requesJYXMMap.put("jyjgbh",
										Md_system.getDzkey());
								requesJYXMMap.put("dly",
										Md_Car_Temp.getTempCar().userxingming);
								if (!Md_system.getSfgxjyxm().equals("��")) {
									requesJYXMMap.put("jyxm", "F1");
								}
								requesJYXMMap.put("ycy", "");
								requesJYXMMap.put("wjy", "");
								requesJYXMMap.put("bhgx", "");
								requesJYXMMap.put("jycs", "1");
								requesJYXMMap.put("dtjyy", "");
								requesJYXMMap.put("dpjyy", "");
								requesJYXMMap.put("ycysfzh", "");
								requesJYXMMap.put("wjysfzh", "");
								requesJYXMMap.put("dtjyysfzh", "");
								requesJYXMMap.put("ccdlsj", "");
								// requesJYXMMap.put("clyt",clyt[model].getData());
								requesJYXMMap.put("dlsj", new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss")
										.format(new Date()));
								requesJYXMMap.put("dpjyysfzh", "");
								requesJYXMMap.put("jyrq", "");
								requestMap.put("vehispara", requesJYXMMap);
								CarLoginActivity.this.request("18Q46",
										requestMap, 0, new String[] { "2" });
							}
						}

						@Override
						public void onNothingSelected(AdapterView<?> parent) {
						}
					});
			return clsslbItem;
		} else {
			clsslbItem = new InfoItemSp(this, "�����������#", "clsslb",
					MD_ListItem.Get_clsslb(), null);
			return clsslbItem;
		}
	}

	/**
	 * ���� MD_Car_Temp ����
	 * 
	 * @param model
	 */
	private void setMD_Car_Temp() {
		Md_Car_Temp.getTempCar().car_hpzl = hpzlItem.getData();
		Md_Car_Temp.getTempCar().car_clsbdh = vinItem.getData();
		Md_Car_Temp.getTempCar().car_hphm = hphmItem.getData();
		Md_Car_Temp.getTempCar().car_lx = cllxItem.getData();
		Md_Car_Temp.getTempCar().car_syxz = syxzItem.getData();
		Md_Car_Temp.getTempCar().car_vin = vinItem.getData();
		if (jclbItem.getData().equals("00")) {
			Md_Car_Temp.getTempCar().sfxc = "0";
		} else {
			Md_Car_Temp.getTempCar().sfxc = "1";
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return true;
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try {
			if ("18C51".equals(jkid)) {
				submitBtn.setEnabled(true);
				List<Md_Car_TongYong> ty = (List<Md_Car_TongYong>) result;
				if (!ty.get(0).code.equals("1")) {
					String sQ = ty.get(0).message;
					DefautDialog.showDialog(
							CarLoginActivity.this,
							CarLoginActivity.this.getResources().getString(
									R.string.SYS_TITLE), ty.get(0).message,
							false, null, null);

				} else {
					if (Md_system.getSfhj().equals("��")) {
						if (requestMap != null) {
							requestMap = null;
						}
						if (requesCarLogintMap != null) {
							requesCarLogintMap = null;
						}
						if (requestMapNode != null) {
							requestMapNode = null;
						}
						requestMapNode = new HashMap<String, Object>();
						requestMap = new HashMap<String, Object>();
						requesCarLogintMap = loginModel
								.getDataNodeAndValueHbxx();
						requesCarLogintMap.put("clsbdh", vinItem.getData());
						requesCarLogintMap.put("gl", gl.getData());
						requestMap.put("hbxx", requesCarLogintMap);
						requestMapNode.put("vehispara", requestMap);
						CarLoginActivity.this.request("18H01", requestMapNode,
								R.string.CAR_LOGIN, new String[] { "1" });
					} else {
						DefautDialog.showDialog(
								CarLoginActivity.this,
								CarLoginActivity.this.getResources().getString(
										R.string.SYS_TITLE), "������¼�ɹ���", false,
								new DefautDialog.OnClickListener() {
									@Override
									public void onClick(DefautDialog dialog,
											View arg0) {
										dialog.dimiss();
										Md_Car_Temp.getTempCar().zdy = false;
										if (Md_Car_Temp.getTempCar().car_jyxm
												.contains("F1")) {
											if (Md_Car_Temp.getTempCar().car_ywcjyxm != null
													&& Md_Car_Temp.getTempCar().car_ywcjyxm
															.contains("F1")) {
												Toast.makeText(
														CarLoginActivity.this,
														"��ۼ������ύ������������������....",
														1000).show();
												Application_Activity
														.goToActivity(
																CarLoginActivity.this,
																Pzlx_Activity.class);
												finish();
											} else {

												if ("�Ĵ�".equals(Md_system.dq)) {
													if (isRGWJ) {
														Application_Activity
																.goToActivity(
																		CarLoginActivity.this,
																		CarPeople_Item_Activity.class);
														finish();
													} else {
														Toast.makeText(
																CarLoginActivity.this,
																"��û�����Ȩ��", 1000)
																.show();
													}
												} else {
													Application_Activity
															.goToActivity(
																	CarLoginActivity.this,
																	CarPeople_Item_Activity.class);
													finish();
												}

											}
										}
									}
								}, null);
					}
				}
			} else if ("18H01".equals(jkid)) {
				DefautDialog.showDialog(
						CarLoginActivity.this,
						CarLoginActivity.this.getResources().getString(
								R.string.SYS_TITLE), "������¼�ɹ���", false,
						new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View arg0) {
								dialog.dimiss();
								Md_Car_Temp.getTempCar().zdy = false;
								if (Md_Car_Temp.getTempCar().car_jyxm
										.contains("F1")) {
									if (Md_Car_Temp.getTempCar().car_ywcjyxm != null
											&& Md_Car_Temp.getTempCar().car_ywcjyxm
													.contains("F1")) {
										Toast.makeText(CarLoginActivity.this,
												"��ۼ������ύ������������������....", 1000)
												.show();
										Application_Activity.goToActivity(
												CarLoginActivity.this,
												Pzlx_Activity.class);
										finish();
									} else {
										if ("�Ĵ�".equals(Md_system.dq)) {
											if (isRGWJ) {
												Application_Activity
														.goToActivity(
																CarLoginActivity.this,
																CarPeople_Item_Activity.class);
												finish();
											} else {
												Toast.makeText(
														CarLoginActivity.this,
														"��û�����Ȩ��", 1000).show();
											}
										} else {
											Application_Activity
													.goToActivity(
															CarLoginActivity.this,
															CarPeople_Item_Activity.class);
											finish();
										}

									}
								}
							}
						}, null);
			} else if ("18Q46".equals(jkid)) {
				HashMap<String, String> hm = (HashMap<String, String>) result;
				if (!hm.get("code").equals("0")
						&& !hm.get("code").equals("$EE")) {
					if (Md_system.getSfhj().equals("��")) {
						if (Md_system.getSfgxjyxm().equals("��")) {
							loginModel.setJYXMItemsData(hm, 3);
						}
					} else {
						if (Md_system.getSfgxjyxm().equals("��")) {
							loginModel.setJYXMItemsData(hm, 2);
						}
					}
				}
			} else if ("18C49".equals(jkid)) {
				Md_Car_Temp.getTempCar().isQuery = true;
				CarLoginActivity.this.queryBtn.setEnabled(true);
				HashMap<String, String> hm = (HashMap<String, String>) result;
				if (!hm.get("code").equals("1")) {
					DefautDialog.showDialog(
							CarLoginActivity.this,
							CarLoginActivity.this.getResources().getString(
									R.string.SYS_TITLE), hm.get("message"),
							false, null, null);
					queryTime = 3;
					handler.post(task);
				} else {
					hm.put("dlysfzh", Md_Car_Temp.getTempCar().jyysfzh);
					loginModel.setItemsData(hm);
					if (Md_system.getSfhj().equals("��")) {
						if (Md_system.getSfgxjyxm().equals("��")) {
							loginModel.setShow(4, true);
							loginModel.setShow(3, true);
						} else {
							loginModel.setShow(3, true);
						}
					} else {
						if (Md_system.getSfgxjyxm().equals("��")) {
							loginModel.setShow(3, true);
							loginModel.setShow(2, true);
						} else {
							loginModel.setShow(2, true);
						}
					}
					String s = hm.get("syr");
					if (s.indexOf("<<") != -1 && s.indexOf(">>") != -1) {
						syr.setData(s.replace("<<", "��").replace(">>", "��"));
					} else if (s.indexOf("<<") != -1) {
						syr.setData(s.replace("<<", "��"));
					} else if (s.indexOf(">>") != -1) {
						syr.setData(s.replace(">>", "��"));
					} else if (s.indexOf("<") != -1 && s.indexOf(">") != -1) {
						syr.setData(s.replace("<", "��").replace(">", "��"));
					} else if (s.indexOf("<") != -1) {
						syr.setData(s.replace("<", "��"));
					} else if (s.indexOf(">") != -1) {
						syr.setData(s.replace(">", "��"));
					}
					String sfmj = hm.get("sfmj");// S�Ƿ�Ϊ��쳵��2��ʾ����1��ʾ����쳵
					if ("1".equals(sfmj)) {
						sfmj = "\n�ó�δ�����������Ч��";
					} else {
						sfmj = "";
					}
					String value = "";
					String zt = hm.get("zt");
					Md_Car_Temp.getTempCar().zt = zt;
					try {
						char[] zts = Md_Car_Temp.getTempCar().zt.trim()
								.toCharArray();
						if (zts.length > 0) {
							for (char ztitem : zts) {
								char[] ztchar = { ztitem };
								String ztstr = new String(ztchar);
								value = value
										+ Md_Car_Temp.getTempCar().mapwz
												.get(ztstr) + "\n";
							}
						} else {
							value = "";
							value = "��Υ����Ϣ";
						}
					} catch (Exception e) {
						value = "";
						value = "��Υ����Ϣ";
					}
					// String value = Md_Car_Temp.getTempCar().mapwz.get(zt);
					// if (value == null || value.equals("")) {
					// value = "��Υ����Ϣ";
					// }
					WZItem.setData(value.trim());
					if (hm.get("yxqz") == null || isInYXQZ(hm.get("yxqz"))) {
						DefautDialog.showDialog(CarLoginActivity.this, "ϵͳ��ʾ��",
								value + sfmj, false,
								new DefautDialog.OnClickListener() {
									@Override
									public void onClick(DefautDialog dialog,
											View arg0) {
										dialog.dimiss();
										if (Md_system.getSfgxjyxm().equals("��")) {
											getJYXM();
										}
									}
								}, null);
					} else {
						// <3
						// �����ܼ쳵ֻ��ʾһ��
						DefautDialog.showDialog(CarLoginActivity.this, "ϵͳ��ʾ��",
								value + sfmj + "\n�˳�δ���쳵����Ч��", false,
								new DefautDialog.OnClickListener() {
									@Override
									public void onClick(DefautDialog dialog,
											View arg0) {
										dialog.dimiss();
										if (Md_system.getSfgxjyxm().equals("��")) {
											getJYXM();
										}
									}
								}, null);

					}

				}

			}
		} catch (Exception e) {
			DefautDialog.showDialog(CarLoginActivity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}

	}

	/**
	 * ��ü�����Ŀ
	 */
	private void getJYXM() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requesJYXMMap != null) {
			requesJYXMMap = null;
		}
		if (!vinItem.getData().equals("")) {
			if (Md_system.getSfhj().equals("��")) {
				if (Md_system.getSfgxjyxm().equals("��")) {
					if (Md_system.getSfzj().equals("��")) {
						loginModel.setItemsDataNull(4);
					} else {
						loginModel.setItemsDataNull(3);
					}

				}
			} else {
				if (Md_system.getSfgxjyxm().equals("��")) {
					if (Md_system.getSfzj().equals("��")) {
						loginModel.setItemsDataNull(3);
					} else {
						loginModel.setItemsDataNull(2);
					}
				}
			}

			requestMap = new HashMap<String, Object>();
			requesJYXMMap = loginModel.getDataNodeAndValue();
			// jylsh
			requesJYXMMap.put("jylsh", "");
			if (jclbItem.getData().equals("01")
					|| jclbItem.getData().equals("00")) {
				requesJYXMMap.put("jylbzl", "");
			}
			requesJYXMMap.put("jyjgbh", Md_system.getDzkey());
			requesJYXMMap.put("dly", Md_Car_Temp.getTempCar().userxingming);
			if (!Md_system.getSfgxjyxm().equals("��")) {
				requesJYXMMap.put("jyxm", "F1");
			}
			requesJYXMMap.put("ycy", "");
			requesJYXMMap.put("wjy", "");
			requesJYXMMap.put("bhgx", "");
			requesJYXMMap.put("jycs", "1");
			requesJYXMMap.put("dtjyy", "");
			requesJYXMMap.put("dpjyy", "");
			requesJYXMMap.put("ycysfzh", "");
			requesJYXMMap.put("wjysfzh", "");
			requesJYXMMap.put("dtjyysfzh", "");
			requesJYXMMap.put("ccdlsj", "");
			// requesJYXMMap.put("clyt",clyt[model].getData());
			requesJYXMMap.put("dlsj", new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").format(new Date()));
			requesJYXMMap.put("dpjyysfzh", "");
			requesJYXMMap.put("jyrq", "");
			requestMap.put("vehispara", requesJYXMMap);

			CarLoginActivity.this.request("18Q46", requestMap, 0,
					new String[] { "2" });
		}
	}

	/*
	 * ��ʱ�����ã�ʵ�ּ�ʱ
	 */
	private Handler handler = new Handler();
	private Runnable task = new Runnable() {
		public void run() {
			handler.postDelayed(this, 1000);
			queryTime--;
			if (queryTime == 0) {
				stop();
			}
		}
	};

	private void stop() {
		handler.removeCallbacks(task);
	}

	/**
	 * �ж��Ƿ��ڼ�����Ч����
	 * 
	 * @param yxqz
	 * @return boolֵ
	 */
	// �ж��Ƿ��ڼ�����Ч����
	private boolean isInYXQZ(String yxqz) {
		if (yxqz.equals("")) {
			return true;
		}
		SimpleDateFormat Simpleformat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date curDate = Simpleformat.parse(Simpleformat.format(new Date()));
			int num = getMonthNum(curDate, Simpleformat.parse(yxqz));
			if (num < 3) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}

	// �����������·�
	// date2����
	/**
	 * ����·�ʱ��
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public int getMonthNum(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		return (cal2.get(1) - cal1.get(1)) * 12 + (cal2.get(2) - cal1.get(2));
	}

	public void registerBoradcastReceiver() {
		IntentFilter myIntentFilter = new IntentFilter();
		myIntentFilter.addAction("ATION_CHECK");
		// ע��㲥
		registerReceiver(mBroadcastReceiver, myIntentFilter);
	}

	/**
	 * ����㲥
	 */
	// ����㲥
	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals("ATION_CHECK")) {
				if (zxzxjxs.getData().equals("0")) {
					if (requestMap != null) {
						requestMap = null;
					}
					if (requesJYXMMap != null) {
						requesJYXMMap = null;
					}
					if (!vinItem.getData().equals("")) {
						// �˴��������
						if (Md_system.getSfhj().equals("��")) {
							if (Md_system.getSfgxjyxm().equals("��")) {
								loginModel.setItemsDataNull(3);

							}
						} else {
							if (Md_system.getSfgxjyxm().equals("��")) {
								loginModel.setItemsDataNull(2);
							}
						}

						requestMap = new HashMap<String, Object>();
						requesJYXMMap = loginModel.getDataNodeAndValue();
						// jylsh
						requesJYXMMap.put("jylsh", "");
						if (jclbItem.getData().equals("01")
								|| jclbItem.getData().equals("00")) {
							requesJYXMMap.put("jylbzl", "");
						}
						requesJYXMMap.put("jyjgbh", Md_system.getDzkey());
						requesJYXMMap.put("dly",
								Md_Car_Temp.getTempCar().userxingming);
						if (!Md_system.getSfgxjyxm().equals("��")) {
							requesJYXMMap.put("jyxm", "F1");
						}
						requesJYXMMap.put("ycy", "");
						requesJYXMMap.put("wjy", "");
						requesJYXMMap.put("bhgx", "");
						requesJYXMMap.put("jycs", "1");
						requesJYXMMap.put("dtjyy", "");
						requesJYXMMap.put("dpjyy", "");
						requesJYXMMap.put("ycysfzh", "");
						requesJYXMMap.put("wjysfzh", "");
						requesJYXMMap.put("dtjyysfzh", "");
						requesJYXMMap.put("ccdlsj", "");
						// requesJYXMMap.put("clyt",clyt[model].getData());
						requesJYXMMap.put("dlsj", new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(new Date()));
						requesJYXMMap.put("dpjyysfzh", "");
						requesJYXMMap.put("jyrq", "");
						requestMap.put("vehispara", requesJYXMMap);
						CarLoginActivity.this.request("18Q46", requestMap, 0,
								new String[] { "2" });
					}
					Toast.makeText(CarLoginActivity.this, "��ǰ������ʽΪ�������ܲ��ܹ�ѡ����",
							Toast.LENGTH_SHORT).show();
				}
			}

		}
	};
	private InfoItem clyt1;

}
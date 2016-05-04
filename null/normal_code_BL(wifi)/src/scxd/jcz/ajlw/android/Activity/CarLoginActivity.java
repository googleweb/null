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
 * 车辆登录控制界面
 * 
 * @author Administrator
 * @time
 * 
 */
public class CarLoginActivity extends BaseActivity {
	public static int hp = 0;
	public static int s;
	private static final int ONLINE = 0;// 在线
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
	private InfoItem jylbzlfdjItem; // 非定检
	private InfoItem jylbzllsjyItem;// 临时检验
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
	 * 判断是否有人工外检权限
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
	 * 初始化数据
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
				Set<String> keySet = bundle.keySet(); // 得到bundle中所有的key
				Iterator<String> iter = keySet.iterator();
				while (iter.hasNext()) {
					String key = iter.next();
					hm.put(key, bundle.getString(key));
				}
				loginModel.setItemsData(hm);
			} catch (Exception e) {
			}
		}
		if (Md_system.getSfhj().equals("是")) {
			if (Md_system.getSfgxjyxm().equals("是")) {
				if (Md_system.getSfzj().equals("是")) {
					this.loginModel.setShow(5, true);
				} else {
					this.loginModel.setShow(4, true);
				}

			} else {
				if (Md_system.getSfzj().equals("是")) {
					this.loginModel.setShow(4, true);
				} else {
					this.loginModel.setShow(3, true);
				}
			}
		} else {
			if (Md_system.getSfgxjyxm().equals("是")) {
				if (Md_system.getSfzj().equals("是")) {
					this.loginModel.setShow(4, true);
				} else {
					this.loginModel.setShow(3, true);
				}

			} else {
				if (Md_system.getSfzj().equals("是")) {
					this.loginModel.setShow(3, true);
				} else {
					this.loginModel.setShow(2, true);
				}
			}
		}

		/**
		 * 置顶
		 */
		findViewById(R.id.btn_up).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView1);
				scrollView.scrollTo(0, 0);
			}
		});
		/**
		 * 置底
		 */
		findViewById(R.id.btn_down).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView1);
				scrollView.scrollTo(0, loginModel.getHeight());
			}
		});
		/**
		 * 查询
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
										"网络异常，请检查网络", 0).show();
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
										"网络异常，请检查网络", 0).show();
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
										"网络异常，请检查网络", 0).show();
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
					DefautDialog.showDialog(CarLoginActivity.this, "提示：",
							"请3秒后重新点击查询！", false, null, null);
				}

			}
		});
		/**
		 * 确定
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
						if (!Md_system.getSfgxjyxm().equals("是")) {
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
							Toast.makeText(CarLoginActivity.this, "网络异常，请检查网络",
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
	 * 设置 权限
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
	 * 判断环检
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
				if (Md_system.getSfhj().equals("是")) {
					if (Md_system.getSfgxjyxm().equals("是")) {
						loginModel.setShow(4, true);
					} else {
						loginModel.setShow(3, true);
					}
				} else {
					if (Md_system.getSfgxjyxm().equals("是")) {
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
	 * 初始化 项目
	 * 
	 * @param model
	 */
	private void initItems(final int model) {
		/**
		 * 项目 输入限制 [1]:文本 [2]:纯数字 [2|8192]:浮点 ^[A-Za-z0-9]{6}$ [\u4e00-\u9fa5]+
		 */
		InfoItem jcxdh;

		InfoItem zczw, zs, jcxlb;

		InfoItem ccrq, clpp1, cwkk, cwkc, cwkg, hxnbcd, hxnbkd, hxnbgd, zzl, zbzl, ltgg, lcbds, fzjg, dlysfzh;
		/* 检验项目 */
		InfoItem F1 = null, C1 = null, DC = null, B1 = null, B2 = null, B3 = null, B4 = null, B5 = null, B6 = null, B0 = null, H1 = null, H2 = null, H3 = null, H4 = null, S1 = null, A1 = null, R1 = null, R2 = null, R3 = null;
		/** 环保数据 **/
		InfoItem clyt = null;
		clyt1 = null;
		InfoItem hbbz = null, rllb = null, gyfs = null, pfbz = null, jqfs = null, hbjcbz = null, sfgz = null, sfyobd = null, bsx = null, obdgzm = null, hbbh = null, gs = null, zsitem = null, pl = null;
		/** 车辆基本信息 **/
		InfoItem rlzl, hdzk, zzs, zzly, xh, sjr, sjrsfzh, ytsx, fdjh, jyhgbzbh, hdzzl, zj, qlj, hlj, ccdjrq, yxqz, bxzzrq;
		// 车辆基本信息二
		InfoItem gbthps, lts, glbm, zzg, fdjxh, gcjk, sfzmhm, hbdbqk, xszbh, qpzk, hpzk, sfzmmc, clpp2, zqyzl, zzcmc, zxxs, djrq, qzbfqz, dybj;
		/**
		 * 综检检验类别
		 */
		InfoItem Grade = null, Ejwh = null, Repair = null;
		/** 登录信息 **/
		this.hphmItem = new InfoItemSpEdt(this, "车牌号码", "hphm",
				MD_ListItem.Get_sf(), 1, null);
		this.clxhItem = new InfoItemEdt(this, "车辆型号*", null, "clxh", 1, null,
				false);
		this.vinItem = new InfoItemEdt(this, "车辆VIN码*", null, "clsbdh", 1,
				null, false);
		/*this.cllxItem = new InfoItemSp(this, "车辆类型", "cllx",
				MD_ListItem.Get_cllx(), null);*/
		this.cllxItem = new InfoItemEdt(this, "车辆类型",null, "cllx",1,
				 null,false);
		this.syxzItem = new InfoItemSp(this, "使用性质", "syxz",
				MD_ListItem.Get_syxz(), null);
		/*this.jylbzlfdjItem = new InfoItemSp(this, "检测类别子类#", "jylbzl",
				MD_ListItem.Get_jylbzlfdj(), null);*/
		this.jylbzlfdjItem = new InfoItemSp(this, "检测类别子类#", "jylbzl",
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
		this.jylbzllsjyItem = new InfoItemSp(this, "检测类别子类#", "jylbzl",
				MD_ListItem.Get_jylbzllsjy(), null);
		/**
		 * 通过修改检测类别来修改号牌号码
		 * */
		// final InfoItemSpEdt hphmItemsp=(InfoItemSpEdt)
		// CarLoginActivity.this.hphmItem;
		this.jclbItem = new InfoItemSp(this, "检测类别*", "jylb",
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
		this.sfqszxzItem = new InfoItemSp(this, "是否双转向轴#", "sfqszxz",
				MD_ListItem.Get_sfsfqszxz(), null);
		this.WZItem = new InfoItemEdt(this, "违章信息", null, "zt", 1, null, true);
		this.hpzlItem = new InfoItemSp(this, "号牌种类", "hpzl",
				MD_ListItem.Get_hpzl(), new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						loginModel.initEdtNull();
						String hpzl = ((Md_cartype) parent
								.getItemAtPosition(position)).getName();
						if ("15".equals(hpzl)) {// 如果是挂车 驱动轴，前照，远光都选无
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
								Set<String> keySet = bundle.keySet(); // 得到bundle中所有的key
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

		syr = new InfoItemEdt(this, "机动车所有人", null, "syr", 1, null, true);
		jcxdh = new InfoItemSp(this, "检测线号", "jcxdh", MD_ListItem.Get_xh(),
				null);
		csys = new InfoItemEdt(CarLoginActivity.this, "车身颜色", null, "csys", 1,
				null, true);
		zxzxjxs = new InfoItemSp(this, "悬架形式#", "zxzxjxs",
				MD_ListItem.Get_zxzxjxs(), null);
		// qdxs = new InfoItemSp(this, "驱动型式#", "qdxs", MD_ListItem.Get_qdxs(),
		// null);
		// 将驱动形式拆分了为驱动轴，手刹轴。这样更能体现出摩托车
		qdxs = new InfoItemSp(this, "驱动轴#", "qdxs", MD_ListItem.Get_qdz(), null);
		zczw = new InfoItemSp(this, "手刹轴#", "zczw", MD_ListItem.Get_qdz(), null);
		zs = new InfoItemSp(this, "轴数*", "zs", getResources().getStringArray(
				R.array.zs), null);
		jcxlb = new InfoItemSp(this, "检测线类别#", "jcxlb",
				MD_ListItem.Get_Jcxlb(), null);
		qzdz = new InfoItemSp(this, "前照灯制#", "qzdz", MD_ListItem.Get_dz(), null);
		ygddtz = new InfoItemSp(this, "远光单独调整#", "ygddtz",
				MD_ListItem.Get_ygddtz(), null);
		ccrq = new InfoItemDate(this, "ccrq", "出厂日期*");
		clpp1 = new InfoItemEdt(this, "中文品牌*", null, "clpp1", 1, null, false);
		cwkk = new InfoItemEdt(this, "车外廓宽*", " mm", "cwkk", 2 | 8192, null,
				false);
		cwkc = new InfoItemEdt(this, "车外廓长*", " mm", "cwkc", 2 | 8192, null,
				false);
		cwkg = new InfoItemEdt(this, "车外廓高*", " mm", "cwkg", 2 | 8192, null,
				false);
		hxnbcd = new InfoItemEdt(this, "货箱内部长度", " mm", "hxnbcd", 2 | 8192,
				null, true);
		hxnbkd = new InfoItemEdt(this, "货箱内部宽度", " mm", "hxnbkd", 2 | 8192,
				null, true);
		hxnbgd = new InfoItemEdt(this, "货箱内部高度", " mm", "hxnbgd", 2 | 8192,
				null, true);
		zzl = new InfoItemEdt(this, "总质量*", " kg", "zzl", 2 | 8192,
				"^[0-9\\.]{1,5}$", false);
		zbzl = new InfoItemEdt(this, "整备质量*", " kg", "0", "zbzl", 2 | 8192,
				"^[0-9\\.]{1,5}$", false);
		ltgg = new InfoItemEdt(this, "轮胎规格", null, "ltgg", 1, null, true);
		lcbds = new InfoItemEdt(this, "里程表数#", "km", "lcbds", 2,
				"^[0-9]{1,9}$", false);
		fzjg = new InfoItemEdt(this, "发证机关*", null, "fzjg", 1, null, false);
		dlysfzh = new InfoItemEdt(this, "登录员(身份证号)#", null, "dlysfzh", 1, null,
				false);
		/** 勾选检验项目 **/
		if (Md_system.getSfgxjyxm().equals("是")) {
			F1 = new InfoItemChk(this, "车辆外观检验", "F1", false);
			C1 = new InfoItemChk(this, "底盘检验", "C1", false);
			DC = new InfoItemChk(this, "动态底盘检验", "DC", false);
			B1 = new InfoItemChk(this, "一轴制动", "B1", false);
			B2 = new InfoItemChk(this, "二轴制动", "B2", false);
			B3 = new InfoItemChk(this, "三轴制动", "B3", false);
			B4 = new InfoItemChk(this, "四轴制动", "B4", false);
			B5 = new InfoItemChk(this, "五轴制动", "B5", false);
			B6 = new InfoItemChk(this, "六轴制动", "B6", false);
			B0 = new InfoItemChk(this, "驻车制动", "B0", false);
			H1 = new InfoItemChk(this, "左外灯或二三轮机动车的左灯", "H1", false);
			H2 = new InfoItemChk(this, "左内灯", "H2", false);
			H3 = new InfoItemChk(this, "右内灯", "H3", false);
			H4 = new InfoItemChk(this, "右外灯或二三轮机动车的右灯", "H4", false);
			S1 = new InfoItemChk(this, "车速表", "S1", false);
			A1 = new InfoItemChk(this, "侧滑或二三轮汽车的轮偏", "A1", false);
			R1 = new InfoItemChk(this, "路试制动", "R1", false);
			R2 = new InfoItemChk(this, "路试坡道驻车", "R2", false);
			R3 = new InfoItemChk(this, "路试车速表", "R3", false);
		}
		/**
		 * 勾选综检检验项目
		 */
		if (Md_system.getSfzj().equals("是")) {
			Grade = new InfoItemChk(this, "等级评定", "grade", false);
			Ejwh = new InfoItemChk(this, "二级维护", "ejwh", false);
			Repair = new InfoItemChk(this, "大修竣工", "repair", false);
		}
		/** 环保信息 **/
		if (Md_system.getSfhj().equals("是")) {
			clyt = new InfoItemSp(this, "车辆用途", "clyt", MD_ListItem.Get_clyt(),
					null);
			obddsfzc = new InfoItemSp(this, "ODB灯是否正常", "obddsfzc",
					MD_ListItem.Get_pdsf(), null);
			hbbz = new InfoItemSp(this, "环保标志", "hbbz", MD_ListItem.Get_hbbz(),
					null);
			rllb = new InfoItemSp(this, "燃料类别", "rllb", MD_ListItem.Get_rylb(),
					null);
			gyfs = new InfoItemSp(this, "供油方式", "gyfs", MD_ListItem.Get_gyfs(),
					null);
			pfbz = new InfoItemSp(this, "排放标准", "pfbz", MD_ListItem.Get_pfbz(),
					null);
			jqfs = new InfoItemSp(this, "进气方式", "jqfs", MD_ListItem.Get_jqfs(),
					null);
			hbjcbz = new InfoItemSp(this, "环保检测标准", "hbjcbz",
					MD_ListItem.Get_hbjcbz(), null);
			sfgz = new InfoItemSp(this, "是否改造", "sfgz", MD_ListItem.Get_sfgz(),
					null);
			sfyobd = new InfoItemSp(this, "是否有ODB", "sfyobd",
					MD_ListItem.Get_pdsf(), new OnItemSelectedListener() {
						@Override
						public void onItemSelected(AdapterView<?> parent,
								View view, int position, long id) {
							if (position == 1) {
								obddsfzc.setData("否");
							} else {
								obddsfzc.setData("是");
							}
						}

						@Override
						public void onNothingSelected(AdapterView<?> arg0) {

						}
					});
			bsx = new InfoItemSp(this, "变速箱", "bsx", MD_ListItem.Get_bsx(),
					null);
			obdgzm = new InfoItemEdt(this, "ODB故障码", null, "obdgzm", 1, null,
					true);
			hbbh = new InfoItemEdt(this, "环保标号", null, "hbbh", 2 | 8192, null,
					true);
			gs = new InfoItemEdt(this, "缸数", null, "gs", 2 | 8192, null, true);
			zsitem = new InfoItemEdt(this, "转速", null, "zs", 2 | 8192, null,
					true);
			pl = new InfoItemEdt(this, "排量", " ML", "pl", 2 | 8192, null, true);
		}
		gl = new InfoItemEdt(this, "功率", " KW", "gl", 2 | 8192, null, true);
		rlzl = new InfoItemSp(this, "燃料类型", "rlzl", MD_ListItem.Get_rlzl(),
				null);
		hdzk = new InfoItemEdt(this, "核定载客人数", " 人", "hdzk", 1, "^[0-9]{1,5}$",
				true);
		zzs = new InfoItemSp(this, "主轴数", "zzs", getResources().getStringArray(
				R.array.zs), null);
		zzly = new InfoItemSp(this, "制动力源", "zzly", MD_ListItem.Get_zzly(),
				null);
		xh = new InfoItemEdt(this, "机动车序号", null, "xh", 1, null, true);
		clyt1 = new InfoItemEdt(this, "车辆用途", null, "clyt", 1, null, true);
		sjr = new InfoItemEdt(this, "送检人（姓名）", null, "sjr", 1, null, true);
		sjrsfzh = new InfoItemEdt(this, "送检人身份证号", null, "sjrsfzh", 1, null,
				true);
		ytsx = new InfoItemEdt(this, "用途属性", null, "ytsx", 1, null, true);
		fdjh = new InfoItemEdt(this, "发动机号", null, "fdjh", 1, null, true);
		jyhgbzbh = new InfoItemEdt(this, "检验合格标志", null, "jyhgbzbh", 1, null,
				true);
		hdzzl = new InfoItemEdt(this, "核定载质量", "  kg ", "hdzzl", 2 | 8192,
				"^[0-9\\.]{1,6}$", true);
		zj = new InfoItemEdt(this, "轴距单位", " mm", "zj", 2 | 8192, null, true);
		qlj = new InfoItemEdt(this, "前轮距单位", " mm", "qlj", 2 | 8192, null, true);
		hlj = new InfoItemEdt(this, "后轮距单位", " mm", "hlj", 2 | 8192, null, true);
		ccdjrq = new InfoItemDate(this, "ccdjrq", "初次登记日期");
		yxqz = new InfoItemDate(this, "yxqz", "检验有效期止");
		bxzzrq = new InfoItemDate(this, "bxzzrq", "保险终止日期");

		gbthps = new InfoItemEdt(this, "钢板弹簧片数", " 片", "gbthps", 2 | 8192,
				null, true);
		lts = new InfoItemEdt(this, "轮胎数", " 个", "lts", 2 | 8192, null, true);
		glbm = new InfoItemEdt(this, "管理部门", null, "glbm", 1, null, true);
		zzg = new InfoItemEdt(this, "制造国", null, "zzg", 1, null, true);
		fdjxh = new InfoItemEdt(this, "发动机型号", null, "fdjxh", 1, null, true);
		gcjk = new InfoItemEdt(this, "国产/进口", null, "gcjk", 1, null, true);
		sfzmhm = new InfoItemEdt(this, "身份证明号码", null, "sfzmhm", 1, null, true);
		hbdbqk = new InfoItemEdt(this, "环保达标情况", null, "hbdbqk", 1, null, true);
		xszbh = new InfoItemEdt(this, "行驶证证芯编号", null, "xszbh", 1, null, true);
		qpzk = new InfoItemEdt(this, "前排载客人数", " 人", "qpzk", 2 | 8192,
				"^[0-9]{1,5}$", true);
		hpzk = new InfoItemEdt(this, "后排载客人数", " 人", "hpzk", 2 | 8192,
				"^[0-9]{1,5}$", true);
		sfzmmc = new InfoItemEdt(this, "身份证明名称", null, "sfzmmc", 1, null, true);
		clpp2 = new InfoItemEdt(this, "英文品牌", null, "clpp2", 1, null, true);
		zqyzl = new InfoItemEdt(this, "准牵引总质量", " kg", "zqyzl", 2 | 8192, null,
				true);
		zzcmc = new InfoItemEdt(this, "制造厂名称", null, "zzcmc", 1, null, true);
		zxxs = new InfoItemEdt(this, "转向形式", null, "zxxs", 1, null, true);
		djrq = new InfoItemDate(this, "djrq", "最近定检日期");
		qzbfqz = new InfoItemDate(this, "qzbfqz", "强制报废期止");
		dybj = new InfoItemSp(this, "抵押标记", "dybj", MD_ListItem.Get_dybj(),
				null);
		// 开始处理
		if (Md_system.getSfhj().equals("是")) {
			if (Md_system.getSfgxjyxm().equals("是")) {
				if (Md_system.getSfzj().equals("是")) {
					this.loginModel
							.initItemBars(new String[] { "综检检验项目", "车辆基本信息二",
									"车辆基本信息一", "环检基础信息", "车辆检测项目", "车辆登录信息" });

					/** 车辆登录信息 **/
					this.loginModel.addItem(5, jclbItem); // 加载 检测类别
					this.loginModel.addItem(5, jylbzlfdjItem); // 检测类别子类非定检
					this.loginModel.addItem(5, jylbzllsjyItem); // 检测类别子类临时检验
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(5, hphmItem); // 加载 号牌号码
					this.loginModel.addItem(5, hpzlItem); // 号牌种类
					this.loginModel.addItem(5, vinItem); // 加载 vin
					this.loginModel.addItem(5, clxhItem); // 型号
					this.loginModel.addItem(5, clsslbmoth(true));// c超高超宽车的
																	// 车辆所属类别
					this.loginModel.addItem(5, cllxItem); // 车辆类型
					this.loginModel.addItem(5, syxzItem); // 使用性质
					this.loginModel.addItem(5, syr);
					this.loginModel.addItem(5, jcxdh);
					this.loginModel.addItem(5, csys);
					this.loginModel.addItem(5, zxzxjxs);
					this.loginModel.addItem(5, qdxs);
					this.loginModel.addItem(5, zczw);
					this.loginModel.addItem(5, zs);
					this.loginModel.addItem(5, sfqszxzItem); // 是否双向转轴
					this.loginModel.addItem(5, jcxlb);
					this.loginModel.addItem(5, qzdz);
					this.loginModel.addItem(5, ygddtz);
					this.loginModel.addItem(5, ccrq);
					this.loginModel.addItem(5, clpp1); // 厂牌
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
					/* 检验项目 */
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
					/** 环保数据 **/

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
					/** 车辆基本信息 **/
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
					// 车辆基本信息二
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
					// 综检检验项目
					this.loginModel.addItem(0, Grade);
					this.loginModel.addItem(0, Ejwh);
					this.loginModel.addItem(0, Repair);
				} else {
					this.loginModel.initItemBars(new String[] { "车辆基本信息二",
							"车辆基本信息一", "环检基础信息", "车辆检测项目", "车辆登录信息" });
					/** 车辆登录信息 **/
					this.loginModel.addItem(4, jclbItem); // 加载 检测类别
					this.loginModel.addItem(4, jylbzlfdjItem); // 检测类别子类非定检
					this.loginModel.addItem(4, jylbzllsjyItem); // 检测类别子类临时检验
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(4, hphmItem); // 加载 号牌号码
					this.loginModel.addItem(4, hpzlItem); // 号牌种类
					this.loginModel.addItem(4, vinItem); // 加载 vin
					this.loginModel.addItem(4, clxhItem); // 型号
					this.loginModel.addItem(4, clsslbmoth(true));// c超高超宽车的
																	// 车辆所属类别
					this.loginModel.addItem(4, cllxItem); // 车辆类型
					this.loginModel.addItem(4, syxzItem); // 使用性质
					this.loginModel.addItem(4, syr);
					this.loginModel.addItem(4, jcxdh);
					this.loginModel.addItem(4, csys);
					this.loginModel.addItem(4, zxzxjxs);
					this.loginModel.addItem(4, qdxs);
					this.loginModel.addItem(4, zczw);
					this.loginModel.addItem(4, zs);
					this.loginModel.addItem(4, sfqszxzItem); // 是否双向转轴
					this.loginModel.addItem(4, jcxlb);
					this.loginModel.addItem(4, qzdz);
					this.loginModel.addItem(4, ygddtz);
					this.loginModel.addItem(4, ccrq);
					this.loginModel.addItem(4, clpp1); // 厂牌
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
					/* 检验项目 */
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
					/** 环保数据 **/

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
					/** 车辆基本信息 **/
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
					// 车辆基本信息二
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
				if (Md_system.getSfzj().equals("是")) {
					this.loginModel.initItemBars(new String[] { "综检检验项目",
							"车辆基本信息二", "车辆基本信息一", "环检基础信息", "车辆登录信息" });
					/** 车辆登录信息 **/
					this.loginModel.addItem(4, jclbItem); // 加载 检测类别
					this.loginModel.addItem(4, jylbzlfdjItem); // 检测类别子类非定检
					this.loginModel.addItem(4, jylbzllsjyItem); // 检测类别子类临时检验
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(4, hphmItem); // 加载 号牌号码
					this.loginModel.addItem(4, hpzlItem); // 号牌种类
					this.loginModel.addItem(4, vinItem); // 加载 vin
					this.loginModel.addItem(4, clxhItem); // 型号
					this.loginModel.addItem(4, clsslbmoth(false));// 非超高超重的
																	// 车辆所属类别
					this.loginModel.addItem(4, cllxItem); // 车辆类型
					this.loginModel.addItem(4, syxzItem); // 使用性质
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
					this.loginModel.addItem(4, clpp1); // 厂牌
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
					/** 环保数据 **/
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
					this.loginModel.addItem(3, zsitem);// 转速
					this.loginModel.addItem(3, pl);
					/** 车辆基本信息 **/
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
					// 车辆基本信息
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
					this.loginModel.initItemBars(new String[] { "车辆基本信息二",
							"车辆基本信息一", "环检基础信息", "车辆登录信息" });
					/** 车辆登录信息 **/
					this.loginModel.addItem(3, jclbItem); // 加载 检测类别
					this.loginModel.addItem(3, jylbzlfdjItem); // 检测类别子类非定检
					this.loginModel.addItem(3, jylbzllsjyItem); // 检测类别子类临时检验
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(3, hphmItem); // 加载 号牌号码
					this.loginModel.addItem(3, hpzlItem); // 号牌种类
					this.loginModel.addItem(3, vinItem); // 加载 vin
					this.loginModel.addItem(3, clxhItem); // 型号
					this.loginModel.addItem(3, clsslbmoth(false));// 非超高超重的
																	// 车辆所属类别
					this.loginModel.addItem(3, cllxItem); // 车辆类型
					this.loginModel.addItem(3, syxzItem); // 使用性质
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
					this.loginModel.addItem(3, clpp1); // 厂牌
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
					/** 环保数据 **/
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
					this.loginModel.addItem(2, zsitem);// 转速
					this.loginModel.addItem(2, pl);
					/** 车辆基本信息 **/
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
					// 车辆基本信息二
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
			if (Md_system.getSfgxjyxm().equals("是")) {
				if (Md_system.getSfzj().equals("是")) {
					this.loginModel.initItemBars(new String[] { "综检检验项目",
							"车辆基本信息二", "车辆基本信息一", "车辆检测项目", "车辆登录信息" });
					/** 车辆登录信息 **/
					this.loginModel.addItem(4, jclbItem); // 加载 检测类别
					this.loginModel.addItem(4, jylbzlfdjItem); // 检测类别子类非定检
					this.loginModel.addItem(4, jylbzllsjyItem); // 检测类别子类临时检验
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(4, hphmItem); // 加载 号牌号码
					this.loginModel.addItem(4, hpzlItem); // 号牌种类
					this.loginModel.addItem(4, vinItem); // 加载 vin
					this.loginModel.addItem(4, clxhItem); // 型号
					this.loginModel.addItem(4, clsslbmoth(true));// 超高超重车辆所属类别
					this.loginModel.addItem(4, cllxItem); // 车辆类型
					this.loginModel.addItem(4, syxzItem); // 使用性质
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
					this.loginModel.addItem(4, clpp1); // 厂牌
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
					/* 检验项目 */
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
					/** 车辆基本信息 **/
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
					// 车辆基本信息二
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
					this.loginModel.initItemBars(new String[] { "车辆基本信息二",
							"车辆基本信息一", "车辆检测项目", "车辆登录信息" });
					/** 车辆登录信息 **/
					this.loginModel.addItem(3, jclbItem); // 加载 检测类别
					this.loginModel.addItem(3, jylbzlfdjItem); // 检测类别子类非定检
					this.loginModel.addItem(3, jylbzllsjyItem); // 检测类别子类临时检验
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(3, hphmItem); // 加载 号牌号码
					this.loginModel.addItem(3, hpzlItem); // 号牌种类
					this.loginModel.addItem(3, vinItem); // 加载 vin
					this.loginModel.addItem(3, clxhItem); // 型号
					this.loginModel.addItem(3, clsslbmoth(true));// 超高超重车辆所属类别
					this.loginModel.addItem(3, cllxItem); // 车辆类型
					this.loginModel.addItem(3, syxzItem); // 使用性质
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
					this.loginModel.addItem(3, clpp1); // 厂牌
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
					/* 检验项目 */
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
					/** 车辆基本信息 **/
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
					// 车辆基本信息二
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
				if (Md_system.getSfzj().equals("是")) {
					this.loginModel.initItemBars(new String[] { "综检检验项目",
							"车辆基本信息二", "车辆基本信息一", "车辆登录信息" });

					/** 车辆登录信息 **/
					this.loginModel.addItem(3, jclbItem); // 加载 检测类别
					this.loginModel.addItem(3, jylbzlfdjItem); // 检测类别子类非定检
					this.loginModel.addItem(3, jylbzllsjyItem); // 检测类别子类临时检验
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(3, hphmItem); // 加载 号牌号码
					this.loginModel.addItem(3, hpzlItem); // 号牌种类
					this.loginModel.addItem(3, vinItem); // 加载 vin
					this.loginModel.addItem(3, clxhItem); // 型号
					this.loginModel.addItem(3, clsslbmoth(false));// 非超高 车辆所属类别
					this.loginModel.addItem(3, cllxItem); // 车辆类型
					this.loginModel.addItem(3, syxzItem); // 使用性质
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
					this.loginModel.addItem(3, clpp1); // 厂牌
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
					/** 车辆基本信息 **/
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
					// 车辆基本信息二
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
					this.loginModel.initItemBars(new String[] { "车辆基本信息二",
							"车辆基本信息一", "车辆登录信息" });

					/** 车辆登录信息 **/
					this.loginModel.addItem(2, jclbItem); // 加载 检测类别
					this.loginModel.addItem(2, jylbzlfdjItem); // 检测类别子类非定检
					this.loginModel.addItem(2, jylbzllsjyItem); // 检测类别子类临时检验
					jylbzlfdjItem.setVisibility(View.GONE);
					jylbzllsjyItem.setVisibility(View.GONE);
					this.loginModel.addItem(2, hphmItem); // 加载 号牌号码
					this.loginModel.addItem(2, hpzlItem); // 号牌种类
					this.loginModel.addItem(2, vinItem); // 加载 vin
					this.loginModel.addItem(2, clxhItem); // 型号
					this.loginModel.addItem(2, clsslbmoth(false));// 非超高 车辆所属类别
					this.loginModel.addItem(2, cllxItem); // 车辆类型
					this.loginModel.addItem(2, syxzItem); // 使用性质
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
					this.loginModel.addItem(2, clpp1); // 厂牌
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
					/** 车辆基本信息 **/
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
					// 车辆基本信息二
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
	 *            是否超高超重
	 * @return InfoItem
	 */
	private InfoItem clsslbmoth(boolean iscgcz) {
		if (iscgcz) {
			clsslbItem = new InfoItemSp(this, "车辆所属类别#", "clsslb",
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
								if (Md_system.getSfhj().equals("是")) {
									if (Md_system.getSfgxjyxm().equals("是")) {
										loginModel.setItemsDataNull(3);
									}
								} else {
									if (Md_system.getSfgxjyxm().equals("是")) {
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
								if (!Md_system.getSfgxjyxm().equals("是")) {
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
			clsslbItem = new InfoItemSp(this, "车辆所属类别#", "clsslb",
					MD_ListItem.Get_clsslb(), null);
			return clsslbItem;
		}
	}

	/**
	 * 设置 MD_Car_Temp 参数
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
					if (Md_system.getSfhj().equals("是")) {
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
										R.string.SYS_TITLE), "车辆登录成功！", false,
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
														"外观检验已提交，继续其他检验流程....",
														1000).show();
												Application_Activity
														.goToActivity(
																CarLoginActivity.this,
																Pzlx_Activity.class);
												finish();
											} else {

												if ("四川".equals(Md_system.dq)) {
													if (isRGWJ) {
														Application_Activity
																.goToActivity(
																		CarLoginActivity.this,
																		CarPeople_Item_Activity.class);
														finish();
													} else {
														Toast.makeText(
																CarLoginActivity.this,
																"您没有外检权限", 1000)
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
								R.string.SYS_TITLE), "车辆登录成功！", false,
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
												"外观检验已提交，继续其他检验流程....", 1000)
												.show();
										Application_Activity.goToActivity(
												CarLoginActivity.this,
												Pzlx_Activity.class);
										finish();
									} else {
										if ("四川".equals(Md_system.dq)) {
											if (isRGWJ) {
												Application_Activity
														.goToActivity(
																CarLoginActivity.this,
																CarPeople_Item_Activity.class);
												finish();
											} else {
												Toast.makeText(
														CarLoginActivity.this,
														"您没有外检权限", 1000).show();
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
					if (Md_system.getSfhj().equals("是")) {
						if (Md_system.getSfgxjyxm().equals("是")) {
							loginModel.setJYXMItemsData(hm, 3);
						}
					} else {
						if (Md_system.getSfgxjyxm().equals("是")) {
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
					if (Md_system.getSfhj().equals("是")) {
						if (Md_system.getSfgxjyxm().equals("是")) {
							loginModel.setShow(4, true);
							loginModel.setShow(3, true);
						} else {
							loginModel.setShow(3, true);
						}
					} else {
						if (Md_system.getSfgxjyxm().equals("是")) {
							loginModel.setShow(3, true);
							loginModel.setShow(2, true);
						} else {
							loginModel.setShow(2, true);
						}
					}
					String s = hm.get("syr");
					if (s.indexOf("<<") != -1 && s.indexOf(">>") != -1) {
						syr.setData(s.replace("<<", "《").replace(">>", "》"));
					} else if (s.indexOf("<<") != -1) {
						syr.setData(s.replace("<<", "《"));
					} else if (s.indexOf(">>") != -1) {
						syr.setData(s.replace(">>", "》"));
					} else if (s.indexOf("<") != -1 && s.indexOf(">") != -1) {
						syr.setData(s.replace("<", "《").replace(">", "》"));
					} else if (s.indexOf("<") != -1) {
						syr.setData(s.replace("<", "《"));
					} else if (s.indexOf(">") != -1) {
						syr.setData(s.replace(">", "》"));
					}
					String sfmj = hm.get("sfmj");// S是否为免检车，2表示不是1表示是免检车
					if ("1".equals(sfmj)) {
						sfmj = "\n该车未过六年免检有效期";
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
							value = "无违法信息";
						}
					} catch (Exception e) {
						value = "";
						value = "无违法信息";
					}
					// String value = Md_Car_Temp.getTempCar().mapwz.get(zt);
					// if (value == null || value.equals("")) {
					// value = "无违法信息";
					// }
					WZItem.setData(value.trim());
					if (hm.get("yxqz") == null || isInYXQZ(hm.get("yxqz"))) {
						DefautDialog.showDialog(CarLoginActivity.this, "系统提示：",
								value + sfmj, false,
								new DefautDialog.OnClickListener() {
									@Override
									public void onClick(DefautDialog dialog,
											View arg0) {
										dialog.dimiss();
										if (Md_system.getSfgxjyxm().equals("是")) {
											getJYXM();
										}
									}
								}, null);
					} else {
						// <3
						// 到期能检车只提示一下
						DefautDialog.showDialog(CarLoginActivity.this, "系统提示：",
								value + sfmj + "\n此车未到检车的有效期", false,
								new DefautDialog.OnClickListener() {
									@Override
									public void onClick(DefautDialog dialog,
											View arg0) {
										dialog.dimiss();
										if (Md_system.getSfgxjyxm().equals("是")) {
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
	 * 获得检验项目
	 */
	private void getJYXM() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requesJYXMMap != null) {
			requesJYXMMap = null;
		}
		if (!vinItem.getData().equals("")) {
			if (Md_system.getSfhj().equals("是")) {
				if (Md_system.getSfgxjyxm().equals("是")) {
					if (Md_system.getSfzj().equals("是")) {
						loginModel.setItemsDataNull(4);
					} else {
						loginModel.setItemsDataNull(3);
					}

				}
			} else {
				if (Md_system.getSfgxjyxm().equals("是")) {
					if (Md_system.getSfzj().equals("是")) {
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
			if (!Md_system.getSfgxjyxm().equals("是")) {
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
	 * 定时器设置，实现计时
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
	 * 判断是否在检验有效期内
	 * 
	 * @param yxqz
	 * @return bool值
	 */
	// 判断是否在检验有效期内
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

	// 日期相减获得月份
	// date2数据
	/**
	 * 获得月份时间
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
		// 注册广播
		registerReceiver(mBroadcastReceiver, myIntentFilter);
	}

	/**
	 * 处理广播
	 */
	// 处理广播
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
						// 此处有新添加
						if (Md_system.getSfhj().equals("是")) {
							if (Md_system.getSfgxjyxm().equals("是")) {
								loginModel.setItemsDataNull(3);

							}
						} else {
							if (Md_system.getSfgxjyxm().equals("是")) {
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
						if (!Md_system.getSfgxjyxm().equals("是")) {
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
					Toast.makeText(CarLoginActivity.this, "当前悬架形式为独立悬架不能勾选此项",
							Toast.LENGTH_SHORT).show();
				}
			}

		}
	};
	private InfoItem clyt1;

}
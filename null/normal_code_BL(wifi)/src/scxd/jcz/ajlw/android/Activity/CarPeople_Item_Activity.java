package scxd.jcz.ajlw.android.Activity;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_JYXM;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.InfoItem;
import scxd.jcz.ajlw.android.model.InfoItemBar;
import scxd.jcz.ajlw.android.model.InfoItemDate;
import scxd.jcz.ajlw.android.model.InfoItemEdt;
import scxd.jcz.ajlw.android.model.InfoItemRdoGrpStyle2;
import scxd.jcz.ajlw.android.model.InfoItemRdoGrpStyle3;
import scxd.jcz.ajlw.android.model.InfoItemSp;
import scxd.jcz.ajlw.android.model.InfoItemSpEdt;
import scxd.jcz.ajlw.android.model.ItemLayout;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import scxd.jcz.ajlw.android.model.Md_system;
import scxd.jcz.ajlw.android.model.RgjyItem;
import scxd.jcz.ajlw.android.sign.DialogListenerImp;
import scxd.jcz.ajlw.android.sign.DisplayMetricsEN;
import scxd.jcz.ajlw.android.sign.WritePadDialog;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 人工检验项目
 * 
 * @author
 * @time
 * 
 * 
 */
@SuppressLint("SimpleDateFormat")
public class CarPeople_Item_Activity extends BaseActivity {
	/**
	 * 动态布局容器
	 */
	LinearLayout lin_layout = null;
	// LinearLayout lin_layout_xgb = null;
	LinearLayout lin_layout_kx = null;
	ScrollView lin_layout_xxbg = null;
	Context contx;
	/**
	 * 界面上的RadioGroup集合，key:项目序号<code>
	 */
	List<InfoItemRdoGrpStyle2> rdoGrpItems = null;

	List<InfoItemRdoGrpStyle3> choserdoGrpItems = null;
	// List<InfoItemRdoGrpStyle2> rdoGrpItems_xgb = null;
	List<InfoItemRdoGrpStyle2> rdoGrpItems_kx = null;
	private TextView hphm = null;
	private TextView clsbdh = null;
	private EditText jyy = null;
	private EditText jyysfzhm = null;
	private EditText jyyjy = null;
	private TextView bhgxm = null;
	private Button submit = null;
	private Button queryBtn = null;
	private Button quedBtn = null;
	private ImageView iv_rs_sign;
	private TextView tv_sign;
	private LinearLayout pLayout;
	private Bitmap mSignBitmap;
	private boolean issc = false;
	private boolean ischosewj = false;

	private ItemLayout[] XXBGModel = new ItemLayout[1];

	private InfoItem[] hphmItem = new InfoItemSpEdt[1];
	private InfoItem[] vinItem = new InfoItemEdt[1];
	private InfoItem[] cllxItem = new InfoItemSp[1];
	private InfoItem[] hpzlItem = new InfoItemSp[1];
	private InfoItem[] syxzItem = new InfoItemSp[1];

	private RadioGroup item_bgxx_rdogrp, item_content_rdogrp;
	private RadioButton item_bgxx_yes, item_rdo_yes;
	private RadioButton item_bgxx_no, item_rdo_no;
	private LinearLayout sfbgxx_layout, sfslliner, otherZp, carPeopleLX,
			message_linear;
	private TextView item_title_txt;
	private TextView kx_text;
	HashMap<String, String> hm = null;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestQueryCarBasicInfoMap = null;
	private String checkedStr = "1";
	private LinearLayout cwkg, cwkk, cwkc,zbzl;
	private EditText cwkc_e, cwkk_e, cwkg_e,zbzl_e;
	private List<String> jyxm_list = null;
	private String magess = "";
	private boolean isBhg = false;
	private EditText jcxdh_sp;// 录像的线号
	private Button kslx;// 开始录像
	private Button jslx;// 结束录像
	private ProgressBar progresslx;
	private TextView textlx_message;
	private boolean isLX = true;
	private Date starTime;

	/**
	 * 初始化界面
	 */
	private void getView() {
		starTime=new Date();
		lin_layout_xxbg = (ScrollView) findViewById(R.id.autoAddLayout_xxbg);
		sfbgxx_layout = (LinearLayout) findViewById(R.id.sfbgxx_layout);
		otherZp = (LinearLayout) findViewById(R.id.zp);
		carPeopleLX = (LinearLayout) findViewById(R.id.zplx_layout);
		iv_rs_sign = (ImageView) findViewById(R.id.iv_rs_sign);
		pLayout = (LinearLayout) findViewById(R.id.p_sign);
		if ("是".equals(Md_system.sfSign)) {
			issc = true;
			pLayout.setVisibility(View.VISIBLE);
		}
		if ("是".equals(Md_system.sfchose)) {
			ischosewj = true;
		} else {
			ischosewj = false;
		}
		iv_rs_sign.setOnClickListener(lx_Click);
		tv_sign = (TextView) findViewById(R.id.tv_sign);
		sfbgxx_layout.setVisibility(View.VISIBLE);
		carPeopleLX.setVisibility(View.VISIBLE);
		otherZp.setVisibility(View.GONE);
		item_bgxx_rdogrp = (RadioGroup) findViewById(R.id.item_bgxx_rdogrp);
		item_bgxx_yes = (RadioButton) findViewById(R.id.item_bgxx_yes);
		item_bgxx_no = (RadioButton) findViewById(R.id.item_bgxx_no);
		item_bgxx_rdogrp
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == item_bgxx_yes.getId()) {
							lin_layout_xxbg.setVisibility(View.VISIBLE);
						} else if (checkedId == item_bgxx_no.getId()) {
							lin_layout_xxbg.setVisibility(View.GONE);
						}
					}
				});
		hphm = (TextView) findViewById(R.id.inspection_hphm);
		bhgxm = (TextView) findViewById(R.id.bhgxm);
		clsbdh = (TextView) findViewById(R.id.inspection_clsbdh);
		jyy = (EditText) findViewById(R.id.inspection_jyy);
		jyysfzhm = (EditText) findViewById(R.id.inspection_jyysfzhm);
		jyyjy = (EditText) findViewById(R.id.jyyjy);
		queryBtn = (Button) findViewById(R.id.autoAddLayout_xxbg_query);
		quedBtn = (Button) findViewById(R.id.autoAddLayout_xxbg_submit);
		submit = (Button) findViewById(R.id.submitInspection);
		XXBGModel[0] = (ItemLayout) findViewById(R.id.autoAddLayout_xxbg_layout);
		lin_layout = (LinearLayout) findViewById(R.id.autoAddLayout);
		item_content_rdogrp = (RadioGroup) findViewById(R.id.item_content_rdogrp);
		sfslliner = (LinearLayout) findViewById(R.id.sfslliner);
		item_rdo_no = (RadioButton) findViewById(R.id.item_rdo_no);
		item_rdo_yes = (RadioButton) findViewById(R.id.item_rdo_yes);
		item_title_txt = (TextView) findViewById(R.id.item_title_txt);
		// lin_layout_xgb = (LinearLayout) findViewById(R.id.autoAddLayout_xgb);
		kx_text = (TextView) findViewById(R.id.kx_text);
		lin_layout_kx = (LinearLayout) findViewById(R.id.autoAddLayout_kx);
		cwkg = (LinearLayout) findViewById(R.id.cwkg);
		cwkk = (LinearLayout) findViewById(R.id.cwkk);
		cwkc = (LinearLayout) findViewById(R.id.cwkc);
		zbzl=(LinearLayout) findViewById(R.id.zbzl);
		cwkc_e = (EditText) findViewById(R.id.cwkc_e);
		cwkk_e = (EditText) findViewById(R.id.cwkk_e);
		cwkg_e = (EditText) findViewById(R.id.cwkg_e);
		zbzl_e=(EditText) findViewById(R.id.zbzl_e);
		kslx = (Button) findViewById(R.id.kslx);
		jslx = (Button) findViewById(R.id.jslx);
		message_linear = (LinearLayout) findViewById(R.id.message_linear);
		progresslx = (ProgressBar) findViewById(R.id.progresslx);
		textlx_message = (TextView) findViewById(R.id.textlx_message);
		jcxdh_sp = (EditText) findViewById(R.id.jcxdh_sp);
		jcxdh_sp.setText(Md_system.getLsxh());
		kslx.setOnClickListener(lx_Click);
		jslx.setOnClickListener(lx_Click);
	}

	/**
	 * 初始化textview文字
	 */
	private void setText() {
		hphm.setText(Md_Car_Temp.getTempCar().car_hphm);
		clsbdh.setText(Md_Car_Temp.getTempCar().car_clsbdh);
		jyy.setText(Md_Car_Temp.getTempCar().userxingming);
		jyysfzhm.setText(Md_Car_Temp.getTempCar().jyysfzh);
		item_content_rdogrp.setOnCheckedChangeListener(rdogrp_Click);
		if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
			sfslliner.setVisibility(View.VISIBLE);
		}
		cwkg.setVisibility(View.VISIBLE);
		cwkk.setVisibility(View.VISIBLE);
		cwkc.setVisibility(View.VISIBLE);
		zbzl.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Application_Activity.getApplication_Exit().addActivity(this);
		setContentView(R.layout.inspection_activity);

		getView();
		setText();
		initXXBGLinLayout();
		this.XXBGModel[0].setShow(0, false);
		initValue();
		contx = CarPeople_Item_Activity.this;
		rdoGrpItems = new ArrayList<InfoItemRdoGrpStyle2>();
		choserdoGrpItems = new ArrayList<InfoItemRdoGrpStyle3>();
		// rdoGrpItems_xgb = new ArrayList<InfoItemRdoGrpStyle2>();
		rdoGrpItems_kx = new ArrayList<InfoItemRdoGrpStyle2>();
		addEvent();
		request("18C47", getRequestPZXMDate(),
				R.string.REQUEST_WJJYXM_MESSAGE_ID, new String[] { "2" });
	}

	/**
	 * 判断选项
	 */
	private OnCheckedChangeListener rdogrp_Click = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			if (checkedId == item_rdo_yes.getId()) {
				checkedStr = "1";
			} else {
				checkedStr = "0";
			}

		}
	};
	/**** 开始与结束录像的点击事件 ***/
	private OnClickListener lx_Click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == kslx) {
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J11", getRequestSubmitKSLXDate("F1"),//左前
							R.string.BEGIN_MESSAGE_KSLX, new String[] { "1" });
					request("18J11", getRequestSubmitKSLXDate("F2"),//右后
							R.string.BEGIN_MESSAGE_KSLX, new String[] { "1" });
				} else {
					Toast.makeText(CarPeople_Item_Activity.this, "检测线代号不能为空！",
							1000).show();
				}
			} else if (v == jslx) {
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J12", getRequestSubmitJSLXDate("F1"),
							R.string.BEGIN_MESSAGE_JSLX, new String[] { "1" });
					request("18J12", getRequestSubmitJSLXDate("F2"),
							R.string.BEGIN_MESSAGE_JSLX, new String[] { "1" });
				} else {
					Toast.makeText(CarPeople_Item_Activity.this, "检测线代号不能为空！",
							1000).show();
				}
			} else if (v == iv_rs_sign) {
				WritePadDialog dialog = new WritePadDialog(
						CarPeople_Item_Activity.this, new DialogListenerImp() {

							@Override
							public void refreshActivity(Object object) {

								mSignBitmap = (Bitmap) object;
								iv_rs_sign.setImageBitmap(mSignBitmap);
								tv_sign.setVisibility(View.GONE);

							}
						});
				dialog.show();
				dialog.setCancelable(false);
			}
		}
	};

	private void initValue() {
		if (hm != null) {
			hm = null;
		}

		hm = new HashMap<String, String>();
		hm.put("hphm", isHZ(Md_Car_Temp.getTempCar().car_hphm.trim()));
		hm.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		hm.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		XXBGModel[0].setItemsData(hm);
	}

	public String isHZ(String str) {
		if ("".equals(str)) {
			return "";
		}
		char[] chars = str.toCharArray();
		char[] cs = { chars[0] };
		if (MD_ListItem.Get_sfs(new String(cs)) != null
				&& !MD_ListItem.Get_sfs(new String(cs)).equals("")) {
			return str.substring(1, str.length());
		}
		return str;
	}

	private void addEvent() {
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isLX) {
					// getRequestSubmitWJJYXMDate();
					if (isBhg) {
						magess = "其中有不合格的项目\n";
					} else {
						magess = "";
					}
					if (!jyy.getText().toString().equals("")
							&& !jyysfzhm.getText().toString().equals("")) {
						alert(magess + "确定提交外观检验数据？",
								new DefautDialog.OnClickListener() {
									@Override
									public void onClick(DefautDialog dialog,
											View view) {
										dialog.dimiss();
										request("18C55",
												getRequestSubmitBeginDate(),
												R.string.BEGIN_MESSAGE,
												new String[] { "1" });
									}
								});
					} else {
						DefautDialog.showDialog(CarPeople_Item_Activity.this,
								R.string.FORMAT_TITLE,
								R.string.INPUT_JYY_AND_JYYSFZH, false, null,
								null);
					}
				} else {
					Toast.makeText(CarPeople_Item_Activity.this, "录像没结束",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		queryBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!hphmItem[0].getData().equals("")
						&& !vinItem[0].getData().equals("")) {
					if (requestMap != null) {
						requestMap = null;
					}
					if (requestQueryCarBasicInfoMap != null) {
						requestQueryCarBasicInfoMap = null;
					}
					requestMap = new HashMap<String, Object>();
					requestQueryCarBasicInfoMap = new HashMap<String, Object>();
					requestQueryCarBasicInfoMap.put("hphm",
							hphmItem[0].getData());
					requestQueryCarBasicInfoMap.put("hpzl",
							hpzlItem[0].getData());
					requestQueryCarBasicInfoMap.put("clsbdh",
							vinItem[0].getData());
					requestQueryCarBasicInfoMap.put("jyjgbh",
							Md_system.getDzkey());
					requestMap.put("QueryCondition",
							requestQueryCarBasicInfoMap);
					CarPeople_Item_Activity.this.request("18C49", requestMap,
							R.string.QUERY_CAR_BASICINFO, new String[] { "2" });
				} else {
					DefautDialog.showDialog(CarPeople_Item_Activity.this,
							R.string.FORMAT_TITLE, R.string.INPUT_VIN_AND_HAPM,
							false, null, null);
				}
			}
		});
		quedBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (XXBGModel[0].isCompleted()) {
					if (XXBGModel[0].isMatch()) {
						if (requestMap != null) {
							requestMap = null;
						}
						if (requestQueryCarBasicInfoMap != null) {
							requestQueryCarBasicInfoMap = null;
						}
						requestMap = new HashMap<String, Object>();
						requestQueryCarBasicInfoMap = XXBGModel[0]
								.getDataNodeAndValue();
						requestQueryCarBasicInfoMap.put("jylsh",
								Md_Car_Temp.getTempCar().car_lsh);
						requestQueryCarBasicInfoMap.put("jyjgbh",
								Md_system.getDzkey());
						requestQueryCarBasicInfoMap.put("jcxdh", "2");
						requestQueryCarBasicInfoMap.put("dqsj",
								new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
										.format(new Date()));
						requestQueryCarBasicInfoMap.put("jyxm", "");
						requestMap
								.put("vehispara", requestQueryCarBasicInfoMap);
						CarPeople_Item_Activity.this.request("18C66",
								requestMap, R.string.CAR_LOGIN_XXBG,
								new String[] { "1" });
					} else {
						DefautDialog.showDialog(CarPeople_Item_Activity.this,
								getResources().getString(R.string.SYS_TITLE),
								XXBGModel[0].Log(), false, null, null);
					}
				} else {
					DefautDialog.showDialog(CarPeople_Item_Activity.this,
							getResources().getString(R.string.SYS_TITLE),
							XXBGModel[0].Log(), false, null, null);
				}
			}
		});
	}

	private void setMD_Car_Temp() {
		Md_Car_Temp.getTempCar().car_hpzl = hpzlItem[0].getData();
		Md_Car_Temp.getTempCar().car_clsbdh = vinItem[0].getData();
		Md_Car_Temp.getTempCar().car_hphm = hphmItem[0].getData();
		Md_Car_Temp.getTempCar().car_lx = cllxItem[0].getData();
		Md_Car_Temp.getTempCar().car_syxz = syxzItem[0].getData();
		Md_Car_Temp.getTempCar().car_vin = vinItem[0].getData();
	}

	/**
	 * 适配控件
	 */
	private void initXXBGLinLayout() {
		this.XXBGModel[0].initItemBars(new String[] { "信息变更" });

		this.hphmItem[0] = new InfoItemSpEdt(this, "车牌号码", "hphm",
				MD_ListItem.Get_sf(), 1, null);
		this.vinItem[0] = new InfoItemEdt(this, "车辆VIN码", null, "clsbdh", 1,
				null, false);
		this.cllxItem[0] = new InfoItemSp(this, "车辆类型", "cllx",
				MD_ListItem.Get_cllx(), null);
		this.syxzItem[0] = new InfoItemSp(this, "使用性质", "syxz",
				MD_ListItem.Get_syxz(), null);
		this.hpzlItem[0] = new InfoItemSp(this, "号牌种类", "hpzl",
				MD_ListItem.Get_hpzl(), new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						XXBGModel[0].initEdtNull();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

		this.XXBGModel[0].addItem(0, hphmItem[0]);
		this.XXBGModel[0].addItem(0, hpzlItem[0]);
		this.XXBGModel[0].addItem(0, vinItem[0]);
		this.XXBGModel[0].addItem(0, cllxItem[0]);
		this.XXBGModel[0].addItem(0, syxzItem[0]);

		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "车身颜色", "csys",
				MD_ListItem.Get_colors(), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "燃料类型", "rlzl",
				MD_ListItem.Get_rlzl(), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "轴数", "zs",
				getResources().getStringArray(R.array.zs), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "驱动型式", "qdxs",
				MD_ListItem.Get_qdxs(), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "驻车轴位", "zczw",
				MD_ListItem.Get_qdxs(), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "主轴数", "zzs",
				getResources().getStringArray(R.array.zs), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "制动力源", "zzly",
				MD_ListItem.Get_zzly(), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "前照灯制", "qzdz",
				MD_ListItem.Get_dz(), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "远光单独调整", "ygddtz",
				MD_ListItem.Get_ygddtz(), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "悬架形式", "zxzxjxs",
				MD_ListItem.Get_zxzxjxs(), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "检测类别", "jylb",
				MD_ListItem.Get_jylb(), null));
		this.XXBGModel[0].addItem(0, new InfoItemSp(this, "车辆所属类别", "clsslb",
				MD_ListItem.Get_clsslb(), null));
		this.XXBGModel[0].addItem(0, new InfoItemDate(this, "djrq", "最近定检日期"));
		this.XXBGModel[0].addItem(0, new InfoItemDate(this, "yxqz", "检验有效期止"));
		this.XXBGModel[0]
				.addItem(0, new InfoItemDate(this, "bxzzrq", "保险终止日期"));
		this.XXBGModel[0].addItem(0, new InfoItemDate(this, "ccrq", "出厂日期"));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "功率", " W", "gl", 2,
				null, true));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "总质量", " kg", "zzl",
				2 | 8192, "^[0-9\\.]{1,5}$", false));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "发动机号", null,
				"fdjh", 1, null, true));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "整备质量", " kg",
				"zbzl", 2 | 8192, "^[0-9\\.]{1,5}$", false));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "驻车轴数", null,
				"zczs", 2, null, false));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "里程表数", "km",
				"lcbds", 2, "^[0-9\\.]{1,9}$", true));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "中文品牌", null,
				"clpp1", 1, null, false));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "车辆型号", null,
				"clxh", 1, null, false));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "机动车所有人", null,
				"syr", 1, null, true));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "车辆用途", null,
				"clyt", 1, null, true));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "用途属性", null,
				"ytsx", 1, null, true));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "送检人（姓名）", null,
				"sjr", 1, null, true));
		this.XXBGModel[0].addItem(0, new InfoItemEdt(this, "送检人身份证号", null,
				"sjrsfzh", 1, null, true));
	}

	/**
	 * 获取牌照项目
	 * 
	 * @return map数据
	 */
	private Map<String, Object> getRequestPZXMDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestQueryCarBasicInfoMap != null) {
			requestQueryCarBasicInfoMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap.put("jylsh",
				Md_Car_Temp.getTempCar().car_lsh);
		requestQueryCarBasicInfoMap.put("jyjgbh", Md_system.getDzkey());
		requestQueryCarBasicInfoMap.put("hphm",
				Md_Car_Temp.getTempCar().car_hphm);
		requestQueryCarBasicInfoMap.put("hpzl",
				Md_Car_Temp.getTempCar().car_hpzl);
		requestMap.put("QueryCondition", requestQueryCarBasicInfoMap);
		return requestMap;
	}

	/**
	 * 动态添加控件到界面上
	 */

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == 4) {
			Intent itt = new Intent();
			if (Md_Car_Temp.getTempCar().FromWjlistToWjItem.equals("yes")) {
				Md_Car_Temp.getTempCar().car_hphm = "";
				Md_Car_Temp.getTempCar().car_hpzl = "";
				itt.setClass(CarPeople_Item_Activity.this,
						CarPeopleXm_Activity.class);
			} else {
				Md_Car_Temp.getTempCar().car_hphm = "";
				Md_Car_Temp.getTempCar().car_hpzl = "";
				itt.setClass(CarPeople_Item_Activity.this,
						CarLoginActivity.class);
			}
			startActivity(itt);
			CarPeople_Item_Activity.this.finish();
		}
		return false;
	}

	private void alert(String msg, DefautDialog.OnClickListener action) {
		DefautDialog.showDialog(
				CarPeople_Item_Activity.this,
				CarPeople_Item_Activity.this.getResources().getString(
						R.string.SYS_TITLE), msg, true, action, null);
	}

	/**
	 * 开始项目提交数据
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestSubmitBeginDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestQueryCarBasicInfoMap != null) {
			requestQueryCarBasicInfoMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap.put("jylsh",
				Md_Car_Temp.getTempCar().car_lsh);
		requestQueryCarBasicInfoMap.put("jyjgbh", Md_system.getDzkey());
		requestQueryCarBasicInfoMap.put("jcxdh", "2");
		requestQueryCarBasicInfoMap.put("jycs",
				Md_Car_Temp.getTempCar().car_jycs);
		requestQueryCarBasicInfoMap.put("hphm",
				Md_Car_Temp.getTempCar().car_hphm);
		requestQueryCarBasicInfoMap.put("hpzl",
				Md_Car_Temp.getTempCar().car_hpzl);
		requestQueryCarBasicInfoMap.put("clsbdh",
				Md_Car_Temp.getTempCar().car_clsbdh);
		requestQueryCarBasicInfoMap.put("gwjysbbh", "");
		requestQueryCarBasicInfoMap.put("jyxm", "F1");
		requestQueryCarBasicInfoMap.put("kssj", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(starTime));
		requestMap.put("vehispara", requestQueryCarBasicInfoMap);
		return requestMap;
	}

	/**
	 * 结束项目提交数据
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestSubmitEndDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestQueryCarBasicInfoMap != null) {
			requestQueryCarBasicInfoMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap.put("jylsh",
				Md_Car_Temp.getTempCar().car_lsh);
		requestQueryCarBasicInfoMap.put("jyjgbh", Md_system.getDzkey());
		requestQueryCarBasicInfoMap.put("jcxdh", "2");
		requestQueryCarBasicInfoMap.put("jycs",
				Md_Car_Temp.getTempCar().car_jycs);
		requestQueryCarBasicInfoMap.put("hphm",
				Md_Car_Temp.getTempCar().car_hphm);
		requestQueryCarBasicInfoMap.put("hpzl",
				Md_Car_Temp.getTempCar().car_hpzl);
		requestQueryCarBasicInfoMap.put("clsbdh",
				Md_Car_Temp.getTempCar().car_clsbdh);
		requestQueryCarBasicInfoMap.put("gwjysbbh", "");
		requestQueryCarBasicInfoMap.put("jyxm", "F1");
		requestQueryCarBasicInfoMap.put("jssj", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestMap.put("vehispara", requestQueryCarBasicInfoMap);
		return requestMap;
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try {
			if ("18C47".equals(jkid)) {
				Map<String, String> jyxm = (Map<String, String>) result;
				if (jyxm.get("hasbody").equals("no")
						|| jyxm.get("wgjcxm").equals("")) {

					CarPeople_Item_Activity.this.alert("查询外观检验项目失败，请重试！",
							new DefautDialog.OnClickListener() {
								@Override
								public void onClick(DefautDialog dialog,
										View view) {
									dialog.dimiss();
									request("18C47", getRequestPZXMDate(),
											R.string.REQUEST_WJJYXM_MESSAGE_ID,
											new String[] { "2" });
								}
							}, new DefautDialog.OnClickListener() {
								@Override
								public void onClick(DefautDialog dialog,
										View view) {
									dialog.dimiss();
								}
							});
				} else {
					dealJYXM(jyxm);
					dealKXJYXM(jyxm);
				}
			} else if ("18C49".equals(jkid)) {
				HashMap<String, String> hm = (HashMap<String, String>) result;
				if (hm.get("code").equals("0")) {
					DefautDialog.showDialog(CarPeople_Item_Activity.this,
							CarPeople_Item_Activity.this.getResources()
									.getString(R.string.SYS_TITLE),
							"查询车辆信息失败，请再试一次！", false, null, null);
				} else {
					XXBGModel[0].setItemsData(hm);
					XXBGModel[0].setShow(0, true);
				}
			} else if ("18C66".equals(jkid)) {
				List<Md_Car_TongYong> ty = (List<Md_Car_TongYong>) result;
				if (ty != null && ty.size() > 0) {
					DefautDialog.showDialog(CarPeople_Item_Activity.this,
							CarPeople_Item_Activity.this.getResources()
									.getString(R.string.SYS_TITLE),
							ty.get(0).message, false, null, null);
				}
				this.XXBGModel[0].setShow(0, false);
			} else if ("18C55".equals(jkid)) {
				// 判断是否是二三轮机动车
				if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
					if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
						request("18C68", getRequestSubmitWJJYXMDate(),
								R.string.REQUEST_SUBJYXM_MESSAGE_ID,
								new String[] { "1" });
					} else if (Md_Car_Temp.getTempCar().pdyj.equals("2")) {
						request("18C80", getRequestSubmitWJJYXMDate2(),
								R.string.REQUEST_SUBJYXM_MESSAGE_ID,
								new String[] { "1" });
					} else {
						request("18C80", getRequestSubmitWJJYXMDate2(),
								R.string.REQUEST_SUBJYXM_MESSAGE_ID,
								new String[] { "1" });
					}
				} else {
					System.out.println("pdyj" + Md_Car_Temp.getTempCar().pdyj);
					if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
						request("18C53", getRequestSubmitWJJYXMDate(),
								R.string.REQUEST_SUBJYXM_MESSAGE_ID,
								new String[] { "1" });
					} else if (Md_Car_Temp.getTempCar().pdyj.equals("2")) {
						request("18C80", getRequestSubmitWJJYXMDate2(),
								R.string.REQUEST_SUBJYXM_MESSAGE_ID,
								new String[] { "1" });
					} else {
						request("18C80", getRequestSubmitWJJYXMDate2(),
								R.string.REQUEST_SUBJYXM_MESSAGE_ID,
								new String[] { "1" });
					}
				}
			} else if ("18C80".equals(jkid)) {
				request("18C58", getRequestSubmitEndDate(),
						R.string.END_MESSAGE, new String[] { "1" });
			} else if ("18C53".equals(jkid) || "18C68".equals(jkid)) {
				request("18C58", getRequestSubmitEndDate(),
						R.string.END_MESSAGE, new String[] { "1" });
			} else if ("18C58".equals(jkid)) {
				List<Md_Car_TongYong> callJS = (List<Md_Car_TongYong>) result;
				dealCallWGJSJY(callJS);
			} else if ("18J11".equals(jkid)) {
				Map<String, String> kslx = (Map<String, String>) result;
				dealCallKSLX(kslx);
			} else if ("18J12".equals(jkid)) {
				Map<String, String> jslx = (Map<String, String>) result;
				dealCallJSLX(jslx);
			}
		} catch (Exception e) {
			DefautDialog.showDialog(CarPeople_Item_Activity.this,
					R.string.SYS_TITLE, R.string.serviceerrpr, false, null,
					null);
		}
	}

	/**
	 * 超找不合格项
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestSubmitWJJYXMDate() {
		// 循环查找不合格项
		StringBuilder bhgx = new StringBuilder();
		// 循环查找合格项
		StringBuilder hgx = new StringBuilder();

		for (InfoItemRdoGrpStyle2 rdoGrpItem : rdoGrpItems) {
			if (rdoGrpItem.isUnPassed()) {
				bhgx.append(rdoGrpItem.getData());
			} else if (rdoGrpItem.isPassed()) {
				hgx.append(rdoGrpItem.getData());
			}
		}
		if (bhgx.length() > 0) {
			isBhg = true;
		} else {
			isBhg = false;
		}
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestQueryCarBasicInfoMap != null) {
			requestQueryCarBasicInfoMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap.put("jylsh",
				Md_Car_Temp.getTempCar().car_lsh);
		requestQueryCarBasicInfoMap.put("jyjgbh", Md_system.getDzkey());
		requestQueryCarBasicInfoMap.put("jcxdh", "2");
		requestQueryCarBasicInfoMap.put("jycs",
				Md_Car_Temp.getTempCar().car_jycs);
		requestQueryCarBasicInfoMap.put("jyxm", "F1");
		requestQueryCarBasicInfoMap.put("hphm",
				Md_Car_Temp.getTempCar().car_hphm);
		requestQueryCarBasicInfoMap.put("hpzl",
				Md_Car_Temp.getTempCar().car_hpzl);
		requestQueryCarBasicInfoMap.put("clsbdh",
				Md_Car_Temp.getTempCar().car_clsbdh);
		// if (rdoGrpItems.size() > Md_Car_JYXM.Car_wgjyxml2.size()) {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_wgjyxml);
		// } else {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_wgjyxml2);
		// }

		if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
			// 摩托车
			if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
				Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
						requestQueryCarBasicInfoMap, Md_Car_JYXM.mt_wgjyxml);
			} else if (Md_Car_Temp.getTempCar().pdyj.equals("2")) {
				Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
						requestQueryCarBasicInfoMap, Md_Car_JYXM.Car_wgjyxml);
			} else {
				Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
						requestQueryCarBasicInfoMap, Md_Car_JYXM.Car_wgjyxml);
			}
			requestQueryCarBasicInfoMap.put("sfsl", checkedStr);
		} else {
			Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
					requestQueryCarBasicInfoMap, Md_Car_JYXM.Car_wgjyxml);
		}
		requestQueryCarBasicInfoMap.put("bz", jyyjy.getText().toString());
		requestQueryCarBasicInfoMap.put("wgjcjyy", jyy.getText().toString());
		requestQueryCarBasicInfoMap.put("wgjcjyysfzh", jyysfzhm.getText()
				.toString());
		requestMap.put("vehispara", requestQueryCarBasicInfoMap);
		return requestMap;

	}

	/**
	 * 查找不合格项
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestSubmitWJJYXMDate2() {
		// 循环查找不合格项
		StringBuilder bhgx = new StringBuilder();
		// 循环查找合格项
		StringBuilder hgx = new StringBuilder();
		StringBuilder wgbhgyy = new StringBuilder();
		for (InfoItemRdoGrpStyle2 rdoGrpItem : rdoGrpItems) {
			if (rdoGrpItem.isUnPassed()) {
				bhgx.append(rdoGrpItem.getData());
				if (wgbhgyy.toString().equals("")) {
					wgbhgyy.append(rdoGrpItem.getData().replace(",", "").trim()
							+ "#" + rdoGrpItem.getBhgyy());
				} else {
					wgbhgyy.append("|"
							+ rdoGrpItem.getData().replace(",", "").trim()
							+ "#" + rdoGrpItem.getBhgyy());
				}
			} else if (rdoGrpItem.isPassed()) {
				hgx.append(rdoGrpItem.getData());
			}
		}
		if (ischosewj) {
			for (InfoItemRdoGrpStyle3 rdoGrpItem : choserdoGrpItems) {
				if (rdoGrpItem.isUnPassed()) {
					bhgx.append(rdoGrpItem.getData());
					if (wgbhgyy.toString().equals("")) {
						wgbhgyy.append(rdoGrpItem.getData().replace(",", "")
								.trim()
								+ "#" + rdoGrpItem.getBhgyy());
					} else {
						wgbhgyy.append("|"
								+ rdoGrpItem.getData().replace(",", "").trim()
								+ "#" + rdoGrpItem.getBhgyy());
					}
				} else if (rdoGrpItem.isPassed()) {
					hgx.append(rdoGrpItem.getData());
				}
			}
		}
		if (rdoGrpItems_kx != null && rdoGrpItems_kx.size() > 0) {
			for (InfoItemRdoGrpStyle2 rdoGrpItem : rdoGrpItems_kx) {
				if (!jyxm_list.contains(rdoGrpItem.getItemID())) {
					if (rdoGrpItem.isUnPassed()) {
						bhgx.append(rdoGrpItem.getData());
						if (wgbhgyy.toString().equals("")) {
							wgbhgyy.append(rdoGrpItem.getData()
									.replace(",", "").trim()
									+ "#" + rdoGrpItem.getBhgyy());
						} else {
							wgbhgyy.append("|"
									+ rdoGrpItem.getData().replace(",", "")
											.trim() + "#"
									+ rdoGrpItem.getBhgyy());
						}
					} else if (rdoGrpItem.isPassed()) {
						hgx.append(rdoGrpItem.getData());
					}
				}
			}
		}
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestQueryCarBasicInfoMap != null) {
			requestQueryCarBasicInfoMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap.put("jylsh",
				Md_Car_Temp.getTempCar().car_lsh);
		requestQueryCarBasicInfoMap.put("jyjgbh", Md_system.getDzkey());
		requestQueryCarBasicInfoMap.put("jcxdh", "2");
		requestQueryCarBasicInfoMap.put("jycs",
				Md_Car_Temp.getTempCar().car_jycs);
		requestQueryCarBasicInfoMap.put("jyxm", "F1");
		requestQueryCarBasicInfoMap.put("hphm",
				Md_Car_Temp.getTempCar().car_hphm);
		requestQueryCarBasicInfoMap.put("hpzl",
				Md_Car_Temp.getTempCar().car_hpzl);
		requestQueryCarBasicInfoMap.put("clsbdh",
				Md_Car_Temp.getTempCar().car_clsbdh);
		// if (rdoGrpItems.size() > Md_Car_JYXM.Car_wgjyxml2.size()) {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_wgjyxml);
		// } else {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_wgjyxml2);
		// }
		// List<String> yjyxm = Arrays.asList((bhgx.toString() + hgx.toString())
		// .split(","));
		// if (yjyxm.get(0).length() == 2) {
		Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
				requestQueryCarBasicInfoMap, Md_Car_JYXM.Car_wgjyxml2);
		// } else if (yjyxm.get(0).length() == 3) {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_wgjyxml);
		// }
		// 新增
		if (!TextUtils.isEmpty(cwkc_e.getText().toString())) {
			requestQueryCarBasicInfoMap
					.put("cwkc", cwkc_e.getText().toString());
		} else {
			requestQueryCarBasicInfoMap.put("cwkc", "");
		}
		if (!TextUtils.isEmpty(cwkk_e.getText().toString())) {
			requestQueryCarBasicInfoMap
					.put("cwkk", cwkk_e.getText().toString());
		} else {
			requestQueryCarBasicInfoMap.put("cwkk", "");
		}
		if (!TextUtils.isEmpty(cwkg_e.getText().toString())) {
			requestQueryCarBasicInfoMap
					.put("cwkg", cwkg_e.getText().toString());
		} else {
			requestQueryCarBasicInfoMap.put("cwkg", "");
		}
		if (!TextUtils.isEmpty(zbzl_e.getText().toString())) {
			requestQueryCarBasicInfoMap
					.put("zbzl", zbzl_e.getText().toString());
		} else {
			requestQueryCarBasicInfoMap.put("zbzl", "");
		}
		//requestQueryCarBasicInfoMap.put("zbzl", "");
		requestQueryCarBasicInfoMap.put("syr", "");
		requestQueryCarBasicInfoMap.put("sjhm", "");
		requestQueryCarBasicInfoMap.put("lxdz", "");
		requestQueryCarBasicInfoMap.put("yzbm", "");
		requestQueryCarBasicInfoMap.put("wgbhgyy", wgbhgyy.toString());
		requestQueryCarBasicInfoMap.put("jyyjy", jyyjy.getText().toString());
		// 新增
		requestQueryCarBasicInfoMap.put("wgjcjyy", jyy.getText().toString());
		requestQueryCarBasicInfoMap.put("wgjcjyysfzh", jyysfzhm.getText()
				.toString());
		if (issc) {
			requestQueryCarBasicInfoMap.put("ZP", getbitmapString());
		}

		requestMap.put("vehispara", requestQueryCarBasicInfoMap);
		return requestMap;
	}

	private String getbitmapString() {
		String bitmapString = "";
		if (mSignBitmap != null) {
			ByteArrayOutputStream currentPhotoBAOS = null;

			try {
				currentPhotoBAOS = new ByteArrayOutputStream();
				if (mSignBitmap.compress(Bitmap.CompressFormat.JPEG, 100,
						currentPhotoBAOS)) {
					currentPhotoBAOS.flush();
					byte[] imageBytes = currentPhotoBAOS.toByteArray();
					currentPhotoBAOS.close();
					currentPhotoBAOS = null;

					bitmapString = Base64.encodeToString(imageBytes,
							Base64.DEFAULT);

					imageBytes = null;

				}
			} catch (Exception e) {
			} finally {
				if (currentPhotoBAOS != null) {
					try {
						currentPhotoBAOS.close();
						currentPhotoBAOS = null;
					} catch (Exception ee) {
					}
				}
			}
		}
		return bitmapString;
	}

	private void dealCallWGKSJY(List<Md_Car_TongYong> callKS) {
		if (callKS.get(0).code.equals("1")) {
			request("18C53", getRequestSubmitWJJYXMDate2(),
					R.string.REQUEST_SUBJYXM_MESSAGE_ID, new String[] { "1" });
		} else {
			alert(callKS.get(0).message, null);
		}

	}

	private void dealCallWGJY(List<Md_Car_TongYong> callWGJY) {
		if (callWGJY.get(0).code.equals("1")) {
			request("18C58", getRequestSubmitEndDate(), R.string.END_MESSAGE,
					new String[] { "1" });
		} else {
			alert(callWGJY.get(0).message, null);
		}
	}

	private void dealCallWGJSJY(List<Md_Car_TongYong> callJS) {
		if (callJS.get(0).code.equals("1")) {
			alert("数据提交成功！", new DefautDialog.OnClickListener() {
				@Override
				public void onClick(DefautDialog dialog, View view) {
					dialog.dimiss();
					Intent itt = new Intent();
					if (Md_Car_Temp.getTempCar().FromWjlistToWjItem
							.equals("yes")) {
						itt.setClass(CarPeople_Item_Activity.this,
								CarPeopleXm_Activity.class);
					} else {
						itt.setClass(CarPeople_Item_Activity.this,
								Pzlx_Activity.class);
					}
					startActivity(itt);
					CarPeople_Item_Activity.this.finish();
				}
			});
		} else {
			alert(callJS.get(0).message, null);
		}
	}

	/**
	 * 显示对话框
	 * 
	 * @param msg
	 *            消息
	 * @param qdaction
	 *            确定按钮监听
	 * @param qxaction
	 *            取消按钮监听
	 */
	public void alert(String msg, DefautDialog.OnClickListener qdaction,
			DefautDialog.OnClickListener qxaction) {
		DefautDialog.showDialog(
				CarPeople_Item_Activity.this,
				CarPeople_Item_Activity.this.getResources().getString(
						R.string.SYS_TITLE), msg, true, qdaction, qxaction);
	}

	/**
	 * 处理返回数据
	 * 
	 * @param rgwj_map
	 */
	private void dealKXJYXM(Map<String, String> rgwj_map) {
		String[] jyxms = null;
		List<RgjyItem> rgjyItems = null;
		if (rgwj_map.get("kxwgjcxm") != null
				&& !rgwj_map.get("kxwgjcxm").equals("")) {
			kx_text.setVisibility(View.VISIBLE);
			lin_layout_kx.setVisibility(View.VISIBLE);
			jyxms = rgwj_map.get("kxwgjcxm").split(",");
			if (jyxms.length > 0) {
				if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
					if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
						rgjyItems = Md_Car_JYXM
								.getItems(jyxms, Md_Car_JYXM.mt_wgjyflname3,
										Md_Car_JYXM.mt_wgjyfl3,
										Md_Car_JYXM.mt_wgjyxml3);
					} else if (Md_Car_Temp.getTempCar().pdyj.equals("2")) {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.wgjyflname3, Md_Car_JYXM.wgjyfl3,
								Md_Car_JYXM.Car_wgjyxm3);
					} else {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.wgjyflname3, Md_Car_JYXM.wgjyfl3,
								Md_Car_JYXM.Car_wgjyxm3);
					}
				} else {
					rgjyItems = Md_Car_JYXM.getItems(jyxms,
							Md_Car_JYXM.wgjyflname3, Md_Car_JYXM.wgjyfl3,
							Md_Car_JYXM.Car_wgjyxm3);
				}
			}
		}
		if (rgjyItems != null && rgjyItems.size() > 0) {
			for (RgjyItem rgjyItem : rgjyItems) {
				if (rgjyItem.msg != null) {
					InfoItemBar itemBar = new InfoItemBar(contx, rgjyItem.msg);
					for (RgjyItem.Item item : rgjyItem.items) {
						InfoItemRdoGrpStyle2 rdoGrpItem;
						rdoGrpItem = new InfoItemRdoGrpStyle2(contx, item, "");
						itemBar.addView(rdoGrpItem);
						rdoGrpItems_kx.add(rdoGrpItem);
					}
					lin_layout_kx.addView(itemBar);
				}
			}
		}
	}

	List<String> wjfjxs = null;
	private List<String> chose_jyxm_list;

	private void dealJYXM(Map<String, String> rgwj_map) {
		try {
			if (!rgwj_map.get("wjfjx").equals("")) {
				bhgxm.setText(rgwj_map.get("wjfjx"));
				wjfjxs = Arrays.asList(rgwj_map.get("wjfjx").split(","));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Md_Car_Temp.getTempCar().pdyj = rgwj_map.get("pdyj");
		String[] jyxms = null;
		List<RgjyItem> rgjyItems = null;
		List<RgjyItem> choseItems = null;
		String[] jyxms_xgb = new String[] { "01", "02", "03", "04", "05", "06",
				"07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31", "32", "33", "34", "35", "36",
				"37", "38", "39", "40", "80" };
		if (!rgwj_map.get("wgjcxm").equals("")) {
			jyxms = rgwj_map.get("wgjcxm").split(",");
			String[] chose_jyxm = minus(jyxms_xgb, jyxms);
			/*
			 * if(ischosewj){ chose_jyxm = minus(jyxms_xgb, jyxms); }else{
			 * chose_jyxm=null; }
			 */

			chose_jyxm_list = Arrays.asList(chose_jyxm);
			jyxm_list = Arrays.asList(jyxms);
			// ss
			if (jyxms.length > 0) {
				if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
					if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
						rgjyItems = Md_Car_JYXM
								.getItems(jyxms, Md_Car_JYXM.mt_wgjyflname3,
										Md_Car_JYXM.mt_wgjyfl3,
										Md_Car_JYXM.mt_wgjyxml3);
						if (ischosewj) {
							choseItems = Md_Car_JYXM.getItems(chose_jyxm,
									Md_Car_JYXM.mt_wgjyflname3,
									Md_Car_JYXM.mt_wgjyfl3,
									Md_Car_JYXM.mt_wgjyxml3);
						}

					} else if (Md_Car_Temp.getTempCar().pdyj.equals("2")) {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.wgjyflname3, Md_Car_JYXM.wgjyfl3,
								Md_Car_JYXM.Car_wgjyxm3);
						if (ischosewj) {
							choseItems = Md_Car_JYXM.getItems(chose_jyxm,
									Md_Car_JYXM.wgjyflname3,
									Md_Car_JYXM.wgjyfl3,
									Md_Car_JYXM.Car_wgjyxm3);
						}
					} else {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.wgjyflname3, Md_Car_JYXM.wgjyfl3,
								Md_Car_JYXM.Car_wgjyxm3);
						if (ischosewj) {
							choseItems = Md_Car_JYXM.getItems(chose_jyxm,
									Md_Car_JYXM.wgjyflname3,
									Md_Car_JYXM.wgjyfl3,
									Md_Car_JYXM.Car_wgjyxm3);
						}
					}
				} else {
					rgjyItems = Md_Car_JYXM.getItems(jyxms,
							Md_Car_JYXM.wgjyflname3, Md_Car_JYXM.wgjyfl3,
							Md_Car_JYXM.Car_wgjyxm3);
					if (ischosewj) {
						choseItems = Md_Car_JYXM.getItems(chose_jyxm,
								Md_Car_JYXM.wgjyflname3, Md_Car_JYXM.wgjyfl3,
								Md_Car_JYXM.Car_wgjyxm3);
					}
				}
				// rgjyItems_xgb = Md_Car_JYXM.getItems(jyxms_xgb,
				// Md_Car_JYXM.wgjyflname2, Md_Car_JYXM.wgjyfl2,
				// Md_Car_JYXM.Car_wgjyxm2);
			} else {
				jyxms = jyxms_xgb;
				jyxm_list = Arrays.asList(jyxms);
				rgjyItems = Md_Car_JYXM.getItems(jyxms,
						Md_Car_JYXM.wgjyflname3, Md_Car_JYXM.wgjyfl3,
						Md_Car_JYXM.Car_wgjyxm3);
				chose_jyxm = null;
			}
			// else {
			// rgjyItems = Md_Car_JYXM.getItems(jyxms,
			// Md_Car_JYXM.wgjyflname3, Md_Car_JYXM.wgjyfl3,
			// Md_Car_JYXM.Car_wgjyxm3);
			// }
		}
		// ss//返回的数据
		if (rgjyItems != null && rgjyItems.size() > 0) {
			for (RgjyItem rgjyItem : rgjyItems) {
				if (rgjyItem.msg != null) {
					InfoItemBar itemBar = new InfoItemBar(contx, rgjyItem.msg);
					for (RgjyItem.Item item : rgjyItem.items) {
						InfoItemRdoGrpStyle2 rdoGrpItem;
						if (wjfjxs != null && wjfjxs.contains(item.code)) {
							rdoGrpItem = new InfoItemRdoGrpStyle2(contx, item,
									true, false);
						} else {
							rdoGrpItem = new InfoItemRdoGrpStyle2(contx, item,
									"");
						}
						itemBar.addView(rdoGrpItem);
						rdoGrpItems.add(rdoGrpItem);
					}
					if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
						itemBar.setShow(false);
					} else {
						itemBar.setShow(true);
					}
					lin_layout.addView(itemBar);
				}
			}
			// if (rgjyItems_xgb != null && rgjyItems_xgb.size() > 0) {
			// for (RgjyItem rgjyItem : rgjyItems_xgb) {
			// if (rgjyItem.msg != null) {
			// InfoItemBar itemBar = new InfoItemBar(contx,
			// rgjyItem.msg);
			// for (RgjyItem.Item item : rgjyItem.items) {
			// InfoItemRdoGrpStyle2 rdoGrpItem = new InfoItemRdoGrpStyle2(
			// contx, item);
			// itemBar.addView(rdoGrpItem);
			// rdoGrpItems_xgb.add(rdoGrpItem);
			// }
			// lin_layout_xgb.addView(itemBar);
			// }
			// }
			//
			// }
			// 自选数据
			if (ischosewj) {
				if (choseItems != null && choseItems.size() > 0) {
					for (RgjyItem rgjyItem : choseItems) {
						if (rgjyItem.msg != null) {
							InfoItemBar itemBar = new InfoItemBar(contx,
									rgjyItem.msg);
							for (RgjyItem.Item item : rgjyItem.items) {
								InfoItemRdoGrpStyle3 rdoGrpItem;
								if (wjfjxs != null
										&& wjfjxs.contains(item.code)) {
									rdoGrpItem = new InfoItemRdoGrpStyle3(
											contx, item, true, "0");
								} else {
									rdoGrpItem = new InfoItemRdoGrpStyle3(
											contx, item);
								}
								itemBar.addView(rdoGrpItem);
								choserdoGrpItems.add(rdoGrpItem);
							}
							if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
								itemBar.setShow(false);
							} else {
								itemBar.setShow(true);
							}
							lin_layout.addView(itemBar);
						}
					}
				}
			} else {

			}
		} else {
			DefautDialog.showDialog(
					CarPeople_Item_Activity.this,
					CarPeople_Item_Activity.this.getResources().getString(
							R.string.SYS_TITLE), "获取查询数据失败，请重试！", false, null,
					null);
		}
	}

	/*** 开始录像的参数 **/
	private Map<String, Object> getRequestSubmitKSLXDate(String str) {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestQueryCarBasicInfoMap != null) {
			requestQueryCarBasicInfoMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap.put("jylsh",
				Md_Car_Temp.getTempCar().car_lsh);
		requestQueryCarBasicInfoMap.put("hphm",
				Md_Car_Temp.getTempCar().car_hphm);
		requestQueryCarBasicInfoMap.put("hpzl",
				Md_Car_Temp.getTempCar().car_hpzl);
		requestQueryCarBasicInfoMap.put("clsbdh",
				Md_Car_Temp.getTempCar().car_clsbdh);
		requestQueryCarBasicInfoMap.put("jcxdh", jcxdh_sp.getText().toString());
		requestQueryCarBasicInfoMap.put("gwxm", str);
		requestMap.put("vehispara", requestQueryCarBasicInfoMap);
		return requestMap;
	}

	/*** 结束录像的参数 **/
	private Map<String, Object> getRequestSubmitJSLXDate(String str) {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestQueryCarBasicInfoMap != null) {
			requestQueryCarBasicInfoMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap = new HashMap<String, Object>();
		requestQueryCarBasicInfoMap.put("jylsh",
				Md_Car_Temp.getTempCar().car_lsh);
		requestQueryCarBasicInfoMap.put("hphm",
				Md_Car_Temp.getTempCar().car_hphm);
		requestQueryCarBasicInfoMap.put("hpzl",
				Md_Car_Temp.getTempCar().car_hpzl);
		requestQueryCarBasicInfoMap.put("clsbdh",
				Md_Car_Temp.getTempCar().car_clsbdh);
		requestQueryCarBasicInfoMap.put("jcxdh", jcxdh_sp.getText().toString());
		requestQueryCarBasicInfoMap.put("gwxm", str);
		requestMap.put("vehispara", requestQueryCarBasicInfoMap);
		return requestMap;
	}

	/**
	 * 开始录像
	 * 
	 * @param kslx
	 */
	private void dealCallKSLX(Map<String, String> kslx) {
		if (kslx.get("code").equals("1")) {
			message_linear.setVisibility(View.VISIBLE);
			progresslx.setVisibility(View.VISIBLE);
			isLX = false;
			textlx_message.setText("正在录像...");
			Toast.makeText(this, "----开始录像成功----", 1000).show();
		} else {
			progresslx.setVisibility(View.GONE);
			textlx_message.setText("开始录像失败");
			Toast.makeText(this, "----开始录像失败，请重试----", 1000).show();
		}
	}

	/**
	 * 结束录像
	 * 
	 * @param jslx
	 */
	private void dealCallJSLX(Map<String, String> jslx) {
		if (jslx.get("code").equals("1")) {
			progresslx.setVisibility(View.GONE);
			textlx_message.setText("录像已完成");
			isLX = true;
			Toast.makeText(this, "----结束录像成功----", 1000).show();
		} else {
			progresslx.setVisibility(View.INVISIBLE);
			isLX = false;
			textlx_message.setText("结束录像失败");
			Toast.makeText(this, "----结束录像失败，请重试----", 1000).show();
		}
	}

	@Override
	protected void onDestroy() {
		if (mSignBitmap != null) {
			mSignBitmap.recycle();
			mSignBitmap = null;
		}
		super.onDestroy();
	}

	public String[] minus(String[] arr1, String[] arr2) {
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> history = new LinkedList<String>();
		String[] longerArr = arr1;
		String[] shorterArr = arr2;
		// 找出较长的数组来减较短的数组
		if (arr1.length > arr2.length) {
			longerArr = arr2;
			shorterArr = arr1;
		}
		for (String str : longerArr) {
			if (!list.contains(str)) {
				list.add(str);
			}
		}
		for (String str : shorterArr) {
			if (list.contains(str)) {
				history.add(str);
				list.remove(str);
			} else {
				if (!history.contains(str)) {
					list.add(str);
				}
			}
		}

		String[] result = {};
		return list.toArray(result);
	}

}

package scxd.jcz.ajlw.android.Activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.InfoItem;
import scxd.jcz.ajlw.android.model.InfoItemEdt;
import scxd.jcz.ajlw.android.model.InfoItemSp;
import scxd.jcz.ajlw.android.model.ItemLayout;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import scxd.jcz.ajlw.android.model.Md_cartype;
import scxd.jcz.ajlw.android.model.Md_system;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 路试项目
 * 
 * @author Administrator
 * @TIME
 * 
 */
public class LsSelect_Activity extends BaseActivity {
	ItemLayout lsData = null;
	Context contx;
	private TextView hphm = null;
	private TextView clsbdh = null;
	private TextView xgb_text = null;
	private TextView lgb_text = null;
	private EditText jyy = null;
	private Button submit = null;
	private Button tijdgsj = null;
	private Button tizjl = null;
	private LinearLayout sfzh = null;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestDate = null;
	private LinearLayout zplx, message_linear;
	private Button kslx;
	private Button jslx;
	private Button xczdkszp;
	private Button xczdjszp;
	private Button pdzczdzp;
	private EditText jcxdh_sp;
	private ProgressBar progresslx;
	private TextView textlx_message;
	private boolean isLX = true;

	private void getView() {
		hphm = (TextView) findViewById(R.id.inspection_hphm);
		clsbdh = (TextView) findViewById(R.id.inspection_clsbdh);
		xgb_text = (TextView) findViewById(R.id.xgb_text);
		xgb_text.setVisibility(View.GONE);
		lgb_text = (TextView) findViewById(R.id.lgb_text);
		lgb_text.setVisibility(View.GONE);
		jyy = (EditText) findViewById(R.id.inspection_jyy);
		submit = (Button) findViewById(R.id.submitInspection);
		tijdgsj = (Button) findViewById(R.id.tijdgsj);
		tizjl = (Button) findViewById(R.id.tizjl);

		lsData = (ItemLayout) findViewById(R.id.lsDataLayout);
		sfzh = (LinearLayout) findViewById(R.id.sfzh);
		sfzh.setVisibility(View.GONE);

		// 抓拍录像
		zplx = (LinearLayout) findViewById(R.id.zplx_layout);
		zplx.setVisibility(View.VISIBLE);
		kslx = (Button) findViewById(R.id.kslx);
		jslx = (Button) findViewById(R.id.jslx);
		xczdkszp = (Button) findViewById(R.id.xczdkszp);
		xczdjszp = (Button) findViewById(R.id.xczdjszp);
		pdzczdzp = (Button) findViewById(R.id.pdzczdzp);
		jcxdh_sp = (EditText) findViewById(R.id.jcxdh_sp);
		message_linear = (LinearLayout) findViewById(R.id.message_linear);
		progresslx = (ProgressBar) findViewById(R.id.progresslx);
		textlx_message = (TextView) findViewById(R.id.textlx_message);
		jcxdh_sp.setText(Md_system.getLsxh());
	}

	private void setText() {
		hphm.setText(Md_Car_Temp.getTempCar().car_hphm);
		clsbdh.setText(Md_Car_Temp.getTempCar().car_clsbdh);
		jyy.setText(Md_Car_Temp.getTempCar().userxingming);
		tijdgsj.setVisibility(View.VISIBLE);
		tizjl.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Application_Activity.getApplication_Exit().addActivity(this);
		setContentView(R.layout.inspection_activity);

		getView();
		setText();
		contx = LsSelect_Activity.this;
		addEvent();
		initJYXMLSDATA();
	}

	// 行车制动
	private InfoItem xczzfs;
	private InfoItem zdcsd;
	private InfoItem zdxtsj;
	private InfoItem zdwdx;
	private InfoItem xczdjl;
	private InfoItem xcmfdd;
	private InfoItem xczdczlz;
	private InfoItem xcpdfs;
	private InfoItem lszdpd;
	// 应急制动
	private InfoItem yjzzfs;
	private InfoItem yjzdcsd;
	private InfoItem yjzdjl;
	private InfoItem yjmfdd;
	private InfoItem yjzdczlfs;
	private InfoItem yjzdczlz;
	private InfoItem yjpdfs;
	private InfoItem yjzdpd;
	// 驻车坡度
	private InfoItem zcpd; // 坡度
	private InfoItem lszczdpd;// 驻车制动判定
	// 车速表判定
	private InfoItem csdscz; // 车速表实测值
	private InfoItem csbpd;// 车速表判定
	// 判定结论
	private InfoItem lsjg;// 路试结果
	// 总结论
	private InfoItem zczdjyjg;
	private InfoItem zjlzcpd;
	private InfoItem zjccs;
	private InfoItem jcxdh;
	private InfoItem jyjl;
	private InfoItem pzrxm;

	/**
	 * 初始化路试检验项目
	 */
	private void initJYXMLSDATA() {
		String[] str = { "空载", "满载" };
		lsData.initItemBars(new String[] { "总结论", "判定结果", "车速表", "驻车制动",
				"应急制动", "行车制动" });
		// 行车制动
		xcpdfs = new InfoItemSp(this, "判定方式", "xcpdfs", MD_ListItem.Get_pdfs(),
				new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						if (position == 0) { // MFDD
							xczdjl.setVisibility(View.GONE);
							zdxtsj.setVisibility(View.VISIBLE);
							xcmfdd.setVisibility(View.VISIBLE);
						} else {// 制动距离
							xczdjl.setVisibility(View.VISIBLE);
							zdxtsj.setVisibility(View.GONE);
							xcmfdd.setVisibility(View.GONE);
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});
		xczzfs = new InfoItemSp(this, "载重方式", "xczzfs", str, null);
		zdcsd = new InfoItemEdt(this, "行车制动初速度", " km/h", "50", "zdcsd",
				2 | 8192, null, false);
		zdxtsj = new InfoItemEdt(this, "行车制动协调时间", "s", "0", "zdxtsj",
				2 | 8192, null, true);
		zdwdx = new InfoItemSp(this, "行车制动稳定性", "zdwdx", MD_ListItem.Get_wdx(),
				null);
		xczdjl = new InfoItemEdt(this, "制动距离", "  m", "0", "xczdjl", 2 | 8192,
				null, true);
		xcmfdd = new InfoItemEdt(this, "MFDD", " m/s²", "0", "xcmfdd",
				2 | 8192, null, false);
		xczdczlz = new InfoItemEdt(this, "行车制动踏板力值", null, "0", "xczdczlz",
				2 | 8192, null, true);
		lszdpd = new InfoItemSp(this, "行车制动判定", "lszdpd",
				MD_ListItem.Get_jlpd(), null);

		// 应急制动
		yjpdfs = new InfoItemSp(this, "应急判定方式", "yjpdfs",
				MD_ListItem.Get_pdfs(), new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						if (position == 0) { // MFDD
							yjzdjl.setVisibility(View.GONE);
							yjmfdd.setVisibility(View.VISIBLE);
						} else {// 制动距离
							yjzdjl.setVisibility(View.VISIBLE);
							yjmfdd.setVisibility(View.GONE);
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});
		yjzzfs = new InfoItemSp(this, "载重方式", "yjzzfs", str, null);
		yjzdcsd = new InfoItemEdt(this, "应急制动初速度", "km/h", "0", "yjzdcsd",
				2 | 8192, null, false);
		yjzdjl = new InfoItemEdt(this, "制动距离", " m", "0", "yjzdjl", 2 | 8192,
				null, true);
		yjmfdd = new InfoItemEdt(this, "MFDD", " m/s²", "0", "yjmfdd",
				2 | 8192, null, false);
		yjzdczlfs = new InfoItemSp(this, "应急操纵力方式", "yjzdczlfs",
				MD_ListItem.Get_yjczfs(), null);
		yjzdczlz = new InfoItemEdt(this, "应急操纵力值", null, "0", "yjzdczlz",
				2 | 8192, null, true);
		yjzdpd = new InfoItemSp(this, "应急制动判定", "yjzdpd",
				MD_ListItem.Get_jlpd(), null);
		// 驻车
		zcpd = new InfoItemSp(this, "驻车坡度", "驻车坡度", MD_ListItem.Get_zcpd(),
				null);
		lszczdpd = new InfoItemSp(this, "驻车制动判定", "lszczdpd",
				MD_ListItem.Get_jlpd(), null);
		// 车速表判定
		csdscz = new InfoItemEdt(this, "车速表实测值", " km/h", "0", "csdscz",
				2 | 8192, null, false);
		csbpd = new InfoItemSp(this, "车速表判定", "csbpd", MD_ListItem.Get_jlpd(),
				null);
		// 判定结论
		lsjg = new InfoItemSp(this, "路试结果", "lsjg", MD_ListItem.Get_jlpd(),
				null);

		// 总结论
		zczdjyjg = new InfoItemSp(this, "主车制动检验结果", "zczdjyjg",
				MD_ListItem.Get_jlpd2(), null);
		zjlzcpd = new InfoItemSp(this, "整车判定", "zjlzcpd",
				MD_ListItem.Get_jlpd(), null);
		zjccs = new InfoItemSp(this, "总检验次数", "zjccs", MD_ListItem.Get_jccs(),
				null);
		jcxdh = new InfoItemSp(this, "检测线代号", "jcxdh", MD_ListItem.Get_jcxdh(),
				null);
		jyjl = new InfoItemSp(this, "检验结论", "jyjl", MD_ListItem.Get_jlpd3(),
				null);
		jyjl = new InfoItemSp(this, "检验结论", "jyjl", MD_ListItem.Get_jlpd3(),
				null);
		pzrxm = new InfoItemEdt(this, "授权签字人", null, "pzrxm", 1, null, true);
		// 适配界面
		// 行车制动
		lsData.addItem(5, xcpdfs);
		lsData.addItem(5, xczzfs);
		lsData.addItem(5, zdwdx);
		lsData.addItem(5, zdxtsj);
		lsData.addItem(5, xcmfdd);
		lsData.addItem(5, xczdjl);
		lsData.addItem(5, xczdczlz);
		lsData.addItem(5, zdcsd);
		lsData.addItem(5, lszdpd);
		// 应急制动
		lsData.addItem(4, yjpdfs);
		lsData.addItem(4, yjzzfs);
		lsData.addItem(4, yjmfdd);
		lsData.addItem(4, yjzdjl);
		lsData.addItem(4, yjzdcsd);
		lsData.addItem(4, yjzdczlfs);
		lsData.addItem(4, yjzdczlz);
		lsData.addItem(4, yjzdpd);
		// 驻车
		lsData.addItem(3, zcpd);
		lsData.addItem(3, lszczdpd);
		// 车速表判定
		lsData.addItem(2, csdscz);
		lsData.addItem(2, csbpd);
		// 判定结论
		lsData.addItem(1, lsjg);
		// 总结论
		lsData.addItem(0, jcxdh);
		lsData.addItem(0, zjccs);
		lsData.addItem(0, zczdjyjg);
		lsData.addItem(0, zjlzcpd);
		lsData.addItem(0, jyjl);
		lsData.addItem(0, pzrxm);
		// 显示界面
		lsData.setShow(5, true);
		pzrxm.setData(Md_Car_Temp.getTempCar().userxingming);
	}

	/**
	 * 路试项目加载
	 * 
	 * @param requestDate
	 */
	private void addLSDATA(Map<String, Object> requestDate) {
		if (null == requestDate) {
			requestDate = new HashMap<String, Object>();
		}
		// 行车制动
		if (xcpdfs.getData().equals("0")) {// MFDD
			if (xczzfs.getData().equals("空载")) {
				requestDate.put("xckzmfdd", xcmfdd.getData());
				requestDate.put("xcmzmfdd", "");
				requestDate.put("zdxtsj", zdxtsj.getData());
				requestDate.put("xckzzdjl", "");
				requestDate.put("xcmzzdjl", "");
			} else {
				requestDate.put("xckzmfdd", "");
				requestDate.put("xcmzmfdd", xcmfdd.getData());
				requestDate.put("zdxtsj", zdxtsj.getData());
				requestDate.put("xckzzdjl", "");
				requestDate.put("xcmzzdjl", "");
			}
		} else {// 制动距离
			if (xczzfs.getData().equals("空载")) {
				requestDate.put("xckzmfdd", "");
				requestDate.put("xcmzmfdd", "");
				requestDate.put("zdxtsj", "");
				requestDate.put("xckzzdjl", xczdjl.getData());
				requestDate.put("xcmzzdjl", "");
			} else {
				requestDate.put("xckzmfdd", "");
				requestDate.put("xcmzmfdd", "");
				requestDate.put("zdxtsj", "");
				requestDate.put("xckzzdjl", "");
				requestDate.put("xcmzzdjl", xczdjl.getData());
			}
		}
		requestDate.put("zdwdx", zdwdx.getData());
		requestDate.put("xczdczlz", xczdczlz.getData());
		requestDate.put("zdcsd", zdcsd.getData());
		requestDate.put("lszdpd", lszdpd.getData());
		// 应急制动
		if (yjpdfs.getData().equals("0")) {// MFDD
			if (yjzzfs.getData().equals("空载")) {
				requestDate.put("yjkzzdjl", "");
				requestDate.put("yjkzmfdd", yjmfdd.getData());
				requestDate.put("yjmzzdjl", "");
				requestDate.put("yjmzmfdd", "");
			} else {
				requestDate.put("yjkzzdjl", "");
				requestDate.put("yjkzmfdd", "");
				requestDate.put("yjmzzdjl", "");
				requestDate.put("yjmzmfdd", yjmfdd.getData());
			}
		} else {// 制动距离
			if (yjzzfs.getData().equals("空载")) {
				requestDate.put("yjkzzdjl", yjzdjl.getData());
				requestDate.put("yjkzmfdd", "");
				requestDate.put("yjmzzdjl", "");
				requestDate.put("yjmzmfdd", "");
			} else {
				requestDate.put("yjkzzdjl", "");
				requestDate.put("yjkzmfdd", "");
				requestDate.put("yjmzzdjl", yjzdjl.getData());
				requestDate.put("yjmzmfdd", "");
			}
		}
		requestDate.put("yjzdcsd", yjzdcsd.getData());
		requestDate.put("yjzdczlfs", yjzdczlfs.getData());
		requestDate.put("yjzdczlz", yjzdczlz.getData());
		requestDate.put("yjzdpd", yjzdpd.getData());
		// 驻车
		requestDate.put("zcpd", zcpd.getData());
		requestDate.put("lszczdpd", lszczdpd.getData());
		// 车速表判定
		requestDate.put("csdscz", csdscz.getData());
		requestDate.put("csbpd", csbpd.getData());
		// 判定结论
		requestDate.put("lsjg", lsjg.getData());
	}

	/**
	 * 设置监听
	 */
	private void addEvent() {
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isLX) {
					if (!jyy.getText().toString().equals("")) {
						alert("确定提交路试数据？", new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View view) {
								dialog.dimiss();
								request("18C55", getRequestSubmitBeginDate(),
										R.string.BEGIN_MESSAGE,
										new String[] { "1" });
							}
						});

					} else {
						DefautDialog.showDialog(LsSelect_Activity.this,
								R.string.FORMAT_TITLE,
								R.string.INPUT_JYY_AND_JYYSFZH, false, null,
								null);
					}
				} else {
					Toast.makeText(LsSelect_Activity.this, "录像没结束",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		kslx.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J11", getRequestSubmitKSLXDate(),
							R.string.BEGIN_MESSAGE_KSLX, new String[] { "1" });
				} else {
					Toast.makeText(LsSelect_Activity.this, "检测线代号不能为空！", 1000)
							.show();
				}
			}
		});
		jslx.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J12", getRequestSubmitJSLXDate(),
							R.string.BEGIN_MESSAGE_JSLX, new String[] { "1" });
				} else {
					Toast.makeText(LsSelect_Activity.this, "检测线代号不能为空！", 1000)
							.show();
				}
			}
		});
		xczdkszp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J31", getRequestSubmitXCZDKSZPDate(),
							R.string.BEGIN_MESSAGE_XCZDKSZP,
							new String[] { "1" });
				} else {
					Toast.makeText(LsSelect_Activity.this, "检测线代号不能为空！", 1000)
							.show();
				}
			}
		});
		xczdjszp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J31", getRequestSubmitXCZDJSZPDate(),
							R.string.BEGIN_MESSAGE_XCZDJSZP,
							new String[] { "1" });
				} else {
					Toast.makeText(LsSelect_Activity.this, "检测线代号不能为空！", 1000)
							.show();
				}

			}
		});
		pdzczdzp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J31", getRequestSubmitPDZCZDZPDate(),
							R.string.BEGIN_MESSAGE_PDZCZDZP,
							new String[] { "1" });
				} else {
					Toast.makeText(LsSelect_Activity.this, "检测线代号不能为空！", 1000)
							.show();
				}
			}
		});
		tijdgsj.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent itt = new Intent();
				itt.setClass(LsSelect_Activity.this, TJDGSJ_Activity.class);
				startActivity(itt);
			}
		});
		tizjl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isNotNull()) {
					request("18C82", getRequestSubmit18C82Date(),
							"提交总结论,请稍等、、、", new String[] { "1" });
				} else {
					Toast.makeText(LsSelect_Activity.this, "总结论数据不可空！", 0)
							.show();
				}
			}
		});
	}

	protected boolean isNotNull() {
		if (!jcxdh.getData().toString().equals("")
				&& !zjccs.getData().toString().equals("")
				&& !zczdjyjg.getData().toString().equals("")
				&& !zjlzcpd.getData().toString().equals("")
				&& !jyjl.getData().toString().equals("")
				&& !pzrxm.getData().toString().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	private Map<String, Object> getRequestSubmitJSLXDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("jcxdh", jcxdh_sp.getText().toString());
		requestDate.put("gwxm", "R");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private Map<String, Object> getRequestSubmitKSLXDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("jcxdh", jcxdh_sp.getText().toString());
		requestDate.put("gwxm", "R");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private Map<String, Object> getRequestSubmitXCZDKSZPDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jcxdh", jcxdh_sp.getText().toString());
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("gwjysbbh", "");
		requestDate.put("jyxm", "R1");
		requestDate.put("kssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestDate.put("zpzl", "0341");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private Map<String, Object> getRequestSubmitPDZCZDZPDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jcxdh", jcxdh_sp.getText().toString());
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("gwjysbbh", "");
		requestDate.put("jyxm", "R2");
		requestDate.put("kssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestDate.put("zpzl", "0345");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private Map<String, Object> getRequestSubmitXCZDJSZPDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jcxdh", jcxdh_sp.getText().toString());
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("gwjysbbh", "");
		requestDate.put("jyxm", "R1");
		requestDate.put("kssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestDate.put("zpzl", "0343");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private Map<String, Object> getRequestSubmitLSJYXMDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", "1");
		requestDate.put("jycs", Md_Car_Temp.getTempCar().car_jycs);
		addJYXM(requestDate);
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("lsy", jyy.getText().toString());
		addLSDATA(requestDate);
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	/**
	 * 检验项目判定
	 * 
	 * @param requestDate
	 */
	// 检验项目判定
	private void addJYXM(Map<String, Object> requestDate) {
		if (!lszczdpd.getData().equals("0") && csbpd.getData().equals("0")) {
			requestDate.put("jyxm", "R1,R2");
		} else if (lszczdpd.getData().equals("0")
				&& !csbpd.getData().equals("0")) {
			requestDate.put("jyxm", "R1,R3");
		} else if (!lszczdpd.getData().equals("0")
				&& !csbpd.getData().equals("0")) {
			requestDate.put("jyxm", "R1,R2,R3");
		} else {
			requestDate.put("jyxm", "R1");
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == 4) {
			Intent itt = new Intent();
			itt.setClass(this, LsCarList_Activity.class);
			startActivity(itt);
			finish();
		}
		return true;
	}

	private void alert(String msg, DefautDialog.OnClickListener action) {
		DefautDialog.showDialog(LsSelect_Activity.this, LsSelect_Activity.this
				.getResources().getString(R.string.SYS_TITLE), msg, true,
				action, null);
	}

	private void alert2(String msg, DefautDialog.OnClickListener queding,
			DefautDialog.OnClickListener quxiao) {
		DefautDialog.showDialog(LsSelect_Activity.this, LsSelect_Activity.this
				.getResources().getString(R.string.SYS_TITLE), msg, true,
				queding, quxiao);
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try {
			if ("18C55".equals(jkid)) {
				if (lszdpd.getData().equals("0")
						&& yjzdpd.getData().equals("0")) {
					DefautDialog.showDialog(
							LsSelect_Activity.this,
							LsSelect_Activity.this.getResources().getString(
									R.string.SYS_TITLE), "行车、应急制动不能同时不检验？请确定！",
							true, null, null);
				} else {
					if (!lsjg.getData().equals("0")) {
						request("18C54", getRequestSubmitLSJYXMDate(),
								R.string.REQUEST_SUBJYXM_MESSAGE_ID,
								new String[] { "1" });
					} else {
						DefautDialog.showDialog(LsSelect_Activity.this,
								LsSelect_Activity.this.getResources()
										.getString(R.string.SYS_TITLE),
								"请确定判定结论是否正确？", true, null, null);
					}
				}
				// List<Md_Car_TongYong> callKS = (List<Md_Car_TongYong>)
				// result;
				// dealCallLSKSJY(callKS);
			} else if ("18C54".equals(jkid)) {
				request("18C58", getRequestSubmitEndDate(),
						R.string.END_MESSAGE, new String[] { "1" });
				// List<Md_Car_TongYong> callWGJY = (List<Md_Car_TongYong>)
				// result;
				// dealCallLSJY(callWGJY);
			} else if ("18C58".equals(jkid)) {
				List<Md_Car_TongYong> callJS = (List<Md_Car_TongYong>) result;
				dealCallLSJSJY(callJS);
			} else if ("18J11".equals(jkid)) {
				Map<String, String> kslx = (Map<String, String>) result;
				dealCallKSLX(kslx);
			} else if ("18J12".equals(jkid)) {
				Map<String, String> jslx = (Map<String, String>) result;
				dealCallJSLX(jslx);
			} else if ("18J31".equals(jkid)) {
				Map<String, String> zp = (Map<String, String>) result;
				dealCallZP(zp);
			} else if ("18C82".equals(jkid)) {
				request("18C59", getRequestSubmit18C59Date(),
						"提交总结论,请稍等、、、", new String[] { "1" });
			} else if ("18C59".equals(jkid)) {
				request("18C62", getRequestSubmit18C62Date(),
						"提交总结论,请稍等、、、", new String[] { "1" });
			} else if ("18C62".equals(jkid)) {
				Map<String, String> callJS = (Map<String, String>) result;
				dealCallTJZJL(callJS);
			}
		} catch (Exception e) {
			DefautDialog.showDialog(LsSelect_Activity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	private void dealCallTJZJL(Map<String, String> callJS) {
		if (callJS.get("code").equals("1")) {
			alert("数据提交成功！", new DefautDialog.OnClickListener() {
				@Override
				public void onClick(DefautDialog dialog, View view) {
					dialog.dimiss();
					Intent intent = new Intent(LsSelect_Activity.this,
							LsCarList_Activity.class);
					startActivity(intent);
					LsSelect_Activity.this.finish();
				}
			});
		} else {
			alert(callJS.get("message"), null);
		}
	}

	private Map<String, Object> getRequestSubmit18C62Date() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", jcxdh.getData().toString());
		requestDate.put("jycs", zjccs.getData().toString());
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("jyjl", jyjl.getData().toString());
		requestDate.put("pzrxm", pzrxm.getData().toString());
		requestDate.put("rgjyjgs", "");
		requestDate.put("yqsbjyjgs", "");
		requestDate.put("jybgjy", "");
		requestDate.put("jybgbz", "");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private Map<String, Object> getRequestSubmit18C59Date() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", jcxdh.getData().toString());
		requestDate.put("jycs", zjccs.getData().toString());
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("jssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private Map<String, Object> getRequestSubmit18C82Date() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", jcxdh.getData().toString());
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("ycyxm", "");
		requestDate.put("ycysfzh", "");
		requestDate.put("zczdl", "");
		requestDate.put("zczdpd", "");
		requestDate.put("zczdjyjg", zczdjyjg.getData().toString());
		requestDate.put("zdjccs", "");
		requestDate.put("zcpd", zcpd.getData().toString());
		requestDate.put("zjccs", zjccs.getData().toString());
		requestDate.put("jczczbzl", "");
		requestDate.put("bzzczbzl", "");
		requestDate.put("zczbzlbfb", "");
		requestDate.put("zbzlpd", "");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private void dealCallKSLX(Map<String, String> kslx) {
		if (kslx.get("code").equals("1")) {
			message_linear.setVisibility(View.VISIBLE);
			progresslx.setVisibility(View.VISIBLE);
			textlx_message.setText("正在录像...");
			isLX = false;
			Toast.makeText(this, "----开始录像成功----", 1000).show();
		} else {
			progresslx.setVisibility(View.GONE);
			textlx_message.setText("开始录像失败");
			Toast.makeText(this, "----开始录像失败，请重试----", 1000).show();
		}
	}

	private void dealCallJSLX(Map<String, String> jslx) {
		if (jslx.get("code").equals("1")) {
			progresslx.setVisibility(View.GONE);
			textlx_message.setText("录像已完成");
			isLX = true;
			Toast.makeText(this, "----结束录像成功----", 1000).show();
		} else {
			progresslx.setVisibility(View.INVISIBLE);
			textlx_message.setText("结束录像失败");
			Toast.makeText(this, "----结束录像失败，请重试----", 1000).show();
		}
	}

	private void dealCallZP(Map<String, String> zp) {
		Toast.makeText(this, zp.get("message"), 1000).show();
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
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", "1");
		requestDate.put("jycs", Md_Car_Temp.getTempCar().car_jycs);
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("gwjysbbh", "");
		requestDate.put("jyxm", "R");
		requestDate.put("kssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestMap.put("vehispara", requestDate);
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
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", "1");
		requestDate.put("jycs", Md_Car_Temp.getTempCar().car_jycs);
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("gwjysbbh", "");
		requestDate.put("jyxm", "R");
		requestDate.put("jssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	public void alert(String msg, DefautDialog.OnClickListener qdaction,
			DefautDialog.OnClickListener qxaction) {
		DefautDialog.showDialog(LsSelect_Activity.this, LsSelect_Activity.this
				.getResources().getString(R.string.SYS_TITLE), msg, true,
				qdaction, qxaction);
	}

	private void dealCallLSKSJY(List<Md_Car_TongYong> callKS) {
		if (lszdpd.getData().equals("0") && yjzdpd.getData().equals("0")) {
			DefautDialog.showDialog(
					LsSelect_Activity.this,
					LsSelect_Activity.this.getResources().getString(
							R.string.SYS_TITLE), "行车、应急制动不能同时不检验？请确定！", true,
					null, null);
		} else {
			if (!lsjg.getData().equals("0")) {
				if (callKS.get(0).code.equals("1")) {
					request("18C54", getRequestSubmitLSJYXMDate(),
							R.string.REQUEST_SUBJYXM_MESSAGE_ID,
							new String[] { "1" });
				} else {
					alert(callKS.get(0).message, null);
				}
			} else {
				DefautDialog.showDialog(
						LsSelect_Activity.this,
						LsSelect_Activity.this.getResources().getString(
								R.string.SYS_TITLE), "请确定判定结论是否正确？", true,
						null, null);
			}
		}
	}

	private void dealCallLSJY(List<Md_Car_TongYong> callWGJY) {
		if (callWGJY.get(0).code.equals("1")) {
			request("18C58", getRequestSubmitEndDate(), R.string.END_MESSAGE,
					new String[] { "1" });
		} else {
			alert(callWGJY.get(0).message, null);
		}
	}

	private void dealCallLSJSJY(List<Md_Car_TongYong> callWGJY) {
		if (callWGJY.get(0).code.equals("1")) {
			alert2("路试数据提交成功！是否在平板上提交总结论？", new DefautDialog.OnClickListener() {
				@Override
				public void onClick(DefautDialog dialog, View view) {
					dialog.dimiss();
				}
			}, new DefautDialog.OnClickListener() {
				@Override
				public void onClick(DefautDialog dialog, View view) {
					dialog.dimiss();
					Intent intent = new Intent(LsSelect_Activity.this,
							LsCarList_Activity.class);
					startActivity(intent);
					LsSelect_Activity.this.finish();
				}
			});
		} else {
			alert(callWGJY.get(0).message, null);
		}
	}
}

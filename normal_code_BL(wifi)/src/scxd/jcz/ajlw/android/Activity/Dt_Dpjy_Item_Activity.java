package scxd.jcz.ajlw.android.Activity;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.common.Md_Car_JYXM;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.InfoItemBar;
import scxd.jcz.ajlw.android.model.InfoItemEdt;
import scxd.jcz.ajlw.android.model.InfoItemRdoGrpStyle2;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import scxd.jcz.ajlw.android.model.Md_system;
import scxd.jcz.ajlw.android.model.RgjyItem;
import scxd.jcz.ajlw.android.sign.DialogListenerImp;
import scxd.jcz.ajlw.android.sign.WritePadDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 动态地盘检验项目
 * @author Administrator
 *@time
 */
public class Dt_Dpjy_Item_Activity extends BaseActivity {

	LinearLayout lin_layout = null;
	// LinearLayout lin_layout_xgb = null;
	LinearLayout lin_layout_kx = null;
	InfoItemEdt jyyInfo = null;
	Context contx;
	List<InfoItemRdoGrpStyle2> rdoGrpItems = null;
	// List<InfoItemRdoGrpStyle2> rdoGrpItems_xgb = null;
	List<InfoItemRdoGrpStyle2> rdoGrpItems_kx = null;
	private TextView hphm = null;
	private TextView clsbdh = null;
	private TextView bhgxm = null;
	private TextView kx_text = null;
	private EditText jyy = null;
	private EditText jyysfzhm = null;
	private EditText jyyjy = null;
	private Button submit = null;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestDate = null;
	private List<String> jyxm_dtdp_list = null;
	private String magess="";
	private boolean isBhg = false;
	//录像
	private Button kslx;
	private Button jslx;
	private Button dtdp_kszp;
	private Button dtdp_jszp;
	private Button pdzczdzp;
	private EditText jcxdh_sp;
	private LinearLayout otherZp,dt_Dpjy_LX,message_linear;
	private ProgressBar progresslx;
	private TextView textlx_message;
	private boolean isLX=true;
	
	private ImageView iv_rs_sign;
	private TextView tv_sign;
	private LinearLayout pLayout;
	private Bitmap mSignBitmap;
	private boolean issc=false;
	
	private Date starTime;
/**
 * 初始化界面并获取控件
 */
	private void getView() {
		starTime=new Date();
		hphm = (TextView) findViewById(R.id.inspection_hphm);
		bhgxm = (TextView) findViewById(R.id.bhgxm);
		clsbdh = (TextView) findViewById(R.id.inspection_clsbdh);
		jyy = (EditText) findViewById(R.id.inspection_jyy);
		jyysfzhm = (EditText) findViewById(R.id.inspection_jyysfzhm);
		submit = (Button) findViewById(R.id.submitInspection);
		lin_layout = (LinearLayout) findViewById(R.id.autoAddLayout);
		jyyjy = (EditText) findViewById(R.id.jyyjy);
		// lin_layout_xgb = (LinearLayout) findViewById(R.id.autoAddLayout_xgb);
		kx_text = (TextView) findViewById(R.id.kx_text);
		lin_layout_kx = (LinearLayout) findViewById(R.id.autoAddLayout_kx);
		kslx = (Button) findViewById(R.id.kslx);
		jslx = (Button) findViewById(R.id.jslx);
		dtdp_kszp=(Button) findViewById(R.id.xczdkszp);
		dtdp_kszp.setText("动态地盘开始照片");
		dtdp_jszp=(Button) findViewById(R.id.xczdjszp);
		dtdp_jszp.setText("动态地盘结束照片");
		pdzczdzp=(Button) findViewById(R.id.pdzczdzp);
		pdzczdzp.setVisibility(View.GONE);
		jcxdh_sp = (EditText) findViewById(R.id.jcxdh_sp);
		jcxdh_sp.setText(Md_system.getLsxh());
		kslx.setOnClickListener(lx_Click);
		jslx.setOnClickListener(lx_Click);
		otherZp=(LinearLayout) findViewById(R.id.zp);
		dt_Dpjy_LX=(LinearLayout) findViewById(R.id.zplx_layout);
		message_linear=(LinearLayout) findViewById(R.id.message_linear);
		progresslx=(ProgressBar) findViewById(R.id.progresslx);
		textlx_message=(TextView) findViewById(R.id.textlx_message);
		otherZp.setVisibility(View.VISIBLE);
		dt_Dpjy_LX.setVisibility(View.VISIBLE);
		iv_rs_sign = (ImageView) findViewById(R.id.iv_rs_sign);
		pLayout = (LinearLayout) findViewById(R.id.p_sign);
		if ("是".equals(Md_system.sfSign)) {
			issc=true;
			pLayout.setVisibility(View.VISIBLE);
		}
		iv_rs_sign.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				WritePadDialog dialog = new WritePadDialog(
						Dt_Dpjy_Item_Activity.this, new DialogListenerImp() {

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
		});
		tv_sign = (TextView) findViewById(R.id.tv_sign);
	}

	private void setText() {
		hphm.setText(Md_Car_Temp.getTempCar().car_hphm);
		clsbdh.setText(Md_Car_Temp.getTempCar().car_clsbdh);
		jyy.setText(Md_Car_Temp.getTempCar().userxingming);
		jyysfzhm.setText(Md_Car_Temp.getTempCar().jyysfzh);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inspection_activity);
		getView();
		setText();
		contx = Dt_Dpjy_Item_Activity.this;
		rdoGrpItems = new ArrayList<InfoItemRdoGrpStyle2>();
		// rdoGrpItems_xgb = new ArrayList<InfoItemRdoGrpStyle2>();
		rdoGrpItems_kx = new ArrayList<InfoItemRdoGrpStyle2>();
		addEvent();

		request("18C47", getRequestGetDTDPJYXMDate(),
				R.string.REQUEST_DTDPJYXM_MESSAGE_ID, new String[] { "2" });
	}
/***
 * 设置监听
 */
	private void addEvent() {
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isLX)
				{
				getRequestSubmitDTDPJYXMDate();
				if (isBhg) {
					magess="其中有不合格的项目\n";
				}else{
					magess="";
				}
				if (!jyy.getText().toString().equals("")
						&& !jyysfzhm.getText().toString().equals("")) {
					alert(magess+"确定提交动态底盘检验数据？", new DefautDialog.OnClickListener() {
						@Override
						public void onClick(DefautDialog dialog, View view) {
							dialog.dimiss();
							request("18C55", getRequestSubmitBeginDate(),
									R.string.BEGIN_MESSAGE,
									new String[] { "1" });
						}
					});
				} else {
					DefautDialog.showDialog(Dt_Dpjy_Item_Activity.this,
							R.string.FORMAT_TITLE,
							R.string.INPUT_JYY_AND_JYYSFZH, false, null, null);
				}
			}else{
				Toast.makeText(Dt_Dpjy_Item_Activity.this, "录像没结束", Toast.LENGTH_SHORT).show();
			}
			}
		});
		
		dtdp_kszp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J31", getRequestSubmitXCZDKSZPDate(),
							R.string.BEGIN_MESSAGE_DTDPKSZP,
							new String[] { "1" });
				} else {
					Toast.makeText(Dt_Dpjy_Item_Activity.this, "检测线代号不能为空！", 1000)
							.show();
				}
			}
		});
		dtdp_jszp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J31", getRequestSubmitXCZDJSZPDate(),
							R.string.BEGIN_MESSAGE_DTDPJSZP,
							new String[] { "1" });
				} else {
					Toast.makeText(Dt_Dpjy_Item_Activity.this, "检测线代号不能为空！", 1000)
							.show();
				}
			}
		});
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
		requestDate.put("jyxm", "DC");
		requestDate.put("kssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestDate.put("zpzl", "0344");
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
		requestDate.put("jyxm", "DC");
		requestDate.put("kssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestDate.put("zpzl", "0342");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}
	/****开始与结束录像的点击事件***/
	private OnClickListener lx_Click=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v==kslx)
			{
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J11", getRequestSubmitKSLXDate(),
							R.string.BEGIN_MESSAGE_KSLX, new String[] { "1" });
				} else {
					Toast.makeText(Dt_Dpjy_Item_Activity.this, "检测线代号不能为空！", 1000)
							.show();
				}
			}else if(v==jslx)
			{
				if (!TextUtils.isEmpty(jcxdh_sp.getText().toString())) {
					request("18J12", getRequestSubmitJSLXDate(),
							R.string.BEGIN_MESSAGE_JSLX, new String[] { "1" });
				} else {
					Toast.makeText(Dt_Dpjy_Item_Activity.this, "检测线代号不能为空！", 1000)
							.show();
				}
			}
		}
	};
	/**
	 * 获取车辆列表请求数据
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestGetDTDPJYXMDate() {
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
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestMap.put("QueryCondition", requestDate);
		return requestMap;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == 4) {
			Intent itt = new Intent();
			if (Md_Car_Temp.getTempCar().FromDTDPlistToDTDPItem.equals("yes")) {
				itt.setClass(Dt_Dpjy_Item_Activity.this,
						Dt_DpjyCarList_Activity.class);
			} else {
				itt.setClass(Dt_Dpjy_Item_Activity.this, CarLoginActivity.class);
			}
			startActivity(itt);
			Dt_Dpjy_Item_Activity.this.finish();
		}
		return true;
	}

	private void alert(String msg, DefautDialog.OnClickListener action) {
		DefautDialog.showDialog(
				Dt_Dpjy_Item_Activity.this,
				Dt_Dpjy_Item_Activity.this.getResources().getString(
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
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", "2");
		requestDate.put("jycs", Md_Car_Temp.getTempCar().car_jycs);
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("gwjysbbh", "");
		requestDate.put("jyxm", "DC");
		requestDate.put("kssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(starTime));
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
		requestDate.put("jcxdh", "2");
		requestDate.put("jycs", Md_Car_Temp.getTempCar().car_jycs);
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("gwjysbbh", "");
		requestDate.put("jyxm", "DC");
		requestDate.put("jssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try{
		if ("18C47".equals(jkid)) {
			Map<String, String> jyxm = (Map<String, String>) result;
			if (jyxm.get("hasbody").equals("no")
					|| jyxm.get("dtdpjyxm").equals("")) {
				Dt_Dpjy_Item_Activity.this.alert("查询动态底盘检验项目失败，请重试！",
						new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View view) {
								dialog.dimiss();
								request("18C47", getRequestGetDTDPJYXMDate(),
										R.string.REQUEST_DTDPJYXM_MESSAGE_ID,
										new String[] { "2" });
							}
						}, new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View view) {
								dialog.dimiss();
							}
						});
			} else {
				dealDTDPJYXM(jyxm);
				dealKXDTDPJYXM(jyxm);
			}
		} else if ("18C55".equals(jkid)) {
			if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
					|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
					|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
					|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
					|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
					|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
					|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
				if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
					request("18C68", getRequestSubmitDTDPJYXMDate(),
							R.string.REQUEST_SUBJYXM_MESSAGE_ID,
							new String[] { "1" });
				} else if (Md_Car_Temp.getTempCar().pdyj.equals("2")) {
					request("18C80", getRequestSubmitDTDPJYXMDate2(),
							R.string.REQUEST_SUBJYXM_MESSAGE_ID,
							new String[] { "1" });
				}else{
					request("18C80", getRequestSubmitDTDPJYXMDate2(),
							R.string.REQUEST_SUBJYXM_MESSAGE_ID,
							new String[] { "1" });
				}
			} else {
				if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
					request("18C53", getRequestSubmitDTDPJYXMDate(),
							R.string.REQUEST_SUBJYXM_MESSAGE_ID,
							new String[] { "1" });
				} else if (Md_Car_Temp.getTempCar().pdyj.equals("2")) {
					request("18C80", getRequestSubmitDTDPJYXMDate2(),
							R.string.REQUEST_SUBJYXM_MESSAGE_ID,
							new String[] { "1" });
				} else{
					request("18C80", getRequestSubmitDTDPJYXMDate2(),
							R.string.REQUEST_SUBJYXM_MESSAGE_ID,
							new String[] { "1" });
				}
			}
		} else if ("18C80".equals(jkid)) {
			request("18C58", getRequestSubmitEndDate(), R.string.END_MESSAGE,
					new String[] { "1" });
		} else if ("18C53".equals(jkid) || "18C68".equals(jkid)) {
			request("18C58", getRequestSubmitEndDate(), R.string.END_MESSAGE,
					new String[] { "1" });
		} else if ("18C58".equals(jkid)) {
			List<Md_Car_TongYong> callJS = (List<Md_Car_TongYong>) result;
			dealCallDTDPJSJY(callJS);
		}else if ("18J11".equals(jkid)) {
			Map<String, String> kslx = (Map<String, String>) result;
			dealCallKSLX(kslx);
		} else if ("18J12".equals(jkid)) {
			Map<String, String> jslx = (Map<String, String>) result;
			dealCallJSLX(jslx);
		}else if ("18J31".equals(jkid)) {
			Map<String, String> zp = (Map<String, String>) result;
			dealCallZP(zp);
		}
		}catch (Exception e) {
			DefautDialog.showDialog(Dt_Dpjy_Item_Activity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	private Map<String, Object> getRequestSubmitDTDPJYXMDate() {
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
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", "2");
		requestDate.put("jycs", Md_Car_Temp.getTempCar().car_jycs);
		requestDate.put("jyxm", "DC");
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		// if (rdoGrpItems.size() > Md_Car_JYXM.Car_dtdpjyxml2.size()) {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_dtdpjyxml);
		// } else {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_dtdpjyxml2);
		// }
		if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
				|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
			if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
				Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
						requestDate, Md_Car_JYXM.mt_dtdpjyxm);
			}else if (Md_Car_Temp.getTempCar().pdyj.equals("2")) {
				Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
						requestDate, Md_Car_JYXM.Car_dtdpjyxml);
			}  else {
				Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
						requestDate, Md_Car_JYXM.Car_dtdpjyxml);
			}
			requestDate.put("sfsl", 1);
		} else {
			Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
					requestDate, Md_Car_JYXM.Car_dtdpjyxml);
		}
		requestDate.put("dpdtjyy", jyy.getText().toString());
		requestDate.put("dpdtjyysfzh", jyysfzhm.getText().toString());
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private Map<String, Object> getRequestSubmitDTDPJYXMDate2() {
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
		if (rdoGrpItems_kx != null && rdoGrpItems_kx.size() > 0) {
			for (InfoItemRdoGrpStyle2 rdoGrpItem : rdoGrpItems_kx) {
				if (!jyxm_dtdp_list.contains(rdoGrpItem.getItemID())) {
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
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", "2");
		requestDate.put("jycs", Md_Car_Temp.getTempCar().car_jycs);
		requestDate.put("jyxm", "DC");
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		// if (rdoGrpItems.size() > Md_Car_JYXM.Car_dtdpjyxml2.size()) {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_dtdpjyxml);
		// } else {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_dtdpjyxml2);
		// }
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_dtdpjyxml3);
		// 新增

		// List<String> yjyxm = Arrays.asList((bhgx.toString() + hgx.toString())
		// .split(","));
		// if (yjyxm.get(0).length() == 2) {
		Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
				requestDate, Md_Car_JYXM.Car_dtdpjyxml2);
		// } else if (yjyxm.get(0).length() == 3) {
		// Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
		// requestDate, Md_Car_JYXM.Car_dtdpjyxml);
		// }
		requestDate.put("dtdpbhgyy", wgbhgyy.toString());
		requestDate.put("jyyjy", jyyjy.getText().toString());

		requestDate.put("dpdtjyy", jyy.getText().toString());
		requestDate.put("dpdtjyysfzh", jyysfzhm.getText().toString());
		if (issc) {
			requestDate.put("ZP", getbitmapString());
		}
		requestMap.put("vehispara", requestDate);
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
	public void alert(String msg, DefautDialog.OnClickListener qdaction,
			DefautDialog.OnClickListener qxaction) {
		DefautDialog.showDialog(
				Dt_Dpjy_Item_Activity.this,
				Dt_Dpjy_Item_Activity.this.getResources().getString(
						R.string.SYS_TITLE), msg, true, qdaction, qxaction);
	}

	private void dealKXDTDPJYXM(Map<String, String> rgwj_map) {
		String[] jyxms = null;
		List<RgjyItem> rgjyItems = null;
		if (rgwj_map.get("kxdpdtfjx") != null
				&& !rgwj_map.get("kxdpdtfjx").equals("")) {
			kx_text.setVisibility(View.VISIBLE);
			lin_layout_kx.setVisibility(View.VISIBLE);
			jyxms = rgwj_map.get("kxdpdtfjx").split(",");
			if (jyxms.length > 0) {
				if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
					if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.mt_dtdpjyflname3,
								Md_Car_JYXM.mt_dtdpjyfl3,
								Md_Car_JYXM.mt_dtdpjyxm3);
					} else if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.dtdpjyflname3,
								Md_Car_JYXM.dtdpjyfl3,
								Md_Car_JYXM.Car_dtdpjyxm3);
					} else {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.dtdpjyflname3,
								Md_Car_JYXM.dtdpjyfl3,
								Md_Car_JYXM.Car_dtdpjyxm3);
					}
				} else {
					rgjyItems = Md_Car_JYXM.getItems(jyxms,
							Md_Car_JYXM.dtdpjyflname3, Md_Car_JYXM.dtdpjyfl3,
							Md_Car_JYXM.Car_dtdpjyxm3);
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

	List<String> dpdtfjxs = null;
/**
 * 动态底盘检验项目数据解析
 * @param dtdpjyxm_map
 */
	private void dealDTDPJYXM(Map<String, String> dtdpjyxm_map) {
		try {
			if (!dtdpjyxm_map.get("dpdtfjx").equals("")) {
				bhgxm.setText(dtdpjyxm_map.get("dpdtfjx"));
				dpdtfjxs = Arrays
						.asList(dtdpjyxm_map.get("dpdtfjx").split(","));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Md_Car_Temp.getTempCar().pdyj = dtdpjyxm_map.get("pdyj");
		String[] jyxms = null;
		List<RgjyItem> rgjyItems = null;
		String[] jyxms_xgb = new String[] { "41", "42", "43", "44" };
		// List<RgjyItem> rgjyItems_xgb = null;
		if (!dtdpjyxm_map.get("dtdpjyxm").equals("")) {
			jyxms = dtdpjyxm_map.get("dtdpjyxm").split(",");
			jyxm_dtdp_list = Arrays.asList(jyxms);
			if (jyxms.length > 0) {
				// if(jyxms[0].length()!=2){
				// jyxms=jyxms_xgb;
				// }
				if (Md_Car_Temp.getTempCar().car_lx.equals("M11")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M12")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M13")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M14")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M15")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M21")
						|| Md_Car_Temp.getTempCar().car_lx.equals("M22")) {
					if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.mt_dtdpjyflname3,
								Md_Car_JYXM.mt_dtdpjyfl3,
								Md_Car_JYXM.mt_dtdpjyxm3);
					}else if (Md_Car_Temp.getTempCar().pdyj.equals("1")) {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.dtdpjyflname3,
								Md_Car_JYXM.dtdpjyfl3,
								Md_Car_JYXM.Car_dtdpjyxm3);
					} else {
						rgjyItems = Md_Car_JYXM.getItems(jyxms,
								Md_Car_JYXM.dtdpjyflname3,
								Md_Car_JYXM.dtdpjyfl3,
								Md_Car_JYXM.Car_dtdpjyxm3);
					}
				} else {
					rgjyItems = Md_Car_JYXM.getItems(jyxms,
							Md_Car_JYXM.dtdpjyflname3, Md_Car_JYXM.dtdpjyfl3,
							Md_Car_JYXM.Car_dtdpjyxm3);
				}
				// rgjyItems_xgb = Md_Car_JYXM.getItems(jyxms_xgb,
				// Md_Car_JYXM.dtdpjyflname2, Md_Car_JYXM.dtdpjyfl2,
				// Md_Car_JYXM.Car_dtdpjyxm2);
			} else {
				jyxms = jyxms_xgb;
				jyxm_dtdp_list = Arrays.asList(jyxms);
				rgjyItems = Md_Car_JYXM.getItems(jyxms,
						Md_Car_JYXM.dtdpjyflname3, Md_Car_JYXM.dtdpjyfl3,
						Md_Car_JYXM.Car_dtdpjyxm3);
			}
			// else {
			// rgjyItems = Md_Car_JYXM.getItems(jyxms,
			// Md_Car_JYXM.dtdpjyflname2, Md_Car_JYXM.dtdpjyfl2,
			// Md_Car_JYXM.Car_dtdpjyxm2);
			// }
		}
		if (rgjyItems != null && rgjyItems.size() > 0) {
			for (RgjyItem rgjyItem : rgjyItems) {
				if (rgjyItem.msg != null) {
					InfoItemBar itemBar = new InfoItemBar(contx, rgjyItem.msg);
					for (RgjyItem.Item item : rgjyItem.items) {
						InfoItemRdoGrpStyle2 rdoGrpItem;
						if (dpdtfjxs != null && dpdtfjxs.contains(item.code)) {
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
			// }
		} else {
			DefautDialog.showDialog(
					Dt_Dpjy_Item_Activity.this,
					Dt_Dpjy_Item_Activity.this.getResources().getString(
							R.string.SYS_TITLE), "获取查询数据失败，请重试！", false, null,
					null);
		}
	}

	private void dealCallDTDPKSJY(List<Md_Car_TongYong> callKS) {
		if (callKS.get(0).code.equals("1")) {
			request("18C53", getRequestSubmitDTDPJYXMDate2(),
					R.string.REQUEST_SUBJYXM_MESSAGE_ID, new String[] { "1" });
		} else {
			alert(callKS.get(0).message, null);
		}
	}

	private void dealCallDTDPJY(List<Md_Car_TongYong> callWGJY) {
		if (callWGJY.get(0).code.equals("1")) {
			request("18C58", getRequestSubmitEndDate(), R.string.END_MESSAGE,
					new String[] { "1" });
		} else {
			alert(callWGJY.get(0).message, null);
		}
	}

	private void dealCallDTDPJSJY(List<Md_Car_TongYong> callWGJY) {
		if (callWGJY.get(0).code.equals("1")) {
			alert("数据提交成功！", new DefautDialog.OnClickListener() {
				@Override
				public void onClick(DefautDialog dialog, View view) {
					dialog.dimiss();
					Intent itt = new Intent();
					if (Md_Car_Temp.getTempCar().FromDTDPlistToDTDPItem
							.equals("yes")) {
						itt.setClass(Dt_Dpjy_Item_Activity.this,
								Dt_DpjyCarList_Activity.class);
					} else {
						itt.setClass(Dt_Dpjy_Item_Activity.this,
								CarLoginActivity.class);
					}
					startActivity(itt);
					Dt_Dpjy_Item_Activity.this.finish();
				}
			});
		} else {
			alert(callWGJY.get(0).message, null);
		}
	}
	
	/***开始录像的参数**/
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
		requestDate.put("gwxm", "DC");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}
	/***结束录像的参数**/
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
		requestDate.put("gwxm", "DC");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}
	private void dealCallKSLX(Map<String, String> kslx) {
		if (kslx.get("code").equals("1")) {
			message_linear.setVisibility(View.VISIBLE);
			progresslx.setVisibility(View.VISIBLE);
			textlx_message.setText("正在录像...");
			isLX=false;
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
			isLX=true;
			Toast.makeText(this, "----结束录像成功----", 1000).show();
		} else {
			progresslx.setVisibility(View.INVISIBLE);
			textlx_message.setText("结束录像失败");
			isLX=false;
			Toast.makeText(this, "----结束录像失败，请重试----", 1000).show();
		}
	}
	private void dealCallZP(Map<String, String> zp) {
		Toast.makeText(this, zp.get("message"), 1000).show();
	}
	@Override
	protected void onDestroy() {
		if (mSignBitmap != null) {
			mSignBitmap.recycle();
			mSignBitmap = null;
		}
		super.onDestroy();
	}
}

package scxd.jcz.ajlw.android.Activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_JYXM;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.InfoItemBar;
import scxd.jcz.ajlw.android.model.InfoItemRdoGrpStyle2;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import scxd.jcz.ajlw.android.model.Md_system;
import scxd.jcz.ajlw.android.model.RgjyItem;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * 车辆查验
 * @author Administrator
 *
 */
public class InspectionWebActivity extends BaseActivity {
	LinearLayout lin_layout = null;
	Context contx;
	List<InfoItemRdoGrpStyle2> rdoGrpItems = null;
	private TextView hphm = null;
	private TextView clsbdh = null;
	private TextView xgb_text = null;
	private TextView lgb_text = null;
	private EditText jyy = null;
	private EditText jyysfzhm = null;
	private Button submit = null;

	private void getView() {
		hphm = (TextView) findViewById(R.id.inspection_hphm);
		clsbdh = (TextView) findViewById(R.id.inspection_clsbdh);
		xgb_text = (TextView) findViewById(R.id.xgb_text);
		xgb_text.setVisibility(View.GONE);
		lgb_text = (TextView) findViewById(R.id.lgb_text);
		lgb_text.setVisibility(View.GONE);
		jyy = (EditText) findViewById(R.id.inspection_jyy);
		jyysfzhm = (EditText) findViewById(R.id.inspection_jyysfzhm);
		submit = (Button) findViewById(R.id.submitInspection);
		lin_layout = (LinearLayout) findViewById(R.id.autoAddLayout);
		findViewById(R.id.inspection_ywlx_value_layout).setVisibility(
				View.VISIBLE);
	}

	private void setText() {
		hphm.setText(Md_Car_Temp.getTempCar().car_hphm);
		clsbdh.setText(Md_Car_Temp.getTempCar().car_clsbdh);
		jyy.setText(Md_Car_Temp.getTempCar().userxingming);
		jyysfzhm.setText(Md_Car_Temp.getTempCar().jyysfzh);
		Md_Car_Temp.getTempCar().ywlx = 7;
		((TextView) findViewById(R.id.inspection_ywlx_value))
				.setText(MD_ListItem.getYwlx(Md_Car_Temp.getTempCar().ywlx));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inspection_activity);
		getView();
		setText();
		contx = InspectionWebActivity.this;
		rdoGrpItems = new ArrayList<InfoItemRdoGrpStyle2>();
		addEvent();
		request("18C47", getRequestGetDPJYXMDate(),
				R.string.REQUEST_CYXM_MESSAGE_ID, new String[] { "2" });
	}

	/**
	 * 获取车辆列表请求数据
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestGetDPJYXMDate() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		Map<String, Object> requestPZXMDate = new HashMap<String, Object>();
		requestPZXMDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestPZXMDate.put("jyjgbh", Md_system.getDzkey());
		requestPZXMDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestPZXMDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestMap.put("QueryCondition", requestPZXMDate);
		return requestMap;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == 4) {
			Intent itt = new Intent();
			if (Md_Car_Temp.getTempCar().FromCylistToCyItem.equals("yes")) {
				itt.setClass(InspectionWebActivity.this,
						InspectionActivity.class);
			} else {
				itt.setClass(InspectionWebActivity.this,
						Dt_Dpjy_Item_Activity.class);
			}
			startActivity(itt);
			InspectionWebActivity.this.finish();
		}
		return false;
	}

	private void alert(String msg, DefautDialog.OnClickListener action) {
		DefautDialog.showDialog(
				InspectionWebActivity.this,
				InspectionWebActivity.this.getResources().getString(
						R.string.SYS_TITLE), msg, true, action, null);
	}

	/**
	 * 添加事件
	 */
	private void addEvent() {
		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!jyy.getText().toString().equals("")
						&& !jyysfzhm.getText().toString().equals("")) {
					alert("确定提交查验检验数据？", new DefautDialog.OnClickListener() {
						@Override
						public void onClick(DefautDialog dialog, View view) {
							dialog.dimiss();
							request("18C57", getRequestSubmitCHYYANJYXMDate(),
									R.string.BEGIN_MESSAGE,
									new String[] { "1" });
						}
					});
				} else {
					DefautDialog.showDialog(InspectionWebActivity.this,
							R.string.FORMAT_TITLE,
							R.string.INPUT_JYY_AND_JYYSFZH, false, null, null);
				}
			}
		});
	}

	private Map<String, Object> getRequestSubmitCHYYANJYXMDate() {
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
		Map<String, Object> requestMap = new HashMap<String, Object>();
		Map<String, Object> requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("jcxdh", "1");
		requestDate.put("jycs", Md_Car_Temp.getTempCar().car_jycs);
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("syr", Md_Car_Temp.getTempCar().userxingming);
		requestDate.put("ywlx", "P");
		if (Md_Car_Temp.getTempCar().car_lx.equals("K18")
				|| Md_Car_Temp.getTempCar().car_lx.equals("K28")
				|| Md_Car_Temp.getTempCar().car_lx.equals("K38")
				|| Md_Car_Temp.getTempCar().car_syxz.equals("O")
				|| Md_Car_Temp.getTempCar().car_syxz.equals("P")
				|| Md_Car_Temp.getTempCar().car_syxz.equals("Q")) {
			requestDate.put("cyzl", "1");
			Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
					requestDate, Md_Car_JYXM.Car_cyxmxcl);
		} else {
			requestDate.put("cyzl", "0");
			Md_Car_JYXM.getXMLAndValue(bhgx.toString(), hgx.toString(),
					requestDate, Md_Car_JYXM.Car_cyxml);
		}
		requestDate.put("cyjl", "1");
		requestDate.put("cyyxm", jyy.getText().toString());
		requestDate.put("cyysfzmhm", jyysfzhm.getText().toString());// 510103196512033458
		requestDate.put("cyrq",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestDate.put("fjhgbj", "");
		requestDate.put("fjyxm", "");
		requestDate.put("fjysfzmhm", "");
		requestDate.put("fjrq", "");
		requestDate.put("bz", "");
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try{
		if ("18C47".equals(jkid)) {
			Map<String, String> jyxm = (Map<String, String>) result;
			if (jyxm.get("hasbody").equals("no") || jyxm.get("cyxm").equals("")) {
				InspectionWebActivity.this.alert("查询查验检验项目失败，请重试！",
						new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View view) {
								dialog.dimiss();
								request("18C47", getRequestGetDPJYXMDate(),
										R.string.REQUEST_CYXM_MESSAGE_ID,
										new String[] { "2" });
							}
						}, new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View view) {
								dialog.dimiss();
							}
						});
			} else {
				dealCYJYXM(jyxm);
			}
		} else if ("18C57".equals(jkid)) {
			List<Md_Car_TongYong> callKS = (List<Md_Car_TongYong>) result;
			dealCallCY(callKS);
		}
		}catch (Exception e) {
			DefautDialog.showDialog(InspectionWebActivity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	public void alert(String msg, DefautDialog.OnClickListener qdaction,
			DefautDialog.OnClickListener qxaction) {
		DefautDialog.showDialog(
				InspectionWebActivity.this,
				InspectionWebActivity.this.getResources().getString(
						R.string.SYS_TITLE), msg, true, qdaction, qxaction);
	}

	private void dealCYJYXM(Map<String, String> cy_map) {
		String[] jyxms = null;
		List<RgjyItem> rgjyItems = null;
		Md_Car_Temp.getTempCar().pdyj = cy_map.get("pdyj");
		if (!cy_map.get("cyxm").equals("")) {
			jyxms = cy_map.get("cyxm").split(",");
			if (Md_Car_Temp.getTempCar().car_lx.equals("K18")
					|| Md_Car_Temp.getTempCar().car_lx.equals("K28")
					|| Md_Car_Temp.getTempCar().car_lx.equals("K38")
					|| Md_Car_Temp.getTempCar().car_syxz.equals("O")
					|| Md_Car_Temp.getTempCar().car_syxz.equals("P")
					|| Md_Car_Temp.getTempCar().car_syxz.equals("Q")) {
				rgjyItems = Md_Car_JYXM.getItems(jyxms, Md_Car_JYXM.cyxcflname,
						Md_Car_JYXM.cyxcfl, Md_Car_JYXM.Car_cyxmxc);
			} else {
				rgjyItems = Md_Car_JYXM.getItems(jyxms, Md_Car_JYXM.cytyflname,
						Md_Car_JYXM.cytyfl, Md_Car_JYXM.Car_cyxm);
			}
		}
		if (rgjyItems != null && rgjyItems.size() > 0) {
			for (RgjyItem rgjyItem : rgjyItems) {
				if (rgjyItem.msg != null) {
					InfoItemBar itemBar = new InfoItemBar(contx, rgjyItem.msg);
					for (RgjyItem.Item item : rgjyItem.items) {
						InfoItemRdoGrpStyle2 rdoGrpItem = new InfoItemRdoGrpStyle2(
								contx, item);
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
		} else {
			DefautDialog.showDialog(
					InspectionWebActivity.this,
					InspectionWebActivity.this.getResources().getString(
							R.string.SYS_TITLE), "获取查询数据失败，请重试！", false, null,
					null);
		}
	}

	private void dealCallCY(List<Md_Car_TongYong> callCY) {
		if (callCY.get(0).code.equals("1")) {
			alert("数据提交成功！", new DefautDialog.OnClickListener() {
				@Override
				public void onClick(DefautDialog dialog, View view) {
					dialog.dimiss();
					Intent itt = new Intent();
					if (Md_Car_Temp.getTempCar().FromCylistToCyItem
							.equals("yes")) {
						itt.setClass(InspectionWebActivity.this,
								InspectionActivity.class);
					} else {
						itt.setClass(InspectionWebActivity.this,
								Dt_Dpjy_Item_Activity.class);
					}
					startActivity(itt);
					InspectionWebActivity.this.finish();
				}
			});
		} else {
			alert(callCY.get(0).message, null);
		}
	}
}

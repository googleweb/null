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
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TJDGSJ_Activity extends BaseActivity {
	private TextView hphm = null;
	private TextView clsbdh = null;
	private EditText jyy = null;
	private Button submit = null;
	private ItemLayout lsData = null;
	private Map<String, Object> requestMap = null;
	private Map<String, Object> requestDate = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inspection_dg_activity);
		getView();
		setText();
		addEvent();
		initJYXMDGDATA();
	}

	private InfoItem dgwz;
	private InfoItem dg;
	private InfoItem wjgdg;
	private InfoItem wygqd;
	private InfoItem wygqdpd;
	private InfoItem wygszpz;
	private InfoItem jgszcz;
	private InfoItem wygczpy;
	private InfoItem wjgczpy;
	private InfoItem wygczpypd;
	private InfoItem wjgczpypd;
	private InfoItem wdpd;
	private InfoItem jcxdh;
	private InfoItem jycs;
	private InfoItem gwjysbbh;

	private void initJYXMDGDATA() {
		lsData.initItemBars(new String[] { "�ƹ�" });
		dgwz = new InfoItemSp(this, "�ƹ�", "dgwz", MD_ListItem.Get_dgwz(), null);
		jcxdh = new InfoItemSp(this, "����ߴ���", "jcxdh", MD_ListItem.Get_jcxdh(),
				null);
		jycs = new InfoItemSp(this, "������", "jycs", MD_ListItem.Get_jycs(),
				null);
		gwjysbbh = new InfoItemEdt(this, "����߹�λ���", null, null, "gwjysbbh",
				1 | 8192, null, false);
		dg = new InfoItemEdt(this, "Զ��Ƹ�", " mm", "0", "dg", 2 | 8192, null,
				true);
		wjgdg = new InfoItemEdt(this, "����Ƹ�", " mm", "0", "wjgdg", 2 | 8192,
				null, true);
		wygqd = new InfoItemEdt(this, "Զ��ǿ��ֵ", " cd", "0", "wygqd", 2 | 8192,
				null, true);
		wygqdpd = new InfoItemSp(this, "Զ��ǿ���ж�", "wygqdpd",
				MD_ListItem.Get_jlpd(), null);
		wygszpz = new InfoItemEdt(this, "Զ�ⴹֱƫ��ֵ", " mm/10m", "0", "wygszpz",
				2 | 8192, null, true);
		jgszcz = new InfoItemEdt(this, "���ⴹֱƫ��ֵ", " mm/10m", "0", "jgszcz",
				2 | 8192, null, true);
		wygczpy = new InfoItemEdt(this, "Զ�ⴹֱƫ��", null, "0", "wygczpy",
				2 | 8192, null, true);
		wjgczpy = new InfoItemEdt(this, "���ⴹֱƫ��", null, "0", "wjgczpy",
				2 | 8192, null, true);
		wygczpypd = new InfoItemSp(this, "Զ�ⴹֱƫ���ж�", "wygczpypd",
				MD_ListItem.Get_jlpd(), null);
		wjgczpypd = new InfoItemSp(this, "���ⴹֱƫ���ж�", "wjgczpypd",
				MD_ListItem.Get_jlpd(), null);
		wdpd = new InfoItemSp(this, "���ж�", "wdpd", MD_ListItem.Get_jlpd(), null);

		lsData.addItem(0, dgwz);
		lsData.addItem(0, jcxdh);
		lsData.addItem(0, jycs);
		lsData.addItem(0, gwjysbbh);
		lsData.addItem(0, dg);
		lsData.addItem(0, wjgdg);
		lsData.addItem(0, wygqd);
		lsData.addItem(0, wygqdpd);
		lsData.addItem(0, wygszpz);
		lsData.addItem(0, jgszcz);
		lsData.addItem(0, wygczpy);
		lsData.addItem(0, wjgczpy);
		lsData.addItem(0, wygczpypd);
		lsData.addItem(0, wjgczpypd);
		lsData.addItem(0, wdpd);
		lsData.setShow(0, true);
	}

	private void addEvent() {
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!gwjysbbh.getData().toString().trim().equals("")) {
					request("18C55", getRequestSubmitBeginDate(),
							R.string.BEGIN_MESSAGE, new String[] { "1" });
				} else {
					Toast.makeText(TJDGSJ_Activity.this, "����߹�λ��Ų���Ϊ��", 1000)
							.show();
				}
			}
		});
	}

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
		requestDate.put("jcxdh", jcxdh.getData().toString().trim());
		requestDate.put("jycs", jycs.getData().toString().trim());
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("gwjysbbh", gwjysbbh.getData().toString().trim());
		if (dgwz.getData().toString().trim().equals("0")) {
			requestDate.put("jyxm", "H1");
		} else {
			requestDate.put("jyxm", "H4");
		}
		requestDate.put("kssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private Map<String, Object> getRequestSubmitDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = lsData.getDataNodeAndValue(dgwz.getData().trim());
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		if (dgwz.getData().toString().trim().equals("0")) {
			requestDate.put("jyxm", "H1");
		} else {
			requestDate.put("jyxm", "H4");
		}
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private void setText() {
		hphm.setText(Md_Car_Temp.getTempCar().car_hphm);
		clsbdh.setText(Md_Car_Temp.getTempCar().car_clsbdh);
		jyy.setText(Md_Car_Temp.getTempCar().userxingming);
	}

	private void getView() {
		hphm = (TextView) findViewById(R.id.inspection_hphm);
		clsbdh = (TextView) findViewById(R.id.inspection_clsbdh);
		jyy = (EditText) findViewById(R.id.inspection_jyy);
		submit = (Button) findViewById(R.id.submitInspection);
		lsData = (ItemLayout) findViewById(R.id.lsDataLayout);
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try {
			if ("18C55".equals(jkid)) {
				request("18C81", getRequestSubmitDate(),
						R.string.REQUEST_SUBJYXM_MESSAGE_ID,
						new String[] { "1" });
			} else if ("18C81".equals(jkid)) {
				request("18C58", getRequestSubmitEndDate(),
						R.string.END_MESSAGE, new String[] { "1" });
			} else if ("18C58".equals(jkid)) {
				List<Md_Car_TongYong> callJS = (List<Md_Car_TongYong>) result;
				dealCallWGJSJY(callJS);
			}
		} catch (Exception e) {
			DefautDialog.showDialog(TJDGSJ_Activity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	private void dealCallWGJSJY(List<Md_Car_TongYong> callJS) {
		if (callJS.get(0).code.equals("1")) {
			alert("�����ύ�ɹ���", new DefautDialog.OnClickListener() {
				@Override
				public void onClick(DefautDialog dialog, View view) {
					dialog.dimiss();
					TJDGSJ_Activity.this.finish();
				}
			});
		} else {
			alert(callJS.get(0).message, null);
		}
	}

	private void alert(String msg, DefautDialog.OnClickListener action) {
		DefautDialog.showDialog(TJDGSJ_Activity.this, TJDGSJ_Activity.this
				.getResources().getString(R.string.SYS_TITLE), msg, true,
				action, null);
	}

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
		requestDate.put("jcxdh", jcxdh.getData().toString().trim());
		requestDate.put("jycs", jycs.getData().toString().trim());
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("gwjysbbh", gwjysbbh.getData().toString().trim());
		if (dgwz.getData().toString().trim().equals("0")) {
			requestDate.put("jyxm", "H1");
		} else {
			requestDate.put("jyxm", "H4");
		}
		requestDate.put("jssj",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

}

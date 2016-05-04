package scxd.jcz.ajlw.android.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Adapter.CarBP_Adapter;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.MD_Xml_Node;
import scxd.jcz.ajlw.android.model.Md_cartype;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
/**
 * 照片补拍
 * @author Administrator
 *@time
 */
public class ReTakePictureActivity extends BaseActivity {

	private EditText text_hphm;
	private Spinner spinner_car_hpzl;
	private EditText text_vin;
	private Button car_login_btu_qx;
	private Button car_login_btu_dl;
	private ListView listView;
	private TextView nullData;
	Map<String, Object> requestMap =null;
	Map<String, Object> requestDate =null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.retakepicture_activity);
		init();
	}

	/**
	 * 初始化数据
	 * 
	 * @return
	 */
	void init() {
		try {
			Md_Car_Temp.getTempCar().FromReTakeToPz="";
			text_hphm = (EditText) findViewById(R.id.car_login_text_hphm);
			text_vin = (EditText) findViewById(R.id.car_login_text_vin);
			spinner_car_hpzl = (Spinner) findViewById(R.id.spinner_car_hpzl);
			car_login_btu_dl = (Button) findViewById(R.id.car_login_btu_dl);
			car_login_btu_qx = (Button) findViewById(R.id.car_login_btu_qx);
			listView = (ListView) findViewById(R.id.cl_listview);
			nullData = (TextView) findViewById(R.id.nullDataList);
			// 适配号牌种类
			ArrayAdapter<Md_cartype> Adapter_hplx = new ArrayAdapter<Md_cartype>(
					this, android.R.layout.simple_spinner_item,
					MD_ListItem.Get_hpzl());
			Adapter_hplx
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner_car_hpzl.setAdapter(Adapter_hplx);

			// 取消事件
			car_login_btu_qx.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					finish();
				}
			});

			// 确认事件
			car_login_btu_dl.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					car_login_btu_dl.setEnabled(false);
					nullData.setVisibility(View.GONE);
					Md_Car_Temp.getTempCar().car_hphm =text_hphm.getText().toString().toUpperCase()
									.replace(" ", "");
					Md_Car_Temp.getTempCar().car_vin = text_vin.getText()
							.toString().toUpperCase().replace(" ", "");
					Md_Car_Temp.getTempCar().car_hpzl = ((Md_cartype) spinner_car_hpzl
							.getSelectedItem()).getName();
					ReTakePictureActivity.this.request("18Q12",
							getReTakePicVehRequestData(),
							R.string.QUERY_BP_CAR_LIST, new String[] { "2" });
				}
			});
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long arg3) {
					if (Md_Car_Temp.getTempCar().carListBooeal) {
						Md_Car_Temp.getTempCar().car_hphm = ((TextView) view
								.findViewById(R.id.car_hphm)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_vin = ((TextView) view
								.findViewById(R.id.car_vin)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_lsh = ((TextView) view
								.findViewById(R.id.car_jylsh)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_hpzl = ((TextView) view
								.findViewById(R.id.car_hpzl)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_jycs = ((TextView) view
								.findViewById(R.id.car_jycs)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_lx = ((TextView) view
								.findViewById(R.id.car_cllx)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_jclb = ((TextView) view
								.findViewById(R.id.car_jylb)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_syxz = ((TextView) view
								.findViewById(R.id.car_syxz)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_clsbdh = Md_Car_Temp
								.getTempCar().car_vin;
						dialog_xm();
					} else {
						dialog_alert();
					}
				}
			});
		} catch (Exception e) {

		}
	}

	// 页面跳转
	protected void dialog_xm() {
		Intent itt = new Intent();
		Md_Car_Temp.getTempCar().FromReTakeToPz = "yes";
		itt.setClass(ReTakePictureActivity.this, Pzlx_Activity.class);
		startActivity(itt);
		finish();
	}

	/**
	 * 获取车辆列表请求数据
	 * 
	 * @return
	 */
	private Map<String, Object> getReTakePicVehRequestData() {
		if(requestMap!=null)
		{
			requestMap=null;
		}if(requestDate!=null)
		{
			requestDate=null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_vin);
		requestMap.put("QueryCondition", requestDate);
		return requestMap;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == 4) {
			finish();
		}
		return false;
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try{
		if ("18Q12".equals(jkid)) {
			car_login_btu_dl.setEnabled(true);
			List<MD_Xml_Node> listMXN = (List<MD_Xml_Node>) result;
			dealListMXN(listMXN);
		}
		}catch (Exception e) {
			DefautDialog.showDialog(ReTakePictureActivity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	private void dealListMXN(List<MD_Xml_Node> listMXN) {

		List<Map<String, Object>> mDataList = null;
		CarBP_Adapter cad = null;
		try {
			mDataList = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < listMXN.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				if (listMXN.get(i).cllx.toString().equals("01")) {
					map.put("img", R.drawable.desk_buses1);
				} else if (listMXN.get(i).cllx.toString().equals("02")) {
					map.put("img", R.drawable.desk_buses);
				} else if (listMXN.get(i).cllx.toString().equals("03")) {
					map.put("img", R.drawable.dxqc);
				} else if (listMXN.get(i).cllx.toString().equals("04")) {
					map.put("img", R.drawable.nyyuc);
				} else if (listMXN.get(i).cllx.toString().equals("05")) {
					map.put("img", R.drawable.wxp);
				} else {
					map.put("img", R.drawable.vehlist_car);
				}
				map.put("car_hphm", listMXN.get(i).hphm.toString());
				map.put("car_jyjl", listMXN.get(i).cngstate.toString());
				map.put("car_vin", listMXN.get(i).clsbdh.toString());
				map.put("car_dlrq", listMXN.get(i).sfzdy.toString());
				map.put("car_jylsh", listMXN.get(i).jclsh.toString());
				map.put("car_hpzl", listMXN.get(i).hpzl.toString());
				map.put("car_jycs", listMXN.get(i).sfwcpz.toString());
				map.put("car_cllx", listMXN.get(i).cllx.toString());
				map.put("car_jylb", listMXN.get(i).jclb.toString());
				map.put("car_syxz", listMXN.get(i).syxz.toString());
				mDataList.add(map);
			}
			Md_Car_Temp.getTempCar().carListBooeal = true;
		} catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", R.drawable.vehlist_car);
			map.put("car_hphm", "");
			map.put("car_jyjl", "");
			map.put("car_vin", "");
			map.put("car_dlrq", "");
			map.put("car_jylsh", "");
			map.put("car_hpzl", "");
			map.put("car_jycs", "");
			map.put("car_cllx", "");
			map.put("car_jylb", "");
			map.put("car_syxz", "");
			mDataList.add(map);
			Md_Car_Temp.getTempCar().carListBooeal = false;
		}

		if (mDataList != null) {
			cad = new CarBP_Adapter(ReTakePictureActivity.this, mDataList);
		}
		if (cad != null) {
			initListView(cad);
		}
		if (!Md_Car_Temp.getTempCar().carListBooeal) {
			dialog_alert();
		}
		if (cad == null || cad.getCount() == 0) {
			nullData.setVisibility(View.VISIBLE);
		} else {
			nullData.setVisibility(View.GONE);
		}
	}

	/**
	 * 弹出对话框--普通对话框
	 */
	protected void dialog_alert() {
		DefautDialog.showDialog(
				ReTakePictureActivity.this,
				ReTakePictureActivity.this.getResources().getString(
						R.string.SYS_TITLE), "抱歉，平台无此数据!", false, null, null);
	}

	private void initListView(CarBP_Adapter cad) {
		listView.setItemsCanFocus(false);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setAdapter(cad);
		listView.setVisibility(0);
	}
}
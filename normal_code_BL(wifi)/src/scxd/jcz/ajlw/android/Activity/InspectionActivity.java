
package scxd.jcz.ajlw.android.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Adapter.CarPz_Adapter;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.MD_Xml_Node;
import scxd.jcz.ajlw.android.model.Md_cartype;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
/**
 * ���鳵�������˹����鴦���ƹ����ģ���ѡ��ʱ���ܴ���dialog_xm(int type)�У�type=2
 * @author 
 * @time
 * 
 */
public class InspectionActivity extends BaseActivity {

	Button btu_seach;
	Button btu_seach_all;
	Button btu_break;
	ListView listView;
	EditText edt_msg_seach;
	boolean zxsystem = false;
	ProgressBar car_list_progressBar_dengdai;
	TextView dengdai_msg;
	String sfwcpz = "";
	Spinner hpzls;
	ArrayAdapter<Md_cartype> adapter;
	EditText hphmet;
	EditText clsbdh;
	TextView nullData = null;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestDate = null;

	/**
	 * �����˵�
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		int group1 = 1;
		int group2 = 2;
		int group3 = 3;
		menu.add(group1, 1, 1, "ˢ���б�");
		menu.add(group2, 2, 2, "ע��ϵͳ");
		menu.add(group3, 3, 3, "�˳�ϵͳ");
		return true;

	}

	/**
	 * ��ȡ�����б���������
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestGetVehListDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", "");
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_clsbdh);
		requestDate.put("jcxm", "CY");
		requestMap.put("QueryCondition", requestDate);
		return requestMap;
	}

	/**
	 * �˵�ѡ���¼�
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Md_Car_Temp.getTempCar().car_hphm = hphmet.getText().toString()
					.trim();
			Md_Car_Temp.getTempCar().car_clsbdh = clsbdh.getText().toString()
					.trim();
			InspectionActivity.this.request("18Q11",
					getRequestGetVehListDate(),
					R.string.REQUEST_VEHLIST_MESSAGE_ID, new String[] { "2" });
			break;
		case 2:
			this.zxsystem = true;
			DefautDialog.showDialog(
					InspectionActivity.this,
					InspectionActivity.this.getResources().getString(
							R.string.SYS_TITLE), "ȷ��Ҫע��ϵͳ��", true,
					new DefautDialog.OnClickListener() {
						@Override
						public void onClick(DefautDialog dialog, View arg0) {
							dialog.dimiss();
							Md_Car_Temp.getTempCar().ispbzc = true;
							Intent itt = new Intent();
							itt.setClass(InspectionActivity.this,
									Login_Activity.class);
							startActivity(itt);
							finish();
						}
					}, null);
			break;
		case 3:
			DefautDialog.showDialog(
					InspectionActivity.this,
					InspectionActivity.this.getResources().getString(
							R.string.SYS_TITLE), "ȷ���˳�ϵͳ��", true,
					new DefautDialog.OnClickListener() {
						@Override
						public void onClick(DefautDialog dialog, View arg0) {
							dialog.dimiss();
							Md_Car_Temp.getTempCar().ispbzc = true;
							Intent itt = new Intent();
							itt.setClass(InspectionActivity.this,
									Login_Activity.class);
							startActivity(itt);
							finish();
						}
					}, null);
			break;
		}
		return true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_list);
		Get_Car_Data();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		Get_Car_Data();
	}

	/**
	 * ��ȡ�����б���Ϣ���󶨵�ListView
	 */
	private void Get_Car_Data() {
		Md_Car_Temp.getTempCar().FromCylistToCyItem = "";
		Md_Car_Temp.getTempCar().clearData();
		hpzls = (Spinner) findViewById(R.id.hpzls);
		// ����Spinner����
		adapter = new ArrayAdapter<Md_cartype>(this,
				android.R.layout.simple_spinner_item, MD_ListItem.Get_cllx());
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		hpzls.setAdapter(adapter);
		hphmet = (EditText) findViewById(R.id.hphmet);
		clsbdh = (EditText) findViewById(R.id.clsbdh);
		edt_msg_seach = (EditText) findViewById(R.id.edt_msg_seach);
		listView = (ListView) findViewById(R.id.cl_listview);
		car_list_progressBar_dengdai = (ProgressBar) findViewById(R.id.car_list_progressBar_dengdai_carList);
		dengdai_msg = (TextView) findViewById(R.id.dengdai_msg);
		nullData = (TextView) findViewById(R.id.nullDataList);
		try {
			InspectionActivity.this.request("18Q11",
					getRequestGetVehListDate(),
					R.string.REQUEST_VEHLIST_MESSAGE_ID, new String[] { "2" });
			// ���ü����¼�
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long arg3) {
					// ����Ƿ�������
					if (Md_Car_Temp.getTempCar().carListBooeal) {
						// ����ʱ������ֵ
						Md_Car_Temp.getTempCar().car_hphm = ((TextView) view
								.findViewById(R.id.car_hphm)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_lx = ((TextView) view
								.findViewById(R.id.car_cllx)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_vin = ((TextView) view
								.findViewById(R.id.car_vin)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_hpzl = ((TextView) view
								.findViewById(R.id.car_hpzl)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_lsh = ((TextView) view
								.findViewById(R.id.car_cllsh)).getText()
								.toString();
						Md_Car_Temp.getTempCar().wjtd = ((TextView) view
								.findViewById(R.id.car_wjtd)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_id = ((TextView) view
								.findViewById(R.id.car_id)).getTag().toString();
						Md_Car_Temp.getTempCar().car_syxz = ((TextView) view
								.findViewById(R.id.car_syxz)).getTag()
								.toString();
						Md_Car_Temp.getTempCar().sfxc = "1";
						Md_Car_Temp.getTempCar().sfzdy = "0";
						Md_Car_Temp.getTempCar().car_clsbdh = Md_Car_Temp
								.getTempCar().car_vin;
						Md_Car_Temp.getTempCar().car_jycs = ((TextView) view
								.findViewById(R.id.car_sfwcpz)).getText()
								.toString();
						dialog_xm();
					} else {
						dialog_alert();
					}

				}
			});
			btu_seach = (Button) findViewById(R.id.btu_seach);
			btu_break = (Button) findViewById(R.id.btu_break);
			// ���÷��ذ�ť�¼�
			btu_break.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					btu_break.setEnabled(false);
					finish();
				}
			});
			// ����������ť�¼�
			btu_seach.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Md_Car_Temp.getTempCar().car_hphm = hphmet.getText()
							.toString().trim();
					Md_Car_Temp.getTempCar().car_clsbdh = clsbdh.getText()
							.toString().trim();
					if (!"".equals(Md_Car_Temp.getTempCar().car_hphm)
							|| !"".equals(Md_Car_Temp.getTempCar().car_clsbdh)) {
						InspectionActivity.this.request("18Q11",
								getRequestGetVehListDate(),
								R.string.REQUEST_VEHLIST_MESSAGE_ID,
								new String[] { "2" });
					} else {
						Toast.makeText(getApplication(), "������ƺ��룬���ܺŲ��ܶ�Ϊ�գ�",
								Toast.LENGTH_SHORT).show();
						return;
					}

				}
			});
			btu_seach_all = (Button) findViewById(R.id.btu_seach_all);
			btu_seach_all.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Md_Car_Temp.getTempCar().car_hphm = "";
					Md_Car_Temp.getTempCar().car_clsbdh = "";
					InspectionActivity.this.request("18Q11",
							getRequestGetVehListDate(),
							R.string.REQUEST_VEHLIST_MESSAGE_ID,
							new String[] { "2" });
				}
			});
		} catch (Exception e) {
			dialog_alert();
		}

	}

	/**
	 * ����ƽ�巵�ذ��������¼�
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == 4) {
			finish();
		}
		return false;
	}

	/**
	 * �����Ի���--��ͨ�Ի���
	 */
	protected void dialog_alert() {
		DefautDialog.showDialog(
				InspectionActivity.this,
				InspectionActivity.this.getResources().getString(
						R.string.SYS_TITLE), "��Ǹ��ƽ̨�޴�����!", false, null, null);

	}

	protected void dialog_xm() {
		Md_Car_Temp.getTempCar().FromCylistToCyItem = "yes";
		Intent intent = new Intent(InspectionActivity.this,
				InspectionWebActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try{
		if ("18Q11".equals(jkid)) {
			List<MD_Xml_Node> listMXN = (List<MD_Xml_Node>) result;
			if (!listMXN.get(0).code.equals("0")) {
				dealListMXN(listMXN);
			} else {
				Toast.makeText(InspectionActivity.this, "û�в�ѯ������!", 1000)
						.show();
			}
		}
		}catch (Exception e) {
			DefautDialog.showDialog(InspectionActivity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	private void dealListMXN(List<MD_Xml_Node> listMXN) {

		List<Map<String, Object>> mDataList = null;
		Map<Integer, Boolean> isSelected = null;
		CarPz_Adapter cad = null;
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
				map.put("car_cllx", listMXN.get(i).cllx.toString());
				map.put("car_vin", listMXN.get(i).clsbdh.toString());
				map.put("car_hpzl", listMXN.get(i).hpzl.toString());
				map.put("car_lsh", listMXN.get(i).jclsh.toString());
				map.put("car_sfwcpz", listMXN.get(i).sfwcpz.toString());
				map.put("sfzdy", listMXN.get(i).sfzdy.toString());
				map.put("syxz", listMXN.get(i).syxz.toString());
				map.put("jclb", listMXN.get(i).jclb.toString());
				map.put("car_id", listMXN.get(i).car_id.toString());
				mDataList.add(map);
			}
			Md_Car_Temp.getTempCar().carListBooeal = true;
		} catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", R.drawable.vehlist_car);
			map.put("car_hphm", "");
			map.put("car_cllx", "");
			map.put("car_vin", "");
			map.put("car_hpzl", "");
			map.put("car_lsh", "");
			map.put("car_sfwcpz", "");
			map.put("sfzdy", "");
			map.put("syxz", "");
			map.put("jclb", "");
			map.put("car_id", "");
			mDataList.add(map);
			Md_Car_Temp.getTempCar().carListBooeal = false;
		}
		isSelected = new HashMap<Integer, Boolean>();
		for (int i = 0; i < mDataList.size(); i++) {
			isSelected.put(i, true);
		}

		if (mDataList != null) {
			cad = new CarPz_Adapter(InspectionActivity.this, mDataList,
					isSelected);
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

	private void initListView(CarPz_Adapter cad) {
		listView.setItemsCanFocus(false);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setAdapter(cad);
		listView.setVisibility(0);
	}
}
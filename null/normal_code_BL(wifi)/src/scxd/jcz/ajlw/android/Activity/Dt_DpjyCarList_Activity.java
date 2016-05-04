/**
 * 
 */
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
 * 动态底盘检验项目类别列表
 * 
 * @author xxy
 * 
 */
public class Dt_DpjyCarList_Activity extends BaseActivity {

	// 搜索按钮
	Button btu_seach;
	// 搜索全部
	Button btu_seach_all;
	// 返回按钮
	Button btu_break;
	// 车辆列表
	ListView listView;
	// 关键词搜索框
	private EditText edt_msg_seach;
	// 是否注销系统
	boolean zxsystem = false;
	// 进度条滚动
	ProgressBar car_list_progressBar_dengdai;
	// 进度条文本
	TextView dengdai_msg;
	// 线程执行状态
	boolean isAsycn = true;

	TextView nullData = null;
	Spinner hpzls;
	EditText hphmet;
	EditText clsbdh;
	ArrayAdapter<Md_cartype> adapter;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestDate = null;
	// 是否完成拍照
	String sfwcpz = "";

	/**
	 * 创建菜单
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		int group1 = 1;
		int group2 = 2;
		int group3 = 3;
		menu.add(group1, 1, 1, "刷新列表");
		menu.add(group2, 2, 2, "注销系统");
		menu.add(group3, 3, 3, "退出系统");
		return true;

	}

	/**
	 * 获取车辆列表请求数据
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
		requestDate.put("jcxm", "DC");
		requestMap.put("QueryCondition", requestDate);
		return requestMap;
	}

	/**
	 * 菜单选择事件
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Md_Car_Temp.getTempCar().car_hphm = hphmet.getText().toString()
					.trim();
			Md_Car_Temp.getTempCar().car_clsbdh = clsbdh.getText().toString()
					.trim();
			Dt_DpjyCarList_Activity.this.request("18Q11",
					getRequestGetVehListDate(),
					R.string.REQUEST_VEHLIST_MESSAGE_ID, new String[] { "2" });
			break;
		case 2:
			this.zxsystem = true;
			DefautDialog.showDialog(
					Dt_DpjyCarList_Activity.this,
					Dt_DpjyCarList_Activity.this.getResources().getString(
							R.string.SYS_TITLE), "确认要注销系统吗？", true,
					new DefautDialog.OnClickListener() {
						@Override
						public void onClick(DefautDialog dialog, View arg0) {
							dialog.dimiss();
							Md_Car_Temp.getTempCar().ispbzc = true;
							Intent itt = new Intent();
							itt.setClass(Dt_DpjyCarList_Activity.this,
									Login_Activity.class);
							startActivity(itt);
							finish();
						}
					}, null);
			break;
		case 3:
			DefautDialog.showDialog(
					Dt_DpjyCarList_Activity.this,
					Dt_DpjyCarList_Activity.this.getResources().getString(
							R.string.SYS_TITLE), "确认退出系统吗？", true,
					new DefautDialog.OnClickListener() {
						@Override
						public void onClick(DefautDialog dialog, View arg0) {
							dialog.dimiss();
							Md_Car_Temp.getTempCar().ispbzc = true;
							Intent itt = new Intent();
							itt.setClass(Dt_DpjyCarList_Activity.this,
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
	 * 获取车辆列表信息并绑定到ListView
	 */
	private void Get_Car_Data() {
		Md_Car_Temp.getTempCar().FromDTDPlistToDTDPItem = "";
		Md_Car_Temp.getTempCar().clearData();
		Md_Car_Temp.getTempCar().zdy = false;
		Md_Car_Temp.getTempCar().str = null;
		this.hpzls = (Spinner) findViewById(R.id.hpzls);
		hphmet = (EditText) findViewById(R.id.hphmet);
		clsbdh = (EditText) findViewById(R.id.clsbdh);
		// 适配spiner
		adapter = new ArrayAdapter<Md_cartype>(this,
				android.R.layout.simple_spinner_item, MD_ListItem.Get_cllx());
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		hpzls.setAdapter(adapter);
		this.edt_msg_seach = (EditText) findViewById(R.id.edt_msg_seach);
		this.listView = (ListView) findViewById(R.id.cl_listview);
		this.car_list_progressBar_dengdai = (ProgressBar) findViewById(R.id.car_list_progressBar_dengdai_carList);
		this.dengdai_msg = (TextView) findViewById(R.id.dengdai_msg);
		this.nullData = (TextView) findViewById(R.id.nullDataList);
		try {
			Dt_DpjyCarList_Activity.this.request("18Q11",
					getRequestGetVehListDate(),
					R.string.REQUEST_VEHLIST_MESSAGE_ID, new String[] { "2" });
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long arg3) {
					if (Md_Car_Temp.getTempCar().carListBooeal) {
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
						Md_Car_Temp.getTempCar().car_id = ((TextView) view
								.findViewById(R.id.car_id)).getTag().toString();
						Md_Car_Temp.getTempCar().car_syxz = ((TextView) view
								.findViewById(R.id.car_syxz)).getTag()
								.toString();
						Md_Car_Temp.getTempCar().car_jclb = ((TextView) view
								.findViewById(R.id.car_jclb)).getTag()
								.toString();
						if (Md_Car_Temp.getTempCar().car_jclb.equals("00")) {
							Md_Car_Temp.getTempCar().sfxc = "0";
						} else {
							Md_Car_Temp.getTempCar().sfxc = "1";
						}
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
			this.btu_seach = (Button) findViewById(R.id.btu_seach);
			this.btu_break = (Button) findViewById(R.id.btu_break);
			// 设置返回按钮事件
			this.btu_break.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					btu_break.setEnabled(false);
					finish();
				}
			});
			// 设置搜索按钮事件
			btu_seach.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Md_Car_Temp.getTempCar().car_hphm = hphmet.getText()
							.toString().trim();
					Md_Car_Temp.getTempCar().car_clsbdh = clsbdh.getText()
							.toString().trim();
					if (!"".equals(Md_Car_Temp.getTempCar().car_hphm)
							|| !"".equals(Md_Car_Temp.getTempCar().car_clsbdh)) {
						Dt_DpjyCarList_Activity.this.request("18Q11",
								getRequestGetVehListDate(),
								R.string.REQUEST_VEHLIST_MESSAGE_ID,
								new String[] { "2" });
					} else {
						Toast.makeText(getApplication(), "请检查号牌号码，车架号不能都为空！",
								Toast.LENGTH_SHORT).show();
						return;
					}
				}
			});
			btu_seach_all = (Button) findViewById(R.id.btu_seach_all);
			// 查询所有的结果
			btu_seach_all.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Md_Car_Temp.getTempCar().car_hphm = "";
					Md_Car_Temp.getTempCar().car_clsbdh = "";
					Dt_DpjyCarList_Activity.this.request("18Q11",
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
	 * 监听平板返回按键按下事件
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == 4) {
			finish();
		}
		return false;
	}

	/**
	 * 弹出对话框--普通对话框
	 */
	protected void dialog_alert() {
		DefautDialog.showDialog(
				Dt_DpjyCarList_Activity.this,
				Dt_DpjyCarList_Activity.this.getResources().getString(
						R.string.SYS_TITLE), "抱歉，平台无此数据!", false, null, null);
	}

	protected void dialog_xm() {
		Intent itt = new Intent();
		Md_Car_Temp.getTempCar().FromDTDPlistToDTDPItem = "yes";
		itt.setClass(Dt_DpjyCarList_Activity.this, Dt_Dpjy_Item_Activity.class);
		startActivity(itt);
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
				Toast.makeText(Dt_DpjyCarList_Activity.this, "没有查询到车辆!", 1000)
						.show();
			}
		}
		}catch (Exception e) {
			DefautDialog.showDialog(Dt_DpjyCarList_Activity.this, R.string.SYS_TITLE,
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
			cad = new CarPz_Adapter(Dt_DpjyCarList_Activity.this, mDataList,
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
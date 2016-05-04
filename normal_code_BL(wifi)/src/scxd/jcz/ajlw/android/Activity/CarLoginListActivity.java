package scxd.jcz.ajlw.android.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Adapter.CarLoginList_Adapter;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.MD_Xml_Node;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 车辆登录列表界面
 * @author gbh
 *@time 
 */
public class CarLoginListActivity extends BaseActivity {

	// 搜索按钮
	Button btu_seach;
	// 搜索全部
	Button btu_seach_all;
	// 返回按钮
	Button btu_break;
	// 车辆列表
	ListView listView;
	// 是否注销系统
	boolean zxsystem = false;
	// 线程执行状态
	boolean isAsycn = true;
	EditText hphmet;
	TextView nullData = null;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestDate = null;

	/**
	 * 创建菜单
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// 添加2个菜单项，分成2组
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
	 * @return 一个map数据
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
			if (!"".equals(Md_Car_Temp.getTempCar().car_hphm)) {
				CarLoginListActivity.this.request("18Q51",
						getRequestGetVehListDate(),
						R.string.REQUEST_VEHLIST_MESSAGE_ID,
						new String[] { "2" });
			}
			break;
		case 2:
			this.zxsystem = true;
			DefautDialog.showDialog(
					CarLoginListActivity.this,
					CarLoginListActivity.this.getResources().getString(
							R.string.SYS_TITLE), "确认要注销系统吗？", true,
					new DefautDialog.OnClickListener() {
						@Override
						public void onClick(DefautDialog dialog, View arg0) {
							dialog.dimiss();
							Md_Car_Temp.getTempCar().ispbzc = true;
							Intent itt = new Intent();
							itt.setClass(CarLoginListActivity.this,
									Login_Activity.class);
							startActivity(itt);
							finish();
						}
					}, null);
			break;
		case 3:
			DefautDialog.showDialog(
					CarLoginListActivity.this,
					CarLoginListActivity.this.getResources().getString(
							R.string.SYS_TITLE), "确认退出系统吗？", true,
					new DefautDialog.OnClickListener() {
						@Override
						public void onClick(DefautDialog dialog, View arg0) {
							dialog.dimiss();
							Md_Car_Temp.getTempCar().ispbzc = true;
							Intent itt = new Intent();
							itt.setClass(CarLoginListActivity.this,
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
		setContentView(R.layout.carloginlistactivity);
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
		Md_Car_Temp.getTempCar().FromWjlistToWjItem = "";
		Md_Car_Temp.getTempCar().clearData();
		Md_Car_Temp.getTempCar().zdy = false;
		Md_Car_Temp.getTempCar().str = null;
		hphmet = (EditText) findViewById(R.id.hphmet);
		this.listView = (ListView) findViewById(R.id.cl_listview);
		this.nullData = (TextView) findViewById(R.id.nullDataList);
		try {
			CarLoginListActivity.this.request("18Q51",
					getRequestGetVehListDate(),
					R.string.REQUEST_VEHLIST_MESSAGE_ID, new String[] { "2" });
			// 设置监听事件
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long arg3) {
					if (Md_Car_Temp.getTempCar().carListBooeal) {
						Md_Car_Temp.getTempCar().isQuery = false;
						Md_Car_Temp.getTempCar().car_hphm = ((TextView) view
								.findViewById(R.id.car_hphm)).getText()
								.toString();
						Md_Car_Temp.getTempCar().car_hpzl = ((TextView) view
								.findViewById(R.id.car_hpzl)).getText()
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
					if (!"".equals(Md_Car_Temp.getTempCar().car_hphm)) {
						CarLoginListActivity.this.request("18Q51",
								getRequestGetVehListDate(),
								R.string.REQUEST_VEHLIST_MESSAGE_ID,
								new String[] { "2" });
					} else {
						Toast.makeText(getApplication(), "请检查你的网络或号牌号码是否为空",
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
					CarLoginListActivity.this.request("18Q51",
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
				CarLoginListActivity.this,
				CarLoginListActivity.this.getResources().getString(
						R.string.SYS_TITLE), "抱歉，平台无数据!", false, null, null);
	}

	protected void dialog_xm() {
		Intent itt = new Intent();
		itt.setClass(CarLoginListActivity.this, CarLoginActivity.class);
		startActivity(itt);
		finish();
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try{
		if ("18Q51".equals(jkid)) {
			List<MD_Xml_Node> listMXN = (List<MD_Xml_Node>) result;
			dealListMXN(listMXN);
		}
		}catch (Exception e) {
			DefautDialog.showDialog(CarLoginListActivity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}
/**
 * 处理xml节点，根据节点显示
 * @param listMXN xml节点集合
 */
	private void dealListMXN(List<MD_Xml_Node> listMXN) {

		List<Map<String, Object>> mDataList = null;
		CarLoginList_Adapter cad = null;
		try {
			mDataList = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < listMXN.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("car_hphm", listMXN.get(i).hphm.toString());
				map.put("car_hpzl", listMXN.get(i).hpzl.toString());
				mDataList.add(map);
			}
			Md_Car_Temp.getTempCar().carListBooeal = true;
		} catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("car_hphm", "");
			map.put("car_hpzl", "");
			mDataList.add(map);
			Md_Car_Temp.getTempCar().carListBooeal = false;
		}
		if (mDataList != null) {
			cad = new CarLoginList_Adapter(CarLoginListActivity.this, mDataList);
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
 * 初始化适配器
 * @param cad 适配器
 * @author 
 */
	private void initListView(CarLoginList_Adapter cad) {
		listView.setItemsCanFocus(false);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setAdapter(cad);
		listView.setVisibility(0);
	}
}

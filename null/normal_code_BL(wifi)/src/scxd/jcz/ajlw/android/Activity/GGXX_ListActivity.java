package scxd.jcz.ajlw.android.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Pzlx_Activity.MyThread;
import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Activity.Common.PromptUtils;
import scxd.jcz.ajlw.android.Adapter.CarBP_Adapter;
import scxd.jcz.ajlw.android.Adapter.Carggpc_Adapter;
import scxd.jcz.ajlw.android.Adapter.Mohu_Adapter;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;

import scxd.jcz.ajlw.android.model.MD_Xml_Node;
import scxd.jcz.ajlw.android.model.MapBeanWDL;
import scxd.jcz.ajlw.android.util.AssestToString;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 公告比对
 * 
 * @author CXY
 * 
 */
public class GGXX_ListActivity extends BaseActivity {
	private RadioButton ydl;
	private RadioButton wdl;
	private EditText mSearch;
	private Button mQuery;
	private ImageView mBack;
	private ListView listView;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestDate = null;
	boolean checked = false;
	boolean iswdl = false;
	private TextView nullData;
	private ArrayList<Map<String, String>> data = null;
	CarBP_Adapter cad = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ggxx__list);
		getView();
		init();
		// Md_Car_Temp.test=AssestToString.xmltoString(this, "test.xml");

		getData();
	}

	/**
	 * 处理事件
	 */
	private void init() {
		ydl.setOnClickListener(clicklisterradio);
		wdl.setOnClickListener(clicklisterradio);
		mQuery.setOnClickListener(clicklisters);
		mBack.setOnClickListener(clicklisters);
		listView.setCacheColorHint(Color.WHITE);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Map<String, String> data = (Map<String, String>) cad
						.getItem(arg2);

				Md_Car_Temp.car_hphm = data.get("car_hphm");
				Md_Car_Temp.car_vin = data.get("car_vin");
				Md_Car_Temp.car_hpzl = data.get("car_hpzl");
				try{
				getGongGaoData("",data.get("clpp1"),data.get("clxh"));
//					getGongGaoData("", "欧铃牌", "ZB1033BDC1F");
				} catch (Exception e) {
					Toast.makeText(GGXX_ListActivity.this, "数据返回出错", 1000)
							.show();
				}

			}
		});
	}

	private void getView() {
		ydl = (RadioButton) findViewById(R.id.ydl);
		wdl = (RadioButton) findViewById(R.id.wdl);
		mSearch = (EditText) findViewById(R.id.search_ed);
		mQuery = (Button) findViewById(R.id.search_btn);
		mBack = (ImageView) findViewById(R.id.back);
		listView = (ListView) findViewById(R.id.list);
		nullData = (TextView) findViewById(R.id.nullDataList);

	}

	/**
	 * 获取数据（登陆）
	 */
	private void getData() {

		GGXX_ListActivity.this.request("18Q12", getRequestDate(),
				R.string.REQUEST_VEHLIST_MESSAGE_ID, new String[] { "2" });

	}

	/**
	 * 下载公告信息
	 */
	private void getGongGaoData(String bh, String clppl, String clxh) {

		GGXX_ListActivity.this.request("18C08",
				getRequestggDate(bh, clppl, clxh),
				R.string.REQUEST_VEHLIST_MESSAGE_ID, new String[] { "2" });
	}

	/**
	 * 未登录时的数据
	 */
	private void getDatawdl() {
		String cjh=mSearch.getText().toString();
		if("".equals(cjh)||cjh==null){
			Toast.makeText(this, "请输入车辆型号", 0).show();
		}else{

		GGXX_ListActivity.this.request("18C08", getRequestwdlDate(),
				R.string.REQUEST_DZJP_MESSAGE_ID, new String[] { "2" });
		}
	}

	/**
	 * 拼接未登录的数据
	 * 
	 * @return map
	 */
	private Map<String, Object> getRequestwdlDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("bh", "");
		requestDate.put("clpp1", "");
		requestDate.put("clxh", mSearch.getText().toString());
		requestMap.put("QueryCondition", requestDate);
		return requestMap;
	}

	/**
	 * 拼接数据
	 * 
	 * @return map
	 */
	private Map<String, Object> getRequestDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("hpzl", "");
		requestDate.put("hphm", "");
		requestDate.put("clsbdh", mSearch.getText().toString());
		requestMap.put("QueryCondition", requestDate);
		return requestMap;
	}

	/**
	 * 拼接下载公告数据的参数
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestggDate(String bh, String clppl,
			String clxh) {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		requestMap = new HashMap<String, Object>();
		requestDate = new HashMap<String, Object>();
		requestDate.put("bh", bh);
		requestDate.put("clpp1", clppl);
		requestDate.put("clxh", clxh);
		requestMap.put("QueryCondition", requestDate);
		return requestMap;
	}

	private OnClickListener clicklisterradio = new OnClickListener() {

		@Override
		public void onClick(View v) {
			checked = ((RadioButton) v).isChecked();
			switch (v.getId()) {
			case R.id.ydl:
				if (checked) {
					mSearch.setHint("请输入车架号后六位");
					getData();
					iswdl = false;
				}

				break;
			case R.id.wdl:
				if (checked) {
					mSearch.setHint("请输入车辆型号");
					initListView(null);
					// getDatawdl();
					iswdl = true;

				}
				break;

			}
		}
	};
	private OnClickListener clicklisters = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.search_btn:
				if (iswdl) {
					
					getDatawdl();
				} else {
					getData();
				}
				break;
			case R.id.back:
				openActivity(MainActivity.class);
				finish();
				break;

			}
		}
	};

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try {
			if ("18Q12".equals(jkid)) {
				@SuppressWarnings("unchecked")
				List<MD_Xml_Node> listMXN = (List<MD_Xml_Node>) result;
				dealListMXN(listMXN);
			} else if ("18C08".equals(jkid)) {
				@SuppressWarnings("unchecked")
				ArrayList<Map<String, String>> responseMap = (ArrayList<Map<String, String>>) result;
				if (responseMap.size() != 0) {
					if (responseMap.size() == 1) {
						// showGGXXPCLB(responseMap);

						Map<String, String> hm = responseMap.get(0);
						MapBeanWDL mapBean = new MapBeanWDL(hm);
						Bundle b = new Bundle();
						b.putSerializable("BEAN", mapBean);
						openActivity(GGXX_TabActivity.class, b);
						finish();

					} else {
						// 弹出批次框框
						showListDialog(responseMap);

					}
				} else {
					Toast.makeText(GGXX_ListActivity.this, "没有查询到公告信息！", 1000)
							.show();
				}

			}
		} catch (Exception e) {
			Toast.makeText(GGXX_ListActivity.this, "数据格式转换出错", 1000).show();
		}

	}

	private void initListView(CarBP_Adapter cad) {
		listView.setItemsCanFocus(false);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setAdapter(cad);
		listView.setVisibility(0);
	}

	private void dealListMXN(List<MD_Xml_Node> listMXN) {

		List<Map<String, Object>> mDataList = null;

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
				map.put("clpp1", listMXN.get(i).clpp1);
				map.put("clxh", listMXN.get(i).clxh);
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
			map.put("clpp1", "");
			map.put("clxh", "");
			mDataList.add(map);
			Md_Car_Temp.getTempCar().carListBooeal = false;
		}

		if (mDataList != null) {
			cad = new CarBP_Adapter(GGXX_ListActivity.this, mDataList);
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
		DefautDialog.showDialog(GGXX_ListActivity.this, GGXX_ListActivity.this
				.getResources().getString(R.string.SYS_TITLE), "抱歉，平台无此数据!",
				false, null, null);
	}

	/**
	 * 显示公告信息
	 * 
	 * @param responseMap
	 */
	private void showGGXXPCLB(ArrayList<Map<String, String>> responseMap) {
		try {
			if (responseMap == null || responseMap.size() == 0) {
				Toast.makeText(this, "没有查询到公告信息！", 1000).show();
				return;
			}
			data = responseMap;
			responseMap = null;
			Carggpc_Adapter adapter = new Carggpc_Adapter(
					GGXX_ListActivity.this, data);
			listView.setAdapter(adapter);
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Map<String, String> hm = data.get(position);
					MapBeanWDL mapBean = new MapBeanWDL(hm);
					Bundle b = new Bundle();
					b.putSerializable("BEAN", mapBean);
					openActivity(GGXX_TabActivity.class, b);
					finish();

				}
			});
		} catch (Exception e) {
			Toast.makeText(GGXX_ListActivity.this, "没有查询到公告信息！", 1000).show();
		}
	}

	private void showListDialog(ArrayList<Map<String, String>> responseMap) {
		View popView = LayoutInflater.from(this).inflate(R.layout.mohu_list,
				null);
		ListView car_listview = (ListView) popView.findViewById(R.id.car_mohu);
		final Mohu_Adapter Mohuadapter = new Mohu_Adapter(
				GGXX_ListActivity.this, responseMap);
		car_listview.setAdapter(Mohuadapter);
		car_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Map<String, String> datas = (Map<String, String>) Mohuadapter
						.getItem(arg2);
				MapBeanWDL mapBean = new MapBeanWDL(datas);
				Bundle b = new Bundle();
				b.putSerializable("BEAN", mapBean);
				openActivity(GGXX_TabActivity.class, b);
				finish(); // 跳转到公告比对显示界面

			}
		});
		PromptUtils.showAlertDialog(this, "提示：", popView, "请选择批次？", "返  回",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						PromptUtils.closeAlertDialog();
					}
				});
	}

}

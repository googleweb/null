package scxd.jcz.ajlw.android.Activity;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Adapter.CarLx_Adapter;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_JYXM;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.Md_cartype;
import scxd.jcz.ajlw.android.model.Md_system;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
/**
 * ������Ŀ
 * @author Administrator
 *@time
 */
public class Pzlx_Activity extends BaseActivity {

	/**
	 * �ж� ����ʱ �Ƿ��ǵ��"���"���ص� ����� ��ˢ�������б�
	 */
	public static boolean isCameraSave = false;
	private static int currentIndex = -1;
	public static String s = "";// �ж������ջ��ǲ���
	private boolean zxsystem = false;
	private boolean isupstate = false;
	private TextView hphm;
	private TextView hpzl;
	private TextView vin;
	private ProgressBar car_list_progressBar_dengdai;
	private TextView dengdai_msg;
	private boolean isAsycn = true;
	private ListView listView;
	private ListView qtlistView;
	private Button zdypzxm;
	private Boolean isFinish;
	private Button zcdjzp;// ��ѯע��Ǽ���Ƭ��ť
	private RadioGroup item_qppzcontent_rdogrp;
	private RadioButton item_rdo_qppzyes;
	private RadioButton item_rdo_qppzno;
	private CarLx_Adapter carLx_Adapter = null;
	private boolean PzlxToTakePhoto = true;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestDate = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_pz_lx);
		Md_Car_Temp.getTempCar().zdyPZXM = null;
		Md_Car_Temp.getTempCar().mDataList = null;
		Md_Car_Temp.getTempCar().basicPZXM = null;
		Md_Car_Temp.getTempCar().zdyHasTakeCodes = null;
		Md_Car_JYXM.message = "";
		Md_Car_Temp.getTempCar().basicPZXMState = null;
		GetPzLx_Data_Binging();
		isCameraSave = false;
		currentIndex = -1;
	}

	@Override
	protected void onStart() {
		super.onStart();
		if (Md_Car_Temp.getTempCar().mDataList != null
				&& Md_Car_Temp.getTempCar().mDataList.size() != 0) {
			Md_Car_Temp.getTempCar().carPhotoBooeal = true;
			Pzlx_Activity.this.request("18Q22", getRequestPZZTDate(),
					R.string.REQUEST_PZZT_MESSAGE_ID, new String[] { "2" });
			// getPZZT(Md_Car_JYXM.message);
			// initCarLx_Adapter();
			// initListView();
		}
	}

	@Override
	protected void onDestroy() {
		isCameraSave = false;
		currentIndex = -1;
		super.onDestroy();
	}

	/**
	 * �����˵�
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		int group1 = 1;
		int group2 = 2;
		int group3 = 3;
		menu.add(group1, 1, 1, "�������");
		menu.add(group2, 2, 2, "ע��ϵͳ");
		menu.add(group3, 3, 3, "�˳�ϵͳ");
		return true;

	}

	/**
	 * �˵�ѡ���¼�
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (isAsycn) {

			switch (item.getItemId()) {
			case 1:
				if (isupstate) {
					DefautDialog.showDialog(
							Pzlx_Activity.this,
							Pzlx_Activity.this.getResources().getString(
									R.string.SYS_TITLE),
							"һ��ȷ�Ͻ��޷������ҳ��,ȷ��Ҫ���������", false, null, null);
				} else {
					DefautDialog.showDialog(
							Pzlx_Activity.this,
							Pzlx_Activity.this.getResources().getString(
									R.string.SYS_TITLE), "�뽫��Ƭ��������Ժ����ϴ�״̬��",
							false, null, null);
				}
				break;
			case 2:
				this.zxsystem = true;
				DefautDialog.showDialog(Pzlx_Activity.this, Pzlx_Activity.this
						.getResources().getString(R.string.SYS_TITLE),
						"ȷ��Ҫע��ϵͳ��", true, new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View arg0) {
								dialog.dimiss();
								Md_Car_Temp.getTempCar().ispbzc = true;
								Intent itt = new Intent();
								itt.setClass(Pzlx_Activity.this,
										Login_Activity.class);
								startActivity(itt);
								finish();
							}
						}, null);
				break;
			case 3:
				DefautDialog.showDialog(Pzlx_Activity.this, Pzlx_Activity.this
						.getResources().getString(R.string.SYS_TITLE),
						"ȷ���˳�ϵͳ��", true, new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View arg0) {
								dialog.dimiss();
								Md_Car_Temp.getTempCar().ispbzc = true;
								Intent itt = new Intent();
								itt.setClass(Pzlx_Activity.this,
										Login_Activity.class);
								startActivity(itt);
								finish();
							}
						}, null);
				break;
			}
		}
		return true;
	}

	/**
	 * ��ȡ��Ϣ���󶨿ؼ�
	 */
	private void GetPzLx_Data_Binging() {
		hphm = (TextView) findViewById(R.id.car_pz_hphm);
		hphm.setText(Md_Car_Temp.getTempCar().car_hphm);
		hpzl = (TextView) findViewById(R.id.car_pz_cllx);
		hpzl.setText(Md_Car_Temp.getTempCar().car_lx);
		vin = (TextView) findViewById(R.id.car_pz_vin);
		vin.setText(Md_Car_Temp.getTempCar().car_vin);
		listView = (ListView) findViewById(R.id.car_pz_list);
		qtlistView = (ListView) findViewById(R.id.car_pz_qt_list);
		car_list_progressBar_dengdai = (ProgressBar) findViewById(R.id.car_list_progressBar_dengdai);
		dengdai_msg = (TextView) findViewById(R.id.dengdai_msg);
		zdypzxm = (Button) findViewById(R.id.zdypzxm);
		zcdjzp = (Button) findViewById(R.id.zcdjzp);
		zcdjzp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// ��ȡ������Ŀ
				Pzlx_Activity.this.request("01C02", getRequestDJZPDate(),
						R.string.REQUEST_DZJP_MESSAGE_ID, new String[] { "2" });
			}
		});
		item_qppzcontent_rdogrp = (RadioGroup) findViewById(R.id.item_qppzcontent_rdogrp);
		item_rdo_qppzno = (RadioButton) findViewById(R.id.item_rdo_qppzno);
		item_rdo_qppzyes = (RadioButton) findViewById(R.id.item_rdo_qppzyes);
		if (Md_Car_Temp.getTempCar().sfqppz.equals("��")) {
			item_rdo_qppzyes.setChecked(true);
		} else {
			item_rdo_qppzno.setChecked(true);
		}
		item_qppzcontent_rdogrp
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == item_rdo_qppzyes.getId()) {
							Md_Car_Temp.getTempCar().sfqppz = "��";
						} else {
							Md_Car_Temp.getTempCar().sfqppz = "��";
						}
					}
				});
		// ��ȡ������Ŀ
		Pzlx_Activity.this.request("18C47", getRequestPZXMDate(),
				R.string.REQUEST_PZXM_MESSAGE_ID, new String[] { "2" });

		// ���ü����¼�

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long arg3) {
				if (!PzlxToTakePhoto) {
					return;
				}
				PzlxToTakePhoto = false;
				Md_Car_Temp.getTempCar().pz_code = ((TextView) view
						.findViewById(R.id.pz_code)).getText().toString();
				Md_Car_Temp.getTempCar().car_xmName = ((TextView) view
						.findViewById(R.id.pz_xm)).getText().toString();
				currentIndex = position;
				Intent itt = new Intent();
				isCameraSave = false;
				itt.putExtra("isCameraSave", "paizhao");
				itt.setClass(Pzlx_Activity.this, TakePhotoActivity.class);
				startActivity(itt);
				PzlxToTakePhoto = true;
			}
		});

		zdypzxm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isBasicPhotoHasTakeAll()) {
					DefautDialog.showDialog(Pzlx_Activity.this,
							R.string.SYS_TITLE,
							R.string.FINISH_TAKE_BASICTAKEPHOTO, true,
							new DefautDialog.OnClickListener() {
								@Override
								public void onClick(DefautDialog dialog,
										View arg0) {
									dialog.dimiss();
									Application_Activity.goToActivity(
											Pzlx_Activity.this,
											zdypzxm_Activity.class);
								}
							}, null);
				} else {
					DefautDialog.showDialog(Pzlx_Activity.this,
							R.string.SYS_TITLE,
							R.string.NOFINISH_TAKE_BASICTAKEPHOTO, false, null,
							null);
				}

			}
		});
		initQTListVist();
		// ���ü����¼�
		qtlistView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long arg3) {
				if (!PzlxToTakePhoto) {
					return;
				}
				PzlxToTakePhoto = false;
				shouAndSelectFromListPhotoItem();
				PzlxToTakePhoto = true;
			}
		});
	}
/**
 * ��ʱ����
 * @author Administrator
 *
 */
	class MyThread implements Runnable {
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finish();
		}
	}
/**
 * ѡ���б���������Ŀ�������ղ���
 * 
 */
	private void shouAndSelectFromListPhotoItem() {
		ArrayAdapter<Md_cartype> adapter = null;
		View popView = LayoutInflater.from(this).inflate(R.layout.qtzp, null);
		final Spinner zpmc_s = (Spinner) popView.findViewById(R.id.zpmc_s);
		adapter = new ArrayAdapter<Md_cartype>(this,
				android.R.layout.simple_spinner_item, MD_ListItem.Get_zpmc());
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		zpmc_s.setAdapter(adapter);
		final AlertDialog dialog = new AlertDialog.Builder(Pzlx_Activity.this)
				.setTitle("ѡ��������Ƭ��").setView(popView)
				.setNegativeButton("ȡ��", null)
				.setPositiveButton("����", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Md_Car_Temp.getTempCar().pz_code = ((Md_cartype) zpmc_s
								.getSelectedItem()).getName();
						Md_Car_Temp.getTempCar().car_xmName = Md_Car_JYXM.Car_wgpzxm
								.get(Md_Car_Temp.getTempCar().pz_code);
						if (Md_Car_Temp.getTempCar().pz_code != null
								&& !"".equals(Md_Car_Temp.getTempCar().pz_code)) {
							Md_Car_Temp.getTempCar().dataqt = new HashMap<String, Object>();

							Md_Car_Temp.getTempCar().dataqt.put("pz_img",
									R.drawable.camera2);
							Md_Car_Temp.getTempCar().dataqt.put("pz_xm",
									Md_Car_Temp.getTempCar().car_xmName);
							Md_Car_Temp.getTempCar().dataqt.put("pz_code",
									Md_Car_Temp.getTempCar().pz_code);
							Md_Car_Temp.getTempCar().dataqt
									.put("property", "0");
							goToTakePhotoActivity();
						}
					}
				}).show();
	}

	private void goToTakePhotoActivity() {
		Intent itt = new Intent();
		itt.setClass(Pzlx_Activity.this, TakePhotoActivity.class);
		startActivity(itt);
	}

	private void initQTListVist() {
		List<Map<String, Object>> DataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pz_img", R.drawable.camera2);
		map.put("pz_xm", "��         ��         ��        Ƭ  ");
		map.put("pz_code", "0");
		map.put("property", "");
		DataList.add(map);
		Map<Integer, Boolean> isSelected = new HashMap<Integer, Boolean>();
		isSelected.put(0, true);
		CarLx_Adapter carLx_Adapter_qt = new CarLx_Adapter(Pzlx_Activity.this,
				DataList, isSelected);
		qtlistView.setItemsCanFocus(false);
		qtlistView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		qtlistView.setAdapter(carLx_Adapter_qt);
	}

	/**
	 * ��ȡ������Ŀ
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestPZXMDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		Map<String, Object> requestMap = new HashMap<String, Object>();
		Map<String, Object> requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("jyjgbh", Md_system.getDzkey());
		requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
		requestDate.put("hpzl", Md_Car_Temp.getTempCar().car_hpzl);
		requestMap.put("QueryCondition", requestDate);
		return requestMap;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isupstate) {
				Md_Car_JYXM.message = "";
				DefautDialog.showDialog(Pzlx_Activity.this, R.string.SYS_TITLE,
						R.string.FINISH_TAKE_PHOTO_ISSETWCPZ, true,
						new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View arg0) {
								dialog.dimiss();
								Intent i = new Intent();
								if (Md_Car_Temp.getTempCar().FromPzlistToPzlx
										.equals("yes")) {
									i.setClass(Pzlx_Activity.this,
											PzCarList_Activity.class);
								} else if (Md_Car_Temp.getTempCar().FromReTakeToPz
										.equals("yes")) {
									i.setClass(Pzlx_Activity.this,
											ReTakePictureActivity.class);
								} else {
									// Md_Car_Temp.getTempCar().car_hphm = "";
									// Md_Car_Temp.getTempCar().car_hpzl = "";
									if (Md_system.getSfdtdp().equals("��")) {
										if (Md_Car_Temp.getTempCar().car_jyxm
												.contains("DC")) {
											if (Md_Car_Temp.getTempCar().car_ywcjyxm != null
													&& Md_Car_Temp.getTempCar().car_ywcjyxm
															.contains("DC")) {
												Toast.makeText(
														Pzlx_Activity.this,
														"���̼������ύ������������������....",
														1000).show();
												i.setClass(Pzlx_Activity.this,
														CarLoginActivity.class);
											} else {
												i.setClass(
														Pzlx_Activity.this,
														Dt_Dpjy_Item_Activity.class);
											}
										} else {
											i.setClass(Pzlx_Activity.this,
													CarLoginActivity.class);
										}
									} else {
										i.setClass(Pzlx_Activity.this,
												CarLoginActivity.class);
									}

								}
								startActivity(i);
								finish();
							}
						}, new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View arg0) {
								dialog.dimiss();
							}
						});
			} else {
				Md_Car_JYXM.message = "";
				DefautDialog.showDialog(Pzlx_Activity.this, R.string.SYS_TITLE,
						R.string.GOOUT_TAKE_PHOTO, true,
						new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View arg0) {
								dialog.dimiss();
								Intent i = new Intent();
								if (Md_Car_Temp.getTempCar().FromPzlistToPzlx
										.equals("yes")) {
									i.setClass(Pzlx_Activity.this,
											PzCarList_Activity.class);
								} else if (Md_Car_Temp.getTempCar().FromReTakeToPz
										.equals("yes")) {
									i.setClass(Pzlx_Activity.this,
											ReTakePictureActivity.class);
								} else {
									Md_Car_Temp.getTempCar().car_hphm = "";
									Md_Car_Temp.getTempCar().car_hpzl = "";
									i.setClass(Pzlx_Activity.this,
											CarLoginActivity.class);
								}
								startActivity(i);
								finish();
							}
						}, null);

			}
		}
		return true;
	}

	/**
	 * ��ȡ����״̬
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestDJZPDate() {
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

	/**
	 * �жϻ�����Ƭ�Ƿ�������ȫ
	 */
	private Boolean isBasicPhotoHasTakeAll() {
		if (Md_Car_Temp.getTempCar().basicPZXMState == null
				|| Md_Car_Temp.getTempCar().basicPZXMState.size() == 0) {
			return true;
		} else {
			for (String code : Md_Car_Temp.getTempCar().basicPZXM) {
				if (Md_Car_Temp.getTempCar().basicPZXMState.contains(code)) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * ��ȡ������Ŀ
	 * 
	 * @param listmxw
	 */
	private void getPZXM(Map<String, String> pzxm) {
		try {
			String[] pzxms = null;
			if (!pzxm.get("wgjyzp").equals("")) {
				pzxms = pzxm.get("wgjyzp").split(",");
			}
			if (Md_Car_Temp.getTempCar().mDataList == null) {
				Md_Car_Temp.getTempCar().mDataList = new ArrayList<Map<String, Object>>();
			}

			if (Md_Car_Temp.getTempCar().basicPZXM == null) {
				Md_Car_Temp.getTempCar().basicPZXM = new ArrayList<String>();
			}

			Md_Car_Temp.getTempCar().basicPZXM = Arrays.asList(pzxms);

			if (Md_Car_Temp.getTempCar().webState) {
				for (int i = 0; i < pzxms.length; i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("pz_img", R.drawable.camera2);
					map.put("pz_xm", Md_Car_JYXM.Car_wgpzxm.get(pzxms[i]));
					map.put("pz_code", pzxms[i]);
					map.put("property", "0");
					Md_Car_Temp.getTempCar().mDataList.add(map);
				}
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("pz_img", R.drawable.camera2);
				map.put("pz_xm", "");
				map.put("pz_code", "null");
				map.put("property", "");
				Md_Car_Temp.getTempCar().mDataList.add(map);
			}
			if (pzxms.length > 0) {
				Md_Car_Temp.getTempCar().carPhotoBooeal = true;
			} else {
				Md_Car_Temp.getTempCar().carPhotoBooeal = false;
			}
		} catch (Exception e) {
			return;
		}
	}

	/**
	 * ��ȡ״ֵ̬,��ʱ����
	 */
	private void getPZZT(String message) {
		String[] code = null;
		if (!message.equals("")) {
			code = message.split(",");
		}
		if (Md_Car_Temp.getTempCar().basicPZXMState == null) {
			Md_Car_Temp.getTempCar().basicPZXMState = new ArrayList<String>();
		}
		if (Md_Car_Temp.getTempCar().isSelected == null) {
			Md_Car_Temp.getTempCar().isSelected = new HashMap<Integer, Boolean>();
		}
		if (code != null && code.length > 0) {
			Md_Car_Temp.getTempCar().basicPZXMState = Arrays.asList(code);
			if (code.length > 0) {
				for (int i = 0; i < Md_Car_Temp.getTempCar().mDataList.size(); i++) {
					for (int j = 0; j < code.length; j++) {
						if (code[j].equals(Md_Car_Temp.getTempCar().mDataList
								.get(i).get("pz_code").toString())) {
							Md_Car_Temp.getTempCar().isSelected.put(i, false);
							break;
						} else {
							Md_Car_Temp.getTempCar().isSelected.put(i, true);
						}
					}
				}
			}
		} else {
			Md_Car_Temp.getTempCar().basicPZXMState = null;
			for (int i = 0; i < Md_Car_Temp.getTempCar().mDataList.size(); i++) {
				if (Md_Car_Temp.getTempCar().zdyPZXM != null
						&& Md_Car_Temp.getTempCar().zdyPZXM.size() > 0) {
					for (String zdycode : Md_Car_Temp.getTempCar().zdyPZXM) {
						if (Md_Car_Temp.getTempCar().mDataList.get(i)
								.get("pz_code").equals(zdycode)) {
							if (Md_Car_Temp.getTempCar().zdyHasTakeCodes != null
									&& Md_Car_Temp.getTempCar().zdyHasTakeCodes
											.size() > 0) {
								for (String istakephotocode : Md_Car_Temp
										.getTempCar().zdyHasTakeCodes) {
									if (istakephotocode.equals(zdycode)) {
										Md_Car_Temp.getTempCar().isSelected
												.put(i, true);
									} else {
										Md_Car_Temp.getTempCar().isSelected
												.put(i, false);
									}
								}
							} else {
								Md_Car_Temp.getTempCar().isSelected.put(i,
										false);
							}
						} else {
							Md_Car_Temp.getTempCar().isSelected.put(i, true);
						}
					}
				} else {
					Md_Car_Temp.getTempCar().isSelected.put(i, true);
				}
			}
		}
	}

	/**
	 * ��ʼ��ListView����������
	 */
	

	private void initCarLx_Adapter() {
		Boolean isc = false;
		try {
			if (Md_Car_Temp.getTempCar().isFinish
					&& Md_Car_Temp.getTempCar().dataqt != null) {
				System.out.println("Md_Car_Temp.getTempCar().mDataList"
						+ Md_Car_Temp.getTempCar().mDataList);
				String pz_code = Md_Car_Temp.getTempCar().dataqt.get("pz_code")
						.toString();
				for (int i = 0; i < Md_Car_Temp.getTempCar().mDataList.size(); i++) {

					if (Md_Car_Temp.getTempCar().mDataList.get(i)
							.get("pz_code").equals(pz_code)) {
						System.out.println("1111"
								+ Md_Car_Temp.getTempCar().mDataList.get(i)
										.get("pz_code"));
						// Md_Car_Temp.getTempCar().mDataList.remove(i);
						Md_Car_Temp.getTempCar().isSelected.put(i, true);
						isc = true;
					}
				}
				if (!isc) {
					Md_Car_Temp.getTempCar().mDataList.add(Md_Car_Temp
							.getTempCar().dataqt);
					Md_Car_Temp.getTempCar().isSelected
							.put(Md_Car_Temp.getTempCar().mDataList.size() - 1,
									true);
				}
				Md_Car_Temp.getTempCar().isFinish = false;
				Md_Car_Temp.getTempCar().dataqt = null;

			}
		} catch (Exception e) {

		}
		if (!Md_Car_Temp.getTempCar().mDataList.isEmpty()) {
			carLx_Adapter = new CarLx_Adapter(Pzlx_Activity.this,
					Md_Car_Temp.getTempCar().mDataList,
					Md_Car_Temp.getTempCar().isSelected);
		}
	}

	/**
	 * ��ʼ������
	 */
	private void initListView() {
		try {
			if (!carLx_Adapter.isEmpty()) {
				if (carLx_Adapter.getCount() == 0) {
					dengdai_msg.setText("��Ǹ��û�в�ѯ���б�������!");
					DefautDialog.showDialog(Pzlx_Activity.this,
							R.string.SYS_TITLE, R.string.NOTGETPZXM, false,
							null, null);
				} else {
					car_list_progressBar_dengdai.setVisibility(View.GONE);
					dengdai_msg.setVisibility(8);
					listView.setItemsCanFocus(false);
					listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
					listView.setAdapter(carLx_Adapter);
					if (Md_Car_Temp.getTempCar().carPhotoBooeal) {
						int count = 0;
						for (int i = 0; i < carLx_Adapter.isSelected.size(); i++) {
							if (carLx_Adapter.isSelected.get(i).booleanValue()) {
								count++;
							}
						}
						if (count == carLx_Adapter.isSelected.size()) {
							isupstate = true;
						} else {
							isupstate = false;
						}

					} else {
						DefautDialog.showDialog(Pzlx_Activity.this,
								R.string.SYS_TITLE, R.string.NOTGETPZXM, false,
								null, null);
					}
				}
			} else {
				DefautDialog.showDialog(Pzlx_Activity.this, R.string.SYS_TITLE,
						R.string.NOTGETPZXM, false, null, null);
			}
		} catch (Exception e) {
			DefautDialog.showDialog(Pzlx_Activity.this, R.string.SYS_TITLE,
					R.string.NOTGETPZXM, false, null, null);
		}
	}

	/**
	 * ��ʾ�Ǽ���Ƭ
	 * 
	 * @param result
	 */
	private void setDJZP(Map<String, Object> result) {
		if (result != null) {
			// ���ݴ���
			View popView = LayoutInflater.from(Pzlx_Activity.this).inflate(
					R.layout.car_djzp_pop, null);
			ImageView imageView = (ImageView) popView
					.findViewById(R.id.imgvCameras);
			TextView txtCameraImgv = (TextView) popView
					.findViewById(R.id.txtCameraImgvs);
			if (result.get("zp") != null) {
				imageView.setVisibility(View.VISIBLE);
				txtCameraImgv.setVisibility(View.GONE);
				imageView.setImageBitmap((Bitmap) result.get("zp"));
			} else {
				imageView.setVisibility(View.GONE);
				txtCameraImgv.setVisibility(View.VISIBLE);
				txtCameraImgv.setText("�޵Ǽ���Ƭ");
			}
			new AlertDialog.Builder(Pzlx_Activity.this).setTitle("�Ǽ���Ƭ")
					.setCancelable(false).setView(popView)
					.setNegativeButton("��    ��", null).show();
		} else {
			DefautDialog.showDialog(Pzlx_Activity.this, Pzlx_Activity.this
					.getResources().getString(R.string.SYS_TITLE),
					"��ѯ�����Ǽ���Ƭʧ��!������", false, null, null);
		}
	}

	/**
	 * ��ȡ����״̬
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestPZZTDate() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		Map<String, Object> requestMap = new HashMap<String, Object>();
		Map<String, Object> requestDate = new HashMap<String, Object>();
		requestDate.put("jylsh", Md_Car_Temp.getTempCar().car_lsh);
		requestDate.put("clsbdh", Md_Car_Temp.getTempCar().car_vin);
		requestMap.put("QueryCondition", requestDate);
		return requestMap;
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try {
			if ("18C47".equals(jkid)) {
				Map<String, String> jyxm = (Map<String, String>) result;
				if (jyxm.get("hasbody").equals("no")
						|| jyxm.get("wgjyzp").equals("")
						|| jyxm.get("cyzp").equals("")) {
					Pzlx_Activity.this.alert("��ѯ��Ƭ��Ŀʧ�ܣ������ԣ�",
							new DefautDialog.OnClickListener() {
								@Override
								public void onClick(DefautDialog dialog,
										View view) {
									dialog.dimiss();
									Pzlx_Activity.this.request("18C47",
											getRequestPZXMDate(),
											R.string.REQUEST_PZXM_MESSAGE_ID,
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
					getPZXM(jyxm);
					Pzlx_Activity.this.request("18Q22", getRequestPZZTDate(),
							R.string.REQUEST_PZZT_MESSAGE_ID,
							new String[] { "2" });
				}
			} else if ("18Q22".equals(jkid)) {
				HashMap<String, String> list_PZZT = (HashMap<String, String>) result;
				if (list_PZZT != null && list_PZZT.size() > 0
						&& !list_PZZT.get("wpzp").equals("")) {
					getPZZT(list_PZZT.get("wpzp"));
				} else {
					getPZZT("");
				}
				initCarLx_Adapter();
				initListView();
			} else if ("01C02".equals(jkid)) {
				Map<String, Object> zp = (Map<String, Object>) result;
				setDJZP(zp);
			}
		} catch (Exception e) {
			DefautDialog.showDialog(Pzlx_Activity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	public void alert(String msg, DefautDialog.OnClickListener qdaction,
			DefautDialog.OnClickListener qxaction) {
		DefautDialog.showDialog(Pzlx_Activity.this, Pzlx_Activity.this
				.getResources().getString(R.string.SYS_TITLE), msg, true,
				qdaction, qxaction);
	}
}

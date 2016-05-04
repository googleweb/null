package scxd.jcz.ajlw.android.Activity;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.ButtonTools;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.Md_system;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * ���ܲ˵�
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class MainActivity extends BaseActivity {
	private ImageView image_logo;
	private Button[] btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jclw_main);
		init();
		
	}

	@Override
	protected void onStart() {
		super.onStart();
		this.setLimit();
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.setLimit();
	}

	/**
	 * ���ݳ�ʼ��
	 */
	@SuppressWarnings("deprecation")
	void init() {
		//��ʼ������һ�η�ֹ���ݻ���
		Md_Car_Temp.car_hphm = "";
		Md_Car_Temp.car_vin = "";
		Md_Car_Temp.car_hpzl = "";
		image_logo = (ImageView) findViewById(R.id.image_logo);
		if (Md_system.dq.trim().equals("") || Md_system.getDq().equals("")) {
			image_logo.setBackgroundDrawable(getResources().getDrawable(
					(R.drawable.mian_bj)));
		} else if (Md_system.getDq().equals("�㶫")) {
			image_logo.setBackgroundDrawable(getResources().getDrawable(
					(R.drawable.mian_gdhs)));
		} else if (Md_system.getDq().equals("����")) {
			image_logo.setBackgroundDrawable(getResources().getDrawable(
					(R.drawable.mian_bj)));
		} else if (Md_system.getDq().equals("�Ĵ�")) {
			image_logo.setBackgroundDrawable(getResources().getDrawable(
					(R.drawable.mian_logo)));
		} else if (Md_system.getDq().equals("����")) {
			image_logo.setBackgroundDrawable(getResources().getDrawable(
					(R.drawable.mian_bj)));
		} else {
			image_logo.setBackgroundDrawable(getResources().getDrawable(
					(R.drawable.mian_bj)));
		}
		this.btn = new Button[15];
		this.btn[0] = (Button) findViewById(R.id.main_btu_zxxt);// ע��
		this.btn[1] = (Button) findViewById(R.id.main_btu_car);// ������½
		this.btn[2] = (Button) findViewById(R.id.main_btn_clcy);// ��������--/δ����״̬
		this.btn[3] = (Button) findViewById(R.id.main_btu_rgjy);// ��ۼ���
		this.btn[4] = (Button) findViewById(R.id.main_btu_wjpz);// ����
		this.btn[5] = (Button) findViewById(R.id.main_btu_dtdp);// ��̬���̼���
		this.btn[6] = (Button) findViewById(R.id.main_btu_dpjy);// ���̼���
		this.btn[7] = (Button) findViewById(R.id.main_btn_xtgl);// ϵͳ����
		this.btn[8] = (Button) findViewById(R.id.main_btn_retakepicture);// ��Ƭ����
		this.btn[9] = (Button) findViewById(R.id.main_btn_ls_car);// ·��
		this.btn[10] = (Button) findViewById(R.id.main_btu_cai_login_list);// �����б�
		this.btn[11] = (Button) findViewById(R.id.main_btn_delete_car);// �����˰�
		this.btn[12] = (Button) findViewById(R.id.main_btn_ggbd_car);// ����--/δ����״̬
		this.btn[13] = (Button) findViewById(R.id.main_ggxx);// ����
		this.btn[14] = (Button) findViewById(R.id.main_btn_forcerecheck_car);//ǿ���ؼ�
		// ע��
		this.btn[0].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DefautDialog.showDialog(MainActivity.this, MainActivity.this
						.getResources().getString(R.string.SYS_TITLE),
						"ȷ��Ҫע��ϵͳ��", true, new DefautDialog.OnClickListener() {
							@Override
							public void onClick(DefautDialog dialog, View view) {
								dialog.dimiss();
								Md_Car_Temp.getTempCar().ispbzc = true;
								Intent itt = new Intent();
								itt.setClass(MainActivity.this,
										Login_Activity.class);
								startActivity(itt);
								finish();
							}
						}, null);
			}
		});
		// ��½
		this.btn[1].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Md_Car_Temp.getTempCar().car_hphm = "";
					Md_Car_Temp.getTempCar().car_hpzl = "";
					Intent itt = new Intent(MainActivity.this,
							CarLoginActivity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}

			}
		});
		// ����Ԥ���б�
		this.btn[10].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Md_Car_Temp.getTempCar().car_hphm = "";
					Md_Car_Temp.getTempCar().car_hpzl = "";
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, CarLoginListActivity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		// �˹�����
		this.btn[3].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Md_Car_Temp.getTempCar().iscarPeople = true;
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, CarPeopleXm_Activity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});

		// ����
		this.btn[4].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Md_Car_Temp.getTempCar().iscarPeople = false;
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, PzCarList_Activity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});

		// ��̬����
		this.btn[5].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Md_Car_Temp.getTempCar().iscarPeople = true;
					Intent itt = new Intent();
					itt.setClass(MainActivity.this,
							Dt_DpjyCarList_Activity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		// ���̼���
		this.btn[6].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Md_Car_Temp.getTempCar().iscarPeople = true;
					Md_Car_Temp.getTempCar().dptjfh = false;
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, DpjyCarList_Activity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		// ϵͳ����
		this.btn[7].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, SystemActivity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		// ��Ƭ����
		this.btn[8].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, ReTakePictureActivity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		// ����·��
		this.btn[9].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, LsCarList_Activity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		// ����
		this.btn[2].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, InspectionActivity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		// ����
		this.btn[11].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Intent itt = new Intent();
					itt.setClass(MainActivity.this,
							ManageCarList_Activity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		// ����ȶ�
		this.btn[12].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, GGBD_Activity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		this.btn[13].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Intent itt = new Intent();
					itt.setClass(MainActivity.this, GGXX_ListActivity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
		//ǿ���ؼ�
		this.btn[14].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!ButtonTools.isFastDoubleClick()) {
					Intent itt = new Intent();
					itt.setClass(MainActivity.this,
							ForceRecheckCar_Activity.class);
					startActivity(itt);
				} else {
					Toast.makeText(MainActivity.this, "�벻Ҫ�ظ����", 0).show();
				}
			}
		});
	}

	/**
	 * ����ƽ�巵�ذ��������¼�
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}

	/**
	 * ���� Ȩ��
	 * 
	 * @param acl
	 */
	private void setLimit() {
		try {
			String[] permissions = null;
			if (Md_Car_Temp.getTempCar().acl.equals("")) {
				permissions = new String[] { "0", "1", "2", "3", "4", "5", "6",
						"7", "8", "9", "10", "11", "12" ,"14"};
			} else {
				permissions = Md_Car_Temp.getTempCar().acl.split(",");
			}
//			 permissions = new String[] { "0", "2", "1", "3", "4", "5", "6", 
//			 "7", "8", "9", "10", "11", "12" };
			for (String permission : permissions) {
				btn[Integer.parseInt(permission)].setEnabled(true);
			}
		} catch (Exception e) {
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		// TODO Auto-generated method stub
		
	}
}

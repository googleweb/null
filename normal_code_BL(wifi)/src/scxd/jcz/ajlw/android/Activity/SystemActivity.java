package scxd.jcz.ajlw.android.Activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Adapter.LsPeople_Adapter;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.LsPeopleProvider;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ViewFlipper;
/**
 * 系统管理
 * @author Administrator
 *@time
 */
public class SystemActivity extends BaseActivity {

	private RadioGroup lsItemsGroup;
	private ViewFlipper lsItemsFlipper;
	private Button addButton;
	private Button cancelButton;
	private ListView listView;
	Button btu_pass_qr;
	Button btu_pass_qx;
	EditText text_pass_old;
	EditText text_pass_new;
	EditText text_pass_com;
	String alertMsg = "";
	String alertTitle = "";
	String pass_old;
	String pass_new;
	String pass_com;
	List<Md_Car_TongYong> list;
	ProgressDialog p_dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.system_layout);
		this.init();
		this.refreshList();
	}

	/**
	 * 初始化数据
	 */
	void init() {
		try {
			this.lsItemsGroup = (RadioGroup) findViewById(R.id.sys_radioGroup);
			this.lsItemsFlipper = (ViewFlipper) findViewById(R.id.sys_viewFlipper);
			this.addButton = (Button) findViewById(R.id.lsry_btn_add);
			this.cancelButton = (Button) findViewById(R.id.lsry_btn_cancel);
			this.listView = (ListView) findViewById(R.id.lsry_list_lsry);
			btu_pass_qr = (Button) findViewById(R.id.btu_up_pass_qr);
			btu_pass_qx = (Button) findViewById(R.id.btu_up_pass_qx);
			text_pass_new = (EditText) findViewById(R.id.text_pass_new);
			text_pass_old = (EditText) findViewById(R.id.text_pass_old);
			text_pass_com=(EditText) findViewById(R.id.text_pass_comfig);
			// 项目选项切换
			this.lsItemsGroup
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(RadioGroup group,
								int checkedId) {
							int checkedIndex = checkedId - group.getId();
							if (checkedIndex == 1) {
								lsItemsFlipper.showPrevious();
							} else {
								lsItemsFlipper.showNext();
							}
						}
					});

			btu_pass_qr.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					pass_old = text_pass_old.getText().toString().trim();
					pass_new = text_pass_new.getText().toString().trim();
					pass_com = text_pass_com.getText().toString().trim();
					if(pass_old.length()>3&&pass_new.length()>3) {
						if(pass_new.equals(pass_com)) {
							SystemActivity.this.request("18J03",
									getRequestGetUpdatePassWordDate(),
									R.string.REQUEST_UPDATE_PASSWORD_ID,
									new String[] {"1"});
						}else {
							dialog_xm("两次输入的新密码不一致", null,false);
						}
						
					}else {
						dialog_xm("请确认密码是否输入完整！", null,false);
					}
					/*if (pass_old.length() > 0 && pass_new.length() > 0) {
						SystemActivity.this.request("18J03",
								getRequestGetUpdatePassWordDate(),
								R.string.REQUEST_UPDATE_PASSWORD_ID,
								new String[] {"1"});
					} else {
						dialog_xm("请确认密码是否输入完整！", null,false);
					}*/
				}
			});
			btu_pass_qx.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					finish();
				}
			});
			this.addButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					addPeople();
				}
			});

			this.cancelButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					finish();
				}
			});

		} catch (Exception e) {
		}
	}

	/**
	 * 密码修改提交数据
	 * 
	 * @return
	 */
	private Map<String, Object> getRequestGetUpdatePassWordDate() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		Map<String, Object> requestDate = new HashMap<String, Object>();
		requestDate.put("userid", Md_Car_Temp.getTempCar().username);
		requestDate.put("oldpwd", pass_old);
		requestDate.put("newpwd", pass_new);
		requestMap.put("vehispara", requestDate);
		return requestMap;
	}

	private void refreshList() {
		LsPeople_Adapter lsryAdapter = new LsPeople_Adapter(this);
		this.listView.setAdapter(lsryAdapter);
		System.gc();
	}

	private void addPeople() {
		View lsryInfoInput = LayoutInflater.from(this).inflate(
				R.layout.lsry_info_input, null);
		final EditText nameEditText = (EditText) lsryInfoInput
				.findViewById(R.id.lsry_edt_name);

		new AlertDialog.Builder(this).setTitle("路试人员信息").setView(lsryInfoInput)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String lsryName = nameEditText.getText().toString()
								.trim().replace(" ", "");
						String msg = "";
						if (match(lsryName)) {
							if (LsPeopleProvider.getInstance(
									SystemActivity.this).insert(lsryName)) {
								msg = "添加成功\n姓名: " + lsryName;
								refreshList();
							} else {
								msg = "未能添加";
							}
						} else {
							msg = "请输入正确的姓名";
						}
						Toast.makeText(SystemActivity.this, msg, 1000).show();
					}
				}).setNegativeButton("取消", null).show();
	}

	private boolean match(String string) {
		if (string.length() < 10 && string.length() != 0
				&& string.matches("[\u4e00-\u9fa5]+")) {
			return true;
		} else
			return false;
	}

	/**
	 * 弹出对话框
	 */
	protected void dialog_xm(String msg, DefautDialog.OnClickListener action,Boolean isqdqx) {
		DefautDialog.showDialog(SystemActivity.this, SystemActivity.this
				.getResources().getString(R.string.SYS_TITLE), msg, isqdqx,
				action, null);

	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try{
		if ("18J03".equals(jkid)) {
			List<Md_Car_TongYong> callUpdatePassword = (List<Md_Car_TongYong>) result;
			callUpdatePas(callUpdatePassword);
		}
		}catch (Exception e) {
			DefautDialog.showDialog(SystemActivity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	/**
	 * 密码修改结果处理
	 * 
	 * @param callUpdatePassword
	 */
	private void callUpdatePas(List<Md_Car_TongYong> callUpdatePassword) {
		try {
			if (callUpdatePassword.get(0).code.equals("1")) {
				dialog_xm("密码修改成功", new DefautDialog.OnClickListener() {
					@Override
					public void onClick(DefautDialog dialog, View view) {
						dialog.dimiss();
						finish();
					}
				},false);
			} else {
				dialog_xm(callUpdatePassword.get(0).message, null,false);
			}
		} catch (Exception e) {
			dialog_xm("密码修改异常，请重新操作!", null,false);
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
}

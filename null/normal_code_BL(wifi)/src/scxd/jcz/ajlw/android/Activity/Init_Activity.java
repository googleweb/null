package scxd.jcz.ajlw.android.Activity;

import java.net.URL;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DESUtil;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.buss.SystemConfig;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.Md_system;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
/**
 * 初始化系统配置
 * @author Administrator
 *@time
 */
public class Init_Activity extends BaseActivity {

	private Spinner dp_sp;
	private Spinner sfhj_sp;
	private Spinner sfzj_sp;
	private Spinner sfgxjyxm_sp;
	private Spinner sfdtdp_sp;
	private Spinner sfsign_sp;
	private Spinner sfchose_sp;
	private Spinner sigle_login;

	private String dp = "北京";
	private String sfhj = "是";
	private String sfzj = "否";
	private String sfgxjyxm = "是";
	private String sfdtdp = "是";
	private String sfsign = "否";
	private String sfchose = "否";
	private String siglelogin="否";
	private Button btu_csh;
	private EditText txt_IP;
	private EditText txt_jyjgbh;
	private EditText txt_lsxh;
	private EditText txt_hapmlb;
	private String strIp = "";
	private String strJyjgbh = "";
	private String lsxh = "";
	private String hapmlb = "";

	/*
	 * public static String zpbh = "0111,0112,0113,0115,0116,0117,0118,0119," +
	 * "0126,0127,0128,0130,0132,0133,0134,0135,0136,0138,0139,0140,0154,0155,0156,0157,"
	 * +
	 * "0158,0159,0160,0161,0163,0201,0202,0203,0204,0205,0206,0207,0208,0211,0257,0321,"
	 * +
	 * "0322,0323,0341,0342,0343,0344,0345,0347,0348,0349,0350,0351,0352,0353,0354,0355"
	 * ;
	 */
	/*
	 * public static String zpmc =
	 * "车辆左前方斜视45度照片,车辆右后方斜视45度照片,车辆识别代号照片,车厢内部照片,灭火器照片,应急锤照片," +
	 * "行驶记录装置照片,发动机号或柔性标签,校车停车指示标志牌照片,急救箱,校车标志灯照片,辅助制动装置,发动机舱自动灭火装置," +
	 * "前轮盘式制动器,防抱死制动装置自检状态灯,残疾车操纵辅助装置,左前轮胎规格型号,校车、卧铺客车的车内外录像监控系统," +
	 * "校车的辅助倒车装置,教练车副制动踏板,右前轮胎规格型号,左后轮胎规格型号,右后轮胎规格型号,驾驶人座椅汽车安全带," +
	 * "车辆正后方照片,校车标牌（前）正面照片,校车标牌（前）反面照片,校车标牌（后）正面照片,危险货物运输车标志,机动车行驶证," +
	 * "机动车牌证申请表,机动车交通事故责任强制保险凭证,机动车安全技术检验报告单,机动车查验记录表,车船税纳税或者免税证明," +
	 * "委托核发检验合格标志通知书,代理人授权书,国产机动车整车出厂合格证和底盘合格证,路试检验记录单,左灯光工位照片,一轴制动工位照片," +
	 * "底盘检验照片,路试行车制动开始照片,底盘动态检验结束照片,路试行车制动结束照片,底盘动态检验开始照片,路试坡度驻车制动照片," +
	 * "车速表工位照片,二轴制动工位照片,三轴制动工位照片,四轴制动工位照片,驻车制动工位照片,右灯光工位照片,侧滑工位照片," +
	 * "五轴制动工位照片,六轴制动工位照片";
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.system_init);
		init();
	}

	/**
	 * 初始化界面
	 */
	public void init() {
		dp_sp = (Spinner) findViewById(R.id.dp_sp);
		sfhj_sp = (Spinner) findViewById(R.id.sfhj_sp);
		sfzj_sp = (Spinner) findViewById(R.id.sfzj_sp);
		sfgxjyxm_sp = (Spinner) findViewById(R.id.sfgxjyxm_sp);
		sfdtdp_sp = (Spinner) findViewById(R.id.sfdtdp_sp);
		sfchose_sp=(Spinner) findViewById(R.id.sfchose_sp);
		sfsign_sp=(Spinner) findViewById(R.id.sfsign_sp);
		sigle_login=(Spinner) findViewById(R.id.sigle_login);
		String[] mItemssfdtdp = getResources().getStringArray(R.array.sfhj);
		ArrayAdapter<String> _Adapter_dtdp = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mItemssfdtdp);
		_Adapter_dtdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sfdtdp_sp.setAdapter(_Adapter_dtdp);
		sfdtdp_sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				sfdtdp = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		try {
			if (Md_system.getSfdtdp().equals("否")) {
				sfdtdp_sp.setSelection(1);
			} else {
				sfdtdp_sp.setSelection(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayAdapter<String> _Adapter_sign = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mItemssfdtdp);
		_Adapter_sign.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sfsign_sp.setAdapter(_Adapter_sign);
		sfsign_sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				sfsign = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		try {
			if (Md_system.getSfSign().equals("否")) {
				sfsign_sp.setSelection(1);
			} else {
				sfsign_sp.setSelection(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayAdapter<String> _Adapter_login = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mItemssfdtdp);
		_Adapter_login.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sigle_login.setAdapter(_Adapter_login);
		sigle_login.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				siglelogin = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		try {
			if (Md_system.getSiglelogin().equals("否")) {
				sigle_login.setSelection(1);
			} else {
				sigle_login.setSelection(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayAdapter<String> _Adapter_chose = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mItemssfdtdp);
		_Adapter_chose.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sfchose_sp.setAdapter(_Adapter_chose);
		sfchose_sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				sfchose = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		try {
			if (Md_system.getSfchose().equals("否")) {
				sfchose_sp.setSelection(1);
			} else {
				sfchose_sp.setSelection(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] mItemssfgxjyxm = getResources().getStringArray(R.array.sfhj);
		ArrayAdapter<String> _Adapter_jyxm = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mItemssfgxjyxm);
		_Adapter_jyxm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sfgxjyxm_sp.setAdapter(_Adapter_jyxm);
		sfgxjyxm_sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				sfgxjyxm = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		try {
			if (Md_system.getSfgxjyxm().equals("否")) {
				sfgxjyxm_sp.setSelection(1);
			} else {
				sfgxjyxm_sp.setSelection(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] mItemssfhj = getResources().getStringArray(R.array.sfhj);
		ArrayAdapter<String> _Adapter_hj = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mItemssfhj);
		_Adapter_hj.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sfhj_sp.setAdapter(_Adapter_hj);
		sfhj_sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				sfhj = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/**综检**/
		ArrayAdapter<String> _Adapter_zj = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mItemssfhj);
		_Adapter_zj.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sfzj_sp.setAdapter(_Adapter_zj);
		sfzj_sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				sfzj = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		try {
			if (Md_system.getSfzj().equals("否")) {
				sfzj_sp.setSelection(1);
			} else {
				sfzj_sp.setSelection(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (Md_system.getSfhj().equals("否")) {
				sfhj_sp.setSelection(1);
			} else {
				sfhj_sp.setSelection(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] mItems = getResources().getStringArray(R.array.dp);
		ArrayAdapter<String> _Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mItems);
		_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dp_sp.setAdapter(_Adapter);
		dp_sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				dp = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		try {
			if (Md_system.dq.equals("北京")) {
				dp_sp.setSelection(0);
			} else if (Md_system.dq.equals("广东")) {
				dp_sp.setSelection(1);
			} else if (Md_system.dq.equals("四川")) {
				dp_sp.setSelection(2);
			} else if (Md_system.dq.equals("其它")) {
				dp_sp.setSelection(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		btu_csh = (Button) findViewById(R.id.but_csh);
		txt_IP = (EditText) findViewById(R.id.txt_IP);

		try {
			URL url = new URL(Md_system.getJk_url());
			if (url.getPort() == -1) {
				txt_IP.setText(url.getHost());
			} else {
				txt_IP.setText(url.getHost() + ":" + url.getPort());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		txt_jyjgbh = (EditText) findViewById(R.id.txt_jyjgbh);
		txt_jyjgbh.setText(Md_system.getDzkey());
		txt_lsxh = (EditText) findViewById(R.id.txt_lsxh);
		txt_lsxh.setText(Md_system.getLsxh());
		txt_hapmlb = (EditText) findViewById(R.id.txt_hapmlb);
		if (Md_system.getHphmlb().length() > 2) {
			txt_hapmlb.setText(Md_system.getHphmlb().subSequence(0, 1));
		} else {
			txt_hapmlb.setText(Md_system.getHphmlb());
		}
		btu_csh.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					strIp = txt_IP.getText().toString().trim();
					strJyjgbh = txt_jyjgbh.getText().toString().trim();
					lsxh = txt_lsxh.getText().toString().trim();
					hapmlb = txt_hapmlb.getText().toString().trim();
					if (strIp.length() == 0 || strJyjgbh.length() == 0) {
						dialog("请填写联网IP和检验机构编号!", null);
					} else {
						initConfig(strIp, strJyjgbh);
					}
				} catch (Exception e) {
					dialog("初始化系统失败，请重试!", null);
				}

			}
		});
	}
/**
 * 将获取到的数据封装成xml格式写入到配置文件当中
 * @param strIp IP数据
 * @param strJyjgbh 机构编号
 * @throws Exception
 */
	private void initConfig(String strIp, String strJyjgbh) throws Exception {
		String strConfig = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n"
				+ "<root><system>" + "\n" + "<url>http://"
				+ strIp
				+ "/TrffWeb/JCZService/TmriOutAccess.asmx</url>"
				+ "\n"
				+ "<ptkey>"
				+ DESUtil.encrypt(strJyjgbh, "9ce84a1f").toUpperCase()
				+ "</ptkey>"
				+ "\n"
				+ "<dzkey>"
				+ strJyjgbh
				+ "</dzkey>"
				+ "\n"
				+ "<hphmlb>"
				+ hapmlb
				+ "</hphmlb>"
				+ "\n"
				+ "<xtlb>18</xtlb>"
				+ "\n"
				/*
				 * + "<zpbh>" + zpbh + "</zpbh>" + "\n"
				 */
				/*
				 * + "<zpmc>" + zpmc + "</zpmc>" + "\n"
				 */
				+ "<dq>"
				+ dp
				+ "</dq>"
				+ "\n"
				+ "<sfdtdp>"
				+ sfdtdp
				+ "</sfdtdp>"
				+ "\n"
				+ "<sfgxjyxm>"
				+ sfgxjyxm
				+ "</sfgxjyxm>"
				+ "\n"
				+ "<lsxh>"
				+ lsxh
				+ "</lsxh>"
				+ "\n"
				+ "<sfhj>"
				+ sfhj
				+ "</sfhj>" 
				+ "\n"
				+ "<sfzj>"
				+ sfzj
				+ "</sfzj>"
				+ "\n"
				+ "<sfsign>"
				+ sfsign
				+ "</sfsign>"
				+ "\n"
				+ "<sigle>"
				+ siglelogin
				+ "</sigle>"
				+ "\n"
				+ "<sfchose>"
				+ sfchose
				+ "</sfchose>"+ "\n" + "</system></root>";

		if (SystemConfig.writeConfigFile(strConfig,
				"/mnt/sdcard/jclwjcz/config-ajlw.xml")) {
			dialog("初始化系统成功!", new DefautDialog.OnClickListener() {
				@Override
				public void onClick(DefautDialog dialog, View view) {
					dialog.dimiss();
					Intent itt = new Intent();
					itt.setClass(Init_Activity.this, Login_Activity.class);
					startActivity(itt);
					Init_Activity.this.finish();
				}
			});
		} else {
			dialog("初始化系统失败，请重试!", null);
		}
	}

	/**
	 * 监听平板返回按键按下事件
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == 4) {
			if (Md_Car_Temp.getTempCar().fromLoginToInit.equals("yes")) {
				Intent itt = new Intent();
				itt.setClass(Init_Activity.this, Login_Activity.class);
				startActivity(itt);
				Init_Activity.this.finish();
			} else {
				Application_Activity.getApplication_Exit().Exit(1);
			}
		}
		return false;
	}

	protected void dialog(String msg, DefautDialog.OnClickListener action) {
		DefautDialog.showDialog(Init_Activity.this, Init_Activity.this
				.getResources().getString(R.string.SYS_TITLE), msg, true,
				action, null);
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
	}
}

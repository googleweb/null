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
 * ��ʼ��ϵͳ����
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

	private String dp = "����";
	private String sfhj = "��";
	private String sfzj = "��";
	private String sfgxjyxm = "��";
	private String sfdtdp = "��";
	private String sfsign = "��";
	private String sfchose = "��";
	private String siglelogin="��";
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
	 * "������ǰ��б��45����Ƭ,�����Һ�б��45����Ƭ,����ʶ�������Ƭ,�����ڲ���Ƭ,�������Ƭ,Ӧ������Ƭ," +
	 * "��ʻ��¼װ����Ƭ,�������Ż����Ա�ǩ,У��ͣ��ָʾ��־����Ƭ,������,У����־����Ƭ,�����ƶ�װ��,���������Զ����װ��," +
	 * "ǰ����ʽ�ƶ���,�������ƶ�װ���Լ�״̬��,�м������ݸ���װ��,��ǰ��̥����ͺ�,У�������̿ͳ��ĳ�����¼����ϵͳ," +
	 * "У���ĸ�������װ��,���������ƶ�̤��,��ǰ��̥����ͺ�,�����̥����ͺ�,�Һ���̥����ͺ�,��ʻ������������ȫ��," +
	 * "����������Ƭ,У�����ƣ�ǰ��������Ƭ,У�����ƣ�ǰ��������Ƭ,У�����ƣ���������Ƭ,Σ�ջ������䳵��־,��������ʻ֤," +
	 * "��������֤�����,��������ͨ�¹�����ǿ�Ʊ���ƾ֤,��������ȫ�������鱨�浥,�����������¼��,����˰��˰������˰֤��," +
	 * "ί�к˷�����ϸ��־֪ͨ��,��������Ȩ��,�������������������ϸ�֤�͵��̺ϸ�֤,·�Լ����¼��,��ƹ⹤λ��Ƭ,һ���ƶ���λ��Ƭ," +
	 * "���̼�����Ƭ,·���г��ƶ���ʼ��Ƭ,���̶�̬���������Ƭ,·���г��ƶ�������Ƭ,���̶�̬���鿪ʼ��Ƭ,·���¶�פ���ƶ���Ƭ," +
	 * "���ٱ�λ��Ƭ,�����ƶ���λ��Ƭ,�����ƶ���λ��Ƭ,�����ƶ���λ��Ƭ,פ���ƶ���λ��Ƭ,�ҵƹ⹤λ��Ƭ,�໬��λ��Ƭ," +
	 * "�����ƶ���λ��Ƭ,�����ƶ���λ��Ƭ";
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.system_init);
		init();
	}

	/**
	 * ��ʼ������
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
			if (Md_system.getSfdtdp().equals("��")) {
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
			if (Md_system.getSfSign().equals("��")) {
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
			if (Md_system.getSiglelogin().equals("��")) {
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
			if (Md_system.getSfchose().equals("��")) {
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
			if (Md_system.getSfgxjyxm().equals("��")) {
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
		/**�ۼ�**/
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
			if (Md_system.getSfzj().equals("��")) {
				sfzj_sp.setSelection(1);
			} else {
				sfzj_sp.setSelection(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (Md_system.getSfhj().equals("��")) {
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
			if (Md_system.dq.equals("����")) {
				dp_sp.setSelection(0);
			} else if (Md_system.dq.equals("�㶫")) {
				dp_sp.setSelection(1);
			} else if (Md_system.dq.equals("�Ĵ�")) {
				dp_sp.setSelection(2);
			} else if (Md_system.dq.equals("����")) {
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
						dialog("����д����IP�ͼ���������!", null);
					} else {
						initConfig(strIp, strJyjgbh);
					}
				} catch (Exception e) {
					dialog("��ʼ��ϵͳʧ�ܣ�������!", null);
				}

			}
		});
	}
/**
 * ����ȡ�������ݷ�װ��xml��ʽд�뵽�����ļ�����
 * @param strIp IP����
 * @param strJyjgbh �������
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
			dialog("��ʼ��ϵͳ�ɹ�!", new DefautDialog.OnClickListener() {
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
			dialog("��ʼ��ϵͳʧ�ܣ�������!", null);
		}
	}

	/**
	 * ����ƽ�巵�ذ��������¼�
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

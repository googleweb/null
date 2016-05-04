package scxd.jcz.ajlw.android.Activity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Activity.Common.FileUtil;
import scxd.jcz.ajlw.android.Activity.Common.PromptUtils;
import scxd.jcz.ajlw.android.Adapter.Carggpc_Adapter;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.InfoItem;
import scxd.jcz.ajlw.android.model.InfoItemEdt;
import scxd.jcz.ajlw.android.model.InfoItemSp;
import scxd.jcz.ajlw.android.model.ItemLayout;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * ������Ŀ���ԭ�����������빦������û�����˿�����鿴GGXX_ListActivity��
 * 
 * 
 * ����ȶ���Ŀ
 * @author Administrator
 *@time
 */
public class GGBD_Activity extends BaseActivity implements OnClickListener {
	private ItemLayout GGInfoModel;
	private Button ggxxcx;
	private Button ggzpcx;
	private Button cldl;
	private Button dpggxxcx;

	private InfoItem bh;
	private InfoItem clpp1;
	private InfoItem clpp2;
	private InfoItem clxh;
	private InfoItem dpid;
	private InfoItem zpbh;
	private InfoItem zs;
	private InfoItem zzl;
	private InfoItem zbzl;
	private InfoItem cwkk;
	private InfoItem cwkc;
	private InfoItem cwkg;
	private InfoItem ltgg;
	private InfoItem sbdhxl;
	private InfoItem dpzs;

	Map<String, Object> requestMap = null;
	Map<String, Object> requesGGXXMap = null;
	Map<String, Object> requesGGZPMap = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_ggbd);
		init();
	}
/**
 * ��ʼ���ؼ������ü���
 */
	private void init() {
		this.GGInfoModel = (ItemLayout) findViewById(R.id.ggxx_itemlayout);
		this.ggxxcx = (Button) findViewById(R.id.ggxxcx);
		this.ggzpcx = (Button) findViewById(R.id.ggzpcx);
		this.cldl = (Button) findViewById(R.id.cldl);
		this.dpggxxcx = (Button) findViewById(R.id.dpggxxcx);
		this.ggxxcx.setOnClickListener(this);
		this.ggzpcx.setOnClickListener(this);
		this.cldl.setOnClickListener(this);
		this.dpggxxcx.setOnClickListener(this);
		this.initItems();
		this.GGInfoModel.setShow(2, true);
	}
/**
 * ��ʼ���ؼ�������ؼ�
 */
	private void initItems() {
		/**
		 * ��Ŀ �������� [1]:�ı� [2]:������ [2|8192]:���� ^[A-Za-z0-9]{6}$ [\u4e00-\u9fa5]+
		 * 
		 * ���������漼������������Ϣ
		 */

		this.GGInfoModel.initItemBars(new String[] { "����ͼƬ��Ϣ", "���������Ϣ",
				"����������Ϣ" });
		this.bh = new InfoItemEdt(this, "����������*", null, "bh", 1, null,
				false);
		this.clpp1 = new InfoItemEdt(this, "Ʒ��(����)*", null, "clpp1", 1, null,
				false);
		this.clxh = new InfoItemEdt(this, "�����ͺ�*", null, "clxh", 1, null, false);
		this.zpbh = new InfoItemEdt(this, "��Ƭ���*", null, "zpbh",1,
				null, false);
		this.clpp2 = new InfoItemEdt(this, "Ʒ��(Ӣ��)*", null, "clpp2",1,
				null, false);
		this.zs = new InfoItemEdt(this, "����*", null, "zs", 1, null,
				false);
		this.zzl = new InfoItemEdt(this, "������*", " kg", "zzl", 1,
				"^[0-9\\.]{1,5}$", false);
		this.zbzl = new InfoItemEdt(this, "��������*", " kg", "0", "zbzl",
				1, "^[0-9\\.]{1,5}$", false);
		this.cwkk = new InfoItemEdt(this, "��������*", " mm", "cwkk", 1,
				null, false);
		this.cwkc = new InfoItemEdt(this, "��������*", " mm", "cwkc", 1,
				null, false);
		this.cwkg = new InfoItemEdt(this, "��������*", " mm", "cwkg", 1,
				null, false);
		this.dpid = new InfoItemEdt(this, "����ID", null, "dpid", 1, null,
				false);
		this.ltgg = new InfoItemEdt(this, "��̥���", null, "ltgg", 1, null,
				false);
		this.sbdhxl = new InfoItemEdt(this, "ʶ���������", null, "sbdhxl", 1,
				null, false);
		this.dpzs = new InfoItemEdt(this, "����", null, "dpzs", 1, null,
				false);
		this.GGInfoModel.addItem(2, clpp1);
		this.GGInfoModel.addItem(2, clxh);
		this.GGInfoModel.addItem(2, dpid);
		this.GGInfoModel.addItem(2, bh);
		this.GGInfoModel.addItem(2, clpp2);
		this.GGInfoModel.addItem(2, zs);
		this.GGInfoModel.addItem(2, zzl);
		this.GGInfoModel.addItem(2, zbzl);
		this.GGInfoModel.addItem(2, cwkk);
		this.GGInfoModel.addItem(2, cwkc);
		this.GGInfoModel.addItem(2, cwkg);
		this.GGInfoModel.addItem(2, ltgg);
		this.GGInfoModel.addItem(2, sbdhxl);
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��ҵID", null, "qyid",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "������ַ", null, "scdz",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�������ͺ�", null,
				"fdjxh", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��������", null, "cllx",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�����", null, "zzg",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "ת����ʽ", null, "zxxs",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "ȼ������", null, "rlzl",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "����", null, "pl",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "����", null, "gl",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�����ڲ�����", "mm",
				"hxnbcd", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�����ڲ����", "mm",
				"hxnbkd", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�����ڲ��߶�", "mm",
				"hxnbgd", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�ְ嵯��Ƭ��", "Ƭ",
				"gbthps", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "���", null, "zj",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "ǰ�־�", null, "qlj",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "���־�", null, "hlj",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��̥��", null, "lts",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�������", null,
				"hdzzl", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "׼ǣ��������", null,
				"zqyzl", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��ؿ�", null, "hdzk",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��ʻ��ǰ������", null,
				"qpzk", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��ʻ�Һ�������", null,
				"hpzk", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "����", null, "pc",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "����������", null,
				"hbdbqk", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "���淢������", null,
				"cslx", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��������", null, "gxrq",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��ע", null, "bz",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "����������ҵ", null,
				"zzcmc", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "���淢������", null,
				"ggrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�����", null, "sfmj",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "������Ч����", null,
				"cxsxrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "������ҵ���ͺ�", null,
				"dpqyxh", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��Ʒ���", null, "cplb",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "���͹�����", null,
				"clggbh", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�Ƿ�����ע��", null,
				"sfyxzc", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "������Ч����", null,
				"ggsxrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "������Ч�ڱ��", null,
				"ggyxqbj", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "������������", null,
				"cxggpc", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�������淢������", null,
				"cxggrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "ֹͣ��������", null,
				"tzscrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��Ч������", null,
				"yxqms", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��Ƭ��", null, "zps",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�����Ч��ֹ", null,
				"mjyxqz", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�����ʶ�ͺ�", null,
				"fgbsxh", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�����ʶ�̱�", null,
				"fgbssb", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�����ʶ��ҵ", null,
				"fgbsqy", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "���", null, "zh",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "����������ϵ��", null,
				"zzllyxs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��Ұ����������������", null,
				"bgazzdyxzzl", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�ӽ���ȥ��", null,
				"jjlqj", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "ǰ������", null, "qxhx",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��ʻ������", null,
				"jsslx", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "������ʽ", null, "cdxs",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��߳���", null, "zgcs",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�ͺ�", null, "yh",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "ǰ�ƶ���ʽ", null,
				"qzdfs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "���ƶ���ʽ", null,
				"hzdfs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "ǰ�ƶ�������ʽ", null,
				"qzdczfs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "���ƶ�������ʽ", null,
				"hzdczfs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��������ҵ", null,
				"fdjqy", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�������̱�", null,
				"fdjsb", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "�Ƿ��������ϵͳ", null,
				"ywabs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��������", null, "clmc",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "��ҵ����", null, "qydm",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "������", null, "ggbj",
				1, null, false));

		/** ������Ϣ **/
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "���̹�����", null,
				"dpbh", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "����ID", null,
				"dpdpid", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��ҵID", null,
				"dpqyid", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������ַ", null,
				"dpscdz", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "�����ͺ�", null,
				"dpdpxh", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "�������", null,
				"dpdplb", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��Ʒ����", null,
				"dpcpmc", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��Ʒ�̱�", null,
				"dpcpsb", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������", null, "dpc",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������", null, "dpk",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������", null, "dpg",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "ȼ������", null,
				"dprlzl", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "���ݱ�׼", null,
				"dpyjbz", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "ת����ʽ", null,
				"dpzxxs", 1, null, false));
		this.GGInfoModel.addItem(1, this.dpzs);
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "���", null, "dpzj",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "�ְ嵯��Ƭ��", null,
				"dpgbthps", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��̥��", null, "dplts",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��̥���", null,
				"dpltgg", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "ǰ�־�", null, "dpqlj",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "���־�", null, "dphlj",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������", null, "dpzzl",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��������", null,
				"dpzbzl", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "׼ǣ��������", null,
				"dpzqyzl", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "�������ͺ�", null,
				"dpfdjxh", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "����", null, "dppl",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "����", null, "dpgl",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "ʶ���������", null,
				"dpsbdh", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "����", null, "dppc",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "���淢������", null,
				"dpcslx", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��������", null,
				"dpgxrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��ע", null, "dpbz",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "����������ҵ", null,
				"dpzzcmc", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "���淢������", null,
				"dpggrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������Ч����", null,
				"dpcxsxrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��ʻ��ǰ������", null,
				"dpqpzk", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��ʻ�Һ�������", null,
				"dphpzk", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������Ч����", null,
				"dpggsxrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������Ч�ڱ��", null,
				"dpggyxqbj", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������������", null,
				"dpcxggpc", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "�������淢������", null,
				"dpcxggrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "ֹͣ��������", null,
				"dptzscrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��Ч������", null,
				"dpyxqms", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��������ҵ", null,
				"dpfdjqy", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "�������̱�", null,
				"dpfdjsb", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "�ӽ���ȥ��", null,
				"dpjjlqj", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "ǰ������", null,
				"dpqxhx", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "���", null, "dpzh",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��߳���", null,
				"dpzgcs", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "�Ƿ��������ϵͳ", null,
				"dpywabs", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "��ҵ����", null,
				"dpqydm", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "������", null,
				"dpggbj", 1, null, false));
		/** ͼƬ��Ϣ **/
		this.GGInfoModel.addItem(0, zpbh);
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "����������", null,
				"zpbh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���͹�����", null,
				"zpclggbh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "˳���", null, "zpsxh",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "����", null, "zppc",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���淢������", null,
				"zpggrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��������", null,
				"zpgxrq", 1, null, false));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ggxxcx:
			queryZCGGXX();
			break;
		case R.id.ggzpcx:
			queryGGZP();
			// showGGZP("");
			break;
		case R.id.cldl:
			toCarLogin();
			break;
		case R.id.dpggxxcx:
			queryDPGGXX();
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return true;
	}

	/**
	 * 01.Map<String, String[]> map; 02.Bundle bundle = new Bundle();
	 * 03.Set<String> keySet = map.keySet(); 04.Iterator<String> iter =
	 * keySet.iterator(); 05.while(iter.hasNext()) 06.{ 07. String key =
	 * iter.next(); 08. bundle.putStringArray(key, map.get(key)); 09.}
	 * 10.intent.putExtra("map", bundle);
	 * 
	 * 01.Map<String, String[]> map; 02.Bundle bundle =
	 * intent.getBundleExtra("map"); 03.Set<String> keySet = bundle.keySet(); //
	 * �õ�bundle�����е�key 04.Iterator<String> iter = keySet.iterator();
	 * 05.while(iter.hasNext()) 06.{ 07. String key = iter.next(); 08.
	 * map.put(key, bundle.getStringArray(key)); 09.}
	 */
	// ��¼��ת
	/**
	 * ������¼��ת
	 */
	private void toCarLogin() {
		Intent intent = new Intent(GGBD_Activity.this, CarLoginActivity.class);
		Md_Car_Temp.getTempCar().isFromGGBD = true;
		Bundle bundle = new Bundle();
		bundle.putString("clpp1", clpp1.getData());
		if (!zs.getData().equals("")) {
			bundle.putString("zs", zs.getData());
		} else {
			bundle.putString("zs", dpzs.getData());
		}
		bundle.putString("zzl", zzl.getData());
		bundle.putString("zbzl", zbzl.getData());
		bundle.putString("cwkk", cwkk.getData());
		bundle.putString("cwkc", cwkc.getData());
		bundle.putString("cwkg", cwkg.getData());
		bundle.putString("clxh", clxh.getData());
		bundle.putString("ltgg", ltgg.getData());
		bundle.putString("clsbdh", sbdhxl.getData());
		intent.putExtra("map", bundle);
		this.startActivity(intent);
		this.finish();
	}

	// ������Ƭ��ѯ
	/**
	 * ������Ƭ��ѯ
	 */
	private void queryGGZP() {
		try {
			FileUtil.deleteFilesByDirectory(new File(
					"/mnt/sdcard/jclwjcz/ggimage/"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (requestMap != null) {
			requestMap = null;
		}
		if (requesGGZPMap != null) {
			requesGGZPMap = null;
		}
		if (!zpbh.getData().trim().equals("")) {
			Md_Car_Temp.getTempCar().ggcxlx = "ggzpcx";
			Md_Car_Temp.getTempCar().ggbh = bh.getData().trim();
			requestMap = new HashMap<String, Object>();
			requesGGZPMap = new HashMap<String, Object>();
			requesGGZPMap.put("zpbh", zpbh.getData().trim());
			requestMap.put("QueryCondition", requesGGZPMap);
			request("18C09", requestMap, R.string.QUERY_CAR_GGZPINFO,
					new String[] { "2" });
		} else {
			Toast.makeText(this, "��Ƭ��Ų���Ϊ�գ�", 1000).show();
			return;
		}
	}

	private String queryBH = "";

	// ������Ϣ��ѯ
	/**
	 * ������Ϣ��ѯ
	 */
	private void queryZCGGXX() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requesGGXXMap != null) {
			requesGGXXMap = null;
		}
		if (!clpp1.getData().trim().equals("")
				&& !clxh.getData().trim().equals("")) {
			Md_Car_Temp.getTempCar().ggcxlx = "zcggxxcx";
			requestMap = new HashMap<String, Object>();
			requesGGXXMap = new HashMap<String, Object>();
			requesGGXXMap.put("bh", queryBH);
			requesGGXXMap.put("clpp1", clpp1.getData().trim());
			requesGGXXMap.put("clxh", clxh.getData().trim());
			requestMap.put("QueryCondition", requesGGXXMap);
			request("18C08", requestMap, R.string.QUERY_CAR_GGINFO,
					new String[] { "2" });
		} else {
			Toast.makeText(this, "����Ʒ�ơ������ͺŲ���Ϊ�գ�", 1000).show();
			return;
		}
	}

	// ������Ϣ��ѯ
	private void queryDPGGXX() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requesGGXXMap != null) {
			requesGGXXMap = null;
		}
		if (!dpid.getData().trim().equals("")) {
			Md_Car_Temp.getTempCar().ggcxlx = "dpggxxcx";
			requestMap = new HashMap<String, Object>();
			requesGGXXMap = new HashMap<String, Object>();
			requesGGXXMap.put("bh", queryBH);
			requesGGXXMap.put("dpid", dpid.getData().trim());
			requestMap.put("QueryCondition", requesGGXXMap);
			request("18C08", requestMap, R.string.QUERY_CAR_DPGGINFO,
					new String[] { "2" });
		} else {
			Toast.makeText(this, "����ID����Ϊ�գ�", 1000).show();
			return;
		}
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try{
		if ("18C08".equals(jkid)) {//������û���õ�
			ArrayList<Map<String, String>> responseMap = (ArrayList<Map<String, String>>) result;
			if (responseMap.size() != 0) {
				showGGXXPCLB(responseMap);
			} else {
				Toast.makeText(GGBD_Activity.this, "û�в�ѯ��������Ϣ��", 1000).show();
			}
		} else if ("18C09".equals(jkid)) {
			Map<String, Object> responseMap = (Map<String, Object>) result;
			if (!responseMap.get("code").equals("0")) {
				showGGZP((String) responseMap.get("zpbh"));
			} else {
				Toast.makeText(GGBD_Activity.this, "û�в�ѯ��������Ƭ��", 1000).show();
			}
		}
		}catch (Exception e) {
			DefautDialog.showDialog(GGBD_Activity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	private ArrayList<Map<String, String>> data = null;
/**
 * ��ʾ������Ϣ
 * @param responseMap
 */
	private void showGGXXPCLB(ArrayList<Map<String, String>> responseMap) {
		try {
			if (responseMap == null || responseMap.size() == 0) {
				Toast.makeText(GGBD_Activity.this, "û�в�ѯ��������Ϣ��", 1000).show();
				return;
			}
			data = responseMap;
			responseMap = null;
			View popView = LayoutInflater.from(this).inflate(
					R.layout.choice_zcggpc, null);
			ListView ggpc_listview = (ListView) popView
					.findViewById(R.id.car_ggpc);
			Carggpc_Adapter adapter = new Carggpc_Adapter(GGBD_Activity.this,
					data);
			ggpc_listview.setAdapter(adapter);
			ggpc_listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					PromptUtils.closeAlertDialog();
					Map<String, String> hm = data.get(position);
					GGInfoModel.setItemsData(hm);
					if (Md_Car_Temp.getTempCar().ggcxlx.equals("zcggxxcx")) {
						GGInfoModel.setShow(2, true);
						GGInfoModel.setShow(1, false);
						GGInfoModel.setShow(0, false);
					} else if (Md_Car_Temp.getTempCar().ggcxlx
							.equals("dpggxxcx")) {
						GGInfoModel.setShow(2, false);
						GGInfoModel.setShow(1, true);
						GGInfoModel.setShow(0, false);
					}
				}
			});
			PromptUtils.showAlertDialog(this, R.drawable.query_dialog_icon,
					"��ʾ��", popView, "��ѡ�����Σ�", "��  ��",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							PromptUtils.closeAlertDialog();
						}
					});
		} catch (Exception e) {
			Toast.makeText(GGBD_Activity.this, "û�в�ѯ��������Ϣ��", 1000).show();
		}
	}

	private String[] zpbhs = null;
	private int surI = 0;
/**
 * ��ʾ������Ƭ
 * @param zpbh
 */
	private void showGGZP(String zpbh) {
		try {
			// zpbh = "11,12,13,14,15";
			if (zpbh.equals("")) {
				Toast.makeText(GGBD_Activity.this, "û�в�ѯ��������Ƭ��", 1000).show();
				return;
			}
			surI = 0;
			zpbhs = zpbh.split(",");
			zpbh = "";
			View popView = LayoutInflater.from(this).inflate(
					R.layout.ggzp_layout, null);
			final ImageView imageView = (ImageView) popView
					.findViewById(R.id.imgvCamera);
			TextView txtCameraImgv = (TextView) popView
					.findViewById(R.id.txtCameraImgv);
			Button btn_left = (Button) popView.findViewById(R.id.btn_left);
			Button btn_right = (Button) popView.findViewById(R.id.btn_right);
			btn_left.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if (surI >= 1) {
						surI = surI - 1;
						imageView
								.setImageBitmap(getBitmap(getImagePath(zpbhs[surI])));
					} else {
						Toast.makeText(GGBD_Activity.this, "����һ����Ƭ�ˣ�", 1000)
								.show();
					}
				}
			});
			btn_right.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if (surI < (zpbhs.length - 1)) {
						surI++;
						imageView
								.setImageBitmap(getBitmap(getImagePath(zpbhs[surI])));
					} else {
						Toast.makeText(GGBD_Activity.this, "����һ����Ƭ�ˣ�", 1000)
								.show();
					}
				}
			});
			txtCameraImgv.setVisibility(View.GONE);
			imageView.setVisibility(View.VISIBLE);
			imageView.setImageBitmap(getBitmap(getImagePath(zpbhs[surI])));
			PromptUtils.showAlertDialog(this, R.drawable.query_dialog_icon,
					"��ʾ��", popView, "������Ƭ��", "��  ��",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							PromptUtils.closeAlertDialog();
						}
					});
		} catch (Exception e) {
			Toast.makeText(GGBD_Activity.this, "û�в�ѯ��������Ƭ��", 1000).show();
		}
	}
/**
 * ��ȡͼƬ�ڱ���·��
 * @param zpbh ��Ƭ���
 * @return ·��
 */
	private String getImagePath(String zpbh) {
		return "/mnt/sdcard/jclwjcz/ggimage/" + Md_Car_Temp.getTempCar().ggbh
				+ "/" + zpbh + ".png";
		// return "/mnt/sdcard/jclwjcz/ggimage/888888/" + zpbh + ".png";
	}
/**
 * ͨ����Ƭ·�����λͼ
 * @param imagePath
 * @return
 */
	private Bitmap getBitmap(String imagePath) {
		Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
		return bitmap;
	}
}

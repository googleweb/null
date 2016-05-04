package scxd.jcz.ajlw.android.Activity;

import java.util.HashMap;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.InfoItem;
import scxd.jcz.ajlw.android.model.InfoItemEdt;
import scxd.jcz.ajlw.android.model.ItemLayout;
import scxd.jcz.ajlw.android.model.MapBeanWDL;
import scxd.jcz.ajlw.android.model.Md_system;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
/**
 * ����ȶԽ���
 * @author CXY
 *
 */
public class GGDetailActivity extends BaseActivity {

	MapBeanWDL mapBean=null;
	private ItemLayout GGInfoModel;
	private ItemLayout loginModel;
	private Button back;
	private LinearLayout  linearGGXX; //������Ϣ
	private LinearLayout  linearbaseXX; //������Ϣ
	private LinearLayout progressBar;
    private RadioButton radioBasexx;//C܇�v��Ϣ
    private RadioButton radioGGXX;//������Ϣ
	
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
	Map<String, Object> requesCarLogintMap = null;
	private Handler handler=null; 
	HashMap<String, String> hm=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ggdetail);
		findView();
		init();
		
		
		
	}

	private void findView() {
		this.GGInfoModel = (ItemLayout) findViewById(R.id.ggxx_itemlayout);
		this.loginModel = (ItemLayout) findViewById(R.id.carLogin_onlineLayout);
		linearGGXX=(LinearLayout) findViewById(R.id.gongaoxx); 
		linearbaseXX=(LinearLayout) findViewById(R.id.basexx);
		radioBasexx=(RadioButton) findViewById(R.id.radiobasexx);
		radioGGXX=(RadioButton) findViewById(R.id.radioggxx);
		progressBar=(LinearLayout) findViewById(R.id.progressbar);
		back=(Button) findViewById(R.id.back);
		
		
	
	}
	private void init() {
		
		Bundle b=getIntent().getExtras();
		mapBean=(MapBeanWDL) b.getSerializable("BEAN");
		linearGGXX.setVisibility(View.VISIBLE);
		linearbaseXX.setVisibility(View.GONE);
		radioBasexx.setOnClickListener(radioClick);
		radioGGXX.setOnClickListener(radioClick);
		progressBar.setVisibility(View.GONE);
		handler=new Handler();  
		back.setOnClickListener(Click);
	}

	private View.OnClickListener Click=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {

         openActivity(GGXX_ListActivity.class);
         finish();
		}
	};
	
	private View.OnClickListener radioClick=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			 boolean checked = ((RadioButton) v).isChecked();
			switch (v.getId()) {
			case R.id.radioggxx:
				if(checked)
				{
					linearGGXX.setVisibility(View.VISIBLE);
					linearbaseXX.setVisibility(View.GONE);
				}
				
				break;

			case R.id.radiobasexx:
				if(checked)
				{
					linearGGXX.setVisibility(View.GONE);
					linearbaseXX.setVisibility(View.VISIBLE);
				}
				break;
			}
		}
	};
	
	private void initItemsGG() {
		/**
		 * ��Ŀ �������� [1]:�ı� [2]:������ [2|8192]:���� ^[A-Za-z0-9]{6}$ [\u4e00-\u9fa5]+
		 * 
		 * ���������漼������������Ϣ
		 */

		this.GGInfoModel.initItemBars(new String[] {"����������Ϣ" });
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
		this.GGInfoModel.addItem(0, clpp1);
		this.GGInfoModel.addItem(0, clxh);
		this.GGInfoModel.addItem(0, dpid);
		this.GGInfoModel.addItem(0, bh);
		this.GGInfoModel.addItem(0, clpp2);
		this.GGInfoModel.addItem(0, zs);
		this.GGInfoModel.addItem(0, zzl);
		this.GGInfoModel.addItem(0, zbzl);
		this.GGInfoModel.addItem(0, cwkk);
		this.GGInfoModel.addItem(0, cwkc);
		this.GGInfoModel.addItem(0, cwkg);
		this.GGInfoModel.addItem(0, ltgg);
		this.GGInfoModel.addItem(0, sbdhxl);
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��ҵID", null, "qyid",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "������ַ", null, "scdz",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�������ͺ�", null,
				"fdjxh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��������", null, "cllx",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�����", null, "zzg",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "ת����ʽ", null, "zxxs",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "ȼ������", null, "rlzl",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "����", null, "pl",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "����", null, "gl",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�����ڲ�����", "mm",
				"hxnbcd", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�����ڲ����", "mm",
				"hxnbkd", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�����ڲ��߶�", "mm",
				"hxnbgd", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�ְ嵯��Ƭ��", "Ƭ",
				"gbthps", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���", null, "zj",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "ǰ�־�", null, "qlj",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���־�", null, "hlj",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��̥��", null, "lts",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�������", null,
				"hdzzl", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "׼ǣ��������", null,
				"zqyzl", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��ؿ�", null, "hdzk",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��ʻ��ǰ������", null,
				"qpzk", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��ʻ�Һ�������", null,
				"hpzk", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "����", null, "pc",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "����������", null,
				"hbdbqk", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���淢������", null,
				"cslx", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��������", null, "gxrq",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��ע", null, "bz",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "����������ҵ", null,
				"zzcmc", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���淢������", null,
				"ggrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�����", null, "sfmj",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "������Ч����", null,
				"cxsxrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "������ҵ���ͺ�", null,
				"dpqyxh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��Ʒ���", null, "cplb",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���͹�����", null,
				"clggbh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�Ƿ�����ע��", null,
				"sfyxzc", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "������Ч����", null,
				"ggsxrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "������Ч�ڱ��", null,
				"ggyxqbj", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "������������", null,
				"cxggpc", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�������淢������", null,
				"cxggrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "ֹͣ��������", null,
				"tzscrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��Ч������", null,
				"yxqms", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��Ƭ��", null, "zps",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�����Ч��ֹ", null,
				"mjyxqz", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�����ʶ�ͺ�", null,
				"fgbsxh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�����ʶ�̱�", null,
				"fgbssb", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�����ʶ��ҵ", null,
				"fgbsqy", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���", null, "zh",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "����������ϵ��", null,
				"zzllyxs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��Ұ����������������", null,
				"bgazzdyxzzl", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�ӽ���ȥ��", null,
				"jjlqj", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "ǰ������", null, "qxhx",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��ʻ������", null,
				"jsslx", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "������ʽ", null, "cdxs",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��߳���", null, "zgcs",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�ͺ�", null, "yh",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "ǰ�ƶ���ʽ", null,
				"qzdfs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���ƶ���ʽ", null,
				"hzdfs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "ǰ�ƶ�������ʽ", null,
				"qzdczfs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "���ƶ�������ʽ", null,
				"hzdczfs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��������ҵ", null,
				"fdjqy", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�������̱�", null,
				"fdjsb", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "�Ƿ��������ϵͳ", null,
				"ywabs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��������", null, "clmc",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "��ҵ����", null, "qydm",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "������", null, "ggbj",
				1, null, false));

	}

	@Override
	protected void onStart() {
		super.onStart();
		GGDetailActivity.this.request("18C49",mapData(),
				R.string.QUERY_CAR_BASICINFO,
				new String[] { "2" });
	}

	private  Map<String,Object> mapData()
	{
		
		if (requestMap != null) {
			requestMap = null;
		}
		if (requesCarLogintMap != null) {
			requesCarLogintMap = null;
		}
		requestMap = new HashMap<String, Object>();
		requesCarLogintMap = new HashMap<String, Object>();
		requesCarLogintMap.put("hphm", Md_Car_Temp.car_hphm);
		requesCarLogintMap.put("hpzl", Md_Car_Temp.car_hpzl);
		requesCarLogintMap.put("clsbdh", Md_Car_Temp.car_vin);
		requesCarLogintMap.put("jyjgbh",
				Md_system.getDzkey());
		requestMap
				.put("QueryCondition", requesCarLogintMap);
		return requestMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onRequestSuccess(String jkid, Object result) {
		progressBar.setVisibility(View.VISIBLE);
		if ("18C49".equals(jkid)) {
		hm = (HashMap<String, String>) result;
			new Thread(){
				              public void run(){    
				                  handler.post(runnableUi);   
				                  }                     
				          }.start();            


	     }
	}
	
	private void initItems() {
		/**
		 * ��Ŀ �������� [1]:�ı� [2]:������ [2|8192]:���� ^[A-Za-z0-9]{6}$ [\u4e00-\u9fa5]+
		 */
		InfoItem csys,syr,zxzxjxs, qdxs, zczw, zs, jcxlb, qzdz, ygddtz, ccrq, clpp1, cwkk, cwkc, cwkg, hxnbcd, hxnbkd, hxnbgd, zzl, zbzl, ltgg, lcbds, fzjg, dlysfzh;
		/** ����������Ϣ **/
		InfoItem rlzl, hdzk, zzs, zzly, xh, sjr, sjrsfzh, ytsx, fdjh, jyhgbzbh, hdzzl, zj, qlj, hlj, ccdjrq, yxqz, bxzzrq;
		// ����������Ϣ��
		InfoItem gbthps, lts, glbm, zzg, fdjxh, gcjk, sfzmhm, hbdbqk, xszbh, qpzk, hpzk, sfzmmc, clpp2, zqyzl, zzcmc, zxxs, djrq, qzbfqz, dybj;
	
		
		
		syr = new InfoItemEdt(this, "������������", null, "syr", 1, null, false);
		csys = new InfoItemEdt(GGDetailActivity.this, "������ɫ", null, "csys", 1,
				null, false);
		zxzxjxs = new InfoItemEdt(this, "������ʽ",null, "zxzxjxs",2 | 8192,null, false);
		// ��������ʽ�����Ϊ�����ᣬ��ɲ�ᡣ�����������ֳ�Ħ�г�
		qdxs =new InfoItemEdt(this, "������",null, "qdxs",2 | 8192,null, false);
		zczw=new InfoItemEdt(this, "��ɲ��",null, "zczw",2 | 8192,null, false);
		zs=new InfoItemEdt(this, "����",null, "zs",2 | 8192,null, false);
		jcxlb=new InfoItemEdt(this, "��������",null, "jcxlb",2 | 8192,null, false);
		qzdz=new InfoItemEdt(this, "ǰ�յ���",null, "qzdz",2 | 8192,null, false);
		ygddtz=new InfoItemEdt(this, "Զ�ⵥ������",null, "ygddtz",2 | 8192,null, false);
		ccrq=new InfoItemEdt(this, "��������",null, "ccrq",2 | 8192,null, false);
		clpp1 = new InfoItemEdt(this, "����Ʒ��*", null, "clpp1", 1, null, false);
		cwkk = new InfoItemEdt(this, "��������*", " mm", "cwkk", 2 | 8192, null,
				false);
		cwkc = new InfoItemEdt(this, "��������*", " mm", "cwkc", 2 | 8192, null,
				false);
		cwkg = new InfoItemEdt(this, "��������*", " mm", "cwkg", 2 | 8192, null,
				false);
		hxnbcd = new InfoItemEdt(this, "�����ڲ�����", " mm", "hxnbcd", 2 | 8192,
				null, false);
		hxnbkd = new InfoItemEdt(this, "�����ڲ����", " mm", "hxnbkd", 2 | 8192,
				null, false);
		hxnbgd = new InfoItemEdt(this, "�����ڲ��߶�", " mm", "hxnbgd", 2 | 8192,
				null, false);
		zzl = new InfoItemEdt(this, "������*", " kg", "zzl", 2 | 8192,
				"^[0-9\\.]{1,5}$", false);
		zbzl = new InfoItemEdt(this, "��������*", " kg", "0", "zbzl", 2 | 8192,
				"^[0-9\\.]{1,5}$", false);
		ltgg = new InfoItemEdt(this, "��̥���", null, "ltgg", 1, null, true);
		lcbds = new InfoItemEdt(this, "��̱���#", "km", "lcbds", 2,
				"^[0-9]{1,9}$", false);
		fzjg = new InfoItemEdt(this, "��֤����*", null, "fzjg", 1, null, false);
		
		rlzl=new InfoItemEdt(this, "ȼ������", null, "rlzl", 1, null, false);
		hdzk = new InfoItemEdt(this, "�˶��ؿ�����", " ��", "hdzk", 1, "^[0-9]{1,5}$",
				true);
		zzs=new InfoItemEdt(this, "������", null, "zzs", 1, null, false);
		zzly=new InfoItemEdt(this, "�ƶ���Դ", null, "zzly", 1, null, false);
		xh = new InfoItemEdt(this, "���������", null, "xh", 1, null, true);
		ytsx = new InfoItemEdt(this, "��;����", null, "ytsx", 1, null, true);
		fdjh = new InfoItemEdt(this, "��������", null, "fdjh", 1, null, true);
		jyhgbzbh = new InfoItemEdt(this, "����ϸ��־", null, "jyhgbzbh", 1, null,
				true);
		hdzzl = new InfoItemEdt(this, "�˶�������", "  kg ", "hdzzl", 2 | 8192,
				"^[0-9\\.]{1,6}$", true);
		zj = new InfoItemEdt(this, "��൥λ", " mm", "zj", 2 | 8192, null, true);
		qlj = new InfoItemEdt(this, "ǰ�־൥λ", " mm", "qlj", 2 | 8192, null, true);
		hlj = new InfoItemEdt(this, "���־൥λ", " mm", "hlj", 2 | 8192, null, true);
		ccdjrq=new InfoItemEdt(this, "���εǼ�����", null, "ccdjrq", 2 | 8192, null, false);
		yxqz=new InfoItemEdt(this, "������Ч��ֹ", null, "yxqz", 2 | 8192, null, false);
		bxzzrq=new InfoItemEdt(this, "������ֹ����", null, "bxzzrq", 2 | 8192, null, false);
		gbthps = new InfoItemEdt(this, "�ְ嵯��Ƭ��", " Ƭ", "gbthps", 2 | 8192,
				null, true);
		lts = new InfoItemEdt(this, "��̥��", " ��", "lts", 2 | 8192, null, true);
		glbm = new InfoItemEdt(this, "������", null, "glbm", 1, null, true);
		zzg = new InfoItemEdt(this, "�����", null, "zzg", 1, null, true);
		fdjxh = new InfoItemEdt(this, "�������ͺ�", null, "fdjxh", 1, null, true);
		gcjk = new InfoItemEdt(this, "����/����", null, "gcjk", 1, null, true);
		sfzmhm = new InfoItemEdt(this, "���֤������", null, "sfzmhm", 1, null, true);
		hbdbqk = new InfoItemEdt(this, "����������", null, "hbdbqk", 1, null, true);
		xszbh = new InfoItemEdt(this, "��ʻ֤֤о���", null, "xszbh", 1, null, true);
		qpzk = new InfoItemEdt(this, "ǰ���ؿ�����", " ��", "qpzk", 2 | 8192,
				"^[0-9]{1,5}$", true);
		hpzk = new InfoItemEdt(this, "�����ؿ�����", " ��", "hpzk", 2 | 8192,
				"^[0-9]{1,5}$", true);
		sfzmmc = new InfoItemEdt(this, "���֤������", null, "sfzmmc", 1, null, true);
		clpp2 = new InfoItemEdt(this, "Ӣ��Ʒ��", null, "clpp2", 1, null, true);
		zqyzl = new InfoItemEdt(this, "׼ǣ��������", " kg", "zqyzl", 2 | 8192, null,
				true);
		zzcmc = new InfoItemEdt(this, "���쳧����", null, "zzcmc", 1, null, true);
		zxxs = new InfoItemEdt(this, "ת����ʽ", null, "zxxs", 1, null, true);
		djrq=new InfoItemEdt(this, "�����������", null, "djrq", 1, null, true);
		qzbfqz=new InfoItemEdt(this, "ǿ�Ʊ�����ֹ", null, "qzbfqz", 1, null, true);
		dybj=new InfoItemEdt(this, "��Ѻ���", null, "dybj", 1, null, true);
		// ��ʼ����
		
					this.loginModel
							.initItemBars(new String[] {  "����������Ϣ"});
					this.loginModel.addItem(0, clpp1); // ����
					this.loginModel.addItem(0, cwkk);
					this.loginModel.addItem(0, cwkc);
					this.loginModel.addItem(0, cwkg);
					this.loginModel.addItem(0, hxnbcd);
					this.loginModel.addItem(0, hxnbkd);
					this.loginModel.addItem(0, hxnbgd);
					this.loginModel.addItem(0, zzl);
					this.loginModel.addItem(0, zbzl);
					this.loginModel.addItem(0, ltgg);
					this.loginModel.addItem(0, lcbds);
					this.loginModel.addItem(0, fzjg);
					this.loginModel.addItem(0, hdzk);
					this.loginModel.addItem(0, zzs);
					this.loginModel.addItem(0, rlzl);
					this.loginModel.addItem(0, zzly);
					this.loginModel.addItem(0, gbthps);
					this.loginModel.addItem(0, lts);
					this.loginModel.addItem(0, glbm);
					this.loginModel.addItem(0, zzg);
					this.loginModel.addItem(0, fdjxh);
					this.loginModel.addItem(0, gcjk);
					this.loginModel.addItem(0, sfzmhm);
					this.loginModel.addItem(0, hbdbqk);
					this.loginModel.addItem(0, xszbh);
					this.loginModel.addItem(0, qpzk);
					this.loginModel.addItem(0, hpzk);
					this.loginModel.addItem(0, sfzmmc);
					this.loginModel.addItem(0, clpp2);
					this.loginModel.addItem(0, zqyzl);
					this.loginModel.addItem(0, zzcmc);
					this.loginModel.addItem(0, zxxs);
					this.loginModel.addItem(0, djrq);
					this.loginModel.addItem(0, qzbfqz);
					this.loginModel.addItem(0, dybj);
					this.loginModel.addItem(0, syr);
					this.loginModel.addItem(0, csys);
					this.loginModel.addItem(0, zxzxjxs);
					this.loginModel.addItem(0, qdxs);
					this.loginModel.addItem(0, zczw);
					this.loginModel.addItem(0, zs);
					this.loginModel.addItem(0, jcxlb);
					this.loginModel.addItem(0, qzdz);
					this.loginModel.addItem(0, ygddtz);
					this.loginModel.addItem(0, ccrq);
					this.loginModel.addItem(0, xh);
					this.loginModel.addItem(0, ytsx);
					this.loginModel.addItem(0, fdjh);
					this.loginModel.addItem(0, jyhgbzbh);
					this.loginModel.addItem(0, hdzzl);
					this.loginModel.addItem(0, zj);
					this.loginModel.addItem(0, qlj);
					this.loginModel.addItem(0, hlj);
					this.loginModel.addItem(0, ccdjrq);
					this.loginModel.addItem(0, yxqz);
					this.loginModel.addItem(0, bxzzrq);
					
					
				
	}

	

	
		 Runnable   runnableUi=new  Runnable(){  
			    @Override  
			    public void run() {  
			    	
			    	initItemsGG();
					GGInfoModel.setItemsDataBD(mapBean.getWdlMap(),hm);//Map������Ϣ
					initItems();
					loginModel.setItemsDataBD(hm,mapBean.getWdlMap());
			     
					progressBar.setVisibility(View.GONE);
			    }  
			      
			};  
		
}

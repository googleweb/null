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
 * 公告比对界面
 * @author CXY
 *
 */
public class GGDetailActivity extends BaseActivity {

	MapBeanWDL mapBean=null;
	private ItemLayout GGInfoModel;
	private ItemLayout loginModel;
	private Button back;
	private LinearLayout  linearGGXX; //公告信息
	private LinearLayout  linearbaseXX; //基本信息
	private LinearLayout progressBar;
    private RadioButton radioBasexx;//C車輛信息
    private RadioButton radioGGXX;//公告信息
	
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
		 * 项目 输入限制 [1]:文本 [2]:纯数字 [2|8192]:浮点 ^[A-Za-z0-9]{6}$ [\u4e00-\u9fa5]+
		 * 
		 * 机动车公告技术参数整车信息
		 */

		this.GGInfoModel.initItemBars(new String[] {"公告整车信息" });
		this.bh = new InfoItemEdt(this, "整车公告编号*", null, "bh", 1, null,
				false);
		this.clpp1 = new InfoItemEdt(this, "品牌(中文)*", null, "clpp1", 1, null,
				false);
		this.clxh = new InfoItemEdt(this, "车辆型号*", null, "clxh", 1, null, false);
		this.zpbh = new InfoItemEdt(this, "照片编号*", null, "zpbh",1,
				null, false);
		this.clpp2 = new InfoItemEdt(this, "品牌(英文)*", null, "clpp2",1,
				null, false);
		this.zs = new InfoItemEdt(this, "轴数*", null, "zs", 1, null,
				false);
		this.zzl = new InfoItemEdt(this, "总质量*", " kg", "zzl", 1,
				"^[0-9\\.]{1,5}$", false);
		this.zbzl = new InfoItemEdt(this, "整备质量*", " kg", "0", "zbzl",
				1, "^[0-9\\.]{1,5}$", false);
		this.cwkk = new InfoItemEdt(this, "车外廓宽*", " mm", "cwkk", 1,
				null, false);
		this.cwkc = new InfoItemEdt(this, "车外廓长*", " mm", "cwkc", 1,
				null, false);
		this.cwkg = new InfoItemEdt(this, "车外廓高*", " mm", "cwkg", 1,
				null, false);
		this.dpid = new InfoItemEdt(this, "底盘ID", null, "dpid", 1, null,
				false);
		this.ltgg = new InfoItemEdt(this, "轮胎规格", null, "ltgg", 1, null,
				false);
		this.sbdhxl = new InfoItemEdt(this, "识别代号序列", null, "sbdhxl", 1,
				null, false);
		this.dpzs = new InfoItemEdt(this, "轴数", null, "dpzs", 1, null,
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
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "企业ID", null, "qyid",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "生产地址", null, "scdz",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "发动机型号", null,
				"fdjxh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "车辆类型", null, "cllx",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "制造国", null, "zzg",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "转向形式", null, "zxxs",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "燃料种类", null, "rlzl",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "排量", null, "pl",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "功率", null, "gl",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "货箱内部长度", "mm",
				"hxnbcd", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "货箱内部宽度", "mm",
				"hxnbkd", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "货箱内部高度", "mm",
				"hxnbgd", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "钢板弹簧片数", "片",
				"gbthps", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "轴距", null, "zj",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "前轮距", null, "qlj",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "后轮距", null, "hlj",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "轮胎数", null, "lts",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "额定载质量", null,
				"hdzzl", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "准牵引总质量", null,
				"zqyzl", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "额定载客", null, "hdzk",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "驾驶室前排人数", null,
				"qpzk", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "驾驶室后排人数", null,
				"hpzk", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "批次", null, "pc",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "环保达标情况", null,
				"hbdbqk", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "公告发布类型", null,
				"cslx", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "更新日期", null, "gxrq",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "备注", null, "bz",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "车辆制造企业", null,
				"zzcmc", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "公告发布日期", null,
				"ggrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "免检标记", null, "sfmj",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "撤销生效日期", null,
				"cxsxrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "底盘企业及型号", null,
				"dpqyxh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "产品类别", null, "cplb",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "车型公告编号", null,
				"clggbh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "是否允许注册", null,
				"sfyxzc", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "公告生效日期", null,
				"ggsxrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "公告有效期标记", null,
				"ggyxqbj", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "撤销公告批次", null,
				"cxggpc", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "撤销公告发布日期", null,
				"cxggrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "停止生产日期", null,
				"tzscrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "有效期描述", null,
				"yxqms", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "照片数", null, "zps",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "免检有效期止", null,
				"mjyxqz", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "反光标识型号", null,
				"fgbsxh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "反光标识商标", null,
				"fgbssb", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "反光标识企业", null,
				"fgbsqy", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "轴荷", null, "zh",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "载质量利用系数", null,
				"zzllyxs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "半挂鞍座最大允许总质量", null,
				"bgazzdyxzzl", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "接近离去角", null,
				"jjlqj", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "前悬后悬", null, "qxhx",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "驾驶室类型", null,
				"jsslx", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "传动型式", null, "cdxs",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "最高车速", null, "zgcs",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "油耗", null, "yh",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "前制动方式", null,
				"qzdfs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "后制动方式", null,
				"hzdfs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "前制动操作方式", null,
				"qzdczfs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "后制动操作方式", null,
				"hzdczfs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "发动机企业", null,
				"fdjqy", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "发动机商标", null,
				"fdjsb", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "是否带防抱死系统", null,
				"ywabs", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "车辆名称", null, "clmc",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "企业代码", null, "qydm",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "公告标记", null, "ggbj",
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
		 * 项目 输入限制 [1]:文本 [2]:纯数字 [2|8192]:浮点 ^[A-Za-z0-9]{6}$ [\u4e00-\u9fa5]+
		 */
		InfoItem csys,syr,zxzxjxs, qdxs, zczw, zs, jcxlb, qzdz, ygddtz, ccrq, clpp1, cwkk, cwkc, cwkg, hxnbcd, hxnbkd, hxnbgd, zzl, zbzl, ltgg, lcbds, fzjg, dlysfzh;
		/** 车辆基本信息 **/
		InfoItem rlzl, hdzk, zzs, zzly, xh, sjr, sjrsfzh, ytsx, fdjh, jyhgbzbh, hdzzl, zj, qlj, hlj, ccdjrq, yxqz, bxzzrq;
		// 车辆基本信息二
		InfoItem gbthps, lts, glbm, zzg, fdjxh, gcjk, sfzmhm, hbdbqk, xszbh, qpzk, hpzk, sfzmmc, clpp2, zqyzl, zzcmc, zxxs, djrq, qzbfqz, dybj;
	
		
		
		syr = new InfoItemEdt(this, "机动车所有人", null, "syr", 1, null, false);
		csys = new InfoItemEdt(GGDetailActivity.this, "车身颜色", null, "csys", 1,
				null, false);
		zxzxjxs = new InfoItemEdt(this, "悬架形式",null, "zxzxjxs",2 | 8192,null, false);
		// 将驱动形式拆分了为驱动轴，手刹轴。这样更能体现出摩托车
		qdxs =new InfoItemEdt(this, "驱动轴",null, "qdxs",2 | 8192,null, false);
		zczw=new InfoItemEdt(this, "手刹轴",null, "zczw",2 | 8192,null, false);
		zs=new InfoItemEdt(this, "轴数",null, "zs",2 | 8192,null, false);
		jcxlb=new InfoItemEdt(this, "检测线类别",null, "jcxlb",2 | 8192,null, false);
		qzdz=new InfoItemEdt(this, "前照灯制",null, "qzdz",2 | 8192,null, false);
		ygddtz=new InfoItemEdt(this, "远光单独调整",null, "ygddtz",2 | 8192,null, false);
		ccrq=new InfoItemEdt(this, "出厂日期",null, "ccrq",2 | 8192,null, false);
		clpp1 = new InfoItemEdt(this, "中文品牌*", null, "clpp1", 1, null, false);
		cwkk = new InfoItemEdt(this, "车外廓宽*", " mm", "cwkk", 2 | 8192, null,
				false);
		cwkc = new InfoItemEdt(this, "车外廓长*", " mm", "cwkc", 2 | 8192, null,
				false);
		cwkg = new InfoItemEdt(this, "车外廓高*", " mm", "cwkg", 2 | 8192, null,
				false);
		hxnbcd = new InfoItemEdt(this, "货箱内部长度", " mm", "hxnbcd", 2 | 8192,
				null, false);
		hxnbkd = new InfoItemEdt(this, "货箱内部宽度", " mm", "hxnbkd", 2 | 8192,
				null, false);
		hxnbgd = new InfoItemEdt(this, "货箱内部高度", " mm", "hxnbgd", 2 | 8192,
				null, false);
		zzl = new InfoItemEdt(this, "总质量*", " kg", "zzl", 2 | 8192,
				"^[0-9\\.]{1,5}$", false);
		zbzl = new InfoItemEdt(this, "整备质量*", " kg", "0", "zbzl", 2 | 8192,
				"^[0-9\\.]{1,5}$", false);
		ltgg = new InfoItemEdt(this, "轮胎规格", null, "ltgg", 1, null, true);
		lcbds = new InfoItemEdt(this, "里程表数#", "km", "lcbds", 2,
				"^[0-9]{1,9}$", false);
		fzjg = new InfoItemEdt(this, "发证机关*", null, "fzjg", 1, null, false);
		
		rlzl=new InfoItemEdt(this, "燃料类型", null, "rlzl", 1, null, false);
		hdzk = new InfoItemEdt(this, "核定载客人数", " 人", "hdzk", 1, "^[0-9]{1,5}$",
				true);
		zzs=new InfoItemEdt(this, "主轴数", null, "zzs", 1, null, false);
		zzly=new InfoItemEdt(this, "制动力源", null, "zzly", 1, null, false);
		xh = new InfoItemEdt(this, "机动车序号", null, "xh", 1, null, true);
		ytsx = new InfoItemEdt(this, "用途属性", null, "ytsx", 1, null, true);
		fdjh = new InfoItemEdt(this, "发动机号", null, "fdjh", 1, null, true);
		jyhgbzbh = new InfoItemEdt(this, "检验合格标志", null, "jyhgbzbh", 1, null,
				true);
		hdzzl = new InfoItemEdt(this, "核定载质量", "  kg ", "hdzzl", 2 | 8192,
				"^[0-9\\.]{1,6}$", true);
		zj = new InfoItemEdt(this, "轴距单位", " mm", "zj", 2 | 8192, null, true);
		qlj = new InfoItemEdt(this, "前轮距单位", " mm", "qlj", 2 | 8192, null, true);
		hlj = new InfoItemEdt(this, "后轮距单位", " mm", "hlj", 2 | 8192, null, true);
		ccdjrq=new InfoItemEdt(this, "初次登记日期", null, "ccdjrq", 2 | 8192, null, false);
		yxqz=new InfoItemEdt(this, "检验有效期止", null, "yxqz", 2 | 8192, null, false);
		bxzzrq=new InfoItemEdt(this, "保险终止日期", null, "bxzzrq", 2 | 8192, null, false);
		gbthps = new InfoItemEdt(this, "钢板弹簧片数", " 片", "gbthps", 2 | 8192,
				null, true);
		lts = new InfoItemEdt(this, "轮胎数", " 个", "lts", 2 | 8192, null, true);
		glbm = new InfoItemEdt(this, "管理部门", null, "glbm", 1, null, true);
		zzg = new InfoItemEdt(this, "制造国", null, "zzg", 1, null, true);
		fdjxh = new InfoItemEdt(this, "发动机型号", null, "fdjxh", 1, null, true);
		gcjk = new InfoItemEdt(this, "国产/进口", null, "gcjk", 1, null, true);
		sfzmhm = new InfoItemEdt(this, "身份证明号码", null, "sfzmhm", 1, null, true);
		hbdbqk = new InfoItemEdt(this, "环保达标情况", null, "hbdbqk", 1, null, true);
		xszbh = new InfoItemEdt(this, "行驶证证芯编号", null, "xszbh", 1, null, true);
		qpzk = new InfoItemEdt(this, "前排载客人数", " 人", "qpzk", 2 | 8192,
				"^[0-9]{1,5}$", true);
		hpzk = new InfoItemEdt(this, "后排载客人数", " 人", "hpzk", 2 | 8192,
				"^[0-9]{1,5}$", true);
		sfzmmc = new InfoItemEdt(this, "身份证明名称", null, "sfzmmc", 1, null, true);
		clpp2 = new InfoItemEdt(this, "英文品牌", null, "clpp2", 1, null, true);
		zqyzl = new InfoItemEdt(this, "准牵引总质量", " kg", "zqyzl", 2 | 8192, null,
				true);
		zzcmc = new InfoItemEdt(this, "制造厂名称", null, "zzcmc", 1, null, true);
		zxxs = new InfoItemEdt(this, "转向形式", null, "zxxs", 1, null, true);
		djrq=new InfoItemEdt(this, "最近定检日期", null, "djrq", 1, null, true);
		qzbfqz=new InfoItemEdt(this, "强制报废期止", null, "qzbfqz", 1, null, true);
		dybj=new InfoItemEdt(this, "抵押标记", null, "dybj", 1, null, true);
		// 开始处理
		
					this.loginModel
							.initItemBars(new String[] {  "车辆基本信息"});
					this.loginModel.addItem(0, clpp1); // 厂牌
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
					GGInfoModel.setItemsDataBD(mapBean.getWdlMap(),hm);//Map公告信息
					initItems();
					loginModel.setItemsDataBD(hm,mapBean.getWdlMap());
			     
					progressBar.setVisibility(View.GONE);
			    }  
			      
			};  
		
}

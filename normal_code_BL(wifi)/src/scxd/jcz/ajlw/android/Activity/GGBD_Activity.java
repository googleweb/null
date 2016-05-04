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
 * 由于项目设计原因此类的数据与功能现在没有用了可以请查看GGXX_ListActivity类
 * 
 * 
 * 公告比对项目
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
 * 初始化控件并设置监听
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
 * 初始化控件，适配控件
 */
	private void initItems() {
		/**
		 * 项目 输入限制 [1]:文本 [2]:纯数字 [2|8192]:浮点 ^[A-Za-z0-9]{6}$ [\u4e00-\u9fa5]+
		 * 
		 * 机动车公告技术参数整车信息
		 */

		this.GGInfoModel.initItemBars(new String[] { "公告图片信息", "公告底盘信息",
				"公告整车信息" });
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
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "企业ID", null, "qyid",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "生产地址", null, "scdz",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "发动机型号", null,
				"fdjxh", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "车辆类型", null, "cllx",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "制造国", null, "zzg",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "转向形式", null, "zxxs",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "燃料种类", null, "rlzl",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "排量", null, "pl",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "功率", null, "gl",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "货箱内部长度", "mm",
				"hxnbcd", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "货箱内部宽度", "mm",
				"hxnbkd", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "货箱内部高度", "mm",
				"hxnbgd", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "钢板弹簧片数", "片",
				"gbthps", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "轴距", null, "zj",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "前轮距", null, "qlj",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "后轮距", null, "hlj",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "轮胎数", null, "lts",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "额定载质量", null,
				"hdzzl", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "准牵引总质量", null,
				"zqyzl", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "额定载客", null, "hdzk",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "驾驶室前排人数", null,
				"qpzk", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "驾驶室后排人数", null,
				"hpzk", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "批次", null, "pc",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "环保达标情况", null,
				"hbdbqk", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "公告发布类型", null,
				"cslx", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "更新日期", null, "gxrq",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "备注", null, "bz",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "车辆制造企业", null,
				"zzcmc", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "公告发布日期", null,
				"ggrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "免检标记", null, "sfmj",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "撤销生效日期", null,
				"cxsxrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "底盘企业及型号", null,
				"dpqyxh", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "产品类别", null, "cplb",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "车型公告编号", null,
				"clggbh", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "是否允许注册", null,
				"sfyxzc", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "公告生效日期", null,
				"ggsxrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "公告有效期标记", null,
				"ggyxqbj", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "撤销公告批次", null,
				"cxggpc", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "撤销公告发布日期", null,
				"cxggrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "停止生产日期", null,
				"tzscrq", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "有效期描述", null,
				"yxqms", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "照片数", null, "zps",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "免检有效期止", null,
				"mjyxqz", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "反光标识型号", null,
				"fgbsxh", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "反光标识商标", null,
				"fgbssb", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "反光标识企业", null,
				"fgbsqy", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "轴荷", null, "zh",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "载质量利用系数", null,
				"zzllyxs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "半挂鞍座最大允许总质量", null,
				"bgazzdyxzzl", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "接近离去角", null,
				"jjlqj", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "前悬后悬", null, "qxhx",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "驾驶室类型", null,
				"jsslx", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "传动型式", null, "cdxs",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "最高车速", null, "zgcs",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "油耗", null, "yh",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "前制动方式", null,
				"qzdfs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "后制动方式", null,
				"hzdfs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "前制动操作方式", null,
				"qzdczfs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "后制动操作方式", null,
				"hzdczfs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "发动机企业", null,
				"fdjqy", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "发动机商标", null,
				"fdjsb", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "是否带防抱死系统", null,
				"ywabs", 1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "车辆名称", null, "clmc",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "企业代码", null, "qydm",
				1, null, false));
		this.GGInfoModel.addItem(2, new InfoItemEdt(this, "公告标记", null, "ggbj",
				1, null, false));

		/** 底盘信息 **/
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "底盘公告编号", null,
				"dpbh", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "底盘ID", null,
				"dpdpid", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "企业ID", null,
				"dpqyid", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "生产地址", null,
				"dpscdz", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "底盘型号", null,
				"dpdpxh", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "底盘类别", null,
				"dpdplb", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "产品名称", null,
				"dpcpmc", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "产品商标", null,
				"dpcpsb", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "外廓长", null, "dpc",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "外廓宽", null, "dpk",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "外廓高", null, "dpg",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "燃料种类", null,
				"dprlzl", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "依据标准", null,
				"dpyjbz", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "转向形式", null,
				"dpzxxs", 1, null, false));
		this.GGInfoModel.addItem(1, this.dpzs);
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "轴距", null, "dpzj",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "钢板弹簧片数", null,
				"dpgbthps", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "轮胎数", null, "dplts",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "轮胎规格", null,
				"dpltgg", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "前轮距", null, "dpqlj",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "后轮距", null, "dphlj",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "总质量", null, "dpzzl",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "整备质量", null,
				"dpzbzl", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "准牵引总质量", null,
				"dpzqyzl", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "发动机型号", null,
				"dpfdjxh", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "排量", null, "dppl",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "功率", null, "dpgl",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "识别代号序列", null,
				"dpsbdh", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "批次", null, "dppc",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "公告发布类型", null,
				"dpcslx", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "更新日期", null,
				"dpgxrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "备注", null, "dpbz",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "车辆制造企业", null,
				"dpzzcmc", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "公告发布日期", null,
				"dpggrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "撤销生效日期", null,
				"dpcxsxrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "驾驶室前排人数", null,
				"dpqpzk", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "驾驶室后排人数", null,
				"dphpzk", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "公告生效日期", null,
				"dpggsxrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "公告有效期标记", null,
				"dpggyxqbj", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "撤销公告批次", null,
				"dpcxggpc", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "撤销公告发布日期", null,
				"dpcxggrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "停止生产日期", null,
				"dptzscrq", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "有效期描述", null,
				"dpyxqms", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "发动机企业", null,
				"dpfdjqy", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "发动机商标", null,
				"dpfdjsb", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "接近离去角", null,
				"dpjjlqj", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "前悬后悬", null,
				"dpqxhx", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "轴荷", null, "dpzh",
				1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "最高车速", null,
				"dpzgcs", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "是否带防抱死系统", null,
				"dpywabs", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "企业代码", null,
				"dpqydm", 1, null, false));
		this.GGInfoModel.addItem(1, new InfoItemEdt(this, "公告标记", null,
				"dpggbj", 1, null, false));
		/** 图片信息 **/
		this.GGInfoModel.addItem(0, zpbh);
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "整车公告编号", null,
				"zpbh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "车型公告编号", null,
				"zpclggbh", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "顺序号", null, "zpsxh",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "批次", null, "zppc",
				1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "公告发布日期", null,
				"zpggrq", 1, null, false));
		this.GGInfoModel.addItem(0, new InfoItemEdt(this, "更新日期", null,
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
	 * 得到bundle中所有的key 04.Iterator<String> iter = keySet.iterator();
	 * 05.while(iter.hasNext()) 06.{ 07. String key = iter.next(); 08.
	 * map.put(key, bundle.getStringArray(key)); 09.}
	 */
	// 登录跳转
	/**
	 * 车辆登录跳转
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

	// 公告照片查询
	/**
	 * 公告照片查询
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
			Toast.makeText(this, "照片编号不能为空！", 1000).show();
			return;
		}
	}

	private String queryBH = "";

	// 公告信息查询
	/**
	 * 公告信息查询
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
			Toast.makeText(this, "中文品牌、车辆型号不能为空！", 1000).show();
			return;
		}
	}

	// 公告信息查询
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
			Toast.makeText(this, "底盘ID不能为空！", 1000).show();
			return;
		}
	}

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try{
		if ("18C08".equals(jkid)) {//此数据没有用到
			ArrayList<Map<String, String>> responseMap = (ArrayList<Map<String, String>>) result;
			if (responseMap.size() != 0) {
				showGGXXPCLB(responseMap);
			} else {
				Toast.makeText(GGBD_Activity.this, "没有查询到公告信息！", 1000).show();
			}
		} else if ("18C09".equals(jkid)) {
			Map<String, Object> responseMap = (Map<String, Object>) result;
			if (!responseMap.get("code").equals("0")) {
				showGGZP((String) responseMap.get("zpbh"));
			} else {
				Toast.makeText(GGBD_Activity.this, "没有查询到公告照片！", 1000).show();
			}
		}
		}catch (Exception e) {
			DefautDialog.showDialog(GGBD_Activity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	private ArrayList<Map<String, String>> data = null;
/**
 * 显示公告信息
 * @param responseMap
 */
	private void showGGXXPCLB(ArrayList<Map<String, String>> responseMap) {
		try {
			if (responseMap == null || responseMap.size() == 0) {
				Toast.makeText(GGBD_Activity.this, "没有查询到公告信息！", 1000).show();
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
					"提示：", popView, "请选择批次？", "返  回",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							PromptUtils.closeAlertDialog();
						}
					});
		} catch (Exception e) {
			Toast.makeText(GGBD_Activity.this, "没有查询到公告信息！", 1000).show();
		}
	}

	private String[] zpbhs = null;
	private int surI = 0;
/**
 * 显示公告照片
 * @param zpbh
 */
	private void showGGZP(String zpbh) {
		try {
			// zpbh = "11,12,13,14,15";
			if (zpbh.equals("")) {
				Toast.makeText(GGBD_Activity.this, "没有查询到公告照片！", 1000).show();
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
						Toast.makeText(GGBD_Activity.this, "最上一张照片了！", 1000)
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
						Toast.makeText(GGBD_Activity.this, "最下一张照片了！", 1000)
								.show();
					}
				}
			});
			txtCameraImgv.setVisibility(View.GONE);
			imageView.setVisibility(View.VISIBLE);
			imageView.setImageBitmap(getBitmap(getImagePath(zpbhs[surI])));
			PromptUtils.showAlertDialog(this, R.drawable.query_dialog_icon,
					"提示：", popView, "公告照片：", "返  回",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							PromptUtils.closeAlertDialog();
						}
					});
		} catch (Exception e) {
			Toast.makeText(GGBD_Activity.this, "没有查询到公告照片！", 1000).show();
		}
	}
/**
 * 获取图片在本地路径
 * @param zpbh 照片编号
 * @return 路径
 */
	private String getImagePath(String zpbh) {
		return "/mnt/sdcard/jclwjcz/ggimage/" + Md_Car_Temp.getTempCar().ggbh
				+ "/" + zpbh + ".png";
		// return "/mnt/sdcard/jclwjcz/ggimage/888888/" + zpbh + ".png";
	}
/**
 * 通过照片路径获得位图
 * @param imagePath
 * @return
 */
	private Bitmap getBitmap(String imagePath) {
		Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
		return bitmap;
	}
}

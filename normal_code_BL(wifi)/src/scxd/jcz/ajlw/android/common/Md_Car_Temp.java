package scxd.jcz.ajlw.android.common;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 临时存储中间数据
 * 
 * @author xxy
 * 
 */
public class Md_Car_Temp {

	public static String test;//测试
	private static Md_Car_Temp md_car_temp;

	public static Md_Car_Temp getTempCar() {
		if (null == md_car_temp) {
			md_car_temp = new Md_Car_Temp();
		}
		return md_car_temp;
	}
	public static String isPing="0";
	public static String message = "";// 保存照片状态
	public List<Map<String, Object>> mDataList; // 牌照项目
	public static Map<String, Object> dataqt=null;//保存其他
	public static Map<Integer, Boolean> isSelected;// 照片状态
	public static Boolean isFinish=false;//确实是否点击了其他选项拍照
	public List<String> basicPZXM; // 基础拍照项目
	public List<String> zdyPZXM; // 自定义拍照项目
	public List<String> basicPZXMState; // 基础拍照项目状态
	public List<String> zdyHasTakeCodes; // 基础拍照项目状态
	public Map<String, String> mapwz = null;
	public String gbthps = ""; // 弹簧钢板片数
	public String sfqppz = "是";
	public String csys = "";
	public String sfzh = "";
	public String zt = "";
	public String car_jcxdh = "1";
	public int returnView;

	public String acl = "";
	/**
	 * 当前项目名称
	 */
	public String car_xmName;
	/**
	 * 车辆id
	 */
	public String car_id = "";
	/**
	 * 线程通知事件标识
	 */
	public boolean isFlag = false;
	/**
	 * 存储已拍照项目
	 */
	public String pzxm_yp = "";
	/**
	 * 存储临时照片，供守护线程进行上传
	 */
	public List<MD_Car_photo> listImageData = new ArrayList<MD_Car_photo>();
	/**
	 * 升级文件路径
	 */
	public String upDataFile = "";
	/**
	 * 车辆类型
	 */
	public String car_lx = "";
	/**
	 * 是否开起人工检验
	 */
	public boolean sfpeple = false;
	/**
	 * 车辆号牌号码
	 */
	public static String car_hphm = "";
	/**
	 * 车辆Vin码
	 */
	public static String car_vin = "";
	public String car_clsbdh = "";
	/**
	 * 检验次数
	 */
	public String car_jycs = "";
	/**
	 * 系统流水号
	 */
	public String car_lsh = "";
	/**
	 * 使用性质
	 */
	public String car_syxz = "";

	/**
	 * 检测类别
	 */
	public String car_jclb = "";

	/**
	 * 号牌种类
	 */
	public static String car_hpzl = "";

	/**
	 * 平板唯一码
	 */
	public String deviceId = "";
	/**
	 * 拍照种类
	 */
	public String pz_code = "";
	/**
	 * 是否自定义 0 不是 1 是
	 */
	public String sfzdy = "0";
	/**
	 * 是否新车 0新车 1 在用车
	 */
	public String sfxc = "";
	/**
	 * 车辆列表是否有数据
	 */
	public boolean carListBooeal = false;
	/**
	 * 拍照类型是否有数据
	 */
	public boolean carPhotoBooeal = false;

	/**
	 * 是否人工检验
	 */
	public boolean iscarPeople = false;

	/**
	 * 人工检验是否有数据
	 */
	public boolean carPeopleBooeal = false;
	/**
	 * webservice是否正常
	 */
	public boolean webState = false;

	/**
	 * 用户名
	 */
	public String username = "";
	/**
	 * 密码
	 */
	public String password = "";
	/**
	 * 用户Id
	 */
	public String userid = "";

	/**
	 * 是否注销
	 */
	public boolean ispbzc = false;
	/**
	 * 用户真实姓名
	 */
	public String userxingming = "";
	/**
	 * 是否拍照
	 */
	public boolean ispz = false;

	/**
	 * 临时存储拍照项目xml
	 */
	public String pzXmlStr = "";
	/**
	 * 外检通道
	 */
	public String wjtd = "";
	/**
	 * 线号
	 */
	public String xh = "0";

	/**
	 * 业务类型
	 */
	public int ywlx = 0;

	/**
	 * 是否补拍照片
	 */
	public boolean sfbpzp = false;

	/**
	 * cng 检测状态
	 */
	public String cngstate = "0";

	/**
	 * cng 检测状态
	 */
	public String sfwcpz = "0";

	/**
	 * 判断拍照列表界面是从哪个界面进入 0：车辆登录 1：拍照界面
	 */
	public String topaizhao = "1";

	public String FromPzlistToPzlx = "";
	public String FromWjlistToWjItem = "";
	public String FromCylistToCyItem = "";
	public String FromDTDPlistToDTDPItem = "";
	public String FromReTakeToPz = "";
	/**
	 * 临时存放 登陆时 检测项目 是否选中
	 */
	public String ls = "0";
	public String wjpz = "0";
	public String rgwj = "0";
	public String str = null;
	public boolean b = false;
	public boolean zdy = false;
	public boolean dptjfh;// 判断底盘数据提交后，跳回界面后线号显示的数据
	public boolean isopent = false;// 手电筒开启
	public String jyysfzh = "";
	public long sjc = 0; // 时间差
	public String fromLoginToInit = "";
	public boolean isQuery = false;
	public String pdyj = "1"; // 1.老国标 2.新国标
	public List<String> car_jyxm = null;
	public List<String> car_ywcjyxm = null;
	public String ggbh = ""; // 公告编号
	public boolean isFromGGBD = false; // 是否从公告界面跳转
	public String ggcxlx = "";

	/**
	 * 恢复默认值
	 * */
	public void clearData() {
		this.car_lx = "";
		this.fromLoginToInit = "";
		if (isSelected != null && isSelected.size() > 0) {
			this.isSelected.clear();
		}
		if (mDataList != null && mDataList.size() > 0) {
			this.mDataList.clear();
		}
		this.zt = "";
		this.car_hphm = "";
		this.car_vin = "";
		this.car_jycs = "";
		this.car_lsh = "";
		this.car_hpzl = "";
		this.car_syxz = "";
		this.car_jclb = "";
		this.pz_code = "";
		this.sfzdy = "0";
		this.sfxc = "";
		this.carListBooeal = false;
		this.carPhotoBooeal = false;
		this.carPeopleBooeal = false;
		this.sfbpzp = false;
		this.ispbzc = false;
		this.pzxm_yp = "";
		this.car_clsbdh = "";
		this.pzXmlStr = "";
		this.wjtd = "";
		this.cngstate = "0";
		this.sfwcpz = "";
		this.ls = "0";
		this.car_jcxdh = "";
		this.wjpz = "0";
		this.rgwj = "0";
		// this.car_id = "" ;

		// this.xh="";
	}

	/**
	 * 字符串MD5加密
	 * 
	 * @param msgString
	 *            传入字符串
	 * @return
	 */
	public String MD5(String msgString) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = msgString.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

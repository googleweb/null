package scxd.jcz.ajlw.android.model;

/**
 * 存储xml字段实体类
 * @author xxy
 *
 */
public class MD_Xml_Node {


	/**
	 * 存储xml字段
	 */
	//信息代码
	public String code;
	//信息
	public String message;
	//列表条数
	public String rownum;
	//检测流水号
	public String jclsh;
	//号牌种类
	public String hpzl;
	//车辆类型
	public String cllx;
	//号牌号码
	public String hphm;
	//车辆识别代号
	public String clsbdh;
	//使用性质
	public String syxz ;
	//检测类别
	public String jclb ;
	//车辆id
	public String car_id;
	public String clpp1;
	public String clxh;
	//0拍照和人工未完成  1 拍照完成 2 人工完成
	public String sfwcpz;
	public String sfzdy;
	public String wjtd;
	
	public String cngstate;
	/**
	 * 存储xml字段构造方法
	 * @param code 返回代码
	 * @param message返回相应信息
	 * @param rownum返回接收到的条数
	 * @param jclsh车辆流水号
	 * @param hpzl号牌种类
	 * @param hphm号牌号码
	 * @param clsbdh车辆识别代号(VIN)
	 * @param cllx 车辆类型
	 * @param sfwcpz 0拍照和人工未完成  1 拍照完成 2 人工完成
	 */
	public MD_Xml_Node(String sfzdy,String cllx,String code,String message,String rownum,String jclsh,String hpzl,String hphm,String clsbdh,String sfwcpz,String wjtd,String syxz,String jclb,String cngstate,String car_id,String clpp1,String clxh){
		
		this.cllx = cllx;
		this.code = code;
		this.message = message;
		this.rownum = rownum;
		this.jclsh = jclsh;
		this.hpzl=hpzl;
		this.hphm=hphm;
		this.clsbdh = clsbdh;
		this.sfwcpz = sfwcpz;
		this.sfzdy = sfzdy;
		this.wjtd = wjtd;
		this.syxz = syxz ;
		this.jclb = jclb ;
		this.cngstate = cngstate ;
		this.car_id=car_id;
		this.clpp1=clpp1;
		this.clxh=clxh;
	}
public MD_Xml_Node(String sfzdy,String cllx,String code,String message,String rownum,String 
		jclsh,String hpzl,String hphm,String clsbdh,String sfwcpz,String wjtd,String syxz,String jclb,
		String cngstate,String car_id){
		
		this.cllx = cllx;
		this.code = code;
		this.message = message;
		this.rownum = rownum;
		this.jclsh = jclsh;
		this.hpzl=hpzl;
		this.hphm=hphm;
		this.clsbdh = clsbdh;
		this.sfwcpz = sfwcpz;
		this.sfzdy = sfzdy;
		this.wjtd = wjtd;
		this.syxz = syxz ;
		this.jclb = jclb ;
		this.cngstate = cngstate ;
		this.car_id=car_id;
	}
}

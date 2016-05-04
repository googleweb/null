package scxd.jcz.ajlw.android.model;

/**
 * 系统配置实体类
 * 
 * @author xxy
 */
public class Md_system {

	/**
	 * 返回version
	 * 
	 * @return 版本号
	 */
	public static String getVersion() {
		return version;
	}

	/**
	 * 设置version
	 * 
	 * @param version
	 *            the version to set
	 */
	public static void setVersion(String version) {
		Md_system.version = version;
	}

	/**
	 * 程序版本号
	 */
	public static String version = "";
	/**
	 * 是否环检
	 */
	public static String sfhj = "是";

	public static String getSfhj() {
		return sfhj;
	}

	public static void setSfhj(String sfhj) {
		Md_system.sfhj = sfhj;
	}

	/**
	 * 是否综检
	 */
	public static String sfzj = "否";

	public static String getSfzj() {
		return sfzj;
	}

	public static void setSfzj(String sfzj) {
		Md_system.sfzj = sfzj;
	}

	/**
	 * 是否在PDA上做动态底盘
	 */
	public static String sfdtdp = "是";

	public static String getSfdtdp() {
		return sfdtdp;
	}

	public static void setSfdtdp(String sfdtdp) {
		Md_system.sfdtdp = sfdtdp;
	}

	/**
	 * 是否签名
	 */
	public static String sfSign = "否";

	public static String getSfSign() {
		return sfSign;
	}

	public static void setSfSign(String sfSign) {
		Md_system.sfSign = sfSign;
	}

	/**
	 * 外检是否自选
	 */
	public static String sfchose = "否";
	

	public static String getSfchose() {
		return sfchose;
	}

	public static void setSfchose(String sfchose) {
		Md_system.sfchose = sfchose;
	}
public static String siglelogin="否";
	/**
 *返回siglelogin
 * @return 
 */
public static String getSiglelogin() {
	return siglelogin;
}

/**
 *设置siglelogin
 * @param siglelogin the siglelogin to set
 */
public static void setSiglelogin(String siglelogin) {
	Md_system.siglelogin = siglelogin;
}

	/**
	 * 是否勾选检验项目
	 */
	public static String sfgxjyxm = "是";

	public static String getSfgxjyxm() {
		return sfgxjyxm;
	}

	public static void setSfgxjyxm(String sfgxjyxm) {
		Md_system.sfgxjyxm = sfgxjyxm;
	}

	/**
	 * 返回lsxh
	 * 
	 * @return
	 */
	public static String lsxh = "1";

	public static String getLsxh() {
		return lsxh;
	}

	public static void setLsxh(String lsxh) {
		Md_system.lsxh = lsxh;
	}

	public static String hphmlb = "川";

	public static String getHphmlb() {
		return hphmlb;
	}

	public static void setHphmlb(String hphmlb) {
		Md_system.hphmlb = hphmlb;
	}

	public static String getZpmc() {
		return zpmc;
	}

	public static void setZpmc(String zpmc) {
		Md_system.zpmc = zpmc;
	}

	public static String zpmc = "";

	public static String getZpbh() {
		return zpbh;
	}

	public static void setZpbh(String zpbh) {
		Md_system.zpbh = zpbh;
	}

	public static String zpbh = "";

	public static String getDq() {
		return dq;
	}

	public static void setDq(String dq) {
		Md_system.dq = dq;
	}

	public static String dq = "北京"; // 地区

	/**
	 * 返回ptkey
	 * 
	 * @return
	 */
	public static String getPtkey() {
		return ptkey;
	}

	/**
	 * 设置ptkey
	 * 
	 * @param ptkey
	 *            the ptkey to set
	 */
	public static void setPtkey(String ptkey) {
		Md_system.ptkey = ptkey;
	}

	/**
	 * 返回dzkey
	 * 
	 * @return
	 */
	public static String getDzkey() {
		return dzkey;
	}

	/**
	 * 设置dzkey
	 * 
	 * @param dzkey
	 *            the dzkey to set
	 */
	public static void setDzkey(String dzkey) {
		Md_system.dzkey = dzkey;
	}

	/**
	 * 返回xtlb
	 * 
	 * @return
	 */
	public static String getXtlb() {
		return xtlb;
	}

	/**
	 * 设置xtlb
	 * 
	 * @param xtlb
	 *            the xtlb to set
	 */
	public static void setXtlb(String xtlb) {
		Md_system.xtlb = xtlb;
	}

	/**
	 * 接口地址
	 * 
	 * @return the jk_url
	 */
	private static String jk_url;
	/**
	 * 接口序列号
	 * 
	 * @param jk_url
	 *            the jk_url to set
	 */
	private static String jk_sn;
	/**
	 * 通用接口序列号
	 */
	private static String ptkey;
	/**
	 * 平板专用接口序列号
	 */
	private static String dzkey;
	/**
	 * 系统类别
	 */
	private static String xtlb;

	/**
	 * 接口地址
	 * 
	 * @return the jk_url
	 * @return the jk_url
	 */
	public static String getJk_url() {
		return jk_url;
	}

	/**
	 * 接口地址
	 * 
	 * @return the jk_url
	 * @param aJk_url
	 *            the jk_url to set
	 */
	public static void setJk_url(String aJk_url) {
		jk_url = aJk_url;
	}

	/**
	 * 接口序列号
	 * 
	 * @param jk_url
	 *            the jk_url to set
	 * @return the jk_sn
	 */
	public static String getJk_sn() {
		return jk_sn;
	}

	/**
	 * 接口序列号
	 * 
	 * @param jk_url
	 *            the jk_url to set
	 * @param aJk_sn
	 *            the jk_sn to set
	 */
	public static void setJk_sn(String aJk_sn) {
		jk_sn = aJk_sn;
	}

}

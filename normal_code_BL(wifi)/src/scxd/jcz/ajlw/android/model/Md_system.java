package scxd.jcz.ajlw.android.model;

/**
 * ϵͳ����ʵ����
 * 
 * @author xxy
 */
public class Md_system {

	/**
	 * ����version
	 * 
	 * @return �汾��
	 */
	public static String getVersion() {
		return version;
	}

	/**
	 * ����version
	 * 
	 * @param version
	 *            the version to set
	 */
	public static void setVersion(String version) {
		Md_system.version = version;
	}

	/**
	 * ����汾��
	 */
	public static String version = "";
	/**
	 * �Ƿ񻷼�
	 */
	public static String sfhj = "��";

	public static String getSfhj() {
		return sfhj;
	}

	public static void setSfhj(String sfhj) {
		Md_system.sfhj = sfhj;
	}

	/**
	 * �Ƿ��ۼ�
	 */
	public static String sfzj = "��";

	public static String getSfzj() {
		return sfzj;
	}

	public static void setSfzj(String sfzj) {
		Md_system.sfzj = sfzj;
	}

	/**
	 * �Ƿ���PDA������̬����
	 */
	public static String sfdtdp = "��";

	public static String getSfdtdp() {
		return sfdtdp;
	}

	public static void setSfdtdp(String sfdtdp) {
		Md_system.sfdtdp = sfdtdp;
	}

	/**
	 * �Ƿ�ǩ��
	 */
	public static String sfSign = "��";

	public static String getSfSign() {
		return sfSign;
	}

	public static void setSfSign(String sfSign) {
		Md_system.sfSign = sfSign;
	}

	/**
	 * ����Ƿ���ѡ
	 */
	public static String sfchose = "��";
	

	public static String getSfchose() {
		return sfchose;
	}

	public static void setSfchose(String sfchose) {
		Md_system.sfchose = sfchose;
	}
public static String siglelogin="��";
	/**
 *����siglelogin
 * @return 
 */
public static String getSiglelogin() {
	return siglelogin;
}

/**
 *����siglelogin
 * @param siglelogin the siglelogin to set
 */
public static void setSiglelogin(String siglelogin) {
	Md_system.siglelogin = siglelogin;
}

	/**
	 * �Ƿ�ѡ������Ŀ
	 */
	public static String sfgxjyxm = "��";

	public static String getSfgxjyxm() {
		return sfgxjyxm;
	}

	public static void setSfgxjyxm(String sfgxjyxm) {
		Md_system.sfgxjyxm = sfgxjyxm;
	}

	/**
	 * ����lsxh
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

	public static String hphmlb = "��";

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

	public static String dq = "����"; // ����

	/**
	 * ����ptkey
	 * 
	 * @return
	 */
	public static String getPtkey() {
		return ptkey;
	}

	/**
	 * ����ptkey
	 * 
	 * @param ptkey
	 *            the ptkey to set
	 */
	public static void setPtkey(String ptkey) {
		Md_system.ptkey = ptkey;
	}

	/**
	 * ����dzkey
	 * 
	 * @return
	 */
	public static String getDzkey() {
		return dzkey;
	}

	/**
	 * ����dzkey
	 * 
	 * @param dzkey
	 *            the dzkey to set
	 */
	public static void setDzkey(String dzkey) {
		Md_system.dzkey = dzkey;
	}

	/**
	 * ����xtlb
	 * 
	 * @return
	 */
	public static String getXtlb() {
		return xtlb;
	}

	/**
	 * ����xtlb
	 * 
	 * @param xtlb
	 *            the xtlb to set
	 */
	public static void setXtlb(String xtlb) {
		Md_system.xtlb = xtlb;
	}

	/**
	 * �ӿڵ�ַ
	 * 
	 * @return the jk_url
	 */
	private static String jk_url;
	/**
	 * �ӿ����к�
	 * 
	 * @param jk_url
	 *            the jk_url to set
	 */
	private static String jk_sn;
	/**
	 * ͨ�ýӿ����к�
	 */
	private static String ptkey;
	/**
	 * ƽ��ר�ýӿ����к�
	 */
	private static String dzkey;
	/**
	 * ϵͳ���
	 */
	private static String xtlb;

	/**
	 * �ӿڵ�ַ
	 * 
	 * @return the jk_url
	 * @return the jk_url
	 */
	public static String getJk_url() {
		return jk_url;
	}

	/**
	 * �ӿڵ�ַ
	 * 
	 * @return the jk_url
	 * @param aJk_url
	 *            the jk_url to set
	 */
	public static void setJk_url(String aJk_url) {
		jk_url = aJk_url;
	}

	/**
	 * �ӿ����к�
	 * 
	 * @param jk_url
	 *            the jk_url to set
	 * @return the jk_sn
	 */
	public static String getJk_sn() {
		return jk_sn;
	}

	/**
	 * �ӿ����к�
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

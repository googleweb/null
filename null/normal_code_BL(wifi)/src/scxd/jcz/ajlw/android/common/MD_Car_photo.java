package scxd.jcz.ajlw.android.common;

/**
 * 拍照图片xml实体类
 * @author xxy
 *
 */
public class MD_Car_photo {

	/**
	 *返回sfxc
	 * @return 
	 */
	public String getSfxc() {
		return sfxc;
	}
	/**
	 *设置sfxc
	 * @param sfxc the sfxc to set
	 */
	public void setSfxc(String sfxc) {
		this.sfxc = sfxc;
	}
	/**
	 *返回jclsh
	 * @return 
	 */
	public String getJclsh() {
		return jclsh;
	}
	/**
	 *设置jclsh
	 * @param jclsh the jclsh to set
	 */
	public void setJclsh(String jclsh) {
		this.jclsh = jclsh;
	}
	/**
	 *返回hphm
	 * @return 
	 */
	public String getHphm() {
		return hphm;
	}
	/**
	 *设置hphm
	 * @param hphm the hphm to set
	 */
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	/**
	 *返回hpzl
	 * @return 
	 */
	public String getHpzl() {
		return hpzl;
	}
	/**
	 *设置hpzl
	 * @param hpzl the hpzl to set
	 */
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	/**
	 *返回pssj
	 * @return 
	 */
	public String getPssj() {
		return pssj;
	}
	/**
	 *设置pssj
	 * @param pssj the pssj to set
	 */
	public void setPssj(String pssj) {
		this.pssj = pssj;
	}
	/**
	 *返回zpzl
	 * @return 
	 */
	public String getZpzl() {
		return zpzl;
	}
	/**
	 *设置zpzl
	 * @param zpzl the zpzl to set
	 */
	public void setZpzl(String zpzl) {
		this.zpzl = zpzl;
	}
	/**
	 *返回zp
	 * @return 
	 */
	public String getZp() {
		return zp;
	}
	/**
	 *设置zp
	 * @param zp the zp to set
	 */
	public void setZp(String zp) {
		this.zp = zp;
	}
	/**
	 *返回cllx
	 * @return 
	 */
	public String getCllx() {
		return cllx;
	}
	/**
	 *设置cllx
	 * @param cllx the cllx to set
	 */
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	/**
	 *返回clsbdh
	 * @return 
	 */
	public String getClsbdh() {
		return clsbdh;
	}
	/**
	 *设置clsbdh
	 * @param clsbdh the clsbdh to set
	 */
	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}
	/**
	 *返回sfzdy
	 * @return 
	 */
	public String getSfzdy() {
		return sfzdy;
	}
	/**
	 *设置sfzdy
	 * @param sfzdy the sfzdy to set
	 */
	public void setSfzdy(String sfzdy) {
		this.sfzdy = sfzdy;
	}
	/**
	 *返回userid
	 * @return 
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 *设置userid
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	//检测流水号
	String jclsh;
	//号码号码
	String hphm;
	//号牌种类
	String hpzl;
	//拍摄时间
	String pssj;
	//照片种类
	String zpzl;
	//照片数据
	String zp;
	//车辆类型
	String cllx;
	//车辆识别代码
	String clsbdh;
	//是否自定义
	String sfzdy;
	//用户ID
	String userid;
	//是否新车 0新车 1在用车
	String sfxc;
}

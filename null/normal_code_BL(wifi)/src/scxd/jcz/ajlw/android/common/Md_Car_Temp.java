package scxd.jcz.ajlw.android.common;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ��ʱ�洢�м�����
 * 
 * @author xxy
 * 
 */
public class Md_Car_Temp {

	public static String test;//����
	private static Md_Car_Temp md_car_temp;

	public static Md_Car_Temp getTempCar() {
		if (null == md_car_temp) {
			md_car_temp = new Md_Car_Temp();
		}
		return md_car_temp;
	}
	public static String isPing="0";
	public static String message = "";// ������Ƭ״̬
	public List<Map<String, Object>> mDataList; // ������Ŀ
	public static Map<String, Object> dataqt=null;//��������
	public static Map<Integer, Boolean> isSelected;// ��Ƭ״̬
	public static Boolean isFinish=false;//ȷʵ�Ƿ���������ѡ������
	public List<String> basicPZXM; // ����������Ŀ
	public List<String> zdyPZXM; // �Զ���������Ŀ
	public List<String> basicPZXMState; // ����������Ŀ״̬
	public List<String> zdyHasTakeCodes; // ����������Ŀ״̬
	public Map<String, String> mapwz = null;
	public String gbthps = ""; // ���ɸְ�Ƭ��
	public String sfqppz = "��";
	public String csys = "";
	public String sfzh = "";
	public String zt = "";
	public String car_jcxdh = "1";
	public int returnView;

	public String acl = "";
	/**
	 * ��ǰ��Ŀ����
	 */
	public String car_xmName;
	/**
	 * ����id
	 */
	public String car_id = "";
	/**
	 * �߳�֪ͨ�¼���ʶ
	 */
	public boolean isFlag = false;
	/**
	 * �洢��������Ŀ
	 */
	public String pzxm_yp = "";
	/**
	 * �洢��ʱ��Ƭ�����ػ��߳̽����ϴ�
	 */
	public List<MD_Car_photo> listImageData = new ArrayList<MD_Car_photo>();
	/**
	 * �����ļ�·��
	 */
	public String upDataFile = "";
	/**
	 * ��������
	 */
	public String car_lx = "";
	/**
	 * �Ƿ����˹�����
	 */
	public boolean sfpeple = false;
	/**
	 * �������ƺ���
	 */
	public static String car_hphm = "";
	/**
	 * ����Vin��
	 */
	public static String car_vin = "";
	public String car_clsbdh = "";
	/**
	 * �������
	 */
	public String car_jycs = "";
	/**
	 * ϵͳ��ˮ��
	 */
	public String car_lsh = "";
	/**
	 * ʹ������
	 */
	public String car_syxz = "";

	/**
	 * ������
	 */
	public String car_jclb = "";

	/**
	 * ��������
	 */
	public static String car_hpzl = "";

	/**
	 * ƽ��Ψһ��
	 */
	public String deviceId = "";
	/**
	 * ��������
	 */
	public String pz_code = "";
	/**
	 * �Ƿ��Զ��� 0 ���� 1 ��
	 */
	public String sfzdy = "0";
	/**
	 * �Ƿ��³� 0�³� 1 ���ó�
	 */
	public String sfxc = "";
	/**
	 * �����б��Ƿ�������
	 */
	public boolean carListBooeal = false;
	/**
	 * ���������Ƿ�������
	 */
	public boolean carPhotoBooeal = false;

	/**
	 * �Ƿ��˹�����
	 */
	public boolean iscarPeople = false;

	/**
	 * �˹������Ƿ�������
	 */
	public boolean carPeopleBooeal = false;
	/**
	 * webservice�Ƿ�����
	 */
	public boolean webState = false;

	/**
	 * �û���
	 */
	public String username = "";
	/**
	 * ����
	 */
	public String password = "";
	/**
	 * �û�Id
	 */
	public String userid = "";

	/**
	 * �Ƿ�ע��
	 */
	public boolean ispbzc = false;
	/**
	 * �û���ʵ����
	 */
	public String userxingming = "";
	/**
	 * �Ƿ�����
	 */
	public boolean ispz = false;

	/**
	 * ��ʱ�洢������Ŀxml
	 */
	public String pzXmlStr = "";
	/**
	 * ���ͨ��
	 */
	public String wjtd = "";
	/**
	 * �ߺ�
	 */
	public String xh = "0";

	/**
	 * ҵ������
	 */
	public int ywlx = 0;

	/**
	 * �Ƿ�����Ƭ
	 */
	public boolean sfbpzp = false;

	/**
	 * cng ���״̬
	 */
	public String cngstate = "0";

	/**
	 * cng ���״̬
	 */
	public String sfwcpz = "0";

	/**
	 * �ж������б�����Ǵ��ĸ�������� 0��������¼ 1�����ս���
	 */
	public String topaizhao = "1";

	public String FromPzlistToPzlx = "";
	public String FromWjlistToWjItem = "";
	public String FromCylistToCyItem = "";
	public String FromDTDPlistToDTDPItem = "";
	public String FromReTakeToPz = "";
	/**
	 * ��ʱ��� ��½ʱ �����Ŀ �Ƿ�ѡ��
	 */
	public String ls = "0";
	public String wjpz = "0";
	public String rgwj = "0";
	public String str = null;
	public boolean b = false;
	public boolean zdy = false;
	public boolean dptjfh;// �жϵ��������ύ�����ؽ�����ߺ���ʾ������
	public boolean isopent = false;// �ֵ�Ͳ����
	public String jyysfzh = "";
	public long sjc = 0; // ʱ���
	public String fromLoginToInit = "";
	public boolean isQuery = false;
	public String pdyj = "1"; // 1.�Ϲ��� 2.�¹���
	public List<String> car_jyxm = null;
	public List<String> car_ywcjyxm = null;
	public String ggbh = ""; // ������
	public boolean isFromGGBD = false; // �Ƿ�ӹ��������ת
	public String ggcxlx = "";

	/**
	 * �ָ�Ĭ��ֵ
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
	 * �ַ���MD5����
	 * 
	 * @param msgString
	 *            �����ַ���
	 * @return
	 */
	public String MD5(String msgString) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = msgString.getBytes();
			// ���MD5ժҪ�㷨�� MessageDigest ����
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// ʹ��ָ�����ֽڸ���ժҪ
			mdInst.update(btInput);
			// �������
			byte[] md = mdInst.digest();
			// ������ת����ʮ�����Ƶ��ַ�����ʽ
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

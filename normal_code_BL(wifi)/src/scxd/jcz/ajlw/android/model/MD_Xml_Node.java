package scxd.jcz.ajlw.android.model;

/**
 * �洢xml�ֶ�ʵ����
 * @author xxy
 *
 */
public class MD_Xml_Node {


	/**
	 * �洢xml�ֶ�
	 */
	//��Ϣ����
	public String code;
	//��Ϣ
	public String message;
	//�б�����
	public String rownum;
	//�����ˮ��
	public String jclsh;
	//��������
	public String hpzl;
	//��������
	public String cllx;
	//���ƺ���
	public String hphm;
	//����ʶ�����
	public String clsbdh;
	//ʹ������
	public String syxz ;
	//������
	public String jclb ;
	//����id
	public String car_id;
	public String clpp1;
	public String clxh;
	//0���պ��˹�δ���  1 ������� 2 �˹����
	public String sfwcpz;
	public String sfzdy;
	public String wjtd;
	
	public String cngstate;
	/**
	 * �洢xml�ֶι��췽��
	 * @param code ���ش���
	 * @param message������Ӧ��Ϣ
	 * @param rownum���ؽ��յ�������
	 * @param jclsh������ˮ��
	 * @param hpzl��������
	 * @param hphm���ƺ���
	 * @param clsbdh����ʶ�����(VIN)
	 * @param cllx ��������
	 * @param sfwcpz 0���պ��˹�δ���  1 ������� 2 �˹����
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

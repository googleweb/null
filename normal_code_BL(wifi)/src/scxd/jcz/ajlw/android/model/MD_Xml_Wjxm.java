package scxd.jcz.ajlw.android.model;

/**
 * ���������Ŀʵ��
 * @author xxy
 *
 */
public class MD_Xml_Wjxm {

	//������Ϣ����
	public String message;
	//����code���� 0:�ɹ� 1:ʧ�� $E:�쳣��Ϣ
	public String code;
	//��ˮ��
	public String jclsh;
	//��Ŀ����
	public String name;
	//��Ŀ���
	public String wjcode;
	//��Ŀid
	public String id;
	//�����
	public String property="0";
	
	/**
	 * ���췽��-����ֵ
	 * @param message ������Ϣ����
	 * @param code ���� 0:�ɹ� 1:ʧ�� $E:�쳣��Ϣ
	 * @param jclsh ��ˮ��
	 * @param name ��Ŀ����
	 * @param wjcode ��Ŀ���
	 */
	public   MD_Xml_Wjxm(String message,String code,String jclsh,String name,String wjcode,String id,String property) {
		this.code=code;
		this.jclsh=jclsh;
		this.message = message;
		this.name= name;
		this.wjcode = wjcode;
		this.id = id;
		this.property=property;
	}
}

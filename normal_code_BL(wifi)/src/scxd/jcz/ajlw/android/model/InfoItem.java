package scxd.jcz.ajlw.android.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * ��Ŀ �����
 * @author wdn
 *
 */
public abstract class InfoItem extends LinearLayout{
	
	/**
	 * ��Ŀ ��Ϣ xml��ʾ
	 */
	protected String xml = "" ;
	protected String title = "" ;
	protected Context context ;
	
	/**
	 * @param context ������
	 * @param viewId ��ͼid	
	 * @param xml xml��ǩ
	 * @param title ����
	 */
	public InfoItem(Context context, int viewId ,String xml ,String title) {
		super(context);
		this.context = context ;
		this.xml = xml ;
		this.title = title ;
		LayoutInflater.from(context).inflate(viewId, this) ;
		this.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT)) ;
	}
	/**
	 * ��ʽ�� xml ��� ��Ŀ����
	 * @param data
	 * @return
	 */
	public String getData2Xml(){
		String result = getData() ;
		if(!result.equals(""))
			result = String.format("<"+xml.split(",")[0]+">%s</"+xml.split(",")[0]+">", result);
		return result ;
	}
	
	/**
	 * xml��� ƥ��
	 * @param xmlKey
	 * @return
	 */
	public boolean xmlMatch(String xmlKey){
		String[] xmls = this.xml.split(",") ;
		for (String xml : xmls) {
			if(xmlKey.equals(xml))
				return true ;
		}
		return false ;
	}
	
	/**
	 * Log
	 * @return ��ƥ�� null  ��ƥ�� "��ʾ"
 	 */
	protected String Log(){
		if(!isMatch())
			return "���ʵ��Ŀ: \"" + this.title + "\"";
		else
			return null ;
	}

	/**
	 * ��ȡ ��Ŀ���� (ԭʼ����)
	 * @return Ĭ�� ""
	 */
	public abstract String getData() ;
	
	
	/**
	 * ���� ��������
	 */
	public abstract void setData(String data) ;
	public abstract void setData(String data,boolean b) ;
	
	/**
	 * ��Ŀ �Ƿ����(�Ƿ�Ϊ��)
	 */
	public abstract boolean isPassed() ;
	
	/**
	 * ������ʽ��� ���� �Ƿ�Ϸ�Ҫ��
	 */
	public abstract boolean isMatch() ;
	
	/**
	 * ����  Ĭ��
	 */
	public abstract void setDefault() ;
}

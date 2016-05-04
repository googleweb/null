package scxd.jcz.ajlw.android.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * 项目 虚基类
 * @author wdn
 *
 */
public abstract class InfoItem extends LinearLayout{
	
	/**
	 * 项目 信息 xml标示
	 */
	protected String xml = "" ;
	protected String title = "" ;
	protected Context context ;
	
	/**
	 * @param context 上下文
	 * @param viewId 试图id	
	 * @param xml xml标签
	 * @param title 标题
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
	 * 格式化 xml 输出 项目数据
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
	 * xml结点 匹配
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
	 * @return 已匹配 null  不匹配 "提示"
 	 */
	protected String Log(){
		if(!isMatch())
			return "请核实项目: \"" + this.title + "\"";
		else
			return null ;
	}

	/**
	 * 获取 项目数据 (原始数据)
	 * @return 默认 ""
	 */
	public abstract String getData() ;
	
	
	/**
	 * 加载 已有数据
	 */
	public abstract void setData(String data) ;
	public abstract void setData(String data,boolean b) ;
	
	/**
	 * 项目 是否完成(是否为空)
	 */
	public abstract boolean isPassed() ;
	
	/**
	 * 正则表达式检测 数据 是否合服要求
	 */
	public abstract boolean isMatch() ;
	
	/**
	 * 重置  默认
	 */
	public abstract void setDefault() ;
}

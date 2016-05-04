package scxd.jcz.ajlw.android.model;

import scxd.jcz.ajlw.android.Activity.R;
import android.content.Context;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
/**
 * 自定义单选框
 * @author CXY
 *
 */
public class InfoItemRdoGrpStyle4 extends InfoItem {

	private RadioGroup rdoGroup ;
	private String defaultValue ;
	
	/**
	 * 
	 * @param context
	 * @param title 标题
	 * @param xml 传输和 加载数据匹配xml
	 * @param defaultValue 默认 1:是 0:否
	 */
	public InfoItemRdoGrpStyle4(Context context ,String title ,String xml ,String defaultValue) {
		super(context, R.layout.item_type_rdogrp_style4, xml, title);
		this.defaultValue = defaultValue ;
		rdoGroup = (RadioGroup)findViewById(R.id.item_content_rdogrp) ;
		TextView titleTxt = (TextView) findViewById(R.id.item_title_txt) ;
		titleTxt.setText(title + " : ") ;
		setData(defaultValue) ;
	}
	/**
	 * 
	 * @param context
	 * @param title
	 * @param xml
	 * @param showValues 单选标签(,号分割)
	 * @param defaultValue
	 */
	public InfoItemRdoGrpStyle4(Context context ,String title ,String xml ,String showValues , String values, String defaultValue) {
		super(context, R.layout.item_type_rdogrp_style4, xml, title);
		rdoGroup = (RadioGroup)findViewById(R.id.item_content_rdogrp) ;
		TextView titleTxt = (TextView) findViewById(R.id.item_title_txt) ;
		titleTxt.setText(title + " : ") ;
		setData(defaultValue) ;
		try {
			String split[] = showValues.split(",") ;
			RadioButton yesBtn = (RadioButton)findViewById(R.id.item_rdo_yes) ;
			RadioButton noBtn = (RadioButton)findViewById(R.id.item_rdo_no) ;
			yesBtn.setText(split[0]) ;
			noBtn.setText(split[1]) ;
			split = values.split(",") ;
			yesBtn.setTag(split[0]) ;
			noBtn.setTag(split[1]) ;
		} catch (Exception e) { }
	}

	@Override
	public String getData() {
		return findViewById(rdoGroup.getCheckedRadioButtonId()).getTag().toString() ;
	}
	
	@Override
	public void setData(String data) {
		if(data == null){
			rdoGroup.clearCheck() ;
		} else if (data.equals("1")) {
			rdoGroup.check(R.id.item_rdo_yes) ;
		} else {
			rdoGroup.check(R.id.item_rdo_no) ;
		}
	}

	@Override
	public boolean isPassed() {
		return rdoGroup.getCheckedRadioButtonId() != -1;
	}

	@Override
	public boolean isMatch() {
		Log.e("null", (rdoGroup.getCheckedRadioButtonId() != -1)+"") ;
		return isPassed();
	}

	@Override
	public void setDefault() {
		setData(defaultValue) ;
	}
	@Override
	public void setData(String data, boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}

package scxd.jcz.ajlw.android.model;

import scxd.jcz.ajlw.android.Activity.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * 路试项目
 * @author wdn
 *
 */
public class LsItem extends LinearLayout {

	private String itemXml ;
	private EditText dataEdit ;
	
	public LsItem(Context context ,String xmlTitle ,int number ,String title ,String dataTitle ,int inputType) {
		super(context);
		this.itemXml = xmlTitle ;
		LayoutInflater.from(context).inflate(R.layout.item_type_edt_rdogrp, this) ;
		TextView titleTextView = (TextView) findViewById(R.id.ls_item_txt_title) ;
		TextView dataTitleTextView = (TextView) findViewById(R.id.ls_item_txt_data_title) ;
		titleTextView.setText(number + ". " + title) ;
		dataTitleTextView.setText(dataTitle + " :") ;
		dataEdit = (EditText) this.findViewById(R.id.ls_item_edit_data) ;
		dataEdit.setInputType(inputType);
	}
	
	/**
	 * 显示 数据
	 * @param data
	 * @param isPass
	 */
	public void setData(String data ,boolean isPass){
		dataEdit = (EditText) this.findViewById(R.id.ls_item_edit_data) ;
		
		dataEdit.setText(data) ;
		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.ls_item_radioGroup) ;
		if(isPass){
			radioGroup.check(R.id.radio0) ;
		}else{
			radioGroup.check(R.id.radio1) ;
		}
	}
	
	/**
	 * 获取项目 信息
	 * @return  xml
	 */
	public String getData(){
		
		dataEdit = (EditText) this.findViewById(R.id.ls_item_edit_data) ;
		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.ls_item_radioGroup) ;
		String data = dataEdit.getText().toString().trim().replace(" " ,"") ;
		int ispass = radioGroup.getCheckedRadioButtonId()==R.id.radio0 ? 1:2 ;
		String itemForXml = "" ;
		if(!data.equals("")){
			itemForXml = String.format(
				"<"+this.itemXml+">%s</"+this.itemXml+">" +
				"<"+this.itemXml+"pd>%s</"+this.itemXml+"pd>", 
				data,
				ispass+"") ;
		}else {
			itemForXml = "" ;
		}
		return itemForXml;
	}
	/**
	 * 是否 合格
	 * @return
	 */
	public boolean isPass(){
		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.ls_item_radioGroup) ;
		if(radioGroup.getId() - radioGroup.getCheckedRadioButtonId() == 2)
			return false ;
		else
			return true ;
	}
	
	public void setDisable(){
		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.ls_item_radioGroup) ;
		radioGroup.getChildAt(0).setClickable(false) ;
		radioGroup.getChildAt(1).setClickable(false) ;
		dataEdit.setEnabled(false) ;
	}
	
}

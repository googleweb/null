package scxd.jcz.ajlw.android.model;

import scxd.jcz.ajlw.android.Activity.R;
import android.content.Context;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * ��ѡ�� ��Ŀ
 * @author wdn
 *
 */
public class InfoItemRdoGrpStyle1 extends InfoItem {

	private RadioGroup rdoGroup ;
	private RgjyItem.Item item ;
	
	public InfoItemRdoGrpStyle1(Context context ,RgjyItem.Item item) {
		super(context, R.layout.item_type_rdogrp_style1, "", "");
		this.item = item ;
		rdoGroup = (RadioGroup)findViewById(R.id.item_content_rdogrp) ;
		TextView title = (TextView) findViewById(R.id.item_title_txt) ;
		title.setMaxLines(3);
		title.setText(item.id + "." + item.name) ;
	}

	@Override
	public String getData() {
		return findViewById(rdoGroup.getCheckedRadioButtonId()).getTag().toString() ;
	}
	
	@Override
	public void setData(String data) {
		
	}
	//ȡ�ϸ���
	@Override
	public boolean isPassed() {
		return findViewById(rdoGroup.getCheckedRadioButtonId()).getTag().equals("1") ;
	}
	//ȡ���ϸ���
	public boolean isUnPassed(){
		return findViewById(rdoGroup.getCheckedRadioButtonId()).getTag().equals("2") ;
	}

	@Override
	//ȡ���漰��
	public boolean isMatch() {
		return findViewById(rdoGroup.getCheckedRadioButtonId()).getTag().equals("3") ;
	}

	@Override
	public void setDefault() {
		// TODO ����
	}

	@Override
	public void setData(String data, boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}

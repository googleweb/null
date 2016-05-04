package scxd.jcz.ajlw.android.model;

import scxd.jcz.ajlw.android.Activity.R;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * 复选框 项目
 * 
 * @author wdn
 */
public class InfoItemRdoGrpStyle2 extends InfoItem {

	private RadioGroup rdoGroup;
	private RgjyItem.Item item;
	private RadioButton item_rdo_yes, item_rdo_no;
	private EditText bhgyy;

	public InfoItemRdoGrpStyle2(Context context, RgjyItem.Item item) {
		super(context, R.layout.item_type_rdogrp_style2, "", "");
		this.item = item;
		rdoGroup = (RadioGroup) findViewById(R.id.item_content_rdogrp);
		TextView titleTxt = (TextView) findViewById(R.id.item_title_txt);
		titleTxt.setText(title + " : ");
		titleTxt.setMaxLines(3);
		titleTxt.setText(item.id + "." + item.name);
	}

	public InfoItemRdoGrpStyle2(Context context, RgjyItem.Item item, String yl) {
		super(context, R.layout.item_type_rdogrp_style2, "", "");
		this.item = item;
		rdoGroup = (RadioGroup) findViewById(R.id.item_content_rdogrp);
		item_rdo_yes = (RadioButton) findViewById(R.id.item_rdo_yes);
		item_rdo_no = (RadioButton) findViewById(R.id.item_rdo_no);
		bhgyy = (EditText) findViewById(R.id.bhgyy);
		item_rdo_yes.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_no.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		item_rdo_no.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_no.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		TextView titleTxt = (TextView) findViewById(R.id.item_title_txt);
		titleTxt.setText(title + " : ");
		titleTxt.setMaxLines(3);
//		titleTxt.setText(item.id + "." + item.name);
		titleTxt.setText(item.name);
	}

	public InfoItemRdoGrpStyle2(Context context, RgjyItem.Item item,
			Boolean sfltxs, Boolean yes) {
		super(context, R.layout.item_type_rdogrp_style2, "", "");
		this.item = item;
		rdoGroup = (RadioGroup) findViewById(R.id.item_content_rdogrp);
		item_rdo_yes = (RadioButton) findViewById(R.id.item_rdo_yes);
		item_rdo_no = (RadioButton) findViewById(R.id.item_rdo_no);
		bhgyy = (EditText) findViewById(R.id.bhgyy);
		item_rdo_yes.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_no.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		item_rdo_no.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_no.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		TextView titleTxt = (TextView) findViewById(R.id.item_title_txt);
		titleTxt.setText(title + " : ");
		if (sfltxs) {
			titleTxt.setTextColor(Color.RED);
		}
		if (yes) {
			item_rdo_yes.setChecked(true);
		} else {
			item_rdo_no.setChecked(true);
		}
		titleTxt.setMaxLines(3);
		titleTxt.setText(item.name);
	}

	@Override
	public String getData() {
		return item.id + ",";
	}
	public String getItemID() {
		return item.id;
	}
	public String getBhgyy() {
		if ("".equals(bhgyy.getText().toString().trim())) {
			return "";
		}
		return bhgyy.getText().toString();
	}

	@Override
	public void setData(String data) {
	}

	// 取合格项
	@Override
	public boolean isPassed() {
		return findViewById(rdoGroup.getCheckedRadioButtonId()).getTag()
				.equals("1");
	}

	// 取不合格项
	public boolean isUnPassed() {
		return findViewById(rdoGroup.getCheckedRadioButtonId()).getTag()
				.equals("0");
	}

	@Override
	public boolean isMatch() {
		return true;
	}

	@Override
	public void setDefault() {
	}

	@Override
	public void setData(String data, boolean b) {
		// TODO Auto-generated method stub
		
	}

}

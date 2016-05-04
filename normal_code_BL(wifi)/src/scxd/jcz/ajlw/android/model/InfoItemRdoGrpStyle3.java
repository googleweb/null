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
 * 
 */
public class InfoItemRdoGrpStyle3 extends InfoItem {

	private RadioGroup rdoGroup;
	private RadioButton item_rdo_hg, item_rdo_bhg, item_rdo_jywh;
	private RgjyItem.Item item;
	private EditText bhgyy;

	public InfoItemRdoGrpStyle3(Context context, RgjyItem.Item item) {
		super(context, R.layout.item_type_rdogrp_style3, "", "");
		this.item = item;
		rdoGroup = (RadioGroup) findViewById(R.id.item_content_rdogrp);
		item_rdo_hg = (RadioButton) findViewById(R.id.item_rdo_hg);
		item_rdo_bhg = (RadioButton) findViewById(R.id.item_rdo_bhg);
		item_rdo_jywh = (RadioButton) findViewById(R.id.item_rdo_jywh);
		bhgyy = (EditText) findViewById(R.id.bhgyy);
		item_rdo_jywh.setChecked(true);
		item_rdo_hg.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_bhg.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		item_rdo_bhg.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_bhg.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		item_rdo_jywh.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_bhg.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		TextView title = (TextView) findViewById(R.id.item_title_txt);
		title.setMaxLines(3);
		title.setText(item.name);
	}

	public InfoItemRdoGrpStyle3(Context context, RgjyItem.Item item,
			boolean sfltxs, String onetothree) {
		super(context, R.layout.item_type_rdogrp_style3, "", "");
		this.item = item;
		rdoGroup = (RadioGroup) findViewById(R.id.item_content_rdogrp);
		item_rdo_hg = (RadioButton) findViewById(R.id.item_rdo_hg);
		item_rdo_bhg = (RadioButton) findViewById(R.id.item_rdo_bhg);
		item_rdo_jywh = (RadioButton) findViewById(R.id.item_rdo_jywh);
		bhgyy = (EditText) findViewById(R.id.bhgyy);
		TextView titleTxt = (TextView) findViewById(R.id.item_title_txt);
		if (sfltxs) {
			titleTxt.setTextColor(Color.RED);
		}
		if ("0".equals(onetothree)) {
			item_rdo_hg.setChecked(true);
		} else if ("1".equals(onetothree)) {
			item_rdo_bhg.setChecked(true);
		} else {
			item_rdo_jywh.setChecked(true);
		}
		
		item_rdo_hg.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_bhg.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		item_rdo_bhg.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_bhg.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		item_rdo_jywh.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_rdo_bhg.isChecked()) {
					bhgyy.setText("");
					bhgyy.setVisibility(View.VISIBLE);
				} else {
					bhgyy.setVisibility(View.GONE);
				}
			}
		});
		titleTxt.setText(title + " : ");
		titleTxt.setMaxLines(3);
		titleTxt.setText(item.name);
	}

	@Override
	public String getData() {
		return item.id + ",";
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
				.equals("2");
	}

	@Override
	// 取不涉及项
	public boolean isMatch() {
		return findViewById(rdoGroup.getCheckedRadioButtonId()).getTag()
				.equals("3");
	}

	@Override
	public void setDefault() {
		// TODO 暂无
	}
	public String getBhgyy() {
		if ("".equals(bhgyy.getText().toString().trim())) {
			return "";
		}
		return bhgyy.getText().toString();
	}

	@Override
	public void setData(String data, boolean b) {
		// TODO Auto-generated method stub
		
	}


}

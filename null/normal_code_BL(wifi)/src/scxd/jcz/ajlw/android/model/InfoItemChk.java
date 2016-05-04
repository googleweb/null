package scxd.jcz.ajlw.android.model;

import scxd.jcz.ajlw.android.Activity.R;
import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * 单选 项目
 * 
 * @author wdn
 * 
 */
public class InfoItemChk extends InfoItem {

	private CheckBox checkBox;
	private Context con;

	/**
	 * 
	 * @param context
	 * @param title
	 *            标题
	 * @param xml
	 *            上传 和 加载数据匹配xml
	 * @param defaultValue
	 *            默认是否选中
	 */
	public InfoItemChk(Context context, String title, final String xml,
			boolean defaultValue) {
		super(context, R.layout.item_type_chk, xml, title);
		this.con=context;
		this.xml = xml;
		this.checkBox = (CheckBox) findViewById(R.id.carlogin_item_checkBox);
		TextView titleTextView = (TextView) findViewById(R.id.carlogin_item_txt);
		titleTextView.setText(title + " : ");
		// 设置默认
					checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						
						@Override
						public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
							if(xml.equals("A1"))
							{
								if(isChecked){
								Intent itt=new Intent("ATION_CHECK");
								con.sendBroadcast(itt);
								}
							}
							
						}
					});
		this.checkBox.setChecked(defaultValue);
	}

	@Override
	public String getData() {
		return this.checkBox.isChecked() ? xml : "";
	}

	@Override
	public void setData(String data) {
		if (data.equals("1"))
			this.checkBox.setChecked(true);
		else
			this.checkBox.setChecked(false);
	}

	@Override
	public boolean isPassed() {
		return true;
	}

	@Override
	public boolean isMatch() {
		return true;
	}

	@Override
	public void setDefault() {
		this.checkBox.setChecked(true);
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		this.checkBox.setEnabled(enabled);
	}

	@Override
	public void setData(String data, boolean b) {
		if (data.equals("1"))
			this.checkBox.setChecked(true);
		else
			this.checkBox.setChecked(false);
		
	}

}

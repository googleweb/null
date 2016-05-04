package scxd.jcz.ajlw.android.model;

import scxd.jcz.ajlw.android.Activity.R;
import android.content.Context;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * 文本框 项目
 * @author wdn
 *
 */
public class InfoItemEdtGrp extends InfoItem {

	private EditText edit ;
	private RadioGroup rdoGroup ;
	private int id ;
	
	public InfoItemEdtGrp(Context context, int id, String title) {
		super(context, R.layout.item_type_rdo_edt, "" ,title) ;
		this.id = id ;
		this.edit = (EditText) findViewById(R.id.carlogin_item_edit) ;
		EditText titleTxt = (EditText) findViewById(R.id.item_txt) ;
		titleTxt.setText(id+". "+ title + " :") ;
		this.rdoGroup = (RadioGroup) findViewById(R.id.item_rdogroup) ;
	}

	@Override
	public String getData() {
		return edit.getText().toString().toUpperCase().trim().replace(" ", "");
	}
	
	@Override
	public String getData2Xml() {
		// TODO Auto-generated method stub
		String resoult = String.format(
				"<item>" +
				"<code>%s</code>" +
				"<jl>%s</jl>" +
				"<msg>%s</msg>" +
				"</item>", 
				this.id,
				this.findViewById(rdoGroup.getCheckedRadioButtonId()).getTag(),
				this.edit.getText()) ;
		return resoult;
	}
	
	@Override
	public void setData(String data) {
		
	}

	@Override
	public boolean isPassed() {
		return true;
	}
	
	@Override
	public boolean isMatch() {
		return true ;
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		this.edit.setEnabled(enabled) ;
//		this.edit.setText("") ;
//		if(!enabled){
//			this.edit.setHint("不用输入") ;
//		}else{
//			this.edit.setHint("") ;
//		}
	}
	
	@Override
	public void setDefault() {
		// TODO 暂无
	}

	@Override
	public void setData(String data, boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}

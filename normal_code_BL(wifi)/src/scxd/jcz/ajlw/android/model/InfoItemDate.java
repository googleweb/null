package scxd.jcz.ajlw.android.model;

import scxd.jcz.ajlw.android.Activity.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
/**
 * 时间项目
 * @author Administrator
 *
 */
public class InfoItemDate extends InfoItem {

	private EditText dateEdt ;
	
	public InfoItemDate(Context context, String xml, String title) {
		super(context, R.layout.item_type_dp, xml, title);
		// TODO Auto-generated constructor stub
		this.dateEdt = (EditText) findViewById(R.id.item_date_edt) ;
		TextView titleTextView = (TextView) findViewById(R.id.item_title) ;
		titleTextView.setText(title + " : ") ;
		this.dateEdt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog() ;
			}
		}) ;
		
	}

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return dateEdt.getText().toString().trim();
	}

	@Override
	public void setData(String data) {
		// TODO Auto-generated method stub
//		if(dateEdt.getText().equals("")){ //空 才 添加数据
			try {
				dateEdt.setText("") ; //先清空 
//				dateEdt.setText(new SimpleDateFormat("yyyy-MM-dd").parse(data).toString());
				if(!TextUtils.isEmpty(data)){
				dateEdt.setText(data.substring(0,10).trim());
				}
//				dateEdt.setText(data.substring(0, 4) + "-" + data.substring(4, 6) + "-" + data.substring(6)) ;
			} catch (Exception e) {
				Log.e(this.title, data + "日期格式加载异常") ;
			}
//		}
	}

	@Override
	public boolean isPassed() {
		// TODO Auto-generated method stub
		return !dateEdt.getText().toString().trim().equals("");
	}

	@Override
	public boolean isMatch() {
		// TODO Auto-generated method stub
		return true;
	}

	private void dialog(){
		final DatePicker datePicker = new DatePicker(this.context) ;
		
		new AlertDialog.Builder(this.context)
		.setTitle("请选择日期 :")
		.setView(datePicker)
		.setCancelable(true)
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String year=(datePicker.getYear()+"").trim();
				String mon=((datePicker.getMonth()+1)+"").trim();
				String day=(datePicker.getDayOfMonth()+"").trim();
				if(mon.length()==1){
					mon="0"+mon;
				}
				if(day.length()==1){
					day="0"+day;
				}
				dateEdt.setText(year+"-"+mon+"-"+day) ;
			}
		}).show();
	}
	
	@Override
	public void setDefault() {
		this.dateEdt.setText("") ;
	}

	@Override
	public void setData(String data, boolean b) {
		// TODO Auto-generated method stub
//		if(dateEdt.getText().equals("")){ //空 才 添加数据
			try {
				dateEdt.setText("") ; //先清空 
//				dateEdt.setText(new SimpleDateFormat("yyyy-MM-dd").parse(data).toString());
				if(!TextUtils.isEmpty(data)){
				dateEdt.setText(data.substring(0,10).trim());
				}
//				dateEdt.setText(data.substring(0, 4) + "-" + data.substring(4, 6) + "-" + data.substring(6)) ;
			} catch (Exception e) {
				Log.e(this.title, data + "日期格式加载异常") ;
			}
//		}
		
	}
}

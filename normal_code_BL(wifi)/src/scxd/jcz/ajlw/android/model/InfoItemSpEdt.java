package scxd.jcz.ajlw.android.model;

import java.util.List;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * 下拉列表+文本框 项目
 * 
 * @author wdn
 * 
 */
public class InfoItemSpEdt extends InfoItem {

	private EditText edit;
	private Spinner spinner;
	private String match;

	/**
	 * 重载 String[]
	 * 
	 * @param context
	 * @param title
	 * @param xml
	 * @param spinnerData
	 * @param inputLimit
	 * @param match
	 */
	public InfoItemSpEdt(Context context, String title, String xml,
			String[] spinnerData, int inputLimit, String match) {
		super(context, R.layout.item_type_sp_edt, xml, title);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
				android.R.layout.simple_spinner_item, spinnerData);
		this.init(context, title, xml, adapter, inputLimit, match);
	}

	/**
	 * 重载 List<Md_cartype>
	 * 
	 * @param context
	 * @param title
	 * @param xml
	 * @param spinnerData
	 * @param inputLimit
	 * @param match
	 */
	private ArrayAdapter<Md_cartype> adapter;

	public InfoItemSpEdt(Context context, String title, String xml,
			List<Md_cartype> spinnerData, int inputLimit, String match) {
		super(context, R.layout.item_type_sp_edt, xml, title);
		adapter = new ArrayAdapter<Md_cartype>(context,
				android.R.layout.simple_spinner_item, spinnerData);
		this.init(context, title, xml, adapter, inputLimit, match);
	}

	private void init(Context context, String title, String xml,
			ArrayAdapter adapter, int inputLimit, String match) {
		this.xml = xml;
		this.match = match;
		this.edit = (EditText) findViewById(R.id.carlogin_item_edit);
		this.spinner = (Spinner) findViewById(R.id.carlogin_item_spinner);
		TextView titleTextView = (TextView) findViewById(R.id.carlogin_item_txt);
		titleTextView.setText(title + " : ");
		edit.setInputType(inputLimit);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner.setAdapter(adapter);
	}

	@Override
	public String getData() {
		String spinnerValue = "";
		String editValue = edit.getText().toString().toUpperCase().trim()
				.replace(" ", "");
		try {
			// 为string 时 会异常
			spinnerValue = ((Md_cartype) spinner.getSelectedItem()).getName();
		} catch (Exception e) {
			spinnerValue = spinner.getSelectedItem().toString();
		}
		if (!editValue.equals(""))
			return spinnerValue + editValue;
		else
			return "";
	}

	@Override
	public void setData(String data) {
		if ("".equals(data)) {
			return;
		}
		try {
			if (xml.equals("hphm")) {
				if (Md_Car_Temp.getTempCar().isQuery) {

				} else {
					String sfs = MD_ListItem.Get_sfs(data.substring(0, 1));
					if ("".equals(sfs)) {
						edit.setText(data);
					} else {
						edit.setText(data.substring(1, data.length()));
						this.spinner.setSelection(MD_ListItem.MatchIndex(sfs,
								MD_ListItem.Get_sf()));
						// if (Md_Car_Temp.getTempCar().isQuery) {
						// edit.setText(data.substring(1, data.length()));
						// this.spinner.setSelection(MD_ListItem.MatchIndex(sfs,
						// MD_ListItem.Get_sf()));
						// // edit.setText(data);
						// } else {
						// edit.setText(data.substring(1, data.length()));
						// this.spinner.setSelection(MD_ListItem.MatchIndex(sfs,
						// MD_ListItem.Get_sf()));
						// }
					}
				}
			} else {
				edit.setText(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isPassed() {
		boolean isPass = false;
		try {
			isPass = !spinner.getSelectedItem().toString().equals("")
					&& !edit.getText().toString().trim().equals("");
		} catch (Exception e) {
			isPass = false;
		}
		return isPass;
	}

	@Override
	public boolean isMatch() {
		if (match != null)
			return edit.getText().toString().trim().replace(" ", "")
					.matches(this.match);
		return true;
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		this.edit.setEnabled(enabled);
		// this.spinner.setEnabled(enabled) ;
		this.edit.setText("");
		if (!enabled) {
			this.edit.setHint("");
		} else {
			this.edit.setHint("");
		}
	}

	@Override
	public void setFocusable(boolean focusable) {
		super.setFocusable(focusable);
		this.spinner.setFocusable(focusable);
		this.spinner.setFocusableInTouchMode(focusable);
		this.edit.setFocusable(focusable);
		this.edit.setFocusableInTouchMode(focusable);
		if (!focusable) {
			this.edit.setText("无");
		} else {
			this.edit.setText("");
		}
	}

	@Override
	public void setDefault() {
		this.edit.setText("");
		this.spinner.setSelection(0);
	}
 /* public void setSpinnerdata(int position) {
	  this.spinner.setSelection(position);
  }*/

	@Override
	public void setData(String data, boolean b) {
		if ("".equals(data)) {
			return;
		}
		try {
			if (xml.equals("hphm")) {
				if (Md_Car_Temp.getTempCar().isQuery) {

				} else {
					String sfs = MD_ListItem.Get_sfs(data.substring(0, 1));
					if ("".equals(sfs)) {
						edit.setText(data);
					} else {
						edit.setText(data.substring(1, data.length()));
						this.spinner.setSelection(MD_ListItem.MatchIndex(sfs,
								MD_ListItem.Get_sf()));
						// if (Md_Car_Temp.getTempCar().isQuery) {
						// edit.setText(data.substring(1, data.length()));
						// this.spinner.setSelection(MD_ListItem.MatchIndex(sfs,
						// MD_ListItem.Get_sf()));
						// // edit.setText(data);
						// } else {
						// edit.setText(data.substring(1, data.length()));
						// this.spinner.setSelection(MD_ListItem.MatchIndex(sfs,
						// MD_ListItem.Get_sf()));
						// }
					}
				}
			} else {
				edit.setText(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

package scxd.jcz.ajlw.android.model;

import java.util.List;

import scxd.jcz.ajlw.android.Activity.R;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 下拉列表 项目
 * 
 * @author wdn
 * 
 */
public class InfoItemSp extends InfoItem {

	private Spinner spinner;
	private List<Md_cartype> listData = null;
	private String[] arrData = null;

	/**
	 * 重载 String[]
	 * 
	 * @param context
	 * @param title
	 * @param xml
	 * @param arrData
	 * @param selectAction
	 */
	public InfoItemSp(Context context, String title, String xml,
			String[] arrData, OnItemSelectedListener selectAction) {
		super(context, R.layout.item_type_sp, xml, title);
		this.setTitle(context, title);
		setAdapter(arrData, selectAction);
	}

	/**
	 * 重载 List<Md_cartype>
	 * 
	 * @param context
	 * @param title
	 * @param xml
	 * @param listData
	 * @param selectAction
	 */
	public InfoItemSp(Context context, String title, String xml,
			List<Md_cartype> listData, OnItemSelectedListener selectAction) {
		super(context, R.layout.item_type_sp, xml, title);
		this.setTitle(context, title);
		setAdapter(listData, selectAction);
	}

	private void setTitle(Context context, String title) {
		this.spinner = (Spinner) findViewById(R.id.carlogin_item_spinner);
		TextView titleTextView = (TextView) findViewById(R.id.carlogin_item_txt);
		titleTextView.setText(title + " : ");
	}

	@Override
	public String getData() {
		String spinnerValue = "";
		try {
			spinnerValue = ((Md_cartype) spinner.getSelectedItem()).getName();
		} catch (Exception e) {
			spinnerValue = spinner.getSelectedItem().toString();
		}
		return spinnerValue;
	}

	/**
	 * 遍历 数据集 找到 index 设置下拉列表选中该index
	 */
	@Override
	public void setData(String data) {
		int index = 0; // 要选中得序号
		try {
			// TODO: 数据为 列表
			for (int i = 0; i < listData.size(); i++) {
				if (listData.get(i).getName().equals(data)) {
					index = i;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: 数据为 字符串
			for (int i = 0; i < arrData.length; i++) {
				if (arrData[i].equals(data)) {
					index = i;
					break;
				}
			}
		}
		this.spinner.setSelection(index);
	}

	@Override
	public boolean isPassed() {
		boolean isPass = false;
		try {
			isPass = !spinner.getSelectedItem().toString().equals("");
		} catch (Exception e) {
			isPass = false;
		}
		return isPass;
	}

	@Override
	public boolean isMatch() {
		String spinnerValue = "";
		try {
			spinnerValue = ((Md_cartype) spinner.getSelectedItem()).getName();
		} catch (Exception e) {
			spinnerValue = spinner.getSelectedItem().toString();
		}
		if ("-1".equals(spinnerValue)) {
			spinner.setFocusable(true);
			spinner.requestFocus();
			spinner.requestFocusFromTouch();
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void setDefault() {
		this.spinner.setSelection(0);
	}

	public void setAdapter(String[] arrData, OnItemSelectedListener selectAction) {
		this.arrData = arrData;
		this.listData = null;
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
				android.R.layout.simple_spinner_item, arrData);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner.setAdapter(adapter);
		
		this.spinner.setOnItemSelectedListener(selectAction);
	}

	public void setAdapter(List<Md_cartype> listData,
			OnItemSelectedListener selectAction) {
		this.listData = listData;
		this.arrData = null;
		ArrayAdapter<Md_cartype> adapter = new ArrayAdapter<Md_cartype>(
				context, android.R.layout.simple_spinner_item, listData);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner.setAdapter(adapter);
		this.spinner.setOnItemSelectedListener(selectAction);
	}

	@Override
	public void setData(String data, boolean b) {
		int index = 0; // 要选中得序号
		try {
			// TODO: 数据为 列表
			for (int i = 0; i < listData.size(); i++) {
				if (listData.get(i).getName().equals(data)) {
					index = i;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: 数据为 字符串
			for (int i = 0; i < arrData.length; i++) {
				if (arrData[i].equals(data)) {
					index = i;
					break;
				}
			}
		}
		this.spinner.setSelection(index);

	}

}

package scxd.jcz.ajlw.android.Adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.model.Md_cartype;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class CSYS_Adapter extends BaseAdapter {
	private List<Md_cartype> data;
	private Context con;
	private LayoutInflater mflater;
	private Map<Integer, String> checkMap = new HashMap<Integer, String>();
	PopupWindow popView;
	EditText editText;

	public CSYS_Adapter(List<Md_cartype> data, Context con,
			PopupWindow popView, EditText edit) {
		super();
		this.data = data;
		this.con = con;
		mflater = LayoutInflater.from(con);
		this.popView = popView;
		editText = edit;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHorld viewHorld;
		if (convertView == null) {
			convertView = mflater.inflate(R.layout.llgg_itme, null);
			viewHorld = new ViewHorld();
			viewHorld.auto = (TextView) convertView.findViewById(R.id.text);

			viewHorld.check = (CheckBox) convertView
					.findViewById(R.id.checkBox1);
			convertView.setTag(viewHorld);
		} else {
			viewHorld = (ViewHorld) convertView.getTag();
			// resetViewHolder(viewHorld);
		}
		viewHorld.auto.setText(((Md_cartype) data.get(position)).getValue());
		viewHorld.check.setChecked(checkMap.get(position) == null ? false
				: true);
		/*
		 * viewHorld.check.setOnCheckedChangeListener(new
		 * OnCheckedChangeListener() {
		 * 
		 * @Override public void onCheckedChanged(CompoundButton buttonView,
		 * boolean isChecked) { if(isChecked) { checkMap.put(position,
		 * viewHorld.auto.getText().toString()); }else{ try{
		 * checkMap.remove(position);}catch(Exception e){
		 * 
		 * } }
		 * 
		 * } });
		 */
		viewHorld.check.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				CheckBox cb = (CheckBox) view;
				if (cb.isChecked()) {
					if ("其它".equals(viewHorld.auto.getText().toString())) {
						checkMap.clear();
						checkMap.put(position, viewHorld.auto.getText()
								.toString());
						editText.setText(viewHorld.auto.getText()
								.toString());
						popView.dismiss();

						
					} else {
						if (checkMap.size() <= 2) {
							checkMap.put(position, viewHorld.auto.getText()
									.toString());
						}else{
							cb.setChecked(false);
							Toast.makeText(con, "最多只能选择3种颜色", 1).show();
						}
						
						
					}
				} else {
					try {
						checkMap.remove(position);
					} catch (Exception e) {

					}
				}
			}
		});
		return convertView;
	}

	protected void resetViewHolder(ViewHorld p_ViewHolder) {
		p_ViewHolder.auto.setText(null);
		p_ViewHolder.check.setChecked(false);

	}

	class ViewHorld {
		TextView auto;
		CheckBox check;
	}

	public Map<Integer, String> getCheckDate() {

		return checkMap;

	}

	public void clearMap() {

		checkMap.clear();
	}
}

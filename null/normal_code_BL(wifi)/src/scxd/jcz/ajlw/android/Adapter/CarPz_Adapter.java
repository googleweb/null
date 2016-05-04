package scxd.jcz.ajlw.android.Adapter;

import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 车辆拍照列表适配器
 * @author Administrator
 *@createtime 
 */
public class CarPz_Adapter extends BaseAdapter {

	private LayoutInflater mInflater;
	/**
	 * 存储数据列表
	 */
	private List<Map<String, Object>> mDataList;
	/**
	 * 复选框状态
	 */
	public static Map<Integer, Boolean> isSelected;

	/**
	 * 构造方法
	 * 
	 * @param context
	 */
	public CarPz_Adapter(Context context,
			List<Map<String, Object>> mDataList_in,
			Map<Integer, Boolean> isSelected_in) {
		mInflater = LayoutInflater.from(context);
		mDataList = mDataList_in;
		isSelected = isSelected_in;
	}

	@Override
	public int getCount() {
		return mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	/**
	 * 将参数赋予视图容器，并赋值
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;

		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.car_list_msg, null);
			holder.img = (ImageView) convertView.findViewById(R.id.img);
			holder.car_hphm = (TextView) convertView
					.findViewById(R.id.car_hphm);
			holder.car_cllx = (TextView) convertView
					.findViewById(R.id.car_cllx);
			holder.cBox = (CheckBox) convertView.findViewById(R.id.xm_select);
			holder.vin = (TextView) convertView.findViewById(R.id.car_vin);
			holder.car_hpzl = (TextView) convertView
					.findViewById(R.id.car_hpzl);
			holder.car_cllsh = (TextView) convertView
					.findViewById(R.id.car_cllsh);
			holder.car_sfwcpz = (TextView) convertView
					.findViewById(R.id.car_sfwcpz);
			holder.car_txt_zdy_res = (TextView) convertView
					.findViewById(R.id.car_txt_zdy_res);
			holder.car_id = (TextView) convertView.findViewById(R.id.car_id);
			holder.car_syxz = (TextView) convertView
					.findViewById(R.id.car_syxz);
			holder.car_jclb = (TextView) convertView
					.findViewById(R.id.car_jclb);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.cBox.setChecked(isSelected.get(position));
		holder.img.setBackgroundResource((Integer) mDataList.get(position).get(
				"img"));
		holder.car_hphm.setText(mDataList.get(position).get("car_hphm")
				.toString());
		holder.car_cllx.setText(mDataList.get(position).get("car_cllx")
				.toString());
		holder.vin.setText(mDataList.get(position).get("car_vin").toString());
		holder.car_hpzl.setText(mDataList.get(position).get("car_hpzl")
				.toString());
		holder.car_cllsh.setText(mDataList.get(position).get("car_lsh")
				.toString());
		holder.car_sfwcpz.setText(mDataList.get(position).get("car_sfwcpz")
				.toString());

		holder.car_txt_zdy_res.setText(mDataList.get(position).get("sfzdy")
				.toString());
		holder.car_hphm.setTag(mDataList.get(position).get("syxz").toString());
		holder.car_hpzl.setTag(mDataList.get(position).get("jclb").toString());
		holder.car_id.setTag(mDataList.get(position).get("car_id").toString());
		holder.car_syxz.setTag(mDataList.get(position).get("syxz").toString());
		holder.car_jclb.setTag(mDataList.get(position).get("jclb").toString());
		return convertView;
	}

	public final class ViewHolder {
		public ImageView img;
		public TextView car_hphm;
		public TextView car_cllx;
		public CheckBox cBox;
		public TextView vin;
		public TextView car_hpzl;
		public TextView car_cllsh;
		public TextView car_sfwcpz;
		public TextView car_txt_zdy_res;
		public TextView car_id;
		public TextView car_syxz;
		public TextView car_jclb;
	}

}

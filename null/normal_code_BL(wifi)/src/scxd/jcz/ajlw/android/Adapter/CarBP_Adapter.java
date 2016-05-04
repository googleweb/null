package scxd.jcz.ajlw.android.Adapter;

import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 
 * @author Administrator
 *@createtime
 */
public class CarBP_Adapter extends BaseAdapter {

	private LayoutInflater mInflater;
	/**
	 * 存储数据列表
	 */
	private List<Map<String, Object>> mDataList;

	/**
	 * 构造方法
	 * 
	 * @param context
	 */
	public CarBP_Adapter(Context context, List<Map<String, Object>> mDataList_in) {
		mInflater = LayoutInflater.from(context);
		mDataList = mDataList_in;
	}

	@Override
	public int getCount() {
		return mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		return mDataList.get(position);
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
			convertView = mInflater.inflate(R.layout.car_list_bp_msg, null);
			holder.img = (ImageView) convertView.findViewById(R.id.img);
			holder.car_hphm = (TextView) convertView
					.findViewById(R.id.car_hphm);
			holder.car_jyjl = (TextView) convertView
					.findViewById(R.id.car_jyjl);
			holder.car_vin = (TextView) convertView.findViewById(R.id.car_vin);
			holder.car_dlrq = (TextView) convertView
					.findViewById(R.id.car_dlrq);
			holder.car_jylsh = (TextView) convertView
					.findViewById(R.id.car_jylsh);
			holder.car_hpzl = (TextView) convertView
					.findViewById(R.id.car_hpzl);
			holder.car_jycs = (TextView) convertView
					.findViewById(R.id.car_jycs);
			holder.car_cllx = (TextView) convertView
					.findViewById(R.id.car_cllx);
			holder.car_jylb = (TextView) convertView
					.findViewById(R.id.car_jylb);
			holder.car_syxz = (TextView) convertView
					.findViewById(R.id.car_syxz);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.img.setBackgroundResource((Integer) mDataList.get(position).get(
				"img"));
		holder.car_hphm.setText(mDataList.get(position).get("car_hphm")
				.toString());
		holder.car_jyjl.setText(mDataList.get(position).get("car_jyjl")
				.toString());
		holder.car_vin.setText(mDataList.get(position).get("car_vin")
				.toString());
		holder.car_dlrq.setText(mDataList.get(position).get("car_dlrq")
				.toString());
		holder.car_jylsh.setText(mDataList.get(position).get("car_jylsh")
				.toString());
		holder.car_hpzl.setText(mDataList.get(position).get("car_hpzl")
				.toString());
		holder.car_jycs.setText(mDataList.get(position).get("car_jycs")
				.toString());
		holder.car_cllx.setText(mDataList.get(position).get("car_cllx")
				.toString());
		holder.car_jylb.setTag(mDataList.get(position).get("car_jylb")
				.toString());
		holder.car_syxz.setTag(mDataList.get(position).get("car_syxz")
				.toString());
		return convertView;
	}

	public final class ViewHolder {
		public ImageView img;
		public TextView car_hphm;
		public TextView car_jyjl;
		public TextView car_vin;
		public TextView car_dlrq;
		public TextView car_jylsh;
		public TextView car_hpzl;
		public TextView car_jycs;
		public TextView car_cllx;
		public TextView car_syxz;
		public TextView car_jylb;
	}

}

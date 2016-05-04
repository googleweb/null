package scxd.jcz.ajlw.android.Adapter;

import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * 车辆登录列表适配器
 * @author Administrator
 *
 */
public class CarLoginList_Adapter extends BaseAdapter {

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
	public CarLoginList_Adapter(Context context,
			List<Map<String, Object>> mDataList_in) {
		mInflater = LayoutInflater.from(context);
		mDataList = mDataList_in;
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
			convertView = mInflater.inflate(R.layout.car_login_list_msg, null);
			holder.car_hphm = (TextView) convertView
					.findViewById(R.id.car_hphm);
			holder.car_hpzl = (TextView) convertView
					.findViewById(R.id.car_hpzl);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.car_hphm.setText(mDataList.get(position).get("car_hphm")
				.toString());
		holder.car_hpzl.setText(MD_ListItem.GetValue(mDataList.get(position)
				.get("car_hpzl").toString(), MD_ListItem.Get_hpzl()));
		return convertView;
	}

	public final class ViewHolder {
		public TextView car_hphm;
		public TextView car_hpzl;
	}

}

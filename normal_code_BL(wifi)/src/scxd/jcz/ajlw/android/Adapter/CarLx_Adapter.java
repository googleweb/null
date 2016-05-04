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
 * 车辆拍照类型自定义BaseAdapter
 * 
 * @author gbh
 * 
 */
public class CarLx_Adapter extends BaseAdapter {

	private LayoutInflater mInflater;

	private  List<Map<String, Object>> mDataList;

	public static  Map<Integer, Boolean> isSelected;

	public CarLx_Adapter(Context context,List<Map<String, Object>> dataList,Map<Integer, Boolean> isSelecte) {
		mInflater = LayoutInflater.from(context);
		init(dataList,isSelecte);
	}

	/**
	 * 初始化数据
	 */
	private void init(List<Map<String, Object>> dataList,Map<Integer, Boolean> isSelecte) {
		mDataList = dataList;
		isSelected = isSelecte;

	}

	@Override
	public int getCount() {
		return mDataList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
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
			convertView = mInflater.inflate(R.layout.car_pz_lx_msg, null);
			holder.car_pz_img = (ImageView) convertView
					.findViewById(R.id.pz_img);
			holder.car_pz_cBox = (CheckBox) convertView
					.findViewById(R.id.pz_ispz_chk);
			holder.car_pz_xm = (TextView) convertView.findViewById(R.id.pz_xm);
			holder.car_pz_code = (TextView) convertView
					.findViewById(R.id.pz_code);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		try {
			if(mDataList.get(position).get("pz_code")
					.toString().equals("0")){
				holder.car_pz_cBox.setVisibility(View.GONE);
			}else{
			holder.car_pz_cBox.setChecked(isSelected.get(position));
			}
			holder.car_pz_code.setText(mDataList.get(position).get("pz_code")
					.toString());
			holder.car_pz_img.setBackgroundResource((Integer) mDataList.get(
					position).get("pz_img"));
			holder.car_pz_xm.setText(mDataList.get(position).get("pz_xm")
					.toString());
		} catch (Exception e) {
			holder.car_pz_cBox.setChecked(false);
			holder.car_pz_code.setText("");
			holder.car_pz_img.setBackgroundResource(R.drawable.camera2);
			holder.car_pz_xm.setText("");
		}

		return convertView;
	}

	public final class ViewHolder {
		public ImageView car_pz_img;
		public TextView car_pz_xm;
		public CheckBox car_pz_cBox;
		public TextView car_pz_code;
	}
}

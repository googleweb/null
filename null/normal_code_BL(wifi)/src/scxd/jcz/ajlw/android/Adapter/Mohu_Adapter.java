package scxd.jcz.ajlw.android.Adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * 
 *Mohu_Adapter.java
 * @author CXY
 * @Description 模糊查询自定义适配器
 * @Create Time 2015-6-30
 */
public class Mohu_Adapter extends BaseAdapter {
	private LayoutInflater inflater;
	private ArrayList<Map<String, String>> data = null;

	public Mohu_Adapter(Context context,
			ArrayList<Map<String, String>> responseMap) {
		this.data = responseMap;
		inflater = inflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (view == null) {
			view = inflater.inflate(R.layout.mohu_item, null);
			TextView mohu_hphm = (TextView) view.findViewById(R.id.mohu_hphm);
			TextView mohu_vin = (TextView) view.findViewById(R.id.mohu_vin);
			TextView mohu_lsh = (TextView) view.findViewById(R.id.mohu_lsh);
			TextView mohu_time=(TextView) view.findViewById(R.id.mohu_time);
			TextView mohu_pc=(TextView) view.findViewById(R.id.pc);
			Map<String, String> itemmap = data.get(position);
			mohu_hphm.setText(itemmap.get("bh"));
			mohu_vin.setText(itemmap.get("clxh"));
			mohu_lsh.setText(itemmap.get("clpp1"));
			mohu_pc.setText(itemmap.get("pc"));
			mohu_time.setText(itemmap.get("ggsxrq"));
		}
		return view;
	}

}

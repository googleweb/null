package scxd.jcz.ajlw.android.Adapter;

import java.util.ArrayList;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * 公告信息适配器
 * @author Administrator
 * @createtime
 */
public class Carggpc_Adapter extends BaseAdapter {

	private LayoutInflater inflater;
	private TextView text_bh, text_pc, text_ggrq, text_cxsxrq;
	private ArrayList<Map<String, String>> data;

	public Carggpc_Adapter(Context context,
			ArrayList<Map<String, String>> responseMap) {
		this.data = responseMap;
		inflater = inflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.car_ggpc_item, null);
			text_bh = (TextView) convertView.findViewById(R.id.bh);
			text_pc = (TextView) convertView.findViewById(R.id.pc);
			text_ggrq = (TextView) convertView.findViewById(R.id.ggrq);
			text_cxsxrq = (TextView) convertView.findViewById(R.id.cxsxrq);
			Map<String, String> hashdate = data.get(position);
			try {
				if (Md_Car_Temp.getTempCar().ggcxlx.equals("zcggxxcx")) {
					text_bh.setText(hashdate.get("bh"));
					text_pc.setText(hashdate.get("pc"));
					text_ggrq.setText(hashdate.get("ggrq"));
					text_cxsxrq.setText(hashdate.get("cxsxrq"));
				} else if (Md_Car_Temp.getTempCar().ggcxlx.equals("dpggxxcx")) {
					text_bh.setText(hashdate.get("dpbh"));
					text_pc.setText(hashdate.get("dppc"));
					text_ggrq.setText(hashdate.get("dpggrq"));
					text_cxsxrq.setText(hashdate.get("dpcxsxrq"));
				}
			} catch (Exception e) {
			}
		}
		return convertView;
	}
}

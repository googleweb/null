package scxd.jcz.ajlw.android.Adapter;

import java.util.ArrayList;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.model.LsPeopleProvider;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
/**
 * 路试列表适配器
 * @author CXY
 *
 */
public class LsPeople_Adapter extends BaseAdapter {

	private ArrayList<String> lsryDataList ;
	private LayoutInflater mInflater;
	private Context context ;
	private int index ;
	
	public LsPeople_Adapter(Context context){
		this.context = context ;
		this.mInflater = LayoutInflater.from(context);
		this.lsryDataList = LsPeopleProvider.getInstance(context).query() ;
//		Log.e("size", lsryDataList.size()+"") ;
		this.notifyDataSetChanged() ;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if(convertView == null)
			convertView = mInflater.inflate(R.layout.lsry_list_item, null);	
		Button deleteButton = (Button) convertView.findViewById(R.id.lsry_btn_delete) ;
		deleteButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				index = position ;
				dialog("注意", "删除路试员 "+lsryDataList.get(position)+" ?") ;
			}
		}) ;
		
		TextView textView = (TextView) convertView.findViewById(R.id.lsry_txt_name) ;
		textView.setText(lsryDataList.get(position)) ;
		
		return convertView;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lsryDataList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lsryDataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	private void dialog(String title ,String msg){
		new AlertDialog.Builder(context).setTitle(title)
		.setMessage(msg)
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//删除 路试人员
				LsPeopleProvider.getInstance(context).delete(lsryDataList.get(index)) ;
				lsryDataList.remove(index) ;	
				notifyDataSetChanged() ;
			}})
		.setNegativeButton("取消", null).show();
		
	}
	
}

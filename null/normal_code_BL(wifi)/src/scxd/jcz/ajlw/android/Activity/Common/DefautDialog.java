package scxd.jcz.ajlw.android.Activity.Common;

import scxd.jcz.ajlw.android.Activity.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * 对话框工具类
 * @author Administrator
 * @createtime 
 */
public class DefautDialog extends Dialog implements
		android.view.View.OnClickListener {

	public interface OnClickListener {
		public void onClick(DefautDialog dialog, View view);
	}

	public static void showDialog(Context context,int title_id, int message_id, Boolean isqdqx,
			DefautDialog.OnClickListener queding_listener,DefautDialog.OnClickListener quxiao_listener) {
		try{
		new DefautDialog(context).show(title_id, message_id, isqdqx, queding_listener,quxiao_listener);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void showDialog(Context context,String title, String message, Boolean isqdqx,
			DefautDialog.OnClickListener queding_listener,DefautDialog.OnClickListener quxiao_listener) {
		try{
		new DefautDialog(context).show(title, message, isqdqx, queding_listener,quxiao_listener);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public DefautDialog(Context context) {
		super(context, R.style.dialog);
	}
			
	public void show(int title_id, int message_id, Boolean isqdqx,
			DefautDialog.OnClickListener queding_listener,DefautDialog.OnClickListener quxiao_listener) {
		show(this.getContext().getResources().getString(title_id), this
				.getContext().getResources().getString(message_id), isqdqx,
				queding_listener,quxiao_listener);
	}

	public void show(String title, String message, Boolean isqdqx,
			DefautDialog.OnClickListener queding_listener,DefautDialog.OnClickListener quxiao_listener) {
		this.setContentView(R.layout.dialog_zdy);
		this.initDialogZdy(title, message, isqdqx, queding_listener,quxiao_listener);
		this.setCancelable(false);
		this.show();
	}

	private void initDialogZdy(String title, String message, Boolean isqdqx,
			final DefautDialog.OnClickListener queding_listener,final DefautDialog.OnClickListener quxiao_listener) {
		if (isqdqx) {
			((LinearLayout) findViewById(R.id.qdqx)).setVisibility(View.VISIBLE);
			((LinearLayout) findViewById(R.id.qd)).setVisibility(View.GONE);
			if (queding_listener != null) {
				((Button) findViewById(R.id.qdqx_queding))
						.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View arg0) {
								queding_listener.onClick(DefautDialog.this,arg0);
							}
						} );
			} else {
				((Button) findViewById(R.id.qdqx_queding))
						.setOnClickListener(this);
			}
			if(quxiao_listener != null){
				((Button) findViewById(R.id.qdqx_quxiao))
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						quxiao_listener.onClick(DefautDialog.this,arg0);
					}
				} );
			}else{
			((Button) findViewById(R.id.qdqx_quxiao)).setOnClickListener(this);
			}
		} else {
			((LinearLayout) findViewById(R.id.qdqx))
					.setVisibility(View.GONE);
			((LinearLayout) findViewById(R.id.qd)).setVisibility(View.VISIBLE);
			if (queding_listener != null) {
				((Button) findViewById(R.id.qd_queding))
						.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View arg0) {
								queding_listener.onClick(DefautDialog.this,arg0);
							}
						} );
			} else {
				((Button) findViewById(R.id.qd_queding))
						.setOnClickListener(this);
			}
		}

		((TextView) findViewById(R.id.dialog_title)).setText(title);
		((TextView) findViewById(R.id.dialog_message)).setText(message);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setCancelable(false);
	}

	public void dimiss() {
		super.dismiss();
	}

	public void show() {
		super.show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.qdqx_queding:
			this.dimiss();
		case R.id.qdqx_quxiao:
			this.dimiss();
		case R.id.qd_queding:
			this.dimiss();
		}
	}

}

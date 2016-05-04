package scxd.jcz.ajlw.android.Activity.Common;

import scxd.jcz.ajlw.android.Activity.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/**
 * 进度条+按钮对话框
 * @author Administrator
 *
 */
public class RequestStatusDialog extends Dialog implements OnClickListener {

	private String title;
	private String message;
	private Boolean isqdlayout;
	private LinearLayout qdqx_layout;
	private LinearLayout qd_layout;
	private TextView progressdialog_title;
	private TextView progressdialog_message;
	private Context con;
	private TextView showNetWorkSpeed;
	private View.OnClickListener lis;

	public RequestStatusDialog(Context context, View.OnClickListener listener) {
		super(context, R.style.dialog);
		con = context;
		lis = listener;
	}

	public RequestStatusDialog(Context context) {
		super(context, R.style.dialog);
		con = context;
	}

	public void showDialog(String title_in, String message_in,
			Boolean isqdlayout_in) {
		this.title = title_in;
		this.message = message_in;
		this.isqdlayout = isqdlayout_in;
		this.setContentView(R.layout.dialog_zdy);
		this.initDialogZdy();
		this.setCancelable(false);
		this.show();
	}

	public void showDialog(int title_id, int message_id, Boolean isqdlayout_in) {
		showDialog(this.getContext().getResources().getString(title_id), this
				.getContext().getResources().getString(message_id),
				isqdlayout_in);
	}

	public void showprogressdialog(String title_in, String message_in) {
		this.title = title_in;
		this.message = message_in;
		this.setContentView(R.layout.progressdialog_zdy);
		this.initProgressDialogZdy(lis);
		this.show();
	}
	public void showprogressdialog(int title_id, String message_in) {
		showprogressdialog(
				this.getContext().getResources().getString(title_id), message_in);
	}
	public void showprogressdialog(int title_id, int message_id) {
		showprogressdialog(
				this.getContext().getResources().getString(title_id), this
						.getContext().getResources().getString(message_id));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setCancelable(false);
	}

	private void initDialogZdy() {
		this.qdqx_layout = (LinearLayout) findViewById(R.id.qdqx);
		this.qd_layout = (LinearLayout) findViewById(R.id.qd);
		((TextView) findViewById(R.id.dialog_title)).setText(title);
		((TextView) findViewById(R.id.dialog_message)).setText(message);
		if (this.isqdlayout) {
			this.qdqx_layout.setVisibility(View.GONE);
			this.qd_layout.setVisibility(View.VISIBLE);
			((Button) findViewById(R.id.qd_queding)).setOnClickListener(this);
		} else {
			this.qdqx_layout.setVisibility(View.VISIBLE);
			this.qd_layout.setVisibility(View.GONE);
			((Button) findViewById(R.id.qdqx_queding)).setOnClickListener(this);
			((Button) findViewById(R.id.qdqx_quxiao)).setOnClickListener(this);
		}
	}

	private ProgressBar pb;

	private void initProgressDialogZdy(View.OnClickListener lis) {
		this.progressdialog_title = (TextView) findViewById(R.id.progressdialog_title);
		this.progressdialog_message = (TextView) findViewById(R.id.progressdialog_message);
		this.pb = (ProgressBar) findViewById(R.id.progressBar1);
		this.showNetWorkSpeed = (TextView) findViewById(R.id.dqws);
		this.showNetWorkSpeed.setTextColor(Color.RED);
		this.progressdialog_title.setText(title);
		this.progressdialog_message.setText(message);
		pb.setOnClickListener(lis);
		mHandler.post(updateCurrentNetWorkSpeed);
	}

	private long lastTimeSpeed = 0;

	private Handler mHandler = new Handler();
	private Runnable updateCurrentNetWorkSpeed = new Runnable() {
		public void run() {
			long getDataFlow = CurWsUtil.getNetworkSpeed(con) / 1024;
			if (lastTimeSpeed == 0) {
				lastTimeSpeed = getDataFlow;
			}
			long showSpeed = getDataFlow - lastTimeSpeed;
			lastTimeSpeed = getDataFlow;
			showNetWorkSpeed.setText(showSpeed + "k/s");
			mHandler.postDelayed(updateCurrentNetWorkSpeed, 1000);
		}
	};

	public void dimiss() {
		try {
			mHandler.removeCallbacks(updateCurrentNetWorkSpeed);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.dismiss();
	}

	public void show() {
		super.show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.qdqx_queding:
			this.dismiss();
		case R.id.qdqx_quxiao:
			this.dismiss();
		case R.id.qd_queding:
			this.dismiss();
		}
	}
}

package scxd.jcz.ajlw.android.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import scxd.jcz.ajlw.android.Activity.MainActivity;
import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.LogWriter;
import scxd.jcz.ajlw.android.Application.MyApplication;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.Md_system;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.TextView;
/**
 * 判断与服务器是否连通的服务
 * @author Administrator
 *
 */
public class PingService extends Service {
	 /**
	  * 悬浮
	  */
	 WindowManager wm = null;
     WindowManager.LayoutParams wmParams = null;
     private float mTouchStartX;
     private float mTouchStartY;
     View view;
     private float x;
     private float y;
     private TextView Pingtext;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	 
	@Override
	public void onCreate() {
		 view = LayoutInflater.from(this).inflate(R.layout.pingfloat, null);
		Pingtext=(TextView) view.findViewById(R.id.pingtext);
		 createView();
		 registerBoradcastReceiver();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		boolean isExit = intent.getBooleanExtra("exit", false);
		if (isExit) {
			unregisterReceiver(mBroadcastReceiver);
			wm.removeView(view);
			stopSelf();
		}
		// 使用定时器,每隔5秒获得一次信号强度值
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			 Intent mIntent = new Intent("ACTION_NAME"); 
			@Override
			public void run() {
				try {
					URL url = new URL(Md_system.getJk_url());
					if (InetAddress.getByName(url.getHost())
							.isReachable(5000)) {
						 
						
						  if(Md_Car_Temp.isPing.equals("0") ||
								  Md_Car_Temp.isPing.equals("1")){
					    
							  LogWriter.open().appendMethodB("PING--",
										PingService.class, "--与服务器已经链接");
							  Md_Car_Temp.isPing="2";
						  }
						   mIntent.putExtra("ping", "true"); 
			                 
			                //发送广播 
			                PingService.this.sendBroadcast(mIntent); 
						
					} else {
						
						if(Md_Car_Temp.isPing.equals("0") ||
								  Md_Car_Temp.isPing.equals("2")){
						LogWriter.open().appendMethodB("PING--",
								PingService.class, "--与服务器已经断开");
						Md_Car_Temp.isPing="1";
						}
						   mIntent.putExtra("ping", "false"); 
			                 
			                //发送广播 
			                PingService.this.sendBroadcast(mIntent); 
					}
				} catch (Exception e) {
					 mIntent.putExtra("ping", "exception"); 
	                 
		                //发送广播 
		                PingService.this.sendBroadcast(mIntent); 
				}
			}
		}, 1000, 5000);

		return Service.START_NOT_STICKY;
	}
/**
 *  创建悬浮（测试ip连接）
 */
	  private void createView() {
          // 获取WindowManagerview
          wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
          // 设置LayoutParams(全局变量）相关参数
          wmParams = ((MyApplication) getApplication()).getMywmParams();
          wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;// 该类型提供与用户交互，置于所有应用程序上方，但是在状态栏后面
          wmParams.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;// 不接受任何按键事件
          wmParams.gravity = Gravity.RIGHT | Gravity.TOP; // 调整悬浮窗口至左上角
          // 以屏幕左上角为原点，设置x、y初始值
          wmParams.x = 0;
          wmParams.y = 0;
          // 设置悬浮窗口长宽数据
          wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
          wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
          wmParams.format = PixelFormat.RGBA_8888;

          wm.addView(view, wmParams);
//
//          view.setOnTouchListener(new OnTouchListener() {
//                  public boolean onTouch(View v, MotionEvent event) {
//                          // 获取相对屏幕的坐标，即以屏幕左上角为原点
//                          x = event.getRawX();
//                          // 25是系统状态栏的高度,也可以通过方法得到准确的值，自己微调就是了
//                          y = event.getRawY()-25 ; 
//                          switch (event.getAction()) {
//                          case MotionEvent.ACTION_DOWN:
//                                  // 获取相对View的坐标，即以此View左上角为原点
//                                  mTouchStartX = event.getX();
//                                  mTouchStartY = event.getY()+view.getHeight()/2;
//                                  break;
//                          case MotionEvent.ACTION_MOVE:
//                                  updateViewPosition(view);
//                                  break;
//                          case MotionEvent.ACTION_UP:
//                                  updateViewPosition(view);
//                                  mTouchStartX = mTouchStartY = 0;
//                                  break;
//                          }
//                          return true;
//                  }
//
//          });
  }
//	  private void updateViewPosition(View view) {
//          // 更新浮动窗口位置参数
//          wmParams.x = (int) (x-mTouchStartX);
//          wmParams.y = (int) (y-mTouchStartY);
//          wm.updateViewLayout(view, wmParams);
//  }
	  /****注册广播****/
	  public void registerBoradcastReceiver(){ 
	        IntentFilter myIntentFilter = new IntentFilter(); 
	        myIntentFilter.addAction("ACTION_NAME"); 
	        //注册广播       
	        registerReceiver(mBroadcastReceiver, myIntentFilter); 
	    } 
	 //处理广播      
	  private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver(){ 
	        @Override 
	        public void onReceive(Context context, Intent intent) { 
	            String action = intent.getAction(); 
	            if(action.equals("ACTION_NAME")){ 
	            	if(intent.getStringExtra("ping").equals("true"))
        			{
//        		Pingtext.setText("畅通");
				Pingtext.setBackgroundDrawable(getResources().getDrawable(R.drawable.wifi));
        			}else if(intent.getStringExtra("ping").equals("false"))
        			{
//        				Pingtext.setText("断开");
        				Pingtext.setBackgroundDrawable(getResources().getDrawable(R.drawable.wificlose));
        			}else{
        				Pingtext.setBackgroundDrawable(getResources().getDrawable(R.drawable.wifi_exc));
        			}
	            }
	            }
	  };
}

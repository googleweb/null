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
 * �ж���������Ƿ���ͨ�ķ���
 * @author Administrator
 *
 */
public class PingService extends Service {
	 /**
	  * ����
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
		// ʹ�ö�ʱ��,ÿ��5����һ���ź�ǿ��ֵ
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
										PingService.class, "--��������Ѿ�����");
							  Md_Car_Temp.isPing="2";
						  }
						   mIntent.putExtra("ping", "true"); 
			                 
			                //���͹㲥 
			                PingService.this.sendBroadcast(mIntent); 
						
					} else {
						
						if(Md_Car_Temp.isPing.equals("0") ||
								  Md_Car_Temp.isPing.equals("2")){
						LogWriter.open().appendMethodB("PING--",
								PingService.class, "--��������Ѿ��Ͽ�");
						Md_Car_Temp.isPing="1";
						}
						   mIntent.putExtra("ping", "false"); 
			                 
			                //���͹㲥 
			                PingService.this.sendBroadcast(mIntent); 
					}
				} catch (Exception e) {
					 mIntent.putExtra("ping", "exception"); 
	                 
		                //���͹㲥 
		                PingService.this.sendBroadcast(mIntent); 
				}
			}
		}, 1000, 5000);

		return Service.START_NOT_STICKY;
	}
/**
 *  ��������������ip���ӣ�
 */
	  private void createView() {
          // ��ȡWindowManagerview
          wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
          // ����LayoutParams(ȫ�ֱ�������ز���
          wmParams = ((MyApplication) getApplication()).getMywmParams();
          wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;// �������ṩ���û���������������Ӧ�ó����Ϸ���������״̬������
          wmParams.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;// �������κΰ����¼�
          wmParams.gravity = Gravity.RIGHT | Gravity.TOP; // �����������������Ͻ�
          // ����Ļ���Ͻ�Ϊԭ�㣬����x��y��ʼֵ
          wmParams.x = 0;
          wmParams.y = 0;
          // �����������ڳ�������
          wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
          wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
          wmParams.format = PixelFormat.RGBA_8888;

          wm.addView(view, wmParams);
//
//          view.setOnTouchListener(new OnTouchListener() {
//                  public boolean onTouch(View v, MotionEvent event) {
//                          // ��ȡ�����Ļ�����꣬������Ļ���Ͻ�Ϊԭ��
//                          x = event.getRawX();
//                          // 25��ϵͳ״̬���ĸ߶�,Ҳ����ͨ�������õ�׼ȷ��ֵ���Լ�΢��������
//                          y = event.getRawY()-25 ; 
//                          switch (event.getAction()) {
//                          case MotionEvent.ACTION_DOWN:
//                                  // ��ȡ���View�����꣬���Դ�View���Ͻ�Ϊԭ��
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
//          // ���¸�������λ�ò���
//          wmParams.x = (int) (x-mTouchStartX);
//          wmParams.y = (int) (y-mTouchStartY);
//          wm.updateViewLayout(view, wmParams);
//  }
	  /****ע��㲥****/
	  public void registerBoradcastReceiver(){ 
	        IntentFilter myIntentFilter = new IntentFilter(); 
	        myIntentFilter.addAction("ACTION_NAME"); 
	        //ע��㲥       
	        registerReceiver(mBroadcastReceiver, myIntentFilter); 
	    } 
	 //����㲥      
	  private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver(){ 
	        @Override 
	        public void onReceive(Context context, Intent intent) { 
	            String action = intent.getAction(); 
	            if(action.equals("ACTION_NAME")){ 
	            	if(intent.getStringExtra("ping").equals("true"))
        			{
//        		Pingtext.setText("��ͨ");
				Pingtext.setBackgroundDrawable(getResources().getDrawable(R.drawable.wifi));
        			}else if(intent.getStringExtra("ping").equals("false"))
        			{
//        				Pingtext.setText("�Ͽ�");
        				Pingtext.setBackgroundDrawable(getResources().getDrawable(R.drawable.wificlose));
        			}else{
        				Pingtext.setBackgroundDrawable(getResources().getDrawable(R.drawable.wifi_exc));
        			}
	            }
	            }
	  };
}

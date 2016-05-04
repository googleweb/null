package scxd.jcz.ajlw.android.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.Activity.Common.BaseActivity.WebTask;
import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.LogWriter;
import scxd.jcz.ajlw.android.Activity.Common.RequestXMLFactory;
import scxd.jcz.ajlw.android.Activity.Common.ResponseFactory;
import scxd.jcz.ajlw.android.Activity.Common.WebStatus;
import scxd.jcz.ajlw.android.Activity.Common.webservice_call;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SingleService extends Service {
private WebTask webTask;
private boolean isrun=false;
private Timer timer;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		super.onCreate();
	}
	private Map<String, Object> getmap() {
		Map<String, Object> maps=new HashMap<String, Object>();
		Map<String, Object> requestMap = new HashMap<String, Object>();
		maps.put("username", Md_Car_Temp.getTempCar().username);
		maps.put("pdaid", Md_Car_Temp.getTempCar().deviceId);
		requestMap.put("QueryCondition", maps);
		return requestMap;
		
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		timer = new Timer();
		final boolean isExit = intent.getBooleanExtra("exit", false);
		if (isExit) {
			stopSelf();
			
		}
		// 使用定时器,每隔5秒获得一次信号强度值
		
		timer.scheduleAtFixedRate(new TimerTask() {
			 Intent mIntent = new Intent("SINGLE_NAME"); 
			 Object result=null;
			@Override
			public void run() {
				if(!isExit){
				try {
					if (WebStatus.isConnect(SingleService.this) == 1
							|| WebStatus.isConnect(SingleService.this) == 0) {
						Object data = RequestXMLFactory.getInstance().create("18Q08", getmap(),
								"2");
						
						String webResult = "";
						webResult = webservice_call
								.postRequest((String) data, "queryObjectOut");

						LogWriter.open().appendMethodB("reponseData" + "18Q08",
								SingleService.class, webResult);
						if (webResult == null || "".equals(webResult)
								|| "$EE".equals(webResult)) {
							
								result= ResponseFactory.getInstance().decode("18Q08", "");
						} else {
							result= ResponseFactory.getInstance()
									.decode("18Q08", webResult);
						}
						@SuppressWarnings("unchecked")
						HashMap<String, String> resultMap = (HashMap<String, String>) result;
						if("0".equals(resultMap.get("code"))){
							mIntent.putExtra("signle", "0");
						}else{
							 mIntent.putExtra("signle", "1"); 
						}
						
					} else {
						//return R.string.NET_ERROR; // 网络连接失败，请检查网络
					}
				} catch (Exception e) {
					 mIntent.putExtra("signle", "1"); 
	                 
		               
				}finally{
					 //发送广播 
	                SingleService.this.sendBroadcast(mIntent); 
				}
			}
			}}, 3000, 10000);

		return Service.START_NOT_STICKY;
	}
	@Override
		public void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
			timer.cancel();
		}

}

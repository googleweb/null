package scxd.jcz.ajlw.android.Activity.Common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * ʹ�÷�����
 * 
 * �ڵ�һ��������Activity��, ������Application�����������.... ����
 * 	CrashHandler.getInstance().init(context, "����Ŀ¼")��
 * ���������ˡ�
 * 
 * @author ( / o \ )
 * 
 */

public class CrashHandler implements UncaughtExceptionHandler {

	public static final String TAG = "CrashHandler";

	private Context context;
	private String logSaveFolder;

	private CrashHandler() {
	}

	private static CrashHandler INSTANCE = new CrashHandler();
	public static CrashHandler getInstance() {
		return INSTANCE;
	}

	/**
	 * ��ʼ������������
	 * @param context ����������
	 * @param logSaveFolder ������־����Ŀ¼ eg."���˱�����Ŀ¼"
	 */
	public void init(Context context, String logSaveFolder) {
		this.context = context;
		this.logSaveFolder = logSaveFolder;
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (tryHandleBySelf(ex)) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			android.os.Process.killProcess(android.os.Process.myPid());
			System.exit(1);
		}else{
			Thread.UncaughtExceptionHandler mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
			if(mDefaultHandler != null){
				mDefaultHandler.uncaughtException(thread, ex);
			}
		}
	}

	/**
	 * �����Լ�����
	 * @param ex
	 * @return
	 */
	private boolean tryHandleBySelf(Throwable ex) {
		if (ex == null) {
			return false;
		}

		new Thread() {
			@Override
			public void run() {
				Looper.prepare();
				Toast.makeText(context, "����С��С��ؼ�һ���úý���.", Toast.LENGTH_LONG).show();
				Looper.loop();
			}
		}.start();

		saveCrashInfo(collectDeviceInfo(context), ex);
		
		return true;
	}

	public Map<String, String> collectDeviceInfo(Context ctx) {
		
		Map<String, String> infos = new HashMap<String, String>();
		
		try {
			PackageManager pm = ctx.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
			if (pi != null) {
				String versionName = pi.versionName == null ? "null" : pi.versionName;
				String versionCode = pi.versionCode + "";
				infos.put("versionName", versionName);
				infos.put("versionCode", versionCode);
			}
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		
		Field[] fields = Build.class.getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				infos.put(field.getName(), field.get(null).toString());
				Log.d(TAG, field.getName() + " : " + field.get(null));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return infos;
	}

	private void saveCrashInfo(Map<String, String> deviceInfos, Throwable ex) {
		
		StringBuffer crashLog = new StringBuffer();
		
		//д���豸��Ϣ
		for (Map.Entry<String, String> entry : deviceInfos.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			crashLog.append(key + "=" + value + "\n");
		}
		
		
		//д������ջ��Ϣ
		Writer writer = null;
		PrintWriter printWriter = null;
		try{

			writer = new StringWriter();
			printWriter = new PrintWriter(writer);
			
			ex.printStackTrace(printWriter);
			
			Throwable cause = ex.getCause();
			while (cause != null) {
				cause.printStackTrace(printWriter);
				cause = cause.getCause();
			}		
			
			crashLog.append(writer.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(writer == null){
				try {
					writer.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(printWriter == null){
				try{
					printWriter.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	
		//�Ѵ�����Ϣд���ļ�
		FileOutputStream fos = null;
		try {
			
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				
				//���ɸ�Ŀ¼
				File saveFolder = new File( Environment.getExternalStorageDirectory().getAbsolutePath(), logSaveFolder);
				saveFolder.mkdirs();

				//д���ļ�
				String fileName = "crash-" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + "-" + Math.random() + ".log";
				fos = new FileOutputStream(new File(saveFolder, fileName));
				fos.write(crashLog.toString().getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null){
				try{
					fos.close();
					fos = null;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}

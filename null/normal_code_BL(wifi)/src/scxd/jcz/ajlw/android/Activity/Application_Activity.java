package scxd.jcz.ajlw.android.Activity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

/**
 * Description：控制activity的退出和跳转
 * @author Administrator
 * @Time 
 *
 */

public class Application_Activity extends Application {

	// 存储activity
	private List<Activity> activities = new LinkedList<Activity>();

	private static Application_Activity Application_Exit;

	// 单例模式中获取唯一的Application_Activity实例
	public static Application_Activity getApplication_Exit() {
		if (Application_Exit == null) {
			Application_Exit = new Application_Activity();
		}
		return Application_Exit;
	}

	// 添加activity到容器中
	public void addActivity(Activity activity) {
		// for (Activity activityes:activities) {
		// if
		// (!activityes.getLocalClassName().equals(activity.getLocalClassName().toString()))
		// {
		activities.add(activity);
		// }
		// }

	}

	/**
	 * 跳转到指定的Activity
	 * 
	 * @param from
	 *            当前的Activity
	 * @param to
	 *            跳转到的Activity
	 * @author gbh
	 */
	public static void goToActivity(Activity from, Class<?> to) {
		Intent intent = new Intent();

		intent.setClass(from, to);
		from.startActivity(intent);
	}

//	/**
//	 * 清除指定的activity
//	 * 
//	 * @param activity
//	 */
//	public void delActivity() {
//		try {
//			for (Activity activity : activities) {
//				if (!activity.getLocalClassName().toString().equals("CarList_Activity")) {
//
//					activity.finish();
//
//					// System.err.println("已清除：activity名称:"+activity.getLocalClassName().toString());
//				}
//
//			}
//
//			// activities.clear();
//		} catch (Exception e) {
//			System.err.println("清除异常:" + e.getMessage().toString());
//		}
//
//	}
	
	/**
	 * 清除指定的activity
	 * 
	 * @param activity
	 */
	public void delActivity(Activity a) {
		try {
			Iterator<Activity> activityIterator = activities.iterator();
			while (activityIterator.hasNext()) {
				Activity activity = activityIterator.next();
				if (activity.getLocalClassName().toString().equals(a.getLocalClassName().toString())) {
					activityIterator.remove();
					activity.finish();
					// System.err.println("已清除：activity名称:"+activity.getLocalClassName().toString());
				}
			}
			// activities.clear();
		} catch (Exception e) {
			System.err.println("清除异常:" + e.getMessage().toString());
		}

	}

	/**
	 * 遍历所有activity并finish
	 * 
	 * @param type
	 *            1 完全退出 非1是部分退出
	 */
	public void Exit(int type) {

		for (Activity activity : activities) {

			activity.finish();
			if (activity.isFinishing()) {
				 System.err.println("已清除；activity名称:"+activity.getLocalClassName().toString());
			}
		}
		activities.clear();
		if (type == 1) {
			System.exit(0);
		}

	}

}

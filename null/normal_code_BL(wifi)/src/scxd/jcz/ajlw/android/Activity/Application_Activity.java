package scxd.jcz.ajlw.android.Activity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

/**
 * Description������activity���˳�����ת
 * @author Administrator
 * @Time 
 *
 */

public class Application_Activity extends Application {

	// �洢activity
	private List<Activity> activities = new LinkedList<Activity>();

	private static Application_Activity Application_Exit;

	// ����ģʽ�л�ȡΨһ��Application_Activityʵ��
	public static Application_Activity getApplication_Exit() {
		if (Application_Exit == null) {
			Application_Exit = new Application_Activity();
		}
		return Application_Exit;
	}

	// ���activity��������
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
	 * ��ת��ָ����Activity
	 * 
	 * @param from
	 *            ��ǰ��Activity
	 * @param to
	 *            ��ת����Activity
	 * @author gbh
	 */
	public static void goToActivity(Activity from, Class<?> to) {
		Intent intent = new Intent();

		intent.setClass(from, to);
		from.startActivity(intent);
	}

//	/**
//	 * ���ָ����activity
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
//					// System.err.println("�������activity����:"+activity.getLocalClassName().toString());
//				}
//
//			}
//
//			// activities.clear();
//		} catch (Exception e) {
//			System.err.println("����쳣:" + e.getMessage().toString());
//		}
//
//	}
	
	/**
	 * ���ָ����activity
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
					// System.err.println("�������activity����:"+activity.getLocalClassName().toString());
				}
			}
			// activities.clear();
		} catch (Exception e) {
			System.err.println("����쳣:" + e.getMessage().toString());
		}

	}

	/**
	 * ��������activity��finish
	 * 
	 * @param type
	 *            1 ��ȫ�˳� ��1�ǲ����˳�
	 */
	public void Exit(int type) {

		for (Activity activity : activities) {

			activity.finish();
			if (activity.isFinishing()) {
				 System.err.println("�������activity����:"+activity.getLocalClassName().toString());
			}
		}
		activities.clear();
		if (type == 1) {
			System.exit(0);
		}

	}

}

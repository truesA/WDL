package com.wdl.jwdl.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;


/**
 * 
 * ============================================================
 * 
 *
 * 
 * description ： application tools The activity of the management class, used
 * for storage and shut off the activity, exit the program
 * 
 * revision history ：
 * 
 * ============================================================
 *
 */
public class AppManagerUtil {

	private static Stack<Activity> activityStack;
	private static AppManagerUtil instance;

	private AppManagerUtil() {
	}

	/**
	 * A single instance
	 */
	public static AppManagerUtil instance() {
		if (instance == null) {
			instance = new AppManagerUtil();
		}
		return instance;
	}

	/**
	 * The Activity is added to the stack
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 移除解绑 - 防止内存泄漏
	 * @param detachActivity
	 */
	public void detach(Activity detachActivity){
		// for 去移除有没有问题？ 一边循环一边移除会出问题 ，
		// 既然这个写法有问题，自己又想不到什么解决方法，参考一下别人怎么写的
        /*for (Activity activity : mActivities) {
            if(activity == detachActivity){
                mActivities.remove(activity);
            }
        }*/
		int size = activityStack.size();
		for (int i = 0; i < size; i++) {
			Activity activity = activityStack.get(i);
			if (activity == detachActivity) {
				activityStack.remove(i);
				i--;
				size--;
			}
		}
	}

	/**
	 * Gets the current Activity (stack last pressed into)
	 * 获取当前的Activity（最前面）
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * The last of the finish of the current Activity (stack into)
	 */
	public void finishActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * The finish of the specified Activity
	 */
	public void finishActivity(Activity finishActivity) {
//		if (activity != null) {
//			activityStack.remove(activity);
//			activity.finish();
//			activity.overridePendingTransition(R.anim.tran_pre_in,
//					R.anim.tran_pre_out);
//			activity = null;
//		}
		int size = activityStack.size();
		for (int i = 0; i < size; i++) {
			Activity activity = activityStack.get(i);
			if (activity == finishActivity) {
				activityStack.remove(i);
				activity.finish();
				i--;
				size--;
			}
		}
	}

	/**
	 * End of the specified class name of the Activity
	 */
	public void finishActivity(Class<? extends Activity> activityClass){
		// for 去移除有没有问题？
        /*for (Activity activity : mActivities) {
            if(activity.getClass().getCanonicalName().equals(activityClass.getCanonicalName())){
                mActivities.remove(activity);
                activity.finish();
            }
        }*/

		int size = activityStack.size();
		for (int i = 0; i < size; i++) {
			Activity activity = activityStack.get(i);
			if (activity.getClass().getCanonicalName().equals(activityClass.getCanonicalName())) {
				activityStack.remove(i);
				activity.finish();
				i--;
				size--;
			}
		}
	}

	/**
	 * Finish all the Activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * Exit the application
	 */
	@SuppressWarnings("deprecation")
	public void AppExit(Context context) {
		try {
			finishAllActivity();
			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.restartPackage(context.getPackageName());
			System.exit(0);
			android.os.Process.killProcess(android.os.Process.myPid());
		} catch (Exception e) {

		}
	}


}
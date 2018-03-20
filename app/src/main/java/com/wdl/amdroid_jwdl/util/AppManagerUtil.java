package com.wdl.amdroid_jwdl.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import com.wdl.amdroid_jwdl.R;

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
	 * Gets the current Activity (stack last pressed into)
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
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity.overridePendingTransition(R.anim.tran_pre_in,
					R.anim.tran_pre_out);
			activity = null;
		}
	}

	/**
	 * End of the specified class name of the Activity
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
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
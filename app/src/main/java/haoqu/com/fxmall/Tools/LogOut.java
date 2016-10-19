package haoqu.com.fxmall.Tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import haoqu.com.fxmall.Consts;
import haoqu.com.fxmall.TApplication;
import haoqu.com.fxmall.activity.LoginActivity;

/**
 * 发送退出广播，并清空偏好存储，跳转到登陆界面。
 * @author apple
 *
 */
public class LogOut {
	public static void logOut(Activity activity){

		//点退出登陆时清空偏好存储
		SharedPreferences sp = activity.getSharedPreferences("login", Context.MODE_PRIVATE);
		Editor et = sp.edit();
		et.clear();
		et.commit();

		//关闭当前活动跳转到登陆界面
		Intent intent1 = new Intent(activity, LoginActivity.class);
		activity.startActivity(intent1);

		//发送退出广播
		Intent intent = new Intent(Consts.EXITACTION);
		TApplication.instance.sendBroadcast(intent);
	}
}

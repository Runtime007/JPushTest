package bat.bin.com.myapplication3.reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import bat.bin.com.myapplication3.LogUtil;
import cn.jpush.android.api.JPushInterface;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.i("Action", intent.getAction());
        // 消息
        Bundle bundle = intent.getExtras();
        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            LogUtil.i("ACTION_REGISTRATION_ID", "JPush用户注册成功:"+JPushInterface.getRegistrationID(context));
        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            LogUtil.i("ACTION_MESSAGE_RECEIVED", "接受到推送下来的自定义消息");
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            LogUtil.i("ACTION_NOTIFICATION_RECEIVED", "接受到推送下来的通知");
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            LogUtil.i("ACTION_NOTIFICATION_OPENED", "用户点击打开了通知");
            // 打开通知栏对应的操作
//            clickNotify(context, bundle);
        } else {
            LogUtil.i("UnKown UnKown UnKown UnKown",
                    "Unhandled intent - " + intent.getAction());
        }
        LogUtil.i("Action",JPushInterface.getRegistrationID(context));
    }
}

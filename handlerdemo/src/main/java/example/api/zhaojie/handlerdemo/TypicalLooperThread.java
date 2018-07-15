package example.api.zhaojie.handlerdemo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class TypicalLooperThread extends Thread {
    private Handler mHandler;
    private static final String TAG = "TypicalLooperThread";
    private static final boolean DEBUG = true;
    @Override
    public void run() {
        //调用Looper.preapre()方法，创建Looper对象，并保存到Looper.sThreadLocal中
        Looper.prepare();
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

            }
        };
        //调用Looper.loop()方法，开始循环消息队列
        Looper.loop();
    }

    public Handler getHandler() {
        if(DEBUG)Log.e(TAG, "MainLooper="+Looper.getMainLooper());
        return mHandler;
    }
}

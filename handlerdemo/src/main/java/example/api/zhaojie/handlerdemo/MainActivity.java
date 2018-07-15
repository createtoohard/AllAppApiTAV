package example.api.zhaojie.handlerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private static final boolean DEBUG = true;
    private static final String TAG = "Looper thread";
    private Button mTypicalLooperThreadButton;
    private TypicalLooperThread mTypicalLooperThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();

    }

    private void initLayout() {
        mTypicalLooperThreadButton = findViewById(R.id.typical_looper_thread_btn);
        mTypicalLooperThreadButton.setOnClickListener(this);
        if(DEBUG)Log.d(TAG, "myLooper = " + Looper.myLooper() + " mainLooper = " + Looper.getMainLooper());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.typical_looper_thread_btn:
                startTypicalLooper();
                break;
        }
    }

    private void startTypicalLooper() {
        mTypicalLooperThread = new TypicalLooperThread();
        mTypicalLooperThread.start();
        Message mTypicalMesage = Message.obtain();
//        mTypicalMesage
//        mTypicalLooperThread.getHandler().sendMessage()

    }
}

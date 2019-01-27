package com.example.dppsdemo;

import android.app.Activity;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button mEnableAdButton, mDisableAdButton;
    private final static String TAG = "dppsdemo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        mEnableAdButton = findViewById(R.id.enable_ad_btn);
        mEnableAdButton.setOnClickListener(this);

        mDisableAdButton = findViewById(R.id.disable_ad_btn);
        mDisableAdButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.enable_ad_btn:
                enableAd();
                break;
            case R.id.disable_ad_btn:
                disableAd();
                break;
            default:
                break;
        }

    }

    private void enableAd() {
        LocalSocket mLocalSocket = new LocalSocket();
        try {
            mLocalSocket.connect(new LocalSocketAddress("pps", LocalSocketAddress.Namespace.RESERVED));
            OutputStream output = mLocalSocket.getOutputStream();
            output.write("ad:on\n".getBytes());
            output.flush();
            output.close();
        } catch (IOException e) {
            Log.e(TAG, "enable error: " + e.getMessage() + " stack: " + e.getStackTrace());
            e.printStackTrace();
        }
    }

    private void disableAd() {
        LocalSocket mLocalSocket = new LocalSocket();
        try {
            mLocalSocket.connect(new LocalSocketAddress("pps", LocalSocketAddress.Namespace.RESERVED));
            OutputStream output = mLocalSocket.getOutputStream();
            output.write("ad:off\n".getBytes());
            output.flush();
            output.close();
        } catch (IOException e) {
            Log.e(TAG, "disable error: " + e.getMessage() + " stack: " + e.getStackTrace());
            e.printStackTrace();
        }
    }
}

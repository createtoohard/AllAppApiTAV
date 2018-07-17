package example.api.zhaojie.activitydemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.api.zhaojie.activitydemo.task.launchmode.LaunchModeMainActivity;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button mLaunchModeButton;
    private Button mCheckAffinityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        mLaunchModeButton = findViewById(R.id.launchmode_btn);
        mLaunchModeButton.setOnClickListener(this);
        mCheckAffinityButton = findViewById(R.id.affinity_btn);
        mCheckAffinityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.launchmode_btn:
                startLaunchModeMainActivity();
                break;
            case R.id.affinity_btn:
                startCheckAffinityActivity();
            default:
                break;
        }
        
    }

    private void startLaunchModeMainActivity() {
        //启动到launchmode相关的主界面
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(this, LaunchModeMainActivity.class);
        intent.setComponent(cn);
        startActivity(intent);
    }

    private void startCheckAffinityActivity() {
    }
}

package example.api.zhaojie.activitydemo.task.launchmode;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.api.zhaojie.activitydemo.R;


/**
 * 1. Standard:
 *  1.1 默认启动模式，即没有设置launchmode就是该模式。
 *  1.2 如果没有使用NEW_TASK FLAG，即使设置了taskAffinity也没有用
 *  1.3 不可复用，该Activity可以有多个实例存在与多个Task中
 *
 * 2. SingleTop:
 *  2.1 Task栈顶只能存在一个该Activity实例，即如果该Activity位于栈顶，不会在创建该Activity，如果不位于栈顶，还是会创建该Activity实例
 *  2.2 如果没有使用NEW_TASK FLAG，即使设置了taskAffinity也没有用
 *  2.3
 *
 * 3. SingleTask
 * 如果没有使用NEW_TAKS FLAG，系统会自动添加该FLAG
 *
 * 4. SingleInstance
 * */
public class LaunchModeMainActivity extends Activity implements View.OnClickListener{
    private Button mLaunchModeStandardButton;
    private Button mLaunchModeSingleTopButton;
    private Button mLaunchModeSingleTaskButton;
    private Button mLaunchModeSingleInstanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launchmode_mainactivity_layout);
        initLayout();
    }

    private enum LaunchMode {
        STANDARD, SINGLETOP, SINGLETASK, SINGLEINSTANCE
    }

    private void initLayout() {
        mLaunchModeStandardButton = findViewById(R.id.launchmode_standard_btn);
        mLaunchModeStandardButton.setOnClickListener(this);

        mLaunchModeSingleTopButton = findViewById(R.id.launchmode_singletop_btn);
        mLaunchModeSingleTopButton.setOnClickListener(this);

        mLaunchModeSingleTaskButton = findViewById(R.id.launchmode_singletask_btn);
        mLaunchModeSingleTaskButton.setOnClickListener(this);

        mLaunchModeSingleInstanceButton = findViewById(R.id.launchmode_singletask_btn);
        mLaunchModeSingleInstanceButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.launchmode_standard_btn:
                startActivity(LaunchMode.STANDARD);
                break;
            case R.id.launchmode_singletop_btn:
                startActivity(LaunchMode.SINGLETOP);
                break;
            case R.id.launchmode_singletask_btn:
                startActivity(LaunchMode.SINGLETASK);
                break;
            case R.id.launchmode_singleinstance_btn:
                startActivity(LaunchMode.SINGLEINSTANCE);
                break;
            default:
                break;
        }
    }

    private void startActivity(LaunchMode launchMode) {
        Intent intent = new Intent();
        ComponentName cn = null;
        switch (launchMode) {
            case STANDARD:
                cn = new ComponentName(this, LaunchModeStandardActivity.class);
                break;
            case SINGLETOP:
                cn = new ComponentName(this, LaunchModeSingleTopActivity.class);
                break;
            case SINGLETASK:
                cn = new ComponentName(this, LaunchModeSingleTaskActivity.class);
                break;
            case SINGLEINSTANCE:
                cn = new ComponentName(this, LaunchModeSingleInstanceActivity.class);
                break;
            default:
                break;
        }
        if(cn != null) {
            intent.setComponent(cn);
            startActivity(intent);
        }
    }


}

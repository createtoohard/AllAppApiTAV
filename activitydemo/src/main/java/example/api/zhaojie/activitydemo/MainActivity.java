package example.api.zhaojie.activitydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button mLaunchModeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        mLaunchModeButton = findViewById(R.id.launchmode_btn);
        mLaunchModeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.launchmode_btn:
                startCheckLaunchMode();
                break;
            default:
                break;
        }
        
    }

    private void startCheckLaunchMode() {
    }
}

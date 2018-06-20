package example.api.zhaojie.taskaffinitydemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class TaskAffinityDemoAllowActivity extends Activity {
    private Button mButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskaffinityallow);
        mButton = findViewById(R.id.start_another_activity_notallow);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity();
            }
        });
    }

    private void startAnotherActivity() {
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(this, TaskAffinityDemoNotAllowActivity.class);
        intent.setComponent(cn);
        startActivity(intent);
    }
}

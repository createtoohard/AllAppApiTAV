package example.api.zhaojie.taskaffinitydemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TaskAffinityDemoActivity extends Activity {

    private Button mStartAnotherActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskaffinitydemo);
        mStartAnotherActivityButton = findViewById(R.id.start_another_activity);
        mStartAnotherActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity();
            }
        });
    }

    private void startAnotherActivity() {
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(this, TaskAffinityDemoAllowActivity.class);
        intent.setComponent(cn);
        startActivity(intent);
    }
}

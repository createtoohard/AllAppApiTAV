package example.api.zhaojie.activitydemo.task.affinity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class TaskAffinityDemoNotAllowActivity extends Activity {
    private Button mButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskaffinitynotallow);
        mButton = findViewById(R.id.start_another_activity_with_newtask);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityWithNewTaskFlag();
            }
        });
    }

    private void startActivityWithNewTaskFlag() {
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(this, TaskAffinityDemoNewTaskActivity.class);
        intent.setComponent(cn);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

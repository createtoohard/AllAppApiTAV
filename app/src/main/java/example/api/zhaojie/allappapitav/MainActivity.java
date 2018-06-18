package example.api.zhaojie.allappapitav;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button mNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        mNotification = findViewById(R.id.notification_tb);
        mNotification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notification_tb:
                startNotificationTestActivity();
                break;
        }

    }

    private void startNotificationTestActivity() {
        String pkgname = "example.api.zhaojie.allappapitav";
        String className = "example.api.zhaojie.allappapitav.NotificationTestActivity";
        ComponentName cn = new ComponentName(pkgname, className);
        Intent intent = new Intent();
        intent.setComponent(cn);
        startActivity(intent);
    }
}

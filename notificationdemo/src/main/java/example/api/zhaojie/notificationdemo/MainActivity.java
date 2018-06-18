package example.api.zhaojie.notificationdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private final String pkgname = "example.api.zhaojie.notificationdemo";
    private Button mBasicNotification, mSetStyleNotification, mTapNotification, mButtonNotification,
            mCategoryNotification, mVisibilityNotification;
    private Button mGroupNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        mBasicNotification = findViewById(R.id.basic_notification_button);
        mBasicNotification.setOnClickListener(this);

        mSetStyleNotification = findViewById(R.id.setstyle_notification_button);
        mSetStyleNotification.setOnClickListener(this);

        mTapNotification = findViewById(R.id.tap_notification_button);
        mTapNotification.setOnClickListener(this);

        mButtonNotification = findViewById(R.id.button_notification_button);
        mButtonNotification.setOnClickListener(this);

        mCategoryNotification = findViewById(R.id.category_notification_button);
        mCategoryNotification.setOnClickListener(this);

        mVisibilityNotification = findViewById(R.id.visibility_notification_button);
        mVisibilityNotification.setOnClickListener(this);

        mGroupNotification = findViewById(R.id.group_notification_button);
        mGroupNotification.setOnClickListener(this);
    }


    private ComponentName createBasicNotificationComponet() {
        return new ComponentName(pkgname, pkgname+".BasicNotification");
    }

    private ComponentName createSetStyleNotificationComponet() {
        return new ComponentName(pkgname, pkgname+".SetStyleNotification");
    }

    private ComponentName createTapNotificationComponet() {
        return new ComponentName(pkgname, pkgname+".TapNotification");
    }

    private ComponentName createButtonNotificationComponet() {
        return new ComponentName(pkgname, pkgname+".ButtonNotification");
    }

    private ComponentName createCategoryNotificationComponet() {
        return new ComponentName(pkgname, pkgname+".CategoryNotification");
    }

    private ComponentName createVisibilityNotificationComponet() {
        return new ComponentName(pkgname, pkgname+".VisibilityNotification");
    }

    private ComponentName createGroupNotificationComponet() {
        return new ComponentName(pkgname, pkgname+".GroupNotification");
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.basic_notification_button:
                startActivity(createBasicNotificationComponet());
                break;
            case R.id.setstyle_notification_button:
                startActivity(createSetStyleNotificationComponet());
                break;
            case R.id.tap_notification_button:
                startActivity(createTapNotificationComponet());
                break;
            case R.id.button_notification_button:
                startActivity(createButtonNotificationComponet());
                break;
            case R.id.category_notification_button:
                startActivity(createCategoryNotificationComponet());
                break;
            case R.id.visibility_notification_button:
                startActivity(createVisibilityNotificationComponet());
                break;
            case R.id.group_notification_button:
                startActivity(createGroupNotificationComponet());
                break;
        }
    }

    private void startActivity(ComponentName componentName) {
        startActivity(new Intent().setComponent(componentName));
    }


}

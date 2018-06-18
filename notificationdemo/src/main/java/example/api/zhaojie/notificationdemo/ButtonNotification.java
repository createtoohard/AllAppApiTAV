package example.api.zhaojie.notificationdemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class ButtonNotification extends Activity implements View.OnClickListener{

    private Button mButtonNotificationButton;
    private final String BUTTON_NOTIFICATION_CHANNEL = "Button_Notification_channel";

    private final int BUTTON_NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.button_notification);
        initLayout();
        createNotificationChannel();
    }

    private void initLayout() {
        mButtonNotificationButton = findViewById(R.id.button_notification_button);
        mButtonNotificationButton.setOnClickListener(this);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.tap_notification_name);
            String description = getString(R.string.tap_notification_description);
            NotificationChannel notificationChannel = new NotificationChannel(BUTTON_NOTIFICATION_CHANNEL, name, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private Notification createButtonNotification() {
        Notification.Builder mBuilder = new Notification.Builder(this, BUTTON_NOTIFICATION_CHANNEL);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("TapNotificationTitle")
                .setContentText("TapNotificationText")
                //.setContentIntent(createPendingIntent())
                //设置AutoCancel后，点击Notification后会自动移除该Notification
                .addAction(new Notification.Action(R.drawable.ic_launcher_background, "snooze", createPendingIntent()))
                .setAutoCancel(true);

        return mBuilder.build();
    }

    private PendingIntent createPendingIntent() {
        Intent snoozeIntent = new Intent();
        snoozeIntent.setClass(this, ResponseTapNotificationActivity.class);
        snoozeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, snoozeIntent, 0);
        return mPendingIntent;
    }

    private void sendNotification(int notificationId, Notification notification) {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationId, notification);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_notification_button:
                sendNotification(BUTTON_NOTIFICATION_ID, createButtonNotification());
                break;
        }
    }
}

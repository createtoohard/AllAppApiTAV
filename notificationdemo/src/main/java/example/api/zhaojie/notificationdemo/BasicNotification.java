package example.api.zhaojie.notificationdemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.Button;

public class BasicNotification extends Activity implements View.OnClickListener {
    private final String CHANNEL_ID = "NotificationDemo_BasicNotificaion";
    private int BASIC_NOTIFICATION_ID = 1;
    private int ALERT_ONCE_NOTIFICATION_ID = 2;
    private int TIMEOUT_NOTIFICATION_ID = 3;
    private int BASIC_NOTIFICATION_BY_COMPAT_ID = 4;

    private Button mSendBasicButton, mUpdateBasicNotification, mSendBasicByCompatButton;
    private Button mAlertOnceButton, mUpdateAlertOnceButton;
    private Button mSendTimeoutButton;
    private Button mCancelBasicButton, mCancelAllButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_notification);
        createNotificationChannel();
        initLayout();
    }

    private void initLayout() {
        mSendBasicButton = findViewById(R.id.basic_button);
        mSendBasicButton.setOnClickListener(this);

        mUpdateBasicNotification = findViewById(R.id.basic_update_button);
        mUpdateBasicNotification.setOnClickListener(this);

        mSendBasicByCompatButton = findViewById(R.id.basic_bycompat_button);
        mSendBasicByCompatButton.setOnClickListener(this);

        mAlertOnceButton = findViewById(R.id.alert_once_button);
        mAlertOnceButton.setOnClickListener(this);

        mUpdateAlertOnceButton = findViewById(R.id.update_alert_once_button);
        mUpdateAlertOnceButton.setOnClickListener(this);

        mSendTimeoutButton = findViewById(R.id.timeout_button);
        mSendTimeoutButton.setOnClickListener(this);

        mCancelBasicButton = findViewById(R.id.cancel_basic_button);
        mCancelBasicButton.setOnClickListener(this);

        mCancelAllButton = findViewById(R.id.cancel_all_button);
        mCancelAllButton.setOnClickListener(this);
    }


    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ (Android 8.0+) because
        // the NotificationChannel class is new not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            /**
             * NotificationChannel constructor needs 3 params
             * String id:
             * CharSequence name:
             * int importance:
             * */
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system, you can't change the importance or other
            // notifioncation behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            // also can use another way to get the NotificaitonManager Object as following
            // NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private Notification createBasicNotification() {
        Notification.Builder mBuilder = new Notification.Builder(this, CHANNEL_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("BasicNotificationContentTitle")
                .setContentText("BasicNotificationContentText")
                .setShowWhen(true);
        return mBuilder.build();
    }

    private Notification updateBasicNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("UpdateBasicNotificationContentTitle")
                .setContentText("UpdateBasicNotificationContentText");
        return mBuilder.build();
    }

    private Notification createAlertNotification() {
        Notification.Builder mBuilder = new Notification.Builder(this, CHANNEL_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("AlertOnceNotificationContentTitle")
                .setContentText("AlertOnceNotificationContentText")
                .setShowWhen(true);
        return mBuilder.build();
    }

    private Notification updateAlertNotification() {
        Notification.Builder mBuilder = new Notification.Builder(this, CHANNEL_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("UpdateAlertOnceNotificationContentTitle")
                .setContentText("UpdateAlertOnceNotificationContentText")
                .setOnlyAlertOnce(true)
                .setShowWhen(true);
        return mBuilder.build();
    }

    private Notification createTimeoutNotification() {
        Notification.Builder mBuilder = new Notification.Builder(this, CHANNEL_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("TimeoutNotificationContentTitle")
                .setContentText("TimeNotificationContentText")
                .setTimeoutAfter(2000)
                .setShowWhen(true);
        return mBuilder.build();
    }

    private void sendNotification(int notificationId, Notification notification) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, notification);
    }

    private Notification createBasicNotificationByCompat() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("BasicNotificationContentTitle")
                .setContentText("BasicNotificationContentText");
        return mBuilder.build();
    }

    private void cancelNotification(int notificationId) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(notificationId);
    }

    private void cancelAllNotification() {
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.cancelAll();
    }



    private void sendNotificationByCompat(int notificationId, Notification notification) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, notification);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.basic_button:
                sendNotification(BASIC_NOTIFICATION_ID, createBasicNotification());
                break;
            case R.id.basic_update_button:
                sendNotification(BASIC_NOTIFICATION_ID, updateBasicNotification());
                break;
            case R.id.basic_bycompat_button:
                sendNotificationByCompat(BASIC_NOTIFICATION_BY_COMPAT_ID, createBasicNotificationByCompat());
                break;
            case R.id.alert_once_button:
                sendNotification(ALERT_ONCE_NOTIFICATION_ID, createAlertNotification());
                break;
            case R.id.update_alert_once_button:
                sendNotification(ALERT_ONCE_NOTIFICATION_ID, updateAlertNotification());
                break;
            case R.id.timeout_button:
                sendNotification(TIMEOUT_NOTIFICATION_ID, createTimeoutNotification());
                break;
            case R.id.cancel_basic_button:
                cancelNotification(BASIC_NOTIFICATION_ID);
                break;
            case R.id.cancel_all_button:
                cancelAllNotification();
                break;
        }
    }
}

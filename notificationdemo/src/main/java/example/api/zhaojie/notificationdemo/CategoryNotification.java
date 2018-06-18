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

public class CategoryNotification extends Activity implements View.OnClickListener {
    private final String CHANNEL_ID = "NotificationDemo_BasicNotificaion";
    private int CATEGORY_ALARM_NOTIFICATION_ID = 1;
    private int CATEGORY_MESSAGE_NOTIFICATION_ID = 2;


    private Button mCategoryAlarmButton, mCategoryMessageButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_notification);
        createNotificationChannel();
        initLayout();
    }

    private void initLayout() {
        mCategoryAlarmButton = findViewById(R.id.category_alarm_button);
        mCategoryAlarmButton.setOnClickListener(this);

        mCategoryMessageButton = findViewById(R.id.category_message_button);
        mCategoryMessageButton.setOnClickListener(this);
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

    private Notification createCategoryNotification(String category) {
        Notification.Builder mBuilder = new Notification.Builder(this, CHANNEL_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("CategoryNotificationContentTitle")
                .setContentText("CategoryNotificationContentText")
                .setShowWhen(true)
                .setCategory(category);
        return mBuilder.build();
    }

    private void sendCategoryNotification(int notificationId, Notification notification) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, notification);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.category_alarm_button:
                sendCategoryNotification(CATEGORY_ALARM_NOTIFICATION_ID, createCategoryNotification(Notification.CATEGORY_ALARM));
                break;
            case R.id.category_message_button:
                sendCategoryNotification(CATEGORY_MESSAGE_NOTIFICATION_ID, createCategoryNotification(Notification.CATEGORY_MESSAGE));

        }
    }
}

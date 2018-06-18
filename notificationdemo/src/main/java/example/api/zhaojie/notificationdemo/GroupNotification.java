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

public class GroupNotification extends Activity implements View.OnClickListener {
    private final String CHANNEL_ID = "NotificationDemo_BasicNotificaion";
    private int SEND_FOUR_NOTIFICATION_ID = 1;
    private int SEND_TWO_SAME_GROUP_NOTIFICATION_ID = 10;
    private final String NOTIFICATION_GROUP_ID = "Group Notification Group id";


    private Button mSendFourButton;
    private Button mSendTwoWithSameGroupButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_notification);
        createNotificationChannel();
        initLayout();
    }

    private void initLayout() {
        mSendFourButton = findViewById(R.id.four_button);
        mSendFourButton.setOnClickListener(this);

        mSendTwoWithSameGroupButton = findViewById(R.id.two_group_button);
        mSendTwoWithSameGroupButton.setOnClickListener(this);

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

    private Notification createSendFourNotification(int notificationId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Notification.Builder mBuilder = new Notification.Builder(this, CHANNEL_ID);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("SendFourNotificationContentTitle" + notificationId)
                    .setContentText("SendFourNotificationContentText" + notificationId)
                    .setShowWhen(true);
            return mBuilder.build();
        } else {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("SendFourNotificationContentTitle" + notificationId)
                    .setContentText("SendFourNotificationContentText" + notificationId)
                    .setShowWhen(true);
            return mBuilder.build();
        }
    }

    private Notification createGroupNotification(int notificationId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Notification.Builder mBuilder = new Notification.Builder(this, CHANNEL_ID);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("GroupNotificationContentTitle" + notificationId)
                    .setContentText("GroupNotificationContentText" + notificationId)
                    .setGroup(NOTIFICATION_GROUP_ID)
                    .setShowWhen(true);
            return mBuilder.build();
        } else {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("GroupNotificationContentTitle" + notificationId)
                    .setContentText("GroupNotificationContentText" + notificationId)
                    .setGroup(NOTIFICATION_GROUP_ID)
                    .setShowWhen(true);
            return mBuilder.build();
        }
    }

    private Notification createGroupSummaryNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);
            builder.setGroup(NOTIFICATION_GROUP_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText("GroupSummaryNotificationText")
                    .setContentTitle("GroupSummaryNotificationTitle")
                    .setGroupSummary(true);
            return builder.build();
        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
            builder.setGroup(NOTIFICATION_GROUP_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText("GroupSummaryNotificationText")
                    .setContentTitle("GroupSummaryNotificationTitle")
                    .setGroupSummary(true);
            return builder.build();
        }
    }

    private Notification createGroupSummaryWithInboxStyleNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Notification.InboxStyle style = new Notification.InboxStyle();
            style.addLine("GroupSumamryWithInboxStyle line1")
                    .addLine("GroupSummaryWithInboxStyle line2");
            Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);
            builder.setGroup(NOTIFICATION_GROUP_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText("GroupSummaryWithInboxStyleNotificationText")
                    .setContentTitle("GroupSummaryWithInboxStyleNotificationTitle")
                    .setStyle(style)
                    .setGroupSummary(true);
            return builder.build();
        } else {
            NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
            style.addLine("GroupSumamryWithInboxStyle line1")
                    .addLine("GroupSummaryWithInboxStyle line2")
                    .addLine("GroupSummaryWithInboxStyle line3");
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
            builder.setGroup(NOTIFICATION_GROUP_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText("GroupSummaryWithInboxStyleNotificationText")
                    .setContentTitle("GroupSummaryWithInboxStyleNotificationTitle")
                    .setStyle(style)
                    .setGroupSummary(true);
            return builder.build();
        }
    }

    private void sendNotification(int notificationId, Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(notificationId, notification);
        } else {
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(notificationId, notification);
        }
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.four_button:
                sendNotification(SEND_FOUR_NOTIFICATION_ID, createSendFourNotification(SEND_FOUR_NOTIFICATION_ID));
                sendNotification(SEND_FOUR_NOTIFICATION_ID+1, createSendFourNotification(SEND_FOUR_NOTIFICATION_ID+1));
                sendNotification(SEND_FOUR_NOTIFICATION_ID+2, createSendFourNotification(SEND_FOUR_NOTIFICATION_ID+2));
                sendNotification(SEND_FOUR_NOTIFICATION_ID+3, createSendFourNotification(SEND_FOUR_NOTIFICATION_ID+3));
                break;
            case R.id.two_group_button:
                sendNotification(SEND_TWO_SAME_GROUP_NOTIFICATION_ID, createGroupNotification(SEND_TWO_SAME_GROUP_NOTIFICATION_ID));
                sendNotification(SEND_TWO_SAME_GROUP_NOTIFICATION_ID+1, createGroupNotification(SEND_TWO_SAME_GROUP_NOTIFICATION_ID+1));
                sendNotification(SEND_TWO_SAME_GROUP_NOTIFICATION_ID+2, createGroupNotification(SEND_TWO_SAME_GROUP_NOTIFICATION_ID+2));
                sendNotification(SEND_TWO_SAME_GROUP_NOTIFICATION_ID+9, createGroupSummaryNotification());
                //sendNotification(SEND_TWO_SAME_GROUP_NOTIFICATION_ID+9, createGroupSummaryWithInboxStyleNotification());
                break;

        }
    }
}

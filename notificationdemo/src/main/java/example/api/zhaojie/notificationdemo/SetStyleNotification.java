package example.api.zhaojie.notificationdemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class SetStyleNotification extends Activity implements View.OnClickListener {
    private Button mBigPictureStyleButton, mBigTextStyleButton, mInboxStyleButton, mMessagingStyleButton,
            mMediaStyleButton;
    private final String CHANNEL_ID = "SetStyleNotification";
    private final int BIGPICTURE_NOTIFICATION_ID = 1;
    private final int BIGTEXT_NOTIFICATION_ID = 2;
    private final int INBOX_NOTIFICATION_ID = 3;
    private final int MESSAGING_NOTIFICATION_ID = 4;
    private final int MEDIA_NOTIFICATION_ID = 5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setstyle_notification);
        createNotificationChannel();
        initLayout();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.setstyle_channel_name);
            String description = getString(R.string.setstyle_channel_description);
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void initLayout() {
        mBigPictureStyleButton = findViewById(R.id.bigpicturestyle_button);
        mBigPictureStyleButton.setOnClickListener(this);

        mBigTextStyleButton = findViewById(R.id.bigtextstyle_button);
        mBigTextStyleButton.setOnClickListener(this);

        mInboxStyleButton = findViewById(R.id.inboxstyle_button);
        mInboxStyleButton.setOnClickListener(this);

        mMessagingStyleButton = findViewById(R.id.messagingstyle_button);
        mMessagingStyleButton.setOnClickListener(this);

        mMediaStyleButton = findViewById(R.id.mediastyle_button);
        mMediaStyleButton.setOnClickListener(this);
    }

    private Bitmap getBigPicture() {
        Bitmap bigPicture = Bitmap.createBitmap(100,100,Bitmap.Config.ARGB_8888);
        bigPicture.eraseColor(Color.RED);
        return bigPicture;
    }


    private Notification createBigPictureNotification() {
        Notification.BigPictureStyle style = new Notification.BigPictureStyle();
        style.bigPicture(getBigPicture())
                .setBigContentTitle("BigPictureStyle Content Title");

        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("BigPictureStyleNotificationTitle")
                .setContentText("BigPictureStyleNotificationText")
                .setShowWhen(true)
                .setLargeIcon(getBigPicture())
                .setStyle(style);
        return builder.build();
    }

    private Notification createBigTextNotification() {
        CharSequence bigText = "小组赛阶段揭幕日只有一场比赛，第三比赛日(6月16)有四场比赛，其他比赛日日均三场;" +
                "小组赛结束后有一天的休息日，八分之一决赛每天两场比赛，之后再休息两天，四分之一决赛仍然是每天两场;" +
                "四分之一比赛结束后休战两天，此后的两场半决赛一天一场，分别在莫斯科和圣彼得堡进行，" +
                "再休息两天后(7月14日)进行三四名比赛，最终的决赛在7月15日进行";
        Notification.BigTextStyle style = new Notification.BigTextStyle();
        style.bigText(bigText);

        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("BigTextStyleNotificationTitle")
                .setContentText("BigTextStyleNotificationText")
                .setShowWhen(true)
                .setLargeIcon(getBigPicture())
                .setStyle(style);
        return builder.build();
    }

    private Notification createInboxNotification() {
        Notification.InboxStyle style = new Notification.InboxStyle();
        style.addLine("inbox line1")
                .addLine("inbox line2")
                .addLine("inbox line3");

        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("InboxStyleNotificationTitle")
                .setContentText("InboxStyleNotificationText")
                .setShowWhen(true)
                .setLargeIcon(getBigPicture())
                .setStyle(style);
        return builder.build();
    }

    private Notification createMessagingNotification() {
        CharSequence messagingStyle = "messagingStyle";
        Notification.MessagingStyle.Message message1 = new Notification.MessagingStyle.Message("hello1", System.currentTimeMillis(), "sender1");
        Notification.MessagingStyle.Message message2 = new Notification.MessagingStyle.Message("hello2", System.currentTimeMillis(), "sender2");
        Notification.MessagingStyle.Message message3 = new Notification.MessagingStyle.Message("hello3", System.currentTimeMillis(), "sender3");

        Notification.MessagingStyle style = new Notification.MessagingStyle(messagingStyle);
        //addMessage()中传入的是Notification.MessagingStyle.Message实例
        style.addMessage(message1)
                .addMessage(message2)
                .addMessage(message3)
                .setConversationTitle("ConversationTitle");

        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                //设置Content并没有显示
                .setContentTitle("MessagingStyleNotificationTitle")
                .setContentText("MessagingStyleNotificationText")
                .setShowWhen(true)
                .setLargeIcon(getBigPicture())
                .setStyle(style);
        return builder.build();
    }

    private Notification createMediaNotification() {
        Notification.MediaStyle style = new Notification.MediaStyle();
        style.setShowActionsInCompactView(1);

        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("InboxStyleNotificationTitle")
                .setContentText("InboxStyleNotificationText")
                .setShowWhen(true)
                .setLargeIcon(getBigPicture())
                .setStyle(style);
        return builder.build();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bigpicturestyle_button:
                sendNotification(BIGPICTURE_NOTIFICATION_ID, createBigPictureNotification());
                break;
            case R.id.bigtextstyle_button:
                sendNotification(BIGTEXT_NOTIFICATION_ID, createBigTextNotification());
                break;
            case R.id.inboxstyle_button:
                sendNotification(INBOX_NOTIFICATION_ID, createInboxNotification());
                break;
            case R.id.messagingstyle_button:
                sendNotification(MESSAGING_NOTIFICATION_ID, createMessagingNotification());
                break;
            case R.id.mediastyle_button:
                //sendNotification();
        }
    }

    private void sendNotification(int notificationId, Notification notification) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, notification);
    }
}

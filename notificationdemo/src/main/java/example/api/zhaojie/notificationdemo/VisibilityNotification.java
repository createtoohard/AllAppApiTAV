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

public class VisibilityNotification extends Activity implements View.OnClickListener {
    private final String CHANNEL_ID = "NotificationDemo_VisibilityNotificaion";
    private int VISIBILITY_SECRET_NOTIFICATION_ID = 1;
    private int VISIBILITY_PRIVATE_NOTIFICATION_ID = 2;
    private int VISIBILITY_PUBLIC_NOTIFICATION_ID = 3;

    private Button mVisibilitySecretButton, mVisibilityPrivateButton, mVisibilityPublicButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visibility_notification);
        createNotificationChannel();
        initLayout();
    }

    private void initLayout() {
        mVisibilitySecretButton = findViewById(R.id.visibility_secret_button);
        mVisibilitySecretButton.setOnClickListener(this);

        mVisibilityPrivateButton = findViewById(R.id.visibility_private_button);
        mVisibilityPrivateButton.setOnClickListener(this);

        mVisibilityPublicButton = findViewById(R.id.visibility_public_button);
        mVisibilityPublicButton.setOnClickListener(this);
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

    private Notification createVisibilityNotification(int visibility) {
        CharSequence bigText = "小组赛阶段揭幕日只有一场比赛，第三比赛日(6月16)有四场比赛，其他比赛日日均三场;" +
                "小组赛结束后有一天的休息日，八分之一决赛每天两场比赛，之后再休息两天，四分之一决赛仍然是每天两场;" +
                "四分之一比赛结束后休战两天，此后的两场半决赛一天一场，分别在莫斯科和圣彼得堡进行，" +
                "再休息两天后(7月14日)进行三四名比赛，最终的决赛在7月15日进行";
        Notification.BigTextStyle style = new Notification.BigTextStyle();
        style.bigText(bigText);

        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("VisibilityNotificationTitle")
                .setContentText("VisibilityNotificationText")
                .setShowWhen(true)
                .setVisibility(visibility)
                .setStyle(style);
        return builder.build();
    }

    private void sendVisibilityNotification(int notificationId, Notification notification) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, notification);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.visibility_secret_button:
                sendVisibilityNotification(VISIBILITY_SECRET_NOTIFICATION_ID, createVisibilityNotification(Notification.VISIBILITY_SECRET));
                break;
            case R.id.visibility_private_button:
                sendVisibilityNotification(VISIBILITY_PRIVATE_NOTIFICATION_ID, createVisibilityNotification(Notification.VISIBILITY_PRIVATE));
                break;
            case R.id.visibility_public_button:
                sendVisibilityNotification(VISIBILITY_PUBLIC_NOTIFICATION_ID, createVisibilityNotification(Notification.VISIBILITY_PUBLIC));
                break;
        }
    }
}

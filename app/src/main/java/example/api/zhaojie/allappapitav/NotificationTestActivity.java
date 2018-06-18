package example.api.zhaojie.allappapitav;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.Button;

public class NotificationTestActivity extends Activity implements View.OnClickListener{
    private Button mSingleButton, mUpdateButton;
    private NotificationManager mNotificationManager;
    private NotificationManagerCompat mgr;
    private NotificationChannel mSingleNotificationChannel;
    private int SINGLE_NOTIFIONCATION_ID = 1;
    private int SINGLE_NOTIFIONCATION_ID_2 = 2;
    private final String SINGLE_CHANNEL_ID = "single_channel";
    private final String GROUP_NOTIFICATION = "notification_group_test";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_test);
        initLayout();
        initNotification();
    }

    private void initNotification() {
    }

    private void initLayout() {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationChannelGroup ncg = new NotificationChannelGroup(SINGLE_CHANNEL_ID,SINGLE_CHANNEL_ID);
        mNotificationManager.createNotificationChannelGroup(ncg);
        mSingleNotificationChannel = new NotificationChannel(SINGLE_CHANNEL_ID, SINGLE_CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
        mNotificationManager.createNotificationChannel(mSingleNotificationChannel);
        mgr = NotificationManagerCompat.from(this);

        mSingleNotificationChannel.setGroup(SINGLE_CHANNEL_ID);

        mSingleButton = findViewById(R.id.single_nb);
        mSingleButton.setOnClickListener(this);

        mUpdateButton = findViewById(R.id.update_nb);
        mUpdateButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.single_nb:
                sendSingleNotification();
                showSummery();
                break;
            case R.id.update_nb:
                updateSingleNotification();
                break;
            default:
                break;
        }

    }

    private void showSummery() {
        Notification.Builder sum = new Notification.Builder(this, SINGLE_CHANNEL_ID);
        sum.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("i dont know")
                .setContentText("hehe")
                .setGroup(GROUP_NOTIFICATION)
                .setGroupSummary(true);
        Notification.InboxStyle style = new Notification.InboxStyle();
        style.addLine("text1")
                .addLine("text2");
        mNotificationManager.notify(144, sum.setStyle(style).build());
    }

    private void updateSingleNotification() {
//        mSingleNotificationChannel = new NotificationChannel(SINGLE_CHANNEL_ID, SINGLE_CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
//        mNotificationManager.createNotificationChannel(mSingleNotificationChannel);
        Notification mNotification;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, SINGLE_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("SingleNotifioncation2")
                .setContentText("I am just a Notifioncation2")
                .setAutoCancel(true)
                .setGroup(GROUP_NOTIFICATION);
        mNotification = builder.build();
//        mgr.notify(SINGLE_NOTIFIONCATION_ID, mNotification);
        mNotificationManager.notify(SINGLE_NOTIFIONCATION_ID_2,mNotification);
    }

    private void sendSingleNotification() {
//        mSingleNotificationChannel = new NotificationChannel(SINGLE_CHANNEL_ID, SINGLE_CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
//        mNotificationManager.createNotificationChannel(mSingleNotificationChannel);
        Notification mSingleNotification;
        NotificationCompat.Builder mSingleNBuilder = new NotificationCompat.Builder(this, SINGLE_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("SingleNotifioncation1")
                .setContentText("I am just a Notifioncation1")
                .setAutoCancel(true)
                .setGroup(GROUP_NOTIFICATION);
        mSingleNotification = mSingleNBuilder.build();
//        mgr.notify(SINGLE_NOTIFIONCATION_ID_2, mSingleNotification);
        mNotificationManager.notify(SINGLE_NOTIFIONCATION_ID,mSingleNotification);
    }
}

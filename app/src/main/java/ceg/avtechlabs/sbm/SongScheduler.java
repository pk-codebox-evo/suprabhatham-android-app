package ceg.avtechlabs.sbm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;

import java.util.HashMap;

import ceg.avtechlabs.sbm.util.FileUtil;

public class SongScheduler extends BroadcastReceiver {
    NotificationManager manager;
    Notification notification;

    public SongScheduler() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        //check and set recurring alarm
        Alarm.checkAndSetRecurringAlarm(context);

        String title = "Suprabhatham";
        String message = "Suprabhatham is playing...";

        FileUtil.delete(context, FileUtil.HOUR_FILE);
        FileUtil.delete(context, FileUtil.MINUTE_FILE);

        Vibrator vibrate = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrate.vibrate(2500);

        PendingIntent pi = PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);

        HashMap<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("title", title);
        arguments.put("message", message);
        arguments.put("intent", pi);

        ceg.avtechlabs.sbm.Notification.showNotification(context, arguments);

        context.startService(new Intent(context, MyService.class));
    }


}

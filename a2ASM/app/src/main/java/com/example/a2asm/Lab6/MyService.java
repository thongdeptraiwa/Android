package com.example.a2asm.Lab6;

import static com.example.a2asm.Lab6.MyNotification.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.a2asm.R;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service onCreate", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Notification();
        return START_NOT_STICKY;
    }

    public void Notification(){

        Intent intent = new Intent(this,Lab6.class);

        //PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        //tạo Bitmap
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_all_inclusive);

        //builder Notification
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Lab6")
                .setContentText("Notification")
                .setSmallIcon(R.drawable.icon_menu)
                .build();

        startForeground(1,notification);

//        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
//        //code check quyền Notification trên thiết bị
//        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
//                == PackageManager.PERMISSION_GRANTED){
//            //nếu đã có quyền , ta thực hiện push Notification
//            notificationManagerCompat.notify(getNotification_ID(),notification);
//        }else {
//            //nếu ko có quyền , thì sẽ thực hiện xin quyền
//            ActivityCompat.requestPermissions(this,
//                    new String[]{android.Manifest.permission.POST_NOTIFICATIONS},7979);
//        }


//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        if(manager != null){
//            manager.notify(getNotification_ID(),notification);
//        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service onDestroy", Toast.LENGTH_SHORT).show();
    }
}

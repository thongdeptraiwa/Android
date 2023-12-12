package com.example.a2asm.Lab6;

import static com.example.a2asm.Lab6.MyNotification.CHANNEL_ID;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.a2asm.R;

public class BackgroundServices extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "BackgroundServices onCreate", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        chuyenQuaWeb();
        return super.onStartCommand(intent,flags,startId);
    }

    public void chuyenQuaWeb(){
        Toast.makeText(this, "Service bắt đầu chạy", Toast.LENGTH_SHORT).show();

        try{
            //sau 2 giay chuyen sang web
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(BackgroundServices.this, "Đang chạy", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.apple.com/vn/"));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    stopSelf();
                }
            },2000);
        }catch (Exception e){
            Toast.makeText(this, "loi chuyen qua web", Toast.LENGTH_SHORT).show();
            stopSelf();
        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "BackgroundServices onDestroy", Toast.LENGTH_SHORT).show();
    }
}

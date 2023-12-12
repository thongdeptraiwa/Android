package com.example.a2asm.Lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.a2asm.R;

import java.util.Date;

public class Lab6 extends AppCompatActivity {


    Button btnStartService,btnStopService,btnBackgroundServices,btnWorkManager;
    private static final int  Notification_ID = 1;


    public static boolean checkWorker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);
        //ánh xạ
        btnStartService=findViewById(R.id.btnStartService);
        btnStopService=findViewById(R.id.btnStopService);
        btnBackgroundServices=findViewById(R.id.btnBackgroundServices);
        btnWorkManager=findViewById(R.id.btnWorkManager);





        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStartService();
            }
        });
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();
            }
        });
        btnBackgroundServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBackgroundService();
            }
        });
        btnWorkManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset checkWorker lại thành false
                checkWorker = false;

                //khi ứng dụng dc kết nối vs sạc sẽ thực hiện công việc này
                Constraints constraints = new Constraints.Builder()
                        .setRequiresCharging(true).build();
                WorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                        .setConstraints(constraints).build();
                //gửi workRequest đến hệ thống
                WorkManager.getInstance(Lab6.this).enqueue(workRequest);

                //thông báo nếu ko đc sạc
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(checkWorker == false){
                            Toast.makeText(Lab6.this, "Thiết bị ko đc sạc", Toast.LENGTH_SHORT).show();
                        }
                    }
                },1000);


            }
        });
    }


    private void clickStartService() {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
    private void clickBackgroundService() {
        Intent intent = new Intent(this, BackgroundServices.class);
        startService(intent);
    }

    private void clickStopService() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }


//    private int getNotification_ID(){
//        return (int) new Date().getTime();
//    }
}
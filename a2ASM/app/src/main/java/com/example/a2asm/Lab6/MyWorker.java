package com.example.a2asm.Lab6;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {


    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        //Tạo handler
        Handler handler = new android.os.Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Lab6.checkWorker = true;
                Toast.makeText(getApplicationContext(), "Thiết bị đang sạc", Toast.LENGTH_SHORT).show();
            }
        }, 500);
        return Result.success();
    }

}

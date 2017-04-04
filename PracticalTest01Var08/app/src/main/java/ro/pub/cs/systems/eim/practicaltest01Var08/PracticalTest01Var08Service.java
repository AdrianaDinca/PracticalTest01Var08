package ro.pub.cs.systems.eim.practicaltest01Var08;

import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;
import java.util.Random;

import ro.pub.cs.systems.eim.practicaltest01Var08.Constants;

public class PracticalTest01Var08Service extends Service {

    private ProcessingThread processingThread;
    private Random random = new Random();
    private Context context = null;
    private boolean isRunning = true;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int a = intent.getIntExtra("a", -1);
        int b = intent.getIntExtra("b", -1);
        int c = intent.getIntExtra("c", -1);
        int d = intent.getIntExtra("d", -1);

        processingThread = new ProcessingThread(this, a, b,c,d);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }


    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(Constants.actionTypes[random.nextInt(Constants.actionTypes.length)]);
  //      intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA,
   //             new Date(System.currentTimeMillis()) + " " + a + " " + b);
        context.sendBroadcast(intent);
    }


    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}

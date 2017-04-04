package ro.pub.cs.systems.eim.practicaltest01Var08;

/**
 * Created by adriana on 04.04.2017.
 */

import java.util.Date;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;

public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    private double a;
    private double b;

    private double c;
    private double d;

    public ProcessingThread(Context context, int a, int b, int c, int d) {
        this.context = context;

        a = a % 5;
        b = b % 5;

        c = c % 5;
        d = d % 5;
    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(Constants.actionTypes[random.nextInt(Constants.actionTypes.length)]);
        intent.putExtra("message", new Date(System.currentTimeMillis()) + " " + a + " " + b + " " + c + " " + d);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}


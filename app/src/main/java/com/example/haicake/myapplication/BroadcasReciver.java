package com.example.haicake.myapplication;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BroadcasReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if ( intent.getAction().equals(MainActivity.ACTION_CUSTOM)) {
            String title = intent.getStringExtra(MainActivity.ACTION_CUSTOM);
            Toast.makeText(context, title, Toast.LENGTH_LONG).show();
        }
    }
}

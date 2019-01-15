package com.example.haicake.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    BroadcasReciver broadcastReceiver;
    private Button btnsend;
    private EditText edtText;
    public static final String  ACTION_CUSTOM = "CUSTOM_INTENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnsend = (Button) findViewById(R.id.btnsend);
        edtText = (EditText) findViewById(R.id.edtText);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(ACTION_CUSTOM, edtText.getText().toString());
                intent.setAction(ACTION_CUSTOM);
                sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        initBroadcastReceiver();
    }

    private void initBroadcastReceiver(){

        broadcastReceiver = new BroadcasReciver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CUSTOM);
        registerReceiver(broadcastReceiver,intentFilter);

    }
}

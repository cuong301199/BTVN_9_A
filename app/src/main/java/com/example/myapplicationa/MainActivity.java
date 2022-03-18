package com.example.myapplicationa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String ACTION_SEND ="send" ;
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS ="address" ;
    private static final String KEY_PHONE = "phone";

    EditText edt_name,edt_address,edt_phone_number;
    Button btn_sendBroadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name = findViewById(R.id.edt_name);
        edt_address = findViewById(R.id.edt_address);
        edt_phone_number = findViewById(R.id.edt_phone_number);
        btn_sendBroadCast = findViewById(R.id.btn_sendBroadCast);

        btn_sendBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBroadCastReciver();
            }
        });
    }

    private void sendBroadCastReciver() {
        String name = edt_name.getText().toString().trim();
        String address = edt_address.getText().toString().trim();
        String phone = edt_phone_number.getText().toString().trim();

        Intent intent = new Intent(ACTION_SEND);
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME,name);
        bundle.putString(KEY_ADDRESS,address);
        bundle.putString(KEY_PHONE,phone);

        intent.putExtras(bundle);
        sendBroadcast(intent);
    }


}
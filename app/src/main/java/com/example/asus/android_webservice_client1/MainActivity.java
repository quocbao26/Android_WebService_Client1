package com.example.asus.android_webservice_client1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnListCh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Setcontrol();
        addEvents();
    }

    private void addEvents() {
        btnListCh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DanhSachCauHoiActivity.class));
            }
        });
    }

    private void Setcontrol() {
        btnListCh = findViewById(R.id.btnListCH);
    }
}

package com.haxon.larp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.haxon.larp.R;

public class MainActivity extends AppCompatActivity {

    Button gotoStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoStart = findViewById(R.id.gotoStart);
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("mypref", 0);

        gotoStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (prefs.contains("username")) {
                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, StartHomeActivity.class);
                    startActivity(i);
                }
                finish();
            }
        });

    }
}
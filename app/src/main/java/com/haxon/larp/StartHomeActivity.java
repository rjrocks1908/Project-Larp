package com.haxon.larp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartHomeActivity extends AppCompatActivity {

    private Button startHome_login, startHome_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_home);

        startHome_login = findViewById(R.id.startHome_login);
        startHome_signUp = findViewById(R.id.startHome_signUp);

        startHome_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartHomeActivity.this, LoginActivity.class));
            }
        });

        startHome_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartHomeActivity.this, RegisterActivity.class));
            }
        });

    }
}
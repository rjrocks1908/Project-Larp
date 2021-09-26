package com.haxon.larp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText passEntry, userNameEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passEntry = findViewById(R.id.login_passEntry);
        userNameEntry = findViewById(R.id.login_userNameEntry);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });

    }

    private void checkCredentials() {

        String userName = userNameEntry.getText().toString();
        String password = passEntry.getText().toString();

        if (!userName.isEmpty()){
            userNameEntry.setError(null);

            if (!password.isEmpty()){
                userNameEntry.setError(null);
            }else{
                passEntry.setError("Please Enter Password!!");
            }
        }else{
            userNameEntry.setError("Please Enter username!!");
        }

    }
}
package com.haxon.larp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.haxon.larp.Designing.CustomProgressBar;
import com.haxon.larp.R;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText passEntry, userNameEntry;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;

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

        CustomProgressBar dialog = new CustomProgressBar(LoginActivity.this);
        dialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );


        String userName = userNameEntry.getText().toString();
        String password = passEntry.getText().toString();



        if (!userName.isEmpty()){
            userNameEntry.setError(null);

            if (!password.isEmpty()){
                userNameEntry.setError(null);

                SharedPreferences sharedPreferences1 = getApplicationContext().getSharedPreferences("mypref", 0);
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putString("username", userName);
                editor.apply();

                dialog.show();
                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("User");

                Query checkUsername = reference.orderByChild("username").equalTo(userName);
                checkUsername.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        dialog.dismiss();
                        if (snapshot.exists()){

                            userNameEntry.setError(null);
                            String checkPassword = snapshot.child(userName).child("password").getValue(String.class);
                            if (checkPassword.equals(password)){

                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                                finish();

                            }else{
                                Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            userNameEntry.setError("User does not exist");
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        dialog.dismiss();
                    }
                });

            }else{
                passEntry.setError("Please Enter Password!!");
            }
        }else{
            userNameEntry.setError("Please Enter username!!");
        }

    }
}
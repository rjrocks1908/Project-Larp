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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.haxon.larp.Designing.CustomProgressBar;
import com.haxon.larp.Models.CredentialsData;
import com.haxon.larp.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText userNameEntry, emailEntry, phoneEntry, passEntry;
    private Button signUpBtn;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userNameEntry = findViewById(R.id.signUp_userNameEntry);
        emailEntry = findViewById(R.id.signUp_emailEntry);
        phoneEntry = findViewById(R.id.signUp_phoneEntry);
        passEntry = findViewById(R.id.login_passEntry);
        signUpBtn = findViewById(R.id.SignUpBtn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadUser();
            }
        });



    }

    private void uploadUser() {
        String userName = userNameEntry.getText().toString();
        String email = emailEntry.getText().toString();
        String phoneNumber = phoneEntry.getText().toString();
        String password = passEntry.getText().toString();

        SharedPreferences sharedPreferences1 = getApplicationContext().getSharedPreferences("mypref", 0);
        SharedPreferences.Editor editor = sharedPreferences1.edit();
        editor.putString("username", userName);
        editor.apply();

        CustomProgressBar dialog = new CustomProgressBar(RegisterActivity.this);
        dialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );

        if (userName.isEmpty()) {
            userNameEntry.setError("Enter UserName");
        } else if (email.isEmpty()) {
            emailEntry.setError("Enter Email");
        } else if (phoneNumber.isEmpty()) {
            phoneEntry.setError("Enter phone Number");
        } else if (password.isEmpty()) {
            passEntry.setError("Enter password");
        } else {
            dialog.show();

            firebaseDatabase = FirebaseDatabase.getInstance();
            reference = firebaseDatabase.getReference("User");

            CredentialsData data = new CredentialsData(userName, email, phoneNumber, password);

            reference.child(userName).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isComplete()) {
                        dialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, InfoTakeActivity.class));
                        finish();
                    } else {
                        dialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "Registration Not Successful", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
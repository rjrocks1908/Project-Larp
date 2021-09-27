package com.haxon.larp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.haxon.larp.Designing.CustomProgressBar;
import com.haxon.larp.Models.CredentialsData;
import com.haxon.larp.Models.MyGoalsModel;
import com.haxon.larp.R;

import java.text.DateFormat;
import java.util.Date;

public class CreateNewTaskActivity extends AppCompatActivity {

    private Toolbar taskToolbar;
    private TextView createTask;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;
    private String username;
    private EditText taskTitle, taskNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_task);

        taskToolbar = findViewById(R.id.taskToolbar);
        createTask = findViewById(R.id.createTask);
        taskTitle = findViewById(R.id.taskTitle);
        taskNote = findViewById(R.id.taskNotes);

        setSupportActionBar(taskToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences prefs = getApplicationContext().getSharedPreferences("mypref", 0);
        username = prefs.getString("username",null);

        createTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });


    }

    private void addTask() {

        CustomProgressBar dialog = new CustomProgressBar(CreateNewTaskActivity.this);
        dialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
        dialog.show();

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Tasks").child(username);
        String date = DateFormat.getDateInstance().format(new Date());
        String title = taskTitle.getText().toString();

        MyGoalsModel data = new MyGoalsModel(
                    title,
                    taskNote.getText().toString(),
                    username,
                    date
                );

        reference.child(title).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                dialog.dismiss();
                if (task.isComplete()){
                    Toast.makeText(CreateNewTaskActivity.this, "Task Created", Toast.LENGTH_SHORT).show();
                    finish();

                }else{
                    Toast.makeText(CreateNewTaskActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
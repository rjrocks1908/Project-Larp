package com.haxon.larp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.haxon.larp.Designing.CustomProgressBar;
import com.haxon.larp.Models.InfoModel;
import com.haxon.larp.R;

public class InfoTakeActivity extends AppCompatActivity {

    CheckBox waterHeater,elecFurnace,xbox,AC,spaceHeat, tvPlasma;
    CheckBox tvLED,cable,cfl,vaccumm,hairdry,fridge,kettle,oven,toastoven;
    CheckBox cellPhone,pc,laptop,wifiRouter,ps4;
    Button next;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_take);

        waterHeater = findViewById(R.id.info_waterHeater);
        elecFurnace = findViewById(R.id.info_elecFurnace);
        xbox = findViewById(R.id.info_xbox);
        AC = findViewById(R.id.info_AC);
        spaceHeat = findViewById(R.id.info_spaceHeat);
        tvPlasma = findViewById(R.id.info_tvplasma);
        tvLED = findViewById(R.id.info_tvLED);
        cable = findViewById(R.id.info_cable);
        cfl = findViewById(R.id.info_cfl);
        vaccumm = findViewById(R.id.info_vaccum);
        hairdry = findViewById(R.id.info_hairdry);
        fridge = findViewById(R.id.info_fridge);
        kettle = findViewById(R.id.info_kettle);
        oven = findViewById(R.id.info_oven);
        toastoven = findViewById(R.id.info_toasteroven);
        cellPhone = findViewById(R.id.info_cellPhone);
        pc = findViewById(R.id.info_pc);
        laptop = findViewById(R.id.info_laptop);
        wifiRouter = findViewById(R.id.info_wifiRouter);
        ps4 = findViewById(R.id.info_ps4);
        next = findViewById(R.id.info_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadChecks();

            }
        });

    }

    private void uploadChecks() {

        CustomProgressBar dialog = new CustomProgressBar(InfoTakeActivity.this);
        dialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );

        SharedPreferences prefs = getApplicationContext().getSharedPreferences("mypref", 0);
        String userName = prefs.getString("username", null);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Appliances");

        InfoModel model = new InfoModel(
                waterHeater.isChecked(),
                elecFurnace.isChecked(),
                xbox.isChecked(),
                AC.isChecked(),
                spaceHeat.isChecked(),
                tvPlasma.isChecked(),
                tvLED.isChecked(),
                cable.isChecked(),
                cfl.isChecked(),
                vaccumm.isChecked(),
                hairdry.isChecked(),
                fridge.isChecked(),
                kettle.isChecked(),
                oven.isChecked(),
                toastoven.isChecked(),
                cellPhone.isChecked(),
                pc.isChecked(),
                laptop.isChecked(),
                wifiRouter.isChecked(),
                ps4.isChecked()
        );

        reference.child(userName).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isComplete()){

                    dialog.dismiss();
                    Toast.makeText(InfoTakeActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(InfoTakeActivity.this, DashboardActivity.class));
                    finish();
                }else{
                    Toast.makeText(InfoTakeActivity.this, "Not Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
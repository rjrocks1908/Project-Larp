package com.haxon.larp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.haxon.larp.Adapters.RulesAdapter;
import com.haxon.larp.Adapters.ThresholdAdapter;
import com.haxon.larp.CONSTANTS;
import com.haxon.larp.R;

public class ThresholdCounterActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String[] appliances = new String[] {"waterHeater","elecFurnace","xbox","AC","spaceHeat","tvPlasma",
            "tvLED","cable","cfl","vaccumm","hairdry","fridge","kettle","oven","toastoven", "cellPhone","pc","laptop","wifiRouter","ps4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threshold_counter);

//        recyclerView = findViewById(R.id.thres_recyclerView);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ThresholdCounterActivity.this);
//        linearLayoutManager.setReverseLayout(true);
//        linearLayoutManager.setStackFromEnd(true);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        ThresholdAdapter adapter = new ThresholdAdapter();
//        recyclerView.setAdapter(adapter);


    }
}
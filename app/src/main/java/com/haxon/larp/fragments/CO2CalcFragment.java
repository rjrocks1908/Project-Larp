package com.haxon.larp.fragments;

import static com.haxon.larp.Utils.appli;
import static com.haxon.larp.Utils.switches;
import static com.haxon.larp.Utils.threshold;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.haxon.larp.Activities.DashboardActivity;
import com.haxon.larp.Activities.ThresholdCounterActivity;
import com.haxon.larp.R;
import com.haxon.larp.Utils;

import java.util.HashMap;

public class CO2CalcFragment extends Fragment {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;

    SwitchMaterial waterHeater,elecFurnace,xbox,AC,spaceHeat, tvPlasma;
    SwitchMaterial tvLED,cable,cfl,vaccumm,hairdry,fridge,kettle,oven,toastoven;
    SwitchMaterial cellPhone,pc,laptop,wifiRouter,ps4;
    Button next;

    String appl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_co2calc,container,false);

        waterHeater = view.findViewById(R.id.calc_waterHeater);
        elecFurnace = view.findViewById(R.id.calc_elecFurnace);
        xbox = view.findViewById(R.id.calc_xbox);
        AC = view.findViewById(R.id.calc_AC);
        spaceHeat = view.findViewById(R.id.calc_spaceHeat);
        tvPlasma = view.findViewById(R.id.calc_tvplasma);
        tvLED = view.findViewById(R.id.calc_tvLED);
        cable = view.findViewById(R.id.calc_cable);
        cfl = view.findViewById(R.id.calc_cfl);
        vaccumm = view.findViewById(R.id.calc_vaccum);
        hairdry = view.findViewById(R.id.calc_hairdry);
        fridge = view.findViewById(R.id.calc_fridge);
        kettle = view.findViewById(R.id.calc_kettle);
        oven = view.findViewById(R.id.calc_oven);
        toastoven = view.findViewById(R.id.calc_toasteroven);
        cellPhone = view.findViewById(R.id.calc_cellPhone);
        pc = view.findViewById(R.id.calc_pc);
        laptop = view.findViewById(R.id.calc_laptop);
        wifiRouter = view.findViewById(R.id.calc_wifiRouter);
        ps4 = view.findViewById(R.id.calc_ps4);
        next = view.findViewById(R.id.calc_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkingSwitches();
                Fragment fragment = new HomeFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

//        switches.clear();



        return view;

    }

    private void checkingSwitches() {

        if (waterHeater.isChecked()){
            switches.put("waterHeater", "Water Heater");
            appli.add("waterHeater");
            threshold.add(4438);
        }
        if (elecFurnace.isChecked()) {
            switches.put("elecFurnace", "Electric Furnace");
            appli.add("elecFurnace");
            threshold.add(1805);
        }
        if (xbox.isChecked()){
            switches.put("xbox", "XBOX");
            appli.add("xbox");
            threshold.add(1973);
        }
        if (AC.isChecked()){
            switches.put("AC", "AC");
            appli.add("AC");
            threshold.add(1973);
        }
        if (spaceHeat.isChecked()){
            switches.put("spaceHeat", "Space Heat");
            appli.add("spaceHeat");
            threshold.add(9863);
        }
        if (tvPlasma.isChecked()){
            switches.put("tvPlasma", "Plasma TV");
            appli.add("tvPlasma");
            threshold.add(9863);
        }
        if (tvLED.isChecked()){
            switches.put("tvLED", "LED TV");
            appli.add("tvLED");
            threshold.add(75945);
        }
        if (cable.isChecked()){
            switches.put("cable", "Cable");
            appli.add("cable");
            threshold.add(16767);
        }
        if (cfl.isChecked()){
            switches.put("cfl", "CFL Light");
            appli.add("cfl");
            threshold.add(197);
        }
        if (vaccumm.isChecked()){
            switches.put("vaccumm", "Vacuum Cleaner");
            appli.add("vaccumm");
            threshold.add(769);
        }
        if (hairdry.isChecked()){
            switches.put("hairdry", "Hair Dryer");
            appli.add("hairdry");
            threshold.add(562);
        }
        if (fridge.isChecked()){
            switches.put("fridge", "Fridge");
            appli.add("fridge");
            threshold.add(14795);
        }
        if (kettle.isChecked()){
            switches.put("kettle", "Kettle");
            appli.add("kettle");
            threshold.add(118);
        }
        if (oven.isChecked()){
            switches.put("oven", "Oven");
            appli.add("oven");
            threshold.add(475);
        }
        if (toastoven.isChecked()){
            switches.put("toastoven", "Toast Oven");
            appli.add("toastoven");
            threshold.add(720);
        }
        if (cellPhone.isChecked()){
            switches.put("cellPhone", "Cell Phone");
            appli.add("cellPhone");
            threshold.add(592);
        }
        if (pc.isChecked()){
            switches.put("pc", "Desktop Computer");
            appli.add("pc");
            threshold.add(3600);
        }
        if (laptop.isChecked()){
            switches.put("laptop", "Laptop");
            appli.add("laptop");
            threshold.add(9863);
        }
        if (wifiRouter.isChecked()){
            switches.put("wifiRouter", "WifiRouter");
            appli.add("wifiRouter");
            threshold.add(86400);
        }
        if (ps4.isChecked()){
            switches.put("ps4", "PS4");
            appli.add("ps4");
            threshold.add(9863);
        }
    }

    void calculateCO2(){

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Item");

        Query applianceName = reference.orderByChild("name").equalTo(appl);
        applianceName.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String value = snapshot.child("EnergyUse").getValue(String.class);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}

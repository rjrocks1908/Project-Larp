package com.haxon.larp.fragments;

import static com.haxon.larp.Utils.switches;

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

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
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

        switches.clear();

        if (waterHeater.isChecked()){
            switches.put("waterHeater", "Water Heater");
        }
        if (elecFurnace.isChecked()) {
            switches.put("elecFurnace", "Electric Furnace");
        }
        if (xbox.isChecked()){
            switches.put("xbox", "XBOX");
        }
        if (AC.isChecked()){
            switches.put("AC", "AC");
        }
        if (spaceHeat.isChecked()){
            switches.put("spaceHeat", "Space Heat");
        }
        if (tvPlasma.isChecked()){
            switches.put("tvPlasma", "Plasma TV");
        }
        if (tvLED.isChecked()){
            switches.put("tvLED", "LED TV");
        }
        if (cable.isChecked()){
            switches.put("cable", "Cable");
        }
        if (cfl.isChecked()){
            switches.put("cfl", "CFL Light");
        }
        if (vaccumm.isChecked()){
            switches.put("vaccumm", "Vacuum Cleaner");
        }
        if (hairdry.isChecked()){
            switches.put("hairdry", "Hair Dryer");
        }
        if (fridge.isChecked()){
            switches.put("fridge", "Fridge");
        }
        if (kettle.isChecked()){
            switches.put("kettle", "Kettle");
        }
        if (oven.isChecked()){
            switches.put("oven", "Oven");
        }
        if (toastoven.isChecked()){
            switches.put("toastoven", "Toast Oven");
        }
        if (cellPhone.isChecked()){
            switches.put("cellPhone", "Cell Phone");
        }
        if (pc.isChecked()){
            switches.put("pc", "Desktop Computer");
        }
        if (laptop.isChecked()){
            switches.put("laptop", "Laptop");
        }
        if (wifiRouter.isChecked()){
            switches.put("wifiRouter", "WifiRouter");
        }
        if (ps4.isChecked()){
            switches.put("ps4", "PS4");
        }

        return view;

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

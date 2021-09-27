package com.haxon.larp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.haxon.larp.R;

import java.util.HashMap;

public class CO2CalcFragment extends Fragment {

    private Spinner appliances;
    private EditText dailyUse;
    private Button addAppliances;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;
    HashMap<String, Integer> appliancesData = new HashMap<String, Integer>();
    String appl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_co2calc,container,false);

        appliances = view.findViewById(R.id.co2_appliances);
        dailyUse = view.findViewById(R.id.co2_dailyUse);
        addAppliances = view.findViewById(R.id.addAppliances);

        ArrayAdapter<CharSequence> chooseApplianceAdapter = ArrayAdapter.createFromResource(
                requireActivity().getApplicationContext(),
                R.array.appliances_array,
                android.R.layout.simple_spinner_item
        );
        chooseApplianceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appliances.setAdapter(chooseApplianceAdapter);
        appl = appliances.getSelectedItem().toString();



        addAppliances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appliancesData.put(appl, Integer.parseInt(dailyUse.getText().toString()));
                dailyUse.setText("");
                Toast.makeText(requireContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });

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

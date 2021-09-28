package com.haxon.larp.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.haxon.larp.Activities.CreateNewTaskActivity;
import com.haxon.larp.Adapters.ThresholdAdapter;
import com.haxon.larp.CONSTANTS;
import com.haxon.larp.Models.MyGoalsModel;
import com.haxon.larp.R;
import com.haxon.larp.Utils;

import java.util.Random;

public class HomeFragment extends Fragment {

    FloatingActionButton addTask;
    RecyclerView recyclerView, workingList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    TextView tip;
    Random myRandom;
    private String[] appliances = new String[] {"waterHeater","elecFurnace","xbox","AC","spaceHeat","tvPlasma",
            "tvLED","cable","cfl","vaccumm","hairdry","fridge","kettle","oven","toastoven", "cellPhone","pc","laptop","wifiRouter","ps4"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        addTask = view.findViewById(R.id.home_addTask);
        recyclerView = view.findViewById(R.id.home_recyclerView);
        workingList = view.findViewById(R.id.home_RVforTimer);
        tip = view.findViewById(R.id.home_tip);

        myRandom = new Random();
        tip.setText(CONSTANTS.tips[myRandom.nextInt(CONSTANTS.tips.length - 1)]);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        ThresholdAdapter adapter = new ThresholdAdapter(appliances, requireContext());
        workingList.setLayoutManager(new LinearLayoutManager(requireContext()));
        workingList.setAdapter(adapter);
        Log.v("T", Utils.switches+"");

        loadTasks();

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), CreateNewTaskActivity.class));
            }
        });

        return view;
    }

    private void loadTasks() {

        SharedPreferences prefs = requireContext().getSharedPreferences("mypref", 0);
        String username = prefs.getString("username",null);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Tasks").child(username);

        FirebaseRecyclerOptions<MyGoalsModel> options = new FirebaseRecyclerOptions.Builder<MyGoalsModel>()
                        .setQuery(reference, MyGoalsModel.class)
                        .build();

        FirebaseRecyclerAdapter<MyGoalsModel, MyViewHolder> adapter = new FirebaseRecyclerAdapter<MyGoalsModel, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i, @NonNull MyGoalsModel myGoalsModel) {

                myViewHolder.taskDate.setText(myGoalsModel.getDates());
                myViewHolder.taskTitle.setText(myGoalsModel.getGoal());
                myViewHolder.taskDesc.setText(myGoalsModel.getGoalNotes());

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_task_layout, parent, false);
                return new MyViewHolder(view);

            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView taskDate, taskTitle, taskDesc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            taskDate = itemView.findViewById(R.id.home_taskDate);
            taskTitle = itemView.findViewById(R.id.home_taskTitle);
            taskDesc = itemView.findViewById(R.id.home_taskDesc);

        }
    }
}

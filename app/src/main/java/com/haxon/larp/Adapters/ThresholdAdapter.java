package com.haxon.larp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haxon.larp.Activities.DashboardActivity;
import com.haxon.larp.R;
import com.haxon.larp.Utils;

import java.util.Locale;

public class ThresholdAdapter extends RecyclerView.Adapter<ThresholdAdapter.ThresholdViewHolder>{

    final String[] data;
    int seconds = 0;
    boolean running = true;
    Context context;
    public ThresholdAdapter(String[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ThresholdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_switchon_appliances, parent, false);
        return new ThresholdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThresholdViewHolder holder, @SuppressLint("RecyclerView") int position) {

        String title = Utils.switches.get(Utils.appli.get(position));
        Log.v("T", title + ":" );
        holder.app_applianceName.setText(title);

//        Handler handler = new Handler();
//
        holder.stopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.switches.remove(data[position]);
                if (holder.timerUp != null){
                    holder.timerUp.cancel();
                }
                Intent intent = new Intent(context, DashboardActivity.class);
                context.startActivity(intent);

            }
        });

        holder.timerUp = new CountDownTimer(99999999, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {



            }

            @Override
            public void onFinish() {

            }
        }.start();
//
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//
//                int hours = seconds / 3600;
//                int minutes = (seconds % 3600) / 60;
//                int sec =   seconds % 60;
//
//                String time = String.format(Locale.getDefault(),
//                        "%d:%02d:%02d",
//                        hours,minutes,sec);
//
//                holder.timer.setText(time);
//
//                if (running){
//
//                    seconds++;
//
//                }
//
//                handler.postDelayed((Runnable) context, 1000);
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return Utils.switches.size();
    }

    private void runTimer() {



    }

    public class ThresholdViewHolder extends RecyclerView.ViewHolder{

        TextView app_applianceName, timer;
        Button stopTimer;
        CountDownTimer timerUp;

        public ThresholdViewHolder(@NonNull View itemView) {
            super(itemView);

            app_applianceName = itemView.findViewById(R.id.app_applianceName);
            timer = itemView.findViewById(R.id.timer);
            stopTimer = itemView.findViewById(R.id.stopTimer);

        }
    }

}

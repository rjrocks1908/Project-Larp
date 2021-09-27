package com.haxon.larp.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.haxon.larp.R;

public class ScreenOnFragment extends Fragment {

    BroadcastReceiver broadcastReceiver;
    private long startTimer;
    private long endTimer;
    private long screenOnTimeSingle;
    private long screenOnTime;
    private final long TIME_ERROR = 1000;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_screenon,container,false);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
                    startTimer = System.currentTimeMillis();
                }
                else if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
                    endTimer = System.currentTimeMillis();
                    screenOnTimeSingle = endTimer - startTimer;

                    if(screenOnTimeSingle < TIME_ERROR) {
                        screenOnTime += screenOnTime;
                        Log.i("SCREEN", screenOnTime + "");
                    }
                }
            }
        };

        return view;

    }

}

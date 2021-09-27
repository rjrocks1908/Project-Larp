package com.haxon.larp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haxon.larp.R;

public class RulesAdapter extends RecyclerView.Adapter<RulesAdapter.RulesViewHolder>{

    private String[] data;

    public RulesAdapter(String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RulesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_items_layout, parent, false);
        return new RulesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RulesViewHolder holder, int position) {

        String title = data[position];
        holder.tips_details.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RulesViewHolder extends RecyclerView.ViewHolder{

        TextView tips_details;

        public RulesViewHolder(@NonNull View itemView) {
            super(itemView);

            tips_details = itemView.findViewById(R.id.tips_details);

        }
    }

}

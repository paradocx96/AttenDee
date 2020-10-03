package com.androx.attendee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolderEvent>  {

    private Context context;
    private ArrayList event_id, event_name, event_date, event_remark;

    EventAdapter(Context context, ArrayList event_id, ArrayList event_name, ArrayList event_date, ArrayList event_remark) {
        this.context = context;
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_date = event_date;
        this.event_remark = event_remark;
    }


    @NonNull
    @Override
    public EventAdapter.MyViewHolderEvent onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.MyViewHolderEvent holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolderEvent extends RecyclerView.ViewHolder {
        public MyViewHolderEvent(@NonNull View itemView) {
            super(itemView);
        }
    }
}

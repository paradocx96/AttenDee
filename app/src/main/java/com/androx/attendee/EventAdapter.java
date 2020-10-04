package com.androx.attendee;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.event_list, parent, false);
        return new MyViewHolderEvent(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.MyViewHolderEvent holder,final int position) {

        holder.id.setText(String.valueOf(event_id.get(position)));
        holder.name.setText(String.valueOf(event_name.get(position)));
        holder.datetime.setText(String.valueOf(event_date.get(position)));
        holder.remark.setText(String.valueOf(event_remark.get(position)));

        holder.mainLayoutEventList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewAttendeeActivity.class);
                intent.putExtra("id", String.valueOf(event_id.get(position)));
                intent.putExtra("name", String.valueOf(event_name.get(position)));
                intent.putExtra("datetime", String.valueOf(event_date.get(position)));
                intent.putExtra("remark", String.valueOf(event_remark.get(position)));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return event_id.size();
    }

    public class MyViewHolderEvent extends RecyclerView.ViewHolder {

        TextView id, name, datetime, remark;
        LinearLayout mainLayoutEventList;

        public MyViewHolderEvent(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.event_id_1);
            name = itemView.findViewById(R.id.event_name_1);
            datetime = itemView.findViewById(R.id.event_datetime_1);
            remark = itemView.findViewById(R.id.event_remark_1);
            mainLayoutEventList = itemView.findViewById(R.id.mainLayoutEventList);
        }
    }
}

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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolderAttendance> {

    private Context context;
    private ArrayList attend_id, attend_name, attend_datetime, attend_remark;

    CustomAdapter(Context context, ArrayList attend_id, ArrayList attend_name, ArrayList attend_datetime, ArrayList attend_remark) {
        this.context = context;
        this.attend_id = attend_id;
        this.attend_name = attend_name;
        this.attend_datetime = attend_datetime;
        this.attend_remark = attend_remark;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolderAttendance onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.attendance_list, parent, false);
        return new MyViewHolderAttendance(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolderAttendance holder, final int position) {

        holder.id.setText(String.valueOf(attend_id.get(position)));
        holder.name.setText(String.valueOf(attend_name.get(position)));
        holder.datetime.setText(String.valueOf(attend_datetime.get(position)));
        holder.remark.setText(String.valueOf(attend_remark.get(position)));

        holder.mainLayoutAttendanceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewAttendeeActivity.class);
                intent.putExtra("id", String.valueOf(attend_id.get(position)));
                intent.putExtra("name", String.valueOf(attend_name.get(position)));
                intent.putExtra("datetime", String.valueOf(attend_datetime.get(position)));
                intent.putExtra("remark", String.valueOf(attend_remark.get(position)));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return attend_id.size();
    }

    public class MyViewHolderAttendance extends RecyclerView.ViewHolder {

        TextView id, name, datetime, remark;
        LinearLayout mainLayoutAttendanceList;

        public MyViewHolderAttendance(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.attendance_id_1);
            name = itemView.findViewById(R.id.attendance_name_1);
            datetime = itemView.findViewById(R.id.attendance_datetime_1);
            remark = itemView.findViewById(R.id.attendance_remark_1);
            mainLayoutAttendanceList = itemView.findViewById(R.id.mainLayoutAttendanceList);
        }
    }
}

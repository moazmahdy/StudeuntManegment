package com.example.studeuntmanegment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter <StudentAdapter.StudentViewHolder> {

    ArrayList<StudentData> list;

    public StudentAdapter(ArrayList<StudentData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item_model , parent , false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, @SuppressLint("RecyclerView") int position) {
        StudentData item = list.get(position);
        holder.studentID.setText(item.id);
        holder.studentName.setText(item.name);
        holder.studentPhone.setText(item.phone);
        holder.studentEmail.setText(item.email);
        holder.ic_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onImageClickListener != null){
                    onImageClickListener.onClick(position , item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    OnItemClickListener onImageClickListener ;
    interface OnItemClickListener{
        public void onClick(int index, StudentData item);
    }
    public class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView studentID;
        TextView studentName;
        TextView studentPhone;
        TextView studentEmail;
        ImageView ic_delete;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentID = itemView.findViewById(R.id.idEnteredTV);
            studentName = itemView.findViewById(R.id.nameEnteredTV);
            studentPhone = itemView.findViewById(R.id.phoneEnteredTV);
            studentEmail = itemView.findViewById(R.id.emailEnteredTV);
            ic_delete = itemView.findViewById(R.id.deleteIC);
        }
    }
}

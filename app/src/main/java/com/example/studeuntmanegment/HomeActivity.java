package com.example.studeuntmanegment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    FloatingActionButton addFloatingActionButton;
    Button addButton;
    RecyclerView studentsRV;
    static StudentAdapter adapter;
    static AddButtonSheetFragment addButtonSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addFloatingActionButton = findViewById(R.id.addFloatingActionButton);
        studentsRV = findViewById(R.id.studentRV);
        adapter = new StudentAdapter(DataClass.list);
        studentsRV.setAdapter(adapter);
        addButton = findViewById(R.id.addButton);
        adapter.onImageClickListener = new StudentAdapter.OnItemClickListener() {
            @Override
            public void onClick(int index, StudentData item) {
                DataClass.list.remove(index);
                adapter.notifyDataSetChanged();
            }
        };
        addFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 addButtonSheet= new AddButtonSheetFragment();
                addButtonSheet.show(getSupportFragmentManager().beginTransaction(), "");
            }
        });
    }
}
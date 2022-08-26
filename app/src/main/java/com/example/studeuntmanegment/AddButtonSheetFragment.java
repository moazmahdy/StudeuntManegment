package com.example.studeuntmanegment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AddButtonSheetFragment extends BottomSheetDialogFragment {

    TextInputLayout studentIdTextInput;
    TextInputLayout studentNameTextInput;
    TextInputLayout studentPhoneTextInput;
    TextInputLayout studentEmailTextInput;
    Button addButton;

    public AddButtonSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_button_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        studentNameTextInput = view.findViewById(R.id.studentNameET);
        studentPhoneTextInput = view.findViewById(R.id.studentPhoneET);
        studentEmailTextInput = view.findViewById(R.id.studentEmailET);
        studentIdTextInput = view.findViewById(R.id.studentIdET);
        addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentNameTextInput.getEditText().getText().toString().isEmpty()) {
                    studentNameTextInput.setError("Valid data");
                    return;
                } else {
                    studentNameTextInput.setError(null);
                }
                if (studentPhoneTextInput.getEditText().getText().toString().isEmpty()) {
                    studentPhoneTextInput.setError("Valid data");
                    return;
                } else {
                    studentPhoneTextInput.setError(null);
                }
                if (studentEmailTextInput.getEditText().getText().toString().isEmpty()) {
                    studentEmailTextInput.setError("Valid data");
                    return;
                } else {
                    studentEmailTextInput.setError(null);
                }
                if (studentIdTextInput.getEditText().getText().toString().isEmpty()) {
                    studentEmailTextInput.setError("Valid data");
                    return;
                } else {
                    studentIdTextInput.setError(null);
                }
                StudentData student = new StudentData(studentIdTextInput.getEditText().getText().toString(),
                        studentNameTextInput.getEditText().getText().toString(),
                        studentPhoneTextInput.getEditText().getText().toString(),
                        studentEmailTextInput.getEditText().getText().toString());
                DataClass.list.add(student);
                HomeActivity.adapter.notifyDataSetChanged();
                HomeActivity.addButtonSheet.dismiss();
            }
        });
    }
//    OnAddClicked onAddClicked = null;
//    interface OnAddClicked{
//      public void onAddClicked(StudentData student);
//      }
}
package com.example.lv1.Model;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.lv1.CreateNewRecordActivity;
import com.example.lv1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class PersonalInfoFragment extends Fragment {
    private TextInputEditText ime;
    private TextInputEditText prezime;
    private TextInputEditText datumRodenja;
    private Button btn;

    Adapter adapter;
    FragmentActivity listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof CreateNewRecordActivity)
        {
            this.listener = (FragmentActivity)context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_personal,container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ime = (TextInputEditText)view.findViewById(R.id.inputIme2);
        prezime = (TextInputEditText)view.findViewById(R.id.inputPrezime2);
        datumRodenja = (TextInputEditText)view.findViewById(R.id.inputDatumRodenja2);
        btn = (Button)view.findViewById(R.id.button);
    }
}

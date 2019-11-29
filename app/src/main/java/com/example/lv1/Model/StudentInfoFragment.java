package com.example.lv1.Model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lv1.R;
import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoFragment extends Fragment {

    private TextInputEditText predmet;
    private TextInputEditText profesor;
    private TextInputEditText godina;
    private TextInputEditText predavanja;
    private TextInputEditText vjezbe;
    private Button btn2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_student_info,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        predmet = (TextInputEditText)view.findViewById(R.id.inputImePredmeta2);
        profesor = (TextInputEditText)view.findViewById(R.id.inputImeProfesora2);
        godina = (TextInputEditText)view.findViewById(R.id.inputGodina2);
        predavanja = (TextInputEditText)view.findViewById(R.id.inputPredavanja2);
        vjezbe = (TextInputEditText)view.findViewById(R.id.inputLV2);
    }
}

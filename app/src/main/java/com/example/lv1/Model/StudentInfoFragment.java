package com.example.lv1.Model;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class StudentInfoFragment extends Fragment {
    private StudentInfoListener studentInfoListener;
    private TextInputEditText predmet;
    private TextInputEditText profesor;
    private TextInputEditText godina;
    private TextInputEditText predavanja;
    private TextInputEditText vjezbe;
    private Button btn2;
    Adapter adapter;
    FragmentActivity listener;

    public interface StudentInfoListener{
        void GetStudentInfo(String predmet, String profesor, String godina, String predavanja, String vjezbe);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof CreateNewRecordActivity)
        {
            this.listener = (FragmentActivity)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

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

        godina.addTextChangedListener(InputCheck);
        predmet.addTextChangedListener(InputCheck);
        profesor.addTextChangedListener(InputCheck);
        predavanja.addTextChangedListener(InputCheck);
        vjezbe.addTextChangedListener(InputCheck);
    }


    private TextWatcher InputCheck = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String sPredmet = predmet.getText().toString();
            String sProfesor = profesor.getText().toString();
            String sGodina = godina.getText().toString();
            String sPredavanja = predavanja.getText().toString();
            String sVjezbe = vjezbe.getText().toString();

            if(sPredmet!=null && sProfesor != null && sGodina!= null && sPredavanja!= null &sVjezbe!= null){
                studentInfoListener.GetStudentInfo(sPredmet,sProfesor,sGodina,sPredavanja,sVjezbe);

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void editTextViewStudent(String sPredmet,String sProfesor,String sGodina, String sPredavanja, String sVjezbe)
    {
        predmet.setText(sPredmet);
        profesor.setText(sProfesor);
        godina.setText(sGodina);
        predavanja.setText(sPredavanja);
        vjezbe.setText(sVjezbe);
    }
}

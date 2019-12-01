package com.example.lv1.Model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.lv1.CreateNewRecordActivity;
import com.example.lv1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class PersonalInfoFragment extends Fragment {
    private PersonalInfoListener personalFragmentListener;
    private TextInputEditText ime;
    private TextInputEditText prezime;
    private TextInputEditText datumRodenja;
    private Button btn;

    Adapter adapter;
    FragmentActivity listener;

    public interface PersonalInfoListener{
        void GetPersonalInfo(String sIme, String sPrezime, String sDatumRodenja);
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
        ime = view.findViewById(R.id.inputIme2);
        prezime = view.findViewById(R.id.inputPrezime2);
        datumRodenja = view.findViewById(R.id.inputDatumRodenja2);
        btn = view.findViewById(R.id.button);

        ime.addTextChangedListener(InputCheck);
        prezime.addTextChangedListener(InputCheck);
        datumRodenja.addTextChangedListener(InputCheck);

    }

    private TextWatcher InputCheck = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String sIme = ime.getText().toString();
            String sPrezime = prezime.getText().toString();
            String sDatumRodenja = datumRodenja.getText().toString();


            if(sIme!=null && sPrezime != null && sDatumRodenja!= null){

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void EditTextView(String sIme, String sPrezime, String sDatumRodenja)
    {
        ime.setText(sIme);
        prezime.setText(sPrezime);
        datumRodenja.setText(sDatumRodenja);
    }
}

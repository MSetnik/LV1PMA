package com.example.lv1.Model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.lv1.CreateNewRecordActivity;
import com.example.lv1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class PersonalInfoFragment extends Fragment {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private PersonalInfoListener personalFragmentListener;
    private TextInputEditText ime;
    private TextInputEditText prezime;
    private TextInputEditText datumRodenja;
    private ImageView img;
    private Button btn;
    private String sIme, sPrezime, sDatum;

    Adapter adapter;
    FragmentActivity listener;

    public interface PersonalInfoListener{
        void GetPersonalInfo(String ime, String prezime, String datumRodenja);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof PersonalInfoListener)
        {
            personalFragmentListener = (PersonalInfoListener)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        personalFragmentListener = null;
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
        img = view.findViewById(R.id.imageView);

        ime.addTextChangedListener(InputCheck);
        prezime.addTextChangedListener(InputCheck);
        datumRodenja.addTextChangedListener(InputCheck);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

    }

    private TextWatcher InputCheck = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


        }

        @Override
        public void afterTextChanged(Editable s) {

             sIme = ime.getText().toString();
             sPrezime = prezime.getText().toString();
             sDatum= datumRodenja.getText().toString();

            personalFragmentListener.GetPersonalInfo(sIme,sPrezime,sDatum);
        }
    };

    public void EditTextView(String sIme, String sPrezime, String sDatumRodenja)
    {
        ime.setText(sIme);
        prezime.setText(sPrezime);
        datumRodenja.setText(sDatumRodenja);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        }
    }
}

package com.example.lv1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lv1.Model.MyDataStorage;
import com.example.lv1.Model.Student;
import com.example.lv1.PocetniActivity;
import com.example.lv1.R;

public class SummaryFragment extends Fragment implements PersonalInfoFragment.PersonalInfoListener, StudentInfoFragment.StudentInfoListener {
    private TextView TWIme;
    private TextView TWPrezime;
    private TextView TWPredmet;
    private TextView TWProfesor;
    private TextView TWPredavanja;
    private TextView TWVjezbe;
    private TextView TWDatumRodenja;
    private TextView TWGodina;
    private Button button;
    private String sDatumRodenja;
    private String mIme, mPrezime, mDatum, mPredmet,mProfesor, mGodina, mPredavanja, mVjezbe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_summary,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TWIme = (TextView)view.findViewById(R.id.textViewIme);
        TWPrezime = (TextView)view.findViewById(R.id.textViewPrezime);
        TWDatumRodenja=view.findViewById(R.id.textviewdatum);
        TWGodina=view.findViewById(R.id.textviewgodina);
        TWPredmet = (TextView)view.findViewById(R.id.textViewPredmet);
        TWProfesor = (TextView)view.findViewById(R.id.textViewProfesor);
        TWPredavanja = (TextView)view.findViewById(R.id.textViewPredavanja);
        TWVjezbe = (TextView)view.findViewById(R.id.textViewVjezbe);
        button = (Button)view.findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDataStorage myDataStorage = MyDataStorage.getInstance();
                Student student = new Student(mIme,mPrezime,mDatum, mPredmet,mProfesor,mGodina, mPredavanja,mVjezbe);
                myDataStorage.addStudent(student);
                Intent intent = new Intent(getActivity(), PocetniActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });
    }


    @Override
    public void GetPersonalInfo(String ime, String prezime, String datumRodenja) {
        mIme = ime;
        mPrezime = prezime;
        mDatum = datumRodenja;

        TWIme.setText(ime);
        TWPrezime.setText(prezime);
        TWDatumRodenja.setText(datumRodenja);

    }

    @Override
    public void GetStudentInfo(String predmet, String profesor, String godina, String predavanja, String vjezbe) {
        mPredmet = predmet;
        mProfesor = profesor;
        mGodina = godina;
        mPredavanja = predavanja;
        mVjezbe = vjezbe;
        TWGodina.setText(godina);
        TWPredmet.setText(predmet);
        TWProfesor.setText(profesor);
        TWPredavanja.setText(predavanja);
        TWVjezbe.setText(vjezbe);

    }
}

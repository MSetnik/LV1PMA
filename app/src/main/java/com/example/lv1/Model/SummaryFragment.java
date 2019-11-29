package com.example.lv1.Model;

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

import com.example.lv1.PocetniActivity;
import com.example.lv1.R;

public class SummaryFragment extends Fragment {
    private TextView ime;
    private TextView prezime;
    private TextView predmet;
    private TextView profesor;
    private TextView predavanja;
    private TextView vjezbe;
    private Button button;
    private String datumRodenja;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_summary,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ime = (TextView)view.findViewById(R.id.textViewIme);
        prezime = (TextView)view.findViewById(R.id.textViewPrezime);
        predmet = (TextView)view.findViewById(R.id.textViewPredmet);
        profesor = (TextView)view.findViewById(R.id.textViewProfesor);
        predavanja = (TextView)view.findViewById(R.id.textViewPredavanja);
        vjezbe = (TextView)view.findViewById(R.id.textViewVjezbe);
        button = (Button)view.findViewById(R.id.button3);
    }


}

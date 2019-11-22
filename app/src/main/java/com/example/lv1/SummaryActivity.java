package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private TextView ime;
    private TextView prezime;
    private TextView predmet;
    private TextView profesor;
    private TextView predavanja;
    private TextView vjezbe;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ime = (TextView)findViewById(R.id.textViewIme);
        prezime = (TextView)findViewById(R.id.textViewPrezime);
        predmet = (TextView)findViewById(R.id.textViewPredmet);
        profesor = (TextView)findViewById(R.id.textViewProfesor);
        predavanja = (TextView)findViewById(R.id.textViewPredavanja);
        vjezbe = (TextView)findViewById(R.id.textViewVjezbe);

        button = (Button)findViewById(R.id.button3);

        final Bundle oExtras = getIntent().getExtras();


        final String sIme = oExtras.getString("ime");
        final String sPrezime =oExtras.getString("prezime");
        final String sPredmet =oExtras.getString("predmet");
        final String sProfesor =oExtras.getString("profesor");
        final String sPredavanja =oExtras.getString("predavanja");
        final String sVjezbe =oExtras.getString("vjezbe");

        ime.setText(sIme);
        prezime.setText(sPrezime);
        predmet.setText(sPredmet);
        profesor.setText(sProfesor);
        predavanja.setText(sPredavanja);
        vjezbe.setText(sVjezbe);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PocetniActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });
    }
}

package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    private TextInputEditText predmet;
    private TextInputEditText profesor;
    private TextInputEditText godina;
    private TextInputEditText predavanja;
    private TextInputEditText vjezbe;

    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);


        predmet = (TextInputEditText)findViewById(R.id.inputImePredmeta2);
        profesor = (TextInputEditText)findViewById(R.id.inputImeProfesora2);
        godina = (TextInputEditText)findViewById(R.id.inputGodina2);
        predavanja = (TextInputEditText)findViewById(R.id.inputPredavanja2);
        vjezbe = (TextInputEditText)findViewById(R.id.inputLV2);

        btn2 = (Button)findViewById(R.id.button2);
        final Bundle oExtras = getIntent().getExtras();
        final String ime =oExtras.getString("ime");
        final String prezime =oExtras.getString("prezime");
        final String datumRodenja =oExtras.getString("datumRodenja");

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SummaryActivity.class);
                intent.putExtra("predmet", predmet.getText().toString());
                intent.putExtra("profesor", profesor.getText().toString());
                intent.putExtra("godina", godina.getText().toString());
                intent.putExtra("predavanja", predavanja.getText().toString());
                intent.putExtra("vjezbe", vjezbe.getText().toString());
                intent.putExtra("ime", ime);
                intent.putExtra("prezime", prezime);
                intent.putExtra("datumRodenja", datumRodenja);
                startActivity(intent);
            }
        });
    }
}

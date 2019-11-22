package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class PersonalInfoActivity extends AppCompatActivity {

    private TextInputEditText ime;
    private TextInputEditText prezime;
    private TextInputEditText datumRodenja;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        ime = (TextInputEditText)findViewById(R.id.inputIme2);
        prezime = (TextInputEditText)findViewById(R.id.inputPrezime2);
        datumRodenja = (TextInputEditText)findViewById(R.id.inputDatumRodenja2);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),StudentInfoActivity.class);
                intent.putExtra("ime", ime.getText().toString());
                intent.putExtra("prezime", prezime.getText().toString());
                intent.putExtra("datumRodenja", datumRodenja.getText().toString());
                startActivity(intent);
            }
        });


    }
}

package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private TextView ime;
    private TextView predmet;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ime = (TextView)findViewById(R.id.textView1);
        predmet = (TextView)findViewById(R.id.textView2);
        button = (Button)findViewById(R.id.button3);

        final Bundle oExtras = getIntent().getExtras();


        final String sIme = oExtras.getString("input1");
        final String sPredmet =oExtras.getString("input2");

        ime.setText(sIme);
        predmet.setText(sPredmet);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });
    }
}

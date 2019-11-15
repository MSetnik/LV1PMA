package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    private TextInputEditText input2;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);


        input2 = (TextInputEditText)findViewById(R.id.input2);
        btn2 = (Button)findViewById(R.id.button2);
        final Bundle oExtras = getIntent().getExtras();
        final String sIme =oExtras.getString("input");

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SummaryActivity.class);
                intent.putExtra("input2", input2.getText().toString());
                intent.putExtra("input1", sIme);
                startActivity(intent);
            }
        });
    }
}

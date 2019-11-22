package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lv1.Adapter.RecycleViewAdapter;
import com.example.lv1.Model.MyDataStorage;
import com.example.lv1.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class PocetniActivity extends AppCompatActivity {

    public Button bNoviStudent;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetni);

        mRecycleView = (RecyclerView)findViewById(R.id.recycleView);

        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);


        mAdapter = new RecycleViewAdapter(MyDataStorage.getInstance().getlStudents());
        mRecycleView.setAdapter(mAdapter);


        bNoviStudent = (Button)findViewById(R.id.dodajStudenta);

        bNoviStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}

package com.example.lv1.Fragment;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.lv1.CreateNewRecordActivity;
import com.example.lv1.Model.ApiManager;
import com.example.lv1.Model.Course;
import com.example.lv1.Model.CourseResponse;
import com.example.lv1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CourseResponse>{
    private static final String  Tag = "myActivity";
    private StudentInfoListener studentInfoListener;
    private Spinner spinnerPredmet;
    private TextInputEditText profesor;
    private TextInputEditText godina;
    private TextInputEditText predavanja;
    private TextInputEditText vjezbe;
    private Button btn2;
    private String sPredmet, sProfesor, sGodina, sPredavanja, sVjezbe;
    Adapter adapter;
    FragmentActivity listener;
    private CourseResponse courseResponse = new CourseResponse();
    ArrayList<CourseResponse> lCourses = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApiManager.getInstance().service().GetCourses().enqueue(this);
    }

    /*private void doSomethingImportantWithJobs(ArrayList<Job> jobs){
        tvJob.setText(jobs.toString());
    }*/

    @Override
    public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
        if (response.isSuccessful() && response.body() != null){
            lCourses.add(response.body());
            Log.d(Tag,"onResponse:" + " " + lCourses);
            //doSomethingImportantWithJobs(lCourses);
        }
    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable t) {
        t.printStackTrace();
    }

    public interface StudentInfoListener{
        void GetStudentInfo(String predmet, String profesor, String godina, String predavanja, String vjezbe);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof StudentInfoListener)
        {
            studentInfoListener = (StudentInfoListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_student_info,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        spinnerPredmet = view.findViewById(R.id.odabirPredmeta);
        profesor = view.findViewById(R.id.inputImeProfesora2);
        godina = view.findViewById(R.id.inputGodina2);
        predavanja = view.findViewById(R.id.inputPredavanja2);
        vjezbe = view.findViewById(R.id.inputLV2);

        godina.addTextChangedListener(InputCheck);
       // spinnerPredmet.addTextChangedListener(InputCheck);
        profesor.addTextChangedListener(InputCheck);
        predavanja.addTextChangedListener(InputCheck);
        vjezbe.addTextChangedListener(InputCheck);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPredmet.setAdapter(adapter);
        spinnerPredmet.setOnItemSelectedListener(this);
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
             //sPredmet = spinnerPredmet.getText().toString();
             sProfesor = profesor.getText().toString();
             sGodina = godina.getText().toString();
             sPredavanja = predavanja.getText().toString();
             sVjezbe = vjezbe.getText().toString();

            studentInfoListener.GetStudentInfo(sPredmet,sProfesor,sGodina,sPredavanja,sVjezbe);

        }
    };

    public void editTextViewStudent(String sPredmet,String sProfesor,String sGodina, String sPredavanja, String sVjezbe)
    {
        //predmet.setText(sPredmet);
        profesor.setText(sProfesor);
        godina.setText(sGodina);
        predavanja.setText(sPredavanja);
        vjezbe.setText(sVjezbe);
    }
}

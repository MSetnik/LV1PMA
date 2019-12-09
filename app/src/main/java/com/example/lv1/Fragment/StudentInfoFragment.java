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
import android.widget.AdapterView;
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
import com.example.lv1.Model.Instructor;
import com.example.lv1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CourseResponse>, AdapterView.OnItemSelectedListener {
    private static final String  Tag = "myActivity";
    private StudentInfoListener studentInfoListener;
    private Spinner spinnerPredmet;
    private Spinner spinnerProfesor;
    private TextInputEditText profesor;
    private TextInputEditText godina;
    private TextInputEditText predavanja;
    private TextInputEditText vjezbe;
    private String sCourse, sName;
    private String sPredmet, sProfesor, sGodina, sPredavanja, sVjezbe;
    FragmentActivity listener;
    private CourseResponse courseResponse = new CourseResponse();
    ArrayList<CourseResponse> lCourseResponse = new ArrayList<>();
    ArrayList<Course> lCourse = new ArrayList<>();
    ArrayList<String> lCourseName = new ArrayList<>();
    private StudentInfoFragment studentInfoFragment;
    private ArrayList<Instructor> lInstructors = new ArrayList<>();
    ArrayList<String>lInstructorNames = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApiManager.getInstance().service().GetCourses().enqueue(this);
    }

    @Override
    public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
        if (response.isSuccessful() && response.body() != null){
            lCourseResponse.add(response.body());
            Log.d(Tag,"onResponse:" + " " + lCourseResponse);

            courseResponse = response.body();
            lCourse = courseResponse.getCourses();


            for(int i=0;i<lCourse.size();i++)
            {
                if(lCourse.get(i).getTitle() != null && !lCourse.get(i).getTitle().matches("") ){
                    lCourseName.add(lCourse.get(i).getTitle());
                }

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, lCourseName);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerPredmet.setAdapter(adapter);
            spinnerPredmet.setOnItemSelectedListener(this);
        }
    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.odabirPredmeta)
        {
            ArrayList<Instructor> inst = new ArrayList<>();
            Log.d(Tag, "onItemSelected: " + spinnerPredmet.getSelectedItem());

            for(Course course : lCourse){

                if(spinnerPredmet.getSelectedItem() == course.getTitle()) {

                    lInstructors = course.getInstructor();

                    Log.d(Tag, "Instructors " +  lInstructors.size());

                    if (lInstructors != null) {
                        lInstructorNames.clear();

                        for (Instructor instructor : lInstructors) {
                            lInstructorNames.add(instructor.getName());

                            Log.d(Tag, "onResponse: " + instructor.getName());

                        }
                    }
                }
            }

            ArrayAdapter<String> adapterProfesor = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, lInstructorNames);
            spinnerProfesor.setAdapter(adapterProfesor);
            spinnerProfesor.setOnItemSelectedListener(this);

            sCourse = spinnerPredmet.getSelectedItem().toString();
            studentInfoListener.GetStudentInfo(sCourse, sName, sGodina, sPredavanja, sVjezbe);
        }
        else if(parent.getId() == R.id.odabirProfesora)
        {
            sName = spinnerProfesor.getSelectedItem().toString();
            studentInfoListener.GetStudentInfo(sCourse, sName, sGodina, sPredavanja, sVjezbe);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
        spinnerProfesor = view.findViewById(R.id.odabirProfesora);
        godina = view.findViewById(R.id.inputGodina2);
        predavanja = view.findViewById(R.id.inputPredavanja2);
        vjezbe = view.findViewById(R.id.inputLV2);

        godina.addTextChangedListener(InputCheck);
        predavanja.addTextChangedListener(InputCheck);
        vjezbe.addTextChangedListener(InputCheck);
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
             sProfesor = profesor.getText().toString();
             sGodina = godina.getText().toString();
             sPredavanja = predavanja.getText().toString();
             sVjezbe = vjezbe.getText().toString();

            studentInfoListener.GetStudentInfo(sPredmet,sProfesor,sGodina,sPredavanja,sVjezbe);

        }
    };
}

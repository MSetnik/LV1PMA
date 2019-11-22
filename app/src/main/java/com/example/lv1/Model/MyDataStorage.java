package com.example.lv1.Model;

import java.util.ArrayList;
import java.util.List;

public class MyDataStorage {
    private List<Student> lStudents;

    private MyDataStorage()
    {
        lStudents = new ArrayList<>();
    }

    static private MyDataStorage instance;
    public static MyDataStorage getInstance()
    {
        if(instance == null)
        {
            instance= new MyDataStorage();
        }
        return instance;
    }

    public List<Student> getlStudents() {
        return lStudents;
    }

    public void addStudent (Student newStudent)
    {
        lStudents.add(newStudent);
    }
}

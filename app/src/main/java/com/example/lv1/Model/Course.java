package com.example.lv1.Model;

import java.util.ArrayList;

public class Course {
    String title;
    ArrayList<Instructor> instructor;

    public String getTitle() {
        return title;
    }

    public ArrayList<Instructor> getInstructor() {
        return instructor;
    }
}
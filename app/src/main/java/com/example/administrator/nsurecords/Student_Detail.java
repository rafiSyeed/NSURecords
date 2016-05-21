package com.example.administrator.nsurecords;

/**
 * Created by Administrator on 20/05/2016.
 */
public class Student_Detail { // used to set/input our data to database
    private String name;
    private String class_name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

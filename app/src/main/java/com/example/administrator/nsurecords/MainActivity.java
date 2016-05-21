package com.example.administrator.nsurecords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,cl_name,email;
    HelperDatabaseClass helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new HelperDatabaseClass(this);
        name = (EditText) findViewById(R.id.editText);
        cl_name = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);


    }
    public void save(View view){
        Student_Detail detail = new Student_Detail();
        detail.setName(name.getText().toString());
        detail.setClass_name(cl_name.getText().toString());
        detail.setEmail(email.getText().toString());
        helper.insert(detail);

    }
}

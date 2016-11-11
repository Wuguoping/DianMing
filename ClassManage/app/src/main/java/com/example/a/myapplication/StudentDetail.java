package com.example.a.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a.myapplication.R;
import com.example.a.myapplication.Student;
import com.example.a.myapplication.StudentRepo;

public class StudentDetail extends AppCompatActivity implements android.view.View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName;
    EditText editTextbanji;
    EditText editTextsno;
    EditText editTextweek1;
    EditText editTextweek2;
    EditText editTextweek3;
    EditText editTextweek4;
    EditText editTextweek5;
    EditText editTextweek6;
    EditText editTextweek7;
    EditText editTextweek8;
    private int _Student_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextbanji = (EditText) findViewById(R.id.editTextbanji);
        editTextsno = (EditText) findViewById(R.id.editTextsno);
        editTextweek1=(EditText)findViewById(R.id.editTextweek1);
        editTextweek2=(EditText)findViewById(R.id.editTextweek2);
        editTextweek3=(EditText)findViewById(R.id.editTextweek3);
        editTextweek4=(EditText)findViewById(R.id.editTextweek4);
        editTextweek5=(EditText)findViewById(R.id.editTextweek5);
        editTextweek6=(EditText)findViewById(R.id.editTextweek6);
        editTextweek7=(EditText)findViewById(R.id.editTextweek7);
        editTextweek8=(EditText)findViewById(R.id.editTextweek8);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Student_Id =0;
        Intent intent = getIntent();
        _Student_Id =intent.getIntExtra("student_Id", 0);
        StudentRepo repo = new StudentRepo(this);
        Student student = new Student();
        student = repo.getStudentById(_Student_Id);

        editTextsno.setText(student.sno);
        editTextName.setText(student.name);
        editTextbanji.setText(student.banji);
        editTextweek1.setText(student.week1);
        editTextweek2.setText(student.week2);
        editTextweek3.setText(student.week3);
        editTextweek4.setText(student.week4);
        editTextweek5.setText(student.week5);
        editTextweek6.setText(student.week6);
        editTextweek7.setText(student.week7);
        editTextweek8.setText(student.week8);
    }



    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.sno= editTextsno.getText().toString();
            student.banji=editTextbanji.getText().toString();
            student.name=editTextName.getText().toString();
            //student.condition=editTextcondition.getText().toString();
            student.week1=editTextweek1.getText().toString();
            student.week2=editTextweek2.getText().toString();
            student.week3=editTextweek3.getText().toString();
            student.week4=editTextweek4.getText().toString();
            student.week5=editTextweek5.getText().toString();
            student.week6=editTextweek6.getText().toString();
            student.week7=editTextweek7.getText().toString();
            student.week8=editTextweek8.getText().toString();

            student.student_ID=_Student_Id;

            if (_Student_Id==0){
                _Student_Id = repo.insert(student);

                Toast.makeText(this,"New Student Insert",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(student);
                Toast.makeText(this,"Student Record updated",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            StudentRepo repo = new StudentRepo(this);
            repo.delete(_Student_Id);
            Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }
}

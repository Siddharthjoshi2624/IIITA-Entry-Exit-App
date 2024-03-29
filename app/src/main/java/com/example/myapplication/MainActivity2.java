package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button back,student,admin,register;
        back=findViewById(R.id.back);
        student=findViewById(R.id.student);
        admin=findViewById(R.id.admin);
        register=findViewById(R.id.register);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i=new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFileInInternalStorage(MainActivity2.this,"Stu_per.txt");
                Intent i;
                i=new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(i);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i=new Intent(MainActivity2.this, MainActivity6.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i=new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(i);
            }
        });
    }
    private void createFileInInternalStorage(Context context, String fileName) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            String initialContent = "Locations:CC3";
            fileOutputStream.write(initialContent.getBytes());
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
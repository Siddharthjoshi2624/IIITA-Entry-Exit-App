package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                createFileInInternalStorage(MainActivity.this,"stu_login_pass.txt");
                createFileInInternalStorage1(MainActivity.this,"CC-3_list.txt");
                i=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
    private void createFileInInternalStorage(Context context, String fileName) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            String initialContent = "sid  sid  ";
            fileOutputStream.write(initialContent.getBytes());
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createFileInInternalStorage1(Context context, String fileName) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            String initialContent = "CC3_list";
            fileOutputStream.write(initialContent.getBytes());
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
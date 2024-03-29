package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.*;
public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button register;
        EditText username,password;
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        username=findViewById(R.id.rollno);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s="Empty!",s2="not match    ",s3="Inside";
                int duration = Toast.LENGTH_SHORT;
                if(password.getText().toString().isEmpty()||username.getText().toString().isEmpty()) {
                    Toast toast1 = Toast.makeText(MainActivity4.this, s, duration);
                    toast1.show();
                    Intent i;
                    i = new Intent(MainActivity4.this, MainActivity4.class);
                    startActivity(i);
                }
                else{
                    String user=username.getText().toString();
                    String pass=password.getText().toString();
                    String tot=user;
                    tot+="  ";
                    tot+=pass;
                    tot+="  ";
                    writeToFileInInternalStorage(MainActivity4.this,"stu_login_pass.txt",tot);
                    Intent i;
                    i = new Intent(MainActivity4.this, MainActivity5.class);
                    startActivity(i);
                }
            }
        });
    }
    private void writeToFileInInternalStorage(Context context, String fileName, String content) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_APPEND);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
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
public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button back,login;
        EditText username,password;
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i=new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
            }
        });
        login=findViewById(R.id.login);
        password=findViewById(R.id.password);
        username=findViewById(R.id.username);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().isEmpty()||username.getText().toString().isEmpty()){
                    Intent i;
                    i = new Intent(MainActivity3.this, MainActivity3.class);
                    startActivity(i);
                }
                else{
                    String line=readOrCreateFileInInternalStorage(MainActivity3.this,"stu_login_pass.txt");
                    String pass="",user="";
                    String[] parts = line.trim().split("\\s+");
                    boolean flag=false;
                    for(int i=0;i<parts.length;i+=2){
                        if(password.getText().toString().equals(parts[i])&&username.getText().toString().equals(parts[i+1])){
                            flag=true;
                            break;
                        }
                    }
                    if(flag){
                        Intent i;
                        i = new Intent(MainActivity3.this, MainActivity13.class);
                        startActivity(i);
                    }
                    else{
                        int duration=Toast.LENGTH_SHORT;
                        Toast toast1 = Toast.makeText(MainActivity3.this,"No Match", duration);
                        toast1.show();
                        Intent i;
                        i = new Intent(MainActivity3.this, MainActivity3.class);
                        startActivity(i);
                    }
                }
            }
        });
    }
    public  String readOrCreateFileInInternalStorage(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
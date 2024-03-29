package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.*;
import android.widget.Toast;
import java.io.*;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Button back,enter;
        EditText passkey;
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i=new Intent(MainActivity6.this, MainActivity2.class);
                startActivity(i);
            }
        });
        enter=findViewById(R.id.enter);
        passkey=findViewById(R.id.passkey);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String line=readPasskeyFromAssets();
                String[] parts = line.split(":");
                String s="Empty!",s2="not match    ",s3="Inside";
                int duration = Toast.LENGTH_SHORT;
                if(passkey.getText().toString().isEmpty()) {
                    Toast toast1 = Toast.makeText(MainActivity6.this, s, duration);
                    toast1.show();
                    Intent i;
                    i = new Intent(MainActivity6.this, MainActivity6.class);
                    startActivity(i);
                }
                else{
                        if(passkey.getText().toString().equals(parts[0])){
                            createFileInInternalStorage(MainActivity6.this,"CC-3_list.txt");
                            Intent i5;
                            i5 = new Intent(MainActivity6.this, MainActivity7.class);
                            startActivity(i5);
                        }
                        else if(passkey.getText().toString().equals(parts[1])){
                            Intent i5;
                            i5 = new Intent(MainActivity6.this, MainActivity9.class);
                            startActivity(i5);
                        }
                        else if(passkey.getText().toString().equals(parts[2])){
                            Intent i5;
                            i5 = new Intent(MainActivity6.this, MainActivity8.class);
                            startActivity(i5);
                        }
                        else if(passkey.getText().toString().equals(parts[3])){
                            Intent i5;
                            i5 = new Intent(MainActivity6.this, MainActivity10.class);
                            startActivity(i5);
                        }
                        else if(passkey.getText().toString().equals(parts[4])){
                            Intent i5;
                            i5 = new Intent(MainActivity6.this, MainActivity11.class);
                            startActivity(i5);
                        }
                        else if(passkey.getText().toString().equals(parts[5])){
                            Intent i5;
                            i5 = new Intent(MainActivity6.this, MainActivity12.class);
                            startActivity(i5);
                        }
                        else{
                            Toast toast = Toast.makeText(MainActivity6.this, s2, duration);
                            toast.show();
                            Intent i6;
                            i6 = new Intent(MainActivity6.this, MainActivity6.class);
                            startActivity(i6);
                        }
                }
            }
        });
    }
    private String readPasskeyFromAssets() {
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("Final_passkey.txt");

            InputStreamReader inputreader = new InputStreamReader(inputStream);
            BufferedReader buffreader = new BufferedReader(inputreader);

            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = buffreader.readLine()) != null) {
                builder.append(line);
            }

            return builder.toString();
        } catch (IOException e) {
            String s="Empty!",s2="not match    ",s3="Inside";
            int duration = Toast.LENGTH_SHORT;
            Toast toast3 = Toast.makeText(MainActivity6.this, "HEna", duration);
                    toast3.show();
            return null;
        }
    }
    private void createFileInInternalStorage(Context context, String fileName) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            String initialContent = "cc3_list";
            fileOutputStream.write(initialContent.getBytes());
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
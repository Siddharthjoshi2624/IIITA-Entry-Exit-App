package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.*;

public class MainActivity15 extends AppCompatActivity {
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);
        l = findViewById(R.id.list);
        String line=readOrCreateFileInInternalStorage(MainActivity15.this,"Stu_per.txt");
        String[] parts = line.split("\\s+");
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(MainActivity15.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,parts);
        l.setAdapter(arr);
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
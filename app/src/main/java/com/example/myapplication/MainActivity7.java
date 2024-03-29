package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity7 extends AppCompatActivity {
    ImageView qrcode;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Button check,qr,success;
        EditText rollno=findViewById(R.id.rollno);
        check=findViewById(R.id.check);
        success=findViewById(R.id.success);
        qr=findViewById(R.id.qr);
        qrcode=findViewById(R.id.qrcode);
        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s="Empty!",s2="not match    ",s3="Inside";
                int duration = Toast.LENGTH_SHORT;
                if(rollno.getText().toString().isEmpty()) {
                    Toast toast1 = Toast.makeText(MainActivity7.this, s, duration);
                    toast1.show();
                    Intent i;
                    i = new Intent(MainActivity7.this, MainActivity7.class);
                    startActivity(i);
                }
                else{
                    flag=true;
                    generateQRCode(rollno.getText().toString());
                }
            }
        });
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    writeToFileInInternalStorage(MainActivity7.this,"CC-3_list.txt","  "+rollno.getText().toString());
                    Intent i;
                    i = new Intent(MainActivity7.this, MainActivity7.class);
                    startActivity(i);
                }
                else{
                    int duration=Toast.LENGTH_SHORT;
                    Toast toast1 = Toast.makeText(MainActivity7.this,"First enter name", duration);
                    toast1.show();
                    Intent i;
                    i = new Intent(MainActivity7.this, MainActivity7.class);
                    startActivity(i);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MainActivity7.this, MainActivity14.class);
                startActivity(i);
            }
        });
    }
    private void generateQRCode(String data) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 300, 300);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? getResources().getColor(R.color.black) : getResources().getColor(R.color.white));
                }
            }
            qrcode.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }
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
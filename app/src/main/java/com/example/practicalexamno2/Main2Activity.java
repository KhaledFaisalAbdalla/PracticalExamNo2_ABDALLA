package com.example.practicalexamno2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    EditText comments,subjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        subjects = findViewById(R.id.editText2);
        comments = findViewById(R.id.editText3);

        setTitle("SUMMARY");

        FileInputStream reader = null;
        String msg = "";
        try {
            reader = openFileInput("data1.txt");
            int token;
            String temp = "";
            while ((token = reader.read()) != -1){
                temp = temp + ((char)token);
            }
            reader.close();
            try {
                String[] list = temp.split("_");
                subjects.setText(list[0]);

            } catch (Exception e) {
                Log.d("error", "empty strings");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader = openFileInput("data2.txt");
            int token;
            String temp = "";
            while ((token = reader.read()) != -1){
                temp = temp + ((char)token);
            }
            reader.close();
            try {
                String[] list = temp.split("_");
                comments.setText(list[0]);

            } catch (Exception e) {
                Log.d("error", "empty strings");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void preivous(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void send(View v){
        comments.getText().toString();
        Toast.makeText(this, "request sent", Toast.LENGTH_LONG).show();
    }
}

package com.example.practicalexamno2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CheckBox IT205, ICS115, ITELEC2, ICS125, ITELEC3, ITELEC4, FELEC2, FELEC3;
    EditText comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("SUBJECT REQUEST");

        IT205 = findViewById(R.id.checkBox);
        ICS115 = findViewById(R.id.checkBox2);
        ITELEC2 = findViewById(R.id.checkBox3);
        ICS125 = findViewById(R.id.checkBox4);
        ITELEC3 = findViewById(R.id.checkBox5);
        ITELEC4 = findViewById(R.id.checkBox6);
        FELEC2 = findViewById(R.id.checkBox7);
        FELEC3 = findViewById(R.id.checkBox8);
        comments =findViewById(R.id.editText);
    }

    public void saveDATA(View v) {

        String c1 = IT205.getText().toString();
        String c2 = ICS115.getText().toString();
        String c3 = ITELEC2.getText().toString();
        String c4 = ICS125.getText().toString();
        String c5 = ITELEC3.getText().toString();
        String c6 = ITELEC4.getText().toString();
        String c7 = FELEC2.getText().toString();
        String c8 = FELEC3.getText().toString();
        String data9 = comments.getText().toString();

        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data9.getBytes());

            if (IT205.isChecked()){
                writer.write(c1.getBytes());
            }
            if (ICS115.isChecked()){
                writer.write(c2.getBytes());
            }
            if (ITELEC2.isChecked()){
             writer.write(c3.getBytes());
            }
            if (ICS125.isChecked()){
                writer.write(c4.getBytes());
            }
            if (ITELEC3.isChecked()) {
                writer.write(c5.getBytes());
            }
            if (ITELEC4.isChecked()) {
                writer.write(c6.getBytes());
            }
            if (FELEC2.isChecked()) {
                writer.write(c7.getBytes());
            }
            if (FELEC3.isChecked()) {
                writer.write(c8.getBytes());
            }

        }catch (FileNotFoundException e){
            Log.d("error", "File not found");
        } catch (IOException e) {
            Log.d("error", "File not found");
        }finally {
            try {
                writer.close();
            }catch (IOException e){
                Log.d("error", "File not found");
            }
        }

        Toast.makeText(this, "data saved in internal storage", Toast.LENGTH_LONG).show();
            }

            public void next(View v) {
                Intent i = new Intent(this, Main2Activity.class);
                startActivity(i);
            }

    }


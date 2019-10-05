package com.baetiong.baetiong_practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
    EditText commA;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);
        cb7 = findViewById(R.id.cb7);
        cb8 = findViewById(R.id.cb8);
        commA = findViewById(R.id.comment);

    }

    public void writeData(View view) {
        String result = "List of Registered Activities:  ";
        String comment = "";
        if(cb1.isChecked()) {
            result += "\n"+ cb1.getText().toString();
            comment += "\n"  + commA.getText().toString();
        }
        if(cb2.isChecked()) {
            result += "\n"+ cb2.getText().toString();
            comment += "\n" + commA.getText().toString();
        }
        if(cb3.isChecked()) {
            result += "\n" + cb3.getText().toString();
            comment += "\n" + commA.getText().toString();
        }
        if(cb4.isChecked()) {
            result += "\n" + cb4.getText().toString();
            comment += "\n"  + commA.getText().toString();
        }
        if(cb5.isChecked()) {
            result += "\n" + cb5.getText().toString();
            comment += "\n" + commA.getText().toString();
        }
        if(cb6.isChecked()) {
            result += "\n" + cb6.getText().toString();
            comment += "\n" + commA.getText().toString();
        }
        if(cb7.isChecked()) {
            result += "\n" + cb7.getText().toString();
            comment += "\n" + commA.getText().toString();
        }
        if(cb8.isChecked()) {
            result += "\n" + cb8.getText().toString();
            comment += "\n" + commA.getText().toString();
        }

        FileOutputStream writer = null;
        try {
            writer = openFileOutput("activities.txt", MODE_PRIVATE);
            writer.write(result.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            Log.d("error", "IO Error");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File Not Found");
            }
        }
        FileOutputStream commA = null;
        try {
            commA = openFileOutput("comment.txt", MODE_PRIVATE);
            commA.write(comment.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            Log.d("error", "IO Error");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File Not Found");
            }
        }
        Toast.makeText(this, "Data Saved...", Toast.LENGTH_LONG).show();

    }

    public void goNext(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }



}

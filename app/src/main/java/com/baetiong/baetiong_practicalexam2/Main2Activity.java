package com.baetiong.baetiong_practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("4ITB", "onCreate has executed");
        Intent i = new Intent(this, myService.class);
        startService(i);

        FileInputStream reader = null;
        String data= "";
        try {
            reader = openFileInput("data1.txt");
            int token;

            while ((token = reader.read()) != -1){
                data = data + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("ERROR","FILE NOT FOUND");
        }
        catch (IOException e) {
            Log.d("ERROR","IO ERROR");
        }
        EditText editText = (EditText)findViewById(R.id.ee1);
        editText.setText(data, TextView.BufferType.EDITABLE);

        FileInputStream readerComment = null;
        String datacomment= "";
        try {
            readerComment = openFileInput("data2.txt");
            int token;

            while ((token = readerComment.read()) != -1){
                datacomment = datacomment + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("ERROR","FILE NOT FOUND");
        }
        catch (IOException e) {
            Log.d("ERROR","IO ERROR");
        }
        EditText editText2 = (EditText)findViewById(R.id.commA);
        editText2.setText(datacomment, TextView.BufferType.EDITABLE);


    }
}

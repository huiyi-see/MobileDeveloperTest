package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class updateInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

    }
    user user = new user();
    EditText firstName = (EditText)findViewById(R.id.updateFN);

    EditText lastName = (EditText)findViewById(R.id.updateLN);
    EditText email = (EditText)findViewById(R.id.updateE);
    EditText phone = (EditText)findViewById(R.id.updatePh);
}

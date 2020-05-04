package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        directoryToPages();
    }
    private void directoryToPages()
    {
        Button create = (Button)findViewById(R.id.homeC);
        Button update = (Button)findViewById(R.id.homeU);
        Button delete = (Button)findViewById(R.id.homeD);
        Button contact = (Button)findViewById(R.id.contactList);
        Button search = (Button) findViewById(R.id.homeS);
        create.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          startActivity(new Intent(MainActivity.this, createInfo.class));
                                      }
                                  }

        );
        update.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          startActivity(new Intent(MainActivity.this, updateInfo.class));
                                      }
                                  }

        );
        delete.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          startActivity(new Intent(MainActivity.this, deleteInfo.class));
                                      }
                                  }

        );
        contact.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          startActivity(new Intent(MainActivity.this, contact.class));
                                      }
                                  }

        );
        search.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          startActivity(new Intent(MainActivity.this, searchInfo.class));
                                      }
                                  }

        );


    }
}

package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import java.util.ArrayList;
import java.util.Collections;

public class contact extends AppCompatActivity {
    FirebaseFirestore db =FirebaseFirestore.getInstance() ;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        list = (ListView)findViewById(R.id.contactList);

        displayContact();

    }

    public void displayContact()
    {
        db.collection("mobileContact").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                String info;
                ArrayList<String>arrayList = new ArrayList<String>();
                int count = 0;
                if (task.isSuccessful())
                {
                    for(QueryDocumentSnapshot document: task.getResult())
                    {
                        info = document.getData().toString().substring(1,document.getData().toString().length()-1);
                        arrayList.add(info);
                        Collections.sort(arrayList);
                        count++;
                    }
                    ArrayAdapter arrayAdapter= new ArrayAdapter(contact.this,android.R.layout.simple_list_item_1,arrayList);
                    list.setAdapter(arrayAdapter);
                }
                else
                {
                   String errorMsg =  "Error retrieving data";
                }
            }
        });
    }
}

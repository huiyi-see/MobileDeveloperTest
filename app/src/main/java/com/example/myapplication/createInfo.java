package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class createInfo extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private TextView invalidText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


        initFirebase();
        setContactOnButtonClick();



    }

    public void setContactOnButtonClick()
    {
        final Button createInfo = (Button)findViewById(R.id.createB);
        createInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){

                user user = new user();
                EditText firstName = (EditText) findViewById(R.id.createFN);

                EditText lastName = (EditText) findViewById(R.id.createLN);

                EditText email = (EditText) findViewById(R.id.createE);

                EditText phone = (EditText) findViewById(R.id.createPh);


                if (firstName.getText().toString().equals("")||lastName.getText().toString().equals("") || email.getText().toString().equals("")|| phone.getText().toString().equals(""))
                {
                    Log.w("Empty fields","Nothing here");


                    String text ="Empty field, the contact can't be created";
                    Toast t = Toast.makeText(createInfo.this,text, Toast.LENGTH_SHORT);
                    t.show();
                }
                else if (user.isEmailValid())
                {
                    String text ="email has wrong format, the contact can't be created";
                    Toast t = Toast.makeText(createInfo.this,text, Toast.LENGTH_SHORT);
                    t.show();
                }
                else {
                    user.setFirstN(firstName.getText().toString());
                    user.setLastN(lastName.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPhone(phone.getText().toString());
                    Map<String, Object> contactInfo = new HashMap<>();
                    contactInfo.put("First Name", user.getFirstN());
                    contactInfo.put("Last Name", user.getLastN());
                    contactInfo.put("Email", user.getEmail());
                    contactInfo.put("Phone Number ", user.getPhone());


                    db.collection("mobileContact")
                            .add(contactInfo)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    System.out.println("the contact has been created");

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                    String text1 = "Your contact has been created";
                    Toast t = Toast.makeText(createInfo.this,text1, Toast.LENGTH_SHORT);
                    t.show();
                    Intent intent = new Intent(createInfo.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
    private void initFirebase(){
        db = FirebaseFirestore.getInstance();
    }

}
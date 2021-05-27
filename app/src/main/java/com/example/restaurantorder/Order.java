package com.example.restaurantorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Order extends AppCompatActivity {
    Button del, take;
    TextView id;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    EditText adr;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        del = findViewById(R.id.submit);
        del.setOnClickListener(this::onClick);
        take = findViewById(R.id.submit2);
        take.setOnClickListener(this::onClick);
        adr = findViewById(R.id.address);

        //  getSupportFragmentManager().beginTransaction().add(R.id.delivery,new Delivery()).commit();
    }


    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            getSupportFragmentManager().beginTransaction().add(R.id.delivery, new Delivery()).commit();
        }
        if(v.getId() == R.id.submit2){
            getSupportFragmentManager().beginTransaction().add(R.id.delivery, new Take_Away()).commit();
        }
    }
    }


package com.example.restaurantorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

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

        Fragment fragment = new Fragment();
        //getSupportFragmentManager().
        //  getSupportFragmentManager().beginTransaction().add(R.id.delivery,new Delivery()).commit();
    }


    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            FrameLayout layoutOne = (FrameLayout)findViewById(R.id.takeaway);
            layoutOne.setVisibility(View.INVISIBLE);
            FrameLayout layout = (FrameLayout)findViewById(R.id.delivery);
            layout.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().add(R.id.delivery, new Delivery()).commit();
        }
        if(v.getId() == R.id.submit2){
            FrameLayout layoutOne = (FrameLayout)findViewById(R.id.delivery);
            layoutOne.setVisibility(View.INVISIBLE);
            FrameLayout layout = (FrameLayout)findViewById(R.id.takeaway);
            layout.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().add(R.id.takeaway, new Take()).commit();

        }
    }

    }


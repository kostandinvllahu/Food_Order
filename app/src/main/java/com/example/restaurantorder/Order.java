package com.example.restaurantorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Order extends AppCompatActivity {
Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
   getSupportFragmentManager().beginTransaction().add(R.id.delivery,new Delivery()).commit();


    }
}
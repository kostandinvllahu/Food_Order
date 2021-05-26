package com.example.restaurantorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Order extends AppCompatActivity {
Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        del =findViewById(R.id.submit);
        del.setOnClickListener(this::onClick);
 //  getSupportFragmentManager().beginTransaction().add(R.id.delivery,new Delivery()).commit();
    }
    public void onClick(View v){
        if(v.getId()==R.id.submit){
            getSupportFragmentManager().beginTransaction().add(R.id.delivery,new Delivery()).commit();
        }
    }
}
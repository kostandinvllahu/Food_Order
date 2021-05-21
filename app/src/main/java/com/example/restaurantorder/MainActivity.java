package com.example.restaurantorder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class MainActivity extends AppCompatActivity {
TextView fullName, email, phone, select;
Button btnClear, btnOrder;
FirebaseAuth fAuth;
FirebaseFirestore fStore;
String userId;

    @Override


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.profilePhone);
        fullName = findViewById(R.id.profileName);
        email = findViewById(R.id.profileEmail);
        select = findViewById(R.id.selectcb1);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();
        btnClear = (Button)findViewById(R.id.Clear);
        btnOrder = (Button)findViewById(R.id.Order);
        CheckBox cb1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox cb2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox cb4 = (CheckBox)findViewById(R.id.checkBox4);
        CheckBox cb5 = (CheckBox)findViewById(R.id.checkBox5);
        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                phone.setText(documentSnapshot.getString("phone"));
                fullName.setText(documentSnapshot.getString("fName"));
                email.setText(documentSnapshot.getString("email"));
            }
        });

      btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(cb1.isChecked())
                  cb1.setChecked(false);
             if(cb2.isChecked())
                  cb2.setChecked(false);
              if(cb3.isChecked())
                  cb3.setChecked(false);
              if(cb4.isChecked())
                  cb4.setChecked(false);
              if(cb5.isChecked())
                  cb5.setChecked(false);

              
            }
        });

      btnOrder.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(cb1.isChecked())
                  select.append("Hello");
          }
      });

    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    public void order(View view){
        //startActivity(new Intent(getApplicationContext(),Order.class));
        finish();
    }
}
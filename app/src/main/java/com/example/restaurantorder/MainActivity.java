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
TextView fullName, email, phone;
TextView select, select2, select3, select4, select5, food1, food2, food3, food4, food5;
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
        select2 = findViewById(R.id.selectcb2);
        select3 = findViewById(R.id.selectcb3);
        select4 = findViewById(R.id.selectcb4);
        select5 = findViewById(R.id.selectcb5);
        food1 = findViewById(R.id.item1);
        food2 = findViewById(R.id.item2);
        food3 = findViewById(R.id.item3);
        food4 = findViewById(R.id.item4);
        food5 = findViewById(R.id.item5);
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
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                /*phone.setText(documentSnapshot.getString("phone"));
                fullName.setText(documentSnapshot.getString("fName"));
                email.setText(documentSnapshot.getString("email"));

                 */
            }
        });

      btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(cb1.isChecked())
                  cb1.setChecked(false);
              select.setText("");
             if(cb2.isChecked())
                  cb2.setChecked(false);
                select2.setText("");
              if(cb3.isChecked())
                  cb3.setChecked(false);
                select3.setText("");
              if(cb4.isChecked())
                  cb4.setChecked(false);
                select4.setText("");
              if(cb5.isChecked())
                  cb5.setChecked(false);
                select5.setText("");

              
            }
        });

      btnOrder.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(cb1.isChecked())
                  select.append(food1.getText().toString());
              if(cb2.isChecked())
                  select2.append(food2.getText().toString());
              if(cb3.isChecked())
                  select3.append(food3.getText().toString());
              if(cb4.isChecked())
                  select4.append(food4.getText().toString());
              if(cb5.isChecked())
                  select5.append(food5.getText().toString());
          }
      });
    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    public void order(View view){
        startActivity(new Intent(getApplicationContext(),Order.class));
        finish();
    }
}
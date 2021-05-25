package com.example.restaurantorder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    TextView fullName, email, phone;
    TextView select, select2, select3, select4, select5, food1, food2, food3, food4, food5, total, number1, number2, number3, number4, number5, p1, p2, p3, p4, p5;
    Button btnClear, btnOrder, btnSelect1, btnSelect2, btnSelect3, btnSelect4, btnSelect5;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId, e, finalPrice;;
    int a, b, c, a1, b1, c1, a2, b2, c2, a3, b3, c3, a4, b4, c4, finalP;
    Boolean check = false, clean=false, redirect = false;
    Timer timer;
    @Override


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // phone = findViewById(R.id.profilePhone);
        //fullName = findViewById(R.id.profileName);
        //email = findViewById(R.id.profileEmail);
        total = findViewById(R.id.selectcb1);
        select = findViewById(R.id.selectcb);
        select2 = findViewById(R.id.selectcb2);
        select3 = findViewById(R.id.selectcb3);
        select4 = findViewById(R.id.selectcb4);
        select5 = findViewById(R.id.selectcb5);
        food1 = findViewById(R.id.item1);
        food2 = findViewById(R.id.item2);
        food3 = findViewById(R.id.item3);
        food4 = findViewById(R.id.item4);
        food5 = findViewById(R.id.item5);
        number1 = findViewById(R.id.amount1);
        number2 = findViewById(R.id.amount2);
        number3 = findViewById(R.id.amount3);
        number4 = findViewById(R.id.amount4);
        number5 = findViewById(R.id.amount5);
        p1 = findViewById(R.id.price1);
        p2 = findViewById(R.id.price2);
        p3 = findViewById(R.id.price3);
        p4 = findViewById(R.id.price4);
        p5 = findViewById(R.id.price5);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();
        btnClear = (Button) findViewById(R.id.Clear);
        btnOrder = (Button) findViewById(R.id.Order);
        btnSelect1 = (Button) findViewById(R.id.checkBox1);
        btnSelect2 = (Button) findViewById(R.id.checkBox2);
        btnSelect3 = (Button) findViewById(R.id.checkBox3);
        btnSelect4 = (Button) findViewById(R.id.checkBox4);
        btnSelect5 = (Button) findViewById(R.id.checkBox5);
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox cb5 = (CheckBox) findViewById(R.id.checkBox5);
        DocumentReference documentReference = fStore.collection("users").document(userId);
       /* documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                phone.setText(documentSnapshot.getString("phone"));
                fullName.setText(documentSnapshot.getString("fName"));
                email.setText(documentSnapshot.getString("email"));
            }
        });*/


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb1.isChecked())
                    cb1.setChecked(false);
                number1.setVisibility(View.INVISIBLE);
                number1.setText("");
                select.setText("");
                p1.setText("");
                check = false;
                if (cb2.isChecked())
                    cb2.setChecked(false);
                number2.setVisibility(View.INVISIBLE);
                number2.setText("");
                select2.setText("");
                p2.setText("");
                check = false;
                if (cb3.isChecked())
                    cb3.setChecked(false);
                number3.setVisibility(View.INVISIBLE);
                number3.setText("");
                select3.setText("");
                p3.setText("");
                check = false;
                if (cb4.isChecked())
                    cb4.setChecked(false);
                number4.setVisibility(View.INVISIBLE);
                number4.setText("");
                select4.setText("");
                p4.setText("");
                check = false;
                if (cb5.isChecked())
                    cb5.setChecked(false);
                number5.setVisibility(View.INVISIBLE);
                number5.setText("");
                select5.setText("");
                p5.setText("");
                total.setText("");
                check = false;
            }
        });

        btnSelect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb1.isChecked()) {
                    select.append(food1.getText().toString());
                    number1.setVisibility(View.VISIBLE);
                    p1.setText("300");
                    number1.setText("1");
                    check = true;
                } else {
                    number1.setVisibility(View.INVISIBLE);
                    select.setText("");
                    number1.setText("");
                    p1.setText("");
                    check = false;
                }
            }
        });


        btnSelect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb2.isChecked()) {
                    select2.append(food2.getText().toString());
                    number2.setVisibility(View.VISIBLE);
                    p2.setText("500");
                    number2.setText("1");
                    check = true;
                } else {
                    number2.setVisibility(View.INVISIBLE);
                    select2.setText("");
                    number2.setText("");
                    p2.setText("");
                    check = false;
                }
            }
        });

        btnSelect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb3.isChecked()) {
                    select3.append(food3.getText().toString());
                    number3.setVisibility(View.VISIBLE);
                    p3.setText("450");
                    number3.setText("1");
                    check = true;
                } else {
                    number3.setVisibility(View.INVISIBLE);
                    select3.setText("");
                    number3.setText("");
                    p3.setText("");
                    check = false;
                }
            }
        });

        btnSelect4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb4.isChecked()) {
                    select4.append(food4.getText().toString());
                    number4.setVisibility(View.VISIBLE);
                    p4.setText("200");
                    number4.setText("1");
                    check = true;
                } else {
                    number4.setVisibility(View.INVISIBLE);
                    select4.setText("");
                    number4.setText("");
                    p4.setText("");
                    check = false;
                }
            }
        });

        btnSelect5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb5.isChecked()) {
                    select5.append(food5.getText().toString());
                    number5.setVisibility(View.VISIBLE);
                    p5.setText("600");
                    number5.setText("1");
                    check = true;
                } else {
                    number5.setVisibility(View.INVISIBLE);
                    select5.setText("");
                    number5.setText("");
                    p5.setText("");
                    check = false;
                }
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //CheckBox1
                if (cb1.isChecked()) {
                    a = Integer.parseInt(p1.getText().toString());
                    b = Integer.parseInt(number1.getText().toString());
                    c = a * b;
                    e = String.valueOf(c);
                    p1.setText(e);
                }

                //CheckBox2
                if (cb2.isChecked()) {
                    a1 = Integer.parseInt(p2.getText().toString());
                    b1 = Integer.parseInt(number2.getText().toString());
                    c1 = a1 * b1;
                    e = String.valueOf(c1);
                    p2.setText(e);
                }
                //CheckBox3
                if (cb3.isChecked()) {
                    a2 = Integer.parseInt(p3.getText().toString());
                    b2 = Integer.parseInt(number3.getText().toString());
                    c2 = a2 * b2;
                    e = String.valueOf(c2);
                    p3.setText(e);
                }

                //CheckBox4
                if (cb4.isChecked()) {
                    a3 = Integer.parseInt(p4.getText().toString());
                    b3 = Integer.parseInt(number4.getText().toString());
                    c3 = a3 * b3;
                    e = String.valueOf(c3);
                    p4.setText(e);
                }

                //CheckBox5
                if (cb5.isChecked()) {
                    a4 = Integer.parseInt(p5.getText().toString());
                    b4 = Integer.parseInt(number5.getText().toString());
                    c4 = a4 * b4;
                    e = String.valueOf(c4);
                    p5.setText(e);
                }
                if (check == true) {
                    finalP = c + c1 + c2 + c3 + c4;
                    finalPrice = String.valueOf(finalP);
                    //total.append(finalPrice.toString());
                    total.append(select.getText().toString() + number1.getText().toString() + " " + select2.getText().toString() + number2.getText().toString() + " " + select3.getText().toString() + number3.getText().toString() + " " + select4.getText().toString() + " " + number4.getText().toString() + "  " + number5.getText().toString() + select5.getText().toString() + " " + finalPrice.toString());
                    String insert = null;
                    insert = total.getText().toString();

                    Map<String, String> OrderMap = new HashMap<>();
                    OrderMap.put("fatura", insert);
                    clean = true;
                    if (clean == true) {
                        if (cb1.isChecked())
                            cb1.setChecked(false);
                        number1.setVisibility(View.INVISIBLE);
                        number1.setText("");
                        select.setText("");
                        p1.setText("");
                        check = false;
                        if (cb2.isChecked())
                            cb2.setChecked(false);
                        number2.setVisibility(View.INVISIBLE);
                        number2.setText("");
                        select2.setText("");
                        p2.setText("");
                        check = false;
                        if (cb3.isChecked())
                            cb3.setChecked(false);
                        number3.setVisibility(View.INVISIBLE);
                        number3.setText("");
                        select3.setText("");
                        p3.setText("");
                        check = false;
                        if (cb4.isChecked())
                            cb4.setChecked(false);
                        number4.setVisibility(View.INVISIBLE);
                        number4.setText("");
                        select4.setText("");
                        p4.setText("");
                        check = false;
                        if (cb5.isChecked())
                            cb5.setChecked(false);
                        number5.setVisibility(View.INVISIBLE);
                        number5.setText("");
                        select5.setText("");
                        p5.setText("");
                        total.setText("");
                        check = false;
                    }
                    fStore.collection("fatura").add(OrderMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {

                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(MainActivity.this, "Order is added!", Toast.LENGTH_SHORT).show();
                            redirect = true;
                            if (redirect = true) {
                                timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(MainActivity.this, Order.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 1000);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            String error = e.getMessage();
                            Toast.makeText(MainActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (check == false) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Opss...");
                    builder.setTitle("You cannot submit an empty order...");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //  alertTextView.setVisibility(View.VISIBLE);
                        }
                    });
                    builder.show();
                    return;
                }

            }
        });
       //KETU ISHTE!
    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

}
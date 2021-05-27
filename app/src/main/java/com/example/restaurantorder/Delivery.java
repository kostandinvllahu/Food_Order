package com.example.restaurantorder;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Delivery#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Delivery extends Fragment {

   private EditText text;
   private  TextView success, success1;
    private Button sub, res;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    boolean check = false;
    Timer timer;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Delivery() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Delivery.
     */
    // TODO: Rename and change types and number of parameters
    public static Delivery newInstance(String param1, String param2) {
        Delivery fragment = new Delivery();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;


    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_delivery, container, false);
        sub = view.findViewById(R.id.subTotal);
        res = view.findViewById(R.id.subTotal2);
        text = view.findViewById(R.id.address);
        success = view.findViewById(R.id.textView7);
        success1 = view.findViewById(R.id.textView8);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = text.getText().toString().trim();
                  if(temp.length() == 0){
                      check = true;
                      success1.setText("Address is mandatory!");
                }else{
                      success.setText("Your order is completed, please wait for the delivery to arrive!");
                      timer = new Timer();
                      timer.schedule(new TimerTask() {
                          @Override
                          public void run() {
                              Intent redirect = new Intent(getActivity(),MainActivity.class);
                              getActivity().startActivity(redirect);

                          }
                      }, 1000);
                  }
            }
        });
        return view;
    }
}
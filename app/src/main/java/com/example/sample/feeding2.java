package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class feeding2 extends AppCompatActivity {
    TextView a,b,c,d,e;
    Button btn;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding2);
        a=findViewById(R.id.first);
        b=findViewById(R.id.second);
        c=findViewById(R.id.third);
        d=findViewById(R.id.fourth);
        e=findViewById(R.id.fifth);
        btn = findViewById((R.id.button2));
        btn.performClick();
        myRef = FirebaseDatabase.getInstance().getReference().child("feeding");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String firstfeed=dataSnapshot.child("firstfeed").getValue().toString();
                String secondfeed=dataSnapshot.child("secondfeed").getValue().toString();
                String thirdfeed=dataSnapshot.child("thirdfeed").getValue().toString();
                String fourthfeed=dataSnapshot.child("fourthfeed").getValue().toString();
                String fifthfeed=dataSnapshot.child("fifthfeed").getValue().toString();
                a.setText(firstfeed);
                b.setText(secondfeed);
                c.setText(thirdfeed);
                d.setText(fourthfeed);
                e.setText(fifthfeed);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(feeding2.this,home.class);
                startActivity(i);
            }
        });
            }
        }




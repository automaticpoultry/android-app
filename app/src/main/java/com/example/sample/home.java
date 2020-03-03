package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.Inet4Address;

public class home extends AppCompatActivity {
    TextView a,b,c;
    TextView d,e,f,g;
    Button btnLogout;
    Button btnFeeding;
    Button btnCleaning;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListerner;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef, myreff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.logout);
        btnFeeding = findViewById(R.id.feeding);
        btnCleaning = findViewById(R.id.cleaning);
        a= findViewById(R.id.temp);
        b=findViewById(R.id.dayornight);
        c=findViewById(R.id.feeds);
        d=findViewById(R.id.vitamins1);
        e=findViewById(R.id.vitamins2);
        f=findViewById(R.id.vitamins3);
        g=findViewById(R.id.vitamins4);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(home.this,MainActivity.class);
                startActivity(intToMain);
            }
        });
        btnFeeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intToFeed = new Intent(home.this,feeding2.class);
                startActivity(intToFeed);
            }
        });
        btnCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intToClean = new Intent(home.this,cleaning2.class);
                startActivity(intToClean);
            }
        });

        myRef = FirebaseDatabase.getInstance().getReference().child("home");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.child("dayornight").getValue().toString();
                String temperature=dataSnapshot.child("temp").getValue().toString();
                String feeds =dataSnapshot.child("feeds").getValue().toString();
                String vitamin1=dataSnapshot.child("vitamin1").getValue().toString();
                String vitamin2=dataSnapshot.child("vitamin2").getValue().toString();
                String vitamin3 =dataSnapshot.child("vitamin3").getValue().toString();
                String vitamin4 =dataSnapshot.child("vitamin4").getValue().toString();
                a.setText(temperature);
                b.setText(value);
                c.setText(feeds);
                d.setText(vitamin1);
                e.setText(vitamin2);
                f.setText(vitamin3);
                g.setText(vitamin4);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

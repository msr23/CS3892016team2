package com.vinacovre.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.Map;

public class NormalChampionshipActivity extends AppCompatActivity {
    Championship Champ = new Championship("Ryan", "Admin");
    TextView champName;
    TextView champCreator;
    private final static String FIREBASE_URL = "https://meupipaapplication.firebaseio.com/championships";
    private Firebase firebaseRef;
    int n = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_championship);
        champName = (TextView) findViewById(R.id.ChampionshipName);
        champName.setText(Champ.getChampionshipName());
        champCreator = (TextView) findViewById(R.id.ChampionshipCreator);
        champCreator.setText(Champ.getChampionshipCreator());

        firebaseRef = new Firebase(FIREBASE_URL);
        String oh = "-KFkYOPECROMhlsiDJKm";
        Query queryRef = firebaseRef.orderByValue().limitToFirst(n);
        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                Map<String, String> value = (Map<String, String>)snapshot.getValue();
             champName.setText(value.get("championshipName")); //This gets the first index, I dont know how to choose which one to grab
                //Maybe I have to change String previousCHild to the index string?
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
            // ...
        });


       // getSupportActionBar().setTitle("New Normal Championship");
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
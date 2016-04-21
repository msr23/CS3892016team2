package com.vinacovre.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import org.w3c.dom.Text;

import java.util.Map;

public class NormalChampionshipActivity extends AppCompatActivity {

    TextView champName;
    TextView champCreator;
    TextView champLocation;
    TextView champDate;
    TextView champTime;
    TextView champType;
    private final static String FIREBASE_URL = "https://meupipaapplication.firebaseio.com/championships";
    private Firebase firebaseRef;
    int n = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_championship);
        champName = (TextView)findViewById(R.id.ChampionshipName);
        champCreator = (TextView) findViewById(R.id.ChampionshipCreator);
        champLocation = (TextView) findViewById(R.id.ChampionshipLocation);
        champDate = (TextView) findViewById(R.id.ChampionshipDate);
        champTime = (TextView) findViewById(R.id.ChampionshipTime);
        champType = (TextView) findViewById(R.id.ChampionshipType);
        firebaseRef = new Firebase(FIREBASE_URL);
        String oh = "-KFkYOPECROMhlsiDJKm";
        Query queryRef = firebaseRef.orderByValue().limitToLast(1);
        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                Map<String, String> value = (Map<String, String>)snapshot.getValue();
                champName.setText(value.get("championshipName"));
                champCreator.setText(value.get("championshipCreator"));
                champLocation.setText(value.get("championshipLocation"));
                champDate.setText(value.get("championshipDate"));
                champTime.setText(value.get("championshipTime"));
                champType.setText(value.get("championshipType"));
                //This gets the first index, I dont know how to choose which one to grab
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
package com.vinacovre.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

public class NormalChampionshipActivity extends AppCompatActivity {

    TextView champName;
    TextView champCreator;
    TextView champLocation;
    TextView champDate;
    TextView champTime;
    TextView champType;
    EditText search;
    Button searchButton;
    private final static String FIREBASE_URL = "https://meupipaapplication.firebaseio.com/championships";
    private Firebase firebaseRef;
    int n = 2;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_championship);
        Firebase.setAndroidContext(this);
        firebaseRef = new Firebase(FIREBASE_URL);
        champName = (TextView) findViewById(R.id.ChampionshipName);
        champCreator = (TextView) findViewById(R.id.ChampionshipCreator);
        champLocation = (TextView) findViewById(R.id.ChampionshipLocation);
        champDate = (TextView) findViewById(R.id.ChampionshipDate);
        champTime = (TextView) findViewById(R.id.ChampionshipTime);
        champType = (TextView) findViewById(R.id.ChampionshipType);
        search = (EditText) findViewById(R.id.searchText);
        searchButton = (Button) findViewById(R.id.Search);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               pullsearch();

            }
        });

    }




    public void pullsearch() {

        String searchInput = search.getText().toString();
        if (!(searchInput.equals(""))) {
            String oh = "championshipName";
            Query queryRef = firebaseRef.orderByChild(oh).equalTo(searchInput);




            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                    Championship champ = snapshot.getValue(Championship.class);

                    // Map<String, String> value = (Map<String, String>)snapshot.getValue();
                    champName.setText(champ.getChampionshipName());
                    champCreator.setText(champ.getChampionshipCreator());
                    champLocation.setText(champ.getChampionshipDate());
                    champDate.setText(champ.getChampionshipDate());
                    champTime.setText(champ.getChampionshipTime());
                    champType.setText(champ.getChampionshipType());
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
        }
    }

}
package com.vinacovre.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.view.KeyEvent;
import android.view.View;
import android.support.*;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.concurrent.ConcurrentHashMap;

public class AddChampionshipActivity extends AppCompatActivity {

    EditText ChampionshipName;
    private final static String FIREBASE_URL = "https://meupipaapplication.firebaseio.com/championships";
    private Firebase firebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_championship);
        Firebase.setAndroidContext(this);
        firebaseRef = new Firebase(FIREBASE_URL).push();

        EditText inputText = (EditText) findViewById(R.id.ChampionshipName);
        inputText.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if(actionId == EditorInfo.IME_ACTION_SEND)
                {
                    sendMessage();
                }
                return true;
            }
        });

        findViewById(R.id.ChampionshipNext).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                sendMessage();
            }
        });
    }


  /*  protected void onStart() {
        super.onStart();
        Button championshipNext = (Button)findViewById(R.id.ChampionshipNext);
        championshipNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                sendMessage();
               // Intent intent = new Intent(AddChampionshipActivity.this, ChampionshipsFragment.class);
                //startActivity(intent);
            }
        });

        findViewById(R.id.ChampionshipNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sendMessage();
            }
        });
    }*/


    public void sendMessage() {
        EditText textChampNameInput = (EditText) (findViewById(R.id.ChampionshipName));

        String ChampName = textChampNameInput.getText().toString();

        if (!ChampName.equals("")) {
            Championship champions = new Championship(ChampName, "Admin");
            System.out.println("******************************************************************");
            System.out.println("HELLO");
            System.out.println("******************************************************************");
            firebaseRef.setValue(champions);
            System.out.println("******************************************************************");
            System.out.println("HELLO");
            System.out.println("******************************************************************");
            textChampNameInput.setText("");
        }
    }


}

  //  getSupportActionBar().setTitle("New Championship");
    //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_championship);
        Button next = (Button) findViewById(R.id.ChampionshipNext);*/

        /*next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroupChampionship);
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio_championship_friendly:
                        Intent intent1 = new Intent(v.getContext(), FriendlyChampionshipActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.radio_championship_normal:
                        Intent intent2 = new Intent(v.getContext(), NormalChampionshipActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });*/


//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radio_championship_friendly:
//                if (checked)
//
//                    break;
//            case R.id.radio_championship_normal:
//                if (checked)
//                    break;
//        }
//    }


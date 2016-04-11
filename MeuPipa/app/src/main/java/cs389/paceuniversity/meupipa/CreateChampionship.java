package cs389.paceuniversity.meupipa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class CreateChampionship extends AppCompatActivity {
    EditText ChampionshipName;
    EditText ChampionshipLocation; //These three are just my edit text boxes started with just them
    EditText ChampionshipCreator;
    private final static String FIREBASE_URL = "https://meu-pipa1.firebaseio.com/"; //Create a string to store the database url
    private Firebase FirebaseRef; //Creates a reference connection to the firebase database
    Championships champion = new Championships();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_championship); //sets the layout of the class to the create championship xml class
        Firebase.setAndroidContext(this); //This is setting the firebase context to this class, meanining that the infomration
        //generate and manipulated is done by this class
        FirebaseRef = new Firebase(FIREBASE_URL); //connects local firebase client to the firebase database

    }

    protected void onStart()
    {
        super.onStart();
        ChampionshipName = (EditText)findViewById(R.id.ChampionshipName);
        ChampionshipLocation = (EditText)findViewById(R.id.ChampionshipLocation);
        ChampionshipCreator = (EditText)findViewById(R.id.ChampionshipCreator); //Listeners for the text files
        ChampionshipName.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                sendMessage();
                return false;
            }


        });

        findViewById(R.id.CreateChampionship).setOnClickListener(new View.OnClickListener()
        {
           public void onClick(View v)
           {
               sendMessage();
           }
        });
    }



    public void sendMessage()
    {
        EditText textChampNameInput = (EditText) (findViewById(R.id.ChampionshipName));
        String ChampName = textChampNameInput.getText().toString();

        EditText textChampCreatorInput = (EditText) (findViewById(R.id.ChampionshipCreator));
        String ChampCreator = textChampCreatorInput.getText().toString();

        EditText textChampLocationInput = (EditText) (findViewById(R.id.ChampionshipLocation));
        String ChampLocation = textChampLocationInput.getText().toString();
        if(!ChampName.equals(""))
        {
            
            Championships champ = new Championships();
            champ.setChampionshipName(ChampName);
            FirebaseRef.push().setValue(champ);
            textChampNameInput.setText("");
        }
    }
        /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_championship);

        RadioButton friendlyMeetup = (RadioButton) findViewById(R.id.FriendlyMeetup);
        friendlyMeetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button championshipNext = (Button) findViewById(R.id.ChampionshipNext);
        championshipNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateChampionship.this, FinishChampionship.class);
            }
        });
    } */

}
//    public void onRadioButtonClicked(View view) {
//        boolean checked = ((android.widget.RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.FriendlyMeetup:
//                if (checked)
//                    //
//                    break;
//            case R.id.NormalTournment:
//                if (checked)
//                    //
//                    break;
//        }
//    }   ojp
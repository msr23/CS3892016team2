package com.vinacovre.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class AddChampionshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_championship);
        Button next = (Button) findViewById(R.id.ChampionshipNext);

        next.setOnClickListener(new View.OnClickListener() {
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
        });
        getSupportActionBar().setTitle("New Championship");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

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
}

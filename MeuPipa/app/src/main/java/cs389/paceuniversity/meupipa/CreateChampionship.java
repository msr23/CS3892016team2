package cs389.paceuniversity.meupipa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class CreateChampionship extends Activity{
    @Override
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
    }

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
//    }
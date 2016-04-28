package com.vinacovre.myapplication;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Query;
/**
 * Created by Christian on 4/26/16.
 */
public class ChampionshipAdapter extends FirebaseListAdapter<Championship> {
  /*  public ChampionshipAdapter(Context context, int resource, ArrayList<Championship> championships)
    {
        super(context,resource,championships);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Championship champ = getItem(position);
        //If thhis isnt working change convert view to View v, and then continue trying to mess around with thiss class


        View v = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.list_view_layout,null);;

        TextView tvName = (TextView) v.findViewById(R.id.championshipName);
        TextView tvLocation = (TextView) v.findViewById(R.id.championshipLocation);

        tvName.setText(champ.getChampionshipName());
        tvLocation.setText(champ.getChampionshipLocation());


        if((convertView == null))
        {
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_view_layout, parent, false);
            //convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.list_view_layout,null);
        }

        return  v;
    }*/



   public ChampionshipAdapter(Query ref, Activity acitivity, int layout)
   {
       super(ref, Championship.class, layout, acitivity);

   }

    @Override
    protected void populateView(View v, Championship championship) {
        String championshipName = championship.getChampionshipName();
        String championshipLocation = championship.getChampionshipLocation();

        TextView championshipNameText = (TextView) v.findViewById(R.id.championshipName);
        TextView championshipLocationText = (TextView) v.findViewById(R.id.championshipLocation);

        championshipNameText.setText(championshipName + ":");
        championshipLocationText.setText(championshipLocation + ":");



    }





}

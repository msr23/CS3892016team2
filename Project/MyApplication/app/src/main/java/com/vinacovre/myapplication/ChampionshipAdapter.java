package com.vinacovre.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Christian on 4/26/16.
 */
public class ChampionshipAdapter extends ArrayAdapter<Championship> {
   public ChampionshipAdapter(Context context, ArrayList<Championship> championships)
   {
       super(context,0,championships);
   }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Championship champ = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_layout, parent, false);

        }

        TextView tvName = (TextView) convertView.findViewById(R.id.championshipName);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.championshipLocation);

        tvName.setText(champ.getChampionshipName());
        tvLocation.setText(champ.getChampionshipLocation());
        return  convertView;
    }


}

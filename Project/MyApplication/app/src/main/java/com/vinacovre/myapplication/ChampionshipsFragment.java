package com.vinacovre.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.ArrayList;


public class ChampionshipsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Championship> arrayOfChampionships;

    Firebase firebaseRef;
    
    private String FIREBASE_URL = "https://meupipaapplication.firebaseio.com/championships";

    public ChampionshipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChampionshipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChampionshipsFragment newInstance(String param1, String param2) {
        ChampionshipsFragment fragment = new ChampionshipsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /*
    public void onStart(){
        super.onStart();

        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.two_line_list_item, firebaseRef){

            @Override
            protected void populateView(View view, ChampionshipsFragment, String s, int i){

            }

        }

    }
    */

  /*  @Override
    public void onStart() {
        super.onStart();

        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, firebaseRef){
            @Override
            public void populateView(View view, String s, int i){
                TextView.text = new TextView(view).findViewById(android.R.id.text1);
                text.setText(s);
            }
        };

    } */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddChampionshipActivity.class);
                startActivity(intent);
            }
        });

        firebaseRef = new Firebase(FIREBASE_URL);
        arrayOfChampionships = new ArrayList<>();
        Query queryRef = firebaseRef.orderByChild("championshipName");
        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Championship cha = dataSnapshot.getValue(Championship.class);

                String name = cha.getChampionshipName();
                String location = cha.getChampionshipLocation();
                Championship twoparama = new Championship(name, location);
                arrayOfChampionships.add(twoparama);


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




            // Map<String, String> value = (Map<String, String>)snapshot.getValue();

            //This gets the first index, I dont know how to choose which one to grab
            //Maybe I have to change String previousCHild to the index string?




        });
       // System.out.println(arrayOfChampionships.get(0));

        ChampionshipAdapter adapter = new ChampionshipAdapter(this.getActivity(), arrayOfChampionships);
        ListView listview = (ListView) getActivity().findViewById(R.id.championshipListView);
        listview.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_championships, container, false);
    }

}

package com.vinacovre.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NormalChampionshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_championship);
        getSupportActionBar().setTitle("New Normal Championship");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

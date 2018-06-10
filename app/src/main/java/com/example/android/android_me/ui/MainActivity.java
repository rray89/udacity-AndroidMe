package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// TODO (5.4) Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // TODO (5.5) Define the behavior for onImageSelected; create a Toast that displays the position clicked

}

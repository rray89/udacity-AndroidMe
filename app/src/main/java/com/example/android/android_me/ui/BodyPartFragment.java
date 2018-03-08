package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

// COMPLETED TF.01 TODO (1.2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
// In this class, you'll need to implement an empty constructor and the onCreateView method
public class BodyPartFragment extends Fragment {

    //Tag for logging
    private static final String TAG = "BodyPartFragment";

    //Var to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> mImageIds;
    private int mListIndex;


    public BodyPartFragment() {
        // Required empty public constructor for instantiating the fragment
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        //get a reference to the ImageView in the fragment layout
        ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_body_part);

        // COMPLETED TF.01 TODO (1.3) Show the first image in the list of head images
        if (mImageIds != null) {
            // COMPLETED TF.02 TODO (2.3) If a list of image ids exists, set the image resource to the correct item in that list
            imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        } else { // Otherwise, create a Log statement that indicates that the list was not found
            Log.v(TAG, "This fragment has a null list of image ids. ");
        }

        return rootView;
    }

    // COMPLETED TF.02 TODO (2.1) Create a setter method and class variable to set and store of a list of image resources
    public void setmImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    // COMPLETED TF.02 TODO (2.2) Create another setter method and variable to track and set the index of the list item to display
    // ex. index = 0 is the first image id in the given list , index 1 is the second, and so on
    public void setmListIndex(int listIndex) {
        mListIndex = listIndex;
    }


}

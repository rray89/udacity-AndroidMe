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

import java.util.ArrayList;
import java.util.List;

// COMPLETED TF.01 TODO (1.2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
// In this class, you'll need to implement an empty constructor and the onCreateView method
public class BodyPartFragment extends Fragment {

    // COMPLETED TF.03 TODO (3.3) Create final Strings to store state information about the list of images and list index
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    //Tag for logging
    private static final String TAG = "BodyPartFragment";

    //list to store a list of image resources and
    private List<Integer> mImageIds;
    //the index of the image that this fragment displays
    private int mListIndex;


    public BodyPartFragment() {
        // Required empty public constructor for instantiating the fragment
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Load the saved state (the list of images and list index) if there is one
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        //get a reference to the ImageView in the fragment layout
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_body_part);

        // COMPLETED TF.01 TODO (1.3) Show the first image in the list of head images
        if (mImageIds != null) {
            // COMPLETED TF.02 TODO (2.3) If a list of image ids exists, set the image resource to the correct item in that list
            imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

            // COMPLETED TF.03 TODO (3.1) Set a click listener on the image view and on a click increment the list index and set the image resource
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    }
                    // COMPLETED TF.03 TODO (3.2) If you reach the end of a list of images, set the list index back to 0 (the first item in the list)
                    else {
                        mListIndex = 0;
                    }
                }
            });
            imageView.setImageResource(mImageIds.get(mListIndex));

        } else { // Otherwise, create a Log statement that indicates that the list was not found
            Log.v(TAG, "This fragment has a null list of image ids. ");
        }

        return rootView;
    }

    // COMPLETED TF.02 TODO (2.1) Create a setter method and class variable to set and store of a list of image resources
    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    // COMPLETED TF.02 TODO (2.2) Create another setter method and variable to track and set the index of the list item to display
    // ex. index = 0 is the first image id in the given list , index 1 is the second, and so on
    public void setListIndex(int listIndex) {
        mListIndex = listIndex;
    }

    // COMPLETED TF.03 TODO (3.4) Override onSaveInstanceState and save the current state of this fragment
    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}

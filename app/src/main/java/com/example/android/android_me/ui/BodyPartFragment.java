package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// COMPLETED TODO (2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
// In this class, you'll need to implement an empty constructor and the onCreateView method
public class BodyPartFragment extends Fragment {

    public BodyPartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        //get a reference to the ImageView in the fragment layout
        ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_body_part);

        // COMPLETED TODO (3) Show the first image in the list of head images
        // Soon, you'll update this image display code to show any image you want
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        return inflater.inflate(R.layout.fragment_body_part, container, false);
    }


}

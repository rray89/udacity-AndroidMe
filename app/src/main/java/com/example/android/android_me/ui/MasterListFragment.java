
// COMPLETED TODO (4.2) Create a new class called MasterListFragment which will display the GridView list of ALL AndroidMe images
    // In the fragment class, you'll need to implement an empty constructor, and onCreateView

package com.example.android.android_me.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


// This fragment displays all of the AndroidMe images in one large list
// The list appears as a grid of images
public class MasterListFragment extends Fragment {

    // COMPLETED TODO (5.1) Define a new interface OnImageClickListener that triggers a callback in the host activity
        // The callback is a method named onImageSelected(int position) that contains information about
        // which position on the grid of images a user has clicked
    OnImageClickListener mCallBack;

    // OnImageClickListener interface, calls a method in the host activity named onImageSelected
    public interface OnImageClickListener {
        void onImageSelected(int position);
    }


    // COMPLETED TODO (5.2) Override onAttach to make sure that the container activity has implemented the callback
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        try {
            mCallBack = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnImageClickListener");
        }
    }

    public MasterListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        //reference to the GridView in the fragment_master_list.xml
        GridView gridView = rootView.findViewById(R.id.gv_images);

        // COMPLETED TODO (4.3) Create a new MasterListAdapter and set it on the GridView
            // The MasterListAdapter code is provided; it creates the ImageViews that are contained in the GridView
            // The adapter takes as parameters (Context context, List<Integer> imageIds)
        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(masterListAdapter);

        // Set a click listener on the gridView and trigger the callback onImageSelected when an item is clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallBack.onImageSelected(position);
            }
        });

        return rootView;
    }




}

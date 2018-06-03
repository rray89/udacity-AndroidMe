
// COMPLETED TODO (4.2) Create a new class called MasterListFragment which will display the GridView list of ALL AndroidMe images
    // In the fragment class, you'll need to implement an empty constructor, and onCreateView

package com.example.android.android_me.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


// This fragment displays all of the AndroidMe images in one large list
// The list appears as a grid of images
public class MasterListFragment extends Fragment {

    public MasterListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        //reference to the GridView in the fragment_master_list.xml
        GridView gridView = rootView.findViewById(R.id.grid_view_images);

        // COMPLETED TODO (4.3) Create a new MasterListAdapter and set it on the GridView
            // The MasterListAdapter code is provided; it creates the ImageViews that are contained in the GridView
            // The adapter takes as parameters (Context context, List<Integer> imageIds)
        MasterListAdapter masterListAdapter = new MasterListAdapter(gridView.getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(masterListAdapter);

        return rootView;
    }
}

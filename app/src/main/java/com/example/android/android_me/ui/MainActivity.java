package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity is responsible for displaying the master list of all images
// COMPLETED TODO (5.4) Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    // COMPLETED TODO (7.3) Create a variable to track whether to display a two-pane or single-pane UI
        // A single-pane display refers to phone screens, and two-pane to larger tablet screens
    private boolean ifTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // COMPLETED TODO (7.4) If you are making a two-pane display, add new BodyPartFragments to create an initial Android-Me image
            // Also, for the two-pane display, get rid of the "Next" button in the master list fragment
        if (findViewById(R.id.ll_android_me) != null) {
            ifTwoPane = true;

            GridView gridView = findViewById(R.id.gv_images);
            gridView.setNumColumns(2);

            Button nextButton = findViewById(R.id.next_btn);
            nextButton.setVisibility(View.GONE);

            if(savedInstanceState == null) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setImageIds(AndroidImageAssets.getHeads());
                fragmentManager.beginTransaction()
                        .add(R.id.fl_head_container, headFragment)
                        .commit();

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setImageIds(AndroidImageAssets.getBodies());
                fragmentManager.beginTransaction()
                        .add(R.id.fl_body_container, bodyFragment)
                        .commit();

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setImageIds(AndroidImageAssets.getLegs());
                fragmentManager.beginTransaction()
                        .add(R.id.fl_leg_container, legFragment)
                        .commit();
            }
        } else {
            ifTwoPane = false;
        }
    }

    // COMPLETED TODO (5.5) Define the behavior for onImageSelected; create a Toast that displays the position clicked
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // COMPLETED TODO (6.2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
            // bodyPartNumber will be = 0 for the head fragment, 1 for the body, and 2 for the leg fragment
            // Dividing by 12 gives us these integer values because each list of images resources has a size of 12
        int bodyPartNumber = position/12;

        // Store the correct list index no matter where in the image list has been clicked
        // This ensures that the index will always be a value between 0-11
        int listIndex = position - bodyPartNumber*12;

        // COMPLETED TODO (7.5) Handle the two-pane case and replace existing fragments right when a new image is selected from the master list
            // The two-pane case will not need a Bundle or Intent since a new activity will not be started;
            // This is all happening in this MainActivity and one fragment will be replaced at a time
        if (ifTwoPane) {
            BodyPartFragment newFragment = new BodyPartFragment();

            switch (bodyPartNumber) {
                case 0:
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_head_container, newFragment)
                            .commit();
                    break;
                case 1:
                    newFragment.setImageIds(AndroidImageAssets.getBodies());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_body_container, newFragment)
                            .commit();
                    break;
                case 2:
                    newFragment.setImageIds(AndroidImageAssets.getLegs());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_leg_container, newFragment)
                            .commit();
                    break;
                default:
                    break;
            }

        } else {
            switch (bodyPartNumber) {
                case 0: headIndex = listIndex; break;
                case 1: bodyIndex = listIndex; break;
                case 2: legIndex = listIndex; break;
                default: break;
            }
        }
        // Set the currently displayed item for the correct body part fragment


        // COMPLETED TODO (6.3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        Bundle bundle = new Bundle();
        bundle.putInt("headIndex", headIndex);
        bundle.putInt("bodyIndex", bodyIndex);
        bundle.putInt("legIndex", legIndex);

        // Attach the Bundle to an intent
        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);

        // COMPLETED TODO (6.4) Get a reference to the "Next" button and launch the intent when this button is clicked
        Button nextButton = findViewById(R.id.next_btn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

}

package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

import butterknife.BindView;


public class ProfileNeighbourActivity extends AppCompatActivity {
    @BindView(R.id.profile_activity_previous_button)
    Button mButton;
    @BindView(R.id.profile_activity_avatar_image)
    ImageView mImage;
    @BindView(R.id.profile_activity_fav_button)
    FloatingActionButton mFavButton;
    @BindView(R.id.profile_activity_name_text)
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);
    }

    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, ProfileNeighbourActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}

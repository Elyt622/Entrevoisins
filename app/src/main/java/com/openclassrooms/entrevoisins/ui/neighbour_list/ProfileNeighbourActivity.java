package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileNeighbourActivity extends AppCompatActivity {

    // UI Components
    @BindView(R.id.profile_activity_previous_button)
    public ImageButton mButtonPrevious;
    @BindView(R.id.profile_activity_avatar_image)
    public ImageView mImage;
    @BindView(R.id.profile_activity_fav_button)
    public FloatingActionButton mButtonFav;
    @BindView(R.id.profile_activity_name_text)
    public TextView mTextName;
    @BindView(R.id.profile_activity_about_text)
    public TextView mTextAbout;
    @BindView(R.id.profile_activity_name2_text)
    public TextView mTextName2;
    @BindView(R.id.profile_activity_adress_text)
    public TextView mTextAddress;
    @BindView(R.id.profile_activity_phone_text)
    public TextView mTextPhone;
    @BindView(R.id.profile_activity_website_text)
    public TextView mTextWebsite;

    String mLinkFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);
        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        String mName = mIntent.getStringExtra("NAME");
        Uri mAvatar = Uri.parse(mIntent.getStringExtra("AVATAR"));
        String mAddress = mIntent.getStringExtra("ADDRESS");
        String mPhone = mIntent.getStringExtra("PHONE");
        String mAbout = mIntent.getStringExtra("ABOUT");

        mLinkFb = "https://facebook.com/" + mName;

        Glide.with(mImage.getContext())
                .load(mAvatar)
                .into(mImage);
        mTextName.setText(mName);
        mTextAbout.setText(mAbout);
        mTextName2.setText(mName);
        mTextAddress.setText(mAddress);
        mTextPhone.setText(mPhone);
        mTextWebsite.setText(mLinkFb);


        mButtonPrevious.setOnClickListener(v -> finish());

        mButtonFav.setOnClickListener(v -> {

        });
    }
}

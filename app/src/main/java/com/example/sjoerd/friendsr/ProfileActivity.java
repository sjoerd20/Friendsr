package com.example.sjoerd.friendsr;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private Friend retrievedFriend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // get intent from MainActivity
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // draw image
        ImageView image = findViewById(R.id.imageView);
        Drawable imageDrawable = getResources().getDrawable(retrievedFriend.getDrawableId());
        image.setImageDrawable(imageDrawable);

        // set name
        TextView name = findViewById(R.id.textName);
        name.setText(retrievedFriend.getName());

        // set bio
        TextView bio = findViewById(R.id.textBio);
        bio.setText(retrievedFriend.getBio());

        // set rating
        RatingBar rating = findViewById(R.id.ratingBar);
        rating.setRating(retrievedFriend.getRating());
    }

    // implements ratingBar clicklistener
    private class RatingBarClickListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            RatingBar rating = findViewById(R.id.ratingBar);
            rating.setRating(v);
        }
    }


}

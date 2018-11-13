package com.example.sjoerd.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.view.View;
import android.util.Log;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    // ArrayList of sample friends
    private ArrayList<Friend> arrayListFriends = new ArrayList<>();
    private String listFriends[] = {"arya", "cersei", "daenerys", "jaime", "jon", "jorah",
                                    "margaery", "melisandre", "sansa", "tyrion"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < listFriends.length; i++) {
            int resourceID = getResources().getIdentifier(listFriends[i], "drawable",
                    getPackageName());
            Friend friend = new Friend(listFriends[i], "This is " + listFriends[i], resourceID);
            arrayListFriends.add(friend);
        }

        // instantiate FriendsAdapter
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, arrayListFriends);

        // show on grid
        GridView gv = findViewById(R.id.gv);
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new GridItemClickListener());
    }

    // implements onClickListener
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            // extract friend object
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);

            // pass info to ProfileActivity
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}

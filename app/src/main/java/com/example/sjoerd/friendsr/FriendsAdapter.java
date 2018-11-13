package com.example.sjoerd.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent,
                                             false);
        }

        // get current friend
        Friend friend = friends.get(position);

        // draw image
        ImageView image = convertView.findViewById(R.id.imageView);
        Drawable imageDrawable = getContext().getResources().getDrawable(friend.getDrawableId());
        image.setImageDrawable(imageDrawable);

        // set name
        TextView name = convertView.findViewById(R.id.textView);
        name.setText(friend.getName());

        return convertView;
    }

    // constructor
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }
}

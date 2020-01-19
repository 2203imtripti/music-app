package com.example.friendchat;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {

    private Button mSongBtn2;
    public FriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends, container, false);


        mSongBtn2 = (Button)view.findViewById(R.id.songs_btn2);

        mSongBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent song_Intent1 = new Intent(getActivity(),album1.class);
                startActivity(song_Intent1);

            }
        });
        return view;
    }

}

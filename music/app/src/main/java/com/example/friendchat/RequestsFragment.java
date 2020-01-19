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
public class RequestsFragment extends Fragment {

    private Button mSongBtn3;

    public RequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_requests, container, false);


        mSongBtn3 = (Button)view.findViewById(R.id.songs_btn3);

        mSongBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent song_Intent1 = new Intent(getActivity(),GenreActivity.class);
                startActivity(song_Intent1);

            }
        });
        return view;
    }
    }



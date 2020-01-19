package com.example.friendchat;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;


public class NewActivity extends AppCompatActivity {

    private String[] itemsAll;
    private ListView mSongsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        mSongsList = findViewById(R.id.songsList);

        appExtenalStorageStoragePermission();

    }


    public void appExtenalStorageStoragePermission() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {

                        displayAudioSongsName();

                    }
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {


                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permission, PermissionToken token) {

                        token.continuePermissionRequest();
                    }


                }).check();
    }


    public ArrayList<File> readOnlyAudioSongs(File file) {
        ArrayList<File> arrayList = new ArrayList<>();


        File[] allFiles = file.listFiles();

        for (File individualFile : allFiles) {
            if (individualFile.isDirectory() && !individualFile.isHidden()) {
                arrayList.addAll(readOnlyAudioSongs(individualFile));
            } else {
                if (individualFile.getName().endsWith(".mp3") || individualFile.getName().endsWith(".aac") || individualFile.getName().endsWith(".wav") || individualFile.getName().endsWith(".wma")) {
                    arrayList.add(individualFile);
                }
            }
        }

        return arrayList;
    }


    private void displayAudioSongsName() {
        final ArrayList<File> audioSongs = readOnlyAudioSongs(Environment.getExternalStorageDirectory());

        itemsAll = new String[audioSongs.size()];

        for (int songsCounter = 0; songsCounter < audioSongs.size(); songsCounter++) {
            itemsAll[songsCounter] = audioSongs.get(songsCounter).getName();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(NewActivity.this, android.R.layout.simple_list_item_1, itemsAll);
        mSongsList.setAdapter(arrayAdapter);

        mSongsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String songName = mSongsList.getItemAtPosition(position).toString();
                Intent intent = new Intent(NewActivity.this, Main1Activity.class);
                intent.putExtra("song", audioSongs);
                intent.putExtra("name", songName);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }
}


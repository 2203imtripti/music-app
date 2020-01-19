package com.example.friendchat;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class song1 extends AppCompatActivity {

    TextView harrdy;
    TextView kya;
    ImageView img;
    Button play;
    Button pause;
    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;
    int count=0;
    String[] kya_h=new String[]{
            "Snanm mennu","Ishq bulava",
            "Mere mehboob","neele neele",
            "Hai apna dil"
    };
    String[] harrdy_h=new String[]{
            "Single -sanam(Band)",
            "Single -sanam(Band)",
            "Single -sanam(Band)","Single -sanam(Band)",
            "Single -sanam(Band)"
    };
    int[] img_h=new int[]{
            R.drawable.sanam,R.drawable.sanam,R.drawable.sanam,R.drawable.sanam,R.drawable.sanam

    };
    int[] songs_h=new int[]{
            R.raw.mennu,R.raw.ishq,R.raw.mere,R.raw.neele,R.raw.hai

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song1);
        play=(Button)findViewById(R.id.new1);
        harrdy=(TextView) findViewById(R.id.hardy);
        kya=(TextView)findViewById(R.id.kya);
        img=(ImageView)findViewById(R.id.img);
        kya.setText(kya_h[count]);
        harrdy.setText(harrdy_h[count]);
        img.setImageResource(img_h[count]);
        pause=(Button)findViewById(R.id.b4);




    }

    public void forw(View view){
        if(count<4) {
            count++;
            kya.setText(kya_h[count]);
            harrdy.setText(harrdy_h[count]);
            img.setImageResource(img_h[count]);

        }

    }
    public void prev(View view){
        if(count>0) {
            count--;
            kya.setText(kya_h[count]);
            harrdy.setText(harrdy_h[count]);
            img.setImageResource(img_h[count]);

        }


    }

    public void playsong(View view) {

        mediaPlayer = MediaPlayer.create(getApplicationContext(), songs_h[count]);
        mediaPlayer.start();
        count++;
    }
    public void pause(View view){
        if (mediaPlayer!=null){
            mediaPlayer.pause();
            pauseCurrentPosition=mediaPlayer.getCurrentPosition();
        }

    }

}

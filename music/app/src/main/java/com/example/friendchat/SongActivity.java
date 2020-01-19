package com.example.friendchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    ListView listView;

    String mtitle[] = {"Sanam Puri","Harddy Sandhu","Black Pink","BTS","western"};
    String description[] ={"Single -Sanam (Band)","Kya baat hai","Black Pink(Band)","K-Pop","various"};
    int images[] ={R.drawable.sanam1,R.drawable.hardy,R.drawable.blackpink,R.drawable.bts,R.drawable.chart};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        listView= findViewById(R.id.listview);
        MyAdapter adapter= new MyAdapter(this,mtitle,description,images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    Intent intent = new Intent(SongActivity.this,album1.class);
                    startActivity(intent);
                }
                if (position==1)
                {
                    Intent intent = new Intent(SongActivity.this,album2.class);
                    startActivity(intent);
                }
                if (position==2)
                {
                    Intent intent = new Intent(SongActivity.this,album3.class);
                    startActivity(intent);
                }
                if (position==3)
                {
                    Intent intent = new Intent(SongActivity.this,album4.class);
                    startActivity(intent);
                }
                if (position==4)
                {
                    Intent intent = new Intent(SongActivity.this,album5.class);
                    startActivity(intent);
                }



            }
        });
    }

    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rTitle[];
        String rdes[];
        int rimg[];

        MyAdapter (Context c, String title[],String desc[],int img[]){
            super(c,R.layout.row,R.id.textView1,title);
            this.context=c;
            this.rTitle=title;
            this.rdes=desc;
            this.rimg=img;

        }
        @NonNull
        @Override
        public View getView(int position,@NonNull View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row =layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView mytitle=row.findViewById(R.id.textView1);
            TextView mydes=row.findViewById(R.id.textView2);
            images.setImageResource(rimg[position]);
            mytitle.setText(rTitle[position]);
            mydes.setText(rdes[position]);

            return row;
        }
    }

}

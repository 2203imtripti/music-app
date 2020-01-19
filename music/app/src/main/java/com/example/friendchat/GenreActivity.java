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

public class GenreActivity extends AppCompatActivity {

    ListView listView1;
    String mtitle[] = {"Hip hop","Acoustic"};
    String description[] ={"Stylized rhythmic music","Solely instrumental"};
    int images[] ={R.drawable.genre1,R.drawable.genre2,};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        listView1= findViewById(R.id.listview1);
        GenreActivity.MyAdapter adapter= new GenreActivity.MyAdapter(this,mtitle,description,images);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    Intent intent = new Intent(GenreActivity.this,genre1.class);
                    startActivity(intent);
                }
                if (position==1)
                {
                    Intent intent = new Intent(GenreActivity.this,genre2.class);
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

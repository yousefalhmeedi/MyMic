package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Vedio extends AppCompatActivity {

ListView listView;

    String mTitle[] ={" الدرس الاول " , " الدرس الثاني " ," الدرس الثالث " ," الدرس الرابع " ," الدرس الخامس " ," الدرس السادس " , " الدرس السابع " ," الدرس الثامن "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);


listView =findViewById(R.id.listView);
MyAdapter adapter = new  MyAdapter(this,mTitle);

listView.setAdapter(adapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){

            Toast.makeText(Vedio.this," Lesson 1",Toast.LENGTH_SHORT).show();
            Intent website = new Intent(Intent.ACTION_VIEW);
            website.setData(Uri.parse("https://www.youtube.com/watch?v=pKlvlwwF-n4"));
            if (website.resolveActivity(getPackageManager()) != null){
                startActivity(website);
            }

        }
        if(position == 1){

            Toast.makeText(Vedio.this," Lesson 2",Toast.LENGTH_SHORT).show();
            Intent website = new Intent(Intent.ACTION_VIEW);
            website.setData(Uri.parse("https://www.youtube.com/watch?v=1_YygYNmn-o&list=RDpKlvlwwF-n4&index=2"));
            if (website.resolveActivity(getPackageManager()) != null){
                startActivity(website);
            }

        }
        if(position == 2){

            Toast.makeText(Vedio.this," Lesson 3",Toast.LENGTH_SHORT).show();
            Intent website = new Intent(Intent.ACTION_VIEW);
            website.setData(Uri.parse("https://www.youtube.com/watch?v=EEJu1ELfqpk"));
            if (website.resolveActivity(getPackageManager()) != null){
                startActivity(website);
            }

        }
        if(position == 3){

            Toast.makeText(Vedio.this," Lesson 4",Toast.LENGTH_SHORT).show();
            Intent website = new Intent(Intent.ACTION_VIEW);
            website.setData(Uri.parse("https://www.youtube.com/watch?v=Q8gV0t4uLfY"));
            if (website.resolveActivity(getPackageManager()) != null){
                startActivity(website);
            }

        } if(position == 4){

            Toast.makeText(Vedio.this," Lesson 5",Toast.LENGTH_SHORT).show();
            Intent website = new Intent(Intent.ACTION_VIEW);
            website.setData(Uri.parse("https://www.youtube.com/watch?v=__BkB9BTye4"));
            if (website.resolveActivity(getPackageManager()) != null){
                startActivity(website);
            }

        }
        if(position == 5){

            Toast.makeText(Vedio.this," Lesson 6",Toast.LENGTH_SHORT).show();
            Intent website = new Intent(Intent.ACTION_VIEW);
            website.setData(Uri.parse("https://www.youtube.com/watch?v=nG2y2Uz_hZg"));
            if (website.resolveActivity(getPackageManager()) != null){
                startActivity(website);
            }

        } if(position == 6){

            Toast.makeText(Vedio.this," Lesson 7",Toast.LENGTH_SHORT).show();
            Intent website = new Intent(Intent.ACTION_VIEW);
            website.setData(Uri.parse("https://www.youtube.com/watch?v=ChAqVjsbbMM"));
            if (website.resolveActivity(getPackageManager()) != null){
                startActivity(website);
            }

        } if(position == 7){

            Toast.makeText(Vedio.this," Lesson 8",Toast.LENGTH_SHORT).show(); Intent website = new Intent(Intent.ACTION_VIEW);
            website.setData(Uri.parse("https://www.youtube.com/watch?v=80wOs4UddHI"));
            if (website.resolveActivity(getPackageManager()) != null){
                startActivity(website);
            }

        }





    }
});

    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rTitle[];



        MyAdapter(Context c, String title[]) {
            super(c,R.layout.row,R.id.textView ,title);
            this.context=c;
            this.rTitle=title;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row,parent,false);

            TextView MyTitle =row.findViewById(R.id.textView);

            MyTitle.setText(rTitle[position]);


            return row;
        }
    }

}

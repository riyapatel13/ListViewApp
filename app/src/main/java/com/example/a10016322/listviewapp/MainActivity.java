package com.example.a10016322.listviewapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Players> arr;
    ArrayList<String> names, positions, descriptions;
    ArrayList<Integer> jerseyNums, images;
    TextView pos, num, text2;
    final String POS = "position";
    final String NUM = "num";
    final String ARRPOS = "arrPos";
    int arrPos;
    int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count++;

        listView = (ListView)(findViewById(R.id.listView_id));
        pos = (TextView)(findViewById(R.id.textPos));
        num = (TextView)(findViewById(R.id.textNum));
        text2 = (TextView)(findViewById(R.id.textView2));
        arr = new ArrayList<>();
        names = new ArrayList<>();
        positions = new ArrayList<>();
        descriptions = new ArrayList<>();
        jerseyNums = new ArrayList<>();
        images = new ArrayList<>();

       // if(savedInstanceState==null) {
            arr.add(new Players("Alex Morgan", 13, "forward", R.drawable.amorgs, "Alex Morgan is born on July 2, 1989 and her hometown is in Diamond Bar, California. She plays on the Orlando Pride club team. She currently has 120 caps and 73 goals on the national team."));
        //IMAGE - http://www.espn.com/photo/2015/0601/mag_morgan01_RW_800x450.jpg
        //INFO - http://www.ussoccer.com/players/2014/03/15/02/36/alex-morgan#tab-1
            arr.add(new Players("Christen Press", 23, "forward", R.drawable.cpress, "Christen Press is born on December 29, 1988 and her hometown is in Palos Verdes Estates, California. She plays on the Chicago Red Stars club team. She currently has 80 caps and 41 goals on the national team."));
        //IMAGE - http://s3.amazonaws.com/assets.asn.com/production/attacheds/9110/original/72015_isi_presschristen_USWNTJTTrophy070514129.jpg?1437336013
        //INFO - http://www.ussoccer.com/players/2014/03/15/02/36/christen-press#tab-1
            arr.add(new Players("Tobin Heath", 17, "midfielder", R.drawable.theath, "Tobin Heath is born on May 26, 1988 and her hometown is in Basking Ridge, New Jersey. She plays on the Portland Thorns club team. She currently has 128 caps and 18 goals on the national team."));
        //IMAGE - http://cdn-s3.si.com/s3fs-public/images/tobin-heath-X159570_TK1_0370.jpg
        //INFO - http://www.ussoccer.com/players/2014/03/15/05/06/tobin-heath#tab-1
            arr.add(new Players("Carli Lloyd", 10, "midfielder", R.drawable.clloyd, "Carli Lloyd is born on July 16, 1982 and her hometown is in Delran, New Jersey. She plays on the Houston Dash club team. She currently has 232 caps and 96 goals on the national team."));
        //IMAGE - https://s-media-cache-ak0.pinimg.com/originals/8a/53/aa/8a53aad1e013cb1ad318c75033f2ff20.jpg
        //INFO - http://www.ussoccer.com/players/2014/03/15/05/02/carli-lloyd#tab-1
            arr.add(new Players("Ali Krieger", 11, "defender", R.drawable.akriegs, "Ali Krieger is born on July 28, 1984 and her hometown is in Dumfries, Virginia. She played on the Washington Spirit but got traded to Orlando Pride next season. She currently has 96 caps and 1 goal on the national team."));
        //IMAGE - https://s-media-cache-ak0.pinimg.com/236x/dd/40/f3/dd40f3f0f6d39f43cb5775ee1b8502c6.jpg
        //INFO - http://www.ussoccer.com/players/2014/03/15/05/09/ali-krieger#tab-1
            arr.add(new Players("Becky Sauerbrunn", 4, "defender", R.drawable.beckys, "Becky Sauerbrunn is born on June 6, 1985 and her hometown is in St. Louis, Missouri. She plays on the FC Kansas City club team. She currently has 119 caps and 0 goals on the national team."));
        //IMAGE - http://img.fifa.com/images/fwwc/2015/players/prt-3/212341.png
        //INFO - http://www.ussoccer.com/players/2014/03/15/05/06/becky-sauerbrunn#tab-1
            arr.add(new Players("Ashlyn Harris", 24, "goalie", R.drawable.aharris, "Ashlyn Harris is born on October 19, 1985 and her hometown is in Satellite Beach, Florida. She plays on the Orlando Pride club team. She currently has 11 caps and 0 goals on the national team."));
        //IMAGE - http://static.tumblr.com/74c3d496068d1a7b480033e8f58ec9ed/ycqnpeb/ZNZnz6ufv/tumblr_static_bxot4n4hgkgg8cgo00gksg4ok.jpg
        //INFO - http://www.ussoccer.com/players/2014/03/15/05/09/ashlyn-harris#tab-1

        /*for (int i=0; i<arr.size(); i++)
            {
                names.add(arr.get(i).getName());
                jerseyNums.add(arr.get(i).getJerseyNum());
                positions.add(arr.get(i).getPosition());
                images.add(arr.get(i).getImage());
                descriptions.add(arr.get(i).getDescription());
            }*/
        //}
        if(savedInstanceState != null)
        {
            /*int x = arr.size();
            arr.clear();
            for (int i=0; i<x; i++)
            {
                arr.add(new Players(savedInstanceState.getStringArrayList("NAMES").get(i),savedInstanceState.getIntegerArrayList("JER").get(i),savedInstanceState.getStringArrayList("POSITIONS").get(i),savedInstanceState.getIntegerArrayList("IMAGES").get(i),savedInstanceState.getStringArrayList("DESC").get(i)));
            }*/
            pos.setText(savedInstanceState.getString(POS));
            num.setText(savedInstanceState.getString(NUM));
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                text2.setText(arr.get(savedInstanceState.getInt(ARRPOS)).getDescription());
            }
        }


        CustomAdapter adapter = new CustomAdapter(this, R.layout.listviewlayout, arr);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arrPos = position;
                Log.d("POS", ""+arrPos);
                pos.setText("Position: "+ arr.get(position).getPosition());
                num.setText("Number: "+ arr.get(position).getJerseyNum());
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    text2.setText(arr.get(position).getDescription());
                }
            }
        });

    }

   protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(POS, pos.getText());
        outState.putCharSequence(NUM, num.getText());
        outState.putInt(ARRPOS, arrPos);
        outState.putStringArrayList("NAMES", names);
        outState.putStringArrayList("POSITIONS", positions);
        outState.putStringArrayList("DESC", descriptions);
        outState.putIntegerArrayList("JER", jerseyNums);
        outState.putIntegerArrayList("IMAGES", images);
    }

   // protected void onRestoreInstanceState(Bundle savedInstanceState)
    //{
      //  super.onRestoreInstanceState(savedInstanceState);
    //} button - onclick listener - list.remove((int)button.getTag() - should be in the adapter)

    public class CustomAdapter extends ArrayAdapter {
        ArrayList<Players> list;
        Context mainContext;
        Button button;

        public CustomAdapter(Context context, int resource, ArrayList<Players> players) {
            super(context, resource, players);
            list = players; //this way we can use objects from list in main method
            mainContext = context;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)mainContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //use this b/c setContentView only works in main activity
            //without ContentView, xml file will not show


            View layoutView = inflater.inflate(R.layout.listviewlayout,null);
            button = (Button)layoutView.findViewById(R.id.button_id);
            TextView textView = (TextView)layoutView.findViewById(R.id.textView);
            ImageView imageView = (ImageView)layoutView.findViewById(R.id.imageView);

            textView.setText(list.get(position).getName());
            imageView.setImageResource(list.get(position).getImage());
            button.setTag(position);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    arr.remove((int)(v.getTag()));
                    for(int i=0; i<arr.size(); i++)
                    {
                        names.add(arr.get(i).getName());
                        descriptions.add(arr.get(i).getDescription());
                        positions.add(arr.get(i).getPosition());
                        jerseyNums.add(arr.get(i).getJerseyNum());
                        images.add(arr.get(i).getImage());

                    }
                    notifyDataSetChanged();
                }
            });

            return layoutView;
        }
    }

}

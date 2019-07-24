package com.example.android.miwok;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorWords = new ArrayList<Word>();

        colorWords.add(new Word("red", "crvena", R.drawable.color_red));
        colorWords.add(new Word("brown","smeđa", R.drawable.color_brown));
        colorWords.add(new Word("white", "bijela", R.drawable.color_white));
        colorWords.add(new Word("black", "crna", R.drawable.color_black));
        colorWords.add(new Word("green", "zelena", R.drawable.color_green));

        WordAdapter colorAdapter = new WordAdapter(this, colorWords, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(colorAdapter);
        listView.setBackgroundResource(R.color.tan_background);


        //layout.setBackgroundColor(getResources().getColor(R.color.category_colors));
        //layout.setBackgroundColor(Color.parseColor("#8800A0"));
    }




}

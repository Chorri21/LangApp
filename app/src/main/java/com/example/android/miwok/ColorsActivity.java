package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        WordAdapter colorAdapter = new WordAdapter(this, colorWords);

        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(colorAdapter);


    }




}

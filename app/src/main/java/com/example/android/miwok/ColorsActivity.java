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

        colorWords.add(new Word("red", "crvena"));
        colorWords.add(new Word("blue","plava"));
        colorWords.add(new Word("white", "bijela"));
        colorWords.add(new Word("black", "crna"));
        colorWords.add(new Word("green", "zelena"));

        WordAdapter colorAdapter = new WordAdapter(this, colorWords);

        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(colorAdapter);


    }




}

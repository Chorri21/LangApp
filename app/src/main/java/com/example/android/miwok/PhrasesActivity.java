package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phrasesWords = new ArrayList<Word>();

        phrasesWords.add(new Word("good afternoon", "dobar dan", "Phrases"));
        phrasesWords.add(new Word("good evening", "dobra večer", "Phrases"));
        phrasesWords.add(new Word("can we order?", "možemo li naručiti?", "Phrases"));

        WordAdapter phrasesAdapter = new WordAdapter(this, phrasesWords);

        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(phrasesAdapter);
        listView.setBackgroundResource(R.color.category_phrases);
    }
}

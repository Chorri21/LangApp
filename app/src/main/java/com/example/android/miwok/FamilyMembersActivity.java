package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> familyWords = new ArrayList<Word>();

        familyWords.add(new Word("father", "tata"));
        familyWords.add(new Word("mother", "mama"));
        familyWords.add(new Word("brother", "brat"));
        familyWords.add(new Word("sister", "sestra"));

        WordAdapter familyAdapter = new WordAdapter(this, familyWords);

        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(familyAdapter);
    }
}

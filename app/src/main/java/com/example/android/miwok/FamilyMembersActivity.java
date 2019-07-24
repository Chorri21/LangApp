package com.example.android.miwok;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> familyWords = new ArrayList<Word>();

        familyWords.add(new Word("father", "tata", R.drawable.family_father));
        familyWords.add(new Word("mother", "mama", R.drawable.family_mother));
        familyWords.add(new Word("son", "sin", R.drawable.family_son));
        familyWords.add(new Word("brother", "brat", R.drawable.family_older_brother));
        familyWords.add(new Word("sister", "sestra", R.drawable.family_older_sister));
        familyWords.add(new Word("grandfather", "djed", R.drawable.family_grandfather));
        familyWords.add(new Word("grandmother", "baka", R.drawable.family_grandmother));


        WordAdapter familyAdapter = new WordAdapter(this, familyWords, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(familyAdapter);
        listView.setBackgroundResource(R.color.tan_background);

    }
}

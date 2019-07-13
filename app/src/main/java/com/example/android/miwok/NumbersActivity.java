package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> numberWords = new ArrayList<Word>();


        numberWords.add(new Word("one", "jedan"));
        numberWords.add(new Word("two", "dva"));
        numberWords.add(new Word("three", "tri"));
        numberWords.add(new Word("four", "cetiri"));
        numberWords.add(new Word("five", "pet"));
        numberWords.add(new Word("six", "šest"));
        numberWords.add(new Word("seven", "sedam"));
        numberWords.add(new Word("eight", "osam"));
        numberWords.add(new Word("nine", "devet"));
        numberWords.add(new Word("ten", "deset"));
        numberWords.add(new Word("eleven", "jedanaest"));
        numberWords.add(new Word("twelve", "dvanaest"));
        numberWords.add(new Word("thirteen", "trinaest"));
        numberWords.add(new Word("fourteen", "četrnaest"));
        numberWords.add(new Word("fifteen", "petnaest"));
        numberWords.add(new Word("sixteen", "šesnaest"));
        numberWords.add(new Word("seventeen", "sedamnaest"));
        numberWords.add(new Word("eighteen", "osamnaest"));
        numberWords.add(new Word("nineteen", "devetnaest"));
        numberWords.add(new Word("twenty", "dvadeset"));
        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter numberAdapter = new WordAdapter(this, numberWords);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.word_list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(numberAdapter);
    }
}
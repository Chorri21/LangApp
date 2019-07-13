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

        numberWords.add(new Word("one", "jedan", R.drawable.number_one));
        numberWords.add(new Word("two", "dva", R.drawable.number_two));
        numberWords.add(new Word("three", "tri",R.drawable.number_three));
        numberWords.add(new Word("four", "cetiri", R.drawable.number_four));
        numberWords.add(new Word("five", "pet", R.drawable.number_five));
        numberWords.add(new Word("six", "šest", R.drawable.number_six));
        numberWords.add(new Word("seven", "sedam", R.drawable.number_seven));
        numberWords.add(new Word("eight", "osam", R.drawable.number_eight));
        numberWords.add(new Word("nine", "devet", R.drawable.number_nine));
        numberWords.add(new Word("ten", "deset", R.drawable.number_ten));

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
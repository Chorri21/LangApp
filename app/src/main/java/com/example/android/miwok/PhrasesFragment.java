package com.example.android.miwok;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> phrasesWords = new ArrayList<Word>();

        phrasesWords.add(new Word("good afternoon", "dobar dan"));
        phrasesWords.add(new Word("good evening", "dobra večer"));
        phrasesWords.add(new Word("can we order?", "možemo li naručiti?"));

        WordAdapter phrasesAdapter = new WordAdapter(getActivity(), phrasesWords, R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.word_list);

        listView.setAdapter(phrasesAdapter);
        listView.setBackgroundResource(R.color.category_phrases);

       return rootView;
    }
}

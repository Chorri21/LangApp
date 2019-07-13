package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    // My Code
    public WordAdapter(Activity context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       //return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
    }

    // Get the {@link Word} object located at this position in the list
    Word currentWord = getItem(position);
    // Default translation
    TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

    // set this text on the default translation text view
    defaultTextView.setText(currentWord.getDefaultTranslation());

    // Miwok translation
    TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

    // set this text on the miwok translation text view
    miwokTextView.setText(currentWord.getMiwokTranslation());

    // Adding the image
    ImageView miwokImage = (ImageView) listItemView.findViewById(R.id.image);
    // Set the ImageSource
    miwokImage.setImageResource(currentWord.getImageDrawable());
    // Return the whole list item layout (containing 2 TextViews)
    // so that it can be shown in the ListView
    return listItemView;
}
}


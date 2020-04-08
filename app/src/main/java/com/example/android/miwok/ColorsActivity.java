package com.example.android.miwok;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    // When the user leaves the activity, release the MediaPlayer.
    // Check more on Activity Lifecycle
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colorWords = new ArrayList<Word>();

        colorWords.add(new Word("red", "crvena", R.drawable.color_red, R.raw.color_red));
        colorWords.add(new Word("brown","smeđa", R.drawable.color_brown, R.raw.color_brown));
        colorWords.add(new Word("white", "bijela", R.drawable.color_white, R.raw.color_white));
        colorWords.add(new Word("black", "crna", R.drawable.color_black, R.raw.color_black));
        colorWords.add(new Word("green", "zelena", R.drawable.color_green, R.raw.color_green));

        WordAdapter colorAdapter = new WordAdapter(this, colorWords, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(colorAdapter);
        listView.setBackgroundResource(R.color.tan_background);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word words = colorWords.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, words.getSoundResourceId());
                mMediaPlayer.start();

                // Set an event listener.
                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });

        //layout.setBackgroundColor(getResources().getColor(R.color.category_colors));
        //layout.setBackgroundColor(Color.parseColor("#8800A0"));
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}

package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                // mMediaPlayer.seekTo(0);
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                mMediaPlayer.stop();
                releaseMediaPlayer();
            }
        }
    };

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
        mAudioManager = (AudioManager) getSystemService(FamilyMembersActivity.AUDIO_SERVICE);

        final ArrayList<Word> familyWords = new ArrayList<Word>();

        familyWords.add(new Word("father", "tata", R.drawable.family_father, R.raw.family_father));
        familyWords.add(new Word("mother", "mama", R.drawable.family_mother, R.raw.family_mother));
        familyWords.add(new Word("son", "sin", R.drawable.family_son, R.raw.family_son));
        familyWords.add(new Word("brother", "brat", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyWords.add(new Word("sister", "sestra", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyWords.add(new Word("grandfather", "djed", R.drawable.family_grandfather, R.raw.family_grandfather));
        familyWords.add(new Word("grandmother", "baka", R.drawable.family_grandmother, R.raw.family_grandmother));


        WordAdapter familyAdapter = new WordAdapter(this, familyWords, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(familyAdapter);
        listView.setBackgroundResource(R.color.tan_background);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word words = familyWords.get(position);

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, words.getSoundResourceId());
                    mMediaPlayer.start();

                    // Set an event listener.
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }


            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
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

            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}

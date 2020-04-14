package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {
    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;
    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                mMediaPlayer.stop();
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(NumbersActivity.AUDIO_SERVICE);

        // Create a list of words
        final ArrayList<Word> numberWords = new ArrayList<Word>();

        numberWords.add(new Word("one", "jedan", R.drawable.number_one, R.raw.number_one));
        numberWords.add(new Word("two", "dva", R.drawable.number_two, R.raw.number_two));
        numberWords.add(new Word("three", "tri",R.drawable.number_three, R.raw.number_three));
        numberWords.add(new Word("four", "cetiri",R.drawable.number_four, R.raw.number_four));
        numberWords.add(new Word("five", "pet",R.drawable.number_five, R.raw.ring));
        numberWords.add(new Word("six", "šest",R.drawable.number_six, R.raw.number_six));
        numberWords.add(new Word("seven", "sedam",R.drawable.number_seven, R.raw.number_seven));
        numberWords.add(new Word("eight", "osam",R.drawable.number_eight, R.raw.number_eight));
        numberWords.add(new Word("nine", "devet",R.drawable.number_nine, R.raw.number_nine));
        numberWords.add(new Word("ten", "deset",R.drawable.number_ten, R.raw.number_ten));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        // Use getActivity(), “this” refers to the NumbersFragment (and not the NumbersActivity), and the Fragment is not a valid Context.
        final WordAdapter numberAdapter = new WordAdapter(getActivity(), numberWords, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        final ListView listView = (ListView) rootView.findViewById(R.id.word_list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(numberAdapter);
        // This is for the whole layout background
        listView.setBackgroundResource(R.color.tan_background);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file.
                releaseMediaPlayer();
                // Get the {@link Word} object at the given position the user clicked on
                Word words = numberWords.get(position);

                int result =  mAudioManager.requestAudioFocus(afChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    // “this” refers to the NumbersFragment (and not the NumbersActivity), and the Fragment is not a valid Context.
                    mMediaPlayer = MediaPlayer.create(getActivity(), words.getSoundResourceId());
                    mMediaPlayer.start();
                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
                //LogCat logging example
                //Log.v("NumbersActivity", "Current word: " + words);

            }
        });
        return rootView;
    }
    /**
     * Clean up the media player by releasing its resources.
     * Here we also abandon the AudioFocus Listener
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
            // We have to abandon the Audio Focus Listener after we do not need it
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}

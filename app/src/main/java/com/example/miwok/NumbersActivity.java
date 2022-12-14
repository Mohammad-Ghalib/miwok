package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);



        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("one","Lutti", R.drawable.number_one ,R.raw.number_one));
        words.add(new Words("Two","Otiiko", R.drawable.number_two , R.raw.number_two));
        words.add(new Words("Three","Tolookosu", R.drawable.number_three , R.raw.number_three));
        words.add(new Words("Four","Oyyisa", R.drawable.number_four , R.raw.number_four));
        words.add(new Words("Five","Massokka", R.drawable.number_five , R.raw.number_five));
        words.add(new Words("Six","Temmokka", R.drawable.number_six , R.raw.number_six));
        words.add(new Words("Seven","Kenekaku", R.drawable.number_seven , R.raw.number_seven));
        words.add(new Words("Eight","Kawinta", R.drawable.number_eight , R.raw.number_eight));
        words.add(new Words("Nine","Wo'e", R.drawable.number_nine , R.raw.number_nine));
        words.add(new Words("Ten","Na'aacha", R.drawable.number_ten , R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Words word = words.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);



            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
        }
    }



}
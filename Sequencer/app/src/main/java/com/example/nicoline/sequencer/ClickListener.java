package com.example.nicoline.sequencer;

import android.view.View;
import android.widget.ImageView;

/**
 * Class for handling click events on the start and stop buttons
 * Created by Nicoline on 20-04-2016.
 */
public class ClickListener implements View.OnClickListener {

    //MediaPlayer mp;

    ImageView view;

    public ClickListener(ImageView v) {
        view = v;
        //mp = MediaPlayer.create(this, R.raw.stone);
    }

    @Override
    public void onClick(View v) {
        System.out.println("Clicking");

        //TODO: check if play-button or stop-button

        //TODO: play button pressed:
        /**
         * Make icon invisible (I have put in the code) and stop button visible
         * Play sounds
         * Start sequencer status bar
         */

        //view.setVisibility(View.INVISIBLE); //Remove the image of the button
        //TODO: make stop-button visible

        //TODO: play sounds

        //mp.start();

        //TODO: Start panning the sequencer status bar.
        //When finished two cycles (an orange and white background cycle), move back to start and repeat
    }
}

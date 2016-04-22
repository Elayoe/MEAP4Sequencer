package com.example.nicoline.sequencer;

import android.app.Activity;
import android.media.SoundPool;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

/**
 * Class for handling click events on the start and stop buttons
 * Created by Nicoline on 20-04-2016.
 */
public class ClickListener extends Activity implements View.OnClickListener {

    MainActivity main;
    //Handler h;

    //TODO: set these to x and y values
    int barStartX;
    int barStartY;

    //Play settings
    int priority = 1;
    int no_loop = 0;
    float normal_playback_rate = 1f;

    ImageView view; //The image that has been clicked
    //Start x and y coords of sequencer status bar

    public ClickListener(ImageView v, MainActivity m) {
        view = v;
        main = m;
        //mp = MediaPlayer.create(this, R.raw.stone);
    }

    @Override
    public void onClick(View v) {
        System.out.println("Clicking");

        //TODO: check if play-button or stop-button (use the view variable)

        //--------------------------------------------------------------------

        //TODO: play button pressed:
        /**
         * Make icon invisible (I have put in the code) and stop button visible
         * Play sounds
         * Start sequencer status bar
         */

        //view.setVisibility(View.INVISIBLE); //Remove the image of the button
        //TODO: make stop-button visible

        //TODO: play sounds:
        //Play sequencer
        Runnable r = new Runnable() {
            @Override
            public void run(){
                for(int i = 0; i < main.sequencer.length; i++) {
                    for(int j = 0; j < main.sequencer[0].length; j++) {
                        if(main.sequencer[i][j].isToBePlayed == true) { //If we want to play this trackBlock
                            main.soundPlayer.play(main.musicColumn[i],
                                    main.sequencer[i][j].volume,
                                    main.sequencer[i][j].volume,
                                    priority,
                                    no_loop,
                                    normal_playback_rate);
                        }
                    }
                    //TODO: Wait until next colum should be played
                    //h.postDelayed(this, 1000);
                }
            }
        };
        r.run();
        //h = new Handler();

        /**
         * Old sequencer code:
        for(int i = 0; i < main.sequencer; i++) {
            for(int j = 0; j < main.musicColumn.length; j++)
            System.out.println("Iteration " + i+1 + ". Playing row number " + main.musicColumn[i] + " in current musicColumn");
            if(main.sequencer)
            main.soundPlayer.play(main.musicColumn[i],
                    leftVolume,
                    rightVolume,
                    priority,
                    no_loop,
                    normal_playback_rate);
        }*/

        //MediaPlayer mp = MediaPlayer.create(this, R.raw.stone);
        //mp.start();

        //TODO: Start panning the sequencer status bar.
        //When finished two cycles (an orange and white background cycle), move back to start and repeat

        //---------------------------------------------------------------------

        //TODO: stop button pressed:
        /**
         * Make icon invisible (I have put in the code) and play button visible
         * Stop sounds
         * Stop and reset sequencer status bar
         */

        //view.setVisibility(View.INVISIBLE); //Remove the image of the button
        //TODO: make start-button visible

        //TODO: stop sounds

        //TODO: Stop panning the sequencer status bar and reset it back to its original place
    }
}

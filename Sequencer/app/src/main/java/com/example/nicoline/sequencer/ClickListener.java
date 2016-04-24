package com.example.nicoline.sequencer;

import android.view.View;
import android.widget.ImageView;

/**
 * Class for handling click events on the start and stop buttons
 * Created by Nicoline on 20-04-2016.
 */
public class ClickListener implements View.OnClickListener {

    private MainActivity main;
    //Handler h;

    //TODO: set these to x and y values
    //Start x and y coords of sequencer status bar
    private int barStartX;
    private int barStartY;

    //Play settings
    private int soundPriority = 1;
    private int no_loop = 0;
    private float playback_rate = 1f; //1 is normal playback rate

    private ImageView view; //The image that has been clicked

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
        playSoundsSimultaneously();

        //TODO: Start panning the sequencer status bar.
        //When finished two cycles (an orange and white background cycle), move back to start and repeat
        startStatusBar();

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

    /**
     * Method for playing the sequencer
     */
    void playSoundsSimultaneously(){
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
                                    soundPriority,
                                    no_loop,
                                    playback_rate);
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
         soundPriority,
         no_loop,
         playback_rate);
         }*/

        //MediaPlayer mp = MediaPlayer.create(this, R.raw.stone);
        //mp.start();
    }

    /**
     * Method that starts panning the status bar
     */
    void startStatusBar() {

    }
}

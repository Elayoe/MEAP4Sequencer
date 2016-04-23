package com.example.nicoline.sequencer;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends Activity {

    //TODO: add velocity variables to be referenced from other classes
    ImageView velocityB1;
    public SoundPool soundPlayer;
    public int musicColumn[];

    //Objects to hold sequencer track-block values
    class SequencerTrackBlock{
        boolean isToBePlayed = false;
        int volume = 1;
    }

    //The sequencer which holds all current information of the step sequencer
    SequencerTrackBlock[][] sequencer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("System is creating");

        //TODO: in the scene, add blocks to the block pile to be dragged
        //TODO: Black block image - should be viewed when placed in sequencer

        //TODO: Get references and place listeners on all interactive buttons as well as the movable yellow bar:
            //Play-button (onClick listener)
            //Blocks (top right corner) (on pressing and releasing)
            //On each track block? We should be able to register if we release a block over one

        //TODO: Add click listeners on both play and stop button
        addPlayAndStopListeners();
        //TODO: make the stop button invisible as default/start
        stopB.setInvisibility(4);

        //TODO: Add touch listeners on all blocks to be dragged
        addBlockListeners();

        //TODO: Add onDrag listeners on all trackBlocks to be dropped on
        addTrackBlockListeners();

        //TODO: Add touch listener to make the velocity knobs able to rotate
        addVelocityListeners();

        //Create sequencer variable
        sequencer = new SequencerTrackBlock[4][8];

        //Go through sequencer array and create/insert info objects
        for(int i = 0; i < sequencer.length; i++) {
            for(int j = 0; j < sequencer[0].length; j++) {
                sequencer[i][j] = new SequencerTrackBlock(); //Has standard values
            }
        }

        createSoundPool();
    }

    void createSoundPool() {
        System.out.println("Creating sound pool and loading in sounds");

        //SoundPool tutorial: http://www.101apps.co.za/index.php/articles/using-android-s-soundpool-class-a-tutorial.html
        soundPlayer = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        //This SoundPool constructor is deprecated from API 21 and forward (we use 15).
        //See here for newer version if we change API: http://stackoverflow.com/questions/17069955/play-sound-using-soundpool-example

        //Wait for the pool to load in the sound files
        soundPlayer.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                Log.i("OnLoadCompleteListener","Sound "+sampleId+" is being loaded.");

                if(status == 0) {
                    Log.i("OnLoadCompleteListener","Sound "+sampleId+" loaded successfully.");
                    System.out.println("SoundId number " + sampleId + ": " + musicColumn[sampleId-1]);
                }
            }
        });

        //Load in sound files
        musicColumn = new int[4];
        musicColumn[0] = soundPlayer.load(getApplicationContext(), R.raw.snare, 1);
        musicColumn[1] = soundPlayer.load(getApplicationContext(), R.raw.cl_hihat, 1);
        musicColumn[2] = soundPlayer.load(getApplicationContext(), R.raw.kick2, 1);
        musicColumn[3] = soundPlayer.load(getApplicationContext(), R.raw.open_hh, 1);
    }

    /**
     * Method for adding (which? touch and drag?) listeners
     */
    void addVelocityListeners() {
        velocityB1 = (ImageView) findViewById(R.id.velocitybutton1);
        velocityB1.setOnTouchListener(new TouchListenerVelocity());
    }

    /**
     * Method for adding click listeners to the play and stop button
     */
    void addPlayAndStopListeners() {
        //Example of listener for clicking the play button
        ImageView playB = (ImageView) findViewById(R.id.playbutton);
        playB.setOnClickListener(new ClickListener(playB, MainActivity.this));
    }

    /**
     * Method for adding touch listeners to all draggable blocks
     */
    void addBlockListeners() {
        //tutorial on drag and drop: http://code.tutsplus.com/tutorials/android-sdk-implementing-drag-and-drop-functionality--mobile-14402
        //For now this is the whole blockpile icon we are dragging - just to show how.
        //This method should probably be put on all blocks that are able to be dragged
        ImageView blockpile = (ImageView) findViewById(R.id.blockpile);
        blockpile.setOnTouchListener(new TouchListenerBlocks(blockpile));
    }

    /**
     * Method for adding drag listeners to all track blocks for registering whenever a block is
     * released over a track block
     */
    void addTrackBlockListeners() {
        //tutorial on drag and drop: http://code.tutsplus.com/tutorials/android-sdk-implementing-drag-and-drop-functionality--mobile-14402
        ImageView trackBlock00 = (ImageView) findViewById(R.id.trackblock00);
        trackBlock00.setOnDragListener(new DragListener());
    }

    // http://www.tutorialspoint.com/android/android_drag_and_drop.htm

}

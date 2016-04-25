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
    ImageView block1, block2, block3, block4, block5, block6, block7, block8, block9, block10, block11, block12, block13, block14, block15, block16, block17, block18, block19, block20;

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

        //TODO: insert correct music files
        //Load in sound files
        musicColumn = new int[4];
        musicColumn[0] = soundPlayer.load(getApplicationContext(), R.raw.plop, 1);
        musicColumn[1] = soundPlayer.load(getApplicationContext(), R.raw.stone, 1);
        musicColumn[2] = soundPlayer.load(getApplicationContext(), R.raw.plop, 1);
        musicColumn[3] = soundPlayer.load(getApplicationContext(), R.raw.stone, 1);
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
        //ImageView blockpile = (ImageView) findViewById(R.id.blockpile);
        //blockpile.setOnTouchListener(new TouchListenerBlocks(blockpile));

        ImageView block1 = (ImageView) findViewById(R.id.block1);
        block1.setOnTouchListener(new TouchListenerBlocks(block1));
        /**
        block2.setOnTouchListener(new TouchListenerBlocks(block2));
        block3.setOnTouchListener(new TouchListenerBlocks(block3));
        block4.setOnTouchListener(new TouchListenerBlocks(block4));
        block5.setOnTouchListener(new TouchListenerBlocks(block5));
        block6.setOnTouchListener(new TouchListenerBlocks(block6));
        block7.setOnTouchListener(new TouchListenerBlocks(block7));
        block8.setOnTouchListener(new TouchListenerBlocks(block8));
        block9.setOnTouchListener(new TouchListenerBlocks(block9));
        block10.setOnTouchListener(new TouchListenerBlocks(block10));
        block11.setOnTouchListener(new TouchListenerBlocks(block11));
        block12.setOnTouchListener(new TouchListenerBlocks(block12));
        block13.setOnTouchListener(new TouchListenerBlocks(block13));
        block14.setOnTouchListener(new TouchListenerBlocks(block14));
        block15.setOnTouchListener(new TouchListenerBlocks(block15));
        block16.setOnTouchListener(new TouchListenerBlocks(block16));
        block17.setOnTouchListener(new TouchListenerBlocks(block17));
        block18.setOnTouchListener(new TouchListenerBlocks(block18));
        block19.setOnTouchListener(new TouchListenerBlocks(block19));*/
        ImageView block20 = (ImageView) findViewById(R.id.block20);
        block20.setOnTouchListener(new TouchListenerBlocks(block20));
    }

    /**
     * Method for adding drag listeners to all track blocks for registering whenever a block is
     * released over a track block
     */
    void addTrackBlockListeners() {
        //tutorial on drag and drop: http://code.tutsplus.com/tutorials/android-sdk-implementing-drag-and-drop-functionality--mobile-14402
        //TODO: Layouts overshadowing?
        //Row 1
        ImageView trackBlock00 = (ImageView) findViewById(R.id.trackblock00);
        trackBlock00.setOnDragListener(new DragListener());
        ImageView trackBlock10 = (ImageView) findViewById(R.id.trackblock10);
        trackBlock10.setOnDragListener(new DragListener());
        ImageView trackBlock20 = (ImageView) findViewById(R.id.trackblock20);
        trackBlock20.setOnDragListener(new DragListener());
        ImageView trackBlock30 = (ImageView) findViewById(R.id.trackblock30);
        trackBlock30.setOnDragListener(new DragListener());
        ImageView trackBlock40 = (ImageView) findViewById(R.id.trackblock40);
        trackBlock40.setOnDragListener(new DragListener());
        ImageView trackBlock50 = (ImageView) findViewById(R.id.trackblock50);
        trackBlock50.setOnDragListener(new DragListener());
        ImageView trackBlock60 = (ImageView) findViewById(R.id.trackblock60);
        trackBlock60.setOnDragListener(new DragListener());
        ImageView trackBlock70 = (ImageView) findViewById(R.id.trackblock70);
        trackBlock70.setOnDragListener(new DragListener());

/**
        //Row 2
        ImageView trackBlock01 = (ImageView) findViewById(R.id.trackblock01);
        trackBlock01.setOnDragListener(new DragListener());
        ImageView trackBlock11 = (ImageView) findViewById(R.id.trackblock11);
        trackBlock11.setOnDragListener(new DragListener());
        ImageView trackBlock21 = (ImageView) findViewById(R.id.trackblock21);
        trackBlock21.setOnDragListener(new DragListener());
        ImageView trackBlock31 = (ImageView) findViewById(R.id.trackblock31);
        trackBlock31.setOnDragListener(new DragListener());
        ImageView trackBlock41 = (ImageView) findViewById(R.id.trackblock41);
        trackBlock41.setOnDragListener(new DragListener());
        ImageView trackBlock51 = (ImageView) findViewById(R.id.trackblock51);
        trackBlock51.setOnDragListener(new DragListener());
        ImageView trackBlock61 = (ImageView) findViewById(R.id.trackblock61);
        trackBlock61.setOnDragListener(new DragListener());
        ImageView trackBlock71 = (ImageView) findViewById(R.id.trackblock71);
        trackBlock71.setOnDragListener(new DragListener());

        //Row 3
        ImageView trackBlock02 = (ImageView) findViewById(R.id.trackblock02);
        trackBlock02.setOnDragListener(new DragListener());
        ImageView trackBlock12 = (ImageView) findViewById(R.id.trackblock12);
        trackBlock12.setOnDragListener(new DragListener());
        ImageView trackBlock22 = (ImageView) findViewById(R.id.trackblock22);
        trackBlock22.setOnDragListener(new DragListener());
        ImageView trackBlock32 = (ImageView) findViewById(R.id.trackblock32);
        trackBlock32.setOnDragListener(new DragListener());
        ImageView trackBlock42 = (ImageView) findViewById(R.id.trackblock42);
        trackBlock42.setOnDragListener(new DragListener());
        ImageView trackBlock52 = (ImageView) findViewById(R.id.trackblock52);
        trackBlock52.setOnDragListener(new DragListener());
        ImageView trackBlock62 = (ImageView) findViewById(R.id.trackblock62);
        trackBlock62.setOnDragListener(new DragListener());
        ImageView trackBlock72 = (ImageView) findViewById(R.id.trackblock72);
        trackBlock72.setOnDragListener(new DragListener());

        //Row 4
        ImageView trackBlock03 = (ImageView) findViewById(R.id.trackblock03);
        trackBlock03.setOnDragListener(new DragListener());
        ImageView trackBlock13 = (ImageView) findViewById(R.id.trackblock13);
        trackBlock13.setOnDragListener(new DragListener());
        ImageView trackBlock23 = (ImageView) findViewById(R.id.trackblock23);
        trackBlock23.setOnDragListener(new DragListener());
        ImageView trackBlock33 = (ImageView) findViewById(R.id.trackblock33);
        trackBlock33.setOnDragListener(new DragListener());
        ImageView trackBlock43 = (ImageView) findViewById(R.id.trackblock43);
        trackBlock43.setOnDragListener(new DragListener());
        ImageView trackBlock53 = (ImageView) findViewById(R.id.trackblock53);
        trackBlock53.setOnDragListener(new DragListener());
        ImageView trackBlock63 = (ImageView) findViewById(R.id.trackblock63);
        trackBlock63.setOnDragListener(new DragListener());
        ImageView trackBlock73 = (ImageView) findViewById(R.id.trackblock73);
        trackBlock73.setOnDragListener(new DragListener());*/
    }

    // http://www.tutorialspoint.com/android/android_drag_and_drop.htm

}

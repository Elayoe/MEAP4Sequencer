package com.example.nicoline.sequencer;

import android.app.Activity;
import android.media.AudioManager;
import android.media.Image;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    //TODO: add velocity variables to be referenced from other classes
    ImageView velocityB1;
    public SoundPool soundPlayer;
    public int musicColumn[];
    ImageView block1, block2, block3, block4, block5, block6, block7, block8, block9, block10,
            block11, block12, block13, block14, block15, block16, block17, block18, block19, block20;
    TouchListenerBlocks block1Listener, block2Listener, block3Listener, block4Listener, block5Listener
            , block6Listener, block7Listener, block8Listener, block9Listener, block10Listener
            , block11Listener, block12Listener, block13Listener, block14Listener, block15Listener
            , block16Listener, block17Listener, block18Listener, block19Listener, block20Listener;

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
        sequencer = new SequencerTrackBlock[8][4];

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

        block1 = (ImageView) findViewById(R.id.block1);
        block1Listener = new TouchListenerBlocks(block1, MainActivity.this);
        block1.setOnTouchListener(block1Listener);

        block2 = (ImageView) findViewById(R.id.block2);
        block2Listener = new TouchListenerBlocks(block2, MainActivity.this);
        block2.setOnTouchListener(block2Listener);

        block3 = (ImageView) findViewById(R.id.block3);
        block3Listener = new TouchListenerBlocks(block3, MainActivity.this);
        block3.setOnTouchListener(block3Listener);

        block4 = (ImageView) findViewById(R.id.block4);
        block4Listener = new TouchListenerBlocks(block4, MainActivity.this);
        block4.setOnTouchListener(block4Listener);

        block5 = (ImageView) findViewById(R.id.block5);
        block5Listener = new TouchListenerBlocks(block5, MainActivity.this);
        block5.setOnTouchListener(block5Listener);

        block6 = (ImageView) findViewById(R.id.block6);
        block6Listener = new TouchListenerBlocks(block6, MainActivity.this);
        block6.setOnTouchListener(block6Listener);

        block7 = (ImageView) findViewById(R.id.block7);
        block7Listener = new TouchListenerBlocks(block7, MainActivity.this);
        block7.setOnTouchListener(block7Listener);

        block8 = (ImageView) findViewById(R.id.block8);
        block8Listener = new TouchListenerBlocks(block8, MainActivity.this);
        block8.setOnTouchListener(block8Listener);

        block9 = (ImageView) findViewById(R.id.block9);
        block9Listener = new TouchListenerBlocks(block9, MainActivity.this);
        block9.setOnTouchListener(block9Listener);

        block10 = (ImageView) findViewById(R.id.block10);
        block10Listener = new TouchListenerBlocks(block10, MainActivity.this);
        block10.setOnTouchListener(block10Listener);

        block11 = (ImageView) findViewById(R.id.block11);
        block11Listener = new TouchListenerBlocks(block11, MainActivity.this);
        block11.setOnTouchListener(block11Listener);

        block12 = (ImageView) findViewById(R.id.block12);
        block12Listener = new TouchListenerBlocks(block12, MainActivity.this);
        block12.setOnTouchListener(block12Listener);

        block13 = (ImageView) findViewById(R.id.block13);
        block13Listener = new TouchListenerBlocks(block13, MainActivity.this);
        block13.setOnTouchListener(block13Listener);

        block14 = (ImageView) findViewById(R.id.block14);
        block14Listener = new TouchListenerBlocks(block14, MainActivity.this);
        block14.setOnTouchListener(block14Listener);

        block15 = (ImageView) findViewById(R.id.block15);
        block15Listener = new TouchListenerBlocks(block15, MainActivity.this);
        block15.setOnTouchListener(block15Listener);

        block16 = (ImageView) findViewById(R.id.block16);
        block16Listener = new TouchListenerBlocks(block16, MainActivity.this);
        block16.setOnTouchListener(block16Listener);

        block17 = (ImageView) findViewById(R.id.block17);
        block17Listener = new TouchListenerBlocks(block17, MainActivity.this);
        block17.setOnTouchListener(block17Listener);

        block18 = (ImageView) findViewById(R.id.block18);
        block18Listener = new TouchListenerBlocks(block18, MainActivity.this);
        block18.setOnTouchListener(block18Listener);

        block19 = (ImageView) findViewById(R.id.block19);
        block19Listener = new TouchListenerBlocks(block19, MainActivity.this);
        block19.setOnTouchListener(block19Listener);

        block20 = (ImageView) findViewById(R.id.block20);
        block20Listener = new TouchListenerBlocks(block20, MainActivity.this);
        block20.setOnTouchListener(block20Listener);
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
        trackBlock00.setOnDragListener(new DragListener(MainActivity.this, 0, 0));
        ImageView trackBlock10 = (ImageView) findViewById(R.id.trackblock10);
        trackBlock10.setOnDragListener(new DragListener(MainActivity.this, 1, 0));
        ImageView trackBlock20 = (ImageView) findViewById(R.id.trackblock20);
        trackBlock20.setOnDragListener(new DragListener(MainActivity.this, 2, 0));
        ImageView trackBlock30 = (ImageView) findViewById(R.id.trackblock30);
        trackBlock30.setOnDragListener(new DragListener(MainActivity.this, 3, 0));
        ImageView trackBlock40 = (ImageView) findViewById(R.id.trackblock40);
        trackBlock40.setOnDragListener(new DragListener(MainActivity.this, 4, 0));
        ImageView trackBlock50 = (ImageView) findViewById(R.id.trackblock50);
        trackBlock50.setOnDragListener(new DragListener(MainActivity.this, 5, 0));
        ImageView trackBlock60 = (ImageView) findViewById(R.id.trackblock60);
        trackBlock60.setOnDragListener(new DragListener(MainActivity.this, 6, 0));
        ImageView trackBlock70 = (ImageView) findViewById(R.id.trackblock70);
        trackBlock70.setOnDragListener(new DragListener(MainActivity.this, 7, 0));

        //Row 2
        ImageView trackBlock01 = (ImageView) findViewById(R.id.trackblock01);
        trackBlock01.setOnDragListener(new DragListener(MainActivity.this, 0, 1));
        ImageView trackBlock11 = (ImageView) findViewById(R.id.trackblock11);
        trackBlock11.setOnDragListener(new DragListener(MainActivity.this, 1, 1));
        ImageView trackBlock21 = (ImageView) findViewById(R.id.trackblock21);
        trackBlock21.setOnDragListener(new DragListener(MainActivity.this, 2, 1));
        ImageView trackBlock31 = (ImageView) findViewById(R.id.trackblock31);
        trackBlock31.setOnDragListener(new DragListener(MainActivity.this, 3, 1));
        ImageView trackBlock41 = (ImageView) findViewById(R.id.trackblock41);
        trackBlock41.setOnDragListener(new DragListener(MainActivity.this, 4, 1));
        ImageView trackBlock51 = (ImageView) findViewById(R.id.trackblock51);
        trackBlock51.setOnDragListener(new DragListener(MainActivity.this, 5, 1));
        ImageView trackBlock61 = (ImageView) findViewById(R.id.trackblock61);
        trackBlock61.setOnDragListener(new DragListener(MainActivity.this, 6, 1));
        ImageView trackBlock71 = (ImageView) findViewById(R.id.trackblock71);
        trackBlock71.setOnDragListener(new DragListener(MainActivity.this, 7, 1));

        //Row 3
        ImageView trackBlock02 = (ImageView) findViewById(R.id.trackblock02);
        trackBlock02.setOnDragListener(new DragListener(MainActivity.this, 0, 2));
        ImageView trackBlock12 = (ImageView) findViewById(R.id.trackblock12);
        trackBlock12.setOnDragListener(new DragListener(MainActivity.this, 1, 2));
        ImageView trackBlock22 = (ImageView) findViewById(R.id.trackblock22);
        trackBlock22.setOnDragListener(new DragListener(MainActivity.this, 2, 2));
        ImageView trackBlock32 = (ImageView) findViewById(R.id.trackblock32);
        trackBlock32.setOnDragListener(new DragListener(MainActivity.this, 3, 2));
        ImageView trackBlock42 = (ImageView) findViewById(R.id.trackblock42);
        trackBlock42.setOnDragListener(new DragListener(MainActivity.this, 4, 2));
        ImageView trackBlock52 = (ImageView) findViewById(R.id.trackblock52);
        trackBlock52.setOnDragListener(new DragListener(MainActivity.this, 5, 2));
        ImageView trackBlock62 = (ImageView) findViewById(R.id.trackblock62);
        trackBlock62.setOnDragListener(new DragListener(MainActivity.this, 6, 2));
        ImageView trackBlock72 = (ImageView) findViewById(R.id.trackblock72);
        trackBlock72.setOnDragListener(new DragListener(MainActivity.this, 7, 2));

        //Row 4
        ImageView trackBlock03 = (ImageView) findViewById(R.id.trackblock03);
        trackBlock03.setOnDragListener(new DragListener(MainActivity.this, 0, 3));
        ImageView trackBlock13 = (ImageView) findViewById(R.id.trackblock13);
        trackBlock13.setOnDragListener(new DragListener(MainActivity.this, 1, 3));
        ImageView trackBlock23 = (ImageView) findViewById(R.id.trackblock23);
        trackBlock23.setOnDragListener(new DragListener(MainActivity.this, 2, 3));
        ImageView trackBlock33 = (ImageView) findViewById(R.id.trackblock33);
        trackBlock33.setOnDragListener(new DragListener(MainActivity.this, 3, 3));
        ImageView trackBlock43 = (ImageView) findViewById(R.id.trackblock43);
        trackBlock43.setOnDragListener(new DragListener(MainActivity.this, 4, 3));
        ImageView trackBlock53 = (ImageView) findViewById(R.id.trackblock53);
        trackBlock53.setOnDragListener(new DragListener(MainActivity.this, 5, 3));
        ImageView trackBlock63 = (ImageView) findViewById(R.id.trackblock63);
        trackBlock63.setOnDragListener(new DragListener(MainActivity.this, 6, 3));
        ImageView trackBlock73 = (ImageView) findViewById(R.id.trackblock73);
        trackBlock73.setOnDragListener(new DragListener(MainActivity.this, 7, 3));
    }

    public void notifyBlock(int imageView, int x, int y){
        //System.out.println("Trackblock " + x + "," + y + " is notifying block " + imageView + ". Block 1 id: " + block1.getId());
        if(imageView == block1.getId()) {
            block1Listener.setTrackBlockX(x);
            block1Listener.setTrackBlockY(y);
            block1Listener.isOnTrackBlock = true;
            System.out.println("Block 1 has been notified about trackblock placement. Block onTrackBlockX " + block1Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block1Listener.onTrackBlockY);
        } else if(imageView == block2.getId()) {
            block2Listener.setTrackBlockX(x);
            block2Listener.setTrackBlockY(y);
            block2Listener.isOnTrackBlock = true;
            System.out.println("Block 2 has been notified about trackblock placement. Block onTrackBlockX " + block2Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block2Listener.onTrackBlockY);
        } else if(imageView == block3.getId()) {
            block3Listener.setTrackBlockX(x);
            block3Listener.setTrackBlockY(y);
            block3Listener.isOnTrackBlock = true;
            System.out.println("Block 3 has been notified about trackblock placement. Block onTrackBlockX " + block3Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block3Listener.onTrackBlockY);
        } else if(imageView == block4.getId()) {
            block4Listener.setTrackBlockX(x);
            block4Listener.setTrackBlockY(y);
            block4Listener.isOnTrackBlock = true;
            System.out.println("Block 4 has been notified about trackblock placement. Block onTrackBlockX " + block4Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block4Listener.onTrackBlockY);
        } else if(imageView == block5.getId()) {
            block5Listener.setTrackBlockX(x);
            block5Listener.setTrackBlockY(y);
            block5Listener.isOnTrackBlock = true;
            System.out.println("Block 5 has been notified about trackblock placement. Block onTrackBlockX " + block5Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block5Listener.onTrackBlockY);
        } else if(imageView == block6.getId()) {
            block6Listener.setTrackBlockX(x);
            block6Listener.setTrackBlockY(y);
            block6Listener.isOnTrackBlock = true;
            System.out.println("Block 6 has been notified about trackblock placement. Block onTrackBlockX " + block6Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block6Listener.onTrackBlockY);
        } else if(imageView == block7.getId()) {
            block7Listener.setTrackBlockX(x);
            block7Listener.setTrackBlockY(y);
            block7Listener.isOnTrackBlock = true;
            System.out.println("Block 7 has been notified about trackblock placement. Block onTrackBlockX " + block7Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block7Listener.onTrackBlockY);
        } else if(imageView == block8.getId()) {
            block8Listener.setTrackBlockX(x);
            block8Listener.setTrackBlockY(y);
            block8Listener.isOnTrackBlock = true;
            System.out.println("Block 8 has been notified about trackblock placement. Block onTrackBlockX " + block8Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block8Listener.onTrackBlockY);
        } else if(imageView == block9.getId()) {
            block9Listener.setTrackBlockX(x);
            block9Listener.setTrackBlockY(y);
            block9Listener.isOnTrackBlock = true;
            System.out.println("Block 9 has been notified about trackblock placement. Block onTrackBlockX " + block9Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block9Listener.onTrackBlockY);
        } else if(imageView == block10.getId()) {
            block10Listener.setTrackBlockX(x);
            block10Listener.setTrackBlockY(y);
            block10Listener.isOnTrackBlock = true;
            System.out.println("Block 10 has been notified about trackblock placement. Block onTrackBlockX " + block10Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block10Listener.onTrackBlockY);
        } else if(imageView == block11.getId()) {
            block11Listener.setTrackBlockX(x);
            block11Listener.setTrackBlockY(y);
            block11Listener.isOnTrackBlock = true;
            System.out.println("Block 11 has been notified about trackblock placement. Block onTrackBlockX " + block11Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block11Listener.onTrackBlockY);
        } else if(imageView == block12.getId()) {
            block12Listener.setTrackBlockX(x);
            block12Listener.setTrackBlockY(y);
            block12Listener.isOnTrackBlock = true;
            System.out.println("Block 12 has been notified about trackblock placement. Block onTrackBlockX " + block12Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block12Listener.onTrackBlockY);
        } else if(imageView == block13.getId()) {
            block13Listener.setTrackBlockX(x);
            block13Listener.setTrackBlockY(y);
            block13Listener.isOnTrackBlock = true;
            System.out.println("Block 13 has been notified about trackblock placement. Block onTrackBlockX " + block13Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block13Listener.onTrackBlockY);
        } else if(imageView == block14.getId()) {
            block14Listener.setTrackBlockX(x);
            block14Listener.setTrackBlockY(y);
            block14Listener.isOnTrackBlock = true;
            System.out.println("Block 14 has been notified about trackblock placement. Block onTrackBlockX " + block14Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block14Listener.onTrackBlockY);
        } else if(imageView == block15.getId()) {
            block15Listener.setTrackBlockX(x);
            block15Listener.setTrackBlockY(y);
            block15Listener.isOnTrackBlock = true;
            System.out.println("Block 15 has been notified about trackblock placement. Block onTrackBlockX " + block15Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block15Listener.onTrackBlockY);
        } else if(imageView == block16.getId()) {
            block16Listener.setTrackBlockX(x);
            block16Listener.setTrackBlockY(y);
            block16Listener.isOnTrackBlock = true;
            System.out.println("Block 16 has been notified about trackblock placement. Block onTrackBlockX " + block16Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block16Listener.onTrackBlockY);
        } else if(imageView == block17.getId()) {
            block17Listener.setTrackBlockX(x);
            block17Listener.setTrackBlockY(y);
            block17Listener.isOnTrackBlock = true;
            System.out.println("Block 17 has been notified about trackblock placement. Block onTrackBlockX " + block17Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block17Listener.onTrackBlockY);
        } else if(imageView == block18.getId()) {
            block18Listener.setTrackBlockX(x);
            block18Listener.setTrackBlockY(y);
            block18Listener.isOnTrackBlock = true;
            System.out.println("Block 18 has been notified about trackblock placement. Block onTrackBlockX " + block18Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block18Listener.onTrackBlockY);
        } else if(imageView == block19.getId()) {
            block19Listener.setTrackBlockX(x);
            block19Listener.setTrackBlockY(y);
            block19Listener.isOnTrackBlock = true;
            System.out.println("Block 19 has been notified about trackblock placement. Block onTrackBlockX " + block19Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block19Listener.onTrackBlockY);
        } else if(imageView == block20.getId()) {
            block20Listener.setTrackBlockX(x);
            block20Listener.setTrackBlockY(y);
            block20Listener.isOnTrackBlock = true;
            System.out.println("Block 20 has been notified about trackblock placement. Block onTrackBlockX " + block20Listener.onTrackBlockX
                    + ", onTrackBlockY: " + block20Listener.onTrackBlockY);
        }
    }

    // http://www.tutorialspoint.com/android/android_drag_and_drop.htm

}

package com.example.nicoline.sequencer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    //TODO: store volume knobs here, så vi kan reference dem senere

    //Objects to hold sequencer track-block values
    class SequencerTrackBlock{
        boolean isToBePlayed = false;
        int volume; //TODO: set this volume to a default volume
    }

    //The sequencer which holds all current information of the step sequencer
    SequencerTrackBlock[][] sequencer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("System is creating");

        //TODO: in the scene, add blocks to the block pile to be dragged
        //TODO: Add black block images to the drawable folder - these should be viewed when placed in sequencer

        //TODO: Get references and place listeners on all interactive buttons as well as the movable yellow bar:
            //Play-button (onClick listener)
            //Blocks (top right corner) (on pressing and releasing)
            //On each track block? We should be able to register if we release a block over one

        //TODO: Add click listeners on both play and stop button
        addPlayAndStopListeners();

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
    }

    /**
     * Method for adding (which? touch and drag?) listeners
     */
    void addVelocityListeners() {
        ImageView velocityB1 = (ImageView) findViewById(R.id.velocitybutton1);
        velocityB1.setOnTouchListener(new TouchListenerVelocity(velocityB1));
    }

    /**
     * Method for adding click listeners to the play and stop button
     */
    void addPlayAndStopListeners() {
        //Example of listener for clicking the play button
        ImageView playB = (ImageView) findViewById(R.id.playbutton);
        playB.setOnClickListener(new ClickListener(playB));
    }

    /**
     * Method for adding touch listeners to all draggable blocks
     */
    void addBlockListeners() {
        //tutorial on drag and drop: http://code.tutsplus.com/tutorials/android-sdk-implementing-drag-and-drop-functionality--mobile-14402
        //For now this is the whole blockpile icon we are dragging - just to show how.
        //This method should probably be put on all blocks that are able to be dragged
        ImageView blockpile = (ImageView) findViewById(R.id.blockpile);
        blockpile.setOnTouchListener(new TouchListener(blockpile));
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

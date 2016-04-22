package com.example.nicoline.sequencer;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Class for handling drag events on velocity knob objects to be turned
 * Created by Nicoline on 20-04-2016.
 */
public class TouchListenerVelocity implements View.OnTouchListener {

    ImageView view;

    public TouchListenerVelocity(ImageView v) {
        view = v;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        System.out.println("Dragging knob");
        //TODO: Here the mouse position can be updated continously
        //TODO: Snap the button to the closest of four positions (calculate distance between the four points)

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //setup drag
            System.out.println("Start dragging knob");

            //TODO: when one step is chosen, adjust all sequencer trackBlocks in that column

            return true;
        }
        else {
            return false;
        }
    }
}

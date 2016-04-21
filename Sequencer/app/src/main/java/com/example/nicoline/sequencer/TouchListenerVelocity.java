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
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //setup drag
            System.out.println("Dragging knob");

            //TODO: rotate the knob in the direction of the mouse while holding down
            //TODO: keep updating for the touch position and update the knob

            return true;
        }
        else {
            return false;
        }
    }
}

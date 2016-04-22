package com.example.nicoline.sequencer;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

/**
 * Class for handling drag events on velocity knob objects to be turned
 * Created by Nicoline on 20-04-2016.
 */
public class TouchListenerVelocity implements View.OnTouchListener {

    //ImageView view;
    float mPreviousX;
    float mPreviousY;

    /**
    public TouchListenerVelocity(ImageView v) {
        view = v;
    }*/

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        float x = event.getX();
        float y = event.getY();


        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:

                //TODO: should we use this outcommented code? Else delete
                /**
                float dx = x - mPreviousX;
                float dy = y - mPreviousY;

                // reverse direction of rotation above the mid-line
                if (y > view.getHeight() / 2) {
                    dx = dx * -1 ;
                }

                // reverse direction of rotation to left of the mid-line
                if (x < view.getWidth() / 2) {
                    dy = dy * -1 ;
                }*/

                int imageCenterX = view.getLeft() + (view.getWidth()/2);
                int imageCenterY = view.getTop() + (view.getHeight()/2);

                //TODO: these are checks for whether the mouse is above to the left or right
                //TODO: - we should check whether it is in one of top four triangles
                if(x < imageCenterX && y < imageCenterY) { //Mouse in top left corner

                }
                else if (x < imageCenterX && y > imageCenterY) { //Mouse in top right corner

                }

                view.setRotation((float)Math.PI*2); //Right position
                view.setRotation((float)Math.PI); //Left position
                view.setRotation((float)Math.PI/4); //Top right
                view.setRotation((float)Math.PI*(3/4)); //Top left

                break;
        }

        //TODO: old code. Use this?
        mPreviousX = x;
        mPreviousY = y;

        //TODO: Here the mouse position can be updated continously
        //TODO: Snap the button to the closest of four positions (calculate distance between the four points)

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //setup drag
            System.out.println("Start dragging knob");

            //TODO: when one step is chosen, adjust all sequencer trackBlocks in that musicColumn

            return true;
        }
        else {
            return false;
        }
    }
}

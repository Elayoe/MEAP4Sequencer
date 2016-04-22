package com.example.nicoline.sequencer;

import android.content.ClipData;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Class for handling drag events on block objects to be dragged
 * Created by Nicoline on 20-04-2016.
 */
public class TouchListenerBlocks implements View.OnTouchListener {

    ImageView view;

    public TouchListenerBlocks(ImageView v) {
        view = v;
    }

    //Standard method. Follow this guide: http://code.tutsplus.com/tutorials/android-sdk-implementing-drag-and-drop-functionality--mobile-14402
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //setup drag
            System.out.println("Dragging");

            //view.setVisibility(View.INVISIBLE); //Remove the image of the block

            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            //start dragging the item touched
            view.startDrag(data, shadowBuilder, view, 0);

            return true;
        }
        else {
            return false;
        }
    }
}

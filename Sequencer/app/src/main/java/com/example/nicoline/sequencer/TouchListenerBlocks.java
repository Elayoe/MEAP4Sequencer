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
    ImageView block1, block2, block3, block4, block5, block6, block7, block8, block9, block10, block11, block12, block13, block14, block15, block16, block17, block18, block19, block20;

    public TouchListenerBlocks(ImageView v) {
        view = v;
        block1.setOnTouchListener(new TouchListenerBlocks(block1));
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
        block19.setOnTouchListener(new TouchListenerBlocks(block19));
        block20.setOnTouchListener(new TouchListenerBlocks(block20));
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

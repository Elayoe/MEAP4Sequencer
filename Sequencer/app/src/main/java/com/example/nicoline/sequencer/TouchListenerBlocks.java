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
    int onTrackBlockX;
    int onTrackBlockY;
    public boolean isOnTrackBlock = false; //Whether the block is placed on a trackblock
    private MainActivity main;

    public TouchListenerBlocks(ImageView v, MainActivity ma) {
        view = v;
        main = ma;
    }

    //Standard method. Follow this guide: http://code.tutsplus.com/tutorials/android-sdk-implementing-drag-and-drop-functionality--mobile-14402
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        /**
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            System.out.println("Down");

            //setup drag
            System.out.println("Dragging");

            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            //start dragging the item touched
            view.startDrag(data, shadowBuilder, view, 0);

            //stop displaying the view where it was before it was dragged
            view.setVisibility(View.INVISIBLE);

            //Whenever lifted, not placed on trackBlock
            isOnTrackBlock = false;
            main.sequencer[onTrackBlockX][onTrackBlockY].isToBePlayed = false;
            System.out.println("TouchListener: Sequencer " + onTrackBlockX + "," + onTrackBlockY + " is " + main.sequencer[onTrackBlockX][onTrackBlockY].isToBePlayed);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            System.out.println("Up");
            view.setVisibility(View.VISIBLE);
        }*/

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                //setup drag
                System.out.println("Dragging");

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);

                //stop displaying the view where it was before it was dragged
                view.setVisibility(View.INVISIBLE);

                //Whenever lifted, not placed on trackBlock
                isOnTrackBlock = false;
                main.sequencer[onTrackBlockX][onTrackBlockY].isToBePlayed = false;
                System.out.println("TouchListener: Sequencer " + onTrackBlockX + "," + onTrackBlockY + " is " + main.sequencer[onTrackBlockX][onTrackBlockY].isToBePlayed);
                //break;
                //System.out.println("X: " + view.getX() + ". Y: " + view.getY());

            case MotionEvent.ACTION_POINTER_UP:
                System.out.println("Up");
                view.setVisibility(View.VISIBLE);
                //break;
        }

        /**
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //setup drag
            System.out.println("Dragging");

            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            //start dragging the item touched
            view.startDrag(data, shadowBuilder, view, 0);

            //stop displaying the view where it was before it was dragged
            view.setVisibility(View.INVISIBLE);

            //Whenever lifted, not placed on trackBlock
            isOnTrackBlock = false;
            main.sequencer[onTrackBlockX][onTrackBlockY].isToBePlayed = false;
            System.out.println("TouchListener: Sequencer " + onTrackBlockX + "," + onTrackBlockY + " is " + main.sequencer[onTrackBlockX][onTrackBlockY].isToBePlayed);

            return true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            System.out.println("Action up");
            view.setVisibility(View.VISIBLE);
            System.out.println("Image now visible");
            return true;
        } else {
            return false;
        }*/
        return true;
    }


    public void setTrackBlockX(int x) {
        onTrackBlockX = x;
    }

    public void setTrackBlockY(int y) {
        onTrackBlockY = y;
    }
}

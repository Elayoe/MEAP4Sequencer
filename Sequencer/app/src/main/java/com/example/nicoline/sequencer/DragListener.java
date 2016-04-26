package com.example.nicoline.sequencer;

import android.app.Activity;
import android.provider.Settings;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Class to handle drop events onto trackBlocks.
 * Created by Nicoline on 20-04-2016.
 */
public class DragListener extends Activity implements View.OnDragListener {

    View view; //The ImageView being dragged
    boolean notSet = true;
    MainActivity main;
    int trackX;
    int trackY;

    public DragListener(MainActivity ma, int x, int y) {
        main = ma;
        trackX = x;
        trackY = y;
    }

    @Override
    public boolean onDrag(View dropTarget, DragEvent event) {
        //handle drag events

        view = (View) event.getLocalState();
        int dragAction = event.getAction();

        if (dragAction == DragEvent.ACTION_DRAG_EXITED) {

        } else if (dragAction == DragEvent.ACTION_DRAG_ENTERED) {

        } else if (dragAction == DragEvent.ACTION_DRAG_ENDED) {
            if (dropEventNotHandled(event)) {
                //System.out.println("Drag event not handled. Setting visible");
                view.setVisibility(View.VISIBLE);
                view.setX(1788);
                view.setY(72);
            }
        } else if (dragAction == DragEvent.ACTION_DROP) {
            view.setBackgroundResource(R.drawable.whitetui);

            //Move to the postition of the trackBlock
            view.setX(dropTarget.getX());
            view.setY(dropTarget.getY());
            //System.out.println("Moving to pos: " + dropTarget.getX() + "," + dropTarget.getY() + ". View: " + view);

            view.setVisibility(View.VISIBLE);

            //Notify the sequencer about the placement of the block
            //System.out.println("Sequencer trackblock " + trackX + "," + trackY);
            main.sequencer[trackX][trackY].isToBePlayed = true;
            System.out.println("DragListener: Sequencer " + trackX + "," + trackY + " is " + main.sequencer[trackX][trackY].isToBePlayed);

            //Nofify block about postion
            //System.out.println("Sending block id: " + view.getId() + " via main object: " + main);
            main.notifyBlock(view.getId(), trackX, trackY);
        }
        return true;
    }


        /**
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                //no action necessary
                //System.out.println("Drag started");
                //break;
            case DragEvent.ACTION_DRAG_ENTERED:
                //no action necessary
                //System.out.println("Drag entered release area");
                //break;
            case DragEvent.ACTION_DRAG_EXITED:
                //no action necessary
                //System.out.println("Drag exited release area");
                //break;
            case DragEvent.ACTION_DROP:
                //handle the dragged view being dropped over a drop view
                //System.out.println("Drag object dropped");

                //handle the dragged view being dropped over a target view
                //view = (View) event.getLocalState();
                //System.out.println("Drag object: " + view + ". Drop target " + dropTarget);

                //Set icon black
                //TODO: set black (right now we can't see because of black background, therfore yellow to test
                //view.setBackgroundResource(R.drawable.blacktui);
                view.setBackgroundResource(R.drawable.whitetui);

                //Move to the postition of the trackBlock
                view.setX(dropTarget.getX());
                view.setY(dropTarget.getY());
                //System.out.println("Moving to pos: " + dropTarget.getX() + "," + dropTarget.getY() + ". View: " + view);

                view.setVisibility(View.VISIBLE);

                //Notify the sequencer about the placement of the block
                //System.out.println("Sequencer trackblock " + trackX + "," + trackY);
                main.sequencer[trackX][trackY].isToBePlayed = true;
                System.out.println("DragListener: Sequencer " + trackX + "," + trackY + " is " + main.sequencer[trackX][trackY].isToBePlayed);

                //Nofify block about postion
                //System.out.println("Sending block id: " + view.getId() + " via main object: " + main);
                main.notifyBlock(view.getId(), trackX, trackY);

                //break;
            case DragEvent.ACTION_DRAG_ENDED:
                if (dropEventNotHandled(event)) {
                    view.setVisibility(View.VISIBLE);
                }

                //break;
            default:
                //break;
        }

        return true;
    }*/

    private boolean dropEventNotHandled(DragEvent dragEvent) {
        return !dragEvent.getResult();
    }
}

package com.example.nicoline.sequencer;

import android.app.Activity;
import android.provider.Settings;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Class to handle drop events onto trackBlocks.
 * Created by Nicoline on 20-04-2016.
 */
public class DragListener extends Activity implements View.OnDragListener {

    View view; //The ImageView being dragged
    boolean notSet = true;

    public DragListener() {
    }

    @Override
    public boolean onDrag(View dropTarget, DragEvent event) {
        //handle drag events

        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                //no action necessary
                //System.out.println("Drag started");
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                //no action necessary
                System.out.println("Drag entered release area");
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                //no action necessary
                System.out.println("Drag exited release area");
                break;
            case DragEvent.ACTION_DROP:
                //handle the dragged view being dropped over a drop view
                System.out.println("Drag object dropped");

                //handle the dragged view being dropped over a target view
                view = (View) event.getLocalState();

                //stop displaying the view where it was before it was dragged
                //view.setVisibility(View.INVISIBLE);

                //Set icon black
                //TODO: set black (right now we can't see because of black background, therfore yellow to test
                //view.setBackgroundResource(R.drawable.blacktui);
                view.setBackgroundResource(R.drawable.yellowtui);
                //view.setBackgroundResource(R.drawable.play);
                //TODO: is it resulting in correct size? Else this should be corrected

                //Move to the postition of the trackBlock
                view.setX(dropTarget.getX());
                view.setY(dropTarget.getY());
                System.out.println("Moving to pos: " + dropTarget.getX() + "," + dropTarget.getY());

                //Set in front of everything
                view.bringToFront();
                //view.setVisibility(view.VISIBLE);

                break;
            case DragEvent.ACTION_DRAG_ENDED:
                //no action necessary
                //System.out.println("Drag ended. Result: " + event.getResult());
                /**
                if(event.getResult() == false && notSet) {
                    view.setBackgroundResource(R.drawable.whitetui);

                    //TODO: why are we not getting any coords? Change this when the blocks are inserted
                    //Start position of blocks:
                    float blockX = findViewById(R.id.blockpile).getX();
                    float blockY = findViewById(R.id.blockpile).getY();

                    System.out.println("Start position: " + blockX + "," + blockY);
                    view.setX(blockX);
                    view.setY(blockY);

                    notSet = false; //So other listeners does not update again
                }*/
                break;
            default:
                break;
        }

        return true;
    }
}

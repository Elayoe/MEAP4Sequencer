package com.example.nicoline.sequencer;

import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Class to handle drop events onto trackBlocks.
 * Created by Nicoline on 20-04-2016.
 */
public class DragListener implements View.OnDragListener {

    public DragListener() {
    }

    @Override
    public boolean onDrag(View dropTarget, DragEvent event) {
        //handle drag events

        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                //no action necessary
                System.out.println("Drag started");
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
                View view = (View) event.getLocalState();

                //stop displaying the view where it was before it was dragged
                view.setVisibility(View.INVISIBLE);

                //TODO: move the image of the block (view) to the location og dropTarget and make its icon black


                break;
            case DragEvent.ACTION_DRAG_ENDED:
                //no action necessary
                System.out.println("Drag ended");
                break;
            default:
                break;
        }

        return true;
    }
}

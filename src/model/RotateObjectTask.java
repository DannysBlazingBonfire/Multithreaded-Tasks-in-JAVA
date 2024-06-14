package model;

import View.GUI;
import View.ShapeComponent;

//class used as task for a thread to rotate a shape
public class RotateObjectTask implements Runnable{

    private GUI view; //access to boundary class
    private boolean stopflag; //stop flag for thread
    private ShapeComponent shape; //access to the shape class
    private static int degrees = 0; //degrees rotated

    public RotateObjectTask(GUI view){
        this.stopflag = false;
        this.view = view;
        shape = view.getShape();
    }

    public void setStopflag(boolean stopflag) {
        this.stopflag = stopflag;
    }

    @Override
    public void run() {
            while(!stopflag){
                try{
                    shape.setRotation(degrees); //set rotational degrees
                    degrees++; //increment degrees by 1
                    view.getShape().revalidate(); //update and draw out shape
                    view.getShape().repaint();
                    if(degrees == 360){ //if degree value equals one full turn then reset
                        degrees = 0;
                    }
                    Thread.sleep(10); //wait

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

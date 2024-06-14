package model;

import View.GUI;

import java.util.Random;

//task class to controll random placement of text
public class RandomTextTask implements Runnable{
    private boolean stopFlag; //stop flag for while loop
    private GUI view; //access to view to update components

    public RandomTextTask(GUI view){
        this.stopFlag = false;
        this.view = view;
    }

    //method to generate random number within set range
    public int getRandomNumberInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    @Override
    public void run() {

        int x; //x cordinate
        int y; //y cordinate

        while (!stopFlag){
            try {
                //generate random num with max x,y as range.
                x = getRandomNumberInt(0,335);
                y = getRandomNumberInt(0,380);

                view.getMovingText().setVisible(false); //make text dissapear

                Thread.sleep(500); //wait

                view.getMovingText().setLocation(x,y); //update text location
                view.getMovingText().setVisible(true); //display text

                Thread.sleep(500); //wait

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

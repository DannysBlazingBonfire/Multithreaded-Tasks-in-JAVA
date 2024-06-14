package model;

import View.GUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//task for running a clock in a thread
public class ClockTask implements Runnable{

    private boolean stopFlag; //stop flag for while loop
    private GUI view; //access to view to change text in components
    private DateTimeFormatter formatter; //formatter to format correct time

    public ClockTask(GUI view){
        this.view = view;
        stopFlag = false;
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); //time in hours, minutes, seconds
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    //run method
    @Override
    public void run() {
        while(!stopFlag){
            try{

                LocalDateTime time = LocalDateTime.now(); //get local time
                String clockdisplay = time.format(formatter); //format time
                view.getClock().setText(clockdisplay); //display time

                Thread.sleep(1000); //wait 1 sec

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

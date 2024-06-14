package Controller;

import View.GUI;
import model.*;

//class governing Logic of application
public class Controller {

    GUI view; //boundary class
    Model model; //model class

    public Controller(){
        this.view = new GUI(this); //parse controller to GUI
        this.model = new Model();
    }

    //method called when starting random text
    public void toggleRandTextOn(){
        model.setRandomTextTask(new RandomTextTask(view)); //new instance of task
        new Thread(model.getRandomTextTask()).start(); //place task as parameter in thread and start
    }

    //method called when stopping random text
    public void toggleRandTextOff(){
        model.getRandomTextTask().setStopFlag(true); //flag for ending whileloop
    }

    //method called when starting clock
    public void toggleClockOn(){
        model.setClockTask(new ClockTask(view));
        new Thread(model.getClockTask()).start();
    }

    //method called when stopping clock
    public void toggleClockOff(){
        model.getClockTask().setStopFlag(true);
    }

    //Starts rotation of shape
    public void toggleRotateOn(){
        model.setRotateObjectTask(new RotateObjectTask(view));
        new Thread(model.getRotateObjectTask()).start();
    }

    //stops rotation of shape
    public void toggleRotateOff(){
        model.getRotateObjectTask().setStopflag(true);
    }
}

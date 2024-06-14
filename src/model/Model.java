package model;

import javax.swing.*;

//model class used to store tasks
public class Model {

    //store Thread tasks in model
    private RandomTextTask randomTextTask;
    private ClockTask clockTask;
    private RotateObjectTask rotateObjectTask;

    //getters-setters for the tasks
    public RandomTextTask getRandomTextTask() {
        return randomTextTask;
    }

    public void setRandomTextTask(RandomTextTask randomTextTask) {
        this.randomTextTask = randomTextTask;
    }

    public ClockTask getClockTask() {
        return clockTask;
    }

    public void setClockTask(ClockTask clockTask) {
        this.clockTask = clockTask;
    }

    public RotateObjectTask getRotateObjectTask() {
        return rotateObjectTask;
    }

    public void setRotateObjectTask(RotateObjectTask rotateObjectTask) {
        this.rotateObjectTask = rotateObjectTask;
    }
}

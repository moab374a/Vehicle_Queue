package code;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class VehicleQueue implements ClockObserver {
    private final Queue<Vehicle> queue = new LinkedList<>();

    //Local time for the class
    private int currentTime;

    private double entryDelay;
    private double exitDelay;

    private boolean greenLight = false;

    private int trafficLightRate;

    private VehicleGenerator generator;

    public VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate, VehicleGenerator generator) {
        Objects.requireNonNull(generator);
        if (trafficLightRate <= 0 || entryDelay <= 0d || exitDelay <= 0d) throw new IllegalArgumentException();
        this.exitDelay = exitDelay;
        this.entryDelay = entryDelay;
        this.generator = generator;
        this.trafficLightRate = trafficLightRate;
    }

    // generate a Car and add It to the queue.
    public void enter() {
        queue.add(generator.createVehicle());
    }

    // pull the car out from the list
    public void leave() {
        queue.poll();
    }

    // give me how many cars in the List
    public int getSize() {
        return queue.size();
    }

    // Get the RemindTime
    private int getDuration(){
        return  this.remainTimeToChangeLights(this.currentTime);}


    // calculate the remain Time To Change the Lights
    private int remainTimeToChangeLights(int currentTime){
        // Remind Time from current Until the Signal changes
        int remindTime = currentTime % (trafficLightRate * 2);
        return remindTime;
    }
    private Integer getTime(){
        return this.currentTime; }


    public double getLength() {
        return queue.stream()
                .map(Vehicle::getLength)
                .reduce(0.0, Double::sum);
    }


    private double getLastLeave() {
        return Math.round(this.exitDelay * needToLeaveAmount(this.getTime() - 1));
    }

    private void setTime(int currentTime) {
        this.currentTime = currentTime; }

    private void switchLight() {
        if (this.getDuration() % this.trafficLightRate == 0)
            this.greenLight = !this.greenLight;
    }
    private boolean isSwitched(int time) {
        boolean isChangedFromLastTime = !isGreenLight(time) && isGreenLight(time - 1);
        return time != 0 && (isChangedFromLastTime);
    }
    private boolean isGreenLight(int time) {
        return this.remainTimeToChangeLights(time) >= trafficLightRate;
    }


    private double amountToEnter() {
        int time = this.getTime();
        double resalt = needToEnterAmount(time) - needToEnterAmount(time - 1);

        return needToEnterAmount(time) - needToEnterAmount(time - 1);
    }

    private double amountToLeave() {
        int timeInt = this.getTime();
        int phaseTime = this.getDuration();
        if (isSwitched(timeInt))
            return Math.floor((this.trafficLightRate - this.getLastLeave()) / this.exitDelay);
        else
            return needToLeaveAmount(phaseTime) - needToLeaveAmount(phaseTime - 1);
    }

    private double needToEnterAmount(double currentTime) {
        return Math.floor(currentTime / this.entryDelay); }

    private double needToLeaveAmount(double currentTime) {
        if (currentTime < this.trafficLightRate) return 0d;
        currentTime %= this.trafficLightRate;
        return Math.floor(currentTime / this.exitDelay);
    }

    @Override
    public void tick(int currentTime) {

        System.out.println("Inside tick , Vehicle Class \n");


        this.setTime(currentTime);

        System.out.println(currentTime);

        this.switchLight();

        double toEnter = amountToEnter();
        for (int i = 0; i < toEnter; i++) this.enter();

        double toLeave = amountToLeave();
        for (int i = 0; i < toLeave; i++) this.leave();
    }


}
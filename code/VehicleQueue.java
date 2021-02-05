package Vehicle_Queue.code;

import java.util.ArrayList;
import java.util.List;

public class VehicleQueue implements ClockObserver {
    private double entryDelay; // TODO. AMOUNT OF TIME TO ALLOW CARS TO enter() in s
    private double exitDelay; // TODO. AMOUNT OF TIME TO ALLOW CARS TO leave() in s but if greenlight is true
    private int trafficLightRate;  //TODO:determines the duration of the red and green phases of the traffic light (s)
    private boolean greenLight = false;

    private List<Vehicle> queue;
    private VehicleGenerator generator;
    private Clock clock;

    public VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate, VehicleGenerator generator) {

        Validator.checkParam(entryDelay);
        Validator.checkParam(exitDelay);
        Validator.checkParam(trafficLightRate);
        Validator.checkParam(generator);

        this.entryDelay = entryDelay;
        this.exitDelay = exitDelay;
        this.trafficLightRate = trafficLightRate;
        this.generator = generator;
        this.generator.createVehicle();
        //this.clock= new Clock();

        queue = new ArrayList<>();
    }



    //TODO:
    public void enter() {
    }

    // TODO. AMOUNT OF TIME TO ALLOW CARS TO enter() in s
    public void leave() {
    }

    public double getLength() //TODO calculate the length of the vehicle queue in meters and the number of vehicles
    {
        return 0;
    }

    public double getSize() // TODO: HOW MANY CARS UN THE QUEUE
    {
        return 0;
    }

    @Override
    public void tick(int currentTime) {

        if (currentTime % trafficLightRate == 0) {  // to increased the trafficLight
            trafficLightRate += trafficLightRate; // update single light
            greenLight = !greenLight;
        }


    }
}

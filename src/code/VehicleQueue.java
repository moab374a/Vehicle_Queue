package code;

import java.util.ArrayList;
import java.util.List;

public class VehicleQueue implements ClockObserver {
    private double entryDelay;
    private double exitDelay;
    private int trafficLightRate;
    private boolean greenLight = false;

    private List<Vehicle> queue;
    private VehicleGenerator generator;

    public VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate, VehicleGenerator generator) {

        Validator.checkParam(entryDelay);
        Validator.checkParam(exitDelay);
        Validator.checkParam(trafficLightRate);
        Validator.checkParam(generator);

        this.entryDelay = entryDelay;
        this.exitDelay = exitDelay;
        this.trafficLightRate = trafficLightRate;
        this.generator = generator;

        queue = new ArrayList<>();
    }

    public VehicleQueue() {

    }

    public void enter(){}
    public void leave(){}

    public  double getLength()
    {
        return 0;
    }
    public  double getSize()
    {
        return 0;
    }

    @Override
    public void tick(int currentTime) {

    }
}

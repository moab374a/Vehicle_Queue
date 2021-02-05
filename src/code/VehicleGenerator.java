package code;

import java.util.Random;

public class VehicleGenerator {
    private Random randomGenerator;

    public VehicleGenerator() {
    }

    public Vehicle createVehicle(){
        Vehicle bicycle  = new Bicycle();
        return bicycle;
    }
}

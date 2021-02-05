package Vehicle_Queue.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VehicleGenerator {
    private Random randomGenerator;

    public VehicleGenerator() {
        randomGenerator = new Random();
    }

    //TODO: creates and provides a random vehicle

    public Vehicle createVehicle() {

        Map<Integer, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put(0, new Bicycle());
        vehicleMap.put(1, new Car());
        vehicleMap.put(2, new Bus());

        int ran = randomGenerator.nextInt(3);


        return vehicleMap.get(ran);
    }
}

package code;

import java.util.ArrayList;
import java.util.List;

public class Clock implements Subject {
    private  int currentTime = 0;
    private int endOfTime;

    private List<ClockObserver> observers;

    public Clock(int endOfTime) {
        if (endOfTime <= 0) throw new IllegalArgumentException();
        this.endOfTime = endOfTime;
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(ClockObserver clockObserver) {
        Validator.checkParam(clockObserver);
        observers.add(clockObserver);
    }

    @Override
    public void removeObserver(ClockObserver observer) {
        Validator.checkParam(observer);
        observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {

        for (ClockObserver c: observers) {
            c.tick(currentTime);
        }
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void run()
    {
        currentTime = 0;
        for (int i = 0; i < endOfTime; i++) {

            System.out.println(currentTime);
            this.currentTime += 1;
            tick(this.currentTime);

        }

    }


     private void tick (int currentTime)
     {
         Validator.checkParam(currentTime);
         for (ClockObserver clock : observers
              ) {clock.tick(currentTime);
         }

     }
}

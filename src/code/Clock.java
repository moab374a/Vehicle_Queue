package code;

import java.util.List;

public class Clock {
    private int currentClock = 0;
    private int endOfTime;

    private List<ClockObserver> observers;

    public Clock(int endOfTime) {
        Validator.checkParam(endOfTime);
        this.endOfTime = endOfTime;
    }

    public void addObserver(ClockObserver clockObserver) {
        Validator.checkParam(clockObserver);
        observers.add(clockObserver);
    }

    public void removeObserver(ClockObserver observer) {
        Validator.checkParam(observer);
        observers.remove(observer);
    }

    public int getCurrentTime() {
        return currentClock;
    }
    public void run()
    {

    }
     private void tick (int currentTime)
     {
         Validator.checkParam(currentTime);
     }

}

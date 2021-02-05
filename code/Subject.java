package Vehicle_Queue.code;

public interface Subject {

    void addObserver(ClockObserver clockObserver);
    void removeObserver(ClockObserver clockObserver);
    void notifyAllObserver();




}

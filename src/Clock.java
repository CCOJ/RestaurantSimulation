import java.util.Observable;

/**
 * Clock uses a thread to run ticks.
 * Only one Clock object is created at a time for the singleton design.
 * This extends Observable to notify any observers.
 */

public class Clock extends Observable implements Runnable {

    /**
     * Supports the singleton design and allows other classes to use this same instance
     */
    private static Clock instance;

    /**
     * Immediately creates the Thread object and hooks with the Clock object
     */
    private Thread thread = new Thread(this);

    /**
     * Events for Clock
     */
    public enum Events {
        CLOCK_TICK
    }

    /**
     * Private constructor for singleton design
     */
    private Clock() {
        thread.start();
    }

    /**
     * Creates the only Clock object if not created. Otherwise, it returns the only Clock object
     * @return instance; Only Clock object
     */
    public static Clock instance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    /**
     * This allows the tick to be processed. Currently set to 1 second (1000ms).
     * It also notifies any observers of a clock tick.
     */
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);           //1 second
                setChanged();                       //Marks the observable object as changed
                notifyObservers(Events.CLOCK_TICK); //Notifies all observers there is a clock tick
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }


}

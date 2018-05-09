import java.util.Observer;
import java.util.Observable;

/**
 * This runs the restaurant functions using a singleton pattern. This will expand to separate classes
 * as we introduce more complexity and modularity.
 */
public class Restaurant implements Observer {

    protected static Restaurant instance;

    public Config config = new Config();

    private int customers = config.getProperty("customers");
    private int employees = config.getProperty("employees");
    private int capacity = config.getProperty("capacity");
    private double money = config.getProperty("money");

    /**
     * Empty constructor for singleton pattern
     */
    private Restaurant() {
    }

    /**
     * To reference to the Restaurant object, it refers to the instance of it.
     * If one doesn't exist, it creates an object for it.
     *
     * @return
     */
    public static Restaurant instance() {
        if (instance == null)
            instance = new Restaurant();

        return instance;
    }

    public void initialize() {
        Clock.instance().addObserver(instance());
    }

    public void update(Observable observable, Object arg) {
        if (arg.equals(Clock.Events.CLOCK_TICK)) {
            processClockTick();
        }
    }

    public void processEvent(Object arg) {
        if (arg.equals(Clock.Events.CLOCK_TICK)) {
            processClockTick();
        }
    }

    public void setCustomer(int customers) {
        this.customers = customers;
    }

    public int getCustomers() {
        return customers;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public int getEmployees() {
        return employees;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    private void processClockTick() {

    }
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * A GUI to allow user interaction with the simulation
 */
public class RestaurantGUI implements ActionListener {

    private static GUI gui;
    private Restaurant restaurant;

    private RestaurantGUI() {
        restaurant = Restaurant.instance();
        gui = new GUI();
        restaurant.initialize();
    }

    private class GUI extends JFrame {
        private JLabel customersLabel = new JLabel("Customers: " + String.valueOf(restaurant.getCustomers()));
        private JLabel employeesLabel = new JLabel("Employees: " + String.valueOf(restaurant.getEmployees()));
        private JLabel capacityLabel = new JLabel("Capacity: " + String.valueOf(restaurant.getCapacity()));
        private JLabel moneyLabel = new JLabel("Money: $" + String.valueOf(restaurant.getMoney()));

        private JPanel statsPanel = new JPanel(new FlowLayout());

        private GUI() {
            super("Restaurant");
            addWindowListener(new WindowAdapter() {
                public void WindowClosing(WindowEvent event) {
                    System.exit(0);
                }
            });

            getContentPane().setLayout(new FlowLayout());

            statsPanel.add(customersLabel);
            statsPanel.add(employeesLabel);
            statsPanel.add(capacityLabel);
            statsPanel.add(moneyLabel);

            getContentPane().add(statsPanel);

            setDefaultCloseOperation(EXIT_ON_CLOSE);

            pack();
            setVisible(true);
        }
    }


    public void actionPerformed(ActionEvent event) {

    }

    public static void main(String[] s) {
        RestaurantGUI restaurantGUI = new RestaurantGUI();
    }
}

package programmingAssignment;

import java.util.ArrayList;


/**
 * The Order class used to construct an order for widgets to be processed by WidgetWarehouse class.
 *
 * @author gabrielsiguenza
 */
public class Order {

    public static final int DEFAULT_SIZE = 10;

    private ArrayList<Widget> orders;
    private int size;
    private int numWidgets;

    /**
     * Default Constructor
     */
    public Order() {
        orders = new ArrayList<Widget>();
        size = DEFAULT_SIZE;
        numWidgets = 0;
    }

    /**
     * Constructor that sets the size of the order.
     *
     * @param size
     */
    public Order(int size) {
        orders = new ArrayList<Widget>();
        this.size = size;
        numWidgets = 0;
    }

    /**
     * 
     * @return
     */
    public int getNumWidgets() {
        return this.numWidgets;
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addWidget(Widget e) {
        if (orders.size() != this.size) {

            orders.add(e);
            numWidgets++;
            return true;
        } else {
            System.out.println("Order has been filled");
            return false;
        }
    }

    /**
     * @return
     */
    public int size() {
        return orders.size(); /*This is where the problem is, this is not correct... know why?*/
    }
//    public void push(Widget) {
//
//    }

    /**
     * Removes orders from the end of the ArrayList.
     */
    public void remove() {
        if (!(orders.size() == 0)) {
            orders.remove(orders.size() - 1);
        }
    }

    /**
     *
     *
     * @return
     */
    public double calcInvoice() {
        double totalPrice = 0;

        for (Widget shit : orders) {
            totalPrice += shit.getCost();
        }

        return totalPrice; // calculated cost(sum of widget costs in the order) cost * .50
    }

    /**
     * @return
     */
    public boolean isFilled() {
        /*Had to fix this method by changing this.size to this.getSize() why? */
        return (numWidgets == this.getSize()); // Why does this need me to getSize?
        // I should have access to my own private instance variable from within this class
        // yet I still only get 1.
    }

    /**
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * @return
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nOrder received: ");
        for (Widget item : orders) {
            s.append(item + ", ");
        }
        s.append("\nSize of the order is: " + this.size);
        s.append(", contains " + getNumWidgets() + " items thus far.\n");

        return s.toString();
    }

}

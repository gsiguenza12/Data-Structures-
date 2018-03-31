package programmingAssignment;

import java.util.Stack;

public class WidgetWareHouse {
    //private Delivery shipmentToBeProcessed;
    private Stack<Order> ordersToBeFilled; //Mismatched queries or updates?
    private Stack<Widget> widgetsOnHand;
    private Order newOrder;

    /**
     * Default Constructor
     */
    public WidgetWareHouse() {
        ordersToBeFilled = new Stack<>();
        widgetsOnHand = new Stack<>();
    }

    /**
     *
     *
     * @param numItems
     */
    public void processOrder(int numItems) {
        this.newOrder = new Order(numItems);

    }

    /**
     *
     *
     * @return
     */
    public Stack<Order> getOrdersToBeFilled() {
        return ordersToBeFilled;
    }

    /**
     *
     *
     */
    public void fillOrder() {
        while(!widgetsOnHand.empty()) {
            System.out.println("filling order from widgets on hand.");
//            System.out.println("Order passed in from Main, size: " + newOrder.getSize());
            newOrder.addWidget(widgetsOnHand.pop());

            System.out.println(newOrder.getNumWidgets());
//            System.out.println(newOrder.isFilled() + "" + " " + newOrder.getSize() + " " + newOrder.getNumWidgets());
            if(newOrder.isFilled()) {
                System.out.println("Order has been filled. Ready to ship.\n");
                break;
            }
        }

        if(widgetsOnHand.empty() && !newOrder.isFilled()) {
            System.out.println("Warehouse is empty and new order has not been filled.");
            System.out.println("\n" + newOrder);
            ordersToBeFilled.push(newOrder);
        }
    }

    /**
     * Get the warehouse's latest order received.
     *
     * @return The instance variable newOrder
     */
    public Order getNewOrder() {
        return newOrder; /* Should use copy constructor or clone? */
    }

    /**
     * Takes in a Widget stack and pops the items into the warehouse inventory.
     *
     * @param shipmentToBeProcessed A Stack of widgets to be added to the WidgetsOnHand Stack.
     */
    public void processDelivery(Stack<Widget> shipmentToBeProcessed) {
        System.out.println("The Warehouse has a new delivery! Adding delivery to inventory.");
        while(!shipmentToBeProcessed.empty()) {
            // adding delivery contents to inventory
            widgetsOnHand.push(shipmentToBeProcessed.pop());
//            System.out.println(widgetsOnHand);
        }
        if(!ordersToBeFilled.empty()) {
            // pops out the most recent order from the orders to be filled stack.
            System.out.println("Still need to process unfilled orders.");
            newOrder = ordersToBeFilled.pop();
            System.out.println(newOrder);
            fillOrder();
//            newOrder.addWidget(widgetsOnHand.pop());
            // what if there are multiple orders left?
        }
    }

    /**
     * Gets the number of widgets currently in the warehouse inventory.
     *
     * @return The number of widgets on hand.
     */
    public int getNumWidgetsOnHand() {
        return widgetsOnHand.size();
    }

    /**
     *
     * @param newOrder
     */
//    public Order addOrder(Order newOrder, int size) {
//        while(!widgetsOnHand.empty()) {
//            System.out.println("filling order from widgets on hand.");
//            /* The size of new order does not match the size of new order passed into method. */
//            System.out.println("Order passed in from Main, size: " + newOrder.size());
//            newOrder.addWidget(widgetsOnHand.pop());
//
//            System.out.println(newOrder.getNumWidgets());
//            System.out.println(newOrder.isFilled() + "" + " " + size + " " + newOrder.getNumWidgets());
//            if(newOrder.isFilled()) { return newOrder; }
//        }
//
//        if(widgetsOnHand.empty() && !newOrder.isFilled()) {
//            System.out.println("Stack is empty and new order is full");
//            ordersToBeFilled.push(newOrder);
//        }
//        return newOrder;
//    }


}

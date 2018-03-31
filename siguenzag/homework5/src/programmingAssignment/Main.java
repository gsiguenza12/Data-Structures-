package programmingAssignment;

import java.util.Stack;

public class Main {

    public static final int SIZE = 10;
    public static final double PROFIT = .50;


    public static void main(String[] args) {

        Widget theWidget = new Widget("Widget", 49.99);
        WidgetWareHouse wareHouse1 = new WidgetWareHouse();
        Stack<Widget> newDelivery = new Stack<>();
        Order readyToShipOrder = new Order();

        double totalCost = 0;


        //Create a delivery
        createDelivery(newDelivery,theWidget);
        //Create a delivery
        createDelivery(newDelivery, theWidget);

        //send delivery to warehouse
        wareHouse1.processDelivery(newDelivery);
        wareHouse1.processDelivery(newDelivery);


        System.out.println("The warehouse has " + wareHouse1.getNumWidgetsOnHand() + " widgets on hand.");


        //Create an order
        wareHouse1.processOrder(11);
        System.out.println("The Warehouse has a new order! " +  wareHouse1.getNewOrder());

        wareHouse1.fillOrder();

        System.out.println("The warehouse has " + wareHouse1.getNumWidgetsOnHand() + " widgets on hand.");

        createDelivery(newDelivery,theWidget);
        wareHouse1.processDelivery(newDelivery);

        //       System.out.println("\nThis order is at the top of the ordersToBeFilled Stack, \n" + wareHouse1.getOrdersToBeFilled());

        System.out.println("The warehouse has " + wareHouse1.getNumWidgetsOnHand() + " widgets on hand.");


        /*Stacks implement push, pop, peek, and empty*/

        // Shipping the new order with invoice.
        readyToShipOrder = wareHouse1.getNewOrder();
        totalCost = readyToShipOrder.calcInvoice();

        System.out.println("\nInvoice\n-----------\n" +  "Total price for current shipment:\n$" + (totalCost += (totalCost * PROFIT)));
        System.out.printf("\n\nTotal profit off this order: " + "%n$%6.2f",(totalCost * PROFIT));
    }

    // This works because Stack newDeliver is an object, so this is passed by reference to the static method
    // the changes made to the Stack are made to the original object in main. (same with arrays)
    public static void createDelivery(Stack theDelivery, Widget theWidget) {
        for(int i = 0; i < 10; i++) {
            theDelivery.push(theWidget);
        }

    }


}

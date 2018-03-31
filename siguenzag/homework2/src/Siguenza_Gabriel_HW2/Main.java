package Siguenza_Gabriel_HW2;

// import packages needed:
import java.util.ArrayList;

/**
 * Main driver that uses an ArrayList to store a list of several food objects.
 *
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Food> foodList = new ArrayList();
        Meats steak = new Meats("Steak", 400, 100, 100, 100);
        Fats milkDuds = new Fats("Milk Duds", 50, 20, 20, 20);
        Milk yogurt = new Milk("Yogurt", 120, 35, 20, 10);
        Vegetables celery = new Vegetables("Celery", 0, 0, 0, 0);
        Fruits apple = new Fruits("Apple", 45, 20, 10, 10);
        Bread bagel = new Bread("Bagel", 90, 35, 20, 20);

        /** Adding items to the ArrayList **/
        // Adding a Meats
        foodList.add(steak);
        // Adding a Fats
        foodList.add(milkDuds);
        // Adding a Milk
        foodList.add(yogurt);
        // Adding a Vegetables
        foodList.add(celery);
        // Adding a Fruits
        foodList.add(apple);
        // Adding a Bread
        foodList.add(bagel);

        // Output current list contents to screen.
        printList(foodList);



    }



    /**
     * Prints objects in list to screen.
     *
     * @param foodList An ArrayList of type Food.
     */
    public static void printList(ArrayList<Food> foodList) {

        System.out.println("Your Favorite Foods are: ");

        for (Food entry : foodList) {

            System.out.println("\n" + entry + "\n");

        }

    }
}
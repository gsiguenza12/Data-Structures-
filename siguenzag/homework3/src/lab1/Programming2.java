package lab1;

// import packages needed
import java.util.ArrayList;

/**
 * Write a static method that deletes the first occurrence of target in a list.
 * public static void delete(ArrayList<String> aList, String target)
 *
 * @author gabrielsiguenza
 */
public class Programming2 {

    public static void main(String[] args) {


        ArrayList<String> aList = new ArrayList<>();

        aList.add("Bananas");
        aList.add("Apples");
        aList.add("Jesus");
        aList.add("Bananas");
        aList.add("Apples");

        System.out.println("Your list contains: ");
        Programming1.printList(aList);

        System.out.println("\nCalling delete method and removing first occurrence of apples.");
        delete(aList,"Apples");

        System.out.println("The list now contains: ");
        Programming1.printList(aList);

    }

    public static void delete(ArrayList<String> aList, String target) {

        if(aList.contains(target)) {

            aList.remove(target);

        }

    }

}

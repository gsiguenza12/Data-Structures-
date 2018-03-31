package lab1;

// import packages needed.
import java.util.ArrayList;
/************************************************
 * COURSE:			  CS113 M 5:30-9:30pm
 * CHAPTER:			  2
 * PROGRAMMER: 		  Gabriel Siguenza
 * DATE LAST MODIFIED: 02.16.2018
 ************************************************/

/**
 * Create a method to replace each occurrence of oldItem in aList with newItem.
 *
 * Need to change this to use the DirectoryEntry definition on page 70.
 * @author gabrielsiguenza
 */
public class Programming1 {

    public static void main(String[] args) {

        ArrayList<String> aList = new ArrayList<String>();

        aList.add("Bananas");
        aList.add("Apples");
        aList.add("Jesus");
        aList.add("Bananas");

        // How did you iterate through an arrayList in the past?
        /*for(int i = 0; i < aList.size(); i++) {

            System.out.println(aList.get(i));
        }*/

        // For : each loop
        System.out.println("The contents of your list are:");
        printList(aList);
        System.out.println();

        if(replace(aList,"Bananas","Turkey")) {
            System.out.println("\nDone.");
        }

        else {
            System.out.println("\nWhoops old item not found within list. Aborting...");
        }
        System.out.println("\nReplacing all occurrences of Bananas with Turkey...");
        System.out.println("\nNow the contents of your list are: ");
        printList(aList);
    }

    /**
     * Replaces each occurrence of oldItem in aList with newItem.
     *
     * @param aList An ArrayList Object of type String.
     * @param oldItem The old object to be replaced.
     * @param newItem The new object to be placed in the index of the old object.
     * @return Returns boolean true, if item exists in ArrayList else, returns false.
     */
    public static boolean replace(ArrayList<String> aList, String oldItem, String newItem){

        // If the item your replacing is not found in the array then abort.
        if(!(aList.contains((String)oldItem))) {

            return false;
        }

        // if the item is found in the array replace.
        else{

            for(String stuff: aList) {

               if(stuff.equalsIgnoreCase(oldItem)) {
                   System.out.println("\nDoes the list contain the old item? " + stuff.equalsIgnoreCase(oldItem));

                   aList.set(aList.indexOf(stuff), newItem);

               }

            }

        }

        return true;

    }

    /**
     * Prints objects in aList to screen.
     *
     * @param aList An ArrayList object of type String
     */
    public static void printList(ArrayList<String> aList) {

        for(String stuff: aList) {

            System.out.println(stuff);

        }

    }
}

package Siguenza_Gabriel_HW4;

/** Tests **/
public class Main {

    public static void main(String[] args) {

        KWLinkedList<String> aList = new KWLinkedList<>();
        System.out.println("Testing methods given in the src code.\n");
        System.out.println("Is the list empty? " + aList.isEmpty());

        System.out.println("Adding 3 items to the list\n");

        aList.add("Tom");
        aList.add("Dick");
        aList.add("Harry");
        aList.add("Sam");

        /*
        Insert Bill before Tom
        Insert Sue before Sam
        Remove Bill
        Remove Sam
         */

        aList.addFirst("Bill");
        aList.add(4,"Sue");

        aList.remove(0);
        aList.remove(4);

        System.out.println(aList.toString()); // calling toString()


    }
}

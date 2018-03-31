package lab2;


/**
 * Chapter 2, Programming 1
 *
 * @author gabrielsiguenza
 */

/**
 * Write a program that compares the values of y1 and y2 in the
 * following expressions for the values of n up to 100 in increments of 10.
 * Does the result surprise you?
 *
 * y1 = 100 * n + 10
 * y2 = 5 * n * n + 2
 */

public class Programming1 {

    /*public static double compareValues(double y1, double y2) {
        int n = 0;

        return 0;

    }*/


    /**
     * Main method to display the values of y1 and y2 in the
     * following expressions for the values of n up to 100 in increments of 10;
     * y1 = 100 * n + 10
     * y2 = 5 * n * n + 2
     *
     * @param args
     */
    public static void main(String[] args) {

        int n = 0;
        double y1;
        double y2;

        for(int i = 10; i <= 100;i += 10){

            n = i;

            y1 = (100 * n + 10);
            y2 = (5 * n * n + 2);
            System.out.println("y1 = " + y1 + "\ny2 = " + y2);
        }


    }
}

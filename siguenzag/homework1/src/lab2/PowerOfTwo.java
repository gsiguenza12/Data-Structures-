package lab2;

import java.util.Scanner;

public class PowerOfTwo
{

    /**
     * Checks whether given int value is a power of two.
     *
     * @param x An int value to be checked.
     * @return Returns true is value passed is a power of two else, returns false.
     */
                                // should be unsigned int.
    static boolean isPowerOfTwo(int x)
    {
        // x must be more than 0, power of two check (0 is non-inclusive)
        return ( x > 0 && (x & (x-1)) == 0);
                        // if x is a power of two then x & (x-1) equals 0,
                        // & performs bitwise operation, so if x is a power of two,
                        // x & (x-1) shifts all unset bits after the first set bit to be set
                        // and the set bit to unset.

    }


    public static void main(String[] args)
    {
        int x = 8;

        System.out.println("Welcome to the Power Of Two Java Program");

        Scanner keys;
        {
            keys = new Scanner(System.in);
        }

        System.out.println("\ndefault = " + x + "\nWould you like to change the default value?(y/n): ");

        if(keys.nextLine().equalsIgnoreCase("Y"))
        {
            System.out.println("Enter new value: ");
            x = keys.nextInt();
        }

        System.out.println("Is " + x + " A power of two?: " + isPowerOfTwo(x));
    }

}
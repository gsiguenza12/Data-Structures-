package recursion;


/**
 *
 * Write a recursive method that will dispense change for a given amount of money.
 * The method will display change for a given amount of money. The method will display
 * all combinations of quarters, dimes, nickels, and pennies that equal the desired amount.
 * Note: the method should not display combinations that are identical. For example 1 nickel
 * and 1 penny and 1 nickel for 6 cents.
 *
 * @author gabrielsiguenza
 */
import java.util.Scanner;
import java.util.ArrayList;

public class ChangeDispenser {
    public static void main(String[] args) {

        Scanner inpt = new Scanner(System.in);

        System.out.println("Enter amount: ");
        double amount = inpt.nextDouble();

        int pennies = (int)(amount * 100);

        ArrayList<int[]> list = convert(0, 0, 0, pennies, new ArrayList<>());

        System.out.println("Testing Penny conversion:" + pennies);

        int[] temp;

        for(int i = 0; i < list.size(); i++) {

            int total = 0;
            temp = list.get(i);
            System.out.print((i+1) + ")	");
            for(int j = 0; j < temp.length; j++) {

                if(j == 0)
                    total += temp[j] * 25;

                else if(j == 1)
                    total+= temp[j] * 10;

                else if(j == 2)
                    total += temp[j] * 5;

                else
                    total += temp[j];

                System.out.print( temp[j] + "	");
            }
            System.out.println( " = " + total);
        }

        inpt.close();
    }

    //Recursive method
    private static ArrayList<int[]> convert(int q, int d, int n, int p, ArrayList<int[]> list)
    {
        //Reduce dimes
        if((d*10) > 25)
        {
            //Reduce to quarters and nickles
            if((d*10) > 20)
            {
                int[] c = {q+1, d-3, n+1, p};
                list.add(c);

                return convert(q+1, d-3, n+1, p, list);
            }
            else
            {
                int[] c = {q+1, d-2, n, p};
                list.add(c);

                return convert(q+1, d-2, n, p, list);
            }
        }

        //Reduce Nickels
        else if((n * 5) >= 10)
        {
            //Check for any extra nickles
            int[] c = {q, d+1, n-2, p};
            list.add(c);

            return convert(q, d+1, n-2, p, list);
        }

        //Reduce Pennies
        else if(p >= 5)
        {
            int[] c = {q, d, n+1, p-5};
            list.add(c);

            return convert(q, d, n+1, p-5, list);
        }

        //Check quarters

        else
            return list;
    }
}

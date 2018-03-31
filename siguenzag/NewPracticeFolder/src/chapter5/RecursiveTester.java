package chapter5;

public class RecursiveTester {


    public static void main(String[] args) {

        System.out.println(RecursiveMethods.recSub(4,7));
//        DrawTriangle.indirectDraw(5,10);

        // simultaneously initialize all indices of the array.
        String[] names = new String[] {"Jim", "Bob", "Gabe", "Jennifer", "Christine"};
        System.out.println(names[RecursiveMethods.linearSearch(names,"Gabe")]);
        // Print out names at the index returned by the recursive linearSearch method.

        // What happens when you don't call the wrapper method.
    // DrawTriangle.indirectDraw(3,5);

        /*Create an array of objects and pass them as parameters to linear search() */

        /* Testing the recursive power method */
        double x, n;

        x = 4;
        n = 4;

//       System.out.println(RecursiveMethods.power(4,4, 0));

    }
}

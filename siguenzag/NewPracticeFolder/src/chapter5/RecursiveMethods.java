package chapter5;

/**
 * A class to practice building recursive methods from
 * the book, Data structures by Elliot Koffman and Paul Wolfgang.
 *
 * @author gabrielsiguenza
 */
public class RecursiveMethods {

    /*
    Finding the recursive structure:

    These are some common patterns for recursive algorithms
      - divide in half, solve one half.
      - divide in sub-problems, solve each sub-problem recursively, "merge".
      - solve one or several problems of size n-1.
      - process first element, recurse on remaining problem.

    2 different types of recursion:
      - functional: function computes and returns the result.
      Ex: computing the sum of n #'s, IsPalindrome, binary search.
      - procedural: no return result (function returns void). The task is accomplished during the recursive calls.
      Ex: Sierpinski fractals.

        Exhaustive recursion
        Non-exhaustive: stops early
     */



    /* Define wrapper:  */
    /**
     * Wrapper for recursive linear search method
     *
     * @param items The array being searched
     * @param target The object being searched for
     * @return The subscript of target if found; otherwise -1
     */
    public static int linearSearch(Object[] items, Object target) {
        return linearSearch(items, target, 0);
    }

    /**
     * Recursive linear search method
     *
     * @param items The array being searched
     * @param target The item being searched for
     * @param posFirst The position of the current first element
     * @return The subscript of target if found; otherwise -1
     */
    public static int linearSearch(Object[] items, Object target, int posFirst) {
        if(posFirst == items.length) {
            return -1;
        }

        else if(target.equals(items[posFirst])) {
            return posFirst;
        }

        else {
            return linearSearch(items, target, posFirst +1);
        }

    }

    /*
    A second approach to searching an array is called a binary search. Binary search
    can be performed only on an array that has been sorted. The stopping cases are the
    same as for linear search.
     */

                                                    // this should be zero for call count.
    public static double power(double x, double n) { /* Say we enter values 4 and 4 */
        // increments until stopping case.

        /* When the recursive call returns 0, we hit our base case. */
        if(n == 0) {
            return 1;
        }

        else {
            /* on the first call we return 4 * power(4, 3) * power(3, 2) * power (2, 1) */
            return x * power(x,n-1);
        }
    }

    /**
     * A recursive subtraction method.
     *
     * @param i the number being subtracted from.
     * @param j A number representing the amount of times needed to decrement i by 1.
     * @return return i - j
     */
    public static int recSub(int i, int j) {
        if (j <= 0) {
            return i;
        }
        else {
            i--;
            return recSub(i, (j-1));
        }
    }

}

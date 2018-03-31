package Programming;

/**
 * Programming Project 6, Chapter 6.
 */
public class RecursiveSubset {

    /*
    FIRST PART, determining whether a subset sum exists.

    Recursive Structure:
        consider the next element in the array
        try making a sum WITH this element
        try making a sum WITHOUT this element
        if neither is possible, return false.

    The next element is either in the solution or it is not. Try both ways, If both fail return false.

        - Need to keep track of the partial sum so far. When starting a recursive call, need to know the sum
        of the current subset. Also need to know the index of the next element to consider.

        maybe void recSubset(int[] a, int target, int i, int sumSoFar)
        i is the index of the next element, sumSoFar sum of elements included in the solution so far.

        most likely will need to utilize a wrapper method.
        boolean subsetSum(int[] a, int target) JUST AN EXAMPLE!
        {
            return recSubset(a, target, 0, 0);
        }

        designing a base case(s)

        // sum is true
        if(sumSoFar == target) return true;

        // we reached the end and sum is not equal to target
        if(i == a.length) return false;

        //recursive case: try next element both in and out of the sum
boolean with = recSubset(a, target, i+1, sumSoFar + a[i]);
boolean without = recSubset(a, target, i+1, sumSoFar);
return (with || without);
             OR

Source: http://www.bowdoin.edu/~ltoma/teaching/cs210/spring09/Slides/210-recursion2.pdf
     */
    public static void main(String[] args) {
        System.out.println("Hello From main!");

        System.out.println("11 ===> " + getDecimalFromBinary(11));
        System.out.println("110 ===> " + getDecimalFromBinary(110));

        System.out.println(Math.pow(2,2));
        System.out.println(power(2,2));
//        int answer = 0;
//
//        answer = power(5,5);
//        System.out.println(answer);
    }

    public static double power(int base, int power) {
        int result = 0;
        if(power == 1) {
            return base;
        }

        if(power == 0) {
            return 1;
        }

        for(int i = 1; i < power; i++) {
            result += base * base;
        }

        return result;
    }

    public static int getDecimalFromBinary(int binary) {
        int decimal = 0;
        int power = 0;

        while(true) {
            if(binary ==0) {
                break;
            }
            else {
                int number = binary % 10;
                decimal += number * power(2,power);
                binary = binary /10;
                power++;
            }
        }
        return decimal;
    }

}

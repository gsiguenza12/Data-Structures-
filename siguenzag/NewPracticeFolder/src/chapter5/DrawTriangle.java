package chapter5;

public class DrawTriangle {
    public static final int LIMIT = 20;

    public static final int ASTERISK = '*';
    /*
    Direct recursion is when a function calls itself recursively
    indirect recursion is when a function calls another function that
    returns the call to the first function... recursively.

    What is the difference between tailed and non-tailed recursion.
    */
                                    // maxStars?
    public static void indirectDraw(int peak, int height) {
//        System.out.println("value of n: " + n); // this executes n times.


        // Base criteria n <= 1, or in this case the recursive calls only execute so long as n is greater than one.
        if(peak > 1) {
//            System.out.println("Before recursive call");

                        // decrement n by 1 progressing closer to the base case.
            indirectDraw(peak-1, height); // recursive call
            indirectDraw(peak, height);
//            System.out.println("After recursive call\n");
            System.out.println(); // suspended execution resumes from the order placed on the stack frame.
        }

        // On the last recursive call, n is equal to 1, the activation frames resume, executing this for loop.
        // The last frame on the stack completes the statement above (System.out.println()) and so on until the first call
        // completes execution ending the loop and delivering the final result.
        for(int i = 0; i < peak; i++) {
            System.out.print("*"); // prints a star, then line above executes?
        }
//        indirectDraw2(n+1); // This activation frame is placed on the stack
//        System.out.println("Final statement"); //all suspended activation frames resume
//         until all the frames have completed processing.

    }

    /*
    What if I use the StringBuilder class and append,
    then in order to complete the triangle use one of the delete methods.
    */
                                                    // accumulated value
    public static void indirectDraw1(int x, int y, StringBuilder String) {
                        // peak on the x axis, height on the y axis



    }


}

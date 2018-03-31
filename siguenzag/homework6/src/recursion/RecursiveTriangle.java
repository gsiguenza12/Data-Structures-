package recursion;

public class RecursiveTriangle {


    public static void main(String[] args) {
    /*

    public static void message(int n) {
    int n = 0;

    stopping case or base case.
    if (n > 0) {

        print "recursive method, n = " + n
        message(n-1);
    }
    */

    drawTriangle(10, 0);

    }

    public static void printStar(int n) {
        while (n > 0) {
            System.out.print('*');
            n--;
        }
    }

    /**
     *
     *
     * @param x
     * @param n
     */
    public static void drawTriangle(int x, int n) {
        if (n == 0) {

        }
        System.out.println("In triangle method");

        for(int i = 0; i < x; i++) {
            printStar(x);
        }
        /*char star = '*';

        StringBuilder triangle = new StringBuilder();

        for(int i = 0; i < width; i++) {
            while(indexStart < width) {
                triangle.append(star);
                System.out.print(star);
                indexStart++;
            }
        }*/
    }
}

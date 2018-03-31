package lab1;

import java.util.Stack;
/**
 * A program that demonstrates the use of a Stack data structure in Java API to
 * reverse the order of Characters in a string.
 *
 * @author gabrielsiguenza
 */
public class Reverser {

    public static void main(String[] args) {
        StringBuilder aString = new StringBuilder();
        StringBuilder result = new StringBuilder();

        aString.append("This is a string");

        System.out.println("This is your original String: \n\"" + aString + "\"");

        Stack<Character> aStack = new Stack<>();

        for(int i = 0; i < aString.length(); i++) {
            aStack.push(aString.charAt(i));
        }

        while(!aStack.empty()) {
            result.append(aStack.pop());
        }

        System.out.println("\nUsing a Stack data struct to re-build string...\n"
                + "This is the result:\n\"" + result + "\"");
    }


}

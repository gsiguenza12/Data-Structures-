package lab2;

import java.util.ArrayList;

/**
 * Programming Project 3, pg. 191
 * Provide a complete implementation of class ArrayStack and test it
 * on each of the applications in this chapter.
 * Use ArrayList. Use your new stack to implement Lab1.
 */
public class ArrayListStack<E> {

    /*** Instance variables ***/
    private ArrayList<E> theList = new ArrayList<>();

    /*** Methods ***/
    public void add(E item) {
        theList.add(item);
    }

    /**
     * Accesses ArrayList instance variable's size value.
     *
     * @return size of the list.
     */
    public int size() {
        return theList.size();
    }

    /**
     * Returns true if the stack is empty; otherwise returns false.
     *
     * @return
     */
    public boolean empty() {
        return theList.isEmpty();
    }

    /**
     * Returns the object at the top of the stack.
     *
     * @return
     */
    public E peek() {
        return theList.get(size()-1); // this throws outOfBoundsException
    }

    /**
     * Returns the object at the top of the stack and removes it.
     *
     * @return
     */
    public E pop() {
        E temp = peek();
        theList.remove(theList.size()-1);
        return temp;
    }

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj
     * @return
     */
    public E push(E obj) {
        E temp = obj;
        theList.add(obj);
        return temp;
    }


    @Override
    public String toString() {
        return "ArrayListStack{" +
                "theList=" + theList +
                '}';
    }

    public static void main(String[] args) {
        StringBuilder aString = new StringBuilder();
        StringBuilder result = new StringBuilder();

        aString.append("This is a string");

        System.out.println("This is your original String: \n\"" + aString + "\"");

        ArrayListStack<Character> aStack = new ArrayListStack<Character>();

        for(int i = 0; i < aString.length(); i++) {
            aStack.push(aString.charAt(i));
        }

        System.out.println("Your stack contains: " + aStack);

        System.out.println("Your stack size: " + aStack.size());

        while(!aStack.empty()) {
            result.append(aStack.pop());
        }

        System.out.println("\nUsing a Stack data struct to re-build string...\n"
                + "This is the result:\n\"" + result + "\"");
    }


}


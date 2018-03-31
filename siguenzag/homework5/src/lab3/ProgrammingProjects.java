package lab3;

/************************************************
 * COURSE:			  CS113 M 5:30-9:30pm
 * CHAPTER:			  3
 * PROGRAMMER: 		  Gabriel Siguenza
 * DATE LAST MODIFIED: 02.28.2018
 ************************************************/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1. Write a main function that creates two stacks of Integer objects and a queue of Integer
 * objects. Store the numbers; -1,15,23,44,4,99 in the first stack. The top of the stack should store 99.
 *
 * 2. Write a loop to get each number from the first stack and store it in the second stack and in the queue.
 *
 * 3. Write a second loop to remove a value from the second stack and from the queue and display each pair of
 * values on a separate output line. Continue until the data structures are empty. Show the output.
 *
 * @author gabrielsiguenza
 */
public class ProgrammingProjects {

    public static void main(String[] args) {
        Stack<Integer> intStack1, intStack2;
        Queue<Integer> intQueue;

        intStack1 = new Stack<>();
        intStack2 = new Stack<>();
        intQueue = new LinkedList<>();

        // Store the numbers; -1,15,23,44,4,99 in the first stack.
        intStack1.push(-1);
        intStack1.push(15);
        intStack1.push(23);
        intStack1.push(44);
        intStack1.push(4);
        intStack1.push(99);

        System.out.println("Outputting integers held in the first stack: " + intStack1);

        System.out.println("\nTesting peek method to grab \"top\" element:");
        System.out.println(intStack1.peek());

        // Write a loop to get each number from the first stack and store it in the second stack and in the queue.
        System.out.println("\nRunning first loop, popping elements from first stack into the second stack:");

        while (!intStack1.isEmpty()) {
            // store the numbers from the first stack into the second stack.
            // store them into the queue.
            intQueue.offer(intStack2.push(intStack1.pop()));
            /* Remember that queue has access to the methods in Vector, Queue has only 5 methods: element, offer, remove, poll, peek */

        }

        System.out.println("\nContents of second stack: " + intStack2 + "\n\nContents of Queue: " + intQueue);

        System.out.println("\nTesting peek method:\n" + intQueue.peek());

        System.out.println("\nRunning second loop to remove elements from Stack and Queue:\n");
        // Write a second loop to remove a value from the second stack and from the queue and display each pair of
        // values on a separate output line. Continue until the data structures are empty. Show the output.
        while (intQueue.poll() != null && intStack2.pop() != null) {
            System.out.println("Contents of Stack: " + intStack2);
            System.out.println("Contents of Queue: " + intQueue);

        }

    }

}

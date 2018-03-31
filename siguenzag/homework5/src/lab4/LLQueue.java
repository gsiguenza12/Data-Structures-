package lab4;

/************************************************
 * COURSE:			  CS113 M 5:30-9:30pm
 * CHAPTER:			  3
 * PROGRAMMER: 		  Gabriel Siguenza
 * DATE LAST MODIFIED: 02.28.2018
 ************************************************/

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implement Queue using the LinkedList as a field of the Queue class. You may use methods from
 * the LinkedList class but not any of the Queue methods that are available to LL.
 *
 * Methods (offer, remove, poll, peek, element).
 * @author gabrielsiguenza
 */
public class LLQueue<E> {

    /** Instance variable **/
    LinkedList<E> linkedListQueue;

    /**
     * Default Constructor
     */
    public LLQueue() {
        linkedListQueue = new LinkedList<>();
    }

    /**
     * Inserts the specified element into the queue if possible, returns true upon success and throws an
     * An IllegalStateException if no space is currently available.
     *
     * @param element The element to add
     * @return Returns true if the element was added, else returns false.
     * @throws IllegalStateException
     * @throws NullPointerException
     * @throws ClassCastException
     */
    public boolean add(E element) {
        linkedListQueue.addFirst(element);
        return true;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return The head of this queue.
     * @throws java.util.NoSuchElementException
     */
    public E element() {
        if(!linkedListQueue.isEmpty()) {
            return linkedListQueue.getFirst();
        }
        else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Inserts the specified element into this queue if it is possible
     * to do so immediately without violating capacity restrictions.
     *
     * @param element
     * @return
     * @throws ClassCastException
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    public boolean offer(E element) {
        linkedListQueue.addLast((E)element);
        return true;

    }

    /**
     * Returns the item at the front of the queue without removing it.
     *
     * @return The item at the front if successful; null if not.
     */
    public E peek() {
        if(linkedListQueue.size() == 0) {
            return null;
        }
        else {
            return linkedListQueue.getFirst();
        }
    }

    /**
     * Removes the entry at the front of the queue and returns it.
     *
     * @return The item removed if successful, or null if not
     */
    public E poll() {
        if(linkedListQueue.size() == 0) {
            return null; // return null if queue is empty, and there is
            // no item to remove.
        }
        else {
            return linkedListQueue.remove(0); // remove the first element
        }
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of the queue.
     * @throws java.util.NoSuchElementException
     */
    public E remove() {
        if(linkedListQueue.getFirst() == null) {
            throw new NoSuchElementException();
        }
        else {
            return linkedListQueue.remove(0);
        }
    }

    @Override
    public String toString() {
        return "LLQueue " +
                "linkedListQueue = " + linkedListQueue;
    }

    /**
     * Tests for an empty Queue
     *
     * @return Returns false if Queue contains at least one element, true otherwise.
     */
    public boolean isEmpty() {
        return linkedListQueue.size() == 0;
    }

}

package chapter4;


import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implements the Queue interface using a circular array.
 *
 * @author gabrielsiguenza
 * @author Koffman & Wolfgang
 */
public class ArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
    /** Constants **/
    private static final int DEFAULT_CAPACITY = 10;

    /** Instance variables **/
    private int front; // index of front.
    private int rear; // index of rear.
    private int size; // number of elements in Queue.
    private int capacity; // actual size of array.
    private E[] theData; // A generic Array to hold the data items.

    /*
    Attempted to instantiate instance variables and got a nullpointer exception.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        capacity = DEFAULT_CAPACITY;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public E[] getTheData() {
        return theData;
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initCapacity) {
        this.size = 0;
        front = 0;
        theData = (E[]) new Object[initCapacity];
        rear = capacity - 1;
        capacity = initCapacity;
    }


    /* What about Iterator<E> iterator? */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * Inserts an item at the rear of the queue.
     * post: item is added to the rear of the queue.
     *
     * @param item The element to add
     * @return true (always successful)
     */
    @Override
    public boolean offer(E item) {
        if(size == capacity) {
            reallocate();
        }
        System.out.println("After reallocate if statement");
        size++;
        System.out.println("After size ++");
        rear = (rear + 1) % capacity;
        System.out.println("After assignment to rear");

        theData[rear] = item;
        System.out.println("After inserting item at rear");
        return true;
    }

    /**
     * Removes the entry at the font of the queue and returns it
     * if the queue is not empty.
     * post: front references item that was second in the queue.
     *
     * @return The item removed if successful or null if not.
     */
    @Override
    public E poll() {
        if(size == 0) {
            return null;
        }
        E result = theData[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    @Override
    public E peek() {
        return null;
    }

    /**
     * Double the capacity and reallocate the data.
     * pre: The array is filled to capacity.
     * post: The capacity is doubled and the first
     * half of the expanded array is filled with data.
     */
    @SuppressWarnings("unchecked")
    private void reallocate() {
        int newCapacity = 2 * capacity;
        E[] newData = (E[]) new Object[newCapacity];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = theData[j];
            j = (j + 1) % capacity;
        }
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        theData = newData;
    }

    private class Iter implements Iterator<E> {
        private int index;

        private int count = 0;

        public Iter() {
            index = front;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = theData[index];
            index = (index + 1) % capacity;
            count++;
            return returnValue;
        }

        /**
         * Remove the item accessed by the Iter object - not implemented.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}

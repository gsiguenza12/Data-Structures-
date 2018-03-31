/*<listing chapter="2" section="8">*/

package Siguenza_Gabriel_HW4;

// LinkedList<E> in the java api extends AbstractSequentialList<E>
// In KWLinkedList we are essentially replacing the class with our own modified version.

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Class Siguenza_Gabriel_HW4.KWLinkedList implements a double linked list and
 * a ListIterator.
 *
 * @author Koffman & Wolfgang
 * @author gabrielsiguenza
 **/

/*
 * An Ordered list class has the heading: ...class Ordered<E extends Comparable<E>> implements Iterable<E>
 * and has a private instance variable of a generic LinkedList<E> type.
 * private LinkedList<E> theList = new LinkedList<E>()
 */
public class KWLinkedList<E> extends AbstractSequentialList<E> implements List<E> {
    // Already implements List? So must provide listIterator method, see @Override.

    // Data Fields
    /**
     * A reference to the head of the list.
     */
    private Node<E> head;

    /**
     * A reference to the end of the list.
     */
    private Node<E> tail;
    /**
     * The size of the list.
     */
    private int size;

    public KWLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public KWLinkedList(Node<E> head, Node<E> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public Node<E> getHead() {
        return this.head;
    }

    public Node<E> getTail() {
        return this.tail;
    }

    public void setHead(Node<E> head) {
        this.head = new Node<E>(head.data, head.next, head.prev);
    }

    public void setTail(Node<E> tail) {
        this.tail = new Node<E>(tail.data, tail.next, tail.prev);
    }

    public void setAll(Node<E> head, Node<E> tail) {
        this.setHead(head);
        this.setTail(tail);
    }

    public void addFirst(E item) {
        add(0, item);
    }

    public void addLast(E item) {
        add(this.size, item);
    }

    public Node<E> getNode(int index) {
        Node<E> node = head;
        int i = 0;
        while (i < index && node != null) {
            node = node.next;
            i++;
        }
        return node;
    }

    //Methods
// Insert solution to programming exercise 4, section 8, chapter 2 here

// Insert solution to programming exercise 3, section 8, chapter 2 here

// Insert (indexOf) solution to programming exercise 1, section 7, chapter 2 here

    public int indexOf() {
        // Example 2.14
        /*ListIterator<String> myIter = myList.iterator();
         * while(myIter.hasNext()) {
         * if(target.equals(myIter.next()) {
         *  myIter.set(newItem);
         *  break;
         *  }
         * }
         */
        return 0;
    }

    /*
    count = 0;
    for(String next Str : myList) {
        if(target.equals(nextStr)) {
            count++;
        }
     }

     I believe you can use this enhanced for loop outside of the class on an object that implements listIterator.
     Inside the class you can't use this because the class overrides LinkedList in java api, so there is no instance
     variable of type LinkedList<E> to use in the enhanced for loop for this implementation. (works for OrderedList class)
     */

    // Insert (lastIndexOf) solution to programming exercise 2, section 7, chapter 2 here
    @Override
    public int lastIndexOf(Object o) {
        KWListIter iterator;
        // ListIterator interface enforces a
        // contract that binds the return type of the listIterator method so this is how we
        // instantiate the KWListIter
        iterator = (KWListIter) listIterator(size);

        while (iterator.hasPrevious()) {
            if (iterator.previous() == o) {
                return iterator.index;
            }
            iterator.index++;
        }

        //missing case here
        return -1;
    }

    // Insert(indexOfMin) solution to programming exercise 3, section 7, chapter 2 here


    //    /**
//     * Section 2.8, pg.113, KWLinkedList implements some of the methods of the list interface using
//     * a double linked list.
//     *
//     * Add an item at the specified index.
//     *
//     * @param index The index at which the object is to be inserted
//     * @param element The object to be inserted
//     * @throws IndexOutOfBoundsException if index is out of range (i < 0 || i > size())
//     */
    @Override
    public void add(int index, E element) {
        listIterator(index).add(element); // the method listIterator(index) anonymous listIterator object
    }

    /*
     * Look closely at these two methods, the above is how you would normally call the listIterator,
     * we needed to modify the add method to use the list iterator since we cannot have both.
     * An error would be thrown if the list iterator was called and we attempted to traverse
     * and modify the list at the same time as the iterator object. (or something like that, I think)
     * So in order to use our version of ListIterator (KWListIter) We need to override our ListIterator<E> listIterator(int index)
     * we need to fulfill the contract but in order to get around this we return a new ListIterator<E> object returned from our
     * KWListIter class. Demonstrated below (Disclaimer:) Not sure if this is correct!
     */

    /*********** THIS FIXED IT ************/
    @Override
    public ListIterator<E> listIterator(int index) {
        return new KWListIter(index);
    }

    /* class extends AbstractSequential and implements list so is a complete implementation */
//    /**
//     * Get the element at position index.
//     * @param index Position of item to be retrieved
//     * @return The item at index
//     */
//    @Override
//    public E get(int index) {
//        if (isEmpty()) {
//            throw new IndexOutOfBoundsException();
//        }
//        else if (index >= this.size) { //index starts at 0, if index is larger than size and if index is equal to size throw exception.
//            throw new IndexOutOfBoundsException();
//        }
//        else if(index < 0) { // index passed is a negative value
//            throw new IndexOutOfBoundsException();
//        }
//        else {
//            return listIterator(index).next(); // replaces get method using the listIterator.
//        }
//    }

    /**
     * Return the size of the list
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /*
    Attempting to write toString to ensure newItems are being added at the correct positions of
    KWLinkedList.
     */
    public String toString() {
        Node<E> nodeRef = head;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (nodeRef != null) {
            result.append(nodeRef.data);
            if (nodeRef.next != null) {
                result.append(", ");
            } else if (nodeRef == null) {
                return "[]";
            }
            nodeRef = nodeRef.next;
        }
        result.append("]");
        return result.toString();
        // check conventional toString used by SingleLinkedList.

        // ListIterator interface enforces a
        // contract that binds the return type of the listIterator method so this is how we
        // instantiate the KWListIter
//        iterator = (KWListIter) listIterator(size);
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
    }

    /* INNER CLASSES */

    /**
     * A Node is the building block for a double-linked list.
     */
    private static class Node<E> {

        /**
         * The data value.
         */
        private E data;
        /**
         * The link to the next node.
         */
        private Node<E> next = null;
        /**
         * The link to the previous node.
         */
        private Node<E> prev = null;

        /**
         * Construct a node with the given data value.
         *
         * @param dataItem The data value
         */
        public Node(E dataItem) {
            this.data = dataItem;
            this.next = null;
            this.prev = null;
        }

        public Node(E data, Node<E> next, Node<E> prev) {
            super();
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    } //end class Node

    /*** Implement the KWListIter Remove method, Implement the set method, implement the listIterator and iterator methods.
     */

    /* Inner class to implement the ListIterator interface. because ListIterator is a sub-interface of
     * Iterator, Classes that implement the ListIterator interface must provide the capabilities of both.*/
    public class KWListIter implements ListIterator<E> {

        /**
         * A reference to the next item.
         */
        private Node<E> nextItem;
        /**
         * A reference to the last item returned.
         */
        private Node<E> lastItemReturned;
        /**
         * The index of the current item.
         */
        private int index = 0;


        /**
         * Default constructor
         */
        public KWListIter() {
            lastItemReturned = null;
            index = 0;
            if(hasNext()) {
                nextItem = head;
            }
            else {
                nextItem = null;
            }
        }

        /**
         * Construct a KWListIter that will reference the ith item.
         *
         * @param i The index of the item to be referenced
         */
        public KWListIter(int i) {
            // Validate i parameter.
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == size) {
                index = size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }


        /**
         * Construct a KWListIter that is a copy of another KWListIter
         *
         * @param other The other KWListIter
         */
        public KWListIter(KWListIter other) {
            KWListIter itr = new KWListIter(0);
            itr.index = other.index;
            itr.lastItemReturned = other.lastItemReturned;
            itr.nextItem = other.nextItem;
        }

        /**
         * Indicate whether movement forward is defined.
         *
         * @return true if call to next will not throw an exception
         */
        @Override
        public boolean hasNext() {
//            System.out.println("Current index is: " + index);
            return nextItem != null;
        }

        /**
         * Move the iterator forward and return the next item.
         *
         * @return The next item in the list
         * @throws NoSuchElementException if there is no such object
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
//            System.out.println("Current index is: " + index);
            return lastItemReturned.data;
        }

        /**
         * Indicate whether movement backward is defined.
         *
         * @return true if call to previous will not throw an exception
         */
        @Override
        public boolean hasPrevious() {
//            System.out.println("Current index is: " + index);
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /**
         * Return the index of the next item to be returned by next
         *
         * @return the index of the next item to be returned by next
         */
        @Override
        public int nextIndex() {
//            System.out.println("Current index is: " + index);
            if (!hasNext()) {
                return size;
            } else {
                return index + 1;
            }
        }


        /**
         * Return the index of the next item to be returned by previous
         *
         * @return the index of the next item to be returned by previous
         */
        @Override
        public int previousIndex() {
//            System.out.println("Current index is: " + index);
            if (!hasPrevious()) {
                return -1;
            } else {
                return index - 1;
            }
        }
        // Insert solution to programming exercise 1, section 8, chapter 2 here


        @Override
        public void remove() {
//            System.out.println("Current index is: " + index);
            if (!hasNext()) {
                getTail().prev.next = null;
            } else if (nextItem.prev.prev == null) {
                head = nextItem;
            } else {
                nextItem.prev.prev.next = nextItem;
                nextItem.prev = nextItem.prev.prev.next;
            }
        }

        // Insert solution to programming exercise 2, section 8, chapter 2 here


        @Override
        public void set(E e) {
            lastItemReturned.data = e;
        }

        /**
         * Move the iterator backward and return the previous item.
         *
         * @return The previous item in the list
         * @throws NoSuchElementException if there is no such object
         */
        @Override
        public E previous() {
//            System.out.println("Current index is: " + index);
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator past the last element
                nextItem = tail;
            } else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        /**
         * Add a new item between the item that will be returned
         * by next and the item that will be returned by previous.
         * If previous is called after add, the element added is
         * returned.
         *
         * @param obj The item to be inserted
         */
        @Override
        public void add(E obj) {
//            System.out.println("Current index is: " + index);

            if (head == null) { // Add to an empty list.
                head = new Node<E>(obj);
                tail = head;
            } else if (nextItem == head) { // Insert at head.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 1
                // Link nextItem to the new node.
                nextItem.prev = newNode; // Step 2
                // The new node is now the head.
                head = newNode; // Step 3
            } else if (nextItem == null) { // Insert at tail.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link the tail to the new node.
                tail.next = newNode; // Step 1
                // Link the new node to the tail.
                newNode.prev = tail; // Step 2
                // The new node is the new tail.
                tail = newNode; // Step 3
            } else { // Insert into the middle.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to nextItem.prev.
                newNode.prev = nextItem.prev; // Step 1
                nextItem.prev.next = newNode; // Step 2
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 3
                nextItem.prev = newNode; // Step 4
            }
            // Increase size and index and set lastItemReturned.
            size++;
            index++;
            lastItemReturned = null;
//            }
        } // End of method add.


    } //end class KWListIter

    /* END OF INNER CLASSES */

// Insert solution to programming exercise 1, section 6, chapter 2 here
} /* END OF CLASS KWLINKEDLIST */
/*</listing>*/

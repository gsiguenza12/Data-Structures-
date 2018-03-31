import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ListIterator;

public class DoubleLinkedList<E> implements List<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;

    //toString
    /**
     *
     * @return A string that reads the data in our Double LinkedList
     */
    public String toString()
    {
        Node<E> nodeRef = head;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (nodeRef != null) {
          result.append(nodeRef.data);
          if(nodeRef.next != null) {
              result.append(", ");
          }
          else if(nodeRef == null) {
              return "[]";
          }
          nodeRef = nodeRef.next;
        }
        result.append("]");
        return result.toString();
    }

//Constructors
    //Default Constructor
    /**
     * Default Constructor that sets the default values for our Double LinkedList
     */
    public DoubleLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    //Full Constructor
    /**
     * This will set the data within the method parameters into our Double LinkedList
     * @param head
     * @param tail
     * @param size
     */
    public DoubleLinkedList(Node<E> head, Node<E> tail, int size)
    {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }
    //Copy Constructor
    /**
     * Copy Constructor for DoubleLinkedList
     * <p>
     * Original DoubleLinkedList is checked for null
     * <p>
     * @param original	theDoubleLinkedList to be copied
     */
    public DoubleLinkedList(DoubleLinkedList<E> original){
        if(original == null){
            System.err.println("ERROR: DoubleLinkedList Copy Constuctor passed null.");
        }
        else {
            this.setAll(original.head, original.tail, original.size);
        }
    }

//GETTERS
    /**
     * Will return the size of the Double Linked List
     * @return size
     */
    public int getSize()
    {
        return this.size;
    }

    /**
     * Will return the head of the Double Linked List
     * @return head
     */
    public Node<E> getHead() {
        return this.head;
    }

    /**
     * THis will return the Tail of the Double Linked List
     * @return tail
     */
    public Node<E> getTail() {
        return this.tail;
    }
//SETTERS

    /**
     * This will set the head of the Double Linked List
     * @param head
     */
    public void setHead(Node<E> head) {
        this.head = new Node<E>(head.data, head.next, head.previous);
    }

    /**
     * Sets the tail for the Double Linked List
     *
     * @param tail	the tail of the Double Linked List
     */
    public void setTail(Node<E> tail) {
        this.tail = new Node<E>(tail.data, tail.next, tail.previous);
    }

    /**
     * This will set the size of the Double Linked List
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Sets all instance variables for DoubleLinkedList
     *
     * @param head	the head of the DoubleLinkedList
     * @param tail	the tail of the DoubleLinkedList
     * @param size	the size of the DoubleLinkedList
     */
    public void setAll(Node<E> head, Node<E> tail, int size) {
        this.setHead(head);
        this.setTail(tail);
        this.size = size;
    }

    /**
     * Adds a Node to the beginning of the list
     * @param item (the item to be added)
     */
    public void addFirst(E item) {
        add(0, item);
    }
    /**
     * Adds a Node to the end of the list
     * @param item (the item to be added)
     */
    public void addLast(E item) {
        add(this.size, item);
    }
    /**
     * Gets the Node at a given index
     * <p>
     * Traverses the list and returns the element after N (index) iterations
     * <p>
     * @param index (the index of the wanted Node)
     * @return Node<E> node  (the node for the specified index)
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;
        int i = 0;
        while(i < index && node != null) {
            node = node.next;
            i++;
        }
        return node;
    }
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean contains(Object o) {
        DoubleListIterator iterator;
        iterator = (DoubleListIterator) listIterator(0);

        while (iterator.hasNext()) {
            if(iterator.next() == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    //Don't do this method
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    //Don't do this method
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(!contains(o)) {
            return false;
        } else {
            remove(indexOf(o));
            return true;
        }
    }

    //Don't do this method
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    //Don't do this method
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    //Don't do this method
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    //Don't do this method
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    //Don't do this method
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public E get(int index) {
        return listIterator(index).next();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new
                    IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = element;
        return result;
    }

    @Override
    public void add(int index, E element) {
        listIterator(index).add(element);
    }

    @Override
    public E remove(int index) {
        E removed = listIterator(index).next();
        listIterator(index + 1).remove();
        return removed;
    }

    @Override
    public int indexOf(Object o) {
        DoubleListIterator iterator;
        iterator = (DoubleListIterator) listIterator(0);

        while (iterator.hasNext()) {
            if(iterator.next() == o) {
                return iterator.previousIndex();
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        DoubleListIterator iterator;
        iterator = (DoubleListIterator) listIterator(size);

        while (iterator.hasPrevious())
        {
            if(iterator.previous() == o)
            {
                return iterator.index;
            }
            iterator.index++;
        }

        //missing case here
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new DoubleListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new DoubleListIterator(index);
    }
    //Don't do this method
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        DoubleLinkedList<E> other = (DoubleLinkedList<E>) o;

        return this.size == other.size && this.head == other.head &&
                this.tail == other.tail;
    }

    //Static Node Inner Class
    private static class Node<E>{
        //Instance Variables
        private E data;
        private Node<E> next = null;
        private Node<E> previous = null;

        //Constructors
        public Node(E dataItem)
        {
            this.data = dataItem;
            this.next = null;
            this.previous = null;
        }
        public Node(E data, Node<E> next, Node<E> prev)
        {
            super();  //Going to use the constructor for the base class since Node can be of any type
            this.data = data;
            this.next = next;
            this.previous = prev;
        }

        @Override
        public String toString()
        {
            return data.toString();

        }
    }//End of the Node Inner Class

    //Double List Iterator Class
    private class DoubleListIterator implements ListIterator<E>{
        private Node<E> nextItem = null;
        private Node<E> lastItemReturned = null;
        private int index;

        public DoubleListIterator() {
            lastItemReturned = null;
            index = 0;
            if(hasNext())
            {
                nextItem = head;
            } else {
                nextItem = null;
            }
        }

        public DoubleListIterator(int i) {
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }
            lastItemReturned = null;

            if (i == size) {
                index = size;
                nextItem = null;
            } else {
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size != 0)
                    || nextItem.previous != null;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator past the last element
                nextItem = (Node<E>) tail;
            } else {
                nextItem = nextItem.previous;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        @Override
        public int nextIndex() {
            if (!hasNext()) {
                return size;
            } else {
                return index + 1;
            }
        }

        @Override
        public int previousIndex() {
            if (!hasPrevious()) {
                return -1;
            } else {
                return index - 1;
            }
        }

        @Override
        public void remove() {
            if (!hasNext()) {
                getTail().previous.next = null;
            } else if(nextItem.previous.previous == null) {
                head = nextItem;
            } else {
                nextItem.previous.previous.next = nextItem;
                nextItem.previous = nextItem.previous.previous.next;
            }
        }

        @Override
        public void set(E e) {
            lastItemReturned.data = e;
        }

        @Override
        public void add(E e) {
            if (head == null) { // Add to an empty list.
                head = new Node<E>(e);
                tail = head;
            }
            else if (nextItem == head) {
                Node<E> newNode = new Node<E>(e);
                newNode.next = nextItem;
                nextItem.previous = newNode;
                head = newNode;
            }
            else if (nextItem == null) {
                Node<E> newNode = new Node<E>(e);
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
            else {
                Node<E> newNode = new Node<E>(e);
                newNode.previous = nextItem.previous;
                nextItem.previous.next = newNode;
                newNode.next = nextItem;
                nextItem.previous = newNode;
            }
            size++;
            index++;
            lastItemReturned = null;
        }
    }
}

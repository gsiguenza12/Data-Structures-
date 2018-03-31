package chapter3;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Objects;

public class ArrayListStack<E> implements StackInterface<E>{
    //Instance Variables
    private ArrayList<E> theData;


    //Constructors
        //Full Constructor
    /**
     * Passes through theData ArrayList<E> and assigns it to this.theData
     * @param theData
     */
    public ArrayListStack(ArrayList<E> theData) {
        this.theData = theData;
    }
        //Default Constructor
    /**
     * Instantiates a new ArrayList for this.theData
     */
    public ArrayListStack() {
        this.theData = new ArrayList<>();
    }

    /**
     * Retrieves the ArrayList<E> theData
     * @return the ArrayList<E> theData
     */
    public ArrayList<E> getTheData() {
        return theData;
    }

    /**
     * Sets the parameter ArrayList<E> theData to this.theData
     * @param theData
     */
    public void setTheData(ArrayList<E> theData) {
        this.theData = theData;
    }


    public String toString() {
        return "ArrayListStack{" +
                "theData=" + theData +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListStack<?> that = (ArrayListStack<?>) o;
        return Objects.equals(theData, that.theData);
    }

    @Override
    public boolean empty() {
        if (this.theData.size() > 0) {
            return false;
        } else {
            return (this.theData.size() == 0);
        }
    }

    @Override
    public E peek() {
        if(empty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return theData.get(theData.size() - 1);
        }
    }

    @Override
    public E pop() {
        if(empty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return theData.remove(theData.size() - 1);
        }
    }

    @Override
    public E push(E obj) {
        this.theData.add(obj);
        return obj;
    }
}

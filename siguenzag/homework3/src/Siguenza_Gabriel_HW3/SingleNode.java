package Siguenza_Gabriel_HW3;

import java.util.LinkedList;

public class SingleNode<E> {
    public SingleNode next;

    private E info;

    //Constructors
    public SingleNode()
    {
        next = null;

        info = null;
    }

    private SingleNode(SingleNode next, SingleNode prev, E data)
    {
        this.next = next;

        info = data;
    }

    private SingleNode(E data)
    {
        next = null;

        info = data;
    }


    //Add to head
    public void addHead(E data)
    {
        SingleNode temp;

        if(next == null)
        {
            next = new SingleNode(data);
        }
        else
        {
            temp = next;

            next = new SingleNode(data);
            next.next = temp;

        }
    }

    //Add to tail
    public void add(E data)
    {
        SingleNode temp;

        if(next == null)
        {
            next = new SingleNode<E>(data);
        }
        else
        {
            temp = next;

            while(temp != null)
            {
                if(temp.next == null)
                {
                    temp.next = new SingleNode<E>(null, temp, data);
                    temp = temp.next;
                    //System.out.println(temp.prev.toString());
                    break;
                }
                else
                    temp = temp.next;
            }
        }
    }

    //Display Items
    public void DisplayAll()
    {
        if(next != null)
        {
            SingleNode temp = next;

            int count = 0;

            while(temp != null)
            {
                System.out.println(count + " " + temp.toString());

                count++;
                temp = temp.next;
            }
        }
        else
            System.out.println("List is empty");
    }

    //Remove index
    public void RemoveHead(int index)
    {
        next = next.next;
    }


    public void remove(String name)
    {
        String returnedName = "";
        Student student = null;

        SingleNode head = next;

        if(next != null)
        {
            SingleNode temp = next;

            int count = 0;

            while(temp.next != null)
            {
                student = (Student)temp.info;
                returnedName = student.getName();

                if(name.equals(returnedName))
                {
                    System.out.println("****Found it****");
                    head = temp.next;

                }

                count++;
                temp = temp.next;
            }

        }
        else
            System.out.println("List is empty");
    }


    LinkedList<E> a = new LinkedList<>();

}//End of DoublyNode

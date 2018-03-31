package Siguenza_Gabriel_HW3;

//Use linked list.
/************************************************
 * COURSE:			  CS113 M 5:30-9:30pm
 * CHAPTER:			  2
 * PROGRAMMER: 		  Gabriel Siguenza
 * DATE LAST MODIFIED: 02.16.2018
 ************************************************/

/**
 * Write a program to manage a list of students waiting to register
 * for a course as described in section 2.5. Operations should include
 *
 * adding a new student at the end of the list,
 * adding a new student at the beginning of the list,
 * removing the student from the beginning of the list,
 * and removing a student by name.
 *
 * Include a text file that states the running time for each of the four operations listed above.
 */

public class StudentList
{
    public static void main(String[] args)
    {
        //Creating variables
        SingleNode SList = new SingleNode();
        String[] students = {"Brian", "Priscilla", "James", "Caitlyn", "Carl", "Kim", "Lauren", "Jesse"};

        //Populating list
        for(String names: students)
            SList.add(new Student(names));

        SList.DisplayAll();

        //Adding to head of list
        SList.addHead(new Student("Doug the Head"));

        System.out.println("\nAdded new head\n");

        SList.DisplayAll();

        //Adding to tail
        SList.add(new Student("Jim the Tail"));

        System.out.println("\nAdded new tail\n");
        SList.DisplayAll();

        //Removing the head
        SList.RemoveHead(0);

        System.out.println("\nRemoved Head\n");
        SList.DisplayAll();


        //Removing the student by name
        SList.remove("Caitlyn");

        System.out.println("\nRemoved Caitlyn\n");
        SList.DisplayAll();
        //

    }
}

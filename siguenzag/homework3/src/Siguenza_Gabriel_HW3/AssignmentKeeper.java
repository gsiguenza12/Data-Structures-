package Siguenza_Gabriel_HW3;


// import packages needed
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/************************************************
 * COURSE:			  CS113 M 5:30-9:30pm
 * CHAPTER:			  2
 * PROGRAMMER: 		  Gabriel Siguenza
 * DATE LAST MODIFIED: 02.16.2018
 ************************************************/

/**
 * An assignment tracking program using ArrayList to create a task completion list of
 * homework assignments.
 *
 * Include a text file that states the running time for each of the four operations listed below.
 *
 * Algorithm:
 * 1. Add a new assignment
 * 2. Remove an assignment
 * 3. Provide a list of the assignments in the order they were assigned
 * 4. Find the assignments with the earliest due date.
 *
 * @author gabrielsiguenza
 */
public class AssignmentKeeper {

    // constant variables
    public static final String DATE_FORMAT = "MM/dd/yy";

    public static void main(String[] args) {

        // variable declaration
        ArrayList<HwAssignment> hwList = new ArrayList<>();
        Scanner key = new Scanner(System.in);
        String input;
        int option, month, day, year;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
        String currentDate = dtf.format(java.time.LocalDate.now());

        // construct menu
        do {
            option = readInt("1. View assignments\n" + "2. Add a new assignment\n" +
                    "3. Remove an assignment\n" +
                    "4. Provide a list of the assignments in the order they were assigned\n" +
                    "5. Find the assignments with the earliest due date.\n0. Exit\nInput Selection(0 - 5): ", key, 0, 5);

            switch (option) {
                case 1:
                    displayAssignments(hwList, currentDate);
                    break;

                case 2:
                /*
                // uncomment to display current assignments to user prior to adding new assignment.
                displayAssignments(hwList, currentDate);
                */
                    System.out.println("\nCreate new assignment");
                    System.out.println("-----------------------");
                    hwList.add(new HwAssignment());
                    System.out.println("Date Assigned: " + currentDate);
                    System.out.print("Press enter for today's date or start typing a new date(MM/dd/yy).\n");

                    // SET DATE ASSIGNED
                    // input should be in a while loop to handle errors and
                    // allow subsequent attempts.
                    input = key.nextLine();
                    if (input.isEmpty()) {
                        buildFromString(hwList, currentDate);
//                    displayAssignments(hwList,currentDate);

//                    String[] values = currentDate.split("/");
//                    month = Integer.parseInt(values[0]);
//                    day = Integer.parseInt(values[1]);
//                    year = Integer.parseInt(values[2]);
//
//                    hwList.get(hwList.size()-1).setDateAssigned(new Date(month,day,(2000 + year)));
//
//                    displayAssignments(hwList,currentDate);
                    } else {
                        buildFromString(hwList, input);
                        System.out.println("*assignment date changed*");
                        System.out.println("Date Assigned: " + hwList.get(hwList.size() - 1).dateAssigned);

//                    displayAssignments(hwList,currentDate);

                    /*String[] values = input.split("/");
                    month = Integer.parseInt(values[0]);
                    day = Integer.parseInt(values[1]);
                    year = Integer.parseInt(values[2]);

                    hwList.get(hwList.size()-1).setDateAssigned(new Date(month,day,(2000 + year)));*/
                    }

                    // echo input
//                System.out.println("Date Assigned: " + hwList.get(hwList.size()-1).dateAssigned);

                    // SET TITLE
                    System.out.println("Enter a title for the assignment: ");
                    input = key.nextLine();
                    hwList.get(hwList.size() - 1).setTitle(input);

                    // SET DUE DATE
                    System.out.println("Enter the due date for the assignment(MM/dd/yy): ");
                    input = key.nextLine();
                    buildFromString2(hwList, input);

                    // PRINT NEWLY CREATED ASSIGNMENT
                    System.out.println("\n*assignments updated*");
                    displayAssignments(hwList, currentDate);


                    break;

                case 3:
                    if (!(hwList.isEmpty())) {
                        System.out.println("Remove an assignment");
                        System.out.println("--------------------");
                        displayAssignments(hwList, currentDate);
                        option = readInt("Delete Homework #: ", key, 1, hwList.size());
                        hwList.remove((option-1));
                        System.out.println("\n*assignment #" + option + " deleted*");
                    } else {
                        System.out.println("No assignments to remove!");
                    }
                    break;

                case 4:
                    System.out.println("Provide a list of the assignments in the order they were assigned.");



                    break;

                case 5:

                    break;

                case 0:
                    System.out.print("\nGoodbye.");
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        }while(option != 0);

    }


    // static methods

//    public static void createAssignment() {
//
//
//    }



    /**
     *
     *
     * @param aList
     * @param all
     */
    public static void buildFromString(ArrayList<HwAssignment> aList, String all) {
        // should call validity method to test for format.
        // boolean isNotValid;
        // isNotValid = (result < lower) || (result > upper);
        // isNotValid = true; // initialize all variables, Compiler will complain because they are initialized in loop

        // try catch? throw exception for format?

        int month, day, year;
        String[] values = all.split("/");
        month = Integer.parseInt(values[0]);
        day = Integer.parseInt(values[1]);
        year = Integer.parseInt(values[2]);
        aList.get(aList.size()-1).setDateAssigned(new Date(month,day,(2000 + year)));
    }

    public static void buildFromString2(ArrayList<HwAssignment> aList, String all) {
        // should call validity method to test for format.
        // boolean isNotValid;
        // isNotValid = (result < lower) || (result > upper);
        // isNotValid = true; // initialize all variables, Compiler will complain because they are initialized in loop

        // try catch? throw exception for format?

        int month, day, year;
        String[] values = all.split("/");
        month = Integer.parseInt(values[0]);
        day = Integer.parseInt(values[1]);
        year = Integer.parseInt(values[2]);
        aList.get(aList.size()-1).setDateDue(new Date(month,day,(2000 + year)));
    }

    public static void buildDateFromString(Date date,String all) {
        // should call validity method to test for format.
        // boolean isNotValid;
        // isNotValid = (result < lower) || (result > upper);
        // isNotValid = true; // initialize all variables, Compiler will complain because they are initialized in loop

        // try catch? throw exception for format?

        int month, day, year;
        String[] values = all.split("/");
        month = Integer.parseInt(values[0]);
        day = Integer.parseInt(values[1]);
        year = Integer.parseInt(values[2]);

        date.setAll(month,day,year);
    }

    /**
     * outputs list to screen.
     *
     * @param aList
     */
    public static void displayAssignments(ArrayList<HwAssignment> aList, String today) {

        if(aList.isEmpty()) {

            System.out.println("\nToday\'s Date: " + today + "\nCurrent Assignments:\n");
            System.out.println("No Assignments.\n");

        }

        else {
            System.out.println("Today\'s Date: " + today + "\nCurrent Assignments:\n");
            int count = 0;
            for (HwAssignment homework : aList) {
                count++;
                System.out.println("Homework # " + count + ": \n" + homework + "\n");
            }
        }

    }

    /**
     * reads input from user, returns integer value (error-checked using bounds).
     *
     * @param prompt
     * @param key
     * @param lower
     * @param upper
     * @return
     */
    public static int readInt(String prompt, Scanner key, int lower, int upper)
    {
        String temp;
        int result;
        boolean isNotValid;

        isNotValid = true; // initialize all variables, Compiler will complain because they are initialized in loop
        result = 0;

        do
        {
            System.out.print(prompt);
            temp = key.nextLine();

            try
            {
                result = Integer.parseInt(temp);
                isNotValid = (result < lower) || (result > upper);

                //Still perform old check but with Exceptions
                if(isNotValid)
                {
                    System.out.println("ERROR: please enter value between " + lower + " - " + upper);
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println(e.getMessage());
            }

        } while(isNotValid);

        return result;
    }


    /*
    // DESCRIPTION:		reads input from user, returns double value (error-checked using bounds)
    // PRECONDITIONS:	key is instantiated, prompt is in form "Enter...: ", lower < upper
    // POSTCONDITIONS:	returns double value between lower and upper (inclusive)
    public static double readDouble(String prompt, Scanner key, double lower, double upper)
    {
        String temp;
        double result;
        boolean isNotValid;

        isNotValid = true;
        result = 0;

        do
        {
            System.out.print(prompt);
            temp = key.nextLine();

            try
            {
                result = Double.parseDouble(temp);
                isNotValid = (result < lower) || (result > upper);

                if(isNotValid)
                {
                    System.out.println("ERROR: please enter value between " + lower + " - " + upper);
                }
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("ERROR: double input is required");
            }
        } while(isNotValid);

        return result;
    }*/

    // class methods (there are no instance variables to perform manipulations).
    public void test() {


    }
}

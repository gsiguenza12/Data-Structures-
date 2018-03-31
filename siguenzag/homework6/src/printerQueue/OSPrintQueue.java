package printerQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Operating system for allocation of print jobs in a queue, assigns jobs to printers
 * (up to three) based on number of pages to be printed. Handles dispatch of print jobs,
 * processes print requests, keeps track of number of printers available, and jobs left
 * to be completed.
 *
 * @author gabrielsiguenza
 */
public class OSPrintQueue {
    public static final int SECONDS_PER_PAGE = 6;

    // Static variable to count down the number of jobs left to print.
    private static int totalJobs = 100 ;
    // Static variable to hold the number of available printers.
    private static int numberOfPrinters;
    private static Printer print1;
    private static Printer print2;
    private static Printer print3;

    private Queue<Queue> printJobQueue; // Holds the 3 categorized Queues
    private Queue<PrintJob> smallJobs; // less than 10 pg jobs
    private Queue<PrintJob> mediumJobs; // greater than 10 less than 20 pg jobs
    private Queue<PrintJob> largeJobs; // greater than 20 pg jobs

    /**
     * Default Constructor
     */
    public OSPrintQueue() {
        printJobQueue = new LinkedList<>();
        smallJobs = new LinkedList<>();
        mediumJobs = new LinkedList<>();
        largeJobs = new LinkedList<>();
    }

    public static void setActivePrinters() {

        if(numberOfPrinters == 1) {
             print1 = new Printer(1);
        }

        if(numberOfPrinters == 2) {
             print1 = new Printer(1);
             print2 = new Printer(2);
        }

        if(numberOfPrinters == 3) {
             print1 = new Printer(1);
             print2 = new Printer(2);
             print3 = new Printer(3);
        }
    }
    @Override
    public String toString() {
        return "OSPrintQueue {\n" +
                "smallJobs = " + smallJobs +
                "\n\nmediumJobs = " + mediumJobs +
                "\n\nlargeJobs = " + largeJobs +
                '}';
    }


    /**
     * Sets the number of available printers.
     * must be a number between 1 and 3.
     *
     * @param numPrinters The number of available printers for the OSPrintQueue to assign jobs to.
     */
    public static void setNumberOfPrinters(int numPrinters) {
        if(numPrinters < 1 || numPrinters > 3) {
            System.out.println("Error! must set at least one printer or a maximum of 3 printers.");
            System.exit(0);
        }
        else {
            numberOfPrinters = numPrinters;
            setActivePrinters();
        }
    }

    public static Printer getPrint1() {
        return print1;
    }

    public static Printer getPrint2() {
        return print2;
    }

    public static Printer getPrint3() {
        return print3;
    }

    public int getTotalJobs() {
        return totalJobs;
    }

    public Queue<PrintJob> getSmallJobs() {
        return smallJobs;
    }

    public Queue<PrintJob> getMediumJobs() {
        return mediumJobs;
    }

    public Queue<PrintJob> getLargeJobs() {
        return largeJobs;
    }

    /**
     * Let's the user know how many printers are currently in operation.
     *
     * @return An integer value representing the number of printers.
     */
    public int getNumberOfPrinters() {
        int numPrinters = numberOfPrinters; /*IntelliJ says that this is redundant, but this protects
         the static variable from being modified outside of Mutator method...(or does it?) is this still necessary?*/
        return numPrinters;
    }

    /* The following method will check the number of pages assigned to a print job and assign it accordingly */
    public void pushPrintJob(PrintJob request) {
        if(request.getNumPages() < 10) {
            smallJobs.offer(request);
            // Small print jobs
        }

        if(request.getNumPages() > 10 && request.getNumPages() < 20) {
            mediumJobs.offer(request);
            // Medium print Jobs
        }

        if(request.getNumPages() > 20) {
            largeJobs.offer(request);
            // Larger print jobs
        }

    }

    /**
     * Assigns jobs from the three Queues, processes PrintJobs via calls to active printer's print method
     */
    public void print(){

        while(!smallJobs.isEmpty() || !mediumJobs.isEmpty() || !largeJobs.isEmpty()) {

            // ensures that the small jobs get printed first
            if (smallJobs.peek() != null) {
//                assignToPrinter();

                /* If there is only one printer first in first out. */
                print1.setActiveJob(smallJobs.poll());
                print1.print();

                decrementJobs();
            }

            // medium jobs are printed second
            if (mediumJobs.peek() != null) {
//                assignToPrinter();

                print2.setActiveJob(mediumJobs.poll());
                print2.print();
                decrementJobs();
            }

            // large jobs should be printed last
            if (largeJobs.peek() != null) {
//                assignToPrinter();

                print3.setActiveJob(largeJobs.poll());
                print3.print();
                decrementJobs();
            }
        }

        System.out.println("All jobs completed...");
    }

    /**
     * Assigns Jobs to printers. Checks for active printers, utilizes all available printers.
     * Prints small jobs, then medium jobs, then large jobs in that order.
     */
    /* There is a more elegant way to accomplish this. */
    public void assignToPrinter() {
        System.out.println("in assign method");
        switch(numberOfPrinters) {
            case 1:
                System.out.println("case 1 running");

                /* send all jobs to printer 1 */
                if(!smallJobs.isEmpty()) {
                    print1.setActiveJob(smallJobs.poll());
                    print1.print();
                }

                else if(!mediumJobs.isEmpty()) {
                    print1.setActiveJob(mediumJobs.poll());
                    print1.print();
                }
                else if(!largeJobs.isEmpty()) {
                    print1.setActiveJob(largeJobs.poll());
                    print1.print();
                }
                else {
                    System.out.println("All print queues are empty");
                }

                break;
            case 2:
                /* choose between the two printers */
                System.out.println("case 2 running");
                if(!smallJobs.isEmpty()) {
                    print1.setActiveJob(smallJobs.poll());
                    print1.print();
                }

                if(!smallJobs.isEmpty()) {
                    print2.setActiveJob(smallJobs.poll());
                    print2.print();
                }

                if(!mediumJobs.isEmpty()) {
                    print1.setActiveJob(mediumJobs.poll());
                    print1.print();
                }

                if(!mediumJobs.isEmpty()) {
                    print2.setActiveJob(mediumJobs.poll());
                    print2.print();
                }

                if(!largeJobs.isEmpty()) {
                    print1.setActiveJob(largeJobs.poll());
                    print1.print();
                }

                if(!largeJobs.isEmpty()) {
                    print2.setActiveJob(largeJobs.poll());
                    print2.print();
                }
                // choose between the two printers.
                break;

            case 3:
                System.out.println("case 3 running");

                /* choose between the three printers */
                // check small jobs
                if(!smallJobs.isEmpty()) {
                    print1.setActiveJob(smallJobs.poll());
                    print1.print();
                }

                if(!smallJobs.isEmpty()) {
                    print2.setActiveJob(smallJobs.poll());
                    print2.print();
                }

                if(!smallJobs.isEmpty()) {
                    print3.setActiveJob(smallJobs.poll());
                    print3.print();
                }

                // check medium jobs.
                if(!mediumJobs.isEmpty()) {
                    print1.setActiveJob(mediumJobs.poll());
                    print1.print();
                }

                if(!mediumJobs.isEmpty()) {
                    print2.setActiveJob(mediumJobs.poll());
                    print2.print();
                }

                if(!mediumJobs.isEmpty()) {
                    print3.setActiveJob(mediumJobs.poll());
                    print3.print();
                }

                // check large jobs.
                if(!largeJobs.isEmpty()) {
                    print1.setActiveJob(largeJobs.poll());
                    print1.print();
                }

                if(!largeJobs.isEmpty()) {
                    print2.setActiveJob(largeJobs.poll());
                    print2.print();
                }

                if(!largeJobs.isEmpty()) {
                    print3.setActiveJob(largeJobs.poll());
                    print3.print();
                }

                break;

            default:
                // do nothing.
                break;
        }
    }
    /**
     * Decrements number of static variable total print jobs by one, if jobs is greater than 1.
     * Otherwise decrements total jobs to 0 and outputs jobs completed.
     */
    public static void decrementJobs() {
        if(totalJobs > 1) {
            totalJobs--;
//            System.out.println("Number of Print Jobs: " + totalJobs);
        }
        else {
            totalJobs--;
            System.out.println("All print jobs have been completed!");
        }
    }

    /**
     * Generates a random integer between 1 and 50 using Math class' random() method.
     *
     * @return The randomly generated number.
     */
    public int generateRandom() {
        /* Generate a random number between 1 and 50, this method would need to be static if I called it as
         * a helper method within this class.
         */
        double randomNumber = (int)(Math.random() * 50) + 1;

//        System.out.println("Randomly generated number: " + randomNumber);

        return (int)randomNumber;
    }

}

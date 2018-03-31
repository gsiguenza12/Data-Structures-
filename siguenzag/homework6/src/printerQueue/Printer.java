package printerQueue;

/**
 * Class to represent a printer object.
 *
 * @author gabrielsiguenza
 */
public class Printer {

    private int printerID;
    private PrintJob activeJob = null;
    private int elapsedTime = 0;
    private int totalElapsedTime = 0;


    /**
     * Allows printer to be identified by number.
     *
     * @param printerID An int value to represent the individual printer.
     */
    public Printer(int printerID) {
        this.printerID = printerID;
    }

    @Override
    public String toString() {
        return "\nPrinter " + printerID +
                ", activeJob: " + activeJob +
                ", elapsedTime: " + totalElapsedTime +
                " seconds";
    }

    /**
     * Sets the current print job to be printed.
     *
     * @param activeJob PrintJob object to be assigned to the printer
     */
    public void setActiveJob(PrintJob activeJob) {
        this.activeJob = activeJob;
    }


    public PrintJob getActiveJob() {

        return activeJob;
    }

    /**
     *
     *
     * @return
     */
    public int getTotalElapsedTime() {
        return totalElapsedTime;
    }

    /**
     * Prints the active job and calculates the elapsed time in seconds.

     */
    public void print() {
        /* Need to account for the first minute when job was assigned ten pages should be printed
         * before minute gets incremented again. */

        // This doesn't work since we could be setting a negative number in the constructor.
        /* Calculations are off here should not be less than one minute.
        if(activeJob.getNumPages() > 10) {
            activeJob.setNumPages(activeJob.getNumPages() - 10); // decrement for the first minute.
            elapsedTime += 60;
        }
        else
        {
            elapsedTime += (activeJob.getNumPages() / 6);
            activeJob.setNumPages(0);
        }*/

        int count = 0;

        // making sure to print last page
        while(activeJob.getNumPages() >= 1){
            count++;
            activeJob.setNumPages(activeJob.getNumPages()-1);
            elapsedTime += 6; // increment elapsed time by six seconds per page
            totalElapsedTime += 6; // also increment the total time for this printer.
        }

        activeJob.markComplete();

        System.out.println(count + " Page " + "Print job completed in " + elapsedTime + " seconds.");

        elapsedTime = 0; // reset elapsed time for next print job.
    }





}

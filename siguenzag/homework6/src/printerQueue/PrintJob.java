package printerQueue;

/**
 * A class to represent a print request.
 *
 * @author gabrielsiguenza
 */
public class PrintJob implements Comparable {
    public static final int MAX_PAGES = 50;

    private int numPages, elapsedTime;
    private boolean isComplete = false;

    PrintJob() {
        numPages = 0;
        elapsedTime = 0;
    }

    PrintJob(int numPages) {
        setNumPages(numPages);
        elapsedTime = (numPages / 6);
    }

    @Override
    public String toString() {
        return "\nPrintJob {" +
                "numPages = " + numPages +
                ", isComplete = " + isComplete +
                '}';
    }

    public void setNumPages(int numPages) {
        if(numPages >= 0 && numPages <= 50) {
            this.numPages = numPages;
        }
        else {
            System.out.println("ERROR: bad data in constructor!");
            System.exit(0);
        }
    }

    public int getNumPages() {
        return numPages;
    }

    public void markComplete() {
        this.isComplete = true;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public boolean complete() {
        return this.isComplete;
    }

    @Override
    public int compareTo(Object o) {
        if(this.getClass() == o.getClass()) {

        }

        return 0;
    }
}

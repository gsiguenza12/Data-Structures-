package Siguenza_Gabriel_HW3;

/************************************************
 * COURSE:			  CS113 M 5:30-9:30pm
 * CHAPTER:			  2
 * PROGRAMMER: 		  Gabriel Siguenza
 * DATE LAST MODIFIED: 02.16.2018
 ************************************************/

/**
 * A class to hold assignment data for a hw assignment-keeper program.
 *
 * An assignment should be able to hold an assignment title,
 * an assignment due date, and whether or not it is completed.
 *
 * @author gabrielsiguenza
 */
public class HwAssignment {

    // constant variables

    // instance variables
    String title;
    boolean isCompete;
    Date dateAssigned;
    Date dateDue;

    /**
     * Default constructor, sets instance variables to default values.
     */
    HwAssignment() {

        this.title = "No title yet";
        this.isCompete = false;
        this.dateAssigned = new Date();
        this.dateDue = new Date();

    }

    /**
     * Full constructor, takes in parameters to set all instance variables.
     *
     * @param title The name of the assignment
     * @param isComplete Sets whether or not the assignment is complete.
     * @param dateAssigned Sets the date the homework was assigned
     * @param dateDue Sets the date the homework is due.
     */
    public HwAssignment(String title, boolean isComplete, Date dateAssigned, Date dateDue) {

        setAll(title, isComplete, dateAssigned, dateDue);

    }

    // getters

    /**
     * Returns String instance variable title.
     *
     * @return The title of the homework assignment as a String
     */
    public String getTitle() {
        return title;
    }

    public boolean isCompete() {
        return isCompete;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    } // !returning reference unsafe!

    public Date getDateDue() {
        return dateDue;
    } // !returning reference unsafe!

    // setters
    public void setAll(String title, boolean isComplete, Date dateAssigned, Date dateDue) {

        this.title = title;
        this.isCompete = isCompete;
        this.dateAssigned = dateAssigned;
        this.dateDue = dateDue;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompete(boolean compete) {
        isCompete = compete;
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public String toString() {

        return ("Date assigned: " + this.dateAssigned + "\nHomework title: " + this.title +
                "\nSubmit before: " + this.dateDue + "\nHomework completed?: " + this.isCompete);
    }
}

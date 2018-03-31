package lab1;
/************************************************
 * COURSE:			  CS113 M 5:30-9:30pm
 * CHAPTER:			  2
 * PROGRAMMER: 		  Gabriel Siguenza
 * DATE LAST MODIFIED: 02.16.2018
 ************************************************/

//import packages needed
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class implements some of the methods of the Java ArrayList Class.
 */
public class PhoneBook {

    // constants

    // instance variables
    private ArrayList<DirectoryEntry> theDirectory = new ArrayList<>();

    /**
     * The inner class DirectoryEntry. A phone directory class
     * to hold contact info.
     *
     * @author gabrielsiguenza
     */
    public static class DirectoryEntry {

        // constants
        public static final String DEFAULT_NAME = "John, Doe";
        public static final String DEFAULT_NUMBER = "301-774-2341";

        // instance variables
        private String name;
        private String number;

        /**
         * Default constructor, sets name and number instance variables to default values.
         */
        public DirectoryEntry() {

            this.name = DEFAULT_NAME;
            this.number = DEFAULT_NUMBER;

        }

        /**
         * Full constructor, sets name and number to values passed in as parameters.
         *
         * @param name The name of the contact.
         * @param number The number of the contact.
         */
        public DirectoryEntry(String name, String number) {

            setAll(name,number);

        }

        // getters
        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

        // setters
        public void setName(String name) {
            this.name = name;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setAll(String name, String number) {

            this.name = name;
            this.number = number;

        }

        /**
         * Returns a String representation of the object.
         *
         * @return Returns String with all instance variables.
         */
        @Override
        public String toString() {

            return (this.name + " " + this.number);

        }

        /**
         * Compares two directory objects for identical name and number.
         *
         * @param o the object to be compared.
         * @return Returns true if objects are identical, otherwise returns false.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DirectoryEntry that = (DirectoryEntry) o;
            return Objects.equals(getName(), that.getName()) &&
                    Objects.equals(getNumber(), that.getNumber());
        }

        /**
         * Creates an individual and unique(deep) copy of the original object.
         *
         * @return Returns a new cloned DirectoryObject.
         */
        @Override
        public Object clone() {

            try {

                DirectoryEntry copy = (DirectoryEntry) super.clone();
                return copy;
            }

            catch(CloneNotSupportedException e) {

                return null;

            }

        }

        /**
         * Generates a unique hashCode for the object.
         *
         * @return returns a unique 32-bit signed integer for the object.
         */
        @Override
        public int hashCode() {

            return Objects.hash(getName(), getNumber());
        }
    } // end of inner class DirectoryEntry

    // class methods
    /**
     * Removes DirectoryEntry from list, if it exists.
     *
     * @param aName
     * @return
     */
    public String removeEntry(String aName) {
        int currentIndex = 0;
        for(DirectoryEntry contact: theDirectory) {
            if (contact.getName().equals(aName)) {
                theDirectory.remove(currentIndex);
                return aName; // ends loop.
            }
            currentIndex ++;
        }
        // target not found.
        return null;
    }

    /**
     * Add an entry to the Directory or change an existing directory.
     *
     * @param aName
     * @param newNumber
     * @return
     */
    public String addOrChangeEntry(String aName, String newNumber) {
        for (DirectoryEntry contact: theDirectory) {
            if(contact.getName().equals(aName)) {
                // if found, updates number of contact.
                theDirectory.get(theDirectory.indexOf(contact)).setNumber(newNumber);
//                theDirectory.set(theDirectory.indexOf(contact), new DirectoryEntry(aName,newNumber));
                return (aName + newNumber); // ends loop.
            }

            else if(contact.getNumber().equals(newNumber)) {
                theDirectory.get(theDirectory.indexOf(contact)).setName(aName);
            }

            // else do nothing.
            else {/*empty statement*/ }
        }

        theDirectory.add(new DirectoryEntry(aName,newNumber)); // adds to the end of list
        return (aName + newNumber);
    }

    // static methods if needed
}


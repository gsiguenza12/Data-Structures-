package Siguenza_Gabriel_HW2;


/** Abstract class that models a kind of food. */
public abstract class Food {

    // Data Field
    private double calories;

    // Abstract Methods
    /** Calculates percentage of protein in a Food object. */
    public abstract double percentProtein();
    /** Calculates percentage of fat in a Food object. */
    public abstract double percentFat();
    /** Calculates percentage of carbohydrates in a Food object. */
    public abstract double percentCarbohydrates();

    // Actual Methods
    public double getCalories() { return calories; }
    public void setCalories(double cal) {

        calories = cal;

    }
}

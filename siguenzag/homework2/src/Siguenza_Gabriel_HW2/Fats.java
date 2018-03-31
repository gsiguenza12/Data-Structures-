package Siguenza_Gabriel_HW2;


import java.util.Objects;

/**
 * The subclass Fats derived from Food class.
 * includes oils, and sweets
 */
public class Fats extends Food {

    private String name;
    private double calories;
    private double fatCal;
    private double carbCal;
    private double proteinCal;

    /**
     * Default constructor
     * sets the calorie count to it's default value.
     */
    public Fats(){

        this.calories = 0;

    }

    /**
     * Constructor sets the instance variable calories.
     */
    public Fats(double cal) {

        this.calories = cal;

    }

    /**
     * Full Constructor
     *
     * @param name
     * @param calories
     * @param fatCal
     * @param carbCal
     * @param proteinCal
     */
    public Fats(String name, double calories, double fatCal, double carbCal, double proteinCal) {
        this.name = name;
        this.calories = calories;
        this.fatCal = fatCal;
        this.carbCal = carbCal;
        this.proteinCal = proteinCal;
    }

    /**
     * Percent Carbohydrates
     * return (carbCal/calories) * 100 = the carb calorie count divided by total calories
     * multiplied by 100 equates to the percentage of total carb calories.
     */
    @Override
    public double percentCarbohydrates() {

        return (carbCal / calories) * 100;

    }

    /**
     * Percent Protein
     * return proteinCal/calories * 100
     */
    @Override
    public double percentProtein() {

        return (proteinCal / calories) * 100;
    }

    /**
     * Percent Fat
     * return proteinCal/calories * 100
     */
    @Override
    public double percentFat() {

        return (fatCal / calories) * 100;
    }

    /****** Getters and Setters ******/
    public String getName() {
        return name;
    }

    public double getCalories() {
        return super.getCalories();
    }

    public double getFatCal() {
        return fatCal;
    }

    public void setFatCal(double fatCal) {
        this.fatCal = fatCal;
    }

    public double getCarbCal() {
        return carbCal;
    }

    public void setCarbCal(double carbCal) {
        this.carbCal = carbCal;
    }

    public double getProteinCal() {
        return proteinCal;
    }

    public void setProteinCal(double proteinCal) {
        this.proteinCal = proteinCal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fats fats = (Fats) o;
        return Double.compare(fats.getCalories(), getCalories()) == 0 &&
                Double.compare(fats.getFatCal(), getFatCal()) == 0 &&
                Double.compare(fats.getCarbCal(), getCarbCal()) == 0 &&
                Double.compare(fats.getProteinCal(), getProteinCal()) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCalories(), getFatCal(), getCarbCal(), getProteinCal());
    }

    public Fats(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fats{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", fatCal=" + fatCal +
                ", carbCal=" + carbCal +
                ", proteinCal=" + proteinCal +
                '}';
    }
}

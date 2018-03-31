package Siguenza_Gabriel_HW2;


import java.util.Objects;

/**
 * The subclass Milk derived from Food class.
 * Includes yogurt, and cheese.
 */
public class Milk extends Food{

    private String name;
    private double calories;
    private double fatCal;
    private double carbCal;
    private double proteinCal;

    /**
     * The food class Milk.
     */
    public Milk(double cal){

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
    public Milk(String name, double calories, double fatCal, double carbCal, double proteinCal) {
        this.name = name;
        this.calories = calories;
        this.fatCal = fatCal;
        this.carbCal = carbCal;
        this.proteinCal = proteinCal;
    }

    /**
     * Percent Carbohydrates
     */
    @Override
    public double percentCarbohydrates() {

        return 0;

    }

    /**
     * Percent Protein
     */
    @Override
    public double percentProtein() {

        return 0;

    }

    /**
     * Percent Fat
     */
    @Override
    public double percentFat() {

        return 0;

    }

    /****** Getters and Setters ******/
    public String getName() {
        return name;
    }

    @Override
    public double getCalories() {
        return calories;
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
        Milk milk = (Milk) o;
        return Double.compare(milk.getCalories(), getCalories()) == 0 &&
                Double.compare(milk.getFatCal(), getFatCal()) == 0 &&
                Double.compare(milk.getCarbCal(), getCarbCal()) == 0 &&
                Double.compare(milk.getProteinCal(), getProteinCal()) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCalories(), getFatCal(), getCarbCal(), getProteinCal());
    }

    @Override
    public String toString() {
        return "Milk{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", fatCal=" + fatCal +
                ", carbCal=" + carbCal +
                ", proteinCal=" + proteinCal +
                '}';
    }
}

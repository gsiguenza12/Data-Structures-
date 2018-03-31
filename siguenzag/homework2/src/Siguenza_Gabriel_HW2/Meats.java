package Siguenza_Gabriel_HW2;


import java.util.Objects;

/**
 * The subclass Meats derived from Food class.
 * includes poultry, fish, and nuts.
 */
public class Meats extends Food{

    /**** CONSTANT VARIABLES ****/

    /**** INSTANCE VARIABLES ****/
    private String name;
    private double calories;
    private double fatCal;
    private double carbCal;
    private double proteinCal;

    /**
     * The food class Meats.
     */
    public Meats(double cal){

        name = "No name specified";
        this.calories = cal;
        this.fatCal = fatCal;
        this.carbCal = carbCal;
        this.proteinCal = proteinCal;

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
    public Meats(String name, double calories, double fatCal, double carbCal, double proteinCal) {
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
        Meats meats = (Meats) o;
        return Double.compare(meats.getCalories(), getCalories()) == 0 &&
                Double.compare(meats.getFatCal(), getFatCal()) == 0 &&
                Double.compare(meats.getCarbCal(), getCarbCal()) == 0 &&
                Double.compare(meats.getProteinCal(), getProteinCal()) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCalories(), getFatCal(), getCarbCal(), getProteinCal());
    }




    @Override
    public String toString() {
        return "Meats{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", fatCal=" + fatCal +
                ", carbCal=" + carbCal +
                ", proteinCal=" + proteinCal +
                '}';
    }
}

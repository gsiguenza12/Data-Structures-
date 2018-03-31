package programmingAssignment;

import java.util.Objects;

/************************************************
 * COURSE:			  CS113 M 5:30-9:30pm
 * CHAPTER:			  3
 * PROGRAMMER: 		  Gabriel Siguenza
 * DATE LAST MODIFIED: 02.28.2018
 ************************************************/


public class Widget {
    private static final String DEFAULT_NAME = "the Widget";
    private static final double DEFAULT_PRICE = 0.0;

    private String itemName;
    private double cost;

    public Widget() {
        this.itemName = DEFAULT_NAME;
        this.cost = DEFAULT_PRICE;
    }

    public Widget(String itemName, double cost) {
        this.itemName = itemName;
        this.cost = cost;
    }

    public String getItemName() {
        return itemName;
    }

    public double getCost() {
        return cost;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "itemName='" + itemName + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Widget widget = (Widget) o;
        return Double.compare(widget.getCost(), getCost()) == 0 &&
                Objects.equals(getItemName(), widget.getItemName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getItemName(), getCost());
    }
}

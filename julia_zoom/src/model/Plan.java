package model;
import java.util.ArrayList;

public class Plan {
    /** on suppose que x est complexe et qu'il s'écrit comme a + b*i
     * Le plan est caractérisé par a min, a max, b min, b max*/
    private double aMin;
    private double aMax;
    private double bMin;
    private double bMax;
    private ArrayList <Point> values = new ArrayList<>();

    public Plan(double aMin, double aMax, double bMin, double bMax) {
        this.aMin = aMin;
        this.aMax = aMax;
        this.bMin = bMin;
        this.bMax = bMax;
    }

    public double getaMin() {
        return aMin;
    }

    public void setaMin(double aMin) {
        this.aMin = aMin;
    }

    public double getaMax() {
        return aMax;
    }

    public void setaMax(double aMax) {
        this.aMax = aMax;
    }

    public double getbMin() {
        return bMin;
    }

    public void setbMin(double bMin) {
        this.bMin = bMin;
    }

    public double getbMax() {
        return bMax;
    }

    public void setbMax(double bMax) {
        this.bMax = bMax;
    }

    public ArrayList<Point> getValues() {
        return values;
    }

    public void setValues(ArrayList<Point> values) {
        this.values = values;
    }

    public void addValue(Point p) {
        /** We can add a new value without testing for the point presence because
         *  the program won't iterate two times on the same point*/
        this.getValues().add(p);
    }
}

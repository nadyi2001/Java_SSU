package task2;

import java.util.Comparator;
import java.util.Objects;

public class SUV extends AbstractVehicle implements Car, Comparable<SUV> {
    private double mileage;

    public SUV(String make, String model, int year, double mileage) {
        super(make, model, year);
        this.mileage = mileage;
    }

    @Override
    public double getFuelEfficiency() {
        return mileage;
    }

    @Override
    public void startEngine() {
        System.out.println("SUV engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("SUV engine stopped.");
    }

    @Override
    public double getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "SUV{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SUV)) return false;
        if (!super.equals(o)) return false;
        SUV suv = (SUV) o;
        return Double.compare(suv.mileage, mileage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mileage);
    }

    @Override
    public int compareTo(SUV o) {
        int mileageComparison = Double.compare(this.mileage, o.mileage);
        int yearComparison = Double.compare(this.getYear(), o.getYear());
        if (mileageComparison != 0) {
            return mileageComparison;
        } else if (yearComparison != 0){
            return yearComparison;
        }
        return this.getModel().compareTo(o.getModel());
    }


    @Override
    public AbstractVehicle deepCopy() {
        return new SUV(getMake(), getModel(), getYear(), this.mileage);
    }

    public static final Comparator<SUV> SEDAN_COMPARATOR = new Comparator<SUV>() {
        @Override
        public int compare(SUV s1, SUV s2) {
            int mileageComparison = Double.compare(s1.getMileage(), s2.getMileage());
            if (mileageComparison != 0) {
                return mileageComparison;
            }
            return Integer.compare(s1.getYear(), s2.getYear());
        }
    };
}
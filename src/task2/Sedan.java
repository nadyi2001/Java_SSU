package task2;

import java.util.Comparator;
import java.util.Objects;

public class Sedan extends AbstractVehicle implements Car, Comparable<Sedan> {
    private double mileage;

    public Sedan(String make, String model, int year, double mileage) {
        super(make, model, year);
        this.mileage = mileage;
    }

    @Override
    public double getFuelEfficiency() {
        return mileage;
    }

    @Override
    public void startEngine() {
        System.out.println("Sedan engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Sedan engine stopped.");
    }

    @Override
    public double getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sedan)) return false;
        if (!super.equals(o)) return false;
        Sedan sedan = (Sedan) o;

        return Double.compare(sedan.mileage, mileage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mileage);
    }

    @Override
    public int compareTo(Sedan o) {
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
        return new Sedan(getMake(), getModel(), getYear(), this.mileage);
    }

    public static final Comparator<Sedan> SEDAN_COMPARATOR = new Comparator<Sedan>() {
        @Override
        public int compare(Sedan s1, Sedan s2) {
            int mileageComparison = Double.compare(s1.getMileage(), s2.getMileage());
            if (mileageComparison != 0) {
                return mileageComparison;
            }
            return Integer.compare(s1.getYear(), s2.getYear());
        }
    };

}

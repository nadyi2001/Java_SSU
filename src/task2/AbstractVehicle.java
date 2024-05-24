package task2;

import java.util.Objects;

public abstract class AbstractVehicle implements Cloneable {
    private String make;
    private String model;
    private int year;

    public AbstractVehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public abstract double getFuelEfficiency();

    @Override
    public String toString() {
        return "AbstractVehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractVehicle that = (AbstractVehicle) o;
        return year == that.year && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year);
    }

    public AbstractVehicle shallowCopy() {
        try {
            return (AbstractVehicle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract AbstractVehicle deepCopy();
}

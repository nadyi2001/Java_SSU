package task2;

public class Main {
    @SuppressWarnings("unlikely-arg-type")
    public void run(){
        Sedan sedan = new Sedan("Toyota", "Camry", 2020, 30.5);
        SUV suv = new SUV("Ford", "Explorer", 2021, 25.0);

        System.out.println(sedan);
        System.out.println(suv);

        sedan.startEngine();
        suv.startEngine();

        sedan.stopEngine();
        suv.stopEngine();

        System.out.println("Sedan mileage: " + sedan.getMileage());
        System.out.println("SUV mileage: " + suv.getMileage());

        System.out.println("Sedan equals SUV: " + sedan.equals(suv));
        System.out.println("Sedan compareTo SUV: " + sedan.compareTo(new Sedan("Toyota", "Camry", 2020, 30.5)));

        AbstractVehicle sedanShallowCopy = sedan.shallowCopy();
        AbstractVehicle suvDeepCopy = suv.deepCopy();

        System.out.println("Shallow Copy of Sedan: " + sedanShallowCopy);
        System.out.println("Deep Copy of SUV: " + suvDeepCopy);

    }
    public static void main(String[] args) {
       new Main().run();
    }
}

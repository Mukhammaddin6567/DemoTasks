package designPatterns.creationalPatterns.prototype;

import java.util.ArrayList;
import java.util.List;

interface VehicleD extends Cloneable {
    void drive();

    VehicleD clone();
}

class CarD implements VehicleD {
    private String model;
    private List<String> features;

    CarD(String model, List<String> features) {
        this.model = model;
        this.features = features;
    }

    @Override
    public VehicleD clone() {
        try {
            CarD cloned = (CarD) super.clone();
            cloned.features = new ArrayList<>(this.features); // Deep copy of mutable field
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void drive() {
        System.out.println("Driving " + this.model + " with features: " + this.features);
    }

    void setFeatures(List<String> features) {
        this.features = features;
    }

    void setModel(String model) {
        this.model = model;
    }

    void addFeature(String feature) {
        this.features.add(feature);
    }

    List<String> getFeatures() {
        return this.features;
    }
}

class DeepCopy {
    public static void main(String[] args) {
        // Create a prototype Car object
        List<String> features = new ArrayList<>();
        features.add("GPS");
        features.add("Sunroof");

        CarD originalCar = new CarD("Tesla Model S", features);

        // Drive before cloning
        originalCar.drive();

        // Adding new feature
        features.add("Test");

        // Setting new features
        originalCar.setFeatures(features);

        // Drive after adding new feature but before cloning
        originalCar.drive();

        // Clone the prototype to create a new Car object
        CarD clonedCar = (CarD) originalCar.clone();

        // Modify the cloned Car
        clonedCar.setModel("Tesla Model X");
        clonedCar.addFeature("Autopilot");

        // Drive both cars
        originalCar.drive(); // Output: Driving a Tesla Model S with features: [GPS, Sunroof, Autopilot]
        clonedCar.drive();   // Output: Driving a Tesla Model X with features: [GPS, Sunroof, Autopilot]

        // Modify after cloning car
        originalCar.setModel("Tesla Model Y");
        originalCar.addFeature("New Feature");

        // Drive both cars
        originalCar.drive(); // Output: Driving a Tesla Model S with features: [GPS, Sunroof, Autopilot]
        clonedCar.drive();   // Output: Driving a Tesla Model X with features: [GPS, Sunroof, Autopilot]

        // Demonstrate shallow copy behavior
        System.out.println("Are features shared? " + (originalCar.getFeatures() == clonedCar.getFeatures())); // Output: false
    }
}

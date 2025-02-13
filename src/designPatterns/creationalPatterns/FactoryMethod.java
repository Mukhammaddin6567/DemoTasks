package designPatterns.creationalPatterns;

interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car!");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a bike!");
    }
}

abstract class VehicleFactory implements Vehicle {
    // Factory method (to be implemented by subclasses)
    abstract Vehicle createVehicle();

    // A method to use the product
    @Override
    public void drive() {
        Vehicle vehicle = createVehicle();
        vehicle.drive();
    }
}

class CarFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Bike();
    }
}

class FactoryMethod {
    public static void main(String[] args) {
        // Create a Car using CarFactory
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory bikeFactory = new BikeFactory();

        // Create a Bike using BikeFactory
        carFactory.drive();
        bikeFactory.drive();
    }
}
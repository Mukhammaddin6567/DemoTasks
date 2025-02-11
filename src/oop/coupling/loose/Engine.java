package oop.coupling.loose;

// Loose Coupling Using Interfaces
interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol Engine started");
    }
}

class DieselEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Diesel Engine started");
    }
}

class Car {
    private Engine engine; // Car depends on the Engine interface (abstraction)

    Car(Engine engine) { // Dependency Injection
        this.engine = engine;
    }

    void startCar() {
        engine.start(); // Using the injected Engine implementation
        System.out.println("Car started");
    }
}

class EngineDemo {
    public static void main(String[] args) {
        Engine dieselEngine = new DieselEngine();
        Engine petrolEngine = new PetrolEngine();

        Car car1 = new Car(dieselEngine); // Injecting DieselEngine
        car1.startCar();

        Car car2 = new Car(petrolEngine); // Injecting PetrolEngine
        car2.startCar();
    }
}

package coupling.tight;

// Tightly Coupled Classes
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private final Engine engine; // Car is tightly coupled to Engine

    Car() {
        this.engine = new Engine(); // Directly creating an instance of Engine
    }

    void startCar() {
        engine.start(); // Using Engine's implementation
        System.out.println("Car started");
    }
}

class EngineDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();
    }
}
package designPatterns.structuralPatterns;

// Subsystem Class: CPU
class CPU {
    void start() {
        System.out.println("CPU is starting...");
    }
}

// Subsystem Class: Memory
class Memory {
    void load() {
        System.out.println("Memory is loading data...");
    }
}

// Subsystem Class: HardDrive
class HardDrive {
    void readData() {
        System.out.println("Reading data from hard drive...");
    }
}

class ComputerFacade {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    // Simplified interface for starting the computer
    void startComputer() {
        this.cpu.start();
        this.memory.load();
        this.hardDrive.readData();
        System.out.println("Computer started successfully...");
    }

}

class Facade {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}

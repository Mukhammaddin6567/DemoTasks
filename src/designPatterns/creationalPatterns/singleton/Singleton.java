package designPatterns.creationalPatterns.singleton;

class Singleton {
    // Private static instance of the clas
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        // Initialization code (if needed)
    }

    // Public static method to provide global access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello, I am a Singleton object!");
    }
}

class SingletonDemo {
    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton singleton = Singleton.getInstance();

        // Call a method on the Singleton instance
        singleton.showMessage();

        // Verify that only one instance exists
        Singleton anotherSingleton = Singleton.getInstance();
        System.out.println("Are both instances the same? " + (singleton == anotherSingleton));
    }
}
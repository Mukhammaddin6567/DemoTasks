package singleton;

class Singleton {
    private static Singleton singletonInstance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }

    private void displayMethod() {
        System.out.println("Inside the display method.");
    }

    public static void main(String[] args) {
        Singleton object = Singleton.getInstance();
        object.displayMethod();
    }
}
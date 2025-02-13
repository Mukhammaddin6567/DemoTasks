package designPatterns.creationalPatterns.singleton;

class SingletonThreadSafe {
    // Private constructor
    private SingletonThreadSafe() {
        // Initialization code (if needed)
    }

    // Static inner helper class
    private static class SingletonHelper {
        private static final SingletonThreadSafe INSTANCE = new SingletonThreadSafe();
    }

    // Public static method to get the instance
    static SingletonThreadSafe getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Example method
    void showMessage() {
        System.out.println("Hello, I am a thread-safe Singleton object!");
    }
}

class SingletonThreadSafeDemo {
    public static void main(String[] args) {
        SingletonThreadSafe singleton = SingletonThreadSafe.getInstance();
        singleton.showMessage();
    }
}
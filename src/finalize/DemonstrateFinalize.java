package finalize;

public class DemonstrateFinalize {
    DemonstrateFinalize demonstrateFinalize;

    static void foo() {
        DemonstrateFinalize object = new DemonstrateFinalize();
    }

    @Override
    protected void finalize() throws Throwable {
        demonstrateFinalize = this;
        System.out.println("The reference of the object is saved. The object will not be gobbled by the garbage collector.");
    }

    public static void main(String[] args) {
        foo();
        System.gc();
    }
}

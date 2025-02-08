package functionalInterface;

@FunctionalInterface
interface TestInterface {
    int calculate(int a, int b);
}

class FunctionalInterfaceDemo {
    public static void main(String[] args) {
//        TestInterface testInterface = (a, b) -> a + b;
        TestInterface testInterface = Integer::sum;

        System.out.println(testInterface.calculate(2, 3));
    }
}
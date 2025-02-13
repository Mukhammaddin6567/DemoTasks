package exceptions.methodOverloading;

class Parent2 {
    void msg() throws ArithmeticException {
        System.out.println("parent method");
    }
}

class TestExceptionChild2 extends Parent2 {
    void msg() /*throws Exception*/ {
        System.out.println("child method");
    }

    public static void main(String[] args) {
        Parent2 parent2 = new TestExceptionChild2();

        try {
            parent2.msg();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
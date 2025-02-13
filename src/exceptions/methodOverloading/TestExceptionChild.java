package exceptions.methodOverloading;

class Parent {
    void msg() {
        System.out.println("Parent method");
    }
}

class TestExceptionChild extends Parent {
    @Override
    void msg() /*throws IOException*/ {
        System.out.println("TestExceptionChild");
    }

    public static void main(String[] args) {
        Parent parent = new TestExceptionChild();
        parent.msg();
    }
}
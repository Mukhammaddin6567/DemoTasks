package oop.inheritance;

class TestInheritance {

    private static class A {
        public static void display() {
            System.out.println("Static method in A");
        }

        public void show() {
            System.out.println("Instance method in A");
        }
    }

    private static class B extends A {
        public static void display() {
            System.out.println("Static method in B");
        }

        @Override
        public void show() {
            System.out.println("Instance method in B");
        }
    }

    public static void main(String[] args) {
        A a = new B();
        a.display();
        a.show();
        new B(){
            @Override
            public void show() {
                System.out.println("Instance method in B");
            }
        }.show();
    }
}



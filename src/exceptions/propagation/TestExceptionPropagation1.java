package exceptions.propagation;

class TestExceptionPropagation1 {
    void m() {
        int data = 50 / 0;
    }

    void n() {
        m();
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("exception handled");
        }
    }

    public static void main(String[] args) {
        TestExceptionPropagation1 object = new TestExceptionPropagation1();
        object.p();
        System.out.println("normal flow...");
    }
}

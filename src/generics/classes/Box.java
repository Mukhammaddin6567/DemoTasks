package generics.classes;

class Box<T> {
    private T t;

    T getT() {
        return t;
    }

    void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.setT(10);
        stringBox.setT("Hello world");

        System.out.printf("Integer value: %d\n\n", integerBox.getT());
        System.out.printf("String value: %s\n\n", stringBox.getT());
    }
}

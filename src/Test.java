public class Test {
    int test = 0;

    static int test2 = -1;

    static {
        System.out.println("1");
    }

    static {
        System.out.println(test2--);
    }

    static {
        System.out.println(test2);
    }

    {
        System.out.println(test++);
    }

    static {
        System.out.println("2");
    }

    public static void main(String[] args) {
        System.out.println(test2);
        System.out.println(Test.test2);
    }
}
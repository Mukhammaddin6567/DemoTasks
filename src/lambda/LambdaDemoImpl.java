package lambda;

import java.util.function.Consumer;

public class LambdaDemoImpl {
    public static void main(String[] args) {
        LambdaDemo demo = number -> number + 5;

        System.out.println(demo.calculate(5));

        StringFunction exclaim = (s) -> s + "!";
        StringFunction ask = (s) -> s + "?";
        printFormatted("Hello", exclaim);
        printFormatted("Hello", ask);
        Consumer<String> test = text -> {

        };
    }

    @FunctionalInterface
    interface StringFunction {
        String run(String str);
    }

    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }
}

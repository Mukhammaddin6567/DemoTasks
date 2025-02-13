package generics.wildcard.upperBounded;

import java.util.List;

class UpperBoundedWildcardExample {
    // Method to sum a list of numbers (accepts Number or its subclasses)
    static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) sum += number.doubleValue();
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.5, 2.5, 3.5);

        System.out.println("Sum of intList: " + sumOfList(integers));    // Works with List<Integer>
        System.out.println("Sum of doubleList: " + sumOfList(doubles));  // Works with List<Double>
    }
}

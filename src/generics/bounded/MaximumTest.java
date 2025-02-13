package generics.bounded;

class MaximumTest {

    static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) max = y;
        if (z.compareTo(x) > 0) max = z;

        return max;
    }

    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));
        System.out.printf("Max of %f, %f and %f is %f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n\n", "apple", "pear", "orange", maximum("apple", "pear", "orange"));
    }

}

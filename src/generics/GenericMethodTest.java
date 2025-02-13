package generics;

class GenericMethodTest {
    static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
//            System.out.printf("%s ", element);
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4};
        Character[] characters = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("Array integers contains: ");
        printArray(integers);

        System.out.println("\nArray doubles contains: ");
        printArray(doubles);

        System.out.println("\nArray characters contains: ");
        printArray(characters);
    }
}

package generics.wildcard.unbounded;

import java.util.List;

class UnboundedWildcardExample {
    // Method to print elements of any list
    static void printList(List<?> list) {
        for (Object object : list) System.out.printf("%s ", object);
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> stringList = List.of("A", "B", "C");
        List<Integer> intList = List.of(1, 2, 3);

        printList(stringList); // Works with List<String>
        printList(intList);    // Works with List<Integer>
    }
}

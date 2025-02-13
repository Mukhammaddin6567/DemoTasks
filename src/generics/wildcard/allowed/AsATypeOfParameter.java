package generics.wildcard.allowed;

import java.util.List;

class AsATypeOfParameter {
    // Method with wildcard parameter
    static void printList(List<?> list) {
        for (Object object : list) System.out.printf("%s ", object);
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> stringList = List.of("Hello", "World");
        List<Integer> integerList = List.of(1,2,3);

        printList(stringList);
        printList(integerList);
    }
}
package generics.wildcard.disallowed;

import java.util.List;

class AsATypeArgumentForAGenericMethodInvocation {
    // Generic method
    static <T> void printList(List<T> list) {
        for (T element : list) System.out.printf("%s ", element);
    }

    public static void main(String[] args) {
        List<String> stringList = List.of("A", "B", "C");

        // valid invocation
        System.out.println(stringList);

        // Invalid: Wildcard not allowed as type argument
        // printList<?>(stringList); Compilation Error
    }
}

package generics.wildcard.allowed;

import java.util.List;

class AsAField {
    // Field with wildcard type
    private List<?> myList;

    AsAField(List<?> myList) {
        this.myList = myList;
    }

    void printList() {
        for (Object object : this.myList) System.out.printf("%s ", object);
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> stringList = List.of("A", "B", "C");
        AsAField example = new AsAField(stringList);
        example.printList();
    }
}

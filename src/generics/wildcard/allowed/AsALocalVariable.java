package generics.wildcard.allowed;

import java.util.List;

class AsALocalVariable {
    public static void main(String[] args) {
        List<?> wildCardList = List.of("Java", "Generics", "Wildcards");
        System.out.println(wildCardList);
    }
}

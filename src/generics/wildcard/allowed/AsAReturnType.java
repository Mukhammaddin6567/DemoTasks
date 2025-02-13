package generics.wildcard.allowed;

import java.util.List;

class AsAReturnType {
    // Method with wildcard return type
    static List<?> getList() {
        return List.of(1, 2, 3); // Returns a List<?> ? here will be Integer
    }

    public static void main(String[] args) {
        List<?> list = getList();
        System.out.println(list);
    }
}

package generics.wildcard.disallowed;

import java.util.ArrayList;
import java.util.List;

class AsATypeArgumentForGenericClassInstanceCreation {
    public static void main(String[] args) {
        // Valid: Specific type argument
        List<String> stringList = new ArrayList<>();

        // Invalid: Wildcard not allowed in instance creation
        // List<?> wildCardList = new ArrayList<?>; // Compilation Error
    }
}

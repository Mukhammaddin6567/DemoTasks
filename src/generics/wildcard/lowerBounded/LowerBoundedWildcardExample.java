package generics.wildcard.lowerBounded;

import java.util.ArrayList;
import java.util.List;

class LowerBoundedWildcardExample {
    // Method to add integers to a list (accepts Integer or its superclasses)
    static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i < 5; i++) list.add(i);
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumbers(numberList); // Works with List<Number>
        addNumbers(objectList); // Works with List<Object>

        System.out.println("Number List: " + numberList);
        System.out.println("Object List: " + objectList);
    }
}

package generics.advantages;

import java.util.ArrayList;
import java.util.List;

class TypeSafety {
    public static void main(String[] args) {
        List rawList = new ArrayList();
        rawList.add(10);
        rawList.add("hello");

        System.out.println(rawList);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
//        integerList.add("hello"); // compile-time error

        System.out.println(integerList);
    }
}

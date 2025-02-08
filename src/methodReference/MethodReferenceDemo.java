package methodReference;

// 1
// Reference to a Static Method
class MathUtils {
    static int square(int number) {
        return number * number;
    }
}

// 2
// Reference to an instance method of a particular object
class Printer {
    void print(String message) {
        System.out.println(message);
    }
}

// 3
// Reference to a Constructor
class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // 1
        // Using a lambda expression
//        Function<Integer, Integer> lambda = (number) -> MathUtils.square(number);
//        System.out.println("Square using lambda: " + lambda.apply(5));

        // Using a method reference
//        Function<Integer, Integer> methodRef = MathUtils::square;
//        System.out.println("Square using method reference: " + methodRef.apply(5));

        // 2
        // Using a lambda expression
//        Printer printer = new Printer();
//        Consumer<String> lambda = (message) -> printer.print(message);
//        lambda.accept("Hello from lambda");

        // Using a method reference
//        Consumer<String> methodReference = printer::print;
//        methodReference.accept("Hello from method reference");

        // 3
        // Reference to an Instance Method of an Arbitrary Object
//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using a lambda expression
//        names.forEach(name -> System.out.println(name));

        // Using a method reference
//        names.forEach(System.out::println);

        // 4
        // Using a lambda expression
//        Function<String, Person> lambda = (name) -> new Person(name);
//        Person person = lambda.apply("Alice");
//        System.out.println("Person name (lambda) " + person.getName());

        // Reference to a Constructor
//        Function<String , Person> referenceToConstructor = Person::new;
//        Person person = referenceToConstructor.apply("Bob");
//
//        System.out.println("Person name (constructor reference) " + person.getName());
    }
}

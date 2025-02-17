package designPatterns.behavioralPatterns;

import java.util.Arrays;
import java.util.List;

class Iterator {
    public static void main(String[] args) {
        // Create a collection of books
        List<String> books = Arrays.asList(
                "Design Patterns",
                "Clean Code",
                "Head First Java",
                "The pragmatic Programmer",
                "Effective Java",
                "Clean Architecture"
        );

        // Create the BookCollection (Aggregate)
        BookCollection bookCollection = new BookCollection(books);

        // Create the iterator for the BookCollection
        IteratorInterface iterator = bookCollection.createIterator();

        // Traverse through the collection
        while (iterator.hasNext()) {
            System.out.println("Book: " + iterator.next());
        }
    }
}

// Iterator interface
interface IteratorInterface {
    boolean hasNext(); // Checks if there are more elements

    Object next(); // Returns the next element
}

// Aggregate interface
@FunctionalInterface
interface Aggregate {
    IteratorInterface createIterator(); // Returns an iterator
}

// ConcreteIterator Class
class BookIterator implements IteratorInterface {
    private final List<String> books;
    private int position = 0;

    BookIterator(List<String> books) {
        this.books = books;
    }

    @Override
    public Object next() {
        if (hasNext()) return books.get(position++);
        return null;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }
}

// ConcreteAggregate Class
class BookCollection implements Aggregate {
    private final List<String> books;

    BookCollection(List<String> books) {
        this.books = books;
    }

    @Override
    public IteratorInterface createIterator() {
        return new BookIterator(books);
    }
}
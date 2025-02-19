package designPatterns.behavioralPatterns;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
@FunctionalInterface
interface Observer {
    void update(String message);
}

// Subject Interface
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String message);
}

// Concrete Observer class
class Subscriber implements Observer {
    private final String name;

    Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name + " received update: " + message);
    }
}

// Concrete Subject (Observable) class
class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) observer.update(message);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Method to publish news
    void publishNews(String message) {
        System.out.println("News published: " + message);
        notifyObservers(message);
    }
}

class ObserverDemo {
    public static void main(String[] args) {
        // Create  a news agency (Subject)
        NewsAgency newsAgency = new NewsAgency();

        // Create subscribers (Observers)
        Subscriber subscriber1 = new Subscriber("Alice");
        Subscriber subscriber2 = new Subscriber("Bob");
        Subscriber subscriber3 = new Subscriber("Charlie");

        // Register observers
        newsAgency.registerObserver(subscriber1);
        newsAgency.registerObserver(subscriber2);
        newsAgency.registerObserver(subscriber3);

        // Publish news
        newsAgency.publishNews("Breaking news: Observer Pattern implemented!");

        // Unsubscribe an observer
        newsAgency.removeObserver(subscriber2);

        // Publish more news
        newsAgency.publishNews("Update: New Java 18 Features Released!");
    }
}
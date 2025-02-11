package oop.cohesion.high;

// High Cohesion Example
class Student {
    private String name;
    private int age;

    // Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }
}

class StudentRepository {
    void saveToDatabase(Student student) {
        System.out.println("Saving student data to database...");
    }

    void loadFromDatabase() {
        System.out.println("Loading student data from database...");
    }
}

class ReportGenerator {
    public void generateReport(Student student) {
        System.out.println("Generating student report...");
    }
}

class EmailService {
    public void sendEmail(Student student) {
        System.out.println("Sending email to student...");
    }
}
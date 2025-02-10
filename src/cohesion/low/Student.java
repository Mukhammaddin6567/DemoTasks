package cohesion.low;

class Student {
    // Student-related properties
    private String name;
    private int age;

    // Database-related methods
    void saveToDatabase() {
        System.out.println("Saving student data to database...");
    }

    void loadFromDatabase() {
        System.out.println("Loading student data from database...");
    }

    // Report-related methods
    void generateReport() {
        System.out.println("Generating student report...");
    }

    // Email-related methods
    void sendEmail(){
        System.out.println("Sending email to student...");
    }
}

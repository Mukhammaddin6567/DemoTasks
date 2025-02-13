package designPatterns.creationalPatterns;

class User {
    // Required fields
    private final String firstName;
    private final String lastName;

    // Optional fields
    private final int age;
    private final String phone;
    private final String address;

    // Private constructor to enforce the use of the Builder
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    int getAge() {
        return age;
    }

    String getPhone() {
        return phone;
    }

    String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", phone='" + getPhone() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }

    // Builder class
    static class UserBuilder {
        // Required fields
        private final String firstName;
        private final String lastName;

        // Optional fields (initialized to default values)
        private int age = 0;
        private String phone = "";
        private String address = "";

        // Constructor for required fields
        UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // Methods to set optional fields
        UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        // Build method to create the User object
        User build() {
            return new User(this);
        }
    }
}

class Builder {
    public static void main(String[] args) {
        User user1 = new User
                .UserBuilder("Muhammaddin", "Baxridinov")
                .address("Buxoro shahar")
                .age(28)
                .phone("+998904476567")
                .build();

        System.out.println(user1.toString());
    }
}

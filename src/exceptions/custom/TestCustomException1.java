package exceptions.custom;

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

class TestCustomException1 {
    static void validate(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("age is not valid to vote");
        else System.out.println("welcome to vote");
    }

    public static void main(String[] args) {
        try {
            validate(13);
        } catch (InvalidAgeException e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occurred: " + e.getMessage());
        }

        System.out.println("rest of the code...");
    }
}

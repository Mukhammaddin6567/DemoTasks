package association.aggregation;

class Operation {
    int square(int n) {
        return n * n;
    }
}

class Circle {
    Operation operation; // aggregation
    private final double PI = Math.PI;

    double area(int radius) {
        operation = new Operation();
        int square = operation.square(radius);
        return square * PI;
    }
}

class OperationWithSquare {
    public static void main(String[] args) {
        Circle circle = new Circle();
        double result = circle.area(5);
        System.out.println(result);
    }
}

package designPatterns.behavioralPatterns;

// Abstract Expression Interface
@FunctionalInterface
interface Expression {
    int interpret();
}

// Terminal Expression: Represents a single number in the expression
class NumberExpression implements Expression {
    private final int number;

    NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return this.number;
    }
}

// Non-Terminal Expression: Addition
class AddExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    AddExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

// Non-Terminal Expression: Subtraction
class SubtractExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    SubtractExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}

// Non-Terminal Expression: Multiplication
class MultiplyExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    MultiplyExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }
}

// Non-Terminal Expression: Division
class DivideExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    DivideExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        int rightValue = rightExpression.interpret();
        if (rightValue == 0) throw new ArithmeticException("Cannot divide by zero");
        return leftExpression.interpret() / rightExpression.interpret();
    }
}

class Interpreter {
    public static void main(String[] args) {
        Expression ten = new NumberExpression(10);
        Expression two = new NumberExpression(2);
        Expression eight = new NumberExpression(8);
        Expression four = new NumberExpression(4);
        Expression zero = new NumberExpression(0);

        // Addition
        Expression addExpression = new AddExpression(ten, two);
        System.out.println("10 + 2 = " + addExpression.interpret());

        // Subtraction
        Expression subtractExpression = new SubtractExpression(eight, four);
        System.out.println("8 - 4 = " + subtractExpression.interpret());

        // Multiplication
        Expression multiplyExpression = new MultiplyExpression(four, two);
        System.out.println("4 * 2 = " + multiplyExpression.interpret());

        // Division
        Expression divideExpression = new DivideExpression(ten, two);
        System.out.println("10 / 2 = " + divideExpression.interpret());

        // Division
        Expression divideExpression2 = new DivideExpression(ten, zero);
        System.out.println("10 / 0 = " + divideExpression2.interpret());
    }
}

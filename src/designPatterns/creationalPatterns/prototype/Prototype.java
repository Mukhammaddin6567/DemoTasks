package designPatterns.creationalPatterns.prototype;

interface Shape extends Cloneable {
    void draw();

    Shape clone();
}

class Circle implements Shape {
    private String color;

    Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone(); // Use Java's built-in cloning mechanism
        } catch (CloneNotSupportedException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    void setColor(String color) {
        this.color = color;
    }
}

class Rectangle implements Shape {
    private String color;

    Rectangle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " rectangle.");
    }

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone(); // Use Java's built-in cloning mechanism
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    void setColor(String color) {
        this.color = color;
    }
}

class Prototype {
    public static void main(String[] args) {
        // Create prototype objects
        Shape redCircle = new Circle("red");
        Shape blueRectangle = new Rectangle("blue");

        // Clone the prototypes to create new objects
        Shape greenCircle = redCircle.clone();
        ((Circle) greenCircle).setColor("green");

        Shape yellowRectangle = blueRectangle.clone();
        ((Rectangle) yellowRectangle).setColor("yellow");

        // Draw the shapes
        redCircle.draw();         // Output: Drawing a red circle.
        greenCircle.draw();       // Output: Drawing a green circle.
        blueRectangle.draw();     // Output: Drawing a blue rectangle.
        yellowRectangle.draw();   // Output: Drawing a yellow rectangle.
    }
}
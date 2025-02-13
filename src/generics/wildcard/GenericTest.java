package generics.wildcard;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing rectangle");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}

class GenericTest {
    static void drawShapes(List<? extends Shape> list) {
        for (Shape shape : list) shape.draw();
    }

    public static void main(String[] args) {
        List<Rectangle> rectangleList = new ArrayList<>();
        rectangleList.add(new Rectangle());

        List<Circle> circleList = new ArrayList<>();
        circleList.add(new Circle());
        circleList.add(new Circle());

        drawShapes(rectangleList);
        drawShapes(circleList);
    }
}

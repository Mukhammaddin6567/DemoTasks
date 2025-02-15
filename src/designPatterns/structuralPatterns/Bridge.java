package designPatterns.structuralPatterns;

interface Renderer {
    void renderCircle(float radius);

    void renderRectangle(float sideA, float sideB);
}

class VectorRenderer implements Renderer {
    @Override
    public void renderRectangle(float sideA, float sideB) {
        System.out.println("Drawing a rectangle of sides " + sideA + " and " + sideB + " using vector graphics");
    }

    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius + " using vector graphics");
    }
}

class RasterRenderer implements Renderer {
    @Override
    public void renderRectangle(float sideA, float sideB) {
        System.out.println("Drawing a rectangle of sides " + sideA + " and " + sideB + " using raster graphics");
    }

    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius + " using raster graphics");
    }
}

abstract class Shape {
    protected Renderer renderer;

    Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    abstract void draw();
}

class Circle extends Shape {
    private final float radius;

    Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    void draw() {
        renderer.renderCircle(radius);
    }
}

class Rectangle extends Shape {
    private final float sideA;
    private final float sideB;

    Rectangle(Renderer renderer, float sideA, float sideB) {
        super(renderer);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    void draw() {
        renderer.renderRectangle(sideA, sideB);
    }
}

class Bridge {
    public static void main(String[] args) {
        // create a vector renderer
        Renderer vectorRenderer = new VectorRenderer();

        // create a raster renderer
        Renderer rasterRenderer = new RasterRenderer();

        // create a circle and draw it using vector graphics
        Shape vectorCircle = new Circle(vectorRenderer, 5.0f);
        vectorCircle.draw();

        // create a circle and draw it using raster graphics
        Shape rasterCircle = new Circle(rasterRenderer, 10f);
        rasterCircle.draw();

        // create a rectangle and draw it using raster graphics
        Shape rectangle = new Rectangle(rasterRenderer, 10.0f, 20.0f);
        rectangle.draw();
    }
}
package designPatterns.structuralPatterns;

interface Coffee {
    String getDescription();    // Returns the description of the coffee

    double getCost();           // Returns the cost of the coffee
}

class CoffeeImpl implements Coffee {
    private final String description;
    private final double cost;

    CoffeeImpl(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

// Concrete Decorator: Adds milk to the coffee
class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.decoratedCoffee.getCost() + 1.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with milk";
    }
}

// Concrete Decorator: Adds sugar to the coffee
class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with sugar";
    }
}

class Decorator {
    public static void main(String[] args) {
        // crate a black coffee
        Coffee coffee = new CoffeeImpl("Black Coffee", 2.5);
        System.out.println(coffee.getDescription() + " Cost $: " + coffee.getCost());

        // add milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost $: " + coffee.getCost());

        // add sugar to the coffee
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost $: " + coffee.getCost());

        // add another milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost $: " + coffee.getCost());
    }
}

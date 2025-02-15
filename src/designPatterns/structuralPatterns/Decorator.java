package designPatterns.structuralPatterns;

interface Coffee {
    String description();    // Returns the description of the coffee

    double cost();           // Returns the cost of the coffee
}

// can be converted to record
/*class CoffeeImpl implements Coffee {
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
}*/

record CoffeeImpl(String description, double cost) implements Coffee {
    
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}

// Concrete Decorator: Adds milk to the coffee
class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.decoratedCoffee.cost() + 1.5;
    }

    @Override
    public String description() {
        return super.description() + " with milk";
    }
}

// Concrete Decorator: Adds sugar to the coffee
class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }

    @Override
    public String description() {
        return super.description() + " with sugar";
    }
}

class Decorator {
    public static void main(String[] args) {
        // crate a black coffee
        Coffee coffee = new CoffeeImpl("Black Coffee", 2.5);
        System.out.println(coffee.description() + " Cost $: " + coffee.cost());

        // add milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.description() + " Cost $: " + coffee.cost());

        // add sugar to the coffee
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.description() + " Cost $: " + coffee.cost());

        // add another milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.description() + " Cost $: " + coffee.cost());
    }
}

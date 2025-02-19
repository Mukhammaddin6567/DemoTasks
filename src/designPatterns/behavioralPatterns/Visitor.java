package designPatterns.behavioralPatterns;

import java.util.ArrayList;
import java.util.List;

interface DiscountVisitor {
    void visit(ElectronicItem electronicItem);

    void visit(GroceryItem groceryItem);
}

@FunctionalInterface
interface Visitable {
    void accept(DiscountVisitor visitor);
}

record ElectronicItem(double price) implements Visitable {
    @Override
    public void accept(DiscountVisitor visitor) {
        visitor.visit(this);
    }
}

record GroceryItem(double price) implements Visitable {
    @Override
    public void accept(DiscountVisitor visitor) {
        visitor.visit(this);
    }
}

class DiscountCalculator implements DiscountVisitor {
    @Override
    public void visit(GroceryItem groceryItem) {
        double discount = groceryItem.price() * 0.05; // 5% discount
        System.out.println("Electronics Discount: $" + discount);
    }

    @Override
    public void visit(ElectronicItem electronicItem) {
        double discount = electronicItem.price() * 0.1; // 10% discount
        System.out.println("Grocery Discount: $" + discount);
    }
}

class Visitor {
    public static void main(String[] args) {
        List<Visitable> cart = new ArrayList<>();
        cart.add(new ElectronicItem(1000));
        cart.add(new GroceryItem(1000));

        DiscountVisitor discountVisitor = new DiscountCalculator();
        for (Visitable item : cart) item.accept(discountVisitor);
    }
}
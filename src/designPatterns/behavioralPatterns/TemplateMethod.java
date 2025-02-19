package designPatterns.behavioralPatterns;

abstract class OrderProcessTemplate {
    // Template method defining the steps of the algorithm
    final void processOrder() {
        selectItem();
        addToCart();
        makePayment(); // Customizable step
        generateInvoice();
        deliverOrder(); // Customizable step
    }

    // Common steps
    void selectItem() {
        System.out.println("Item selected");
    }

    void addToCart() {
        System.out.println("Item added to cart");
    }

    void generateInvoice() {
        System.out.println("Invoice generated");
    }

    // Steps that will be implemented differently in subclasses
    abstract void makePayment();

    abstract void deliverOrder();
}

class ElectronicsOrder extends OrderProcessTemplate {
    @Override
    void makePayment() {
        System.out.println("Payment made using Credit Card");
    }

    @Override
    void deliverOrder() {
        System.out.println("Electronics item shipped via FedEx");
    }
}

class GroceryOrder extends OrderProcessTemplate {
    @Override
    void makePayment() {
        System.out.println("Payment made using PayPal");
    }

    @Override
    void deliverOrder() {
        System.out.println("Groceries delivered by local delivery partner");
    }
}

class TemplateMethod {
    public static void main(String[] args) {
        System.out.println("Processing Electronics Order:");
        OrderProcessTemplate electronicsOrder = new ElectronicsOrder();
        electronicsOrder.processOrder();

        System.out.println("\nProcessing Grocery Order:");
        OrderProcessTemplate groceryOrder = new GroceryOrder();
        groceryOrder.processOrder();
    }
}
package factoryMethod;

@FunctionalInterface
interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " via Credit Card.");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " via PayPal.");
    }
}

class CryptoPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " via Cryptocurrency.");
    }
}

abstract class PaymentFactory {
    abstract Payment createPayment();

    void processPayment(double amount) {
        Payment payment = createPayment();
        payment.pay(amount);
    }
}

class CreditCardPaymentFactory extends PaymentFactory {
    @Override
    Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalPaymentFactory extends PaymentFactory {
    @Override
    Payment createPayment() {
        return new PayPalPayment();
    }
}

class CryptoPaymentFactory extends PaymentFactory {
    @Override
    Payment createPayment() {
        return new CryptoPayment();
    }
}

class PaymentDemo {
    public static void main(String[] args) {
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        PaymentFactory payPalFactory = new PayPalPaymentFactory();
        PaymentFactory cryptoFactory = new CryptoPaymentFactory();

        creditCardFactory.processPayment(1);
        payPalFactory.processPayment(2);
        cryptoFactory.processPayment(3);

    }
}
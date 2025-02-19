package designPatterns.behavioralPatterns;

@FunctionalInterface
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid: " + amount + "$ using Credit Card: " + this.cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private final String email;

    PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid: " + amount + "$ using PayPal: " + this.email);
    }
}

class CryptoPayment implements PaymentStrategy {
    private final String walletAddress;

    CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid: " + amount + "$ using Crypto Wallet: " + this.walletAddress);
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    void pay(int amount) {
        if (paymentStrategy == null) System.out.println("No payment method selected");
        else paymentStrategy.pay(amount);
    }
}

class Strategy {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment("9860 1601 2718 5397"));
        context.pay(1_000_000);

        // Pay using PayPal
        context.setPaymentStrategy(new PayPalPayment("mukhammaddinbakhridinov@gmail.com"));
        context.pay(2_500_000);

        // Pay using Crypto Wallet
        context.setPaymentStrategy(new CryptoPayment("0x5B38Da6a701c568545dCfcB03FcB875f56beddC4"));
        context.pay(5_000_000);
    }
}

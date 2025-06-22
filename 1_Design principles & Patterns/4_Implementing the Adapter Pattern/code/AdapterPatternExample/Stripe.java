package AdapterPatternExample;

public class Stripe {
	public void makePayment(double amountInDollars) {
        System.out.println("Stripe processed payment of $" + amountInDollars);
    }
}

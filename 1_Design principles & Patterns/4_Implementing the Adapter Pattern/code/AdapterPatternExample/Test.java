package AdapterPatternExample;

public class Test {
	public static void main(String[] args) {
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentProcessor razorPayProcessor = new RazorPayAdapter(new RazorPay());

        paypalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
        razorPayProcessor.processPayment(300.00);
	}
}

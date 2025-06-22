package AdapterPatternExample;

public class RazorPayAdapter implements PaymentProcessor {
    private RazorPay razorPay;

    public RazorPayAdapter(RazorPay razorPay) {
        this.razorPay = razorPay;
    }

    public void processPayment(double amount) {
    	razorPay.doTransaction(amount);
    }
}
public class Iou {
    public final String lender;
    public final String borrower;
    public final double amount;

    public String getLender() {
        return lender;
    }

    public String getBorrower() {
        return borrower;
    }

    public double getAmount() {
        return amount;
    }

    public Iou(String lender, String borrower, double amount) {
        this.lender = lender;
        this.borrower = borrower;
        this.amount = amount;
    }
}

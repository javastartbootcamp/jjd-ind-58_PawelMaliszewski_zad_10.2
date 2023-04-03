package pl.javastart.task.contracts;

public class PrePaid extends Contract {

    private double balance;
    private double textCost;
    private double mmsCost;
    private double minuteCost;

    public PrePaid(double balance, double textCost, double mmsCost, double minuteCost) {
        this.balance = balance;
        this.textCost = textCost;
        this.mmsCost = mmsCost;
        this.minuteCost = minuteCost;
    }

    protected double getBalance() {
        return balance;
    }

    protected double getTextCost() {
        return textCost;
    }

    protected void setTextCost(double textCost) {
        this.textCost = textCost;
    }

    protected double getMmsCost() {
        return mmsCost;
    }

    protected void setMmsCost(double mmsCost) {
        this.mmsCost = mmsCost;
    }

    protected double getMinuteCost() {
        return minuteCost;
    }

    protected void setMinuteCost(double minuteCost) {
        this.minuteCost = minuteCost;
    }

    private double oneSecondCost() {
        return minuteCost / SIXTY_SECONDS;
    }

    private double callCost(int seconds) {
        return oneSecondCost() * seconds;
    }

    private void updateBalance(double cost) {
        balance -= cost;
    }

    @Override
    public int phoneCall(int seconds) {
        double callCost = callCost(seconds);
        if (balance >= callCost) {
            updateBalance(callCost);
            updateCallDuration(seconds);
            return seconds;
        } else if (balance >= oneSecondCost()) {
            int secondsLeft = (int) (balance / oneSecondCost());
            updateBalance(callCost(secondsLeft));
            updateCallDuration(secondsLeft);
            return secondsLeft;
        }
        return 0;
    }

    @Override
    public boolean sendText() {
        if (balance >= textCost) {
            updateBalance(textCost);
            textMassagesSent++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sendMms() {
        if (balance >= mmsCost) {
            updateBalance(mmsCost);
            multimediaMassagesSent++;
            return true;
        } else {

            return false;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n" + super.toString() + "Na koncie zostało " + String.format("%.2f", balance) + " zł\n";
    }
}

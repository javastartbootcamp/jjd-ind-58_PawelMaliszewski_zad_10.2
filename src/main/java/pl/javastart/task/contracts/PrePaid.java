package pl.javastart.task.contracts;

public class PrePaid extends Contract {

    private static final int SIXTY_SECONDS = 60;
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

    private void setCallDuration(int seconds) {
        setCallDurationInSeconds(seconds);
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
    public void phoneCall(int seconds) {
        if (balance >= callCost(seconds)) {
            updateBalance(callCost(seconds));
            updateCallDuration(seconds);
        } else if (balance >= oneSecondCost() && balance < callCost(seconds)) {
            double secondsLeft = balance / oneSecondCost();
            updateBalance(callCost((int) secondsLeft));
            updateCallDuration((int) secondsLeft);
            System.out.println("Połączenie przerwane brak środków na koncie\n");
        } else {
            System.out.println("Nie udało się wykonać połączenia brak środków na koncie\n");
        }
    }

    @Override
    public void sendText() {
        if (balance >= textCost) {
            updateBalance(textCost);
            setTextsSent(getTextsSent() + 1);
            System.out.println("SMS wysłany\n");
        } else {
            System.out.println("Nie udało się wysłać SMSa\n");
        }
    }

    @Override
    public void sendMms() {
        if (balance >= mmsCost) {
            updateBalance(mmsCost);
            setMmsSent(getMmsSent() + 1);
            System.out.println("MMS wysłany\n");
        } else {
            System.out.println("Nie udało się wysłać MMSa\n");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Na koncie zostało " + String.format("%.2f", balance) + " zł\n";
    }
}

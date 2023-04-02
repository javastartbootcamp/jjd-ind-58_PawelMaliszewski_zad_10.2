package pl.javastart.task.contracts;

public class Monthly extends Contract {

    private boolean billPaid;

    public Monthly(boolean billPaid) {
        this.billPaid = billPaid;
    }

    protected boolean isBillPaid() {
        return billPaid;
    }

    protected void setBillPaid(boolean billPaid) {
        this.billPaid = billPaid;
    }

    @Override
    public void phoneCall(int seconds) {
        if (billPaid) {
            setCallDurationInSeconds(getCallDurationInSeconds() + seconds);
        } else {
            System.out.println("Faktura nieopłacona połączenia wychodzące zablokowane\n");
        }
    }

    @Override
    public void sendText() {
        if (billPaid) {
            setTextsSent(getTextsSent() + 1);
        } else {
            System.out.println("Faktura nieopłacona wiadomości wychodzące zablokowane\n");
        }

    }

    @Override
    public void sendMms() {
        if (billPaid) {
            setMmsSent(getMmsSent() + 1);
        } else {
            System.out.println("Faktura nieopłacona wiadomości wychodzące zablokowane\n");
        }
    }

    private String billStatus() {
        if (billPaid) {
            return "zapłacona";
        }
        return "niezapłacona";
    }

    @Override
    public String toString() {
        return super.toString() + "Faktura: " + billStatus();
    }
}

package pl.javastart.task.contracts;

public class Monthly extends Contract {

    private final double planCharge;
    private boolean billPaid;

    public Monthly(double planCharge, boolean billPaid) {
        this.planCharge = planCharge;
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
            callDurationInSeconds += seconds;
        } else {
            System.out.println("Faktura nieopłacona połączenia wychodzące zablokowane\n");
        }
    }

    @Override
    public void sendText() {
        if (billPaid) {
            textsSent++;
        } else {
            System.out.println("Faktura nieopłacona wiadomości wychodzące zablokowane\n");
        }

    }

    @Override
    public void sendMms() {
        if (billPaid) {
            mmsSent++;
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
        return super.toString() + "Cena abonamentu: " + planCharge + "\nFaktura: " + billStatus() + "\n";
    }
}

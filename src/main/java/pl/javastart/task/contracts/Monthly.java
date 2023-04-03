package pl.javastart.task.contracts;

public class Monthly extends Contract {

    private final double monthlyPlanCharges;
    private boolean billPaid;

    public Monthly(double monthlyPlanCharges, boolean billPaid) {
        this.monthlyPlanCharges = monthlyPlanCharges;
        this.billPaid = billPaid;
    }

    protected boolean isBillPaid() {
        return billPaid;
    }

    protected void setBillPaid(boolean billPaid) {
        this.billPaid = billPaid;
    }

    @Override
    public int phoneCall(int seconds) {
        if (billPaid) {
            callDurationInSeconds += seconds;
            return seconds;
        }
        return 0;
    }

    @Override
    public boolean sendText() {
        if (billPaid) {
            textMassagesSent++;
            return true;
        }
        return false;
    }

    @Override
    public boolean sendMms() {
        if (billPaid) {
            multimediaMassagesSent++;
            return true;
        }
        return false;
    }

    private String billStatus() {
        if (billPaid) {
            return "zapłacona";
        }
        return "niezapłacona";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n" + super.toString() + "Cena abonamentu: " + monthlyPlanCharges + "\nFaktura: " + billStatus() + "\n";
    }
}

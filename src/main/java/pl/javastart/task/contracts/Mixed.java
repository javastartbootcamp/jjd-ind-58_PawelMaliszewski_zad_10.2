package pl.javastart.task.contracts;

public class Mixed extends PrePaid {

    private double bundleMinutes;
    private int bundleTexts;
    private int bundleMms;

    public Mixed(double balance, double textCost, double mmsCost, double minuteCost, int bundleMinutes, int bundleTexts, int bundleMms) {
        super(balance, textCost, mmsCost, minuteCost);
        this.bundleMinutes = bundleMinutes;
        this.bundleTexts = bundleTexts;
        this.bundleMms = bundleMms;
    }

    @Override
    public void phoneCall(int seconds) {
        if (bundleSecondLeft() - seconds >= 0) {
            updateBundleMinutes(seconds);
            updateCallDuration(seconds);
        } else if (bundleSecondLeft() > 0 && bundleSecondLeft() - seconds < 0) {
            super.phoneCall((seconds - bundleSecondLeft()));
            updateCallDuration(bundleSecondLeft());
            updateBundleMinutes(bundleSecondLeft());
        } else {
            super.phoneCall(seconds);
        }
    }

    private int bundleSecondLeft() {
        return (int) (bundleMinutes * SIXTY_SECONDS);
    }

    private void updateBundleMinutes(int seconds) {
        bundleMinutes -= ((double) seconds / SIXTY_SECONDS);
    }

    @Override
    public void sendText() {
        if (bundleTexts > 0) {
            textsSent++;
            bundleTexts--;
            System.out.println("SMS wysłany\n");
        } else {
            super.sendText();
        }
    }

    @Override
    public void sendMms() {
        if (bundleMms > 0) {
            mmsSent++;
            bundleMms--;
            System.out.println("MMS wysłany\n");
        } else {
            super.sendMms();
        }
    }

    @Override
    public String toString() {
        return super.toString() + "=====Pozostało w pakiecie=====\n"
                + "Minut: " + (int) bundleMinutes + "\n"
                + "SMS: " + bundleTexts  + "\n"
                + "MMS: " + bundleMms + "\n";
    }
}

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
    public int phoneCall(int seconds) {
        int bundleSecondsLeft = bundleSecondLeft();
        if (bundleSecondsLeft - seconds >= 0) {
            updateBundleMinutes(seconds);
            updateCallDuration(seconds);
            return seconds;
        } else {
            int callSeconds = super.phoneCall((seconds - bundleSecondsLeft));
            updateCallDuration(bundleSecondsLeft);
            updateBundleMinutes(bundleSecondsLeft);
            return callSeconds + bundleSecondsLeft;
        }
    }

    private int bundleSecondLeft() {
        return (int) (bundleMinutes * SIXTY_SECONDS);
    }

    private void updateBundleMinutes(int seconds) {
        bundleMinutes -= ((double) seconds / SIXTY_SECONDS);
    }

    @Override
    public boolean sendText() {
        if (bundleTexts > 0) {
            textMassagesSent++;
            bundleTexts--;
            return true;
        }
        return super.sendText();
    }

    @Override
    public boolean sendMms() {
        if (bundleMms > 0) {
            multimediaMassagesSent++;
            bundleMms--;
            return true;
        }
        return super.sendMms();
    }

    @Override
    public String toString() {
        return super.toString() + "=====Pozostało w pakiecie=====\n"
                + "Minut: " + (int) bundleMinutes + "\n"
                + "SMS: " + bundleTexts  + "\n"
                + "MMS: " + bundleMms + "\n";
    }
}

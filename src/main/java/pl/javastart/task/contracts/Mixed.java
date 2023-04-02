package pl.javastart.task.contracts;

public class Mixed extends PrePaid {

    private int bundleMinutes;
    private int bundleTexts;
    private int bundleMms;

    public Mixed(double balance, double textCost, double mmsCost, double minuteCost, int bundleMinutes, int bundleTexts, int bundleMms) {
        super(balance, textCost, mmsCost, minuteCost);
        this.bundleMinutes = bundleMinutes;
        this.bundleTexts = bundleTexts;
        this.bundleMms = bundleMms;
    }

    protected int getBundleMinutes() {
        return bundleMinutes;
    }

    protected void setBundleMinutes(int bundleMinutes) {
        this.bundleMinutes = bundleMinutes;
    }

    protected int getBundleTexts() {
        return bundleTexts;
    }

    protected void setBundleTexts(int bundleTexts) {
        this.bundleTexts = bundleTexts;
    }

    protected int getBundleMms() {
        return bundleMms;
    }

    protected void setBundleMms(int bundleMms) {
        this.bundleMms = bundleMms;
    }

    @Override
    public void phoneCall(int seconds) {
        if (bundleSecondLeft() + seconds <= 0) {
            updateCallDuration(seconds);
        } else if (bundleSecondLeft() < 0 && bundleSecondLeft() + seconds > 0) {
            updateCallDuration(bundleSecondLeft() - seconds);
            super.phoneCall((bundleSecondLeft() + seconds));
        } else {
            super.phoneCall(seconds);
        }
    }

    private int bundleSecondLeft() {
        return getCallDurationInSeconds() - bundleMinutesToSeconds();
    }

    private int bundleMinutesToSeconds() {
        return bundleMinutes * 60;
    }

    @Override
    public void sendText() {
        if (bundleTexts > getTextsSent()) {
            setTextsSent(getTextsSent() + 1);
            System.out.println("SMS wysłany\n");
        } else {
            super.sendText();
        }
    }

    @Override
    public void sendMms() {
        if (bundleMms > getMmsSent()) {
            setMmsSent(getMmsSent() + 1);
            System.out.println("MMS wysłany\n");
        } else {
            super.sendMms();
        }
    }

    private int bundleMinutesLeft() {
        if (bundleSecondLeft() < 0) {
            return (bundleSecondLeft() * -1) / 60;
        }
        return 0;
    }

    private int bundleTextLeft() {
        if (getTextsSent() - bundleTexts < 0) {
            return bundleTexts - getTextsSent();
        }
        return 0;
    }

    private int bundleMmsLeft() {
        if (getMmsSent() - bundleMms < 0) {
            return bundleMms - getMmsSent();
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "=====Pozostało w pakiecie=====\n"
                + "Minut: " + bundleMinutesLeft() + "\n"
                + "SMS: " + bundleTextLeft()  + "\n"
                + "MMS: " + bundleMmsLeft() + "\n";
    }
}

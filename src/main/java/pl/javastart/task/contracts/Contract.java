package pl.javastart.task.contracts;

public abstract class Contract implements Operations {

    private int textsSent;
    private int mmsSent;
    private int callDurationInSeconds;

    protected int getTextsSent() {
        return textsSent;
    }

    protected void setTextsSent(int textsSent) {
        this.textsSent = textsSent;
    }

    protected int getMmsSent() {
        return mmsSent;
    }

    protected void setMmsSent(int mmsSent) {
        this.mmsSent = mmsSent;
    }

    protected int getCallDurationInSeconds() {
        return callDurationInSeconds;
    }

    protected void setCallDurationInSeconds(int callDurationInSeconds) {
        this.callDurationInSeconds = callDurationInSeconds;
    }

    protected void updateCallDuration(int seconds) {
        setCallDurationInSeconds(getCallDurationInSeconds() + seconds);
    }

    @Override
    public String toString() {
        return  "=== STAN KONTA === \n"
                + "Wysłanych SMSów: " + textsSent + "\n"
                + "Wysłanych MMSów: " + mmsSent + "\n"
                + "Liczba sekund rozmowy: " + callDurationInSeconds + "\n";
    }
}

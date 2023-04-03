package pl.javastart.task.contracts;

public abstract class Contract {

    protected static final int SIXTY_SECONDS = 60;
    protected int textsSent;
    protected int mmsSent;
    protected int callDurationInSeconds;

    protected void updateCallDuration(int seconds) {
        callDurationInSeconds += seconds;
    }

    @Override
    public String toString() {
        return  "=== STAN KONTA === \n"
                + "Wysłanych SMSów: " + textsSent + "\n"
                + "Wysłanych MMSów: " + mmsSent + "\n"
                + "Liczba sekund rozmowy: " + callDurationInSeconds + "\n";
    }

    public abstract void phoneCall(int seconds);

    public abstract void sendText();

    public abstract void sendMms();
}

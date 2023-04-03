package pl.javastart.task.contracts;

public abstract class Contract {

    protected static final int SIXTY_SECONDS = 60;
    protected int textMassagesSent;
    protected int multimediaMassagesSent;
    protected int callDurationInSeconds;

    protected void updateCallDuration(int seconds) {
        callDurationInSeconds += seconds;
    }

    @Override
    public String toString() {
        return  "=== STAN KONTA === \n"
                + "Wysłanych SMSów: " + textMassagesSent + "\n"
                + "Wysłanych MMSów: " + multimediaMassagesSent + "\n"
                + "Liczba sekund rozmowy: " + callDurationInSeconds + "\n";
    }

    public abstract int phoneCall(int seconds);

    public abstract boolean sendText();

    public abstract boolean sendMms();
}

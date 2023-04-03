package pl.javastart.task.phone;

import pl.javastart.task.contracts.Contract;

public class Phone {
    private final Contract contract;

    public Phone(Contract contract) {
        this.contract = contract;
    }

    public void sendText() {
        if (contract.sendText()) {
            System.out.println("SMS wysłany\n");
        } else {
            System.out.println("Nie udało się wysłać SMSa\n");
        }

    }

    public void call(int seconds) {
        int callTime = contract.phoneCall(seconds);
        if (callTime == 0) {
            System.out.println("Nie udało się wykonać połączenia\n");
        } else if (callTime < seconds) {
            System.out.println("Połączenie przerwane\n");
        }
    }

    public void sendMms() {
        if (contract.sendMms()) {
            System.out.println("MMS wysłany\n");
        } else {
            System.out.println("Nie udało się wysłać MMSa\n");
        }
    }

    public void printAccountState() {
        System.out.println(contract);
    }
}

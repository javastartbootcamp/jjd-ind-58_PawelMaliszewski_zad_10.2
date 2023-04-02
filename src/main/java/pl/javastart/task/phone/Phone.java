package pl.javastart.task.phone;

import pl.javastart.task.contracts.Contract;

public class Phone {
    Contract contract;

    public Phone(Contract contract) {
        this.contract = contract;
    }

    public void sendText() {
        contract.sendText();
    }

    public void call(int seconds) {
        contract.phoneCall(seconds);
    }

    public void sendMms() {
        contract.sendMms();
    }

    public void printAccountState() {
        System.out.println(contract);
    }
}

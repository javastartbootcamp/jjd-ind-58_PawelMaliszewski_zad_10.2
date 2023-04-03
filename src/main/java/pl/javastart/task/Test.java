package pl.javastart.task;

import pl.javastart.task.contracts.Mixed;
import pl.javastart.task.contracts.Monthly;
import pl.javastart.task.contracts.PrePaid;
import pl.javastart.task.phone.Phone;

public class Test {

    public static void main(String[] args) {

        Phone prePaid = new Phone(new PrePaid(1, .10, .20, .5));
        Phone monthly1 = new Phone(new Monthly(99.99, true));
        Phone monthly2 = new Phone(new Monthly(99.99, false));
        Phone mixed = new Phone(new Mixed(1, .1, .2, .5, 1, 1, 1));

        mixed.printAccountState();
        mixed.sendText();
        mixed.sendMms();
        mixed.call(30);
        mixed.printAccountState();
        mixed.call(35);
        mixed.printAccountState();
        mixed.call(240);
        mixed.sendText();
        mixed.sendMms();
        mixed.printAccountState();
    }
}
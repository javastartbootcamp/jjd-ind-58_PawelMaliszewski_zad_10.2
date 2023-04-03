package pl.javastart.task;

import pl.javastart.task.contracts.Mixed;
import pl.javastart.task.contracts.Monthly;
import pl.javastart.task.contracts.PrePaid;
import pl.javastart.task.phone.Phone;

public class Main {

    public static void main(String[] args) {

        Phone prePaid = new Phone(new PrePaid(1, .10, .20, .5));
        Phone monthly1 = new Phone(new Monthly(100, true));
        Phone monthly2 = new Phone(new Monthly(100, false));
        Phone mixed = new Phone(new Mixed(100, .1, .2, .5, 1, 1, 1));

        prePaid.printAccountState();
        prePaid.sendMms();
        prePaid.sendText();
        prePaid.call(30);
        prePaid.printAccountState();
        prePaid.call(100);
        prePaid.printAccountState();

        mixed.printAccountState();
        mixed.sendText();
        mixed.sendMms();
        mixed.call(30);
        mixed.printAccountState();
        mixed.call(30);
        mixed.printAccountState();
        mixed.call(600);
        mixed.sendText();
        mixed.sendMms();
        mixed.printAccountState();

        monthly1.printAccountState();
        monthly1.sendText();
        monthly1.sendMms();
        monthly1.call(1000);
        monthly1.printAccountState();

        System.out.println("=====================");

        monthly2.printAccountState();
        monthly2.sendText();
        monthly2.sendMms();
        monthly2.call(1000);
        monthly2.printAccountState();
    }
}
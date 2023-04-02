package pl.javastart.task;

import pl.javastart.task.contracts.Mixed;
import pl.javastart.task.contracts.Monthly;
import pl.javastart.task.contracts.PrePaid;
import pl.javastart.task.phone.Phone;

public class Test {

    public static void main(String[] args) {

        Phone prePaid = new Phone(new PrePaid(1, .10, .20, .5));
        Phone monthly1 = new Phone(new Monthly(true));
        Phone monthly2 = new Phone(new Monthly(false));
        Phone mixed = new Phone(new Mixed(10, .1, .2, .5, 1, 1, 1));

        prePaid.printAccountState();
        prePaid.call(10);
        prePaid.sendText();
        prePaid.sendMms();
        prePaid.printAccountState();
        prePaid.call(1000);
        prePaid.printAccountState();

        System.out.println("============================================");

        monthly1.printAccountState();
        monthly1.call(10);
        monthly1.call(600);
        monthly1.sendText();
        monthly1.sendText();
        monthly1.sendText();
        monthly1.sendMms();
        monthly1.sendMms();
        monthly1.sendMms();
        monthly1.printAccountState();
        monthly1.call(1000);
        monthly1.call(1000);
        monthly1.printAccountState();

        System.out.println("============================================");

        monthly2.printAccountState();
        monthly2.call(10);
        monthly2.sendText();
        monthly2.sendMms();
        monthly2.printAccountState();

        System.out.println("============================================");

        mixed.printAccountState();
        mixed.call(60);
        mixed.sendText();
        mixed.sendMms();
        mixed.printAccountState();
        mixed.call(30);
        mixed.printAccountState();
    }
}

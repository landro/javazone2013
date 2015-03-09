package no.bekk.open.javazone.banking.business;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static no.bekk.open.javazone.banking.business.PDFService.getAccountStatement;

public class AccountSystem {

    private static List<byte[]> cache = new CopyOnWriteArrayList<byte[]>();

    /**
     * Returns account balance
     */
    static double getAccountBalance(String username) {

        try {

            Thread.sleep(100); // ms

//            cache.add(getAccountStatement(username));

            return Math.rint(Math.random() * username.length() * 42);

        } catch (InterruptedException e) {

           throw new RuntimeException("Unable to get account balance from legacy system");

        }

    }

}

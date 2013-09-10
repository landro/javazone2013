package no.bekk.open.javazone.banking.business;

import java.security.SecureRandom;

public class PDFService {

    private static final int SIZE = 2 * 1024 * 1024;

    /**
     * Returns PDF containing account statement
     */
    public static byte[] getAccountStatement(String username) {
        try {

            Thread.sleep(100); // ms
            new SecureRandom().nextBytes(new byte[1000000]);
            return new byte[SIZE];

        } catch (InterruptedException e) {

            throw new RuntimeException("Not able to fetch PDF from database");

        }

    }

}

package no.bekk.open.javazone.banking.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BusinessLogic {

    private static final String ACCOUNT_BALANCE_SESSION_ATTRIBUTE = "accountBalance";

    private static final Lock l = new ReentrantLock();

    public static double getAccountBalance(String username, HttpServletRequest request) {

        HttpSession session = request.getSession();

        Double accountBalance = getAccountBalanceFromSession(session);

        if (accountBalance != null) {

            return accountBalance;

        } else {

            // Have to use lock to protect legacy system
            // that doesn't support concurrent access?
            // TODO ?
            l.lock();
            try {
                return getAccountInfoFromLegacySystemAndCacheOnSession(username, session);
            } finally {
                l.unlock();
            }

        }

    }

    private static Double getAccountBalanceFromSession(HttpSession session) {
        return (Double) session.getAttribute(ACCOUNT_BALANCE_SESSION_ATTRIBUTE);
    }

    // Cache stuff on session in order to improve performance TICKET-345
    // TODO ?
    private static Double getAccountInfoFromLegacySystemAndCacheOnSession(String username, HttpSession session) {

        // Set account balance on session
        Double accountBalance = AccountSystem.getAccountBalance(username);
        session.setAttribute(ACCOUNT_BALANCE_SESSION_ATTRIBUTE, accountBalance);

        return accountBalance;

    }

}

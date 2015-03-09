package no.bekk.open.javazone.banking.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BusinessLogic {

	private static final String ACCOUNT_BALANCE_SESSION_ATTRIBUTE = "accountBalance";

	// Have to synchronize to protect legacy system
	// TODO ?
	public static synchronized double getAccountBalance(String username, HttpServletRequest request) {

		HttpSession session = request.getSession();

		Double accountBalance = getAccountBalanceFromSession(session);

		if (accountBalance != null) {

			return accountBalance;

		} else {

			return getAccountInfoFromLegacySystemAndCacheOnSession(username, session);

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

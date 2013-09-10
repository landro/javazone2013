package no.bekk.open.javazone.banking.servlets;

import no.bekk.open.javazone.banking.business.BusinessLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.currentTimeMillis;

public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getRemoteUser();

        // Get account balance
        long start = currentTimeMillis();
        double accountBalance = BusinessLogic.getAccountBalance(user, req);
        long duration = currentTimeMillis() - start;

        // Set attributes on request for presentation purposes
        req.setAttribute("user", user);
        req.setAttribute("accountBalance", accountBalance);
        req.setAttribute("duration", duration);

        // Forward to view
        req.getRequestDispatcher("../WEB-INF/jsp/banking/account.jsp").forward(req, resp);

    }

}

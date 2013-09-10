package no.bekk.open.javazone;

import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

    private static final Logger LOG = Log.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        WebAppContext context = new WebAppContext("src/main/webapp", "/");

        HashLoginService loginService = new HashLoginService();
        loginService.setName("Test Realm");
        loginService.setConfig("src/main/resources/realm.properties");
        server.addBean(loginService);

        //context.setParentLoaderPriority(true);

        server.setHandler(context);

        server.start();
        server.join();
    }


}

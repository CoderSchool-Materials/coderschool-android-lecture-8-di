import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Created by ckung on 4/4/17.
 */
public class Program {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new ServerModule());

        Server server = injector.getInstance(Server.class);
        server.start(7000);
    }
}

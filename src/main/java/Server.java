import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ckung on 4/4/17.
 */
public class Server {

    private final ExecutorService clientProcessingPool;
    private final Provider<ClientTask> clientTaskProvider;

    @Inject
    public Server(ExecutorService servicePool, Provider<ClientTask> clientTaskProvider) {
        this.clientProcessingPool = servicePool;
        this.clientTaskProvider = clientTaskProvider;
    }

    public void start(int port) {
        Runnable serverTask = new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(port);
                    System.out.println("Waiting for clients to connect...");
                    while (true) {
                        Socket clientSocket = serverSocket.accept();

                        clientProcessingPool.submit(clientTaskProvider.get().setSocket(clientSocket));
                    }
                } catch (IOException e) {
                    System.err.println("Unable to process client request");
                    e.printStackTrace();
                }
            }
        };
        Thread serverThread = new Thread(serverTask);
        serverThread.start();
    }
}

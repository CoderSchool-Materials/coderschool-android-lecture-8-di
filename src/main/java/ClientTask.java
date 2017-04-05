import javax.inject.Inject;
import javax.inject.Provider;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * Created by ckung on 4/4/17.
 */
public class ClientTask implements Runnable {

    private final ExecutorService handleVideoProcessingPool;
    private final Provider<VideoProcessingTask> videoProcessingTaskProvider;
    private Socket clientSocket;

    @Inject
    public ClientTask(ExecutorService service, Provider<VideoProcessingTask> videoProcessingTaskProvider) {
        this.handleVideoProcessingPool = service;
        this.clientSocket = clientSocket;
        this.videoProcessingTaskProvider = videoProcessingTaskProvider;
    }

    public ClientTask setSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
        return this;
    }

    @Override
    public void run() {
        System.out.println("Got a client !");

        handleVideoProcessingPool.submit(videoProcessingTaskProvider.get());

        // Do whatever required to process the client's request

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

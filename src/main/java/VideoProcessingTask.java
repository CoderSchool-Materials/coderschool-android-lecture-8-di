import javax.inject.Inject;

/**
 * Created by ckung on 4/4/17.
 */
public class VideoProcessingTask implements Runnable {

    private final VideoProcessExecution execution;

    @Inject
    public VideoProcessingTask(VideoProcessExecution execution) {
        this.execution = execution;
    }

    @Override
    public void run() {
        System.out.println(execution.startProcessing());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(execution.endProcessing());
    }
}

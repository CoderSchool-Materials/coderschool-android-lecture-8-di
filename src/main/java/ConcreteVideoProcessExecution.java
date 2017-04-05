/**
 * Created by ckung on 4/4/17.
 */
public class ConcreteVideoProcessExecution implements VideoProcessExecution {
    @Override
    public String startProcessing() {
        return "starting video";
    }

    @Override
    public String endProcessing() {
        return "ending processing";
    }
}

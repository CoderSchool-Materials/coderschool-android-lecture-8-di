/**
 * Created by ckung on 4/4/17.
 */
public class FunnyVideoProcessExecution implements VideoProcessExecution {
    @Override
    public String startProcessing() {
        return "i hope this works";
    }

    @Override
    public String endProcessing() {
        return "yes! it worked";
    }
}

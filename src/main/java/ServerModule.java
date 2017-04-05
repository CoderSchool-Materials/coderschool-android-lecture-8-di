import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ckung on 4/4/17.
 */
public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ExecutorService.class).toInstance(Executors.newFixedThreadPool(100));
        bind(VideoProcessExecution.class).to(FunnyVideoProcessExecution.class);
    }
}

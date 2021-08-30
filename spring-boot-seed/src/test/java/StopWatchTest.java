import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

/**
 * @author xiaopeng
 * @date 2021年03月25日 15:13
 * @description
 */
public class StopWatchTest {
    @Test
    public void StopWatchMethod() throws InterruptedException {
        StopWatch sw = new StopWatch("test");
        sw.start("task1");
        // do something
        Thread.sleep(100);
        sw.stop();
        sw.start("task2");
        // do something
        Thread.sleep(200);
        sw.stop();
        System.out.println("sw.prettyPrint()~~~~~~~~~~~~~~~~~");
        System.out.println(sw.prettyPrint());
    }
}

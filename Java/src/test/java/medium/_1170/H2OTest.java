package medium._1170;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

public class H2OTest {

    @Test
    public void test() throws InterruptedException {
        H2O h2O = new H2O();

        String s = "OHOHOHOHOHOHOHOHO";
        ExecutorService executorService = Executors.newCachedThreadPool();
        // for (char c : s.toCharArray()) {
        //     executorService.submit(new Runnable() {
        //         @Override
        //         public void run() {
        //             if (c == 'H') {
        //                 h2O.hydrogen();
        //             } else {
        //
        //             }
        //         }
        //     });
        // }

    }
}
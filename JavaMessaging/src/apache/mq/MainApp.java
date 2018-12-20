package apache.mq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MainApp {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(10);

        IntStream.range(1,100).forEach(
                x-> ex.submit(new Thread(new ProducerWorkerThread()))
        );

        ExecutorService consumers = Executors.newFixedThreadPool(10);
        IntStream.range(1,10).forEach(
                x-> consumers.submit(new Thread(new ConsumerWorkerThread()))
        );

        ex.shutdown();
        consumers.shutdown();
//
//        ex.awaitTermination(2, TimeUnit.MINUTES);
//        consumers.awaitTermination(1, TimeUnit.HOURS);
    }
}

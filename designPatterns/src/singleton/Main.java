package singleton;

import singleton.firstImplementation.FirstImplementation;
import singleton.firstImplementation.ThreadClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        ThreadClient tc = new ThreadClient(FirstImplementation.getInstance());
        ExecutorService ex = Executors.newFixedThreadPool(10);
        for (int i = 0 ;i <1000 ;i ++){
            ex.submit(tc);
        }
        ex.awaitTermination(100, TimeUnit.SECONDS);

    }


}

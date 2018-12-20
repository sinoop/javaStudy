package lock.intrinsic;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        IntStream.range(1,11).forEach(x-> new Thread(new Worker(x)).start());
    }
}

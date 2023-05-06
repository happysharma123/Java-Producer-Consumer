import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> q = (Queue<Integer>) new ArrayQueue<Integer>(16);

        BlockingQueue<Integer> queue = new BlockingQueue<Integer>(q, 16);

        final Runnable producer = () -> {
            while (true) {
                int x = 10;
                queue.put(x);

            }
        };

        new Thread(producer).start();


        final Runnable consumer = () -> {
            while (true) {
                int i = queue.take();
//                process(i);
            }
        };

        new Thread(consumer).start();

    }
}
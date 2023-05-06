import java.util.Queue;

public class WaitAndNotify<E> {

    private Object notEmpty = new Object();
    private Object notFull = new Object();

    private Queue<E> queue;
    private int max = 16;

    public synchronized void put(E e) throws InterruptedException {
        while (queue.size() == max) {
            notFull.wait();
        }
        queue.add(e);
        notEmpty.notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        if (queue.size() == 0) {
            notEmpty.wait();
        }
        E item = queue.remove();
        notFull.notifyAll();
        return item;
    }
}

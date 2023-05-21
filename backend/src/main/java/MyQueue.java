import java.util.LinkedList;

public class MyQueue<T> {
    private LinkedList<T> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public void push(T data) {
        queue.addLast(data);
    }

    public T pop() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }
}
public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println(queue.pop()); // 输出1
        System.out.println(queue.pop()); // 输出2
        System.out.println(queue.pop()); // 输出3

        queue.push(6);
        queue.push(7);

        System.out.println(queue.pop()); // 输出4
        System.out.println(queue.pop()); // 输出5
        System.out.println(queue.pop()); // 输出6
        System.out.println(queue.pop()); // 输出7

        System.out.println(queue.pop()); // 输出null
    }
}
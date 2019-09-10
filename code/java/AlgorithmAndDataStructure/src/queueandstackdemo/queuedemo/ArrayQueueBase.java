package queueandstackdemo.queuedemo;

/**
 * @author xiaolei
 * 数组队列
 * enqueue()入队
 * dequeue()出队
 */
public class ArrayQueueBase {
    private String[] items;
    // 总容量
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueueBase(int capacity) {
        items = new String[capacity];
        n = capacity;
    }
    public ArrayQueueBase() {
        this(20);
    }
    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            // 如果有空余空间，则搬运一次数据
            for (int i = head; i < tail; i ++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail ++;
        return true;
    }
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head ++;
        return ret;
    }
}

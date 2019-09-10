package queueandstackdemo.queuedemo;

/**
 * @author xiaolei
 */
public interface IQueue<E> {
    /**
     * getSize() queue的长度
     * isEmpty() 是否为空
     * enqueue() 入队
     * dequeue() 出队
     * getFront() 查看队首的元素
     */
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}

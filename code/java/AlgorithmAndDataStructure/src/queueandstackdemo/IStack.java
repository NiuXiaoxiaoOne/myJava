package queueandstackdemo;

/**
 * @author xiaolei
 * ArrayIStack.java的接口
 *
 * [     ]peek()栈顶  <- addLast(E e)/removeLast()
 */
public interface IStack<E> {
    /**
     * getSize() 查看长度
     * isEmpty() 是否为空
     * pop() 出栈
     * push() 入栈
     * peek() 查看栈顶的元素
     */
    int getSize();
    boolean isEmpty();
    E pop();
    E peek();
    void push(E e);
}

package arraydemo;

/**
 * @author xiaolei
 * 数据元素的基本操作
 */
public interface List<T> {
    public boolean isEmpty();
    int length();
    T get(int i);
    boolean set(int i, T x);
    void add(int i, T x);
    T remove(int i);
    int indexOf(T x);
}

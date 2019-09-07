package arraydemo;

import java.util.Iterator;

/**
 * @author xiaolei
 */
public abstract class AbsList<T> implements Iterable<T>, List<T> {
    protected int length;
    @Override
    abstract public T get(int i);
    @Override
    abstract public boolean set(int i, T x);
    abstract public int indexOf(int begin, int end, T o);
    @Override
    abstract public void add(int i, T x);
    abstract public void clear();
    @Override
    abstract public T remove(int i);
    @Override
    abstract public Iterator<T> iterator();
    @Override
    public boolean isEmpty() {return length==0;}
    @Override
    public int length() {return length;}
    public void add(T x) {add(length, x);}
    public void append(T x) {add(length, x);}
    @Override
    public int indexOf(T o) {
        return indexOf(0, length, o);
    }
    public T remove(T o) {
        return remove(indexOf(o));
    }
}

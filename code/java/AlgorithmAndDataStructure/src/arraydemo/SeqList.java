package arraydemo;

import java.util.Arrays;

/**
 * @author xiaolei
 */
public class SeqList<T> extends AbsList<T> implements Iterable<T> {

    private String[] data;
    private int myLength;
    private int incrementSize;

    /* 构造方法 */

    public SeqList(int initLen) {
        if (initLen <= 0) {
            initLen = 16;
        }
        myLength = 0;
        incrementSize = 0;
        data = new String[initLen];
    }
    public SeqList() { this(16); }
    // 用数组elem来初始化列表【要对elem列表进行判断】
    public SeqList(T[] elem) {
        myLength = elem.length;
        incrementSize = 0;
        data = (String[]) Arrays.copyOf(elem, length);
    }
    /* 容量问题 */

    public void setCapacity(int newSize) { data = Arrays.copyOf(data, newSize); }
    public int getCapacity() { return data.length; }
    public void setIncr(int inc) { incrementSize = inc; }
    private void grow() {
        int newSize = data.length + incrementSize;
        data = Arrays.copyOf(data, newSize);
    }
    /* 取值问题 */
    @Override
    public T get(int i) {
        if (i < 0 || i > length - 1) {
            return null;
        }
        return (T) data[i];
    }
    @Override
    public boolean set(int i, T x) {
        if (i < 0 || i > length - 1) {
            return false;
        } else {
            data[i] = (String) x;
            return true;
        }
    }
}

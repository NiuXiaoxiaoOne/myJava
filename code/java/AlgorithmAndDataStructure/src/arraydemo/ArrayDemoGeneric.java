package arraydemo;

/**
 * @author xiaolei
 * ArrayDemo.java的泛型实现
 * 增添动态增加或减少数组大小
 */
public class ArrayDemoGeneric<E> {
    private E[] data;
    private int size;

    public ArrayDemoGeneric(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    public ArrayDemoGeneric(){
        this(10);
    }

    /**
     * getSize()获取元素个数
     * getCapacity()获取元素容量
     * isEmpty()数组是否为空
     */
    public int getSize(){
        return size;
    }
    public E getFirst() {
        return data[0];
    }
    public E getLast() {
        return data[size - 1];
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * add()添加元素
     * @param index 索引
     * @param e 值
     */
    public void add(int index, E e){
        if (size == data.length){
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        for (int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }
    public void addFirst(E e) {
        add(0, e);
    }
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * update
     * get() 获得index位置的元素
     * set() 修改data[index]为e
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * find
     * contains() 查找数组中是否有元素e,返回true/false
     * find() 查找数组元素e的索引,未找到则返回-1
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * delete
     * remove() 删除index位置的元素,返回该元素
     * removeFirst/Last() 删除第一个/最后一个元素
     * removeElement() 删除元素e
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        // 空下来的data[size]不是真正的去掉了,应该进行回收
        data[size] = null;

        if (size < data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }
    public E removeFirst() {
        return remove(0);
    }
    public E removeLast() {
        return remove(size - 1);
    }
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * resize() 将数组空间编程newCapacity大小
     */
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}

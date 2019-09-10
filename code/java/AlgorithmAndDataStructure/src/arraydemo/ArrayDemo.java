package arraydemo;

/**
 * @author xiaolei
 * 实现一个数组
 */
public class ArrayDemo {
    private int[] data;
    private int size;

    public ArrayDemo(int capacity){
        data = new int[capacity];
        size = 0;
    }
    public ArrayDemo(){
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
    public void add(int index, int e){
        if (size == data.length){
            throw new IllegalArgumentException("Add failed. Array is full.");
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
    public void addFirst(int e) {
        add(0, e);
    }
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * update
     * get() 获得index位置的元素
     * set() 修改data[index]为e
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }
    public void set(int index, int e) {
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
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
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
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        return ret;
    }
    public int removeFirst() {
        return remove(0);
    }
    public int removeLast() {
        return remove(size - 1);
    }
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
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

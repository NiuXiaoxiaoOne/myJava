package linkedlistdemo;

import java.util.Random;

/**
 * @author xiaolei
 *
 * 判断find和find2在10000次内，查找key所花费的时间和内存
 * 结论: find2的时间为find的1/2, 内存相同
 */
public class Test {
    /**
     * 判断list中是否有key，若找到则返回其位置，否则返回-1
     * @param list 列表
     * @param n 列表长度
     * @param key 查找对象
     * @return
     */
    public static int find(int[] list, int n, int key) {

        if (list == null || n <= 0) {
            return -1;
        }

        int i = 0;
        while (i < n) {
            if (list[i] == key) {
                return i;
            }
            i ++;
        }
        return -1;
    }
    public static int find2(int[] list, int n, int key) {
        if (list == null || n <= 0) {
            return -1;
        }
        if (list[n-1] == key) {
            return n-1;
        }
        int temp = list[n-1];
        list[n-1] = key;

        int i = 0;
        while (list[i] != key) {
            i ++;
        }
        list[n-1] = temp;

        if (i == n-1) {
            return -1;
        } else {
            return i;
        }
    }

    public static void main(String[] args) {

        Runtime run = Runtime.getRuntime();
        run.gc();

        int[] mylist = {1, 3, 5, 6, 7, 8, 9, 11, 22, 33};
        Random r = new Random();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i ++) {
            Test.find2(mylist, mylist.length, mylist[r.nextInt(mylist.length)]);
        }

        long finallyTime = System.currentTimeMillis() - startTime;
        System.out.println("find function 花费时间: " + finallyTime);
        long start_find = run.freeMemory();
        System.out.println("find function 空闲量: " + start_find);
        run.gc();
        System.out.println("find function 耗费量: " + (start_find - run.freeMemory()));
    }
}

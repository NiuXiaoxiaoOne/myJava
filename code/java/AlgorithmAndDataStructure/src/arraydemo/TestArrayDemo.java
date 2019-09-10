package arraydemo;

/**
 * @author xiaolei
 */
public class TestArrayDemo {
    public static void main(String[] args) {
        ArrayDemoGeneric<Integer> arr = new ArrayDemoGeneric<>(20);
        for (int i = 0; i < 20; i++) {
            arr.addLast(i);
        }
        System.out.println("=== Add() ===");
        System.out.println(arr);

        arr.add(1, 100);
        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        System.out.println("=== Remove() ===");
        arr.remove(2);
        arr.removeElement(-1);
        arr.removeFirst();
        arr.removeLast();
        System.out.println(arr);
        // [1, 2, 3, 4, 5, 6, 7, 8]


    }
}

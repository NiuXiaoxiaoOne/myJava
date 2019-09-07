// 异或
public class ExculsiveOR {

    public static void main(String[] args) {
        // 找出array中没有重复过的数
        int array[] = {2, 3, 3, 4, 5, 4, 5};
        int v = 0;

        for (int i : array) {
            v ^= i;
        }
        System.out.println(v);
    }
}

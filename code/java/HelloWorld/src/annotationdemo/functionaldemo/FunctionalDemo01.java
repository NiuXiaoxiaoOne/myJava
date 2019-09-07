package annotationdemo.functionaldemo;

/**
 * @author xiaolei
 */
public class FunctionalDemo01 {
    public static void main(String[] args) {
//        fun(() -> System.out.println("hello"));
        fun(new IMessage() {
            @Override
            public void toPrint() {
                System.out.println("hello");
            }
        });
    }
    public static void fun(IMessage msg) {
        msg.toPrint();
    }
}

interface IMessage {
    public void toPrint();
}

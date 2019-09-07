package reflectdemo.invocationhandler;

import org.w3c.dom.ls.LSOutput;

/**
 * @author xiaolei
 * 测试动态代理
 */
public class TInvocationHandler {
    public static void main(String[] args) {
        MyInvocationHandler handler = new MyInvocationHandler();
        Subject sub = (Subject) handler.bind(new RealSubject());
        String info = sub.say("xiaozhou", 13);
        System.out.println(info);
    }
}

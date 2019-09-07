package reflectdemo.invocationhandler;

/**
 * @author xiaolei
 */
public interface Subject {
    /**
     * 定义一个类接口，RealSubject.java会实现它，用来测试动态代理的功能
     * @param name
     * @param age
     * @return
     */
    public String say(String name, int age);
}

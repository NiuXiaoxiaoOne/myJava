package reflectdemo.invocationhandler;

/**
 * @author xiaolei
 */
public class RealSubject implements Subject {
    @Override
    public String say(String name, int age) {
        return "name: " + name + " age: " + age;
    }
}

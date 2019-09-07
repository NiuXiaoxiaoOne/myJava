package reflectdemo.classloaderdemo;

/**
 * @author xiaolei
 * ClassLoader是一个抽象类，但没有抽象方法，目的是要让用户自己去继承使用，而不是
 * 直接使用，如果有程序类的文件信息，那么先定义一个类加载器
 *
 * 自定义类加载器
 */
class MyClassLoader extends ClassLoader {
    public Class<?> getMyClass(String className) throws
            ClassNotFoundException {
        // 默认通过CLASSPATH加载
        return super.loadClass(className);
    }
}
/**
 * @author xiaolei
 * 然后创建一个类
 */
class Salgrade {
    public Salgrade() {
        System.out.println("=== This is Salgrade Class! ===");
    }
    public String toPrint() {
        return "rr";
    }
}
/**
 * @author xiaolei
 * 使用自定义类加载器
 */
public class CustomClassLoader {
    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        // 实例化类加载器
        MyClassLoader mcl = new MyClassLoader();
        // 通过类加载器来取得指定的类对象
        Class<?> cls =
                mcl.getMyClass("reflectdemo.classloaderdemo.Salgrade");
        // 实例化该类对象
        System.out.println(cls.newInstance());
        // 调用Salgrade.toPrint()
        Salgrade sal = (Salgrade) cls.newInstance();
        System.out.println(sal.toPrint());
    }
}

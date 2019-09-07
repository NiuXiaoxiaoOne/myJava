package reflectdemo.classloaderdemo;

/**
 * @author xiaolei
 * 查看某类的类加载器以及父类加载器
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        Class<?> cls = ClassLoaderDemo.class;
        // 查看ClassLoaderDemo类的类加载器以及父类加载器
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
    }
}

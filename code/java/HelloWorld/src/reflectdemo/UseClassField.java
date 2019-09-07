package reflectdemo;

import java.lang.reflect.Field;

/**
 * @author xiaolei
 * 通过将类的属性改变为可被外部访问的方式，来设置属性
 */
public class UseClassField {
    public static void main(String[] args)
            throws Exception {
        Class<?> target = null;
        Object obj = null;
        target = Class.forName("reflectdemo.People");
        obj = target.newInstance();
        // 取得name和age属性
        Field nameField = target.getDeclaredField("name");
        Field ageField = target.getDeclaredField("age");
        // 将name和age设置为可被外部访问,而不是private
        nameField.setAccessible(true);
        ageField.setAccessible(true);
        // 设置name和age的内容,相当于setName(),setAge()
        nameField.set(obj, "xiaozhou");
        ageField.set(obj, 13);
        // 查看name和age的内容,相当于getName(),getAge()
        System.out.println("name: " + nameField.get(obj) + "\n" +
                "age: " + ageField.get(obj));
    }
}

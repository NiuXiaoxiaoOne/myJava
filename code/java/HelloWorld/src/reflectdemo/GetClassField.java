package reflectdemo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author xiaolei
 * CurrentClassField: 显示类中的所有属性
 */
class ShowField {
    public void showClassField(Field[] myField) {
        System.out.println("currentClassField: ");
        for (int i = 0; i < myField.length; i ++) {
            Class<?> fieldType = myField[i].getType();
            // 修饰符
            int modifierNumber = myField[i].getModifiers();
            String modifierOfTheField = Modifier.toString(modifierNumber);
            System.out.print(modifierOfTheField + " ");
            // 返回值类型
            System.out.print(fieldType.getName() + " ");
            // 属性名
            System.out.print(myField[i].getName());
            System.out.println("; ");
        }
    }
}
/**
 * @author xiaolei
 */
public class GetClassField {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> c1 = null;
        c1 = Class.forName("reflectdemo.People");

        // 获取本类中的所有属性
        Field myField[] = c1.getDeclaredFields();
        ShowField sh = new ShowField();
        sh.showClassField(myField);
        // 获取父类的所有属性
        System.out.println("===========");
        Field[] fatherField = c1.getFields();
        sh.showClassField(fatherField);

    }


}

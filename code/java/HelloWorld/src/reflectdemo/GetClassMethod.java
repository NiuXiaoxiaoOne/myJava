package reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取类的所有方法并显示
 */
class ShowMethod {
    public void classMethod(Method[] m) {
        for (int i = 0; i < m.length; i ++) {
            // 方法返回值的类型
            Class<?> r = m[i].getReturnType();
            // 全部的参数类型
            Class<?>[] p = m[i].getParameterTypes();
            // 得到方法的修饰符
            int xx = m[i].getModifiers();
            System.out.print(Modifier.toString(xx) + " ");
            // 返回值类型
            System.out.print(r.getName() + " ");
            // 方法名称
            System.out.print(m[i].getName());
            // 方法参数
            System.out.print("(");
            for (int j = 0; j < p.length; j ++) {
                System.out.print(p[j].getName() + " arg" + j);
                if (j < p.length - 1) {
                    System.out.print(", ");
                }
            }
            // 该方法所附带的异常
            Class<?>[] ex = m[i].getExceptionTypes();
            if (ex.length > 0) {
                System.out.print(") throws ");
            } else {
                System.out.print(")");
            }
            for (int k = 0; k < ex.length; k ++) {
                System.out.print(ex[k].getName());
                if (k < ex.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
public class GetClassMethod {
    public static void main(String[] args) throws ClassNotFoundException {
        
        Class<?> c1 = null;
        c1 = Class.forName("reflectdemo.People");
        Method m[] = c1.getMethods();

        ShowMethod sh = new ShowMethod();
        sh.classMethod(m);
    }
}

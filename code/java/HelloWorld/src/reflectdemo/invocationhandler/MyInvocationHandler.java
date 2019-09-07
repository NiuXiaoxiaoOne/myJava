package reflectdemo.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiaolei
 * 定义一个实现InvocationHandler接口的子类实例
 * 用来完成动态代理的具体操作
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object obj;
    public Object bind(Object obj) {
        this.obj = obj;
        // 取得代理对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), this);
    }
    /**
     * 动态调用方法
     * @param proxy 被代理的对象
     * @param method 要调用的方法
     * @param args 方法调用时所需要的参数
     * @return 返回方法的返回信息
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy,
                         Method method, Object[] args) throws Throwable {
        // 调用方法
        Object temp = method.invoke(this.obj, args);
        return temp;
    }
}

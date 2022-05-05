package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 定义动态代理调用处理器
 *
 * @Author hongyi
 * @Date 2022/3/28 0028 15:07
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("依赖实现类实现动态代理");
        System.out.println("invoke方法通过反射调用被代理对象方法:" + method.getName());
        return method.invoke(target, args);
    }

}

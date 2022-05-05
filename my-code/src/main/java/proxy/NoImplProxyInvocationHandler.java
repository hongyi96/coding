package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author hongyi
 * @Date 2022/3/28 0028 15:22
 */

public class NoImplProxyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("不依赖实现类实现动态代理");
        System.out.println("invoke方法返回值: Hello World");
        return "success";
    }

}

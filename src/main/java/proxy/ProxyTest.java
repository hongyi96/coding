package proxy;

import java.lang.reflect.Proxy;

/**
 * @Author hongyi
 * @Date 2022/3/28 0028 15:09
 */

public class ProxyTest {
    public static void main(String[] args) {
        //创建了 Subject 接口的实现类
        Subject subject = new SubjectImpl();
        Subject proxy1 = (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                new ProxyInvocationHandler(subject));

        proxy1.sayHello();

        Subject proxy2 = (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                new Class[]{Subject.class},
                new NoImplProxyInvocationHandler());
        proxy2.sayHello();
    }
}

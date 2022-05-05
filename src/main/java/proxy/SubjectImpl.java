package proxy;

/**
 * @Author hongyi
 * @Date 2022/3/28 0028 15:07
 */

public class SubjectImpl implements Subject {
    @Override
    public String sayHello() {
        System.out.println(" Hello World");
        return "success";
    }
}

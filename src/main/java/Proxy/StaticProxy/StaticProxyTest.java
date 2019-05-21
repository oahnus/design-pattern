package Proxy.StaticProxy;

/**
 * Created by oahnus on 2019/4/1
 * 22:54.
 */
public class StaticProxyTest {
    public static void main(String... args) {
        SubjectProxy proxy = new SubjectProxy(new RealSubject());
        proxy.request();
    }
}

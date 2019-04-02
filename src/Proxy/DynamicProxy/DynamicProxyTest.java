package Proxy.DynamicProxy;

import Proxy.Subject;


/**
 * Created by oahnus on 2019/4/2
 * 22:52.
 */
public class DynamicProxyTest {
    public static void main(String... args) {
        Subject subject = (Subject) new SubjectProxy().getInstance(new RealSubject());
        subject.request();
    }
}

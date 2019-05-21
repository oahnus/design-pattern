package Proxy.MyProxy;

import Proxy.Subject;

/**
 * Created by oahnus on 2019/4/3
 * 1:04.
 */
public class MyProxyTest {
    public static void main(String... args) {
        Subject subject = (Subject) new MySubjectProxy().getInstance(new MyRealSubject());
        subject.request();
    }
}

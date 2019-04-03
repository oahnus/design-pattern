package Proxy.DynamicProxy;

import Proxy.Subject;


/**
 * Created by oahnus on 2019/4/2
 * 22:52.
 */
public class DynamicProxyTest {
    public static void main(String... args) {
        // 将JDK Proxy 生成的class 文件保存到目录中
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Subject subject = (Subject) new SubjectProxy().getInstance(new RealSubject());
        subject.request();
    }
}

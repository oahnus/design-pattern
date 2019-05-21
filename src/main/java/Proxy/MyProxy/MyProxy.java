package Proxy.MyProxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by oahnus on 2019/4/2
 * 23:27.
 *
 * 模拟JDK 中的Proxy类, 类中尽量使用和JDK中相同的方法
 * 模拟类中 忽略了类型判断，空值判断等校验
 */
public class MyProxy {

    private static final String LN = "\r\n";

    private MyInvocationHandler h;

    // 构造函数 将实现MyInvocationHandler接口的对象 保存
    protected MyProxy(MyInvocationHandler h) {
        this.h = h;
    }


    public static Object newProxyInstance(MyProxyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h) {
        try {
            Class<?> proxyClass = getProxyClass0(classLoader, interfaces, h);
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            Object instance = constructor.newInstance(h);
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Class<?> getProxyClass0(MyProxyClassLoader loader,
                                           Class<?>[] interfaces, MyInvocationHandler h) {
        // JDK 使用两个Byte保存接口数量, 2Byte 最大 65536
        if (interfaces.length > 65535) {
            throw new IllegalArgumentException("interface limit exceeded");
        }

        // If the proxy class defined by the given loader implementing
        // the given interfaces exists, this will simply return the cached copy;
        // otherwise, it will create the proxy class via the ProxyClassFactory

        // 缓存
        // proxyClassCache 是 WeakCache的实例，在创建时会由构造函数传入ProxyClassFactory
        // 代理类的生成由 ProxyClassFactory.apply(classLoader, interfaces)方法完成
        // apply 方法的主要工作就是通过 ProxyGenerator.generateProxyClass 动态生成代理类的字节码文件, 并写入磁盘，
        // 如果设置环境变量 sun.misc.ProxyGenerator.saveGeneratedFiles = true JDK 会将生成的代理类class文件保存到  com.sun.proxy目录下
        // 之后通过classloader将代理类编译，加载， 从而得到代理类的实例
//        return proxyClassCache.get(loader, interfaces);

        try {

            // 这里直接通过模拟方法 创建新的代理类
            String sourceStr = generateClassSourceStr(loader, interfaces);

            // 将源代码文件 保存到磁盘
            String path = MyProxy.class.getResource("").getPath();
            File sourceFile = new File(path + "$Proxy0.java");
            FileOutputStream out = new FileOutputStream(sourceFile);
            out.write(sourceStr.getBytes());
            out.flush();

            // 编译生成class
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null ,null, Charset.forName("utf-8"));
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(sourceFile);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 加载class

            Class proxyClass = loader.findClass("$Proxy0");
            sourceFile.delete();
            return proxyClass;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 模拟ProxyGenerator.generateProxyClass 方法, 这里直接使用字符串拼接 生成 .class 文件
     * 这类同样忽略各种校验
     * @param loader
     * @param interfaces
     * @return
     */
    private static String generateClassSourceStr(ClassLoader loader, Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        // 为了简单 写死包名和import
        sb.append("package Proxy.MyProxy;").append(LN);
        sb.append("import Proxy.MyProxy.MyInvocationHandler;").append(LN);
        sb.append("import Proxy.MyProxy.MyRealSubject;").append(LN);
        sb.append("import Proxy.Subject;").append(LN);
        sb.append("import java.lang.reflect.*;").append(LN);
        sb.append("public class $Proxy0 implements ");

        String[] intfNames = new String[interfaces.length];
        for (int i = 0; i < interfaces.length;i++) {
            String name = interfaces[i].getName();
            intfNames[i] = name.substring(name.lastIndexOf(".") + 1);
        }
        // 构造函数
        sb.append(String.join(", ", intfNames)).append(" {").append(LN);
        sb.append("MyInvocationHandler h;").append(LN);
        sb.append("public $Proxy0(MyInvocationHandler h) {").append(LN);
        sb.append("this.h = h;").append(LN);
        sb.append("}").append(LN);

        // 实现接口方法
        List<Method> methodList = new ArrayList<>();
        for (Class<?> anInterface : interfaces) {
            methodList.addAll(Arrays.asList(anInterface.getMethods()));
        }
        for (Method method: methodList) {
            Class<?>[] params = method.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstLetter(clazz.getSimpleName());
                paramNames.append(type + " " +  paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if(i > 0 && i < params.length-1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            // 这里没有导入 返回值 类型的包名
            sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + paramNames.toString() + ") {" + LN);
            sb.append("try{" + LN);
            String name = interfaces[0].getName();
            String intfName = name.substring(name.lastIndexOf(".") + 1);
            sb.append("Method m = " + intfName + ".class.getMethod(\"" + method.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + LN);
            sb.append(((method.getReturnType() != void.class) ? "return " : "") + "this.h.invoke(this,m,new Object[]{" + paramValues + "})" + ";" + LN);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + LN);
            sb.append("throw new UndeclaredThrowableException(e);" + LN);
            sb.append("}");
            sb.append(method.getReturnType() == void.class ? "" : "return null;");
            sb.append("}");
        }
        sb.append("}").append(LN);
        return sb.toString();
    }

    private static String toLowerFirstLetter(String className) {
        char[] chars = className.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }
}

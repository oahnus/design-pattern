package Proxy.MyProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by oahnus on 2019/4/3
 * 0:53.
 */
public class MyProxyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyProxyClassLoader.class.getPackage().getName() + "." + name;
        String path = MyProxyClassLoader.class.getResource("").getPath();
        File classFile = new File(path,name.replaceAll("\\.","/") + ".class");
        if(classFile.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try{
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                byte [] buff = new byte[1024];
                int len;
                while ((len = in.read(buff)) != -1){
                    out.write(buff,0,len);
                }
                return defineClass(className,out.toByteArray(),0,out.size());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}

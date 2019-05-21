package Singleton.SeriableSingleton;

import java.io.*;

/**
 * Created by oahnus on 2019/3/31
 * 12:24.
 */
public class SerializableSingletonTest {
    public static void main(String... args) throws IOException, ClassNotFoundException {
        SerializableSingleton s1 = null;
        SerializableSingleton s2 = SerializableSingleton.getInstance();

        FileOutputStream fos = null;
        fos = new FileOutputStream("SerializableSingleton.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s2);
        oos.flush();
        oos.close();


        FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerializableSingleton) ois.readObject();
        ois.close();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
}

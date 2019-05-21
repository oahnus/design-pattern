package Prototype;

import java.io.*;

/**
 * Created by oahnus on 2019/3/31
 * 23:29.
 */
public class Prototype implements Cloneable, Serializable {

    private String name;

    public Prototype(String name) {
        System.out.println("Init Prototype With Name " + name);
        this.name = name;
    }

    @Override
    protected Object clone() {
        System.out.println("Clone Prototype With Name " + name);
        Object obj = null;
        try {
            obj = this.deepClone();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //从流里读回来
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}

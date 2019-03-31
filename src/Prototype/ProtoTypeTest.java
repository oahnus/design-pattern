package Prototype;

/**
 * Created by oahnus on 2019/3/31
 * 23:44.
 */
public class ProtoTypeTest {
    public static void main(String... args) {
        Prototype prototype = new Prototype("原型");

        Prototype clonedObj1 = (Prototype) prototype.clone();
        Prototype clonedObj2 = (Prototype) prototype.clone();
        Prototype clonedObj3 = (Prototype) prototype.clone();
        Prototype clonedObj4 = (Prototype) prototype.clone();

        System.out.println(prototype);
        System.out.println(clonedObj1);
        System.out.println(clonedObj2);
        System.out.println(clonedObj3);
        System.out.println(clonedObj4);
    }
}

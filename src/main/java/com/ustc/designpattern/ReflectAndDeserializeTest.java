package com.ustc.designpattern;

import com.ustc.designpattern._01singletonpattern.SingletonPattern01;

import java.lang.reflect.Constructor;

/**
 * @author matthew huang
 * @description
 * @date 2019/6/13 2:50 PM
 */
public class ReflectAndDeserializeTest {

    public static void main(String[] args) throws Exception {

        // 正常情况
        SingletonPattern01 s1 = SingletonPattern01.getInstance();
        SingletonPattern01 s2 = SingletonPattern01.getInstance();
        System.out.println(s1 + "\n" + s2);

        // 反射
        Class<SingletonPattern01> clazz = (Class<SingletonPattern01>) Class.forName("com.ustc.designpattern._01singletonpattern.SingletonPattern01");
        Constructor<SingletonPattern01> c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        SingletonPattern01 s3 = c.newInstance();
        SingletonPattern01 s4 = c.newInstance();
        System.out.println(s3 + "\n" + s4);

        // 反序列化
//        FileOutputStream fos = new FileOutputStream("${url}");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(s1);
//        oos.close();
//        fos.close();
//
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("${url}"));
//        SingletonPattern01 s5 = (SingletonPattern01) ois.readObject();
//        System.out.println(s5);

    }
}

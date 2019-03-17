package com.ustc.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Matthew Huang
 * @Date 2019/3/17 15:12
 */
class Person{
    public String name;
    private int age;

    public void property() {
        System.out.println("I'm a human.");
    }

    private void speak(String state) {
        System.out.println("My name is " + name + ", and I come from " + state + ".");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "com.ustc.test.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test{
    @org.junit.Test
    // 通过反射机制创建对象
    public void Test() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;             // Class<com.ustc.test.Person> clazz = com.ustc.test.Person.class;
        Person p = (Person)clazz.newInstance(); // clazz.newInstance();

        Field f1 = clazz.getField("name");
        f1.set(p, "Matthew");

        Field f2 = clazz.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(p, 24);
        System.out.println(p);

        Method m1 = clazz.getMethod("property");
        m1.invoke(p);

        Method m = clazz.getDeclaredMethod("speak", String.class);
        m.setAccessible(true);
        m.invoke(p, "China");

    }

}


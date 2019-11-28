package com.ustc.designpattern._01singletonpattern;

/**
 * @author matthew huang
 * @description 单例模式
 * @date 2019/6/9 10:15 PM
 *
 * 作用：保证一个类只有一个实例，并且提供一个访问该实例的全局访问点。
 * 应用：Windows管理器、读取配置文件、日志、数据库连接池、OS文件系统。
 * 优点：内存占用和系统初始化代价小。
 * 实现方式：饿汉式、懒汉式、双重检测锁式、静态内部类式、枚举单例。
 *
 */
public class SingletonPattern {
    public static void main(String[] args) {
        // 饿汉式：线程安全，调用效率高，不能延迟加载
        SingletonPattern01 sp1 = SingletonPattern01.getInstance();
        // 懒汉式：线程安全，调用效率低，能延迟加载
        SingletonPattern02 sp2 = SingletonPattern02.getInstance();
        // 双重检测锁式：不建议使用
        SingletonPattern03 sp3 = SingletonPattern03.getInstance();
        // 静态内部类式：线程安全，调用效率高，能延迟加载
        SingletonPattern04 sp4 = SingletonPattern04.getInstance();
        // 枚举式：线程安全，调用效率高，不能延迟加载，天然防止反射和反序列化漏洞
        SingletonPattern05 sp5 = SingletonPattern05.INSTANCE;

        /**
         * 说明：（1）单例对象占用资源少，不需要延迟加载时，枚举式优于饿汉式；
         *      （2）单例对象占用资源多，需要延迟加载，静态内部类式优于懒汉式。
         */
    }
}

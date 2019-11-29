package com.ustc.designpattern._01singletonpattern;

/**
 * 懒汉式单例模式
 * 优点：资源效率高。
 * 缺点：调用（并发）效率低。
 */
public class SingletonPattern02
{
    // 不创建实例，真正使用时才加载
    private static SingletonPattern02 instance;

    private SingletonPattern02() {
    }

    // 延时加载（懒加载），需同步防止多线程创建多个实例
    public static synchronized SingletonPattern02 getInstance() {
        if (instance == null) {
            instance = new SingletonPattern02();
        }
        return instance;
    }
}

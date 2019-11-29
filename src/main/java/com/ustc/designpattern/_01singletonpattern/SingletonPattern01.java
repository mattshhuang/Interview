package com.ustc.designpattern._01singletonpattern;

/**
 * 饿汉式单例模式
 * 优点：天然线程安全，调用效率高。
 * 缺点：资源效率低。
 */
public class SingletonPattern01
{
    // 类初始化时就加载这个对象，私有且不可更改，保证类对象唯一
    private static final SingletonPattern01 instance = new SingletonPattern01();

    // 私有构造器
    private SingletonPattern01() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    // 唯一的开发接口
    public static SingletonPattern01 getInstance() {
        return instance;
    }
}

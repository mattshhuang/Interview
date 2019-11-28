package com.ustc.designpattern._01singletonpattern;

/**
 * 静态内部类式单例模式
 * 优点：兼备并发高效调用和懒加载的优势。
 */
public class SingletonPattern04 {
    // 懒加载，静态内部类在使用时加载，天然线程安全
    private static class SingletonPatternClassInstance {
        // 保证只有一个，且只能赋值一次
        private static final SingletonPattern04 instance = new SingletonPattern04();
    }

    public static SingletonPattern04 getInstance() {
        return SingletonPatternClassInstance.instance;
    }

    private SingletonPattern04() {
    }
}

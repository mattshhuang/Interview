package com.ustc.designpattern._01singletonpattern;

/**
 * 双重检测锁式单例模式
 * 说明：由于编译器优化和JVM底层内部模型原因，两个同步块的顺序可能会有调整，出现问题。
 */
public class SingletonPattern03
{
    // volatile关键字：确保本条指令不会因编译器的优化而省略，且要求每次直接读值。
    private volatile static SingletonPattern03 instance;

    private SingletonPattern03() {
    }

    public static SingletonPattern03 getInstance(){
        // 同步放到if语句内，提高调用效率，只在第一次调用时加载
        if (instance == null) {
            SingletonPattern03 sp;
            synchronized (SingletonPattern03.class) {
                sp = instance;
                if (sp == null) {
                    synchronized (SingletonPattern03.class) {
                        if (instance == null) {
                            instance = new SingletonPattern03();
                        }
                    }
                instance = sp;
                }
            }
        }
        return instance;
    }
}

package com.ustc.designpattern._01singletonpattern;

/**
 * 枚举式单例模式
 * 优点：实现简单，避免通过反射和反序列化的漏洞。
 * 缺点：无延迟加载。
 */
public enum SingletonPattern05
{
    // 枚举元素本身就是单例的，INSTANCE就是SingletonPattern05的一个单例
    INSTANCE;

    // 添加需要的操作
    public void singletonPatternOperation() {
        // Todo...
    }
}

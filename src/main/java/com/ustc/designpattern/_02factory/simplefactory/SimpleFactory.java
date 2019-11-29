package com.ustc.designpattern._02factory.simplefactory;

/**
 * @author Matthew
 * @description 简单工厂模式
 * @date 2019-11-29 22:52
 * @version 1.0
 *
 * 说明：又称静态工厂模式，一般使用静态方法。通过接收不同的参数来返回不同的对象实例。
 * 缺点：对于增加类必须修改代码，不符合OCP原则。
 *
 * static关键字：主要作用在于创建独立于具体对象的域变量或者方法。
 *
 */
public class SimpleFactory
{
    public static Car createCar(String type) {
        if ("auto".equals(type)) {
            return new Auto();
        } else if ("audi".equals(type)) {
            return new Audi();
        } else {
            return null;
        }
    }

    public static Car createAuto() {
        return new Auto();
    }

    public static Car createAudi() {
        return new Audi();
    }

    public static void main(String[] args) {
        // 非工厂模式的实例化类：需要知道每个类的创建方式
        new Auto().move();
        new Audi().move();

        // 简单工厂模式实例化类：只需要知道Car接口和创建类方式
        // 方法一
        SimpleFactory.createCar("auto").move();
        SimpleFactory.createCar("audi").move();

        // 方法二
        SimpleFactory.createAuto();
        SimpleFactory.createAudi();
    }
}

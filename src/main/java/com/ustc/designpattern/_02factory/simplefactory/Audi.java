package com.ustc.designpattern._02factory.simplefactory;

/**
 * @author Matthew
 * @version 1.0
 * @description
 * @date 2019-11-29 23:02
 */
public class Audi implements Car
{
    @Override
    public void move() {
        System.out.println("Audi is moving!");
    }
}

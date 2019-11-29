package com.ustc.designpattern._02factory.simplefactory;

/**
 * @author Matthew
 * @version 1.0
 * @description
 * @date 2019-11-29 22:58
 */
public class Auto implements Car
{
    @Override
    public void move() {
        System.out.println("Auto is moving!");
    }
}

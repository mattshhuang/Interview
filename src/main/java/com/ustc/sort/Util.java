package com.ustc.sort;

/**
 * @Author Matthew Huang
 * @Date 2019/2/23 13:25
 */
public class Util {
    public static void swapInt(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void show(int[] array){
        for (int a: array) {
            System.out.print(a + "  ");
        }
        System.out.println();
    }
}

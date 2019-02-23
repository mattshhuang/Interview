package com.ustc.sort;

/**
 * Ñ¡ÔñÅÅÐò
 * @Author Matthew Huang
 * @Date 2019/2/22 14:44
 */
public class SelectSort {
    public static void selectSort(int[] array){
        int len = array.length;
        for (int i = len -1; i > 0; --i){
            boolean flag = false;
            int maxIndex = 0;
            for (int j = 1; j <= i; ++j){
                if (array[j] > array[maxIndex]){
                    maxIndex = j;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }

        for (int a: array) {
            System.out.print(a + "  ");
        }
        System.out.println();
    }
}

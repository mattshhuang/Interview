package com.ustc.sort;

/**
 * Ï£¶ûÅÅÐò
 * @Author Matthew Huang
 * @Date 2019/2/22 14:44
 */
public class ShellSort {
    public static void shellSort(int[] array){
        int len = array.length;
        for (int gap = len/2; gap > 0; gap /= 2){
            for (int i = gap; i < len; ++i){
                if (array[i - gap] > array[i]){
                    Util.swapInt(array, i, i - gap);
                }
            }
        }

        for (int a: array) {
            System.out.print(a + "  ");
        }
        System.out.println();
    }
}

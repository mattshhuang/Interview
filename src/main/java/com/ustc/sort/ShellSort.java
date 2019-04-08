package com.ustc.sort;

/**
 * 希尔排序
 * @Author Matthew Huang
 * @Date 2019/2/22 14:44
 */
public class ShellSort {
    public static void shellSort(int[] array){
        int len = array.length;
        for (int gap = len/2; gap > 0; gap /= 2){
                for (int i = array.length - 1; i > gap - 1; i--){
                    if (array[i] < array[i - gap])
                        Util.swapInt(array, i, i - gap);
                }
            }

        Util.show(array);
    }
}

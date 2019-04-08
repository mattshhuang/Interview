package com.ustc.sort;

/**
 * 冒泡排序
 * @Author Matthew Huang
 * @Date 2019/2/22 14:44
 */
public class BubbleSort {
    public static void bubbleSort(int[] array){
        int len = array.length;
        for (int i = len - 1; i > 0; --i){
            boolean flag = false;
            for (int j = 0; j < i; ++j){
                if (array[j] > array[j+1]){
                    Util.swapInt(array, j, j+1);
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }

        Util.show(array);
    }
}

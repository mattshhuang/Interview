package com.ustc.sort;

/**
 * 插入排序
 * @Author Matthew Huang
 * @Date 2019/2/22 14:44
 */
public class InsertSort {
    public static void insertSort(int[] array){
        int len = array.length;
        for (int i = 1; i < len; ++i){
            for (int j = i; j > 0; --j){
                if (array[j] < array[j-1]){
                    Util.swapInt(array, j, j-1);
                }else
                    break;
            }
        }
        Util.show(array);
    }
}

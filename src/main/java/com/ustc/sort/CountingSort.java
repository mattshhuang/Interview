package com.ustc.sort;

import java.util.Arrays;

/**
 * @Author Matthew Huang
 * @Date 2019/2/23 19:48
 */
public class CountingSort {
//    public static void countingSort(int[] array){
//        // 先求出最大、最小值
//        int min = array[0], max = array[0];
//        for (int i = 1; i < array.length; ++i){
//            min = Math.min(array[i], min);
//            max = Math.max(array[i], max);
//        }
//
//        // 构建桶
//        int base = 0 - min;
//        int[] bucket = new int[max - min + 1];
//        Arrays.fill(bucket, 0);
//        for (int i = 0; i < array.length; ++i){
//            ++bucket[array[i] + base];
//        }
//
//        // 输出桶中的数据到待排序数组
//        int i = 0, iBucket = 0;
//        while (i < array.length){// 如果是 for 类型则不好表示
//            if (bucket[iBucket] != 0){
//                array[i] = iBucket - base;
//                --bucket[iBucket];
//                ++i;// 只有不等于零时，i 才加一
//            }else {
//                ++iBucket;
//            }
//        }
//
//        for (int a: array) {
//            System.out.print(a + "  ");
//        }
//        System.out.println();
//    }
}


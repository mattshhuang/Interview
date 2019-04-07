package com.ustc.sort;

import java.util.Arrays;

/**
 * @Author Matthew Huang
 * @Date 2019/2/23 19:48
 */
public class CountingSort {
    public static void countingSort(int[] array){
        // 先求出最大、最小值
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; ++i){
            min = Math.min(array[i], min);
            max = Math.max(array[i], max);
        }

        // 构建桶
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; ++i){
            ++bucket[array[i] - min];
        }

        // 输出桶中的数据到待排序数组
        int i = 0, iBucket = 0;
        while (i < array.length){// 如果是 for 类型则不好表示
            if (bucket[iBucket] != 0){
                array[i] = iBucket + min;
                --bucket[iBucket];
                ++i;// 只有不等于零时，i才加一
            }else {
                ++iBucket;
            }
        }
//        //另一种输出方法：因为桶中数值只有0，1，其他，三种特殊情况，可以枚举考虑
//        for (int i = 0, j = 0; i < bucket.length; i++) {
//            if (bucket[i] == 0)
//                continue;
//            if (bucket[i] == 1) {
//                array[j++] = i + min;
//                continue;
//            }
//            while (bucket[i] >= 0){
//                array[j++] = i + min;
//                bucket[i]--;
//            }
//        }

        Util.show(array);
    }
}


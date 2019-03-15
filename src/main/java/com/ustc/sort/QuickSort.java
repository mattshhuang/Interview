package com.ustc.sort;

/**
 * 快速排序
 * @Author Matthew Huang
 * @Date 2019/2/23 13:01
 */
public class QuickSort {
//    public static void quickSort(int[] array){
//        array = quick(array, 0, array.length-1);
//        for (int a: array) {
//            System.out.print(a + "  ");
//        }
//        System.out.println();
//    }
//
//    /**
//     * 算法主要逻辑部分
//     * @param array
//     * @param start
//     * @param end
//     * @return
//     */
//    private static int[] quick(int[] array, int start, int end){
//        int len = array.length;
//        if (len < 1 || start < 0 || end >= len || start > end){
//            return null;
//        }
//        int smallIndex = patition(array, start, end);
//        if (smallIndex > start){
//            quick(array, start, smallIndex - 1);
//        }
//        if (smallIndex < end){
//            quick(array, smallIndex + 1, end);
//        }
//        return array;
//    }
//
//    /**
//     *
//     * @param array
//     * @param start
//     * @param end
//     * @return
//     */
//    private static int patition(int[] array, int start, int end){
//        int smallIndex = start - 1;
//        int pivot = (int)(start + Math.random() * (end - start + 1));
//        Util.swapInt(array, pivot, end);
//        for (int i = start; i <= end; ++i){
//            if (array[i] <= array[end]){
//                ++smallIndex;
//                if (smallIndex < i){
//                    Util.swapInt(array, smallIndex, i);
//                }
//            }
//        }
//        return smallIndex;
//    }
}

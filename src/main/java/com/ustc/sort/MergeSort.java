package com.ustc.sort;

import java.util.Arrays;

/**
 * ¶þÂ·¹é²¢ÅÅÐò
 * @Author Matthew Huang
 * @Date 2019/2/23 13:00
 */
public class MergeSort {
    public static void mergeSort(int[] array){
        for (int a: merge1(array)) {
            System.out.print(a + "  ");
        }
        System.out.println();
    }

    private static int[] merge1(int[] array){
        if (array.length < 2){
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge2(merge1(left), merge1(right));
    }

    private static int[] merge2(int[] left, int[] right){
        int result[] = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0;
            index < result.length; ++index){
            if (i >= left.length){
                result[index] = right[j++];
            }else if (j >= right.length){
                result[index] = left[i++];
            }else if (left[i] <= right[j]){
                result[index] = left[i++];
            }else{
                result[index] = right[j++];
            }
        }
        return result;
    }
}

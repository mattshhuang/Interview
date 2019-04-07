package com.ustc.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author Matthew Huang
 * @Date 2019/4/7 13:05
 */
public class TwoSum_1 {
    @Test
    public void test(){
        int[] nums = {3,2,2,4};

        for (int n : twoSum(nums, 6)) {
            System.out.print(n + " ");
        }

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if (hashMap.containsKey(temp) )//&& hashMap.get(temp) != i)
                return new int[]{hashMap.get(temp), i};
            hashMap.put(nums[i], i); //精髓之处，这个元素在放入map之前判断，免去了重复、首位等特殊情况的判断
        }
        return null;
    }
}

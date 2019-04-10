package com.ustc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @Author Matthew Huang
 * @Date 2019/4/10 14:14
 */
public class SubsetsII_90 {
    @Test
    public void test() {
        int[] nums = {2,1,2};
        List list = subsetsWithDup(nums);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        //递归放入
        addElem(nums, 0, temp, list);
        //Set<List<Integer>> set = new HashSet<>(list);
        return new ArrayList<>(new HashSet<>(list));
    }

    private void addElem(int[] nums, int n, List<Integer> temp, List<List<Integer>> list) {
        if (n >= nums.length) {
            List addTemp = new ArrayList(temp);
            list.add(addTemp);
            //list.add(temp);//如果直接放入temp，则所有结果都等于最后一次放入的情况
            return;
        }

        temp.add(nums[n]);
        addElem(nums, n + 1, temp, list);

        temp.remove(temp.size() - 1);
        addElem(nums, n + 1, temp, list);
    }
}

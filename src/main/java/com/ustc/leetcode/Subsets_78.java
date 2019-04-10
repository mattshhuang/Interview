package com.ustc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Matthew Huang
 * @Date 2019/4/10 12:42
 */
public class Subsets_78 {
    @Test
    public void test() {
        int[] nums = {1,2,3};
        List list = subsets(nums);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> temp = new ArrayList<>();
        //递归放入
        addElem(nums, 0, temp, list);
        return list;
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

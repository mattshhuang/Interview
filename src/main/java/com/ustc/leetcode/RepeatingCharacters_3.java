package com.ustc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;


/**
 * @Author Matthew Huang
 * @Date 2019/4/7 16:11
 */
public class RepeatingCharacters_3 {
    @Test
    public void test(){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring1(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }

    public int lengthOfLongestSubstring1(String s) {
        int result = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<>();
        while(right < s.length()) {
            if(!t.contains(s.charAt(right))) {
                t.add(s.charAt(right++));
                result = Math.max(result, t.size());//关心存什么
            }else {
                t.remove(s.charAt(left++));
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); right++){
            if (map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            res = Math.max(res, right - left + 1);//只关心left和right的值，不关心存什么删什么
            map.put(s.charAt(right), right);
        }

        return res;
    }
}

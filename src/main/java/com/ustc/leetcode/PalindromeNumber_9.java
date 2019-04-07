package com.ustc.leetcode;

import org.junit.Test;


/**
 * @Author Matthew Huang
 * @Date 2019/4/7 18:03
 */
public class PalindromeNumber_9 {
    @Test
    public void test(){
        System.out.println(isPalindrome(-1111));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)  return false;
        if (x < 10) return true;

        String xStr = String.valueOf(x);
        int len = xStr.length();
        for (int i = 0; i < len/2; i++){
            if (xStr.charAt(i) != xStr.charAt(len - i - 1))
                return false;
        }

        return true;
    }
}

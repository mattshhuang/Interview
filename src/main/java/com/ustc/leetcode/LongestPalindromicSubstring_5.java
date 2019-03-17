package com.ustc.leetcode;

import org.junit.Test;

/**
 * give the Longest Palindromic Substring
 * @Author Matthew Huang
 * @Date 2019/3/17 21:33
 */
public class LongestPalindromicSubstring_5 {
    @Test
    public void test(){
        String s = "aacdefcaa";
        System.out.println(longestPalindrome2(s));
    }

    // 2. 中心扩展法
    public String longestPalindrome2(String s) {
        // 反转字符串：String sReverse = new StringBuffer(s).reverse().toString();
        // 字符串转字符数组：char[] ch = s.toCharArray();
        if (s.length() <= 1)
            return s;

        String result = "", temp = "";
        int len = s.length();
        for (int i = 0; i < len; ++i){
            // 虚中心点
            temp = getPalindrome(s, i, i + 1);
            result = result.length() < temp.length() ? temp: result;
            // 实中心点
            temp = getPalindrome(s, i, i);
            result = result.length() < temp.length() ? temp: result;
        }

        return result;
    }

    private String getPalindrome(String str, int coreLeft, int coreRight){
        while (coreLeft>=0 && coreRight < str.length() && str.charAt(coreLeft) == str.charAt(coreRight)){
            --coreLeft;
            ++coreRight;
        }
        return str.substring(coreLeft + 1, coreRight);
    }

    // 1. 动态规划方法
    public String longestPalindrome1(String s) {
        if(s.length() <= 1)
            return s;

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int siteStart = 0, lenMax = 1;

        // 初始化
        for (int i = 0; i < len; ++i){
            dp[i][i] = true;
            if (i < len - 1 && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i + 1] = true;
                siteStart = i;
                lenMax = 2;
            }
        }

        // 考虑长度大于等于3的情况
        for (int k = 3; k <= len; ++k){
            for (int low = 0; low <= len-k; ++low){
                int high = low + k - 1;
                if (dp[low+1][high-1] == true && s.charAt(low) == s.charAt(high)) {
                    dp[low][high] = true;
                    siteStart = low;
                    lenMax = k;
                }
            }
        }
        System.out.println(siteStart + " " + lenMax);
        return s.substring(siteStart, siteStart + lenMax);
    }
}

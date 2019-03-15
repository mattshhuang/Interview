package com.ustc.leetcode;

import org.junit.Test;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * @Author Matthew Huang
 * @Date 2019/3/15 23:02
 */
public class WildcardMatching_44 {
    @Test
    public void test(){
        String s = "";
        String p = "";
        System.out.println(isMatch(s, p));
    }

    public boolean isMatch(String s, String p){
        int sPosition = 0;
        int pPosition = 0;
        int star = 0;       // '*'开始的位置
        int match = -1;     //

        while (sPosition < s.length()){
            // 情形1：当s和p的当前位置字符相同
            if (pPosition < p.length() && s.charAt(sPosition) == p.charAt(pPosition)){
                ++sPosition;
                ++pPosition;
            }
            // 情形2：当p的当前位置字符为'*'
            else if (pPosition < p.length() && p.charAt(pPosition) == '*'){
                star = pPosition;   // 记录'*'的起始位置
                match = sPosition;  // 记录与'*'匹配的当前位置
                ++pPosition;        // p的位置往后移动一位
                // 注意：由于'*'可能匹配空字符，所以s的位置暂时不加
            }
            // 情形3：当p处在'*'，s与之比较
            else if (match != -1){
                pPosition = star + 1;   // p的位置往后移动一位
                ++match;                // s的当前字符与p中的'*'匹配，'*'匹配个数加一
                sPosition = match;      // s的位置往后移动亿为
            }
            // 情形4： 当s和p的当前位置不匹配
            else return false;
        }

        while (pPosition < p.length() && p.charAt(pPosition) == '*'){   // 如果p的最后还有若干个'*'
            ++pPosition;
        }
        return pPosition == p.length(); // 是否匹配即p是否遍历完全
    }
}

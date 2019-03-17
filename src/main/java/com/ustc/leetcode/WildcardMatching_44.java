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
        String s = "ho";  // input s......
        String p = "**ho";  // input p......
        System.out.println(isMatch(s, p));
        System.out.println(isMatch2(s, p));
    }

    /**
     * method 1: logic
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p){
        int sPosition = 0;
        int pPosition = 0;
        int star = 0;       // '*'开始的位置
        int match = -1;     //

        while (sPosition < s.length()){
            // 情形1：当s和p的当前位置字符相同
            if (pPosition < p.length() && (s.charAt(sPosition) == p.charAt(pPosition )|| p.charAt(pPosition) == '?')){
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

    /**
     * method 2: dp
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p){
        // 描述特征
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        f[0][0] = true;

        // 当p以*开头时，可能存在连续的*，故用循环
        for (int j = 1; j <= p.length(); ++j){
            if (p.charAt(j-1) == '*' && f[0][j-1])
                f[0][j] = true;
        }

        // 填充
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    // 前一个字符为'*'，则可能有三种情况：新的一个*、多余的*、持续的*
                    f[i][j] = f[i - 1][j - 1] || f[i - 1][j] || f[i][j - 1];
                } else {
                    // 前一个字符不为'*'，则当前两个字符需要匹配
                    f[i][j] = f[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
        }

        return f[s.length()][p.length()];
    }
}

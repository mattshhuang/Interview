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
        int star = 0;       // '*'��ʼ��λ��
        int match = -1;

        while (sPosition < s.length()){
            // ����1����s��p�ĵ�ǰλ���ַ���ͬ
            if (pPosition < p.length() && (s.charAt(sPosition) == p.charAt(pPosition )|| p.charAt(pPosition) == '?')){
                ++sPosition;
                ++pPosition;
            }
            // ����2����p�ĵ�ǰλ���ַ�Ϊ'*'
            else if (pPosition < p.length() && p.charAt(pPosition) == '*'){
                star = pPosition;   // ��¼'*'����ʼλ��
                match = sPosition;  // ��¼��'*'ƥ��ĵ�ǰλ��
                ++pPosition;        // p��λ�������ƶ�һλ
                // ע�⣺����'*'����ƥ����ַ�������s��λ����ʱ����
            }
            // ����3����p����'*'��s��֮�Ƚ�
            else if (match != -1){
                pPosition = star + 1;   // p��λ�������ƶ�һλ
                ++match;                // s�ĵ�ǰ�ַ���p�е�'*'ƥ�䣬'*'ƥ�������һ
                sPosition = match;      // s��λ�������ƶ���Ϊ
            }
            // ����4�� ��s��p�ĵ�ǰλ�ò�ƥ��
            else return false;
        }

        while (pPosition < p.length() && p.charAt(pPosition) == '*'){   // ���p����������ɸ�'*'
            ++pPosition;
        }
        return pPosition == p.length(); // �Ƿ�ƥ�伴p�Ƿ������ȫ
    }

    /**
     * method 2: dp
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p){
        // ��������
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        f[0][0] = true;

        // ��p��*��ͷʱ�����ܴ���������*������ѭ��
        for (int j = 1; j <= p.length(); ++j){
            if (p.charAt(j-1) == '*' && f[0][j-1])
                f[0][j] = true;
        }

        // ���
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    // ǰһ���ַ�Ϊ'*'�������������������µ�һ��*�������*��������*
                    f[i][j] = f[i - 1][j - 1] || f[i - 1][j] || f[i][j - 1];
                } else {
                    // ǰһ���ַ���Ϊ'*'����ǰ�����ַ���Ҫƥ��
                    f[i][j] = f[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
        }

        return f[s.length()][p.length()];
    }
}

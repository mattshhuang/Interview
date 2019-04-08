package com.ustc.leetcode;

import org.junit.Test;

/**
 * @Author Matthew Huang
 * @Date 2019/3/20 19:06
 */
public class ZigZagConversion_6 {
    @Test
    public void test(){
        String s = "PAYPALISHIR";   // �������������"A" 0; "ABF" 1; "ABF" 6
        int numRows = 2;
        //System.out.println("Result is: " + convert1(s, numRows));
        System.out.println("Result is: " + convert2(s, numRows));
    }

    // O(n), use StringBuilder
    public String convert2(String s, int numRows) {
        int len = s.length();
        // �������
        if (numRows <= 1 || len <= 1 || len <= numRows)
            return s;

        /**
         * StringBuilder:
         * - String -> StringBuilder: StringBuilder(String s)
         * - StringBuilder -> String: StringBuilder.toString()
         * - StringBuilder�ڲ���ʹ��һ������ȥ�洢���ݵ�(char[]֮��Ϊbyte[])���ɱ���ַ����У�String���ɸı䣬ÿ�δ����µĶ���
         * - ��StringBuffer���̰߳�ȫ��
         */
        // ��ʼ��
        StringBuilder[] sb = new StringBuilder[numRows]; // ����Ҫ�ķ�����append()��insert(int, String)
        for(int i = 0; i < numRows; ++i){
            sb[i] = new StringBuilder("");
        }

        // ������ʵ�λ��
        for (int i = 0; i < len; ++i){
            int index = i % (2 * numRows - 2);
            index = index < numRows ? index : 2 * numRows - 2 -index;
            sb[index].append(s.charAt(i));
        }

        // ���
        for (int i = 1; i < numRows; ++i){
            sb[0].append((sb[i]));
        }
        return sb[0].toString();
    }

    // myself
    public String convert1(String s, int numRows) {
        int len = s.length();
        // �������
        if (numRows <= 1 || len <= 1 || len <= numRows)
            return s;

        int flag1 = numRows, flag2 = numRows - 2, numColum;
        if(len/(2*numRows-2) == 0) {
            numColum = (numRows-1) * len/(2*numRows-2);
        } else {
            numColum = (numRows-1) * len/(2*numRows-2) + 1;
        }
        // ��ʼ����ά����
        String[][] result = new String[numRows][numColum];
        String zStr = "";

        int row = 0, colum = 0;
        for(int i = 1; i <= len; ++ i){
            if(flag1 != 0 && flag2 == numRows - 2){
                // ִ��ÿ��numRows��
                result[numRows - flag1][colum] = String.valueOf(s.charAt(i - 1));
                --flag1;
                if (flag1 == 0)
                    ++colum;
            }else if (flag1 == 0 && flag2 != 0){
                // ִ��ÿ��1��
                result[flag2][colum++] = String.valueOf(s.charAt(i - 1));
                --flag2;
            }else if (flag1 == 0 && flag2 == 0){
                // ���һ����Ԫ
                flag1 = numRows;
                flag2 = numRows - 2;
                --i;
            }
        }

        // ���
        for (int i = 0; i < numRows; ++i){
            for (int j = 0; j < numColum; ++j){
                if (result[i][j] != null) {
                    zStr += result[i][j];
                    System.out.print(result[i][j] + " ");
                }else
                    System.out.print("  ");
            }
            System.out.println();
        }

        return zStr;
    }
}

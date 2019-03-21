package com.ustc.leetcode;

import org.junit.Test;

/**
 * 注意：这道题由于只要求输出，故存储的时候不需要存储空字符，连着存储即可！
 * @Author Matthew Huang
 * @Date 2019/3/20 19:06
 */
public class ZigZagConversion_6 {
    @Test
    public void test(){
        String s = "PAYPALISHIR";   // 特殊测试用例："A" 0; "ABF" 1; "ABF" 6
        int numRows = 2;
        //System.out.println("Result is: " + convert1(s, numRows));
        System.out.println("Result is: " + convert2(s, numRows));
    }

    // O(n), use StringBuilder
    public String convert2(String s, int numRows) {
        int len = s.length();
        // 特殊情况
        if (numRows <= 1 || len <= 1 || len <= numRows)
            return s;

        /**
         * StringBuilder:
         * - String -> StringBuilder: StringBuilder(String s)
         * - StringBuilder -> String: StringBuilder.toString()
         * - StringBuilder内部是使用一个数组去存储数据的(char[]之后为byte[])，可变的字符序列；String不可改变，每次创建新的对象
         * - 仅StringBuffer是线程安全的
         */
        // 初始化
        StringBuilder[] sb = new StringBuilder[numRows]; // 最主要的方法是append()和insert(int, String)
        for(int i = 0; i < numRows; ++i){
            sb[i] = new StringBuilder("");
        }

        // 插入合适的位置
        for (int i = 0; i < len; ++i){
            int index = i % (2 * numRows - 2);
            index = index < numRows ? index : 2 * numRows - 2 -index;
            sb[index].append(s.charAt(i));
        }

        // 输出
        for (int i = 1; i < numRows; ++i){
            sb[0].append((sb[i]));
        }
        return sb[0].toString();
    }

    // myself
    public String convert1(String s, int numRows) {
        int len = s.length();
        // 特殊情况
        if (numRows <= 1 || len <= 1 || len <= numRows)
            return s;

        int flag1 = numRows, flag2 = numRows - 2, numColum;
        if(len/(2*numRows-2) == 0) {
            numColum = (numRows-1) * len/(2*numRows-2);
        } else {
            numColum = (numRows-1) * len/(2*numRows-2) + 1;
        }
        // 初始化二维数组
        String[][] result = new String[numRows][numColum];
        String zStr = "";

        int row = 0, colum = 0;
        for(int i = 1; i <= len; ++ i){
            if(flag1 != 0 && flag2 == numRows - 2){
                // 执行每列numRows个
                result[numRows - flag1][colum] = String.valueOf(s.charAt(i - 1));
                --flag1;
                if (flag1 == 0)
                    ++colum;
            }else if (flag1 == 0 && flag2 != 0){
                // 执行每列1个
                result[flag2][colum++] = String.valueOf(s.charAt(i - 1));
                --flag2;
            }else if (flag1 == 0 && flag2 == 0){
                // 完成一个单元
                flag1 = numRows;
                flag2 = numRows - 2;
                --i;
            }
        }

        // 输出
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

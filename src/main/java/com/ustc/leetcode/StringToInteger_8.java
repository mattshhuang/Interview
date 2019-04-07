package com.ustc.leetcode;

import org.junit.Test;

/**题目并不是特别完善，这里只需要满足基本的判断条件即可：+ - 非法 越界
 * @Author Matthew Huang
 * @Date 2019/4/3 13:29
 */
public class StringToInteger_8 {
    @Test
    public void test(){
        System.out.println(myAtoi("+-2"));
        System.out.println(Character.isUpperCase('A'));
    }

    public int myAtoi(String str){
        str = str.trim();
        int numLen = 10;
        long result = 0;
        boolean decimal = false;
        //特殊情况
        if (str.length() == 0 || (str.contains("+") && str.contains("-")))
            return 0;

        //标注负数情况
        if (str.charAt(0) == '-') {
            decimal = true;
            str = (String) str.subSequence(1, str.length());
        }
        else if (str.charAt(0) == '+')
            str = (String) str.subSequence(1, str.length());
        else if (!isNumber(str.charAt(0)))
            return 0;

        if (str.length() == 0)
            return 0;

        //去除前面多余的0
        StringBuilder strSB = new StringBuilder(str);
        for (int i = strSB.length(); i != 0 && strSB.charAt(0) == '0'; --i){
            strSB.delete(0, 1);
        }
        str = strSB.toString();

        //提取数字
        for (int i = 0; i < str.length() && numLen != 0; ++i){
            if (isNumber(str.charAt(i))) {
                result = result * 10 + str.charAt(i) - 48;
                numLen--;
            }
            if (str.charAt(i) == '.')
                break;
        }

        //超过范围输出
        if (decimal && (numLen == 0 || result * -1 < Integer.MIN_VALUE))
            return Integer.MIN_VALUE;
        else if (numLen == 0 || result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        //正常输出
        if (decimal)
            return (int)result * -1;
        else
            return (int)result;
    }

    private boolean isNumber(char c){
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
}

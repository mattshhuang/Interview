package com.ustc.leetcode;

import org.junit.Test;

/**关键问题在于输入的数据在反转后可能越界：[-2^30, 2^30-1]
 * @Author Matthew Huang
 * @Date 2019/4/2 17:13
 */
public class ReverseInteger_7 {
    @Test
    public void test() {
        int x = -2147483648;
        System.out.println(reverse1(x));
    }

    public long reverse1(int x) {
        if (x < -2<<30 || x > (2<<30) - 1 || x == 0)
            return 0;
        boolean isNegative = false;
        long inputLong = x;
        if (inputLong < 0){
            isNegative = true;
            inputLong *= -1;
        }

        String inputStr = String.valueOf(inputLong);
        StringBuilder outputStr = new StringBuilder("-");
        int[] input = new int[inputStr.length()];
        for (int i = 0; i < inputStr.length(); ++i) {
            input[i] = Integer.parseInt(String.valueOf(inputStr.charAt(i)));
            outputStr.insert(1, input[i]);
        }

        long result;
        if (isNegative)
            result = Long.parseLong(String.valueOf(outputStr));
        else
            result = Long.parseLong(String.valueOf(outputStr.deleteCharAt(0)));

        if (result < -2<<30 || result > (2<<30) - 1)
            return 0;
        else
            return (int)result;
    }

    public int reverse2(int x){
        long result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        }
        return (int)result;
    }


}

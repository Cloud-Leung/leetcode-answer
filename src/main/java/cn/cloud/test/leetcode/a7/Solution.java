package cn.cloud.test.leetcode.a7;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * @author liangqiang
 * @date 2019/4/26 4:44 PM
 */
public class Solution {

    public int reverse(int x) {
        boolean isNegative = x < 0;
        long temp = Math.abs((long)x);
        if (temp < 10) {
            return x;
        }
        long reverse = reverseTemp(0, temp);
        long result = (isNegative ? 0 - reverse : reverse);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }

    private long reverseTemp(long result, long temp) {
        long mo = temp % 10;
        if (temp == mo) {
            return result * 10 + mo;
        }
        return reverseTemp(result * 10 + mo, temp / 10);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-2147483648));
    }
}

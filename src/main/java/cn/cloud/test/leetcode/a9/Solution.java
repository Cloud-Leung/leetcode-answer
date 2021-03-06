package cn.cloud.test.leetcode.a9;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @author liangqiang
 * @date 2019/4/26 4:44 PM
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        long temp = (long)x;
        long reverse = reverseTemp(0, temp);
        return reverse == x;
    }

    private long reverseTemp(long result, long temp) {
        long mo = temp % 10;
        if (temp == mo) {
            return result * 10 + mo;
        }
        return reverseTemp(result * 10 + mo, temp / 10);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}

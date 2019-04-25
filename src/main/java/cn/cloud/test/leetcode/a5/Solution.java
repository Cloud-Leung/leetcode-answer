package cn.cloud.test.leetcode.a5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author liangqiang
 * @date 2019/4/25 2:30 PM
 */
public class Solution {

    public String longestPalindrome(String s) {
        //TODO 使用lastindexof的方式统计
        String maxStr = "";
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (sb.toString().contains(String.valueOf(c))) {
                max = sb.toString().length() > max ? sb.toString().length() : max;
                sb = reCal(sb, sb.toString().indexOf(c));
                sb.append(c);
                if (sb.toString().length() > maxStr.length()) {
                    maxStr = sb.toString();
                }
            } else {
                sb.append(c);
            }
        }
        return "".equals(maxStr) ? first(sb) : maxStr;
    }

    private String first(StringBuilder sb) {
        if(sb.toString().equals("")){
            return "";
        }
        return sb.toString().substring(0,1);
    }

    private StringBuilder reCal(StringBuilder sb, int i) {
        String str = sb.toString();
        return new StringBuilder(str.substring(i));
    }

    public static void main(String[] args) {

        String str = "abcba";
        System.out.println(new Solution().longestPalindrome(str));
    }

}

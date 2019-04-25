package cn.cloud.test.leetcode.a3;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author liangqiang
 * @date 2019/4/25 1:39 PM
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (sb.toString().contains(String.valueOf(c))) {
                max = sb.toString().length() > max ? sb.toString().length() : max;
                sb = reCal(sb, sb.toString().indexOf(c));
            }
            sb.append(c);
        }
        return sb.toString().length() > max ? sb.toString().length() : max;
    }

    private StringBuilder reCal(StringBuilder sb, int i) {
        String str = sb.toString();
        return new StringBuilder(str.substring(i + 1));
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(str));
    }

}

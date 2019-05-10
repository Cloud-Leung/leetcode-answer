package cn.cloud.test.leetcode.a14;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author liangqiang
 * @date 2019/4/26 4:44 PM
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        return longestCommonPrefix(strs[0], 1, strs);
    }

    public String longestCommonPrefix(String result, int index, String[] strs) {
        if (index >= strs.length) {
            return result;
        }
        if (result.length() < 1) {
            return "";
        }
        String str = strs[index];
        int length = Math.min(result.length(), str.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (result.charAt(i) == str.charAt(i)) {
                sb.append(str.charAt(i));
            } else {
                break;
            }
        }
        return longestCommonPrefix(sb.toString(), index + 1, strs);
    }

    public static void main(String[] args) {
        String[] s = {"flower", "flow", "flight"};
        System.out.println(new Solution().longestCommonPrefix(s));
    }
}

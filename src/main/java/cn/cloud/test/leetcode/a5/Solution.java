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
 * 解题点：Manacher算法
 * @author liangqiang
 * @date 2019/4/25 2:30 PM
 */
public class Solution {

    public String longestPalindrome(String str) {
        String[] chars = createManacher(str);
        int[] lens = new int[chars.length];
        int maxLen = 0;// 当前最长回文长度
        int index = 0;// 最长回文长度中心位置
        int p; //最长回文串最右边的坐标
        int len;// 当前回文长度
        for (int i = 0; i < chars.length; i++) {
            p = (maxLen - 1) / 2 + index;// 计算出当前最长回文最右侧的坐标
            if (i == 0) {// 第一个字符串回文必定只有自己
                lens[i] = 1;
                maxLen = 1;
                index = i;
                continue;
            }
            if (i > p) {// 如果当前位置在最长回文包含之外，则只能一个个进行回文匹配
                len = cal(1, i, 1, chars);
            } else {// 如果当前位置在最长回文之内，那么当前点相对于最长回文中心的对程点的回文长度  和 当前点和最长回文右侧坐标的差值 中小的值对当前点来说必定是回文，因为回文内是对称的
                // 但如果超出回文范围则不能保证，所以取小的值，超出的范围需再进行匹配
                len = Math.min(lens[2 * index - i], p - i);
                int compair = (len - 1) / 2 + 1;
                len = cal(len, i, compair, chars);
            }
            lens[i] = len;
            if (len > maxLen) {
                maxLen = len;
                index = i;
            }
        }
        int radus = (maxLen - 1) / 2;
        int start = index - radus;
        int end = index + radus;
        return getString(chars, start, end);
    }

    private String getString(String[] chars, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (chars[i].equals("#")) {
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private int cal(int len, int center, int compair, String[] chars) {
        if (center - compair < 0 || center + compair >= chars.length) {
            return len;
        }
        if (!chars[center + compair].equals(chars[center - compair])) {
            return len;
        }
        return cal(len + 2, center, compair + 1, chars);
    }

    private String[] createManacher(String s) {
        String[] manacher = new String[2 * s.length() + 1];
        int writeIndex = 0;
        manacher[writeIndex] = "#";
        writeIndex++;
        for (int i = 0; i < s.length(); i++) {
            manacher[writeIndex] = s.charAt(i) + "";
            writeIndex++;
            manacher[writeIndex] = "#";
            writeIndex++;
        }
        return manacher;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(new Solution().longestPalindrome(str));
    }
}

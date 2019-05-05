package cn.cloud.test.leetcode.a10;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * @author liangqiang
 * @date 2019/4/26 4:44 PM
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int size = Math.max(s.length(), p.length()) + 1;
        Boolean[][] result = new Boolean[size][size];
        return cacheMatch(result, 0, 0, s, p);
    }

    /**
     * 动态规划 并把过程中的计算结果保留 后面的相同计算可直接使用结果
     * @param result
     * @param sindex
     * @param pindex
     * @param s
     * @param p
     * @return
     */
    private boolean cacheMatch(Boolean[][] result, int sindex, int pindex, String s, String p) {
        if (p.length() <= pindex) {
            return s.length() <= sindex;
        }
        if (result[sindex][pindex] != null) {
            return result[sindex][pindex];
        }
        boolean match;
        boolean curMatch = s.length() > sindex && (s.charAt(sindex) == p.charAt(pindex) || '.' == p.charAt(pindex));
        if (p.length() > pindex + 1 && '*' == p.charAt(pindex + 1)) {
            // 当前字符匹配 则当前*可以匹配0次也可以匹配 n 次
            if (curMatch) {
                // 匹配n次或匹配0次
                // 匹配0次则 s不变 p跳过到*的下一个位置
                // 匹配n次则 p不变 s跳到下一个位置
                match = cacheMatch(result, sindex + 1, pindex, s, p) || cacheMatch(result, sindex, pindex + 2, s, p);
            } else {
                // 当前字符不匹配则只能匹配0次 正则跳过*
                match = cacheMatch(result, sindex, pindex + 2, s, p);
            }
        } else {
            // 下一个字符不是 * 则 只有当前匹配并且 后续也匹配才为true
            match = curMatch && cacheMatch(result, sindex + 1, pindex + 1, s, p);
        }
        result[sindex][pindex] = match;
        return match;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(solution.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

package cn.cloud.test.leetcode.a11;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * @author liangqiang
 * @date 2019/4/26 4:44 PM
 */
public class Solution {

    public int maxArea(int[] height) {
        return maxArea(0, 0, height.length - 1, height);
    }

    private int maxArea(int maxArea, int left, int right, int[] height) {
        if (right <= left) {
            return maxArea;
        }
        boolean isRight = Math.min(height[right], height[left]) == height[right];
        int maxAreaTemp = Math.max(maxArea, (right - left) * (isRight ? height[right] : height[left]));
        return maxArea(maxAreaTemp, isRight ? left : left + 1, isRight ? right - 1 : right, height);
    }

    public static void main(String[] args) {
        int[] re = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(re));

    }
}

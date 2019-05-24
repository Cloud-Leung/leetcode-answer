package cn.cloud.test.leetcode.a15;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author liangqiang
 * @date 2019/5/23 11:14 PM
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[length - 1] < 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < length; i++) {
            if (i >= length - 2) {
                break;
            }
            int ri = nums[i];
            if (ri > 0) {
                break;
            }

            if (i > 0 && nums[i - 1] == ri) {
                continue;
            }

            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                if (nums[j] + nums[i] > 0) {
                    break;
                }
                int re = nums[j] + nums[k] + ri;
                if (re == 0) {
                    newList(ri, nums[j], nums[k], result);
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    j++;
                    k--;
                } else if (re > 0) {
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    k--;
                } else {
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    j++;
                }
            }
        }
        return result;
    }

    private void newList(int ri, int num, int num1, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        list.add(ri);
        list.add(num);
        list.add(num1);
        result.add(list);
    }

    public static void main(String[] args) {
        int[] nu = {
            -2, 0, 0, 2, 2};
        System.out.println(new Solution().threeSum(nu));
    }
}

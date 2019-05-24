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
        // 如果第所有数都大于0 或者所有树都小于0 则无解
        if (nums[0] > 0 || nums[length - 1] < 0) {
            return new ArrayList<>();
        }
        // 从第一个开始循环
        // 用两个指针 一个在紧挨着i 另一个放在末尾 然后向内查找满足条件的树
        for (int i = 0; i < length; i++) {
            // 因为需要三个指针，所以最后一个查找的数应该是倒数第三个
            if (i >= length - 2) {
                break;
            }
            int ri = nums[i];
            // 如果当前数已经大于0 则代表后面都是大于0的数 后面不会有解
            if (ri > 0) {
                break;
            }
            // 如果当前树和前一个数一样 可以直接跳过，因为解是一样的
            if (i > 0 && nums[i - 1] == ri) {
                continue;
            }

            int j = i + 1;
            int k = length - 1;
            // 由两端向内查找 小于等于i的位置不用找，因为已经匹配过了
            while (j < k) {
                // 如果j+i就已经大于0，代表j一定大于0 这时候后面已经无解 不用在匹配了
                if (nums[j] + nums[i] > 0) {
                    break;
                }
                int re = nums[j] + nums[k] + ri;
                if (re == 0) {
                    // 满足解 保存结果
                    newList(ri, nums[j], nums[k], result);
                    // 如果当前数和前一个一样 则直接跳过，因为已经匹配过
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    // 如果当前数和前一个一样 则直接跳过，因为已经匹配过
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    j++;
                    k--;
                } else if (re > 0) {
                    // 如果和大于0 则把k向左移动，减小值，如果值一样也直接跳过
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    k--;
                } else {
                    // 如果和小于0 则把j向右移动，增大值，如果值一样也直接跳过
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
        int[] nu = {-2, 0, 0, 2, 2};
        System.out.println(new Solution().threeSum(nu));
    }
}

package cn.cloud.test.leetcode.a4;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author liangqiang
 * @date 2019/4/25 1:39 PM
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        boolean isEven = size % 2 == 0;
        int maxIndex = (size / 2) + 1;
        int[] mergeArray = merge(nums1, nums2, maxIndex - 1);
        if (isEven) {
            return ((double)mergeArray[mergeArray.length - 1] + (double)mergeArray[mergeArray.length - 2]) / 2;
        }
        return ((double)mergeArray[mergeArray.length - 1]);
    }

    private int[] merge(int[] nums1, int[] nums2, int maxIndex) {
        int[] mergeArray = new int[maxIndex + 1];
        merge(nums1, 0, nums2, 0, mergeArray, 0, maxIndex);
        return mergeArray;
    }

    private void merge(int[] nums1, int left, int[] nums2, int right, int[] result, int writeIndex, int maxIndex) {
        if (writeIndex - 1 == maxIndex) {
            return;
        }
        int leftVal = left >= nums1.length ? Integer.MAX_VALUE : nums1[left];
        int rightVal = right >= nums2.length ? Integer.MAX_VALUE : nums2[right];
        if (leftVal < rightVal) {
            result[writeIndex] = leftVal;
            merge(nums1, left + 1, nums2, right, result, writeIndex + 1, maxIndex);
        } else {
            result[writeIndex] = rightVal;
            merge(nums1, left, nums2, right + 1, result, writeIndex + 1, maxIndex);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

}

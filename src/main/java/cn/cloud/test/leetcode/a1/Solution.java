package cn.cloud.test.leetcode.a1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author liangqiang
 * @date 2019/4/25 11:16 AM
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        boolean find = false;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            List<Integer> list = map.getOrDefault(temp, new ArrayList<>());
            list.add(i);
            map.put(temp, list);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int sub = target - entry.getKey();
            indexes[0] = entry.getValue().get(0);
            if (map.containsKey(sub)) {
                if (sub == entry.getKey()) {
                    if (map.get(sub).size() <= 1) {
                        continue;
                    }
                    indexes[1] = map.get(sub).get(1);
                } else {
                    indexes[1] = map.get(sub).get(0);
                }
                find = true;
                break;
            }
        }
        if (find) {
            return indexes;
        }
        System.out.println("can't find!");
        return null;
    }

    public static void main(String[] args) {
        int[] i = {3, 3};
        int[] result = new Solution().twoSum(i, 6);
        for (int i1 : result) {
            System.out.println(i1);
        }
    }

}

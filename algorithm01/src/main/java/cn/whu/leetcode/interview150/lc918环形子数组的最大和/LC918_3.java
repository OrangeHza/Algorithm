package cn.whu.leetcode.interview150.lc918环形子数组的最大和;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.Arrays;

public class LC918_3 extends Solution {

    // 两轮最大连续子数组和 试一下
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = 0;
        int min = 0;
        int sum = 0;
        int maxA = nums[0], minA = nums[0];//全局最大和最小连续值
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], nums[i] + max);
            maxA = Math.max(maxA, max);
            min = Math.min(nums[i], nums[i] + min);
            minA = Math.min(minA, min);
            sum += nums[i];
        }
        return sum == minA ? maxA : Math.max(maxA, sum - minA);
    }

    public static void main(String[] args) {
        test("[1,-2,3,-2]");
        test("[5,-3,5]");
        test("[3,-2,2,-3]");
        test("[-3,-2,-3]");
        test("[-5,-2,5,6,-2,-7,0,2,8]");
    }

    private static void test(String strs) {
        int[] nums = HzaUtils.string2Ints(strs);
        LC918_3 t = new LC918_3();
        int ans = t.maxSubarraySumCircular(nums);
        print(ans);
    }

}

package cn.whu.leetcode.interview150.lc918环形子数组的最大和;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.Arrays;

public class LC918_2 extends Solution {

    // 两轮最大连续子数组和 试一下
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        int ans = nums[0];
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            if(i==0){
                dpMax[i] = nums[i];
                dpMin[i] = nums[i];
            }else {
                dpMax[i] = Math.max(nums[i],dpMax[i-1]+nums[i]);
                dpMin[i] = Math.min(nums[i],dpMin[i-1]+nums[i]);
                ans = Math.max(ans,dpMax[i]);
                if(sum!=dpMin[i]) ans = Math.max(ans,sum-dpMin[i]);
            }
        }
        return ans;
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
        LC918_2 t = new LC918_2();
        int ans = t.maxSubarraySumCircular(nums);
        print(ans);
    }

}

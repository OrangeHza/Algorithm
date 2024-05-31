package cn.whu.leetcode.interview150.lc918环形子数组的最大和;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

public class LC918 extends Solution {

    // 两轮最大连续子数组和 试一下
    public int maxSubarraySumCircular(int[] nums) {
        int begin = 0;
        int[] dp = new int[nums.length];
        int ans = nums[0];
        for (int i = 0; i < nums.length * 2; i++) {
            if (i == 0) dp[0] = nums[0];
            else {
                int k = (i + nums.length) % nums.length;
                int pre = (i - 1 + nums.length) % nums.length; // 上一个
                if (k == begin) {
                    begin++; // 前面收缩一下，多几种情况，可能会更好 // 头作尾，大小不变
                    while (begin < nums.length && nums[begin] <= 0) {
                        dp[pre] -= nums[begin];//这种情况会增大
                        begin++;
                    }
                    dp[k] = dp[pre];//头做尾，大小不变
                    ans = Math.max(ans,dp[k]);
                    continue;

                }
                if (dp[pre] > 0) {
                    dp[k] = dp[pre] + nums[k];
                } else {
                    dp[k] = nums[k];
                    begin = k;
                }
                ans = Math.max(ans, dp[k]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //test("[1,-2,3,-2]");
        //test("[5,-3,5]");
        //test("[3,-2,2,-3]");
        test("[-5,-2,5,6,-2,-7,0,2,8]");
    }

    private static void test(String strs) {
        int[] nums = HzaUtils.string2Ints(strs);
        LC918 t = new LC918();
        int ans = t.maxSubarraySumCircular(nums);
        print(ans);
    }

}

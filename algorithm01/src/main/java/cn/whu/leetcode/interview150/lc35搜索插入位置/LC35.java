package cn.whu.leetcode.interview150.lc35搜索插入位置;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

public class LC35 extends Solution {

    // 二分找数值
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length;
        // 左闭右开的形式写二分，特别简单
        while (l<r){
            int mid = (l+r)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) r=mid;
            else l = mid+1;
        }
        return r;
    }

    public static void main(String[] args) {
        test("[1,3,5,6]", 5);
        test("[1,3,5,6]", 2);
        test("[1,3,5,6]", 7);

    }

    private static void test(String strs, int target) {
        int[] nums = HzaUtils.string2Ints(strs);
        LC35 t = new LC35();
        int ans = t.searchInsert(nums, target);
        print(ans);
    }


}

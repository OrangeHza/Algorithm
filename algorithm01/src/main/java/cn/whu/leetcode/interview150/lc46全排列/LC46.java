package cn.whu.leetcode.interview150.lc46全排列;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.*;

public class LC46 extends Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new HashSet<Integer>(), ans);
        return ans;
    }

    public void dfs(int[] nums, List<Integer> curt, Set<Integer> visited, List<List<Integer>> ans) {
        if (curt.size() == nums.length) {
            ans.add(new ArrayList<>(curt));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                visited.add(nums[i]);
                curt.add(nums[i]);
                dfs(nums, curt, visited, ans);
                curt.remove(curt.size() - 1);
                visited.remove(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        test("[1,2,3]");

    }

    private static void test(String strs) {
        int[] nums = HzaUtils.string2Ints(strs);
        LC46 t = new LC46();
        List<List<Integer>> ans = t.permute(nums);
        print2(ans);
    }

}

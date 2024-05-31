package cn.whu.leetcode.interview150.lc108将有序数组转换为二叉搜索树;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.TreeNode;

public class LC108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length);
    }

    public TreeNode dfs(int[] nums,int l,int r){//[l,r) 通通左闭右开
        if(l==r) return null; // ★ 左闭右开的终止条件
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,l,mid);
        root.right = dfs(nums,mid+1,r);
        return root;
    }


    public static void main(String[] args) {
        test("[-10,-3,0,5,9]");
        test("[1,3]");
    }

    private static void test(String strs) {
        int[] nums = HzaUtils.string2Ints(strs);
        LC108 t = new LC108();
        TreeNode ans = t.sortedArrayToBST(nums);
        ans.show();
    }

}

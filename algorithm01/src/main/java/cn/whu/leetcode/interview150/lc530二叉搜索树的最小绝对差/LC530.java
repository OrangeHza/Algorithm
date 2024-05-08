package cn.whu.leetcode.interview150.lc530二叉搜索树的最小绝对差;

import cn.whu.utils.Solution;
import cn.whu.utils.TreeNode;

public class LC530 extends Solution {

    // 应该维护的是全局最低，所以还得是全局变量
    int ans = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return ans;
        getMinimumDifference(root.left);
        ans = Math.min(ans, Math.abs(root.val - pre));
        pre = root.val;
        getMinimumDifference(root.right);
        return ans;
    }

    public static void main(String[] args) {

        test("[4,2,6,1,3]");
        test("[1,0,48,null,null,12,49]");
        test("[236,104,701,null,227,null,911]");

    }

    private static void test(String strs) {
        LC530 t = new LC530();
        TreeNode root = TreeNode.create(strs);
        int ans = t.getMinimumDifference(root);
        print(ans);
    }

}

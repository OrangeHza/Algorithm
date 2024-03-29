package cn.whu.leetcode.interview150.lc530二叉搜索树的最小绝对差;

import cn.whu.utils.Solution;
import cn.whu.utils.TreeNode;

public class LC530_2 extends Solution {

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return ans;
    }

    // 应该维护的是全局最低，所以还得是全局变量
    int ans = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;
    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        ans = Math.min(ans, Math.abs(root.val - pre));
        //System.out.print(pre + "-" + root.val + "\t");
        pre = root.val;
        inOrder(root.right);
    }


    public static void main(String[] args) {
        test("[4,2,6,1,3]");
        test("[1,0,48,null,null,12,49]");
        test("[236,104,701,null,227,null,911]");

    }

    private static void test(String strs) {
        LC530_2 t = new LC530_2();
        TreeNode root = TreeNode.create(strs);
        int ans = t.getMinimumDifference(root);
        print(ans);
    }

}

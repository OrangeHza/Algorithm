package cn.whu.leetcode.interview150.lc230二叉搜索树中第K小的元素;

import cn.whu.utils.Solution;
import cn.whu.utils.TreeNode;

public class LC230 extends Solution {

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return ans;
    }

    int ans = -1;
    int k = -1;
    public void inOrder(TreeNode root) {
        if (root == null || ans != -1) return;
        kthSmallest(root.left, k);
        // 中序第k个
        k--;
        if (k == 0) {
            ans = root.val;
            return;
        }
        //System.out.print(k + ":" + root.val+" ");
        kthSmallest(root.right, k);
    }


    public static void main(String[] args) {
        test("[5,3,6,2,4,null,null,1]", 3);

    }

    private static void test(String strs, int k) {
        TreeNode root = TreeNode.create(strs);
        LC230 t = new LC230();
        int ans = t.kthSmallest(root, k);
        print(ans);
    }

}

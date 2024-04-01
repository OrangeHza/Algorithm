package cn.whu.leetcode.interview150.lc106从中序与后序遍历序列构造二叉树;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;
import cn.whu.utils.TreeNode;

public class LC106 extends Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return null;
    }

    public static void main(String[] args) {

        test("[9,3,15,20,7]", "[9,15,7,20,3]");

    }

    private static void test(String strs, String strs1) {
        int[] inorder = HzaUtils.string2Ints(strs);
        int[] postorder = HzaUtils.string2Ints(strs1);

        LC106 t = new LC106();
        TreeNode ans = t.buildTree(inorder, postorder);
        if (ans == null) print("null");
        else ans.llevelOrder();
    }


}

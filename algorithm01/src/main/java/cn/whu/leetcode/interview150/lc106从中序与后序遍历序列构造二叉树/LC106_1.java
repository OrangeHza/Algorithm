package cn.whu.leetcode.interview150.lc106从中序与后序遍历序列构造二叉树;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;
import cn.whu.utils.TreeNode;

public class LC106_1 extends Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode createTree(int[] inorder, int x1, int x2, int[] postorder, int y1, int y2) {
        //if (x1 == x2) return new TreeNode(inorder[x1]); // 单节点直接返回，这是出口 代码逻辑正确就不需要这个出口
        if (x1 > x2) return null;
        int val = postorder[y2];
        TreeNode root = new TreeNode(val);
        int k = x1;
        while (inorder[k] != val) k++;
        root.left = createTree(inorder, x1, k - 1, postorder, y1, y1 + (k - x1) - 1);
        root.right = createTree(inorder, k + 1, x2, postorder, y1 + (k - x1), y2 - 1);
        return root;
    }

    public static void main(String[] args) {
        test("[9,3,15,20,7]", "[9,15,7,20,3]");
        test("[2,1]", "[2,1]");
        test("[3,2,1]", "[3,2,1]");
    }

    private static void test(String strs, String strs1) {
        int[] inorder = HzaUtils.string2Ints(strs);
        int[] postorder = HzaUtils.string2Ints(strs1);

        LC106_1 t = new LC106_1();
        TreeNode ans = t.buildTree(inorder, postorder);
        if (ans == null) print("null");
        else ans.llevelOrder();
    }

}

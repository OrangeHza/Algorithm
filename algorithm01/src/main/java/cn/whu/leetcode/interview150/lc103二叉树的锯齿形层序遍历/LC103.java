package cn.whu.leetcode.interview150.lc103二叉树的锯齿形层序遍历;

import cn.whu.utils.Solution;
import cn.whu.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC103 extends Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.push(root);
        boolean reverse = false;
        while (!q.isEmpty()) {
            int T = q.size();
            // 一层全出完
            ArrayList<Integer> level = new ArrayList<>();
            while (T-- > 0) {
                TreeNode top = q.poll();
                level.add(top.val);
                if (top.left != null) {
                    q.offer(top.left); // 这里top.left不是这一层的，不能加进level
                }
                if (top.right != null) {
                    q.offer(top.right);
                }
            }
            // 注意，一层遍历完了，再add
            if (reverse) Collections.reverse(level);
            ans.add(level);
            reverse = !reverse;
            //print(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        test("[3,9,20,null,null,15,7]");

    }

    private static void test(String strs) {
        TreeNode root = TreeNode.create(strs);
        LC103 t = new LC103();
        List<List<Integer>> ans = t.zigzagLevelOrder(root);
        System.out.println(ans);
    }

}

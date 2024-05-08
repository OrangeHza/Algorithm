package cn.whu.leetcode.interview150;

import cn.whu.utils.Solution;
import cn.whu.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC637 extends Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> ans = new ArrayList<>();
        if (root == null) return ans;

        // 就是层序遍历
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            // 一次遍历一层
            long sum = 0;
            for(int i=0;i<size;i++){
                TreeNode top = q.poll();
                sum += top.val;
                if(top.left!=null) q.offer(top.left);
                if(top.right!=null) q.offer(top.right);
            }
            ans.add(sum*1.0/size);
        }
        return ans;

    }

    public static void main(String[] args) {

        //root = [3,9,20,null,null,15,7]
        test("[3,9,20,null,null,15,7]");
        test("[3,9,20,15,7]");
        test("[2147483647,2147483647,2147483647]");

    }

    private static void test(String strs) {
        TreeNode root = TreeNode.create(strs);
        LC637 t = new LC637();
        List<Double> ans = t.averageOfLevels(root);
        print(ans);
    }

}

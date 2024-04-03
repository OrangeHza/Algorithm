package cn.whu.leetcode.interview150.lc117填充每个节点的下一个右侧节点指针2;

import cn.whu.utils.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class LC117 extends Solution {

    public Node connect(Node root) {
        if (root == null) return null;
        // 层序遍历
        Deque<Node> q = new LinkedList<>();
        q.push(root);
        // 一层一层地处理
        while (!q.isEmpty()) {
            int T = q.size();
            Node pre = null;
            while (T-- > 0) {
                Node curt = q.poll();
                if (curt.left != null) q.offer(curt.left);
                if (curt.right != null) q.offer(curt.right);
                if (pre != null) pre.next = curt;
                pre = curt;
            }
            pre.next = null;
        }
        return root;
    }

    public static void main(String[] args) {
        //test("[1,2,3,4,5,null,7]");
        test("[]");
    }

    private static void test(String strs) {
        Node root = (Node) Node.create(strs);
        LC117 t = new LC117();
        Node ans = t.connect(root);
        if (ans == null) print("null");
        else ans.llevelOrder(); // 先不管输出了
    }

}

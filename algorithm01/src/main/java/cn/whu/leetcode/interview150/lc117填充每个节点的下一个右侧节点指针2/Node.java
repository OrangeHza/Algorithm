package cn.whu.leetcode.interview150.lc117填充每个节点的下一个右侧节点指针2;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static Node newNode(Integer val) {
        if (val == null) return null;
        else return new Node(val);
    }


    // 层序创建二叉树
    public static Node create(Integer[] vals) {
        if (vals == null || vals.length == 0 || vals[0] == null) return null;
        Queue<Node> q = new LinkedList<>();
        int k = 0;
        Node root = new Node(vals[k++]);
        q.offer(root);
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (k < vals.length) {
                top.left = newNode(vals[k++]);
                if (top.left != null) q.offer(top.left);
            }
            if (k < vals.length) {
                top.right = newNode(vals[k++]);
                if (top.right != null) q.offer(top.right);
            }
        }
        return root;
    }

    // 层序创建二叉树  参数为String ',' 隔开  (#,null) 等任意非法字符串都可以表示null
    public static Node create(String strs) {
        if (strs == null || strs.trim().length() == 0) return null;

        String rep = "{[]}";
        for (int i = 0; i < rep.length(); i++) {
            strs = strs.replace("" + rep.charAt(i), "");
        }

        String[] split = strs.split(",");
        Integer[] vals = new Integer[split.length];

        for (int i = 0; i < split.length; i++) {
            try {
                Integer val = Integer.parseInt(split[i].trim());
                vals[i] = val;
            } catch (Exception e) {
                vals[i] = null;
            }
        }
        return create(vals);
    }


    public void preOrder() {
        System.out.print(this.val + " ");
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
    }

    public void lpreOrder() {
        System.out.print("先序: ");
        this.preOrder();
        System.out.println();
    }

    public void inOrder() {
        if (this.left != null) this.left.inOrder();
        System.out.print(this.val + " ");
        if (this.right != null) this.right.inOrder();
    }

    public void linOrder() {
        System.out.print("中序: ");
        this.inOrder();
        System.out.println();
    }

    public void afterOrder() {
        if (this.left != null) this.left.afterOrder();
        if (this.right != null) this.right.afterOrder();
        System.out.print(this.val + " ");
    }

    public void lafterOrder() {
        System.out.print("后序: ");
        this.afterOrder();
        System.out.println();
    }

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.offer(this);
        while (!q.isEmpty()) {
            Node top = q.poll();
            System.out.print(top.val + " ");
            if (top.left != null) q.offer(top.left);
            if (top.right != null) q.offer(top.right);
        }
    }

    public void llevelOrder() {
        System.out.print("层序: ");
        this.levelOrder();
        System.out.println();
    }

    public void show() {
        this.lpreOrder();
        this.linOrder();
        this.lafterOrder();
        this.llevelOrder();
    }

    public static void main(String[] args) {
        Node root;

        Integer[] vals = {1, null, 2, 3};
        root = Node.create(vals);
        root.show();

        System.out.println("---------------------");
        root = Node.create("1, null, 2, 3");
        root.show();

    }

}




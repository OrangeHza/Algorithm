package cn.whu.leetcode.interview150.lc427建立四叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.offer(this);

        System.out.print("[");
        while (!q.isEmpty()) {
            Node top = q.poll();
            System.out.print(top);
            if(top.isLeaf) continue;//很重要
            if (top.topLeft != null) q.offer(top.topLeft);//一定记住是top.
            if (top.topRight != null) q.offer(top.topRight);
            if (top.bottomLeft != null) q.offer(top.bottomLeft);
            if (top.bottomRight != null) q.offer(top.bottomRight);
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        int leaf = isLeaf ? 1 : 0;
        int value = val ? 1 : 0;
        if (!isLeaf) value = 1;
        return "[" + leaf + "," + value + ']';
    }

    public static void main(String[] args) {
        int n = 8;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("(%d,%d)\t", i, j);
            }
            System.out.println();
        }
    }
}

/*
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

*/
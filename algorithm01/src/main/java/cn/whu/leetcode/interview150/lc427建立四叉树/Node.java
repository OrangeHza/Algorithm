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
        q.add(this);

        System.out.print("[");
        while (!q.isEmpty()) {
            Node top = q.remove();
            System.out.print(top);
            if(top.topLeft!=null) q.add(topLeft);
            if(top.topRight!=null) q.add(topRight);
            if(top.bottomLeft!=null) q.add(bottomLeft);
            if(top.bottomRight!=null) q.add(bottomRight);
        }
        System.out.println("]");

    }

    @Override
    public String toString() {
        return "[" + val + "," + isLeaf + ']';
    }
}

/*
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

*/
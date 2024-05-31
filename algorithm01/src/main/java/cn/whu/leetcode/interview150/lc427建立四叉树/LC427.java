package cn.whu.leetcode.interview150.lc427建立四叉树;

import cn.whu.utils.HzaUtils;

public class LC427 {

    public Node construct(int[][] grid) {
        Node root = new Node(false, false);

        return root;
    }


    public static void main(String[] args) {
        String strs = "[[0,1],[1,0]]";
        int[][] grid = HzaUtils.string2IntegerArray2D(strs);
        LC427 t = new LC427();
        Node ans = t.construct(grid);

    }


}

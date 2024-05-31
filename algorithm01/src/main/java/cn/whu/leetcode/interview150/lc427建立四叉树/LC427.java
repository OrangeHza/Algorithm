package cn.whu.leetcode.interview150.lc427建立四叉树;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

public class LC427 extends Solution {

    public Node construct(int[][] grid) {
        if (grid.length == 1) return new Node(grid[0][0] == 1, true);
        return combine(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    public Node combine(int[][] grid, int x1, int y1, int x2, int y2) {//左闭右闭吧
        //prints(x1, y1, '\t', x2, y2);
        Node root = new Node(false, false);//默认不是叶子
        // 递归边界
        if (x2 - x1 == 1) {
            root.topLeft = new Node(grid[x1][y1] == 1, true);
            root.topRight = new Node(grid[x1][y2] == 1, true);
            root.bottomLeft = new Node(grid[x2][y1] == 1, true);
            root.bottomRight = new Node(grid[x2][y2] == 1, true);
        } else {
            int midX = (x1 + x2) / 2, midY = (y1 + y2) / 2;
            root.topLeft = combine(grid, x1, y1, midX, midY);
            root.topRight = combine(grid, x1, midY + 1, midX, y2);
            root.bottomLeft = combine(grid, midX + 1, y1, x2, midY);
            root.bottomRight = combine(grid, midX + 1, midY + 1, x2, y2);
        }

        // 判断是否合并
        if (root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomRight.isLeaf && root.bottomLeft.isLeaf) {
            boolean val = root.topLeft.val;
            if (root.topRight.val == val && root.bottomLeft.val == val && root.bottomRight.val == val) {
                root.val = val;
                root.isLeaf = true;
                // else里面也会有这种情况 所以置为null是不可避免的
                root.topLeft = null;
                root.topRight = null;
                root.bottomLeft = null;
                root.bottomRight = null;
            }
        }
        return root;
    }


    public static void main(String[] args) {


        //test("[[0,1],[1,0]]");
        test("[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]");
        test("[[0]]");

    }

    private static void test(String strs) {
        int[][] grid = HzaUtils.string2IntegerArray2D(strs);
        LC427 t = new LC427();
        Node ans = t.construct(grid);
        ans.levelOrder();
        System.out.println();

    }


}

package cn.whu.leetcode.interview150.lc427建立四叉树;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

public class LC427_1 extends Solution {

    public Node construct(int[][] grid) {
        return combine(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    public Node combine(int[][] grid, int x1, int y1, int x2, int y2) {//左闭右闭吧
        int v = grid[x1][y1];
        boolean same = true;
        loop:
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (v != grid[i][j]) {
                    same = false;
                    break loop;
                }
            }
        }
        if (same) return new Node(v==1, true);//其他直接默认是null
        int midX = (x1 + x2) / 2, midY = (y1 + y2) / 2;
        return new Node(true,false,
                combine(grid, x1, y1, midX, midY),
                combine(grid, x1, midY + 1, midX, y2),
                combine(grid, midX + 1, y1, x2, midY),
                combine(grid, midX + 1, midY + 1, x2, y2)
        );
    }


    public static void main(String[] args) {


        //test("[[0,1],[1,0]]");
        test("[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]");
        test("[[0]]");

    }

    private static void test(String strs) {
        int[][] grid = HzaUtils.string2IntegerArray2D(strs);
        LC427_1 t = new LC427_1();
        Node ans = t.construct(grid);
        ans.levelOrder();
        System.out.println();

    }


}

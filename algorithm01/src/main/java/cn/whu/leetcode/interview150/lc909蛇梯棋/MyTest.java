package cn.whu.leetcode.interview150.lc909蛇梯棋;

import cn.whu.utils.Solution;

public class MyTest extends Solution {

    public static void main(String[] args) {
        LC909 t = new LC909();
        t.n = 6;
        int n = 6;
        for (int i = 1; i <= n * n; i++) {
            int[] xy = t.getXY(i);
            System.out.printf("%d: (%d,%d)\n",i,xy[0],xy[1]);
        }
    }
}

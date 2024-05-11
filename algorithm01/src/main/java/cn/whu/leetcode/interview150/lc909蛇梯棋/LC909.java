package cn.whu.leetcode.interview150.lc909蛇梯棋;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LC909 extends Solution {


    public int snakesAndLadders(int[][] board) {
        this.n = board.length;

        Deque<Integer> q = new LinkedList<>();
        q.offer(1);

        int k = 0;
        HashSet<Integer> set = new HashSet<>();//如果队的就不要重复入了 反正只会更长
        set.add(1);
        while (!q.isEmpty()) {
            int size = q.size();
            k++;
            if (k > n * n / 6 + 1) return -1;//有可能到达不了
            for (int i = 0; i < size; i++) {
                int top = q.poll();
                // 下层6个子结点
                for (int j = top + 1; j <= top + 6; j++) {
                    int[] xy = getXY(j);
                    int x = xy[0], y = xy[1];
                    int next = board[x][y] == -1 ? j : board[x][y];
                    if (!set.contains(next)) {
                        set.add(next);
                        q.offer(next);
                        if (next == n * n) {
                            return k;
                        }
                    }

                }
            }
        }
        return -1;
    }

    int n; // 矩阵大小
    int[] getXY(int index) {
        int x = (n - 1) - (index - 1) / n;
        int y = -1;
        if ((index - 1) / n % 2 == 0) {//从左往右
            y = (index - 1) % n;
        } else { // 从右往左
            y = (n - 1) - (index - 1) % n;
        }
        return new int[]{x, y};
    }


    //private int getIndex(int x,int y);

    public static void main(String[] args) {
        //test("[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]");
        //test("[[-1,-1,-1],[-1,9,8],[-1,8,9]]");
        //test("[[1,1,-1],[1,1,1],[-1,1,1]]");
        test("[[-1,-1,-1,135,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,105,-1],[-1,-1,92,-1,-1,-1,-1,-1,-1,201,-1,118,-1,-1,183,-1],[-1,-1,-1,-1,-1,-1,-1,-1,-1,179,-1,-1,-1,-1,-1,-1],[-1,248,-1,-1,-1,-1,-1,-1,-1,119,-1,-1,-1,-1,-1,192],[-1,-1,104,-1,-1,-1,-1,-1,-1,-1,165,-1,-1,206,104,-1],[145,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,229,-1],[-1,-1,75,140,-1,-1,-1,-1,-1,-1,-1,-1,43,-1,34,-1],[-1,-1,-1,-1,-1,-1,169,-1,-1,-1,-1,-1,-1,188,-1,-1],[-1,-1,-1,-1,-1,-1,92,-1,171,-1,-1,-1,-1,-1,-1,66],[-1,-1,-1,126,-1,-1,68,-1,-1,-1,-1,-1,-1,-1,-1,-1],[-1,109,-1,86,28,228,-1,-1,144,-1,-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,59,-1,-1,-1,-1,-1,51,-1,-1,-1,62,-1],[-1,71,-1,-1,-1,63,-1,-1,-1,-1,-1,-1,212,-1,-1,-1],[-1,-1,-1,-1,174,-1,59,-1,-1,-1,-1,-1,-1,133,-1,-1],[-1,-1,62,-1,5,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1],[-1,-1,-1,59,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]]");
    }

    private static void test(String strs) {
        int[][] board = HzaUtils.string2IntegerArray2D(strs);
        print2(board);
        LC909 t = new LC909();
        int ans = t.snakesAndLadders(board);
        print(t.n, "\n\n");
        print(ans);
    }


}

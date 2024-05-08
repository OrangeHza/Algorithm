package cn.whu.leetcode.interview150.lc130被围绕的区域;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.ArrayList;

public class LC130 extends Solution {

    public void solve(char[][] board) {
        // 寻找'O'的连通分量
        this.M = board.length;
        this.N = board[0].length;
        this.board = board;
        this.visited = new boolean[M][N];

        for (int i = 1; i < M - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    fill.clear();
                    flag = true;
                    dfs(i,j);
                    if (flag) {
                        // 被包围，填充
                        for (int[] pos : fill) {
                            board[pos[0]][pos[1]] = 'X';
                        }
                    }
                }
            }
        }


    }

    int M, N;
    char[][] board;
    boolean[][] visited;
    ArrayList<int[]> fill = new ArrayList<>();
    boolean flag = true;

    boolean judge(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N && !visited[x][y] && board[x][y] == 'O';
    }


    void dfs(int x, int y) {
        if (x == 0 || x == M - 1 || y == 0 || y == N - 1) flag = false;
        visited[x][y] = true;
        fill.add(new int[]{x, y});

        boolean f1 = false, f2 = false, f3 = false, f4 = false;
        if (judge(x - 1, y)) dfs(x - 1, y);
        if (judge(x + 1, y)) dfs(x + 1, y);
        if (judge(x, y - 1)) dfs(x, y - 1);
        if (judge(x, y + 1)) dfs(x, y + 1);
        // 保证一次连通分量全部遍历到 全部标记到
    }


    public static void main(String[] args) {

        //test("[[X,X,X,X],[X,O,O,X],[X,X,O,X],[X,O,X,X]");
        //test("[[X]]");
        test("[[O,O,O,O,X,X],[O,O,O,O,O,O],[O,X,O,X,O,O],[O,X,O,O,X,O],[O,X,O,X,O,O],[O,X,O,O,O,O]]");

    }

    private static void test(String strs) {
        char[][] board = HzaUtils.string2CharArray2D(strs);
        print2(board);
        LC130 t = new LC130();
        t.solve(board);
        print2(board);
    }
}

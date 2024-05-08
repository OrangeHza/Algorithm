package cn.whu.leetcode.interview150.lc130被围绕的区域;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

public class LC130_ans extends Solution {

    public void solve(char[][] board) {
        // 寻找'O'的连通分量
        this.M = board.length;
        this.N = board[0].length;
        this.board = board;

        // 左边界和右边界
        for (int i = 0; i < M; i++) {
            if (board[i][0] == 'O') dfs(i, 0);
            if (board[i][N - 1] == 'O') dfs(i, N - 1);
        }

        // 上边界和下边界
        for (int j = 0; j < N; j++) {
            if (board[0][j] == 'O') dfs(0, j);
            if (board[M - 1][j] == 'O') dfs(M - 1, j);
        }

        // Z修改为O，O修改为X
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'Z') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }

    int M, N;
    char[][] board;

    boolean judge(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N && board[x][y] == 'O';
    }


    void dfs(int x, int y) {
        board[x][y] = 'Z'; // 临时修改为Z，不需要visited了
        if (judge(x - 1, y)) dfs(x - 1, y);
        if (judge(x + 1, y)) dfs(x + 1, y);
        if (judge(x, y - 1)) dfs(x, y - 1);
        if (judge(x, y + 1)) dfs(x, y + 1);
        // 保证一次连通分量全部遍历到 全部标记到
    }


    public static void main(String[] args) {

        test("[[X,X,X,X],[X,O,O,X],[X,X,O,X],[X,O,X,X]");
        test("[[X]]");
        //test("[[O,O,O,O,X,X],[O,O,O,O,O,O],[O,X,O,X,O,O],[O,X,O,O,X,O],[O,X,O,X,O,O],[O,X,O,O,O,O]]");

    }

    private static void test(String strs) {
        char[][] board = HzaUtils.string2CharArray2D(strs);
        print2(board);
        LC130_ans t = new LC130_ans();
        t.solve(board);
        print2(board);
    }
}

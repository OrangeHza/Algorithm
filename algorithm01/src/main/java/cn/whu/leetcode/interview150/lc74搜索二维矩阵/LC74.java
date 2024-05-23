package cn.whu.leetcode.interview150.lc74搜索二维矩阵;

public class LC74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = m - 1, y = 0;
        while (x >= 0 && y < n) {
            if (target == matrix[x][y]) return true;
            else if (target < matrix[x][y]) x--;
            else y++;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

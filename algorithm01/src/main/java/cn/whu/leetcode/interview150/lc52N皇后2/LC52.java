package cn.whu.leetcode.interview150.lc52N皇后2;

import cn.whu.utils.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC52 extends Solution {

    public int totalNQueens(int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>(); // 和相等 次对角线
        HashSet<Integer> set2 = new HashSet<>(); // 差相等 主对角线
        HashSet<Integer> set3 = new HashSet<>(); // 行或列不能相同
        dfs(n, 0, set1, set2, set3);
        return ans;
    }

    int ans = 0;

    public void dfs(int n, int k, Set<Integer> set1, Set<Integer> set2, Set<Integer> set3) {
        if (k == n) ans++;
        for (int i = 0; i < n; i++) {//(k,i)
            if (!set1.contains(k + i) && !set2.contains(k - i) && !set3.contains(i)) {
                set1.add(k + i);
                set2.add(k - i);
                set3.add(i);

                dfs(n, k + 1, set1, set2, set3);

                set1.remove(k + i);
                set2.remove(k - i);
                set3.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        test(4);
        test(1);

    }

    private static void test(int n) {
        LC52 t = new LC52();
        int ans = t.totalNQueens(n);
        print(ans);
    }
}

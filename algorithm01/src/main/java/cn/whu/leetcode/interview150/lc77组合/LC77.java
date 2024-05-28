package cn.whu.leetcode.interview150.lc77组合;

import cn.whu.utils.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC77 extends Solution {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, k, 1, new HashSet<Integer>(), ans);
        return ans;
    }

    public void dfs(int n, int k, int now, Set<Integer> set, List<List<Integer>> ans) {
        if (set.size() == k) {
            ans.add(new ArrayList<>(set));
            return;
        }
        for (int i = now; i <= n - (k - set.size()) + 1; i++) {//参数now防止重复   上届也有(set.size+(剩下来~n)至少得有k个吧 妙处在于set.size())
            if (!set.contains(i)) {
                set.add(i);
                dfs(n, k, i, set, ans);
                set.remove(i);
            }
        }
    }


    public static void main(String[] args) {
        test(4, 2);
        test(1, 1);
    }

    private static void test(int n, int k) {
        LC77 t = new LC77();
        List<List<Integer>> ans = t.combine(n, k);
        print2(ans);
    }
}

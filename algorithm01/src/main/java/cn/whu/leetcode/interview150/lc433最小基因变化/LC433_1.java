package cn.whu.leetcode.interview150.lc433最小基因变化;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashSet;

public class LC433_1 extends Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0;
        if (bank == null || bank.length == 0) return -1;
        if (!Arrays.asList(bank).contains(endGene)) return -1;
        visited.clear();
        int ans = dfs(startGene, endGene, bank, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    HashSet<String> visited = new HashSet<>();

    int dfs(String now, String end, String[] bank, int deep) {
        if (now.equals(end)) return deep;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < bank.length; i++) {
            if (isNext(bank[i], now) && !visited.contains(bank[i])) {
                visited.add(bank[i]);
                ans = Math.min(dfs(bank[i], end, bank, deep + 1), ans);
                visited.remove(bank[i]); // 回退
            }
        }
        return ans;
    }

    // 判断s1和s2的距离是否是1
    boolean isNext(String s1, String s2) {
        int k = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) k++;
            if (k > 1) break;
        }
        return k == 1;
    }

    public static void main(String[] args) {
        test("AACCGGTT", "AACCGGTA", "[AACCGGTA]");
        test("AACCGGTT", "AACCGGTA", "");
        test("AACCGGTT", "AAACGGTA", "[AACCGATT,AACCGATA,AAACGATA,AAACGGTA]");

    }

    private static void test(String start, String end, String bank_s) {
        String[] bank = HzaUtils.string2Strings(bank_s);
        LC433_1 t = new LC433_1();
        int ans = t.minMutation(start, end, bank);
        print(ans);
    }
}
